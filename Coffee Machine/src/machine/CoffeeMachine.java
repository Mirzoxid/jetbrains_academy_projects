package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine(new Resource(400, 540, 120, 9, 550));
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            if (action.equals("exit")) {
                break;
            }

            switch (action) {
                case "remaining":
                    machine.printResource();
                    break;
                case "buy":
                    System.out.printf("What do you want to buy? %s back - to main menu: ", CoffeeType.getCoffieTypesByOrdeNum());
                    String coffeeType = scanner.nextLine();
                    if ("back".equals(coffeeType)) {
                        break;
                    } else {
                        machine.buyCoffee(Objects.requireNonNull(CoffeeType.findByOrderNum(Integer.parseInt(coffeeType))));
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int water = Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many ml of milk do you want to add:");
                    int milk = Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int beans = Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int cups = Integer.parseInt(scanner.nextLine());
                    machine.fillResource(water, milk, beans, cups);
                    break;
                case "take":
                    System.out.println("I gave you $" + machine.takeMoney());
                    break;
            }
        }
    }

}
