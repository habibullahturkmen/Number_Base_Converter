package converter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        int decimal = scan.nextInt();
        System.out.print("Enter target base: ");
        int targetBase = scan.nextInt();
        String result = null;
        StringBuilder remainders = new StringBuilder();

        while (result == null) {
            result = checkTargetAndConvert(decimal, targetBase, remainders);
            if (result == null) {
                System.out.print("Enter target base: ");
                targetBase = scan.nextInt();
            }
        }
        System.out.println("Conversion result: " + result);

    }

    public static String checkTargetAndConvert(int decimal, int targetBase, StringBuilder remainders) {
        if (targetBase == 2) {
            return convertToBinary(decimal, remainders);
        } else if (targetBase == 8) {
            return convertToOctal(decimal, remainders);
        } else if (targetBase == 16) {
            return convertToHexadecimal(decimal, remainders);
        } else {
            System.out.println("Wrong Base, try again!");
        }
        return null;
    }

    public static String convertToBinary(int decimal, StringBuilder remainders) {
        while (decimal >= 2) {
            remainders.append(decimal % 2);
            decimal /= 2;
        }
        remainders.append(decimal);
        remainders.reverse();
        return remainders.toString();
    }

    public static String convertToOctal(int decimal, StringBuilder remainders) {
        while (decimal >= 8) {
            remainders.append(decimal % 8);
            decimal /= 8;
        }
        remainders.append(decimal);
        remainders.reverse();
        return remainders.toString();

    }

    public static String convertToHexadecimal(int decimal, StringBuilder remainders) {
        while (decimal >= 16) {
            if (decimal % 16 == 10) {
                remainders.append("A");
            } else if (decimal % 16 == 11) {
                remainders.append("B");
            } else if (decimal % 16 == 12) {
                remainders.append("C");
            } else if (decimal % 16 == 13) {
                remainders.append("D");
            } else if (decimal % 16 == 14) {
                remainders.append("E");
            } else if (decimal % 16 == 15) {
                remainders.append("F");
            } else {
                remainders.append(decimal % 16);
            }
            decimal /= 16;
        }

        if (decimal == 10) {
            remainders.append("A");
        } else if (decimal == 11) {
            remainders.append("B");
        } else if (decimal == 12) {
            remainders.append("C");
        } else if (decimal == 13) {
            remainders.append("D");
        } else if (decimal == 14) {
            remainders.append("E");
        } else if (decimal == 15) {
            remainders.append("F");
        } else {
            remainders.append(decimal);
        }
        remainders.reverse();
        return remainders.toString();
    }

}
