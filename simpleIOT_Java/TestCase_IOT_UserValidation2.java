import java.io.*;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * TestCase_IOT_UserValidation2
 * <p/>
 * The results of assessing this file the first time should be an input output trace with the root in
 * the trace1 method.  After adding the validate method, the vulnerability and trace should go away.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_UserValidation2 {
    ResultSet resultSet;
    PrintWriter printWriter;
    FileInputStream fileInputStream;
    byte[] buffer;

    public static void main(String[] args) throws Exception {
        TestCase_IOT_UserValidation2 testCase = new TestCase_IOT_UserValidation2();
        testCase.trace1();
    }

    private void trace1() throws Exception {
        String source = getVulnerableSource();
        callValidateEventually(source);

        FileOutputStream fileOutputStream = new FileOutputStream("c:\\foo");
	    printWriter = new PrintWriter(fileOutputStream);
        writeToVulnerableSink(source);
    }

    public String getVulnerableSource() throws Exception {
        fileInputStream.read(buffer);
        return new String(buffer);
    }

    public void writeToVulnerableSink(String str) throws Exception {
        printWriter.write(str);
    }

    private void callValidateEventually(String source) throws Exception {
        callValidateAlmostThere(source);
    }

    private void callValidateAlmostThere(String source) throws Exception {
        callValidate(source);
    }

    private void callValidate(String source) throws Exception {
        validate(source);
    }

    private void validate(String source) throws Exception {
        if (source.length() > 100) {
            throw new Exception("Out of bounds");
        }
    }
}
