import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Lexemes {
    public static void main(String[] args) {
        String fString;
        String sString;
        int number;
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> numbersInBinarry = new ArrayList<>();
        ArrayList<String> russianWords = new ArrayList<>();
        System.out.println("Введите первую строку:");
        Scanner sc = new Scanner(System.in);
        fString = sc.nextLine();
        System.out.println("Введите строку делителей:");
        sString = sc.nextLine();
        System.out.println("Введите целое число:");
        number = Integer.valueOf(sc.nextLine());
        String[] buffer = fString.split("[" + sString + "]+");
        System.out.print("Введенная строка:");
        System.out.println(Arrays.toString(buffer));
        words.addAll(Arrays.asList(buffer));
        int differenceByRemoved = 0;
        for (int i = 0; i < buffer.length; i++) {
            boolean isNumber = true;
            for (int j = 0; j < buffer[i].length(); j++)
                if (!Character.isDigit(buffer[i].charAt(j))) {
                    isNumber = false;
                    break;
                }
            if (isNumber) {
                words.remove(i - differenceByRemoved);
                differenceByRemoved++;
                numbers.add(buffer[i]);
            }
        }
        System.out.println("Не числа: " + words.toString());
        System.out.println("Числа: " + numbers.toString());
        for (int i = 0; i < numbers.size(); i++)
            try {
                int temp = Integer.parseInt(numbers.get(i), 2);
                numbersInBinarry.add(numbers.get(i));
            } catch (NumberFormatException nfex) {
            }

        System.out.println("Числа в двоичной: " + numbersInBinarry.toString());
        for (int i = 0; i < words.size(); i++) {
            boolean isRussian = true;
            for (int j = 0; j < words.get(i).length(); j++) {
                int valueOfChar = words.get(i).charAt(j);
                if (!(valueOfChar <= 1103 && valueOfChar >= 1040)) {
                    isRussian = false;
                }
            }
            if (isRussian) {
                russianWords.add(words.get(i));
            }
        }
        System.out.println("Слова русскими буквами: " + russianWords.toString());
        int positionOfNumber;
        int positionOfLowest = 0;
        StringBuffer stringOfNumbers = new StringBuffer(numbers.toString());
        System.out.println(stringOfNumbers);
        positionOfNumber = stringOfNumbers.indexOf(String.valueOf(number));
        stringOfNumbers.replace(positionOfNumber + String.valueOf(number).length(), positionOfNumber + String.valueOf(number).length(), ", " + String.valueOf(-number));
        for (int i = 0; i < numbers.size(); i++) {
                if (Integer.valueOf(numbers.get(i).toString()) < number)
                    positionOfLowest = i;
        }
        if(positionOfLowest==0) {
            System.out.println("Введено минимальное значение");
            System.exit(0);
        }
        int positionOfLowestOld = positionOfLowest;
        positionOfLowest = stringOfNumbers.indexOf(numbers.get(positionOfLowest).toString());
        stringOfNumbers.replace(positionOfLowest-2,positionOfLowest+numbers.get(positionOfLowestOld).toString().length(),"");
        System.out.println("Ряд после преобразований: "+stringOfNumbers);
    }
}
