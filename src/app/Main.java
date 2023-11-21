package app;

import java.util.Scanner;
import java.util.Locale;

//Домашнє завдання
//
//Methods

//Магазин продає товар зі знижкою, залежно від суми покупки:
//- до 5000, включно, знижка 5% від суми купівлі;
//- від 5000, виключно, до 10000, включно, знижка 10% від суми купівлі;
//- понад 10000, знижка 15% від суми покупки.

//Реалізуйте функціонал, що розраховує суму знижки, суму до оплати
//за вирахуванням знижки для певної суми купівлі.
//Розрахунки знижки та суми до оплати проводяться кожен в окремих
//методах.

//Виведіть через окремий метод наступну інформацію: загальна сума покупки,
//сума знижки, сума до оплати.
//Грошові значення, при виведенні, повинні мати два знаки після
//десяткового роздільника.

public class Main {
    static String productName;
    static double productPrice;
    static int productQuantity;
    static int discount;
    static double sum;
    static double discountSum;
    static double totalSum;
    static int count = 0;
    static String countEnding;
    public static final String CURRENCY = "EUR";

    public static void main(String[] args) {

        title();

        //Перше замовлення :
        orderInput();
        orderOutput();

        //Друге замовлення :
        orderInput();
        orderOutput();

    }

    private static void title() {
        System.out.println("\nWelcome to the \"NAVI SHOP\"! - the best hardware shop !");
    }

    private static void orderInput() {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        System.out.println("Please, input product name : ");
        productName = input.nextLine();
        do {
            System.out.println("Please, input product price per item : ");
            productPrice = input.nextDouble();
            if (productPrice <= 0) {
                System.out.println("Sorry, but price must be higher then 0...");
            }
        } while (productPrice <= 0);
        System.out.println("Please, input product quantity : ");
        productQuantity = input.nextInt();

    }

    private static void orderOutput() {

        count++;
        countEnding = theCountEnding(count);
        sum = productCostWithoutDiscount(productPrice, productQuantity);
        discount = productDiscount(sum);
        discountSum = productCostDiscount(sum, discount);
        totalSum = productTotalSum(sum, discountSum);

        System.out.printf("-------------------------%n" +
                        "Your %d%s order is :%n" +
                        "Product name : %s%n" +
                        "Product price : %s %.2f%n" +
                        "Product quantity : %d%n" +
                        "Total order cost without discount : %s %.2f%n" +
                        "Price discount : %d%%%n" +
                        "Discount sum : %s %.2f%n" +
                        "Total order sum : %s %.2f%n" +
                        "-------------------------%n", count, countEnding, productName, CURRENCY,
                productPrice, productQuantity, CURRENCY, sum, discount, CURRENCY, discountSum, CURRENCY, totalSum);
    }

    private static double productCostWithoutDiscount(double productPrice, int productQuantity) {
        return productPrice * productQuantity;
    }

    private static int productDiscount(double sum) {
        if (sum > 0 && sum <= 5000) {
            return discount = 5;
        } else if (sum > 5000 && sum <= 10000) {
            return discount = 10;
        } else {
            return discount = 15;
        }
    }

    private static double productCostDiscount(double sum, int discount) {
        return (sum / 100) * discount;
    }

    private static double productTotalSum(double sum, double discountSum) {
        return sum - discountSum;
    }

    private static String theCountEnding(int count) {
        switch (count) {
            case 1:
                countEnding = "st";
                return countEnding;
            case 2:
                countEnding = "nd";
                return countEnding;
            case 3:
                countEnding = "rd";
                return countEnding;
            default:
                countEnding = "th";
                return countEnding;
        }
    }
}