public class Task_3 {
    public static void main(String[] args) {
        int z = 1000;
        System.out.print("Набор простых чисел от 1 до " + z + ": ");
        getPrimeNumbers(z);
    }

    public static void getPrimeNumbers(int a) {
        for (int j = 2; j <= a; j++) {
            int count = 0;
            for (int i = 1; i <= j; i++) {
                if (j % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(j + " ");
                }
        }
    }
}
