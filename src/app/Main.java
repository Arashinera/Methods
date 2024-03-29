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

    //Створюємо змінні класу Main :
    static int choice;
    static String productName;
    static double productPrice;
    static int productQuantity;
    static int discount;
    static double sum;
    static double discountSum;
    static double totalSum;
    static double count = 0;
    static String countEnding;
    public static final String CURRENCY = "EUR";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        //Тайтл :
        title();

        //Задаємо кількість замовлень від 1 до 10 :
        do {
            System.out.println("How many orders do you want to create (from 1 to 100)? :");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 100);

        //Задаємо цикл створення замовлень :
        for (int i = 0; i < choice; i++) {
            //Методи введеня та виведення :
            orderInput();
            orderOutput();
        }

        scanner.close();
    }

    //Метод виведення тайтлу :
    private static void title() {
        System.out.println("\nWelcome to the \"NAVI SHOP\"! - the best hardware shop !");
    }

    //Метод введення значень замовлення :
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

    //Метод виведення значень замовлення :
    private static void orderOutput() {

        count++;
        countEnding = theCountEnding(count);
        sum = productCostWithoutDiscount(productPrice, productQuantity);
        discount = productDiscount(sum);
        discountSum = productCostDiscount(sum, discount);
        totalSum = productTotalSum(sum, discountSum);

        System.out.printf("-------------------------%n" +
                        "Your %.0f%s order is :%n" +
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

    //Метод розрахунку загальної ціни без знижки :
    private static double productCostWithoutDiscount(double productPrice, int productQuantity) {
        return productPrice * productQuantity;
    }

    //Метод розрахунку значення знижки :
    private static int productDiscount(double sum) {
        if (sum > 0 && sum <= 5000) {
            return discount = 5;
        } else if (sum > 5000 && sum <= 10000) {
            return discount = 10;
        } else {
            return discount = 15;
        }
    }

    //Метод розрахунку суми знижки :
    private static double productCostDiscount(double sum, int discount) {
        return (sum / 100) * discount;
    }

    //Метод розрахунку загальної ціни зі знижкою :
    private static double productTotalSum(double sum, double discountSum) {
        return sum - discountSum;
    }

    //Метод виявлення закінчення змінної count :
    private static String theCountEnding(double count) {
        if (count % 10 == 1) {
            countEnding = "st";
        } else if (count % 10 == 2) {
            countEnding = "nd";
        } else if (count % 10 == 3) {
            countEnding = "rd";
        } else {
            countEnding = "th";
        }
        return countEnding;
    }
    }