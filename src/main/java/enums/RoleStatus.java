package enums;

public enum RoleStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing(){
        return this != NOTHING;
    }
}
