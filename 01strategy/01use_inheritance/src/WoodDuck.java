public class WoodDuck extends Duck {
    @Override
    void display() {
        System.out.println("저는 나무오리입니다.");
    }

    @Override
    public void fly() {
        /*
            나무오리도 날지 못하기 때문에 아무 것도 하지 못하도록 오버라이드
         */
        System.out.println("저는 날지 못해요.");
    }

    @Override
    public void quack() {
        /*
            나무오리는 꽥꽥 하지도 못함!
         */
        System.out.println("저는 꽥꽥 울지도 못해요.");
    }
}
