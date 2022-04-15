package baseball.play;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.Game;
import baseball.GameResult;
import baseball.SetNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameStart {
    private final int NUMBER_SIZE = 3;
    private final String PLEASE_INPUT_NUMBER = "숫자를 입력해 주세요 : ";
    private final String GAME_END_MESSAGE = "3개의숫자를모두맞히셨습니다!게임종료";
    private final String RE_GAME_MESSAGE = "게임을새로시작하려면1,종료하려면2를입력하세요";
    private final int RE_GAME_NUMBER = 1;

    public void start() {
        while (true) {
            Game game = new Game(setRandomNumber());

            playGame(game);

            System.out.println(RE_GAME_MESSAGE);

            if(Integer.parseInt(readLine()) != RE_GAME_NUMBER) {
                break;
            }
        }
    }

    private void playGame(Game game) {
        while (true) {
            System.out.println(PLEASE_INPUT_NUMBER);
            List<Integer> userInput = Arrays.stream(readLine().split("")).map(
                    Integer::parseInt
            ).collect(Collectors.toList());

            if(userInput.size() > NUMBER_SIZE) {
                throw new IllegalArgumentException("숫자는 1과 9사이의 숫자이어야 합니다");
            }

            GameResult result =  game.play(userInput);

            if(!result.isOut()) {
                System.out.println(result.resultAsString());
            }

            if(result.isOut()) {
                System.out.println(GAME_END_MESSAGE);
                break;
            }

        }
    }

    private List<Integer> setRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while(true) {
            Integer number = pickNumberInRange(SetNumber.MIN_NUMBER, SetNumber.MAX_NUMBER);
            if(!computerNumber.contains(number)) {
                computerNumber.add(number);
            }

            if(computerNumber.size() == NUMBER_SIZE) {
                break;
            }
        }

        return computerNumber;
    }


}
