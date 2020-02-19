import java.io.*;

/**
 * TestCase_IOT_XFile_Part2
 * <p/>
 * Part of TestCase_IOT_XFile_Part1
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_XFile_Part2 {
    public void writeToVulnerableSink(String str)
        throws FileNotFoundException
    {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
