package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.formatter.BinaryFormatter;
import org.bitbucket.openisoj2.core.formatter.IFormatter;

public class Bitmap {
    private IFormatter formatter;
    private boolean[] bits;

    public Bitmap() {
        this(new BinaryFormatter());
    }

    public Bitmap(IFormatter formatter) {
        this.formatter = formatter;
        bits = new boolean[128];
    }

    public IFormatter getFormatter() {
        return formatter;
    }

    public int getPackedLength() throws Exception {
        return formatter.getPackedLength(isExtendedBitmap() ? 32 : 16);
    }

    public boolean isExtendedBitmap() {
        return isFieldSet(1);
    }

    public boolean isFieldSet(int field) {
        return bits[field - 1];
    }

    public void setField(int field, boolean on) {
        bits[field - 1] = on;
        bits[0] = false;

        for (int i = 64; i < 127; i++) {
            if (bits[i]) {
                bits[0] = true;
                break;
            }
        }
    }

    public void setFormatter(IFormatter formatter) {
        this.formatter = formatter;
    }

    public byte[] toMsg() throws Exception {
        int lengthOfBitmap = isExtendedBitmap() ? 16 : 8;

        byte[] data = new byte[lengthOfBitmap];

        for (int i = 0; i < lengthOfBitmap; i++) {
            for (int j = 0; j < 8; j++) {
                if (bits[i * 8 + j]) {
                    data[i] = (byte) (data[i] | (128 / (int) Math.pow(2, j)));
                }
            }
        }

        if (formatter instanceof BinaryFormatter)
            return data;

        IFormatter binaryFormatter = new BinaryFormatter();
        String bitMapString = binaryFormatter.getString(data);

        return formatter.getBytes(bitMapString);
    }

    public int unpack(byte[] msg, int offset) throws Exception {
        int lengthOfBitmap = formatter.getPackedLength(16);

        if (formatter instanceof BinaryFormatter) {
            // Java needs the 0xFF because otherwise it get's confused
            // wtf explained http://stackoverflow.com/questions/792386
            if ((msg[offset] & 0xFF) >= 128) {
                lengthOfBitmap += 8;
            }
        } else if (msg[offset] >= 0x38) {
            lengthOfBitmap += 16;
        }

        byte[] bitmapData = new byte[lengthOfBitmap];
        System.arraycopy(msg, offset, bitmapData, 0, lengthOfBitmap);

        if (!(formatter instanceof BinaryFormatter)) {
            IFormatter binaryFormatter = new BinaryFormatter();
            String value = formatter.getString(bitmapData);
            bitmapData = binaryFormatter.getBytes(value);
        }

        for (int i = 0; i < bitmapData.length; i++) {
            for (int j = 0; j < 8; j++) {
                bits[i * 8 + j] = (bitmapData[i] & (128 / (int) Math.pow(2, j))) > 0;
            }
        }

        return offset + lengthOfBitmap;
    }
}
