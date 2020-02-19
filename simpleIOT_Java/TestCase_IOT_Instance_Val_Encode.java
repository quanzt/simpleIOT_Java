
import java.io.*;

/**
 * TestCase_IOT_Instance_Val_Encode
 * <p/>
 * The results of assessing this file should be a input output stack trace leading from getVulnerableSource to
 * writeToVulnerableSink the first time.  After adding validate or encode, the stack trace should be gone and
 * the vulnerabilities cleared.
 * <p/>
 * Complexity: Medium
 */
public class TestCase_IOT_Instance_Val_Encode {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Instance_Val_Encode testCase = new TestCase_IOT_Instance_Val_Encode();
            String file = args[0];
            String source = testCase.getVulnerableSource(file);
            testCase.validate(source);
            String encodedStr = testCase.encode(source);
            testCase.writeToVulnerableSink(file, encodedStr);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        fis.close();

        String ret = new String(buf);
        return ret;
    }

    public void writeToVulnerableSink(String file, String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }

    private void validate(String source) throws Exception {
        if (source.length() > 100) {
            throw new Exception("Length too long: " + source.length());
        }
    }

    private String encode(String source) {
        return source.trim();
    }
}
