import java.io.*;
import java.lang.*;

/**
 * TestCase_IOT_Array
 * <p/>
 * The results of assessing this file should be a two input/output stack traces with main
 * as the root.  This case is equivalent to TestCase_IOT_Instance, except that the taint is
 * transmitted in an array.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_Array {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Array testCase = new TestCase_IOT_Array();
            final String file = args[0];
            String[] taintedStuff = new String[] {
                testCase.getVulnerableSource(file)
            };

            testCase.writeToVulnerableSink(file, taintedStuff);

            testCase.writeToVulnerableSink(file, taintedStuff[0]);
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

    public void writeToVulnerableSink(String fileName, String[] strs)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter writer = new PrintWriter(fos);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            writer.write(str);
        }
        writer.close();
    }

    private void writeToVulnerableSink(String file, String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
