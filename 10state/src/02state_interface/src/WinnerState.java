public class WinnerState implements State {

    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("[WinnerState - insertQuarter()] 알맹이가 나가고 있습니다. 잠시 후 동전을 투입해주세요.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("[WinnerState - ejectQuarter()] 이미 알맹이를 뽑았습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("[WinnerState - turnCrank()] 손잡이는 한 번만 돌려주세요.");
    }

    @Override
    public void dispense() {
        System.out.println("[WinnerState - dispense()] 축하드립니다~ 알맹이 1+1!! 알맹이가 나가는 중입니다.");
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() == 0) {
            System.out.println("아쉽게도 알맹이가 하나밖에 없었네요...!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if(gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("알맹이가 매진되었습니다.");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
