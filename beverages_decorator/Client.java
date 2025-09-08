package beverages_decorator;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Choose base drink
        System.out.println("Choose a drink:");
        System.out.println("1. Coffee");
        System.out.println("2. Cappuccino");
        System.out.println("3. Latte");
        System.out.println("4. Hot Chocolate");
        int choice = sc.nextInt();

        Beverage beverage = null;
        switch (choice) {
            case 1 -> beverage = new Coffee();
            case 2 -> beverage = new Cappuccino();
            case 3 -> beverage = new Latte();
            case 4 -> beverage = new Chocolate();
            default -> {
                System.out.println("Invalid choice.");
                System.exit(0);
            }
        }

        // Add-ons selection
        boolean adding = true;
        while (adding) {
            System.out.println("\nAdd-ons:");
            System.out.println("1. Milk (+5)");
            System.out.println("2. Sugar (+2)");
            System.out.println("3. Whipped Cream (+7)");
            System.out.println("4. Done");
            int addon = sc.nextInt();

            switch (addon) {
                case 1 -> beverage = new Milk(beverage);
                case 2 -> beverage = new Sugar(beverage);
                case 3 -> beverage = new WhippedCream(beverage);
                case 4 -> adding = false;
                default -> System.out.println("Invalid choice");
            }
        }

        // Final order
        System.out.println("\nYour Order: " + beverage.getDescription());
        System.out.println("Total Cost: " + beverage.cost());

        sc.close();
    }
}
