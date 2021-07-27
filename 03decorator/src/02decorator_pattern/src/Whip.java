public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        description = "Whip";
        this.beverage = beverage;
    }

    @Override
    float cost() {
        return 0.54f + beverage.cost();
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + ", " + description;
    }
}
