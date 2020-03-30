package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.exceptions.UnknownFieldException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;

public class Iso8583 extends AMessage implements IMessage {
	public class Bit {
		public static final int _002_PAN = 2;
		public static final int _003_PROC_CODE = 3;
		public static final int _004_TRAN_AMOUNT = 4;
		public static final int _005_SETTLE_AMOUNT = 5;
		public static final int _007_TRAN_DATE_TIME = 7;
		public static final int _009_CONVERSION_RATE_SETTLEMENT = 9;
		public static final int _045_TRACK_1_DATA = 45;
		public static final int _053_SECURITY_RELATED_CONTROL_INFORMATION = 53;
		public static final int _057_AUTHORISATION_LIFE_CYCLE = 57;
		public static final int _058_AUTHORISING_AGENT_INSTITUTION = 58;
		public static final int _011_SYS_TRACE_AUDIT_NUM = 11;
		public static final int _012_LOCAL_TRAN_TIME = 12;
		public static final int _013_LOCAL_TRAN_DATE = 13;
		public static final int _014_EXPIRATION_DATE = 14;
		public static final int _015_SELLTLEMENT_DATE = 15;
		public static final int _016_CONVERSION_DATE = 16;
		public static final int _018_MERCHANT_TYPE = 18;
		public static final int _022_POS_ENTRY_MODE = 22;
		public static final int _023_CARD_SEQUENCE_NUM = 23;
		public static final int _025_POS_CONDITION_CODE = 25;
		public static final int _026_POS_PIN_CAPTURE_CODE = 26;
		public static final int _027_AUTH_ID_RSP = 27;
		public static final int _028_TRAN_FEE_AMOUNT = 28;
		public static final int _029_SETTLEMENT_FEE_AMOUNT = 29;
		public static final int _030_TRAN_PROC_FEE_AMOUNT = 30;
		public static final int _031_SETTLEMENT_PROC_FEE_AMOUNT = 31;
		public static final int _032_ACQUIRING_INST_ID_CODE = 32;
		public static final int _033_FORWARDING_INT_ID_CODE = 33;
		public static final int _035_TRACK_2_DATA = 35;
		public static final int _037_RETRIEVAL_REF_NUM = 37;
		public static final int _038_AUTH_ID_RESPONSE = 38;
		public static final int _039_RESPONSE_CODE = 39;
		public static final int _040_SERVICE_RESTRICTION_CODE = 40;
		public static final int _041_CARD_ACCEPTOR_TERMINAL_ID = 41;
		public static final int _042_CARD_ACCEPTOR_ID_CODE = 42;
		public static final int _043_CARD_ACCEPTOR_NAME_LOCATION = 43;
		public static final int _044_ADDITIONAL_RESPONSE_DATA = 44;
		public static final int _048_ADDITIONAL_DATA = 48;
		public static final int _049_TRAN_CURRENCY_CODE = 49;
		public static final int _050_SETTLEMENT_CURRENCY_CODE = 50;
		public static final int _052_PIN_DATA = 52;
		public static final int _054_ADDITIONAL_AMOUNTS = 54;
		public static final int _056_MESSAGE_REASON_CODE = 56;
		public static final int _059_ECHO_DATA = 59;
		public static final int _066_SETTLEMENT_CODE = 66;
		public static final int _067_EXTENDED_PAYMENT_CODE = 67;
		public static final int _070_NETWORK_MANAGEMENT_INFORMATION_CODE = 70;
		public static final int _073_DATE_ACTION = 73;
		public static final int _074_CREDITS_NUMBER = 74;
		public static final int _075_CREDITS_REVERSAL_NUMBER = 75;
		public static final int _076_DEBITS_NUMBER = 76;
		public static final int _077_DEBITS_REVERSAL_NUMBER = 77;
		public static final int _078_TRANSFER_NUMBER = 78;
		public static final int _079_TRANSFER_REVERSAL_NUMBER = 79;
		public static final int _080_INQUIRIES_NUMBER = 80;
		public static final int _081_AUTHORISATIONS_NUMBER = 81;
		public static final int _082_CREDITS_PROCESSING_FEE_AMOUNT = 82;
		public static final int _083_CREDITS_TRANSACTION_FEE_AMOUNT = 83;
		public static final int _084_DEBITS_PROCESSING_FEE_AMOUNT = 84;
		public static final int _085_DEBITS_TRANSACTION_FEE_AMOUNT = 85;
		public static final int _086_CREDITS_AMOUNT = 86;
		public static final int _087_CREDITS_REVERSAL_AMOUNT = 87;
		public static final int _088_DEBITS_AMOUNT = 88;
		public static final int _089_DEBITS_REVERSAL_AMOUNT = 89;
		public static final int _090_ORIGINAL_DATA_ELEMENTS = 90;
		public static final int _091_FILE_UPDATE_CODE = 91;
		public static final int _095_REPLACEMENT_AMOUNTS = 95;
		public static final int _097_AMOUNT_NET_SETTLEMENT = 97;
		public static final int _098_PAYEE = 98;
		public static final int _100_RECEIVING_INST_ID_CODE = 100;
		public static final int _101_FILE_NAME = 101;
		public static final int _102_ACCOUNT_ID_1 = 102;
		public static final int _103_ACCOUNT_ID_2 = 103;
		public static final int _118_PAYMENTS_NUMBER = 118;
		public static final int _119_PAYMENTS_REVERSAL_NUMBER = 119;
	}

