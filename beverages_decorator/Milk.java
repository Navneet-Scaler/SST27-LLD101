package beverages_decorator;

public class Milk extends AddOnDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public int cost() {
        return beverage.cost() + 5;
    }
}
