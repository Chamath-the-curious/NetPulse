import domain.DailyStat;
import logic.NetworkReader;
import logic.UsageRecorder;

public class App {
    public static void main(String[] args) {
        DailyStat stat = NetworkReader.readPerAdapter();
        System.out.println(stat);
        UsageRecorder.record(stat);
    }
}
