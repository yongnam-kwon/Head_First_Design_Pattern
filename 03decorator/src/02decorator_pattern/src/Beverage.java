public abstract class Beverage {
    String description = "Beverage super class";

    String getDescription() {
        return this.description;
    }

    abstract float cost();

    @Override
    public String toString() {
        return getDescription() + " : $" + cost();
    }
}
