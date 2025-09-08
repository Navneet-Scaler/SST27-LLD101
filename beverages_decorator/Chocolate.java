package beverages_decorator;

public class Chocolate extends Beverage {

    @Override
    public String getDescription() {
        return "Hot Chocolate";
    }

    @Override
    public int cost() {
        return 15;
    }
}
