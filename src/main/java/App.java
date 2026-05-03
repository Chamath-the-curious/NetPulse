import domain.DailyStat;
import logic.DataHandler;
import util.NetworkReader;
import util.UsageRecorder;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App {

    private static final Logger logger = Logger.getLogger(UsageRecorder.class.getName());

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        DataHandler dataHandler = new DataHandler();

        Runnable task = () -> {
            logger.log(Level.INFO, "Running task at: " + java.time.LocalDate.now());

            dataHandler.execute();
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }
}
