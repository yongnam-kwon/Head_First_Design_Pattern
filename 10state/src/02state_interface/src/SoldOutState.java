public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("[SoldOutState - insertQuarter()] 알맹이가 매진되었습니다. 이 동전 먹을까요?");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("[SoldOutState - ejectQuarter()] 알맹이가 매진되었습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("[SoldOutState - turnCrank()()] 알맹이가 매진되었습니다.");
    }

    @Override
    public void dispense() {
        System.out.println("[SoldOutState - dispense()] 알맹이가 매진되었습니다.");
    }
}
