package baseball;

import enums.RefereeStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    private Referee referee;

    @BeforeEach
    public void setUp() {
        referee = new Referee(1, 4);
    }

    @Test
    public void strike() {
        RefereeStatus status = referee.play(new Referee(1, 4));
        assertThat(status).isEqualTo(RefereeStatus.STRIKE);
    }

    @Test
    public void ball() {
        RefereeStatus status = referee.play(new Referee(2, 4));
        assertThat(status).isEqualTo(RefereeStatus.BALL);
    }

    @Test
    public void nothing() {
        RefereeStatus status = referee.play(new Referee(2, 5));
        assertThat(status).isEqualTo(RefereeStatus.NOTHING);
    }
}
