public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    float cost() {
        return 1.99f;
    }
}
