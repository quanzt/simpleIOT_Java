
import java.io.*;

/**
 * TestCase_IOT_XFile_Part1
 * <p/>
 * The results of assessing this file should be a single input/output stack traces with main as the root.  The file
 * relies on TestCase_IOT_XFile_Part2 since we are trying to do a cross file analysis.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_XFile_Part1 {
    public static void main(String[] args) {
        try {
            TestCase_IOT_XFile_Part1 testCase = new TestCase_IOT_XFile_Part1();
            TestCase_IOT_XFile_Part2 testCase2 = new TestCase_IOT_XFile_Part2();
            testCase2.writeToVulnerableSink(testCase.getVulnerableSource(args[0]));
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
}
