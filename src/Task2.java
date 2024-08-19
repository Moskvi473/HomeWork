import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

class Sensor {
    public int getHumidity() {
        Random random = new Random();
        return random.nextInt(101);
    }
}

public class Task2 {
    public static void main(String[] args) {
        LocalDate lastWateredDate = LocalDate.of(2023, 7, 15); // Дата полива
        LocalDate currentDate = LocalDate.now();
        Sensor sensor = new Sensor();
        int humidity = sensor.getHumidity();

        System.out.println("Текущая влажность: " + humidity + "%");

        LocalDate nextWateringDate;

        switch (currentDate.getMonth()) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                nextWateringDate = lastWateredDate.plus(1, ChronoUnit.MONTHS);
                break;
            case MARCH:
            case APRIL:
            case MAY:
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                nextWateringDate = lastWateredDate.plus(1, ChronoUnit.WEEKS);
                break;
            case JUNE:
            case JULY:
            case AUGUST:
                if (humidity < 30) {
                    nextWateringDate = lastWateredDate.plus(2, ChronoUnit.DAYS);
                } else {
                    nextWateringDate = lastWateredDate.plus(1, ChronoUnit.WEEKS);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentDate.getMonth());
        }

        System.out.println("Следующая дата полива: " + nextWateringDate);
    }
}