public abstract class Duck {
    public void quack() {
        System.out.println("꽥꽥!");
    }

    public void swim() {
        System.out.println("첨벙첨벙~");
    }

    public void fly() {
        System.out.println("난다.");
    }

    abstract void display();

    // 기타 오리 관련 메소드들...
}
