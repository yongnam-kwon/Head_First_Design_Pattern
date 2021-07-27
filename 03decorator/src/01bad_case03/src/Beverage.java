public abstract class Beverage {
    String description;

    String getDescription() {
        return this.description;
    }
    abstract float cost();
}