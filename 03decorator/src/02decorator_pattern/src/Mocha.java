public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        description = "Mocha";
        this.beverage = beverage;
    }

    @Override
    float cost() {
        return 0.2f + beverage.cost();
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + ", " + description;
    }
}