	public static class MsgType {
		public static final int _0000_INVALID_MSG = 0x000;
		public static final int _0100_AUTH_REQ = 0x100;
		public static final int _0110_AUTH_REQ_RSP = 0x110;
		public static final int _0120_AUTH_ADV = 0x120;
		public static final int _0130_AUTH_ADV_RSP = 0x130;
		public static final int _0200_TRAN_REQ = 0x200;
		public static final int _0201_TRAN_REQ_REP = 0x201;
		public static final int _0202_TRAN_CMP = 0x202;
		public static final int _0203_TRAN_CMP_REP = 0x203;
		public static final int _0210_TRAN_REQ_RSP = 0x210;
		public static final int _0212_TRAN_CMP_RSP = 0x212;
		public static final int _0220_TRAN_ADV = 0x220;
		public static final int _0221_TRAN_ADV_REP = 0x221;
		public static final int _0230_TRAN_ADV_RSP = 0x230;
		public static final int _0300_ACQUIRER_FILE_UPDATE_REQ = 0x300;
		public static final int _0310_ACQUIRER_FILE_UPDATE_RSP = 0x310;
		public static final int _0320_ACQUIRER_FILE_UPDATE_ADV = 0x320;
		public static final int _0322_ISSUER_FILE_UPDATE_ADV = 0x322;
		public static final int _0330_ACQUIRER_FILE_UPDATE_ADV_RSP = 0x330;
		public static final int _0332_ISSUER_FILE_UPDATE_ADV_RSP = 0x332;
		public static final int _0400_ACQUIRER_REV_REQ = 0x400;
		public static final int _0410_ACQUIRER_REV_REQ_RSP = 0x410;
		public static final int _0420_ACQUIRER_REV_ADV = 0x420;
		public static final int _0421_ACQUIRER_REV_ADV_REP = 0x421;
		public static final int _0430_ACQUIRER_REV_ADV_RSP = 0x430;
		public static final int _0500_ACQUIRER_RECONCILE_REQ = 0x500;
		public static final int _0510_ACQUIRER_RECONCILE_REQ_RSP = 0x510;
		public static final int _0520_ACQUIRER_RECONCILE_ADV = 0x520;
		public static final int _0521_ACQUIRER_RECONCILE_ADV_REP = 0x521;
		public static final int _0530_ACQUIRER_RECONCILE_ADV_RSP = 0x530;
		public static final int _0600_ADMIN_REQ = 0x600;
		public static final int _0601_ADMIN_REQ_REP = 0x601;
		public static final int _0610_ADMIN_REQ_RSP = 0x610;
		public static final int _0800_NWRK_MNG_REQ = 0x800;
		public static final int _0801_NWRK_MNG_REQ_REP = 0x801;
		public static final int _0810_NWRK_MNG_REQ_RSP = 0x810;

