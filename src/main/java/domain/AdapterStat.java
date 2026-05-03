package domain;

public class AdapterStat {
    private String name;
    private long receivedBytes;
    private long sentBytes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getReceivedBytes() {
        return receivedBytes;
    }

    public void setReceivedBytes(long receivedBytes) {
        this.receivedBytes = receivedBytes;
    }

    public long getSentBytes() {
        return sentBytes;
    }

    public void setSentBytes(long sentBytes) {
        this.sentBytes = sentBytes;
    }

    @Override
    public String toString() {
        return "name: " + name + "\ntotal usage: " + ( sentBytes + receivedBytes) + "\n";
    }
}
