import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину забора (в см): ");
        int fenceLength = scanner.nextInt();

        int lettersLength = 15 * 62 / 3; // 15 букв, 62 см на каждые 3 буквы
        int spacesLength = 3 * 12; // 3 пробела, 12 см на каждый пробел

        int totalLength = lettersLength + spacesLength;

        if (totalLength <= fenceLength) {
            System.out.println("Надпись поместится на забор.");
        } else {
            System.out.println("Надпись не поместится на забор.");
        }
    }
}
