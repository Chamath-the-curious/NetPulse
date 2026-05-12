package util;

import domain.DataAmount;

public class UnitConverter {

    public static double toMegaBytes(long bytes) {
        return (double) bytes / (1024.0 * 1024.0);
    }

    public static double toGigaBytes(long bytes) {
        return (double) bytes / (1024.0 * 1024.0 * 1024.0);
    }

    public static DataAmount convert(long totalUsageInBytes) {
        if (totalUsageInBytes >= 1e+9) {
            return new DataAmount("GB", toGigaBytes(totalUsageInBytes));
        } else if (totalUsageInBytes >= 1e+6) {
            return new DataAmount("MB", toMegaBytes(totalUsageInBytes));
        } else {
            return new DataAmount("Bytes", totalUsageInBytes);
        }
    }
}
