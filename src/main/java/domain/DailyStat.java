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

    @Override
    public String toString() {
        return "Date: " + date + "\n" + adapterStats.toString();
    }
}
