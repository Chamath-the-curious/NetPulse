package domain;

import java.time.LocalDate;

public class DailyStat {
    private LocalDate date;
    private long accumulatedBytes; // Persisted total usage
    private long lastRawValue; // Value from last check

    public DailyStat() {}

    public DailyStat(long lastRawValue) {
        this.lastRawValue = lastRawValue;
        date = LocalDate.now();
    }

    public void updateAccumulatedBytes(long delta) {
        accumulatedBytes += delta;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getAccumulatedBytes() {
        return accumulatedBytes;
    }

    public void setAccumulatedBytes(long accumulatedBytes) {
        this.accumulatedBytes = accumulatedBytes;
    }

    public long getLastRawValue() {
        return lastRawValue;
    }

    public void setLastRawValue(long lastRawValue) {
        this.lastRawValue = lastRawValue;
    }
}
