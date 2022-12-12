import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double a = sc.nextDouble();
        System.out.println("Введите второе число: ");
        double b = sc.nextDouble();
        System.out.println("Укажите оператор: ");
        char operator = sc.next().charAt(0);
        getAnswer(a, b, operator);
    }

    public static void getAnswer(double number1, double number2, char sign) {
        DecimalFormat format = new DecimalFormat("0.#");
        double answer = 0;
        switch (sign) {
            case '+':
                answer = number1 + number2;
                System.out.printf("Ответ:  "+format.format(number1)+" "+sign+" "+format.format(number2)+" = "+format.format(answer));
                break;
            case '-':
                answer = number1 - number2;
                System.out.printf("Ответ:  "+format.format(number1)+" "+sign+" "+format.format(number2)+" = "+format.format(answer));
                break;
            case '*':
                answer = number1 * number2;
                System.out.printf("Ответ:  "+format.format(number1)+" "+sign+" "+format.format(number2)+" = "+format.format(answer));
                break;
            case '/':
                if (number2 == 0.0) {
                    System.out.println("Деление на '0' недопустимо!");
                } else {
                    answer = number1 / number2;
                    System.out.printf("Ответ:  "+format.format(number1)+" "+sign+" "+format.format(number2)+" = "+format.format(answer));
                }
                break;
            default:
                System.out.println("Неверно выбран оператор!");
                break;
        }
    }
}

