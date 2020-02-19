import java.io.*;

/**
 * TestCase_IOT_Recursion
 * <p/>
 * The results of assessing this file should a one input/output stack traces: with main at the root,
 * This class has a couple of recursive methods that carry the taint.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_Recursion {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Recursion testCase = new TestCase_IOT_Recursion();
            final String file = args[0];
            String str = testCase.readFromVulnerableSource(file);
            testCase.writeToVulnerableSink(str);
        } catch (Exception ex) {
        }
    }

    private String readFromVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();

        ret = recursiveTrim(ret);

        return ret;
    }

    private String recursiveTrim(String ret) {
        if (ret.startsWith(" ")) {
            ret = recursiveTrim(ret.substring(1));
        }
        if (ret.endsWith(" ")) {
            ret = recursiveTrim(ret.substring(0, ret.length() - 1));
        }
        return ret;
    }

    private void writeToVulnerableSink(String str) throws Exception {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
