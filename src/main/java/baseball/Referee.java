package baseball;

import enums.RefereeStatus;

public class Referee {
    private final int position;
    private final int ballNumber;

    public Referee(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public RefereeStatus play(Referee referee) {
        if(this.equals(referee)) {
            return RefereeStatus.STRIKE;
        }
        if(referee.matchBallNumber(ballNumber)) {
            return RefereeStatus.BALL;
        }
        return RefereeStatus.NOTHING;
    }

    private boolean matchBallNumber(int ballNumber) {
        return this.ballNumber == ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Referee referee = (Referee) o;
        return position == referee.position && ballNumber == referee.ballNumber;
    }
}
