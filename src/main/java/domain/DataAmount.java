package domain;

public class DataAmount {

    private final String metric;
    private final Double amount;

    public DataAmount(String metric, double amount) {
        this.metric = metric;
        this.amount = Math.round(amount * 100.0) / 100.0;
    }

    public String getMetric() {
        return metric;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount + " " + metric;
    }
}
