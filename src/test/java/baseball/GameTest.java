package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import enums.RoleStatus;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void play() {
        Game game = new Game(Arrays.asList(5, 3, 8));
        GameResult result = game.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void play_nothing() {
        Game game = new Game(Arrays.asList(5, 3, 8));
        GameResult result = game.play(Arrays.asList(9, 2, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }
    @Test
    public void play_1ball() {
        Game game = new Game(Arrays.asList(5, 3, 8));
        GameResult result = game.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void play_1strike_1ball() {
        Game game = new Game(Arrays.asList(5, 3, 8));
        GameResult result = game.play(Arrays.asList(5, 8, 6));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void play_3strike() {
        Game game = new Game(Arrays.asList(5, 3, 8));
        GameResult result = game.play(Arrays.asList(5, 3, 8));
        assertThat(result.isOut()).isTrue();
    }

    @Test
    public void strike() {
        Game game = new Game(Arrays.asList(1, 2, 3));
        RoleStatus status = game.play(new Role(1, 1));
        assertThat(status).isEqualTo(RoleStatus.STRIKE);
    }

    @Test
    public void ball() {
        Game game = new Game(Arrays.asList(1, 2, 3));
        RoleStatus status = game.play(new Role(1, 2));
        assertThat(status).isEqualTo(RoleStatus.BALL);
    }

    @Test
    public void nothing() {
        Game game = new Game(Arrays.asList(1, 2, 3));
        RoleStatus status = game.play(new Role(1, 4));
        assertThat(status).isEqualTo(RoleStatus.NOTHING);
    }
}
