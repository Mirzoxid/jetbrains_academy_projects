package machine;

public enum CoffeeType {
    ESPRESSO(1, 250, 0, 16, 1, 4),
    LATTE(2, 350, 75, 20, 1, 7),
    CAPPUCCINO(3, 200, 100, 12, 1, 6);

    CoffeeType(int orderNum, int water, int milk, int beans, int cups, int price) {
        this.orderNum = orderNum;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.price = price;
    }

    private final int orderNum;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;
    private final int price;

    public static String getCoffieTypesByOrdeNum() {
        StringBuilder ordTxt = new StringBuilder();
        for (CoffeeType value : CoffeeType.values()) {
            ordTxt.append(String.format("% d - %s,", value.orderNum, value.name().toLowerCase()));
        }
        return ordTxt.toString();
    }

    public static CoffeeType findByOrderNum(int orderNum) {
        for (CoffeeType type : CoffeeType.values()) {
            if (orderNum == type.orderNum) {
                return type;
            }
        }
        return null;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getPrice() {
        return price;
    }
}
