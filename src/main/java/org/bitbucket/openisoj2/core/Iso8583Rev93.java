package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.bitbucket.openisoj2.core.lengthformatters.VariableLengthFormatter;

public class Iso8583Rev93 extends Iso8583 implements IMessage {
	public static class ActionCode {

		public static final String APPROVED = "000";
		public static final String _000_APPROVED = "000";
		public static final String HONOUR_WITH_ID = "001";
		public static final String _001_HONOUR_WITH_ID = "001";
		public static final String APPROVED_PARTIAL = "002";
		public static final String _002_APPROVED_PARTIAL = "002";
		public static final String APPROVED_VIP = "003";
		public static final String _003_APPROVED_VIP = "003";
		public static final String APPROVED_UPDATE_TRACK_3 = "004";
		public static final String _004_APPROVED_UPDATE_TRACK_3 = "004";
		public static final String APPROVED_CHANGED_ACC = "005";
		public static final String _005_APPROVED_CHANGED_ACC = "005";
		public static final String APPROVED_PARTIAL_CHANGED_ACC = "006";
		public static final String _006_APPROVED_PARTIAL_CHANGED_ACC = "006";
		public static final String APPROVED_UPDATE_ICC = "007";
		public static final String _007_APPROVED_UPDATE_ICC = "007";
		public static final String DO_NOT_HONOUR = "100";
		public static final String _100_DO_NOT_HONOUR = "100";
		public static final String EXPIRED_CARD = "101";
		public static final String _101_EXPIRED_CARD = "101";
		public static final String SUSPECTED_FRAUD = "102";
		public static final String _102_SUSPECTED_FRAUD = "102";
		public static final String CONTACT_ACQUIRER = "103";
		public static final String _103_CONTACT_ACQUIRER = "103";
		public static final String RESTRICTED_CARD = "104";
		public static final String _104_RESTRICTED_CARD = "104";
		public static final String CALL_ACQ_SECURITY = "105";
		public static final String _105_CALL_ACQ_SECURITY = "105";
		public static final String PIN_TRIES_EXCEEDED = "106";
		public static final String _106_PIN_TRIES_EXCEEDED = "106";
		public static final String REFER_TO_CI = "107";
		public static final String _107_REFER_TO_CI = "107";
		public static final String REFER_TO_CI_SPECIAL = "108";
		public static final String _108_REFER_TO_CI_SPECIAL = "108";
		public static final String INVALID_MERCHANT = "109";
		public static final String _109_INVALID_MERCHANT = "109";
		public static final String INVALID_AMOUNT = "110";
		public static final String _110_INVALID_AMOUNT = "110";
		public static final String INVALID_CARD_NUMBER = "111";
		public static final String _111_INVALID_CARD_NUMBER = "111";
		public static final String PIN_DATA_REQUIRED = "112";
		public static final String _112_PIN_DATA_REQUIRED = "112";
		public static final String UNACCEPTABLE_FEE = "113";
		public static final String _113_UNACCEPTABLE_FEE = "113";
		public static final String NO_ACCOUNT_OF_REQUESTED_TYPE = "114";
		public static final String _114_NO_ACCOUNT_OF_REQUESTED_TYPE = "114";
		public static final String FUNCTION_NOT_SUPPORTED = "115";
		public static final String _115_FUNCTION_NOT_SUPPORTED = "115";
		public static final String NOT_SUFFICIENT_FUNDS = "116";
		public static final String _116_NOT_SUFFICIENT_FUNDS = "116";
		public static final String INCORRECT_PIN = "117";
		public static final String _117_INCORRECT_PIN = "117";
		public static final String NO_CARD_RECORD = "118";
		public static final String _118_NO_CARD_RECORD = "118";
		public static final String TRAN_NOT_PERMITTED_CARDHOLDER = "119";
		public static final String _119_TRAN_NOT_PERMITTED_CARDHOLDER = "119";
		public static final String TRAN_NOT_PERMITTED_TERMINAL = "120";
		public static final String _120_TRAN_NOT_PERMITTED_TERMINAL = "120";
		public static final String EXCEEDS_WITHDRAWAL_AMNT_LIMIT = "121";
		public static final String _121_EXCEEDS_WITHDRAWAL_AMNT_LIMIT = "121";
		public static final String SECURITY_VIOLATION = "122";
		public static final String _122_SECURITY_VIOLATION = "122";
		public static final String EXCEEDS_WITHDRAWAL_FREQ_LIMIT = "123";
		public static final String _123_EXCEEDS_WITHDRAWAL_FREQ_LIMIT = "123";
		public static final String VIOLATION_OF_LAW = "124";
		public static final String _124_VIOLATION_OF_LAW = "124";
		public static final String CARD_NOT_EFFECTIVE = "125";
		public static final String _125_CARD_NOT_EFFECTIVE = "125";
		public static final String INVALID_PIN_BLOCK = "126";
		public static final String _126_INVALID_PIN_BLOCK = "126";
		public static final String PIN_LENGTH_ERROR = "127";
		public static final String _127_PIN_LENGTH_ERROR = "127";
		public static final String PIN_KEY_SYNCH_ERROR = "128";
		public static final String _128_PIN_KEY_SYNCH_ERROR = "128";
		public static final String SUSPECT_COUNTERFEIT_CARD = "129";
		public static final String _129_SUSPECT_COUNTERFEIT_CARD = "129";
		public static final String DO_NOT_HONOUR_PICK_UP = "200";
		public static final String _200_DO_NOT_HONOUR_PICK_UP = "200";
		public static final String EXPIRED_CARD_PICK_UP = "201";
		public static final String _201_EXPIRED_CARD_PICK_UP = "201";
		public static final String SUSPECTED_FRAUD_PICK_UP = "202";
		public static final String _202_SUSPECTED_FRAUD_PICK_UP = "202";
		public static final String CONTACT_ACQ_PICK_UP = "203";
		public static final String _203_CONTACT_ACQ_PICK_UP = "203";
		public static final String RESTRICTED_CARD_PICK_UP = "204";
		public static final String _204_RESTRICTED_CARD_PICK_UP = "204";
		public static final String CALL_ACQUIRER_SECURITY_PICK_UP = "205";
		public static final String _205_CALL_ACQUIRER_SECURITY_PICK_UP = "205";
		public static final String PIN_TRIES_EXCEEDED_PICK_UP = "206";
		public static final String _206_PIN_TRIES_EXCEEDED_PICK_UP = "206";
		public static final String SPECIAL_CONDITIONS_PICK_UP = "207";
		public static final String _207_SPECIAL_CONDITIONS_PICK_UP = "207";
		public static final String LOST_CARD_PICK_UP = "208";
		public static final String _208_LOST_CARD_PICK_UP = "208";
		public static final String STOLEN_CARD_PICK_UP = "209";
		public static final String _209_STOLEN_CARD_PICK_UP = "209";
		public static final String SUSPECT_COUNTERFEIT_PICK_UP = "210";
		public static final String _210_SUSPECT_COUNTERFEIT_PICK_UP = "210";
		public static final String FILE_ACTION_SUCCESSFUL = "300";
		public static final String _300_FILE_ACTION_SUCCESSFUL = "300";
		public static final String FILE_ACTION_NOT_SUPORTED = "301";
		public static final String _301_FILE_ACTION_NOT_SUPORTED = "301";
		public static final String FILE_RECORD_NOT_FOUND = "302";
		public static final String _302_FILE_RECORD_NOT_FOUND = "302";
		public static final String FILE_DUP_RECORD_REPLACED = "303";
		public static final String _303_FILE_DUP_RECORD_REPLACED = "303";
		public static final String FILE_FIELD_EDIT_ERROR = "304";
		public static final String _304_FILE_FIELD_EDIT_ERROR = "304";
		public static final String FILE_LOCKED_OUT = "305";
		public static final String _305_FILE_LOCKED_OUT = "305";
		public static final String FILE_ACTION_NOT_SUCCESSFUL = "306";
		public static final String _306_FILE_ACTION_NOT_SUCCESSFUL = "306";
		public static final String FILE_FORMAT_ERROR = "307";
		public static final String _307_FILE_FORMAT_ERROR = "307";
		public static final String FILE_DUP_RECORD_REJECTED = "308";
		public static final String _308_FILE_DUP_RECORD_REJECTED = "308";
		public static final String FILE_UNKNOWN_FILE = "309";
		public static final String _309_FILE_UNKNOWN_FILE = "309";
		public static final String REV_ACCEPTED = "400";
		public static final String _400_REV_ACCEPTED = "400";
		public static final String RECON_IN_BALANCE = "500";
		public static final String _500_RECON_IN_BALANCE = "500";
		public static final String RECON_OUT_OF_BALANCE = "501";
		public static final String _501_RECON_OUT_OF_BALANCE = "501";
		public static final String AMNT_NOT_RECON_TOTALS_PROVIDED = "502";
		public static final String _502_AMNT_NOT_RECON_TOTALS_PROVIDED = "502";
		public static final String RECON_TOTALS_NOT_AVAILABLE = "503";
		public static final String _503_RECON_TOTALS_NOT_AVAILABLE = "503";
		public static final String NOT_RECONCILED_TOTALS_PROVIDED = "504";
		public static final String _504_NOT_RECONCILED_TOTALS_PROVIDED = "504";
		public static final String ADMIN_ACCEPTED = "600";
		public static final String _600_ADMIN_ACCEPTED = "600";
		public static final String ADMIN_ORIG_TRAN_NOT_FOUND = "601";
		public static final String _601_ADMIN_ORIG_TRAN_NOT_FOUND = "601";
		public static final String ADMIN_INVALID_REF = "602";
		public static final String _602_ADMIN_INVALID_REF = "602";
		public static final String ADMIN_REF_PAN_INCOMPATIBLE = "603";
		public static final String _603_ADMIN_REF_PAN_INCOMPATIBLE = "603";
		public static final String ADMIN_POS_PHOTO_NOT_AVAIL = "604";
		public static final String _604_ADMIN_POS_PHOTO_NOT_AVAIL = "604";
		public static final String ADMIN_ITEM_SUPPLIED = "605";
		public static final String _605_ADMIN_ITEM_SUPPLIED = "605";
		public static final String ADMIN_DOCUMENTATION_NOT_AVAIL = "606";
		public static final String _606_ADMIN_DOCUMENTATION_NOT_AVAIL = "606";
		public static final String FEE_ACCEPTED = "700";
		public static final String _700_FEE_ACCEPTED = "700";
		public static final String NWRK_MNG_ACCEPTED = "800";
		public static final String _800_NWRK_MNG_ACCEPTED = "800";
		public static final String ADVICE_ACK_WITH_NO_LIABILITY = "900";
		public static final String _900_ADVICE_ACK_WITH_NO_LIABILITY = "900";
		public static final String ADVICE_ACK_WITH_LIABILITY = "901";
		public static final String _901_ADVICE_ACK_WITH_LIABILITY = "901";
		public static final String INVALID_TRANSACTION = "902";
		public static final String _902_INVALID_TRANSACTION = "902";
		public static final String REENTER_TRANSACTION = "903";
		public static final String _903_REENTER_TRANSACTION = "903";
		public static final String FORMAT_ERROR = "904";
		public static final String _904_FORMAT_ERROR = "904";
		public static final String ACQUIRER_NOT_SUPPORTED = "905";
		public static final String _905_ACQUIRER_NOT_SUPPORTED = "905";
		public static final String CUTOVER_IN_PROGRESS = "906";
		public static final String _906_CUTOVER_IN_PROGRESS = "906";
		public static final String ISSUER_OR_SWITCH_INOPERATIVE = "907";
		public static final String _907_ISSUER_OR_SWITCH_INOPERATIVE = "907";
		public static final String ROUTING_ERROR = "908";
		public static final String _908_ROUTING_ERROR = "908";
		public static final String SYSTEM_MALFUNCTION = "909";
		public static final String _909_SYSTEM_MALFUNCTION = "909";
		public static final String CARD_ISSUER_SIGNED_OFF = "910";
		public static final String _910_CARD_ISSUER_SIGNED_OFF = "910";
		public static final String CARD_ISSUER_TIMED_OUT = "911";
		public static final String _911_CARD_ISSUER_TIMED_OUT = "911";
		public static final String CARD_ISSUER_UNAVAILABLE = "912";
		public static final String _912_CARD_ISSUER_UNAVAILABLE = "912";
		public static final String DUPLICATE_TRANSMISSION = "913";
		public static final String _913_DUPLICATE_TRANSMISSION = "913";
		public static final String ORIGINAL_TRAN_NOT_FOUND = "914";
		public static final String _914_ORIGINAL_TRAN_NOT_FOUND = "914";
		public static final String CUTOVER_OR_CHKPT_ERROR = "915";
		public static final String _915_CUTOVER_OR_CHKPT_ERROR = "915";
		public static final String MAC_INCORRECT = "916";
		public static final String _916_MAC_INCORRECT = "916";
		public static final String MAC_KEY_SYNC_ERROR = "917";
		public static final String _917_MAC_KEY_SYNC_ERROR = "917";
		public static final String NO_COMMS_KEY = "918";
		public static final String _918_NO_COMMS_KEY = "918";
		public static final String ENCR_KEY_SYNC_ERROR = "919";
		public static final String _919_ENCR_KEY_SYNC_ERROR = "919";
		public static final String SECURITY_ERROR_RETRY = "920";
		public static final String _920_SECURITY_ERROR_RETRY = "920";
		public static final String SECURITY_ERROR_NO_ACTION = "921";
		public static final String _921_SECURITY_ERROR_NO_ACTION = "921";
		public static final String MSG_NR_OUT_OF_SEQ = "922";
		public static final String _922_MSG_NR_OUT_OF_SEQ = "922";
		public static final String REQUEST_IN_PROGRESS = "923";
		public static final String _923_REQUEST_IN_PROGRESS = "923";
		public static final String VIOLATION_OF_BUSINESS_RULE = "950";
		public static final String _950_VIOLATION_OF_BUSINESS_RULE = "950";

