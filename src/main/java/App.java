import domain.DailyStat;
import logic.NetworkReader;
import logic.RecordReader;
import logic.UsageRecorder;

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

        Runnable task = () -> {
            logger.log(Level.INFO, "Running task at: " + java.time.LocalDate.now());

            Optional<DailyStat> statOptional = NetworkReader.readPerAdapter();
            statOptional.ifPresent(UsageRecorder::record);
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }
}
