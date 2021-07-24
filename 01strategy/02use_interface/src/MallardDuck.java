public class MallardDuck extends Duck implements Flyable, Quackable {
    @Override
    void display() {
        System.out.println("저는 청둥오리입니다.");
    }

    @Override
    public void fly() {
        System.out.println("훨훨~");
    }

    @Override
    public void quack() {
        System.out.println("꽥꽥!");
    }
}
