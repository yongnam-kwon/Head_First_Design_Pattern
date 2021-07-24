public class WoodDuck extends Duck {    // 날지도, 울지도 못하니까 Flyable, Quackable을 implement하지 않음
    @Override
    void display() {
        System.out.println("전 나무오리입니다.");
    }
}
