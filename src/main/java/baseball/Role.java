package baseball;

import enums.RoleStatus;
import java.util.Objects;

public class Role {
    private final int position;
    private final SetNumber ballNumber;

    public Role(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = new SetNumber(ballNumber);
    }

    public RoleStatus play(Role role) {
        if(this.equals(role)) {
            return RoleStatus.STRIKE;
        }
        if(role.matchBallNumber(ballNumber)) {
            return RoleStatus.BALL;
        }
        return RoleStatus.NOTHING;
    }

    private boolean matchBallNumber(SetNumber ballNumber) {
        return this.ballNumber.equals(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return position == role.position && Objects.equals(ballNumber, role.ballNumber);
    }
}
