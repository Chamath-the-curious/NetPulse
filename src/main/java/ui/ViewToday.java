package ui;

import domain.AdapterStat;
import domain.DailyStat;
import domain.DataAmount;
import util.RecordReader;
import util.UnitConverter;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewToday {

    private static final Logger logger = Logger.getLogger(ViewToday.class.getName());

    public static void view() {

        Optional<DailyStat> recordedTodayStatOpt = RecordReader.read(LocalDate.now());

        if (recordedTodayStatOpt.isEmpty()) {
            logger.log(Level.WARNING, "No record found");
            logger.log(Level.INFO, "Try running \"record\" command first");
            return;
        }

        DailyStat stat = recordedTodayStatOpt.get();

        DataAmount dataAmount = UnitConverter.convert(stat.getAccumulatedBytes());
        System.out.println("    Today's data usage:\t" + dataAmount);
    }
}
