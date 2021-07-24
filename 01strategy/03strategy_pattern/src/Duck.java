import fly.FlyBehavior;
import quack.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {}

    public void swim() {
        System.out.println("헤엄침");
    }

    public abstract void display();

    public void performQuack() {    // quack() 대신
        quackBehavior.quack();
    }

    public void performFly() {  // fly() 대신
        flyBehavior.fly();
    }

    /**
     * setter 추가 → 동적으로 행동 지정 가능
     */
    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }
}
