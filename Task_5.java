import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double a = sc.nextDouble();
        System.out.println("Введите второе число: ");
        double b = sc.nextDouble();
        System.out.println("Укажите оператор: ");
        char operator = sc.next().charAt(0);
        String operand = Character.toString(operator);
        double result = getAnswer(a, b, operator);
        String equation = getReadyEquation(a, b, operator);
        System.out.println("Исходное уравнение: "+equation);
        String[] st1 = new String[0];
        if (operator == '+') {
            st1 = equation.split("\\+");
        }
        else if (operator == '-') {
            st1 = equation.split("\\-");
        }
        else if (operator == '*') {
            st1 = equation.split("\\*");
        }
        else if (operator == '/') {
            st1 = equation.split("\\/");
        }
        String[] st2 = st1[1].split("=");
        String[] st3 = new String[3];
        st3[0] = st1[0];
        st3[1] = st2[0];
        st3[2] = st2[1];
        String equat = Arrays.toString(st3);
        String equat1 = changeString(equat);
        String[] st4 = equat1.split(" ");
        String new_equat = st4[0]+operator+st4[1]+"="+st4[2];
        System.out.println("Новое уравнение со скрытыми цифрами: "+new_equat);
        String new_equat1 = MissingDigit(st4, operator);
        System.out.println("Уравнение с восстановленными значениями: "+new_equat1);
    }

    public static String getReadyEquation(double number1, double number2, char sign) {
        DecimalFormat format = new DecimalFormat("0.#");
        double answer;
        String s = "";
        switch (sign) {
            case '+':
                answer = number1 + number2;
                s = format.format(number1)+sign+format.format(number2)+"="+format.format(answer);
                break;
            case '-':
                answer = number1 - number2;
                s = format.format(number1)+sign+format.format(number2)+"="+format.format(answer);
                break;
            case '*':
                answer = number1 * number2;
                s = format.format(number1)+sign+format.format(number2)+"="+format.format(answer);
                break;
            case '/':
                if (number2 == 0.0) {
                    System.out.println("Деление на '0' недопустимо!");
                } else {
                    answer = number1 / number2;
                    s = format.format(number1)+sign+format.format(number2)+"="+format.format(answer);
                }
                break;
            default:
                System.out.println("Неверно выбран оператор!");
                break;
        }
        return s;
    }
    public static double getAnswer(double number1, double number2, char sign) {
        DecimalFormat format = new DecimalFormat("0.#");
        double answer = 0;
        switch (sign) {
            case '+':
                answer = number1 + number2;
                break;
            case '-':
                answer = number1 - number2;
                break;
            case '*':
                answer = number1 * number2;
                break;
            case '/':
                if (number2 == 0.0) {
                    System.out.println("Деление на '0' недопустимо!");
                } else {
                    answer = number1 / number2;
                }
                break;
            default:
                System.out.println("Неверно выбран оператор!");
                break;
        }
        return answer;
    }
    public static String changeString(String line)
    {
        String line1 = line.replace("[", "").replace("]", "").replace(",", "");
        Random sRand = new Random();
        int x = sRand.nextInt(line1.length());
        String line2 = line1.substring(0, x) + "?" + line1.substring(x + 1);
        return line2;
    }

    public static String MissingDigit(String[] line, char operand) {
        DecimalFormat format = new DecimalFormat("0.#");
        double result;
        String res;
        if (line[2].contains("?")) {
            if (operand == '+') {
                result = Double.parseDouble(line[0]) + Double.parseDouble(line[1]);
                line[2] = format.format(result) + "";
            } else if (operand == '-') {
                result = Double.parseDouble(line[0]) - Double.parseDouble(line[1]);
                line[2] = format.format(result) + "";
            } else if (operand == '*') {
                result = Double.parseDouble(line[0]) * Double.parseDouble(line[1]);
                line[2] = format.format(result) + "";
            } else if (operand == '/') {
                result = Double.parseDouble(line[0]) / Double.parseDouble(line[1]);
                line[2] = format.format(result) + "";
            }
        }
        else if (line[0].contains("?")) {
            if (operand == '+') {
                result = Double.parseDouble(line[2]) - Double.parseDouble(line[1]);
                line[0] = format.format(result) + "";
            }
            if (operand == '-') {
                result = Double.parseDouble(line[2]) + Double.parseDouble(line[1]);
                line[0] = format.format(result) + "";
            }
            if (operand == '*') {
                result = Double.parseDouble(line[2]) / Double.parseDouble(line[1]);
                line[0] = format.format(result) + "";
            }
            if (operand == '/') {
                result = Double.parseDouble(line[2]) * Double.parseDouble(line[1]);
                line[0] = format.format(result) + "";
            }
        }
        else if (line[1].contains("?")) {
            if (operand == '+') {
                result = Double.parseDouble(line[2]) - Double.parseDouble(line[0]);
                line[1] = format.format(result) + "";
            } else if (operand == '-') {
                result = Double.parseDouble(line[0]) - Double.parseDouble(line[2]);
                line[1] = format.format(result) + "";
            } else if (operand == '*') {
                result = Double.parseDouble(line[2]) / Double.parseDouble(line[0]);
                line[1] = format.format(result) + "";
            } else if (operand == '/') {
                result = Double.parseDouble(line[0]) / Double.parseDouble(line[2]);
                line[1] = format.format(result) + "";
            }
        }
        res = line[0]+operand+line[1]+"="+line[2];
        return res;
    }
}
