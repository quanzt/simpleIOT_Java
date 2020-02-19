
import java.io.*;

/**
 * TestCase_IOT_OverlapTrace
 * <p/>
 * Tne result of running this testcase is to find two stack traces, one that has main as the root,
 * and the other that has writeToSinkCheck as the root.  What makes this testcase special is that
 * the two stack traces overlap each other.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_OverlapTrace {
    public static void main(String[] args) {
        try {
            TestCase_IOT_OverlapTrace testCase = new TestCase_IOT_OverlapTrace();
            final String file = args[0];
            String str = testCase.readFromVulnerableSource(file);
            testCase.writeToSinkCheck(file, str);
        } catch (Exception ex) {
        }
    }

    private String readFromVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();

        return ret;
    }

    private void writeToSinkCheck(String file, String str) throws Exception {
        if (str == null) {
            str = readFromVulnerableSource(file);
        }
        writeToVulnerableSink(str);
    }

    private void writeToVulnerableSink(String str) throws Exception {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.println(str);
    }
}
