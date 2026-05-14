package cli;

import picocli.CommandLine.Command;
import ui.ViewAll;

@Command(name = "daily-usage", description = "View all recorded daily usages")
public class DailyUsageCommand implements Runnable {

    @Override
    public void run() {
        ViewAll.view();
    }
}
