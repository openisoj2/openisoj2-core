package org.bitbucket.openisoj2.core;

import java.util.Hashtable;

public final class ActionCodeRspCodeMap {
    private static Hashtable<String, String> rspCodeMap = new Hashtable<String, String>();
    private static Hashtable<String, String> actionCodeMap = new Hashtable<String, String>();

    static {
        populateRspCodeMap();
        populateActionCodeMap();
    }

    private ActionCodeRspCodeMap() {
    }

    public static String getActionCode(String rspCode) {
        String actionCode = null;
        if (rspCode != null) {
            actionCode = actionCodeMap.get(rspCode);
            if (actionCode == null) {
                actionCode = "100";
            }
        }
        return actionCode;
    }

    public static String getResponseCode(String actionCode) {
        String rspCode = null;
        if (actionCode != null) {
            rspCode = rspCodeMap.get(actionCode);
            if (rspCode == null) {
                rspCode = "05";
            }
        }
        return rspCode;
    }

    protected static void populateRspCodeMap() {
        rspCodeMap.put("000", "00");
        rspCodeMap.put("001", "08");
        rspCodeMap.put("002", "10");
        rspCodeMap.put("003", "11");
        rspCodeMap.put("004", "16");
        rspCodeMap.put("100", "05");
        rspCodeMap.put("101", "54");
        rspCodeMap.put("102", "59");
        rspCodeMap.put("103", "60");
        rspCodeMap.put("104", "62");
        rspCodeMap.put("105", "66");
        rspCodeMap.put("106", "75");
        rspCodeMap.put("107", "01");
        rspCodeMap.put("108", "02");
        rspCodeMap.put("109", "03");
        rspCodeMap.put("110", "13");
        rspCodeMap.put("111", "14");
        rspCodeMap.put("113", "23");
        rspCodeMap.put("114", "42");
        rspCodeMap.put("115", "40");
        rspCodeMap.put("116", "51");
        rspCodeMap.put("117", "55");
        rspCodeMap.put("118", "56");
        rspCodeMap.put("119", "57");
        rspCodeMap.put("120", "58");
        rspCodeMap.put("121", "61");
        rspCodeMap.put("122", "63");
        rspCodeMap.put("123", "65");
        rspCodeMap.put("124", "93");
        rspCodeMap.put("200", "04");
        rspCodeMap.put("201", "33");
        rspCodeMap.put("202", "34");
        rspCodeMap.put("203", "35");
        rspCodeMap.put("204", "36");
        rspCodeMap.put("205", "37");
        rspCodeMap.put("206", "38");
        rspCodeMap.put("207", "07");
        rspCodeMap.put("208", "41");
        rspCodeMap.put("209", "43");
        rspCodeMap.put("301", "24");
        rspCodeMap.put("302", "25");
        rspCodeMap.put("304", "27");
        rspCodeMap.put("305", "28");
        rspCodeMap.put("306", "29");
        rspCodeMap.put("308", "26");
        rspCodeMap.put("902", "12");
        rspCodeMap.put("903", "19");
        rspCodeMap.put("904", "30");
        rspCodeMap.put("905", "31");
        rspCodeMap.put("906", "90");
        rspCodeMap.put("907", "91");
        rspCodeMap.put("908", "92");
        rspCodeMap.put("909", "96");
        rspCodeMap.put("911", "68");
        rspCodeMap.put("913", "94");
        rspCodeMap.put("915", "95");
        rspCodeMap.put("921", "21");
        rspCodeMap.put("923", "09");
    }

    protected static void populateActionCodeMap() {
        actionCodeMap.put("00", "000");
        actionCodeMap.put("01", "107");
        actionCodeMap.put("02", "108");
        actionCodeMap.put("03", "109");
        actionCodeMap.put("04", "200");
        actionCodeMap.put("06", "913");
        actionCodeMap.put("07", "207");
        actionCodeMap.put("08", "001");
        actionCodeMap.put("09", "923");
        actionCodeMap.put("10", "002");
        actionCodeMap.put("11", "003");
        actionCodeMap.put("12", "902");
        actionCodeMap.put("13", "110");
        actionCodeMap.put("14", "111");
        actionCodeMap.put("15", "908");
        actionCodeMap.put("16", "004");
        actionCodeMap.put("19", "903");
        actionCodeMap.put("21", "921");
        actionCodeMap.put("22", "909");
        actionCodeMap.put("23", "113");
        actionCodeMap.put("24", "301");
        actionCodeMap.put("25", "302");
        actionCodeMap.put("26", "308");
        actionCodeMap.put("27", "304");
        actionCodeMap.put("28", "305");
        actionCodeMap.put("29", "306");
        actionCodeMap.put("30", "904");
        actionCodeMap.put("31", "905");
        actionCodeMap.put("33", "201");
        actionCodeMap.put("34", "202");
        actionCodeMap.put("35", "203");
        actionCodeMap.put("36", "204");
        actionCodeMap.put("37", "205");
        actionCodeMap.put("38", "206");
        actionCodeMap.put("39", "114");
        actionCodeMap.put("40", "115");
        actionCodeMap.put("41", "208");
        actionCodeMap.put("42", "114");
        actionCodeMap.put("43", "209");
        actionCodeMap.put("44", "114");
        actionCodeMap.put("51", "116");
        actionCodeMap.put("52", "114");
        actionCodeMap.put("53", "114");
        actionCodeMap.put("54", "101");
        actionCodeMap.put("55", "117");
        actionCodeMap.put("56", "118");
        actionCodeMap.put("57", "119");
        actionCodeMap.put("58", "120");
        actionCodeMap.put("59", "102");
        actionCodeMap.put("60", "103");
        actionCodeMap.put("61", "121");
        actionCodeMap.put("62", "104");
        actionCodeMap.put("63", "122");
        actionCodeMap.put("64", "110");
        actionCodeMap.put("65", "123");
        actionCodeMap.put("66", "105");
        actionCodeMap.put("67", "200");
        actionCodeMap.put("68", "911");
        actionCodeMap.put("75", "106");
        actionCodeMap.put("77", "103");
        actionCodeMap.put("78", "103");
        actionCodeMap.put("90", "906");
        actionCodeMap.put("91", "907");
        actionCodeMap.put("92", "908");
        actionCodeMap.put("93", "124");
        actionCodeMap.put("94", "913");
        actionCodeMap.put("95", "915");
        actionCodeMap.put("96", "909");
        actionCodeMap.put("98", "121");
    }
}
