package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.exceptions.FieldDescriptorException;
import org.bitbucket.openisoj2.core.exceptions.FieldFormatException;
import org.bitbucket.openisoj2.core.exceptions.FieldUnpackException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.fieldvalidator.HexFieldValidator;
import org.bitbucket.openisoj2.core.fieldvalidator.IFieldValidator;
import org.bitbucket.openisoj2.core.fieldvalidator.NumericFieldValidator;
import org.bitbucket.openisoj2.core.formatter.*;
import org.bitbucket.openisoj2.core.lengthformatters.FixedLengthFormatter;
import org.bitbucket.openisoj2.core.lengthformatters.ILengthFormatter;
import org.bitbucket.openisoj2.core.lengthformatters.VariableLengthFormatter;


public class FieldDescriptor implements IFieldDescriptor {

    public static IFieldDescriptor getAsciiAlphaNumeric(int length) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(length), FieldValidators.getAnsp(),
                new PadRightSetAdjuster(length, ' '));
    }

    public static IFieldDescriptor getAsciiAmount(int length) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(length), FieldValidators.getRev87Amount(),
                new PadLeftSetAdjuster(length, '0'));
    }

    public static IFieldDescriptor getAsciiAns(int length) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(length), FieldValidators.getAns(), null);
    }

    public static IFieldDescriptor getAsciiFixed(int packedLength, IFieldValidator validator) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(packedLength), validator, Formatters.getAscii(), null, null);
    }

    public static IFieldDescriptor getAsciiLLCharacter(int maxLength) throws Exception {
        return getAsciiVar(2, maxLength, FieldValidators.getAns());
    }

    public static IFieldDescriptor getAsciiLLLBinary(int packedLength) throws Exception {
        return new FieldDescriptor(new VariableLengthFormatter(3, packedLength), FieldValidators.getHex(),
                Formatters.getBinary(), null, null);
    }

    public static IFieldDescriptor getAsciiLLLCharacter(int maxLength) throws Exception {
        return getAsciiVar(3, maxLength, FieldValidators.getAns());
    }

    public static IFieldDescriptor getAsciiLLLNumeric(int maxLength) throws Exception {
        return getAsciiVar(3, maxLength, FieldValidators.getN());
    }

    public static IFieldDescriptor getAsciiLLNumeric(int maxLength) throws Exception {
        return getAsciiVar(2, maxLength, FieldValidators.getN());
    }

    public static IFieldDescriptor getAsciiN(int length) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(length), FieldValidators.getN(), null);
    }

    public static IFieldDescriptor getAsciiNumeric(int length) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(length), FieldValidators.getN(), new PadLeftSetAdjuster(
                length, '0'));
    }

    public static IFieldDescriptor getAsciiVar(int lengthIndicator, int maxLength, IFieldValidator validator)
            throws Exception {
        return new FieldDescriptor(new VariableLengthFormatter(lengthIndicator, maxLength), validator, null);
    }

    public static IFieldDescriptor getBcdFixed(int packedLength) throws Exception {
        return new FieldDescriptor(new FixedLengthFormatter(packedLength), FieldValidators.getN(), Formatters.getBcd(),
                new PadLeftSetAdjuster(packedLength * 2, '0'), null);
    }

    public static IFieldDescriptor getBcdVar(int lengthIndicator, int maxLength) throws Exception {
        return new FieldDescriptor(new VariableLengthFormatter(lengthIndicator, maxLength, new BcdFormatter()),
                FieldValidators.getN(), Formatters.getBcd(), null, null);
    }

    public static IFieldDescriptor getBinaryFixed(int packedLength) {
        return new FieldDescriptor(new FixedLengthFormatter(packedLength), FieldValidators.getHex(),
                Formatters.getBinary(), null, null);
    }

	/*
     * public static IFieldDescriptor getBinaryVar(int lengthIndicator, int maxLength) throws Exception { return new
	 * FieldDescriptor(new VariableLengthFormatter(lengthIndicator, maxLength, Formatters.getAscii()),
	 * FieldValidators.getHex(), Formatters.getBinary(), null); }
	 */

    public static IFieldDescriptor getBinaryVar(int lengthIndicator, int maxLength, IFormatter lengthFormatter)
            throws Exception {
        return new FieldDescriptor(new VariableLengthFormatter(lengthIndicator, maxLength, lengthFormatter),
                FieldValidators.getHex(), Formatters.getBinary(), null, null);
    }

    public static IFieldDescriptor getPanMask(IFieldDescriptor decoratedFieldDescriptor) {
        return new PanMaskDecorator(decoratedFieldDescriptor);
    }

    protected ILengthFormatter lengthFormatter;
    protected IFieldValidator validator;
    protected IFormatter formatter;
    protected Adjuster adjuster;
    private Sensitiser sensitiser;

    public FieldDescriptor(ILengthFormatter lengthFormatter, IFieldValidator validator) throws Exception {
        this(lengthFormatter, validator, new AsciiFormatter(), null, null);
    }

    public FieldDescriptor(ILengthFormatter lengthFormatter, IFieldValidator validator, Adjuster adjuster)
            throws Exception {
        this(lengthFormatter, validator, new AsciiFormatter(), adjuster, null);
    }

    public FieldDescriptor(ILengthFormatter lengthFormatter, IFieldValidator validator, IFormatter formatter,
                           Adjuster adjuster, Sensitiser sensitiser) {
        if (formatter instanceof BinaryFormatter && !(validator instanceof HexFieldValidator))
            throw new FieldDescriptorException("A Binary field must have a hex validator");

        if (formatter instanceof BcdFormatter && !(validator instanceof NumericFieldValidator))
            throw new FieldDescriptorException("A BCD field must have a numeric validator");

        this.lengthFormatter = lengthFormatter;
        this.validator = validator;
        this.formatter = formatter;
        this.adjuster = adjuster;
        this.sensitiser = sensitiser;
    }

    public String display(String prefix, int fieldFieldNr, String value) throws Exception {
        String fieldValue = value == null ? "" : value;

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("[");
        sb.append(Utils.padRight(lengthFormatter.getDescription(), 7, ' '));
        sb.append(Utils.padRight(validator.getDescription(), 4, ' '));
        sb.append(Utils.padLeft(lengthFormatter.getMaxLength(), 5, ' '));
        sb.append(" ");
        sb.append(Utils.padLeft("" + fieldValue.length(), 3, '0'));
        sb.append("] ");
        sb.append(Utils.padLeft("" + fieldFieldNr, 3, '0'));
        sb.append(" ");
        sb.append("[");
        if (sensitiser != null)
            sb.append(sensitiser.sensitise(fieldValue));
        else
            sb.append(fieldValue);
        sb.append("]");

        return sb.toString();
    }

    public String display(String prefix, String fieldNrPrefix, int fieldFieldNr, String value) throws Exception {
        String fieldValue = value == null ? "" : value;

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("[");
        sb.append(Utils.padRight(lengthFormatter.getDescription(), 7, ' '));
        sb.append(Utils.padRight(validator.getDescription(), 4, ' '));
        sb.append(Utils.padLeft(lengthFormatter.getMaxLength(), 5, ' '));
        sb.append(" ");
        sb.append(Utils.padLeft("" + fieldValue.length(), 3, '0'));
        sb.append("] ");
        sb.append(fieldNrPrefix);
        sb.append(Utils.padLeft("" + fieldFieldNr, 3, '0'));
        sb.append(" ");
        sb.append("[");
        sb.append(fieldValue);
        sb.append("]");

        return sb.toString();
    }

    public Adjuster getAdjuster() {
        return adjuster;
    }

    public IFormatter getFormatter() {
        return formatter;
    }

    public ILengthFormatter getLengthFormatter() {
        return lengthFormatter;
    }

    public int getPackedLenghth(String value) throws Exception {
        return lengthFormatter.getLengthOfLengthIndicator() + formatter.getPackedLength(value.length());
    }

    public IFieldValidator getValidator() {
        return validator;
    }

    public byte[] pack(int fieldNumber, String value) throws Exception {
        if (!lengthFormatter.isValidLength(formatter.getPackedLength(value.length())))
            throw new FieldFormatException("" + fieldNumber, "The field length is not valid");

        if (!validator.isValid(value))
            throw new FieldFormatException("" + fieldNumber, "Invalid value for field");

        int lenOfLenInd = lengthFormatter.getLengthOfLengthIndicator();
        int lenOfField = formatter.getPackedLength(value.length());

        byte[] field = new byte[lenOfLenInd + lenOfField];
        lengthFormatter.pack(field, lenOfField, 0);

        byte[] fieldData = formatter.getBytes(value);
        System.arraycopy(fieldData, 0, field, lenOfLenInd, lenOfField);
        return field;
    }

    public UnpackObject unpack(int fieldNumber, byte[] data, int offset) {
        try {
            int lenOfLenInd = lengthFormatter.getLengthOfLengthIndicator();
            int lenOfField = lengthFormatter.getLengthOfField(data, offset);
            if (formatter instanceof BcdFormatter)
                lenOfField = formatter.getPackedLength(lenOfField);

            byte[] fieldData = new byte[lenOfField];
            System.arraycopy(data, offset + lenOfLenInd, fieldData, 0, lenOfField);
            int newOffset = offset + lenOfField + lenOfLenInd;

            String value = formatter.getString(fieldData);

            if (!validator.isValid(value))
                throw new FieldFormatException("" + fieldNumber, "Invalid field format");

            int length = value.length();

            if (formatter instanceof BinaryFormatter)
                length = formatter.getPackedLength(length);
            if (!lengthFormatter.isValidLength(length))
                throw new FieldFormatException("" + fieldNumber, "Field is too long");

            return new UnpackObject(value, newOffset);
        } catch (Exception e) {
            if (e instanceof RuntimeException)
                throw (RuntimeException) e;
            FieldUnpackException fex = new FieldUnpackException("" + fieldNumber, data, offset, e);
            throw fex;
        }

    }

}
