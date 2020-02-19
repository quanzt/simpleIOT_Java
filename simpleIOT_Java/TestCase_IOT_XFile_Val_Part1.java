
import java.io.*;

/**
 * TestCase_IOT_XFile_Val_Part1
 * <p/>
 * The results of running an assessment on this code will be a single input/output trace with main as the root when the
 * validate method is not specified (medium confidence/Type I).  When the validate method is marked as validating for
 * either input or output, no traces should be found and the vulnerability should be eliminated.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_XFile_Val_Part1 {
    public static void main(String[] args) {
        try {
            TestCase_IOT_XFile_Val_Part1 testCase = new TestCase_IOT_XFile_Val_Part1();
            TestCase_IOT_XFile_Part2 testCase2 = new TestCase_IOT_XFile_Part2();
            testCase2.writeToVulnerableSink(testCase.validate(testCase.getVulnerableSource(args[0])));
        } catch (Exception e) {
        }
    }

    private String validate(String vulnerableSource) {
        return vulnerableSource;
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
