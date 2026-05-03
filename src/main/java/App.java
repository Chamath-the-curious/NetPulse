import domain.DailyStat;
import logic.NetworkReader;
import logic.UsageRecorder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class App {
    public static void main(String[] args) {

        ScheduledExecutorService scheduer =
                Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Running task at: " + java.time.LocalDateTime.now());

            DailyStat stat = NetworkReader.readPerAdapter();
            UsageRecorder.record(stat);
        };

        scheduer.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }
}
