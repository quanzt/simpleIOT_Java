
import java.io.*;

/**
 * TestCase_IOT_MemberTaint
 * <p/>
 * The results of assessing this file should be three input/output stack traces with main as the root.  The first trace
 * uses a member variable of a class to transmit the taint directly. The second test passes the taint through the
 * constructor and gets it back using a get method. The test passes the taint though a set method and gets it back using
 * a get method.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_MemberTaint {
    public static class TaintedStruct {
        public String m_tainted = null;

        TaintedStruct() {
        }

        TaintedStruct(String tainted) {
            m_tainted = tainted;
        }

        public String getTainted() {
            return m_tainted;
        }

        public void setTainted(String tainted) {
            m_tainted = tainted;
        }
    }

    public static void main(String[] args) {
        try {
            // first case
            TestCase_IOT_MemberTaint testCase = new TestCase_IOT_MemberTaint();
            TaintedStruct struct = new TaintedStruct();
            struct.m_tainted = testCase.getVulnerableSource(args[0]);
            testCase.writeToVulnerableSink1(struct.m_tainted);

            // second case
            TaintedStruct struct2 = new TaintedStruct(testCase.getVulnerableSource(args[0]));
            testCase.writeToVulnerableSink2(struct2.getTainted());

            // third case
            TaintedStruct struct3 = new TaintedStruct();
            struct3.setTainted(testCase.getVulnerableSource(args[0]));
            testCase.writeToVulnerableSink3(struct3.getTainted());
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

    public void writeToVulnerableSink1(String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }

    public void writeToVulnerableSink2(String str) throws IOException {
        FileOutputStream fos = new FileOutputStream(str);
        fos.write(str.getBytes());
    }

    public void writeToVulnerableSink3(String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
