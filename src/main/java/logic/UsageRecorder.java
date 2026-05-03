package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import util.JsonConfig;
import domain.DailyStat;
import util.Paths;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsageRecorder {

    private static ObjectMapper mapper = JsonConfig.MAPPER;
    private static final Logger logger = Logger.getLogger(UsageRecorder.class.getName());


    public static void record(DailyStat stat) {
        try {
            File file = new File(Paths.DATA_DIR, stat.getDate() + ".json");
            // create directory if it doesn't exist
            file.getParentFile().mkdirs();

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, stat);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO Exception: ", e);
        }
    }
}
