import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.print("Раунд " + round + " - Введите ваш выбор (К - камень, Н - ножницы, Б - бумага): ");
            String userChoice = scanner.next().toUpperCase();
            String computerChoice = getRandomChoice(random);

            System.out.println("Компьютер выбрал: " + computerChoice);

            int roundResult = getRoundResult(userChoice, computerChoice);
            if (roundResult > 0) {
                userScore += roundResult;
                System.out.println("Вы выиграли этот раунд!");
            } else if (roundResult < 0) {
                computerScore += -roundResult;
                System.out.println("Компьютер выиграл этот раунд!");
            } else {
                System.out.println("Ничья!");
            }
        }

        System.out.println("Итоговый счет: Вы - " + userScore + ", Компьютер - " + computerScore);
        if (userScore > computerScore) {
            System.out.println("Вы победили!");
        } else if (userScore < computerScore) {
            System.out.println("Компьютер победил!");
        } else {
            System.out.println("Ничья!");
        }
    }

    private static String getRandomChoice(Random random) {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0: return "К";
            case 1: return "Н";
            case 2: return "Б";
            default: throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    private static int getRoundResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return 0;
        }

        switch (userChoice) {
            case "К":
                return computerChoice.equals("Н") ? 1 : -5;
            case "Н":
                return computerChoice.equals("Б") ? 2 : -1;
            case "Б":
                return computerChoice.equals("К") ? 5 : -2;
            default:
                throw new IllegalArgumentException("Unexpected user choice: " + userChoice);
        }
    }
}