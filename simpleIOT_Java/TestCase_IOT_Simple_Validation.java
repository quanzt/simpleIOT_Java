
import java.io.*;

/**
 * TestCase_IOT_Simple_Validation
 * <p/>
 * The results of assessing this file should be no vulnerability. 
 * The validate() method must be tied as a validation rouine
 * to the fis.read call in getCoveredVulnerableSource().
 * <p/>
 * Complexity: Medium
 */
public class TestCase_IOT_Simple_Validation {
    public static void main(String[] args) {
        try {
            testSinkValidated();
        } catch (Exception e) {
        }
    }
    
    /**
     *  In this case, external data goes through a validation routine before
     *  reaching a sink.
     *  <p/>
     *  There should be no vulnerability derived from this call, when
     *  the validate() method is specified as a validation routine.
     *
     */
    private static void testSinkValidated()
    {
        try {
            TestCase_IOT_Simple_Validation testCase = new TestCase_IOT_Simple_Validation();
            String file = "SomeUntaintedFileName";
            String source = testCase.getCoveredVulnerableSource(file);
            testCase.validate(source);
            testCase.writeToVulnerableSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     * This is used as a source of input for which the input call
     * has an associated validation routine. For the test to get expected
     * results, the validate() method should be associated with the specific read()
     * call inside this method.
     */
    public String getCoveredVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf); // Tie validate() to this read() call
        fis.close();

        String ret = new String(buf);
        return ret;
    }

    public void writeToVulnerableSink(String file, String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.print(str);
    }

    private void validate(String source) throws Exception {
        if (source.length() > 100) {
            throw new Exception("Length too long: " + source.length());
        }
    }

} // class TestCase_IOT_Simple_Validation
