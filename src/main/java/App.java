
import cli.NetPulseCommand;
import logic.DataHandler;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App  {

    private static final Logger logger = Logger.getLogger(App.class.getName());

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
