package org.bitbucket.openisoj2.core.pinblock;

import org.bitbucket.openisoj2.core.Utils;
import org.bitbucket.openisoj2.core.formatter.Formatters;

public class Iso0 {
	/**
	 * This method extracts the 12 right-most digits of the account number, execluding the check digit.
	 * 
	 * @param accountNumber
	 *            (PAN) consists of the BIN (Bank Identification Number), accountNumber and a check digit.
	 * @return the 12 right-most digits of the account number, execluding the check digit.
	 */
	public static String extractAccountNumberPart(String accountNumber) {
		String accountNumberPart = null;
		if (accountNumber.length() > 12)
			accountNumberPart = accountNumber.substring(accountNumber.length() - 13, accountNumber.length() - 1);
		else
			accountNumberPart = accountNumber;
		return accountNumberPart;
	}

	public byte[] createPinBlock(String pan, String pin) throws Exception {
		String acct = extractAccountNumberPart(pan);
		String pinData = Utils.padLeft("" + pin.length(), 2, '0') + pin;
		pinData = Utils.padRight(pinData, 16, 'F');
		byte[] bPin = Formatters.getBinary().getBytes(pinData);
		String acctData = Utils.padLeft(acct, 16, '0');
		byte[] bAcct = Formatters.getBinary().getBytes(acctData);

		byte[] pinblock = new byte[8];
		for (int i = 0; i < 8; i++)
			pinblock[i] = (byte) (bPin[i] ^ bAcct[i]);

		return pinblock;
	}
}
