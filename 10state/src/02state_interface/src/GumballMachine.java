public class GumballMachine {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State winnerState;
    State soldState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (this.count > 0) state = noQuarterState;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }
    void releaseBall() {
        System.out.println("[GumballMachine - releaseBall()] 알맹이가 나가고 있습니다.");
        if(count > 0) {
            count = count - 1;
        }
    }

    // Getter
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getSoldState() {
        return soldState;
    }

    int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String str = "";
        if(state == soldOutState) str = "SOLD_OUT";
        else if(state == noQuarterState) str = "NO_QUARTER";
        else if(state == hasQuarterState) str = "HAS_QUARTER";
        else if(state == soldState) str = "SOLD";
        else if(state == winnerState) str = "WINNER_STATE";
        return "GumballMachine{" +
                "state=" + str +
                ", count=" + count +
                '}';
    }
}
