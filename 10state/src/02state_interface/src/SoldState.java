public class SoldState implements State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("[SoldState - insertQuarter()] 알맹이가 나가고 있습니다. 잠시 후 동전을 투입해주세요.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("[SoldState - ejectQuarter()] 이미 알맹이를 뽑았습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("[SoldState - turnCrank()] 손잡이는 한 번만 돌려주세요.");
    }

    @Override
    public void dispense() {
        System.out.println("[SoldState - dispense()] 알맹이가 나가는 중입니다.");
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
