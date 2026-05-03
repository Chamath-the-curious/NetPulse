package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.JsonConfig;
import domain.DailyStat;
import config.Paths;

import java.io.File;

public class UsageRecorder {

    private static ObjectMapper mapper = JsonConfig.MAPPER;

    public static void record(DailyStat stat) {
        try {
            File file = new File(Paths.DATA_DIR, stat.getDate() + ".json");
            // create directory if it doesn't exist
            file.getParentFile().mkdirs();

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, stat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
