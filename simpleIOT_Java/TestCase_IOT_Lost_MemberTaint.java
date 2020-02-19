
import javax.swing.*;
import java.io.*;
import java.text.*;

/**
 * TestCase_Lost_IOT_MemberTaint
 * <p/>
 * The results of assessing this file should be three input/output stack traces with main as the root.  All three traces
 * will be reported on the source, not the sink, because the trace is lost. See TestCase_IOT_MemberTaint for more
 * information on the expected results.
 * <p/>
 * Complexity: Hard
 */
public class TestCase_IOT_Lost_MemberTaint {
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
            String file = args[0];
            String key = args[1];

            // first case
            TestCase_IOT_Lost_MemberTaint testCase = new TestCase_IOT_Lost_MemberTaint();
            TaintedStruct struct = new TaintedStruct();
            struct.m_tainted = testCase.getVulnerableSource(file);
            testCase.writeToUnknownSink1(key, struct.m_tainted);

            // second case
            TaintedStruct struct2 = new TaintedStruct(testCase.getVulnerableSource(args[0]));
            testCase.writeToUnknownSink2(struct2.getTainted());

            // third case
            TaintedStruct struct3 = new TaintedStruct();
            struct3.setTainted(testCase.getVulnerableSource(args[0]));
            testCase.writeToUnknownSink3(key, struct3.getTainted());
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

    public native void native_sink_1(String key, String str);

    public void writeToUnknownSink1(String key, String str) {
        native_sink_1(key, str);
    }

    public void writeToUnknownSink2(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    public void writeToUnknownSink3(String pattern, String str) throws Exception {
        MessageFormat fmt = new MessageFormat(str);
        fmt.parse(str);
    }
}
