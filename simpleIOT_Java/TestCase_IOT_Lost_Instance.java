
import java.io.*;

/**
 * TestCase_Lost_IOT_Instance_Lost
 * <p/>
 * The results of running this test is an input/output stack trace that is associated with the
 * source and has a root at the main method.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_Lost_Instance {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Lost_Instance testCase = new TestCase_IOT_Lost_Instance();
            String file = args[0];
            String source = testCase.getVulnerableSource(file);

            String key = args[1];
            testCase.writeToUnknownSink(key, source);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public void writeToUnknownSink(String key, String str) {
        System.setProperty(key, str);
    }
}