		public static boolean isApprove(String action_code) {
			return action_code.charAt(0) == '0' || action_code.charAt(0) > '2' && action_code.charAt(0) < '9'
					&& action_code.substring(1).equals("00") || action_code.equals("901");
		}

		public static boolean isCapture(String action_code) {
			return action_code.charAt(0) == '2';
		}

		public static boolean isDecline(String action_code) {
			return !isApprove(action_code) && !isCapture(action_code);
		}

		public static boolean isInterveneRspCode(String action_code) {
			return action_code.equals("107") || action_code.equals("108") || action_code.equals("103")
					|| action_code.equals("105") || action_code.equals("203") || action_code.equals("205");
		}

		protected ActionCode() {
		}
	}

	/** Human readable constants mapping to field numbers */
	public class Bit {

		/** Primary Account Number */
		public static final int _002_PAN = 2;

		/** Processing Code */
		public static final int _003_PROC_CODE = 3;

		/** Transaction Amount */
		public static final int _004_TRAN_AMOUNT = 4;

		/** Settlement Amount */
		public static final int _005_SETTLE_AMOUNT = 5;

		/** Transmission Date and Time */
		public static final int _007_TRAN_DATE_TIME = 7;

		/** Conversion Rate Settlement */
		public static final int _009_CONVERSION_RATE_SETTLEMENT = 9;

