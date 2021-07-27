public class GreenTeaOption extends CondimentDecorator {

    Beverage beverage;

    public GreenTeaOption(Beverage beverage) {
        description = "Green Tea Option";
        this.beverage = beverage;
    }

    @Override
    float cost() {
        return 0.25f + beverage.cost();
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + ", " + description;
    }
}
