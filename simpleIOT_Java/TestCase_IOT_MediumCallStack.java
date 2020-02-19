import java.io.*;

/**
 * TestCase_IOT_MediumCallStack
 * <p/>
 * The results of assessing this file should be a single input/output stack trace with main as the
 * root.  The program is equivalent to TestCase_IOT_Instance_Assigns except that it uses a lot of
 * specialized methods that create a deeper call stack. 
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_MediumCallStack {
    public static void main(String[] args) {
        try {
            TestCase_IOT_MediumCallStack testCase = new TestCase_IOT_MediumCallStack();
            testCase.writeToVulnerableSink(testCase.getVulnSourceFromFile(args[0]));
        } catch (Exception e) {
        }
    }

    private String getVulnSourceFromFile(String file) throws IOException {
        return getVulnerableSource(file);
    }

    public String getVulnerableSource(String file) throws IOException, FileNotFoundException {
        return convertBufToString(readBufFromFile(file));
    }

    private String convertBufToString(byte[] buf) {
        return new String(buf);
    }

    private byte[] readBufFromFile(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = getBuffer();
        readIntoBuf(fis, buf);
        return buf;
    }

    private void readIntoBuf(FileInputStream fis, byte[] buf) throws IOException {
        fis.read(buf);
        fis.close();
    }

    private byte[] getBuffer() {
        return new byte[100];
    }

    public void writeToVulnerableSink(String str) throws FileNotFoundException {
        createPrintWriter(str).write(str);
    }

    private PrintWriter createPrintWriter(String str) throws FileNotFoundException {
        return new PrintWriter(createFileOutput(str));
    }

    private FileOutputStream createFileOutput(String str) throws FileNotFoundException {
        return new FileOutputStream(str);
    }
}