		/** Systems Trace Audit Number */
		public static final int _011_SYS_TRACE_AUDIT_NUM = 11;

		/** Field 12 - Time, Local Transaction */
		public static final int _012_LOCAL_TRAN_DATETIME = 12;

		/** Field 14 - Expiry Date */
		public static final int _014_EXPIRY_DATE = 14;

		/** Field 16 - Conversion Date */
		public static final int _016_CONVERSION_DATE = 16;

		/** Field 22 - POS Data Code */
		public static final int _022_POS_DATA_CODE = 22;

		/** Field 23 - Card Sequence Number */
		public static final int _023_CARD_SEQ_NR = 23;

		/** Field 24 - Function Code */
		public static final int _024_FUNC_CODE = 24;

		/** Field 25 - Message Reason Code */
		public static final int _025_MSG_REASON_CODE = 25;

		/** Field 27 - Approval Code Length */
		public static final int _027_APPROVAL_CODE_LEN = 27;

		/** Field 28 - Reconciliation Date */
		public static final int _028_RECON_DATE = 28;

		/** Field 29 - Reconciliation Indicator */
		public static final int _029_RECON_INDICATOR = 29;

		/** Field 30 - Original Amounts */
		public static final int _030_AMOUNTS_ORIGINAL = 30;

		/** Field 32 - Acquiring Institutino ID Code */
		public static final int _032_ACQ_INST_ID_CODE = 32;

		/** Field 35 - Track 2 Data */
		public static final int _035_TRACK_2_DATA = 35;

		/** Field 37 - Retrieval Reference Number */
		public static final int _037_RET_REF_NR = 37;

		/** Field 38 - Approval Code */
		public static final int _038_APPROVAL_CODE = 38;

		/** Field 39 - Action Code */
		public static final int _039_ACTION_CODE = 39;

		/** Field 40 - Service Code */
		public static final int _040_SERVICE_CODE = 40;

		/** Field 41 - Terminal ID */
		public static final int _041_TERMINAL_ID = 41;

		/** Field 42 - Card Acceptor ID */
		public static final int _042_CARD_ACCEPTOR_ID = 42;

		/** Field 44 - Additional Response Data */
		public static final int _044_ADDITIONAL_RESPONSE_DATA = 44;

