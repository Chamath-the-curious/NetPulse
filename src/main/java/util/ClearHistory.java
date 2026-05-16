package util;

import config.Paths;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClearHistory {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(ClearHistory.class.getName());

    public static void clear() {
        System.out.print("Are you sure you want to permanently clear history? [y/n]: ");
        boolean confirmation = scanner.nextLine().equals("y");

        if (confirmation) {
            try {
                FileUtils.cleanDirectory(new File(Paths.DATA_DIR));
            } catch (IOException e) {
                logger.log(Level.SEVERE, "IO Exception: ", e);
            }
        }
    }
}
