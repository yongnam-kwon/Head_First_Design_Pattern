import java.util.Random;

public class HasQuarterState implements State {

    GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("[HasQuarterState - insertQuarter()] 동전은 하나만 투입해주시기 바랍니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("[HasQuarterState - ejectQuarter()] 동전이 반환됩니다.");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("[HasQuarterState - turnCrank()] 손잡이를 돌렸습니다. 알맹이가 곧 나갑니다.");
//        gumballMachine.setState(gumballMachine.getSoldState());

        int winner = randomWinner.nextInt(10);  // 0 ~ 9 사이의 값 난수 발생
        if((winner == 0) && (gumballMachine.getCount() >= 2)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("[HasQuarterState - dispense()] 손잡이를 돌려야 알맹이가 나갑니다.");
    }
}
