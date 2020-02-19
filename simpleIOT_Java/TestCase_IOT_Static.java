
import java.io.*;

/**
 * TestCase_IOT_Static
 * <p/>
 * The results of assessing this file should be a input output stack trace leading from getVulnerableSource to
 * writeToVulnerableSink.  All methods in this class are static.  We do not use a temporary to store the source.
 * <p/>
 * Complexity: Easiest
 */
public class TestCase_IOT_Static {
    public static void main(String[] args) {
        try {
            writeToVulnerableSink(getVulnerableSource(args[0]));
        } catch (Exception e) {
        }
    }

    public static String getVulnerableSource(String file)
        throws java.io.IOException, java.io.FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public static void writeToVulnerableSink(String str)
        throws java.io.FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