		/** Field 45 - Track 1 Data */
		public static final int _045_TRACK_1_DATA = 45;

		/** Field 46 - Fees Amounts */
		public static final int _046_FEES_AMOUNTS = 46;

		/** Field 48 - Private Additional Data */
		public static final int _048_PRIVATE_ADDITIONAL_DATA = 48;

		/** Field 49 - Transaction Currency Code */
		public static final int _049_TRAN_CURRENCY_CODE = 49;

		/** Field 50 - Settlement Currency Code */
		public static final int _050_SETTLEMENT_CURRENCY_CODE = 50;

		/** Field 52 - PIN Data */
		public static final int _052_PIN_DATA = 52;

		/** Field 53 - Security Related Information */
		public static final int _053_SECURITY_INFO = 53;

		/** Field 54 - Additional Amounts */
		public static final int _054_ADDITIONAL_AMOUNTS = 54;

		/** Field 55 - ICC Data */
		public static final int _055_ICC_DATA = 55;

		/** Field 56 - Original Data Elements */
		public static final int _056_ORIG_DATA_ELEMENTS = 56;

		/** Field 57 - Auth Life Cycle Code */
		public static final int _057_AUTH_LIFE_CYCLE_CODE = 57;

		/** Field 58 - Authorizing Agent Institution ID Code */
		public static final int _058_AUTH_AGENT_INST_ID_CODE = 58;

		/** Field 59 - Echo Data */
		public static final int _059_ECHO_DATA = 59;

		/** Field 62 - Hotcard Capacity */
		public static final int _062_HOTCARD_CAPACITY = 62;

		/** Field 63 - TermApp.ISO Private Data */
		public static final int _063_TERMAPP_PRIVATE_DATA = 63;

		/** Field 64 - Message Authentication Code */
		public static final int _064_MAC = 64;

		/** Field 66 - Original Fees Amounts */
		public static final int _066_ORIGINAL_FEES_AMOUNTS = 66;

		/** Fiel 67 - Extended Payment Data */
		public static final int _067_EXT_PAYMENT_DATA = 67;

		/** Field 71 - Message Number */
		public static final int _071_MSG_NR = 71;

		/** Field 72 - Data Record */
		public static final int _072_DATA_RECORD = 72;

		/** Field 74 - Credits, Number */
		public static final int _074_NR_CREDITS = 74;

		/** Field 75 - Credits Reversal, Number */
		public static final int _075_NR_CREDITS_REVERSAL = 75;

		/** Field 76 - Debits, Number */
		public static final int _076_NR_DEBITS = 76;

		/** Field 77 - Debits Reversal, Number */
		public static final int _077_NR_DEBITS_REVERSAL = 77;

		/** Field 81 - Authorisations, Number */
		public static final int _081_NR_AUTHS = 81;

		/** Field 86 - Credits, Amount */
		public static final int _086_AMOUNT_CREDITS = 86;

		/** Field 87 - Credits Reversal, Amount */
		public static final int _087_AMOUNT_CREDITS_REVERSAL = 87;

		/** Field 88 - Debits, Amount */
		public static final int _088_AMOUNT_DEBITS = 88;

		/** Field 89 - Debits Reversal, Amount */
		public static final int _089_AMOUNT_DEBITS_REVERSAL = 89;

		/** Field 90 - Authorisations Reversal, Number */
		public static final int _090_NR_AUTHS_REVERSAL = 90;

		/** Field 96 - Key Management Data */
		public static final int _096_KEY_MANAGEMENT_DATA = 96;

		/** Field 97 - Net Reconciliation Amount */
		public static final int _097_AMOUNT_NET_RECON = 97;

		/** Field 98 - Payee */
		public static final int _098_PAYEE = 98;

		/** Field 100 - Receiving Institution ID Code */
		public static final int _100_RECEIVING_INST_ID_CODE = 100;

		/** Field 101 - File Name */
		public static final int _101_FILE_NAME = 101;

		/** Field 102 - Account ID 1 */
		public static final int _102_ACCOUNT_ID_1 = 102;

		/** Field 103 - Account ID 2 */
		public static final int _103_ACCOUNT_ID_2 = 103;

		/** Field 104 - Transaction Description */
		public static final int _104_TRAN_DESCRIPTION = 104;

		/** Field 109 - Fee Amounts, Credits */
		public static final int _109_FEE_AMOUNTS_CREDITS = 109;

		/** Field 110 - Fee Amounts, Debits */
		public static final int _110_FEE_AMOUNTS_DEBITS = 110;

		/** Fied 123 - Receipt Data */
		public static final int _123_RECEIPT_DATA = 123;

		/** Field 124 - Display Data */
		public static final int _124_DISPLAY_DATA = 124;

		/** Field 128 - Message Authentication Code */
		public static final int _128_MAC = 128;

	}

	public class FuncCode {
		public static final String _100_ORIGINAL_AUTH = "100";
		public static final String _200_ADVICE_REQUIRED = "200";
		public static final String _201_RESULT_OUTSTANDING = "201";
		public static final String _301_ADD_RECORD = "301";
		public static final String _303_DELETE_RECORD = "303";
		public static final String _304_REPLACE_RECORD = "304";
		public static final String _305_ENQUIRY = "305";
		public static final String _306_REPLACE_FILE = "306";
		public static final String _380_DATA_MORE_TO_COME = "380";
		public static final String _381_DATA_NO_MORE_TO_COME = "381";
		public static final String _382_NO_DATA = "382";
		public static final String _383_FILE_TRANSFER_COMPLETE = "383";
		public static final String _384_FILE_TRANSFER_ABORTED = "384";
		public static final String _400_FULL_REVERSAL_REQUIRED = "400";
		public static final String _401_PARTIAL_REVERSAL_REQUIRED = "401";
		public static final String _690_ADMINISTRATIVE_NOTIFICATION = "690";
		public static final String _691_ADMINISTRATIVE_REQUEST = "691";
		public static final String _805_SPECIAL_INSTRUCTION = "805";
		public static final String _811_KEY_EXCHANGE = "811";

	}

