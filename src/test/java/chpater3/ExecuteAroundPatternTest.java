package chpater3;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
import static chpater3.ExecuteAroundPattern.*;

public class ExecuteAroundPatternTest {
    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter(new FileWriter("data.txt"));
        for(int i = 0; i < 5; i++) {
            pw.println("hello world" + i);
        }
        pw.flush();
        pw.close();
    }

    @Test
    public void processFileTestSpec() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLines = processFile((br) -> br.readLine() + br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLines);
    }


}