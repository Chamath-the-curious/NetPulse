package cli;

import picocli.CommandLine.Command;
import util.ClearHistory;

@Command(name = "clear-history", description = "Clear data usage history")
public class ClearHistoryCommand implements Runnable {

    @Override
    public void run() {
        ClearHistory.clear();
    }
}
