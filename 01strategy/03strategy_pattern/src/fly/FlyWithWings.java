package fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("날개로 훨훨 날아다님~");
    }
}
