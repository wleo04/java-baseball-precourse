package enums;

public enum RoleStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing(){
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
