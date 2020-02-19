import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

public class TestCase_IOT_UserValidation {
    ResultSet resultSet;
    FileInputStream fileInputStream;
    PrintWriter printWriter;
    byte[] buffer;

    public static void main(String[] args) throws Exception {
        TestCase_IOT_UserValidation testCase = new TestCase_IOT_UserValidation();
        testCase.trace1();

        TestCase_IOT_UserValidation testCase2 = new TestCase_IOT_UserValidation();
        testCase2.trace2();

        TestCase_IOT_UserValidation testCase3 = new TestCase_IOT_UserValidation();
        testCase3.trace3();
    }

    private void trace1() throws Exception {
        String source = getVulnerableSource1();
        validate(source);
        writeToVulnerableSink(source);
    }

    private void trace2() throws Exception {
        String source = getVulnerableSource2();
        validate(source);
        writeToVulnerableSink(source);
    }

    private void trace3() throws Exception {
        String source = getVulnerableSource3();
        validate(source);
        writeToVulnerableSink(source);
    }

    public String getVulnerableSource1() throws Exception {
        fileInputStream.read(buffer);
        return new String(buffer);
    }

    public String getVulnerableSource2() throws Exception {
        fileInputStream.read(buffer);
        return new String(buffer);
    }

    public String getVulnerableSource3() throws Exception {
        return resultSet.getString("x");
    }

    public void writeToVulnerableSink(String str) throws Exception {
        printWriter.write(str);
    }

    private void validate(String source) throws Exception {
        // validate
    }
}
