package lesson_5;

public class MainDegree {

    public static void main(String[] args) {

        System.out.println(calculation(0, -1));
        System.out.println(calculation(0, 0));
        System.out.println(calculation(2, 3));
        System.out.println(calculation(2, -3));

    }

    private static double calculation(double n, int x) {
        if (n == 0 && x > 0) {
            return 0;
        }
        if (x < 0) {
            return 1 / (n * calculation(n, -x - 1));// 1/(n*n)
        } else if (x > 0) {
            return n * calculation(n, x - 1);//n*n
        }
        return 1;

    }
}
