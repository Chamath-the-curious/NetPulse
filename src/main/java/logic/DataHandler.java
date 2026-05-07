package logic;

import domain.DailyStat;
import util.NetworkReader;
import util.RecordReader;
import util.UsageRecorder;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Since Get-NetAdapterStatistics resets at every shutdown we need to handle it
 */

public class DataHandler  {

    private static final Logger logger = Logger.getLogger(DataHandler.class.getName());

    public static void execute() {
        Optional<DailyStat> statToBeRecordedOpt = NetworkReader.readPerAdapter();
        Optional<DailyStat> recordedTodayStatOpt = RecordReader.read(LocalDate.now());

        if (statToBeRecordedOpt.isEmpty()) {
            logger.log(Level.SEVERE, "statToBeRecorded is empty!");
            return;
        }

        DailyStat statToBeRecorded = statToBeRecordedOpt.get();

        // record new usage only if it is higher than recorded usage
        recordedTodayStatOpt.ifPresentOrElse(
                recordedTodayStat -> {
                    long newUsage = statToBeRecorded.calculateTotalUsageByTheDate();
                    long existingUsage = recordedTodayStat.calculateTotalUsageByTheDate();

                    if (newUsage > existingUsage) {
                        UsageRecorder.record(statToBeRecorded);
                    }
                },
                () -> {
                    // no existing record
                    UsageRecorder.record(statToBeRecorded);
                }
        );
    }
}
