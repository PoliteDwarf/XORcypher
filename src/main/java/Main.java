
public class Main {
    public static void main(String[] args) {
        Encrypter test = new Encrypter(args);
        test.encrypt();
        test.setInput("output.txt");
        test.setOutput("output2.txt");
        test.encrypt();
    }
}