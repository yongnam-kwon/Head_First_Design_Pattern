import fly.FlyBehavior;
import fly.FlyNoWay;
import fly.FlyWithWings;
import quack.MuteQuack;
import quack.Quack;

public class MiniDuckSimulator {
    public static void main(String[] args) {    // EX
        Duck mallardDuck = new MallardDuck(new MuteQuack(), new FlyNoWay());
        mallardDuck.performQuack();
        mallardDuck.performFly();

        /**
         * 다형성 : 같은 메서드를 호출하였지만, 다른 것이 실행
         */
        mallardDuck.setQuackBehavior(new Quack());
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.performQuack();
        mallardDuck.performFly();

    }
}
