package cli;

import logic.DataHandler;
import picocli.CommandLine.Command;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

@Command(name = "record", description = "Record data usage")
public class RecordCommand implements Runnable {

    private static final Logger logger = Logger.getLogger(RecordCommand.class.getName());

    @Override
    public void run() {

        try {
            DataHandler.execute();
            logger.info("Data usage logged for: " + LocalDateTime.now());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: ", e);
        }
    }
}
