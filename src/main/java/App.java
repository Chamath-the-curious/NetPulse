import domain.DailyStat;
import logic.NetworkReader;
import logic.RecordReader;
import logic.UsageRecorder;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class App {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Running task at: " + java.time.LocalDateTime.now());

            Optional<DailyStat> statOptional = NetworkReader.readPerAdapter();
            statOptional.ifPresent(UsageRecorder::record);
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }
}