		public static int getOriginal(int msgType) {
			return msgType & 0xFFEF;
		}

		public static int getResponse(int msgType) {
			return msgType & 0xFFFE | 0x0010;
		}

		public static int toInt(String msgType) {
			return Utils.msgTypeToInt(msgType);
		}

		public static String toString(int msgType) {
			return Utils.msgTypeToString(msgType);
		}
	}

	private static Template _defaultTemplate;

	protected int _msgType;

	static {
		_defaultTemplate = new Template();
		try {
			_defaultTemplate.put(Bit._002_PAN, FieldDescriptor.getAsciiVar(2, 19, FieldValidators.getN()));
			_defaultTemplate.put(Bit._003_PROC_CODE, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			_defaultTemplate.put(Bit._004_TRAN_AMOUNT, FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._005_SETTLE_AMOUNT, FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._007_TRAN_DATE_TIME, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._009_CONVERSION_RATE_SETTLEMENT,
					FieldDescriptor.getAsciiFixed(8, FieldValidators.getN()));
			_defaultTemplate
					.put(Bit._011_SYS_TRACE_AUDIT_NUM, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			_defaultTemplate.put(Bit._012_LOCAL_TRAN_TIME, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			_defaultTemplate.put(Bit._013_LOCAL_TRAN_DATE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			_defaultTemplate.put(Bit._014_EXPIRATION_DATE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			_defaultTemplate.put(Bit._015_SELLTLEMENT_DATE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			_defaultTemplate.put(Bit._016_CONVERSION_DATE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			_defaultTemplate.put(Bit._018_MERCHANT_TYPE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			_defaultTemplate.put(Bit._022_POS_ENTRY_MODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));

			_defaultTemplate.put(Bit._023_CARD_SEQUENCE_NUM, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			_defaultTemplate.put(Bit._025_POS_CONDITION_CODE, FieldDescriptor.getAsciiFixed(2, FieldValidators.getN()));
			_defaultTemplate.put(Bit._026_POS_PIN_CAPTURE_CODE,
					FieldDescriptor.getAsciiFixed(2, FieldValidators.getN()));
			_defaultTemplate.put(Bit._027_AUTH_ID_RSP, FieldDescriptor.getAsciiFixed(1, FieldValidators.getN()));
			_defaultTemplate.put(Bit._028_TRAN_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(9, FieldValidators.getRev87Amount()));
			_defaultTemplate.put(Bit._029_SETTLEMENT_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(9, FieldValidators.getRev87Amount()));
			_defaultTemplate.put(Bit._030_TRAN_PROC_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(9, FieldValidators.getRev87Amount()));
			_defaultTemplate.put(Bit._031_SETTLEMENT_PROC_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(9, FieldValidators.getRev87Amount()));
			_defaultTemplate.put(Bit._032_ACQUIRING_INST_ID_CODE,
					FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getN()));
			_defaultTemplate.put(Bit._033_FORWARDING_INT_ID_CODE,
					FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getN()));
			_defaultTemplate
					.put(Bit._035_TRACK_2_DATA, FieldDescriptor.getAsciiVar(2, 37, FieldValidators.getTrack2()));
			_defaultTemplate.put(Bit._037_RETRIEVAL_REF_NUM, FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._038_AUTH_ID_RESPONSE, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			_defaultTemplate.put(Bit._039_RESPONSE_CODE, FieldDescriptor.getAsciiFixed(2, FieldValidators.getAn()));
			_defaultTemplate.put(Bit._040_SERVICE_RESTRICTION_CODE,
					FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			_defaultTemplate.put(Bit._041_CARD_ACCEPTOR_TERMINAL_ID,
					FieldDescriptor.getAsciiFixed(8, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._042_CARD_ACCEPTOR_ID_CODE,
					FieldDescriptor.getAsciiFixed(15, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._043_CARD_ACCEPTOR_NAME_LOCATION,
					FieldDescriptor.getAsciiFixed(40, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._044_ADDITIONAL_RESPONSE_DATA,
					FieldDescriptor.getAsciiVar(2, 25, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._045_TRACK_1_DATA, FieldDescriptor.getAsciiVar(2, 76, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._048_ADDITIONAL_DATA,
					FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._049_TRAN_CURRENCY_CODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			_defaultTemplate.put(Bit._050_SETTLEMENT_CURRENCY_CODE,
					FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			_defaultTemplate.put(Bit._052_PIN_DATA, FieldDescriptor.getBinaryFixed(8));
			_defaultTemplate.put(Bit._053_SECURITY_RELATED_CONTROL_INFORMATION, FieldDescriptor.getBinaryFixed(48));
			_defaultTemplate.put(Bit._054_ADDITIONAL_AMOUNTS,
					FieldDescriptor.getAsciiVar(3, 120, FieldValidators.getAn()));
			_defaultTemplate.put(Bit._056_MESSAGE_REASON_CODE,
					FieldDescriptor.getAsciiVar(3, 4, FieldValidators.getN()));
			_defaultTemplate.put(Bit._057_AUTHORISATION_LIFE_CYCLE,
					FieldDescriptor.getAsciiVar(3, 3, FieldValidators.getN()));
			_defaultTemplate.put(Bit._058_AUTHORISING_AGENT_INSTITUTION,
					FieldDescriptor.getAsciiVar(3, 11, FieldValidators.getAnp()));
			_defaultTemplate.put(Bit._059_ECHO_DATA, FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._066_SETTLEMENT_CODE, FieldDescriptor.getAsciiFixed(1, FieldValidators.getN()));
			_defaultTemplate.put(Bit._067_EXTENDED_PAYMENT_CODE,
					FieldDescriptor.getAsciiFixed(2, FieldValidators.getN()));
			_defaultTemplate.put(Bit._070_NETWORK_MANAGEMENT_INFORMATION_CODE,
					FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			_defaultTemplate.put(Bit._073_DATE_ACTION, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			_defaultTemplate.put(Bit._074_CREDITS_NUMBER, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._075_CREDITS_REVERSAL_NUMBER,
					FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._076_DEBITS_NUMBER, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._077_DEBITS_REVERSAL_NUMBER,
					FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._078_TRANSFER_NUMBER, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._079_TRANSFER_REVERSAL_NUMBER,
					FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._080_INQUIRIES_NUMBER, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._081_AUTHORISATIONS_NUMBER,
					FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			_defaultTemplate.put(Bit._082_CREDITS_PROCESSING_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._083_CREDITS_TRANSACTION_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._084_DEBITS_PROCESSING_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._085_DEBITS_TRANSACTION_FEE_AMOUNT,
					FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			_defaultTemplate.put(Bit._086_CREDITS_AMOUNT, FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			_defaultTemplate.put(Bit._087_CREDITS_REVERSAL_AMOUNT,
					FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			_defaultTemplate.put(Bit._088_DEBITS_AMOUNT, FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			_defaultTemplate.put(Bit._089_DEBITS_REVERSAL_AMOUNT,
					FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			_defaultTemplate.put(Bit._090_ORIGINAL_DATA_ELEMENTS,
					FieldDescriptor.getAsciiFixed(42, FieldValidators.getN()));
			_defaultTemplate.put(Bit._091_FILE_UPDATE_CODE, FieldDescriptor.getAsciiFixed(1, FieldValidators.getAn()));
			_defaultTemplate.put(Bit._095_REPLACEMENT_AMOUNTS,
					FieldDescriptor.getAsciiFixed(42, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._097_AMOUNT_NET_SETTLEMENT,
					FieldDescriptor.getAsciiFixed(17, FieldValidators.getRev87Amount()));
			_defaultTemplate.put(Bit._098_PAYEE, FieldDescriptor.getAsciiFixed(25, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._100_RECEIVING_INST_ID_CODE,
					FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._101_FILE_NAME, FieldDescriptor.getAsciiVar(2, 17, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._102_ACCOUNT_ID_1, FieldDescriptor.getAsciiVar(2, 28, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._103_ACCOUNT_ID_2, FieldDescriptor.getAsciiVar(2, 28, FieldValidators.getAns()));
			_defaultTemplate.put(Bit._118_PAYMENTS_NUMBER, FieldDescriptor.getAsciiVar(3, 30, FieldValidators.getN()));
			_defaultTemplate.put(Bit._119_PAYMENTS_REVERSAL_NUMBER,
					FieldDescriptor.getAsciiVar(3, 10, FieldValidators.getN()));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public Iso8583() {
		this(_defaultTemplate);
	}

	public Iso8583(Template template) {
		super(template);
		setMsgType(MsgType._0000_INVALID_MSG);
	}

	protected static Template getDefaultTemplate() {
		return _defaultTemplate;
	}

	public static int getResponse(int msgType) {
		return msgType - (msgType % 2) + 0x10;
	}

	@Override
	public Object clone() {
		try {
			Iso8583 msg = (Iso8583) super.clone();
			msg.setMsgType(getMsgType());
			return msg;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	protected IField createField(int field) throws UnknownFieldException {
		if (template.containsKey(field))
			return new Field(field, template.get(field));

		throw new UnknownFieldException(Integer.toString(field));
	}

	public AdditionalAmounts getAdditionalAmounts() throws Exception {
		if (!isFieldSet(Bit._054_ADDITIONAL_AMOUNTS))
			return null;

		AdditionalAmounts addAmounts = new AdditionalAmounts();
		String amounts = getField(Bit._054_ADDITIONAL_AMOUNTS).getValue();

		if (amounts.length() % 20 != 0)
			throw new Exception("Additional Amounts incorrect length");

		for (int i = 0; i < amounts.length(); i += 20) {
			String amount = amounts.substring(i, i + 20);
			addAmounts.add(new AdditionalAmount(amount));
		}

		return addAmounts;
	}

	public int getMsgType() {
		return _msgType;
	}

	@Override
	public int getPackedLength() throws Exception {
		int superLength = super.getPackedLength();
		int mtidLen = template.getMsgTypeFormatter().getPackedLength(4);
		return superLength + mtidLen;
	}

	public long getTransactionAmount() throws NumberFormatException, UnknownFieldException {
		return Long.parseLong(getField(Bit._004_TRAN_AMOUNT).getValue());
	}

	public TransmissionDateTime getTransmissionDateTime() {
		return new TransmissionDateTime(this);
	}

	public void setMsgType(int _msgType) {
		this._msgType = _msgType;
	}

	public void setTransactionAmount(long transactionAmount) throws UnknownFieldException {
		String strAmt = Long.toString(transactionAmount);
		setFieldValue(Bit._004_TRAN_AMOUNT, Utils.padLeft(strAmt, 12, '0'));
	}

	@Override
	public byte[] toMsg() throws Exception {
		int length = getPackedLength();

		String msgTypeString = IsoConvert.fromIntToMsgType(getMsgType());

		byte[] newMsgType = template.getMsgTypeFormatter().getBytes(msgTypeString);

		int msgTypeLen = newMsgType.length;
		byte[] data = new byte[length];

		System.arraycopy(newMsgType, 0, data, 0, newMsgType.length);
		byte[] baseMsg = super.toMsg();
		System.arraycopy(baseMsg, 0, data, msgTypeLen, baseMsg.length);
		return data;
	}

	@Override
	protected String toString(String prefix) throws Exception {
		StringBuilder sb = new StringBuilder();

		sb.append(prefix).append(IsoConvert.fromIntToMsgType(_msgType)).append(":")
				.append(System.getProperty("line.separator"));
		sb.append(super.toString(prefix));

		return sb.toString();
	}

	@Override
	public int unpack(byte[] msg, int startingOffset) throws Exception {
		byte[] buffer = new byte[4];
		int offset = startingOffset;
		System.arraycopy(msg, offset, buffer, 0, 4);

		_msgType = IsoConvert.fromMsgTypeDataToInt(buffer);
		offset += 4;

		return super.unpack(msg, offset);
	}

}
