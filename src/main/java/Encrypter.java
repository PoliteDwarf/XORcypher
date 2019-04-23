import java.io.*;
import java.util.Arrays;

public class Encrypter {
    private char[] key;
    private String InputFileName, OutputFileName;

    Encrypter() {
        key = "".toCharArray();
        OutputFileName = Arrays.toString(key) + ".txt";
    }

    Encrypter(String input) {
        int flag = 0;
        String[] parsed = input.split(" ");
        for (String s : parsed) {
            if (flag == 1) {
                key = s.toCharArray();
                OutputFileName = s + ".txt";
                flag = 0;
                continue;
            }
            else if (flag == 2) {
                OutputFileName = s;
                flag = 0;
                continue;
            }
            else if (s.contains(".txt")) {
                InputFileName = s;
                flag = 0;
                continue;
            }
            if ((s.equals("-c")) || (s.equals("-d"))) flag = 1;
            if (s.equals("-o")) flag = 2;
        }
        Encrypt();
    }

    private void Encrypt(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(InputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(OutputFileName));
            String line = reader.readLine();
            while (line != null){
                char[] rez = line.toCharArray();
                for (int i = 0; i < line.length(); i++){
                    rez[i] = (char) (line.charAt(i) ^ key[i % key.length]);
                }
                writer.write(rez);
                writer.newLine();
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
