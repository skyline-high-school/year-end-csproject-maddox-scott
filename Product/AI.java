public class AI {
    static GameState returnMove(GameState state) {
        return (GameState)minValue(state)[0];
    }

    static Object[] maxValue(GameState state) {
        Object[] output = new Object[2];
        output[1] = Integer.MIN_VALUE;
        if (state.isTerminalState()) {
            output[1] = state.value();
            return output;
        }
        for (GameState successorState : state.getMoves('X')) {
            int successorEval = (Integer)minValue(successorState)[1];
            if (successorEval > (Integer)output[1]) {
                output[0] = successorState;
                output[1] = successorEval;
            }
        }
        return output;
    }

    static Object[] minValue(GameState state) {
        Object[] output = new Object[2];
        output[1] = Integer.MAX_VALUE;
        if (state.isTerminalState()) {
            output[1] = state.value();
            return output;
        }
        for (GameState successorState : state.getMoves('O')) {
            int successorEval = (Integer)maxValue(successorState)[1];
            if (successorEval < (Integer)output[1]) {
                output[0] = successorState;
                output[1] = successorEval;
            }
        }
        return output;
    }
}
