public class Main {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.toString());

        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.toString());

        espresso = new Mocha(espresso);
        System.out.println(espresso.toString());

        houseBlend = new Mocha(houseBlend);
        System.out.println(houseBlend.toString());

        System.out.println("==========main==========");

        Beverage frappuccino = new Frappuccino();
        System.out.println(frappuccino.toString());

        frappuccino = new GreenTeaOption(frappuccino);
        System.out.println(frappuccino.toString());

        frappuccino = new Whip(frappuccino);
        System.out.println(frappuccino.toString());
        frappuccino = new Whip(frappuccino);
        System.out.println(frappuccino.toString());

        System.out.println("==========main1==========");

        Beverage frappuccino1 = new Frappuccino();
        System.out.println(frappuccino1.toString());

        frappuccino1 = new Whip(frappuccino1);
        System.out.println(frappuccino1.toString());

        frappuccino1 = new GreenTeaOption(frappuccino1);
        System.out.println(frappuccino1.toString());
    }
}
