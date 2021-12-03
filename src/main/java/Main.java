import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Да се състави програма на Java, чрез която се въвеждат 2 числа с [10..70] цифри. ако N е броя цифри на по-малкото число,
//програма да използва само първите N цифри от двете числа по следния начин.
//Умножава 1-та цифра от 1-то число с последната цифра на второто число. Ако това произведение е >10 числото се редуцира до сбор от цифрите си.
//Продължава с 2-та цифра отляво на 1-то число и т.н.
//Да се изведат резултатите от всяка новополучена цифра. Пример: при 123456789 и 987654321 се извежда:149779419.
//Пример: 123456789 987654321 Изход: 149779419

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        //it is not explained how exactly are the two numbers entered so I looked at the example
        String[] lineEntries = reader.readLine().split(" ");

        String stringOne;
        String stringTwo;
        if (lineEntries.length >= 2) {
            stringOne = lineEntries[0];
            stringTwo = lineEntries[1];
        } else {
            throw new IllegalArgumentException("The entries you submitted are not in the desired pattern");
        }

        int shorterSize = Math.min(stringOne.length(), stringTwo.length());
        stringOne = stringOne.substring(0, shorterSize);
        stringTwo = new StringBuilder(stringTwo.substring(0, shorterSize)).reverse().toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shorterSize; i++) {
            int a = Character.getNumericValue(stringOne.charAt(i));
            int b = Character.getNumericValue(stringTwo.charAt(i));
            int product = a * b;
            //in the example it is said that the number should be grater than 10 to reduce its digits
            //but the result example is calculated with number grater or equal to 10
            while (product >= 10) {
                int tens = product / 10;
                int ones = product % 10;
                product = tens + ones;
            }
            result.append(product);
        }

        System.out.println("Result: " + result);
    }
}
