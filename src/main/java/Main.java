
import cli.NetPulseCommand;
import logic.DataHandler;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        DataHandler dataHandler = new DataHandler();

        int exitCode = new CommandLine(new NetPulseCommand()).execute(args);

        try {
            logger.log(Level.INFO, "Running task at: " + LocalDate.now());
            dataHandler.execute();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Task failed", e);
        }

        System.exit(exitCode);
    }
}
