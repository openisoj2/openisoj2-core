package org.bitbucket.openisoj2.core;

public class Track2 {
    private String pan;
    private String expiry;
    private String discretionaryData;
    private String serviceRestrictionCode;
    private String track2;

    public Track2(String track2) {
        this.track2 = track2;
        parse();
    }

    public String getDiscretionaryData() {
        return discretionaryData;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getPan() {
        return pan;
    }

    public String getServiceRestrictionCode() {
        return serviceRestrictionCode;
    }

    private void parse() {
        char delim = '=';
        int firstDelim = track2.indexOf(delim);
        if (firstDelim < 0) {
            delim = 'D';
            firstDelim = track2.indexOf(delim);
        }
        if (firstDelim < 0)
            throw new IllegalArgumentException("Invalid track 2");

        pan = track2.substring(0, firstDelim).toLowerCase();
        if (pan.endsWith("f")) {
            pan = pan.substring(0, pan.length() - 1);
        }
        int secondDelim = track2.indexOf(delim, firstDelim + 1);
        int track2Length = track2.length();
        if (secondDelim < 0 && firstDelim + 1 == track2Length)
            return;

        int srcStart = firstDelim + 1;
        if (secondDelim != firstDelim + 1) {
            expiry = track2.substring(srcStart, srcStart + 4);
            srcStart += 4;
        } else {
            srcStart++;
        }

        int thirdDelim = track2.indexOf(delim, srcStart);
        int discretionaryStart = thirdDelim + 1;
        if (thirdDelim < 0) {
            if (srcStart >= track2Length)
                return;
            serviceRestrictionCode = track2.substring(srcStart, srcStart + 3);
            discretionaryStart = srcStart + 3;
        }

        if (discretionaryStart < track2Length)
            discretionaryData = track2.substring(discretionaryStart);
    }

    @Override
    public String toString() {
        return track2;
    }
}
