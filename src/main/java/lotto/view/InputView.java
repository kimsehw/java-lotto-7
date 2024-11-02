package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements View {

    public static final String AMOUNT_INPUT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String INVALID_INPUT_VIEW_EXCEPTION = "[ERROR] 존재하지 않는 InputView 를 요청하셨습니다.";
    public static final String AMOUNT = "Amount";
    public static final String WINNING_NUMBER = "WinningNumber";
    public static final String BONUS_NUMBER = "BonusNumber";

    private final String requestMessage;

    private InputView(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public static View of(String type) {
        if (type.equals(AMOUNT)) {
            return new InputView(AMOUNT_INPUT_REQUEST_MESSAGE);
        }

        if (type.equals(WINNING_NUMBER)) {
            return new InputView(WINNING_NUMBER_INPUT_REQUEST_MESSAGE);
        }

        if (type.equals(BONUS_NUMBER)) {
            return new InputView(BONUS_NUMBER_INPUT_REQUEST_MESSAGE);
        }

        throw new IllegalArgumentException(INVALID_INPUT_VIEW_EXCEPTION);
    }

    private void showRequestMessage() {
        System.out.println(requestMessage);
    }

    private String getInput() {
        return Console.readLine();
    }

    @Override
    public String display() {
        showRequestMessage();
        return getInput();
    }
}