import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Tests {

    public void assertEqualsFile(String FirstFile, String SecondFile) {
        try {
            FileInputStream one = new FileInputStream(FirstFile);
            FileInputStream two = new FileInputStream(SecondFile);
            int symbOne = one.read();
            int symbTwo = two.read();
            while (symbOne != -1 || symbTwo != -1) {
                assertEquals(symbOne, symbTwo);
                symbOne = one.read();
                symbTwo = two.read();
            }
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void Test() {
        Encrypter test = new Encrypter("-c Key testInput.txt -o testOutput.txt".split(" "));
        test.encrypt();
        assertEqualsFile("testOutput.txt", "testExpectedOutput.txt");
        test = new Encrypter("-c Newkey testInput2.txt -o testOutput2.txt".split(" "));
        test.encrypt();
        assertEqualsFile("testOutput2.txt", "testExpectedOutput2.txt");
        test = new Encrypter("-c AnotherKey testInput3.txt -o testOutput3.txt".split(" "));
        test.encrypt();
        assertEqualsFile("testOutput3.txt", "testExpectedOutput3.txt");
        test = new Encrypter("-c WtfisThisKey testInput4.txt -o testOutput4.txt".split(" "));
        test.encrypt();
        assertEqualsFile("testOutput4.txt", "testExpectedOutput4.txt");
        test = new Encrypter("-c LeagueOfLegends testInput5.txt -o testOutput5.txt".split(" "));
        test.encrypt();
        assertEqualsFile("testOutput5.txt", "testExpectedOutput5.txt");
    }
}
