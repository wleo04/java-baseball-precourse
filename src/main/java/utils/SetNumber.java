package utils;

public class SetNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private int number;

    public SetNumber(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 1과 9사이의 숫자이어야 합니다");
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SetNumber setNumber = (SetNumber) o;
        return number == setNumber.number;
    }
}
