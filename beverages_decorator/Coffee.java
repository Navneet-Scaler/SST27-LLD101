package beverages_decorator;

public class Coffee extends Beverage {

    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public int cost() {
        return 12;
    }
}
