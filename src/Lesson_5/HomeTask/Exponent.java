package Lesson_5.HomeTask;

public class Exponent {
    public static void main(String[] args) {
        System.out.println(Exponentiation(10, 2));
    }

//    Дробную степень задать не могу, аргумент int
    public static double Exponentiation(int root, int pow) {
        if (pow == 0)
            return 1;

        if(pow < 0) {
            double result = 0;
            pow = pow * (-1);
            if(pow == 1)
                result = (double) 1 / root;
            else
                result = (double) 1 / (root * Exponentiation(root, pow - 1));
            return result;
        }

        if(pow == 1)
            return root;
        else
            return root * Exponentiation(root, pow - 1);
    }
}
