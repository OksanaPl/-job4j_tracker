package kata;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//        Создай консольное приложение “Калькулятор”. Приложение должно читать из консоли введенные пользователем строки,
//        числа, арифметические операции проводимые между ними и выводить в консоль результат их выполнения.
//        Реализуй класс Main с методом public static String calc(String input).
//        Метод должен принимать строку с арифметическим выражением между двумя числами и возвращать строку
//        с результатом их выполнения. Ты можешь добавлять свои импорты, классы и методы.
//        Добавленные классы не должны иметь модификаторы доступа (public или другие)
//
//        Требования:
//    *    Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
//    *    a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)! Решения,
//    *    в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.

//    *    Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
//     *   Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
//     *   На выходе числа не ограничиваются по величине и могут быть любыми.
//     *   Калькулятор умеет работать только с целыми числами.

//     *   Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
//     *   при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
//
//        При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно,
//     *   при вводе арабских - ответ ожидается арабскими.
//     *   При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
//     *   При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
//     *   приложение выбрасывает исключение и завершает свою работу.
//    *    Результатом операции деления является целое число, остаток отбрасывается.
//     *   Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
//     *   Результатом работы калькулятора с римскими числами могут быть только положительные числа,
//     *   если результат работы меньше единицы, выбрасывается исключение

class Main {
    static List<String> romans = List.of("O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");

    public static void main(String[] args) {
        System.out.println("Введите пример:");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(calc(a));
    }

    public static String calc(String input) {
        List<String> inputList = Arrays.asList(input.split(""));
        String[] operands = input.split("[+-/*]");
        String first = operands[0];
        String second = operands[1];

        if (romans.contains(first) && !romans.contains(second) || romans.contains(second) && !romans.contains(first)) {
            throw new RuntimeException("Некорректный ввод! Числа должны быть либо римскими либо арабскими !");
        }

        boolean isRome = false;
        for (String r: romans) {
            if (r.equals(first)) {
                isRome = true;
                break;
            }
        }

        int num1 = isRome ? romans.indexOf(first) : Integer.parseInt(first);
        int num2 = isRome ? romans.indexOf(second) : Integer.parseInt(second);

        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new RuntimeException("Некорректный ввод! Числа должны быть от 1 до 10 !");
        }

        int result = 0;
        if (inputList.contains("+")) {
            result = num1 + num2;
        } else if (inputList.contains("-")) {
            result = num1 - num2;
        } else if (inputList.contains("*")) {
            result = num1 * num2;
        } else if (inputList.contains("/")) {
            result = num1 / num2;
        }

        if (isRome && result < 1) {
            throw new RuntimeException("Некорректный ввод! Результат с римскими цифрами не может быть меньше единицы !");
        }

        return isRome ? convertNumberToRoman(result) : String.valueOf(result);
    }

    static String convertNumberToRoman(int numArabian) {
        return romans.get(numArabian);
    }
}