	/** Human readable constants mapping to message types */
	public static class MsgType {
		/** Invalid Message */
		public static final int _0000_INVALID_MSG = Iso8583.MsgType._0000_INVALID_MSG;

		/** Authorisation Request */
		public static final int _1100_AUTH_REQ = 0x1100;

		/** Authorisation Request Response */
		public static final int _1110_AUTH_REQ_RSP = 0x1110;

		/** Authorisation Advice */
		public static final int _1120_AUTH_ADV = 0x1120;

		/** Authorisation Advice Response */
		public static final int _1130_AUTH_ADV_RSP = 0x1130;

		/** Transaction Request */
		public static final int _1200_TRAN_REQ = 0x1200;

		/** Transaction Request Response */
		public static final int _1210_TRAN_REQ_RSP = 0x1210;

		/** Transaction Advice */
		public static final int _1220_TRAN_ADV = 0x1220;

		/** Transaction Advice Response */
		public static final int _1230_TRAN_ADV_RSP = 0x1230;

		/** File Action Request */
		public static final int _1304_FILE_ACTION_REQ = 0x1304;

		/** File Action Request Response */
		public static final int _1314_FILE_ACTION_REQ_RSP = 0x1314;

		/** Reversal Advice */
		public static final int _1420_TRAN_REV_ADV = 0x1420;

		/** Reversal Advice Response */
		public static final int _1430_TRAN_REV_ADV_RSP = 0x1430;

		/** Reconciliation Request */
		public static final int _1500_RECON_REQ = 0x1500;

		/** Reconciliation Request Response */
		public static final int _1510_RECON_REQ_RSP = 0x1510;

		/** Reconciliation Advice */
		public static final int _1520_RECON_ADV = 0x1520;

		/** Reconciliation Advice Response */
		public static final int _1530_RECON_ADV_RSP = 0x1530;

		/** Administration Request */
		public static final int _1604_ADMIN_REQ = 0x1604;

		/** Administration Request Response */
		public static final int _1614_ADMIN_REQ_RSP = 0x1614;

		/** Administration Advice */
		public static final int _1624_ADMIN_ADV = 0x1624;

		/** Administration Advice Response */
		public static final int _1634_ADMIN_ADV_RSP = 0x1634;

		/** Network Management Request */
		public static final int _1804_NWRK_MNG_REQ = 0x1804;

		/** Network Management Request Response */
		public static final int _1814_NWRK_MNG_REQ_RSP = 0x1814;

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

	public static final class PosDataCode {
		public static class CardCaptureCapability {
			public static final String _0_NONE = "0";
			public static final String _1_CAPTURE = "1";
		}

		public static class CardDataInputCapability {
			public static final String _0_UNKNOWN = "0";
			public static final String _1_MANUAL = "1";
			public static final String _2_MAGSTRIPE = "2";
			public static final String _3_BAR_CODE = "3";
			public static final String _4_OCR = "4";
			public static final String _5_MAGSTRIPE_KEY_ENTRY_ICC = "5";
			public static final String _6_KEY_ENTRY = "6";
			public static final String _7_MAGSTRIPE_KEY_ENTRY = "7";
			public static final String _8_MAGSTRIPE_ICC = "8";
			public static final String _9_ICC = "9";
			public static final String _A_CONTACTLESS_ICC = "A";
			public static final String _B_CONTACTLESS_MAGSTRIPE = "B";
		}

		public static class CardDataInputMode {
			public static final String _0_UNKNOWN = "0";
			public static final String _1_MANUAL = "1";
			public static final String _2_MAGSTRIPE = "2";
			public static final String _3_BAR_CODE = "3";
			public static final String _4_OCR = "4";
			public static final String _5_ICC = "5";
			public static final String _6_KEY_ENTRY = "6";
			public static final String _7_CONTACTLESS_ICC = "7";
			public static final String _8_CONTACTLESS_MAGSTRIPE = "8";
		}

		public static class CardDataOutputCapability {
			public static final String _0_UNKNOWN = "0";
			public static final String _1_NONE = "1";
			public static final String _2_MAGSTRIPE = "2";
			public static final String _3_ICC = "3";
		}

		public static class CardholderAuthCapability {
			public static final String _0_NONE = "0";
			public static final String _1_PIN = "1";
			public static final String _2_SIGNATURE = "2";
			public static final String _3_BIOMETRICS = "3";
			public static final String _4_BIOGRAPHIC = "4";
			public static final String _5_INOPERATIVE = "5";
			public static final String _6_OTHER = "6";
		}

		public static class CardholderAuthEntity {
			public static final String _0_NOT_AUTHENTICATED = "0";
			public static final String _1_ICC = "1";
			public static final String _2_CAD = "2";
			public static final String _2_TERMINAL = "2";
			public static final String _3_AUTHORIZER = "3";
			public static final String _4_MERCHANT = "4";
			public static final String _5_OTHER = "5";
		}

		public static class CardholderAuthMethod {
			public static final String _0_NONE = "0";
			public static final String _1_PIN = "1";
			public static final String _2_SIGNATURE = "2";
			public static final String _3_BIOMETRICS = "3";
			public static final String _4_BIOGRAPHIC = "4";
			public static final String _5_MANUAL = "5";
			public static final String _6_OTHER = "6";
		}

		public static class CardholderPresent {

			public static final String _0_PRESENT = "0";
			public static final String _1_NOT_PRESENT = "1";
			public static final String _2_MAIL_ORDER = "2";
			public static final String _3_TELEPHONE = "3";
			public static final String _4_STANDING_AUTH = "4";
		}

		public static class CardPresent {
			public static final String _0_NOT_PRESENT = "0";
			public static final String _1_PRESENT = "1";
		}

