import domain.DailyStat;
import logic.NetworkReader;

public class App {
    public static void main(String[] args) {
        DailyStat stat = NetworkReader.readPerAdapter();
        System.out.println(stat);
    }
}
