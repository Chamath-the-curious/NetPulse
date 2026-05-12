package cli;

import picocli.CommandLine.Command;

@Command(
        name = "netpulse",
        subcommands = {
                RecordCommand.class,
                TodayCommand.class
        }
)
public class NetPulseCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Use a subcommand. Try --help");
    }
}
