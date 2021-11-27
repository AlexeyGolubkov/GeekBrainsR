package ru.geekbrains.homework;

//by AlexeyGolubkov

class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static final void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a, b, s;
        a = 0;
        b = 0;
        s = a + b;

        if (s >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 0;
        // better cod
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    /* other cod variant
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value<=100 ) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    */
    }

    private static void compareNumbers() {
/* инициировать a и b такими значениями нельзя
        boolean a, b;
        a = false;
        b = true;
*/
        double a, b;
        a = 0.7 ;
        b = 5555/77777;

        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }
}