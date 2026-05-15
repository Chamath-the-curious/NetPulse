package ui;

import config.Paths;
import domain.DailyStat;
import domain.DataAmount;
import util.RecordReader;
import util.UnitConverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAll {

    private static final Logger logger = Logger.getLogger(ViewAll.class.getName());

    public static void view() {

        File folder = new File(Paths.DATA_DIR);
        File[] files = folder.listFiles();

        if (files == null) {
            logger.log(Level.WARNING, "No records found");
            return;
        }

        List<DailyStat> records = new ArrayList<>();

        for (File file : files) {
            try {
                records.add(RecordReader.read(file));
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Something went wrong!");
            }
        }

        System.out.println("\tDaily Usage");
        for (DailyStat dailyStat : records) {
            DataAmount dataAmount = UnitConverter.convert(dailyStat.getAccumulatedBytes());
            System.out.println("    " + dailyStat.getDate().getMonth() + "-" + dailyStat.getDate().getDayOfMonth() + "\t" + dataAmount);
        }
    }
}
