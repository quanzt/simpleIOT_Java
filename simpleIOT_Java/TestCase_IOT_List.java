/*
 *
 *  $Id: $
 *  $DateTime: $
 *  $Author: $
 *
 *   Ounce Labs Confidential
 *
 *   Copyright (c) 2004 Ounce Labs, Inc.
 *
 *   Date Created: Jul 14, 2005  
 */

import java.io.*;
import java.util.*;

/**
 * TestCase_IOT_List
 * <p/>
 * The results of assessing this file should be a single input/output stack traces with main
 * as the root.  The taint is carried by the list collection.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_List {
    public static void main(String[] args) {
        try {
            TestCase_IOT_List testCase = new TestCase_IOT_List();
            List strs = new ArrayList();
            String file = args[0];
            strs.add(testCase.getVulnerableSource(file));
            testCase.writeToVulnerableSink(file, strs);
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

    public void writeToVulnerableSink(String fileName, List strs)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter writer = new PrintWriter(fos);
        for (Iterator i = strs.iterator(); i.hasNext();) {
            String str = (String) i.next();
            writer.write(str);
        }
        writer.close();
    }
}
