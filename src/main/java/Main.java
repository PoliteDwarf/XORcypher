import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите команду в следующем формате: [-d]||[-c] KeyName InputFileName.txt (-o OutputFileName.txt)");
        Scanner in= new Scanner(System.in);
        String input = in.nextLine();
        new Encrypter(input);
    }
}
