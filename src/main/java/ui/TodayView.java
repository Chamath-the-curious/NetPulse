package ui;

import domain.AdapterStat;
import domain.DailyStat;
import domain.DataAmount;
import logic.DataHandler;
import util.RecordReader;
import util.UnitConverter;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TodayView {

    private static final Logger logger = Logger.getLogger(TodayView.class.getName());

    public static void view() {

        Optional<DailyStat> recordedTodayStatOpt = RecordReader.read(LocalDate.now());

        if (recordedTodayStatOpt.isEmpty()) {
            logger.log(Level.WARNING, "No record found");
            logger.log(Level.INFO, "Try running \"record\" command first");
            return;
        }

        DailyStat stat = recordedTodayStatOpt.get();

        System.out.println("Today's data usage");
        for (AdapterStat adapterStat : stat.getAdapterStats()) {
            DataAmount dataAmountByAdapter = UnitConverter.convert(adapterStat.calculateTotalUsageByAdapter());
            System.out.println("\t" + adapterStat.getName() + "\t" + dataAmountByAdapter);
        }

        DataAmount dataAmountByTheDay = UnitConverter.convert(stat.calculateTotalUsageByTheDate());
        System.out.println("Total Usage\t\t" + dataAmountByTheDay);
    }
}
