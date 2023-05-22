public class AI {
    static GameState returnMove(GameState state, int size) {
        if (size > 3) {
            return (GameState)minValueABCutoff(state, Integer.MIN_VALUE, Integer.MAX_VALUE, 13 - size)[0];
        } else {
            return (GameState)minValueAB(state, Integer.MIN_VALUE, Integer.MAX_VALUE)[0];
        }
    }

    static Object[] maxValueAB(GameState state, int alpha, int beta) {
        Object[] output = new Object[2];
        output[0] = null;
        output[1] = Integer.MIN_VALUE;
        if (state.isTerminalState()) {
            output[1] = state.value();
            return output;
        }
        for (GameState successorState : state.getMoves('X')) {
            int successorEval = (Integer)minValueAB(successorState, alpha, beta)[1];
            if (successorEval > (Integer)output[1]) {
                output[0] = successorState;
                output[1] = successorEval;
            }
            alpha = Integer.max(alpha, successorEval);
            if (alpha >= beta) {
                break;
            }
        }
        return output;
    }

    static Object[] minValueAB(GameState state, int alpha, int beta) {
        Object[] output = new Object[2];
        output[0] = null;
        output[1] = Integer.MAX_VALUE;
        if (state.isTerminalState()) {
            output[1] = state.value();
            return output;
        }
        for (GameState successorState : state.getMoves('O')) {
            int successorEval = (Integer)maxValueAB(successorState, alpha, beta)[1];
            if (successorEval < (Integer)output[1]) {
                output[0] = successorState;
                output[1] = successorEval;
            }
            beta = Integer.min(beta, successorEval);
            if (alpha >= beta) {
                break;
            }
        }
        return output;
    }

    static Object[] maxValueABCutoff(GameState state, int alpha, int beta, int cutoff) {
        Object[] output = new Object[2];
        output[0] = null;
        output[1] = Integer.MIN_VALUE;
        if (state.isTerminalState() || cutoff == 0) {
            output[1] = state.heuristicValue();
            return output;
        }
        for (GameState successorState : state.getMoves('X')) {
            int successorEval = (Integer)minValueABCutoff(successorState, alpha, beta, cutoff - 1)[1];
            if (successorEval > (Integer)output[1]) {
                output[0] = successorState;
                output[1] = successorEval;
            }
            alpha = Integer.max(alpha, successorEval);
            if (alpha >= beta) {
                break;
            }
        }
        return output;
    }

    static Object[] minValueABCutoff(GameState state, int alpha, int beta, int cutoff) {
        Object[] output = new Object[2];
        output[0] = null;
        output[1] = Integer.MAX_VALUE;
        if (state.isTerminalState() || cutoff == 0) {
            output[1] = state.heuristicValue();
            return output;
        }
        for (GameState successorState : state.getMoves('O')) {
            int successorEval = (Integer)maxValueABCutoff(successorState, alpha, beta, cutoff - 1)[1];
            if (successorEval < (Integer)output[1]) {
                output[0] = successorState;
                output[1] = successorEval;
            }
            beta = Integer.min(beta, successorEval);
            if (alpha >= beta) {
                break;
            }
        }
        return output;
    }
}
