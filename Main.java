import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        StringBuilder value = new StringBuilder(input.nextLine());
        StringBuilder getValue = new StringBuilder();
        for (int index : value.toString().toCharArray()) {
            getValue.append(Encryption.divider(String.valueOf(index))).append("_");
        }
        System.out.println(getValue);
        StringBuilder setValue = new StringBuilder();
         value = new StringBuilder();
        for (char index : getValue.toString().toCharArray()) {
            if (index == '_') {
                setValue.append((char)Integer.parseInt(Encryption.login(value.toString(), true)));
                value = new StringBuilder();
            } else {
                value.append(index);
            }
        }

        System.out.println(setValue);

    }
}