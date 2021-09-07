public class GumballMachine {

    // 4개의 상태
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if(state == HAS_QUARTER) {          // 동전이 있는 상태인데 동전을 넣으려고 할 때
            System.out.println("동전은 한 개만 넣어주세요.");
        } else if(state == NO_QUARTER) {    // 동전이 없는 상태인데 동전을 넣으려고 할 때
            state = HAS_QUARTER;
            System.out.println("동전을 넣었습니다.");
        } else if(state == SOLD_OUT) {      // 매진 상태인데 동전을 넣으려고 할 때
            System.out.println("매진되었습니다. 다음 기회에!");
        } else if(state == SOLD) {          // 알맹이가 나가고 있는데 동전을 넣으려고 할 때
            System.out.println("잠깐만 기다려주세요. 알맹이가 나가고 있습니다.");
        }
    }

    public void ejectQuarter() {
        if(state == HAS_QUARTER) {          // 동전이 있는 상태인데 동전을 반환받으려고 할 때
            System.out.println("동전이 반환되고 있습니다.");
            state = NO_QUARTER;
        } else if(state == NO_QUARTER) {    // 동전이 없는 상태인데 동전을 반환받으려고 할 때
            System.out.println("동전이 없습니다. 동전을 넣어주세요.");
        } else if(state == SOLD_OUT) {      // 매진 상태인데 동전을 반환받으려고 할 때
            System.out.println("매진되었습니다.");
        } else if(state == SOLD) {          // 알맹이가 나가고 있는데 동전을 반환받으려고 할 때
            System.out.println("동전이 없습니다.");
        }
    }

    public void turnCrank() {
        if(state == HAS_QUARTER) {          // 동전이 있는 상태인데 손잡이를 돌릴 때
            System.out.println("손잡이를 이미 돌렸습니다. 곧 알맹이가 나갑니다.");
            state = SOLD;
            dispense();
        } else if(state == NO_QUARTER) {    // 동전이 없는 상태인데 손잡이를 돌릴 때
            System.out.println("동전을 넣은 후 손잡이를 돌려주세요.");
        } else if(state == SOLD_OUT) {      // 매진 상태인데 손잡이를 돌릴 때
            System.out.println("매진되었습니다.");
        } else if(state == SOLD) {          // 알맹이가 나가고 있는데 손잡이를 돌릴 때
            System.out.println("손잡이는 한 번만 돌려주세요. 알맹이가 나가고 있습니다.");
        }
    }

    public void dispense() {
        if(state == HAS_QUARTER) {          // 동전이 있는 상태인데 알맹이 나가게 할 때
            System.out.println("손잡이를 돌려주세요.");
        } else if(state == NO_QUARTER) {    // 동전이 없는 상태인데 알맹이 나가게 할 때
            System.out.println("동전을 넣고, 손잡이를 돌려주세요.");
        } else if(state == SOLD_OUT) {      // 매진 상태인데 알맹이 나가게 할 때
            System.out.println("매진되었습니다.");
        } else if(state == SOLD) {          // 알맹이가 나가고 있는데 알맹이 나가게 할 때
            System.out.println("알맹이가 이미 나가고 있습니다.");
            count--;
            if(count == 0) {
                state = SOLD_OUT;
                System.out.println("알맹이가 더 이상 없습니다.");
            } else {
                state = NO_QUARTER;
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        if(state == SOLD_OUT) str = "SOLD_OUT";
        else if(state == NO_QUARTER) str = "NO_QUARTER";
        else if(state == HAS_QUARTER) str = "HAS_QUARTER";
        else if(state == SOLD) str = "SOLD";
        return "GumballMachine{" +
                "state=" + str +
                ", count=" + count +
                '}';
    }
}
