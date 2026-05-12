package cli;

import picocli.CommandLine.Command;
import ui.TodayView;

@Command(name = "today", description = "View usage today")
public class TodayCommand implements Runnable {

    @Override
    public void run() {
        TodayView.view();
    }
}
