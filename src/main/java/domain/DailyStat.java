package domain;

import java.time.LocalDate;
import java.util.List;

public class DailyStat {
    private LocalDate date;
    private List<AdapterStat> adapterStats;

    public DailyStat(List<AdapterStat> adapterStats) {
        date = LocalDate.now();
        this.adapterStats = adapterStats;
    }

    public List<AdapterStat> getAdapterStats() {
        return adapterStats;
    }

    public void setAdapterStats(List<AdapterStat> adapterStats) {
        this.adapterStats = adapterStats;
    }

    public LocalDate getDate() {
        return date;
    }

    public long calculateTotalUsageByTheDate() {
        return adapterStats.stream()
                .map(AdapterStat::calculateTotalUsageByAdapter)
                .mapToLong(Long::longValue)
                .sum();
    }

    @Override
    public String toString() {
        return "Date: " + date + "\n" + adapterStats.toString();
    }
}
