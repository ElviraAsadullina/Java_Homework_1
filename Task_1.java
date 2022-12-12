import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.InputMismatchException;

public class Task_1 {
    public static void main(String[] args) {
        int n = getInt();
        System.out.println("Треугольное число от " + n + " = " + getSum(n));
    }
    public static int getSum(int a) {
        int sum = 0;
        int[] numbers = IntStream.range(1, a + 1).toArray();
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
    public static int getInt() {
        Scanner sc = new Scanner(System.in);
        int number;
        while(true) {
            try {
                System.out.print("Введите любое натуральное число: ");
                number = sc.nextInt();
                if(!sc.hasNextInt()) {
                    throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException e) {
                System.out.println("Ошибка ввода! Попробуйте снова!");
                sc.nextLine();
            }
        }
        return number;
    }
}