		public static class OperatingEnvironment {
			public static final String _0_NO_TERMINAL = "0";
			public static final String _1_ATTENDED_ON_ACCEPTOR_PREMISES = "1";
			public static final String _2_UNATTENDED_ON_ACCEPTOR_PREMISES = "2";
			public static final String _3_ATTENDED_OFF_ACCEPTOR_PREMISES = "3";
			public static final String _4_UNATTENDED_OFF_ACCEPTOR_PREMISES = "4";
			public static final String _5_UNATTENDED_ON_CARDHOLDER_PREMISES = "5";
		}

		public static class PinCaptureCapability {
			public static final String _0_NONE = "0";
			public static final String _1_UNKNOWN = "1";
			public static final String _4_FOUR = "4";
			public static final String _5_FIVE = "5";
			public static final String _6_SIX = "6";
			public static final String _7_SEVEN = "7";
			public static final String _8_EIGHT = "8";
			public static final String _9_NINE = "9";
			public static final String _A_TEN = "A";
			public static final String _B_ELEVEN = "B";
			public static final String _C_TWELVE = "C";
		}

		public static class TerminalOperator {
			public static final String _0_CUSTOMER_OPERATED = "0";
			public static final String _1_CARD_ACCEPTOR_OPERATED = "1";
			public static final String _2_ADMINISTRATIVE = "2";
		}

		public static class TerminalOutputCapability {
			public static final String _0_UNKNOWN = "0";
			public static final String _1_NONE = "1";
			public static final String _2_PRINTING = "2";
			public static final String _3_DISPLAY = "3";
			public static final String _4_PRINTING_AND_DISPLAY = "4";
		}

		public static class TerminalType {
			public static final String _00_ADMIN = "00";
			public static final String _01_POS = "01";
			public static final String _02_ATM = "02";
			public static final String _03_HOME = "03";
			public static final String _04_ECR = "04";
			public static final String _05_DIAL = "05";
			public static final String _06_TRAVELLERS_CHECK = "06";
			public static final String _07_FUEL = "07";
			public static final String _08_SCRIP = "08";
			public static final String _09_COUPON = "09";
			public static final String _10_TICKET = "10";
			public static final String _11_POINT_OF_BANKING = "11";
			public static final String _12_TELLER = "12";
			public static final String _13_FRANCHISE_TELLER = "13";
			public static final String _14_PERSONAL_BANKING = "14";
			public static final String _15_PUBLIC_UTILITY = "15";
			public static final String _16_VENDING = "16";
			public static final String _17_SELF_SERVICE = "17";
			public static final String _18_AUTHORIZATION = "18";
			public static final String _19_PAYMENT = "19";
			public static final String _20_VRU = "20";
			public static final String _21_SMART_PHONE = "21";
			public static final String _22_INTERACTIVE_TELEVISION = "22";
			public static final String _23_PERSONAL_DIGITAL_ASSISTANT = "23";
			public static final String _24_SCREEN_PHONE = "24";
			public static final String _25_BUSINESS_BANKING = "25";
			public static final String _90_E_COMMERCE = "90";
			public static final String _91_E_COMMERCE_SET_NO_CH_CERT = "91";
			public static final String _92_E_COMMERCE_SET_CH_CERT = "92";
			public static final String _93_E_COMMERCE_SET_CHIP_NO_CH_CERT = "93";
			public static final String _94_E_COMMERCE_SET_CHIP_CH_CERT = "94";
			public static final String _95_E_COMMERCE_SSL_NO_CH_CERT = "95";
			public static final String _96_E_COMMERCE_SSL_CHIP_NO_CH_CERT = "96";
		}

		private String cardCaptureCapability;
		private String cardDataInputCapability;
		private String cardDataInputMode;
		private String cardDataOutputCapability;
		private String cardholderAuthCapability;
		private String cardholderAuthEntity;
		private String cardholderAuthMethod;
		private String cardholderPresent;
		private String cardPresent;
		private String operatingEnvironment;
		private String pinCaptureCapability;
		private String terminalOutputCapability;
		private String terminalOperator;
		private String terminalType;

		public PosDataCode() {
		}

		public PosDataCode(String msg) {
			unpack(msg);
		}

		public final String getCardCaptureCapability() {
			return cardCaptureCapability;
		}

		public final String getCardDataInputCapability() {
			return cardDataInputCapability;
		}

		public final String getCardDataInputMode() {
			return cardDataInputMode;
		}

		public final String getCardDataOutputCapability() {
			return cardDataOutputCapability;
		}

		public final String getCardholderAuthCapability() {
			return cardholderAuthCapability;
		}

		public final String getCardholderAuthEntity() {
			return cardholderAuthEntity;
		}

		public final String getCardholderAuthMethod() {
			return cardholderAuthMethod;
		}

		public final String getCardholderPresent() {
			return cardholderPresent;
		}

		public final String getCardPresent() {
			return cardPresent;
		}

		public final String getOperatingEnvironment() {
			return operatingEnvironment;
		}

		public final String getPinCaptureCapability() {
			return pinCaptureCapability;
		}

		public String getTerminalOperator() {
			return terminalOperator;
		}

		public final String getTerminalOutputCapability() {
			return terminalOutputCapability;
		}

		public String getTerminalType() {
			return terminalType;
		}

		public final void setCardCaptureCapability(String cardCaptureCapability) {
			this.cardCaptureCapability = cardCaptureCapability;
		}

		public final void setCardDataInputCapability(String cardDataInputCapability) {
			this.cardDataInputCapability = cardDataInputCapability;
		}

		public final void setCardDataInputMode(String cardDataInputMode) {
			this.cardDataInputMode = cardDataInputMode;
		}

		public final void setCardDataOutputCapability(String cardDataOutputCapability) {
			this.cardDataOutputCapability = cardDataOutputCapability;
		}

		public final void setCardholderAuthCapability(String cardholderAuthCapability) {
			this.cardholderAuthCapability = cardholderAuthCapability;
		}

