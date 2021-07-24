import fly.FlyBehavior;
import quack.QuackBehavior;

public class MallardDuck extends Duck {
    public MallardDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        this.quackBehavior = quackBehavior;
        this.flyBehavior = flyBehavior;
    }

    @Override
    public void display() {
        System.out.println("청둥오리임ㅇㅇ");
    }
}
