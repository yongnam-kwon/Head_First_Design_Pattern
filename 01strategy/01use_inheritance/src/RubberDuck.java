public class RubberDuck extends Duck {
    @Override
    void display() {
        System.out.println("저는 고무오리입니다.");
    }

    @Override
    public void fly() {
        /*
            날지 못하도록 Override를 해야...
            Why? : 고무오리는 날지 못하기 때문
         */
        System.out.println("저는 날지 못해요.");
    }
}