		public final void setCardholderAuthEntity(String cardholderAuthEntity) {
			this.cardholderAuthEntity = cardholderAuthEntity;
		}

		public final void setCardholderAuthMethod(String cardholderAuthMethod) {
			this.cardholderAuthMethod = cardholderAuthMethod;
		}

		public final void setCardholderPresent(String cardholderPresent) {
			this.cardholderPresent = cardholderPresent;
		}

		public final void setCardPresent(String cardPresent) {
			this.cardPresent = cardPresent;
		}

		public final void setOperatingEnvironment(String operatingEnvironment) {
			this.operatingEnvironment = operatingEnvironment;
		}

		public final void setPinCaptureCapability(String pinCaptureCapability) {
			this.pinCaptureCapability = pinCaptureCapability;
		}

		public void setTerminalOperator(String terminalOperator) {
			this.terminalOperator = terminalOperator;
		}

		public final void setTerminalOutputCapability(String terminalOutputCapability) {
			this.terminalOutputCapability = terminalOutputCapability;
		}

		public void setTerminalType(String terminalType) {
			this.terminalType = terminalType;
		}

		@Override
		public String toString() {
			return cardDataInputCapability + cardholderAuthCapability + cardCaptureCapability + operatingEnvironment
					+ cardholderPresent + cardPresent + cardDataInputMode + cardholderAuthMethod + cardholderAuthEntity
					+ cardDataOutputCapability + terminalOutputCapability + pinCaptureCapability + terminalOperator
					+ terminalType;
		}

		public void unpack(String msg) {
			cardDataInputCapability = msg.substring(0, 1);
			cardholderAuthCapability = msg.substring(1, 2);
			cardCaptureCapability = msg.substring(2, 3);
			operatingEnvironment = msg.substring(3, 4);
			cardholderPresent = msg.substring(4, 5);
			cardPresent = msg.substring(5, 6);
			cardDataInputMode = msg.substring(6, 7);
			cardholderAuthMethod = msg.substring(7, 8);
			cardholderAuthEntity = msg.substring(8, 9);
			cardDataOutputCapability = msg.substring(9, 10);
			terminalOutputCapability = msg.substring(10, 11);
			pinCaptureCapability = msg.substring(11, 12);
			terminalOperator = msg.substring(12, 13);
			terminalType = msg.substring(13, 15);
		}
	}

	private static Template defaultTemplate;

