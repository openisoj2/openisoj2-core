package org.bitbucket.openisoj2.core;

public class AdditionalAmount {
    private String accountType;
    private String amountType;
    private String currencyCode;
    private String sign;
    private String amount;

    public AdditionalAmount() {
    }

    public AdditionalAmount(String value) throws Exception {
        if (value.length() != 20) {
            throw new Exception("Value incorrect length for argument value");
        }

        accountType = value.substring(0, 2);
        amountType = value.substring(2, 4);
        currencyCode = value.substring(4, 7);
        sign = value.substring(7, 8);
        amount = value.substring(8);

    }

    public String getAccountType() {
        return accountType;
    }

    public String getAmount() {
        return Utils.padLeft(amount, 12, '0');
    }

    public String getAmountType() {
        return amountType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getSign() {
        return sign;
    }

    public long getValue() {
        if (sign == null || amount == null) {
            return 0;
        }

        long amt = Long.parseLong(amount);
        if ("D".equals(sign)) {
            return -amt;
        }

        return amt;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAmount(String amount) {
        this.amount = Utils.padLeft(amount, 12, '0');
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setValue(long value) {
        sign = value < 0 ? "D" : "C";
        long amt = value < 0 ? -value : value;
        amount = Long.toString(amt);
    }

    @Override
    public String toString() {
        return getAccountType() + getAmountType() + getCurrencyCode() + getSign() + getAmount();
    }
}
