package baseball;

import baseball.game.Role;
import enums.RoleStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {
    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role(1, 4);
    }

    @Test
    public void strike() {
        RoleStatus status = role.play(new Role(1, 4));
        assertThat(status).isEqualTo(RoleStatus.STRIKE);
    }

    @Test
    public void ball() {
        RoleStatus status = role.play(new Role(2, 4));
        assertThat(status).isEqualTo(RoleStatus.BALL);
    }

    @Test
    public void nothing() {
        RoleStatus status = role.play(new Role(2, 5));
        assertThat(status).isEqualTo(RoleStatus.NOTHING);
    }
}
