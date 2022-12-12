import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Task_2 {
    public static void main(String[] args) {
        int n = getInt();
        System.out.println("Факториал числа " + n + " = " + getFactorial(n));
    }
    public static int getFactorial(int a) {
        int mult = 1;
        int[] numbers = IntStream.range(1, a + 1).toArray();
        for (int i = 0; i < numbers.length; i++) {
            mult *= numbers[i];
        }
        return mult;
    }
    public static int getInt() {
        Scanner sc = new Scanner(System.in);
        int number;
        while(true) {
            try {
                System.out.print("Введите любое натуральное число: ");
                number = sc.nextInt();
                if(number < 1) {
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
