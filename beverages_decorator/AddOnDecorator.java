package beverages_decorator;

public abstract class AddOnDecorator extends Beverage {
    protected Beverage beverage;

    public AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
