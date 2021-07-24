public class RubberDuck extends Duck implements Quackable {   // 날지 못하니까 Flyable을 implement해주지 않음
    @Override
    void display() {
        System.out.println("저는 고무오리입니다.");
    }

    @Override
    public void quack() {
        System.out.println("고무오리 꽥꽥!");
    }
}
