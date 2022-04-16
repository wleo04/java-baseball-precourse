package baseball.game;

import enums.RoleStatus;
import org.junit.platform.commons.util.StringUtils;

public class GameResult {
    private int strike = 0;
    private int ball = 0;

    private final int NOT_EXIST_SCORE = 0;
    private final int OUT_STRIKE_COUNT = 3;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public boolean isOut() {
        return strike == OUT_STRIKE_COUNT;
    }

    public void write(RoleStatus status) {
        if(status.isStrike()) {
            this.strike++;
        }

        if(status.isBall()) {
            this.ball++;
        }
    }

    public String resultAsString(){
        String resultMessage = "";
        if(ball > NOT_EXIST_SCORE) {
            resultMessage = this.ball + "볼";
        }

        if(strike > NOT_EXIST_SCORE) {
            if(StringUtils.isNotBlank(resultMessage)) {
                resultMessage += " ";
            }
            resultMessage += this.strike + "스트라이크";
        }

        if(ball == NOT_EXIST_SCORE && strike == NOT_EXIST_SCORE) {
            resultMessage = "낫싱";
        }

        return resultMessage;
    }
}
