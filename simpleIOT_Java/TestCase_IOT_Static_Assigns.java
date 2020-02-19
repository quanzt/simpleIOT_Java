
import java.io.*;

/**
 * TestCase_IOT_Static_Assigns
 * <p/>
 * The results of assessing this file should be a input output stack trace leading from getVulnerableSource to
 * writeToVulnerableSink.  All methods in this class are static.  We use a temporary to store the source, making
 * this slightly more complex then the TestCase_IOT_Static class.
 * <p/>
 * Complexity: Easiest
 */
public class TestCase_IOT_Static_Assigns {
    public static void main(String[] args) {
        try {
            String source = getVulnerableSource(args[0]);
            writeToVulnerableSink(source);
        } catch (Exception e) {
        }
    }

    public static String getVulnerableSource(String file)
        throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public static void writeToVulnerableSink(String str)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