	static {
		defaultTemplate = new Template();
		try {

			defaultTemplate.put(
					Bit._002_PAN,
					new FieldDescriptor(new VariableLengthFormatter(2, 19), FieldValidators.getN(), Formatters
							.getAscii(), null, FullSensitiser.getInstance()));
			defaultTemplate.put(Bit._003_PROC_CODE, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			defaultTemplate.put(Bit._004_TRAN_AMOUNT, FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			defaultTemplate.put(Bit._005_SETTLE_AMOUNT, FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			defaultTemplate.put(Bit._007_TRAN_DATE_TIME, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate.put(Bit._009_CONVERSION_RATE_SETTLEMENT,
					FieldDescriptor.getAsciiFixed(8, FieldValidators.getN()));
			defaultTemplate.put(Bit._011_SYS_TRACE_AUDIT_NUM, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			defaultTemplate
					.put(Bit._012_LOCAL_TRAN_DATETIME, FieldDescriptor.getAsciiFixed(12, FieldValidators.getN()));
			defaultTemplate.put(Bit._014_EXPIRY_DATE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			defaultTemplate.put(Bit._016_CONVERSION_DATE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
			defaultTemplate.put(Bit._022_POS_DATA_CODE, FieldDescriptor.getAsciiFixed(15, FieldValidators.getAns()));
			defaultTemplate.put(Bit._023_CARD_SEQ_NR, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._024_FUNC_CODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._027_APPROVAL_CODE_LEN, FieldDescriptor.getAsciiFixed(1, FieldValidators.getN()));
			defaultTemplate.put(Bit._028_RECON_DATE, FieldDescriptor.getAsciiFixed(6, FieldValidators.getN()));
			defaultTemplate.put(Bit._029_RECON_INDICATOR, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._030_AMOUNTS_ORIGINAL, FieldDescriptor.getAsciiFixed(24, FieldValidators.getN()));
			defaultTemplate.put(Bit._032_ACQ_INST_ID_CODE, FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getN()));
			defaultTemplate.put(Bit._035_TRACK_2_DATA, new FieldDescriptor(new VariableLengthFormatter(2, 37),
					FieldValidators.getTrack2(), Formatters.getAscii(), null, FullSensitiser.getInstance()));
			defaultTemplate.put(Bit._037_RET_REF_NR, FieldDescriptor.getAsciiFixed(12, FieldValidators.getAnp()));
			defaultTemplate.put(Bit._038_APPROVAL_CODE, FieldDescriptor.getAsciiFixed(6, FieldValidators.getAnp()));
			defaultTemplate.put(Bit._039_ACTION_CODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._040_SERVICE_CODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._041_TERMINAL_ID, FieldDescriptor.getAsciiFixed(8, FieldValidators.getAns()));
			defaultTemplate.put(Bit._042_CARD_ACCEPTOR_ID, FieldDescriptor.getAsciiFixed(15, FieldValidators.getAns()));
			defaultTemplate.put(Bit._044_ADDITIONAL_RESPONSE_DATA,
					FieldDescriptor.getAsciiVar(2, 99, FieldValidators.getAns()));
			defaultTemplate.put(Bit._045_TRACK_1_DATA, FieldDescriptor.getAsciiVar(2, 76, FieldValidators.getAns()));
			defaultTemplate.put(Bit._046_FEES_AMOUNTS, FieldDescriptor.getAsciiVar(3, 204, FieldValidators.getAns()));
			defaultTemplate.put(Bit._048_PRIVATE_ADDITIONAL_DATA,
					FieldDescriptor.getAsciiVar(4, 9999, FieldValidators.getNone()));
			defaultTemplate.put(Bit._049_TRAN_CURRENCY_CODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._050_SETTLEMENT_CURRENCY_CODE,
					FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._052_PIN_DATA, FieldDescriptor.getAsciiFixed(16, FieldValidators.getHex()));
			defaultTemplate.put(Bit._053_SECURITY_INFO, FieldDescriptor.getAsciiVar(2, 96, FieldValidators.getHex()));
			defaultTemplate.put(Bit._054_ADDITIONAL_AMOUNTS,
					FieldDescriptor.getAsciiVar(3, 96, FieldValidators.getHex()));
			defaultTemplate.put(Bit._055_ICC_DATA, FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getHex()));
			// defaultTemplate.put(Bit._055_ICC_DATA, FieldDescriptor.getBinaryVar(3, 999, Formatters.getBinary()));
			defaultTemplate
					.put(Bit._056_ORIG_DATA_ELEMENTS, FieldDescriptor.getAsciiVar(2, 35, FieldValidators.getN()));
			defaultTemplate
					.put(Bit._057_AUTH_LIFE_CYCLE_CODE, FieldDescriptor.getAsciiFixed(3, FieldValidators.getN()));
			defaultTemplate.put(Bit._058_AUTH_AGENT_INST_ID_CODE,
					FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getN()));
			defaultTemplate.put(Bit._059_ECHO_DATA, FieldDescriptor.getAsciiVar(3, 200, FieldValidators.getAns()));
			defaultTemplate.put(Bit._062_HOTCARD_CAPACITY, FieldDescriptor.getAsciiVar(3, 5, FieldValidators.getN()));
			defaultTemplate.put(Bit._063_TERMAPP_PRIVATE_DATA,
					FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getHex()));
			defaultTemplate.put(Bit._064_MAC, FieldDescriptor.getBinaryFixed(8));
			defaultTemplate.put(Bit._066_ORIGINAL_FEES_AMOUNTS,
					FieldDescriptor.getAsciiVar(3, 204, FieldValidators.getAns()));
			defaultTemplate.put(Bit._067_EXT_PAYMENT_DATA, FieldDescriptor.getAsciiFixed(2, FieldValidators.getN()));
			defaultTemplate.put(Bit._071_MSG_NR, FieldDescriptor.getAsciiFixed(8, FieldValidators.getN()));
			defaultTemplate.put(Bit._072_DATA_RECORD, FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getAns()));
			defaultTemplate.put(Bit._074_NR_CREDITS, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate
					.put(Bit._075_NR_CREDITS_REVERSAL, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate.put(Bit._076_NR_DEBITS, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate.put(Bit._077_NR_DEBITS_REVERSAL, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate.put(Bit._081_NR_AUTHS, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate.put(Bit._086_AMOUNT_CREDITS, FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			defaultTemplate.put(Bit._087_AMOUNT_CREDITS_REVERSAL,
					FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			defaultTemplate.put(Bit._088_AMOUNT_DEBITS, FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			defaultTemplate.put(Bit._089_AMOUNT_DEBITS_REVERSAL,
					FieldDescriptor.getAsciiFixed(16, FieldValidators.getN()));
			defaultTemplate.put(Bit._090_NR_AUTHS_REVERSAL, FieldDescriptor.getAsciiFixed(10, FieldValidators.getN()));
			defaultTemplate.put(Bit._096_KEY_MANAGEMENT_DATA,
					FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getAns()));
			defaultTemplate.put(Bit._097_AMOUNT_NET_RECON, FieldDescriptor.getAsciiFixed(17, FieldValidators.getAn()));
			defaultTemplate.put(Bit._098_PAYEE, FieldDescriptor.getAsciiFixed(25, FieldValidators.getAns()));
			defaultTemplate.put(Bit._100_RECEIVING_INST_ID_CODE,
					FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getN()));
			defaultTemplate.put(Bit._101_FILE_NAME, FieldDescriptor.getAsciiVar(2, 99, FieldValidators.getAns()));
			defaultTemplate.put(Bit._102_ACCOUNT_ID_1, FieldDescriptor.getAsciiVar(2, 28, FieldValidators.getAns()));
			defaultTemplate.put(Bit._103_ACCOUNT_ID_2, FieldDescriptor.getAsciiVar(2, 28, FieldValidators.getAns()));
			defaultTemplate.put(Bit._104_TRAN_DESCRIPTION,
					FieldDescriptor.getAsciiVar(4, 9999, FieldValidators.getAns()));
			defaultTemplate.put(Bit._109_FEE_AMOUNTS_CREDITS,
					FieldDescriptor.getAsciiVar(2, 84, FieldValidators.getAns()));
			defaultTemplate.put(Bit._110_FEE_AMOUNTS_DEBITS,
					FieldDescriptor.getAsciiVar(2, 84, FieldValidators.getAns()));
			defaultTemplate.put(Bit._123_RECEIPT_DATA, FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getAns()));
			defaultTemplate.put(Bit._124_DISPLAY_DATA, FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getAns()));
			defaultTemplate.put(Bit._128_MAC, FieldDescriptor.getBinaryFixed(8));
		} catch (Exception e) {

		}
	}

	protected static Template getDefaultTemplate() {
		return (Template) defaultTemplate.clone();
	}

	public Iso8583Rev93() {
		this(defaultTemplate);
	}

	public Iso8583Rev93(Template template) {
		super(template);
	}

	@Override
	public Object clone() {
		try {
			Iso8583Rev93 msg = (Iso8583Rev93) super.clone();
			msg.setMsgType(getMsgType());
			return msg;
		} catch (Exception e) {
			return null;
		}
	}

	public PosDataCode getPosDataCode() {
		return new PosDataCode(get(Iso8583Rev93.Bit._022_POS_DATA_CODE));
	}

	public void setPosDataCode(PosDataCode posDataCode) throws Exception {
		set(Iso8583Rev93.Bit._022_POS_DATA_CODE, posDataCode.toString());
	}
}
