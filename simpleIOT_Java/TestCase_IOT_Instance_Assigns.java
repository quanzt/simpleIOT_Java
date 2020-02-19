
import java.io.*;

/**
 * TestCase_IOT_Instance_Assigns
 * <p/>
 * The results of assessing this file should be a input output stack trace
 * leading from getVulnerableSource to writeToVulnerableSink.  Unlike the TestCase_IOT_Static
 * class, all methods in this class are not static.  We do use temporaries to store the
 * result of getVulnerableSource(), making this slightly more complex then TestCase_IOT_Instance
 * <p/>
 * Complexity: Easy
 */
public class TestCase_IOT_Instance_Assigns {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Instance_Assigns testCase = new TestCase_IOT_Instance_Assigns();
            final String source = testCase.getVulnerableSource(args[0]);
            testCase.writeToVulnerableSink(source);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file)
        throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public void writeToVulnerableSink(String str)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
