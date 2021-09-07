public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("[NoQuarterState - insertQuarter()] 동전을 투입했습니다.");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("[NoQuarterState - ejectQuarter()] 동전을 투입해주시기 바랍니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("[NoQuarterState - turnCrank()] 동전을 투입한 후, 손잡이를 돌려주시기 바랍니다.");
    }

    @Override
    public void dispense() {
        System.out.println("[NoQuarterState - dispense()] 동전을 투입해주시기 바랍니다.");
    }
}
