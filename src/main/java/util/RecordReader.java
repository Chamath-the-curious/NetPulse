package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.DailyStat;
import config.JsonConfig;
import config.Paths;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecordReader {

    private static ObjectMapper mapper = JsonConfig.MAPPER;
    private static final Logger logger = Logger.getLogger(RecordReader.class.getName());

    public static Optional<DailyStat> read(LocalDate date) {
        File file = new File(Paths.DATA_DIR, date + ".json");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            return Optional.of(mapper.readValue(file, DailyStat.class));

        } catch (FileNotFoundException e) {
            return Optional.empty();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO Exception: ", e);
            return Optional.empty();

        }
    }

    public static DailyStat read(File file) {
        try {
            return mapper.readValue(file, DailyStat.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
