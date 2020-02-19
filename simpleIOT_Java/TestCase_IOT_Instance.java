
import java.io.*;

/**
 * TestCase_IOT_Instance
 * <p/>
 * The results of assessing this file should be two input output stack traces -
 * one leading from getVulnerableSource to writeToVulnerableSink, and one
 * from the <external-caller> through main() to writeToVulnerableSink.
 * Unlike the TestCase_IOT_Static class, all methods in this class are not static.
 * We do not use temporaries to store the result of getVulnerableSource().
 * <p/>
 * Complexity: Easy
 */
public class TestCase_IOT_Instance {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Instance testCase = new TestCase_IOT_Instance();
            testCase.writeToVulnerableSink(testCase.getVulnerableSource());
            testCase.writeToVulnerableSink(args[0]);
        } 
        catch (Exception e) 
        {
        }
    }

    public String getVulnerableSource()
        throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream("UntaintedFileNameSource");
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public void writeToVulnerableSink(String str)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("UntaintedFileNameSink");
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
