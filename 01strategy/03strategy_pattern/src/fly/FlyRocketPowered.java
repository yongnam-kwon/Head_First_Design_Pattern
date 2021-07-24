package fly;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("로켓으로 더 높이 날아감!");
    }
}
