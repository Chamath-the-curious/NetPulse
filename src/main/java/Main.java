
import cli.NetPulseCommand;
import logic.DataHandler;
import picocli.CommandLine;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        int exitCode = new CommandLine(new NetPulseCommand()).execute(args);
        System.exit(exitCode);
    }
}
