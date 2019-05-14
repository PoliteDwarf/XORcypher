import java.io.*;
import java.util.Arrays;

public class Encrypter {
    private char[] key;
    private String InputFileName, OutputFileName;
    enum Flag {
        KEY, OUTPUT, NONE
    }

    Encrypter(String[] input) {
        Flag flag = Flag.NONE;
        for (String s : input) {
            if (flag == Flag.KEY) {
                key = s.toCharArray();
                OutputFileName = s;
                flag = Flag.NONE;
            }
            else if (flag == Flag.OUTPUT) {
                OutputFileName = s;
                flag = Flag.NONE;
            }
            else if ((s.equals("-c")) || (s.equals("-d"))) flag = Flag.KEY;
            else if (s.equals("-o")) flag = Flag.OUTPUT;
            else {
                InputFileName = s;
            }
        }
    }

    void encrypt(){
        try {
            FileInputStream reader = new FileInputStream("src/test/java/" + InputFileName);
            FileOutputStream writer = new FileOutputStream("src/test/java/" + OutputFileName);
            int i = 0;
            int symb = reader.read();
            while (symb != -1){
                symb = (char) (symb ^ key[i % key.length]);
                i++;
                writer.write(symb);
                symb = reader.read();
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void setKey(String string) {
        key = string.toCharArray();
    }

    void setInput(String string) {
        InputFileName = string;
    }

    void setOutput(String string) {
        OutputFileName = string;
    }
}
