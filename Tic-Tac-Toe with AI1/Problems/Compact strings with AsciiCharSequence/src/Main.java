import java.util.*;

class AsciiCharSequence implements CharSequence {
    private final byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence.clone();
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] array = Arrays.copyOfRange(sequence, start, end);
        return new AsciiCharSequence(array);
    }

    @Override
    public String toString() {
        return new String(sequence);
    }
}
