package org.bitbucket.openisoj2.core;

/**
 * Class that represents Track 1 data
 */
public class Track1 {
    private String pan;
    private String name;
    private String expiry;
    private String src;
    private String discretionaryData;
    private String track1;

    public Track1(String track1) {
        this.track1 = track1;
        parse();
    }

    public String getPan() {
        return pan;
    }

    public String getName() {
        return name;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getSrc() {
        return src;
    }

    public String getDiscretionaryData() {
        return discretionaryData;
    }

    private void parse() {
        // B1234567895343547^PETER/OXLEY JOHN ROBERT   ^1907101235725416835357357186210
        String data = track1.substring(1);
        String[] parts = data.split("\\^");
        this.pan = parts[0];
        this.name = parts[1];
        String rest = parts[2];
        this.expiry = rest.substring(0, 4);
        this.src = rest.substring(4, 7);
        this.discretionaryData = rest.substring(7);
    }

    @Override
    public String toString() {
        return track1;
    }
}
