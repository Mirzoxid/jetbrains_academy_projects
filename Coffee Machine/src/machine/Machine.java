package machine;

public class Machine {
    private final Resource resource;

    public Machine(Resource resource) {
        this.resource = resource;
    }

    public void printResource() {
        System.out.println("The coffee machine has:");
        resource.print();
    }

    public void buyCoffee(CoffeeType buyCoffieType) {
        if (buyCoffieType.getWater() > resource.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (buyCoffieType.getMilk() > resource.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (buyCoffieType.getBeans() > resource.getBeans()) {
            System.out.println("Sorry, not enough beans!");
        } else if (buyCoffieType.getCups() > resource.getCups()) {
            System.out.println("Sorry, not enough cups!");
        } else {
            resource.setWater(resource.getWater() - buyCoffieType.getWater());
            resource.setMilk(resource.getMilk() - buyCoffieType.getMilk());
            resource.setBeans(resource.getBeans() - buyCoffieType.getBeans());
            resource.setCups(resource.getCups() - buyCoffieType.getCups());
            resource.setMoney(resource.getMoney() + buyCoffieType.getPrice());
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public void fillResource(int water, int milk, int beans, int cups) {
        resource.setWater(resource.getWater() + water);
        resource.setMilk(resource.getMilk() + milk);
        resource.setBeans(resource.getBeans() + beans);
        resource.setCups(resource.getCups() + cups);
    }

    public int takeMoney() {
        int takenMoney = resource.getMoney();
        resource.setMoney(0);
        return takenMoney;
    }
}
