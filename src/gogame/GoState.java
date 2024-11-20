package gogame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class GoState implements Predicate<Point> {
    BoardSpace[][] board;
    Integer blackCaptured;
    Integer whiteCaptured;
    Stone turn;
    Set<GoState> previousStates;

    public GoState(int size) {
        board = new BoardSpace[size][size];
        blackCaptured = 0;
        whiteCaptured = 0;
        turn = Stone.BLACK;
        previousStates = new HashSet<>();
    }

    public GoState(GoState state) {
        this.board = state.board.clone();
        this.blackCaptured = state.blackCaptured;
        this.whiteCaptured = state.whiteCaptured;
        this.turn = state.turn;
        this.previousStates = new HashSet<>(state.previousStates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GoState goState = (GoState) o;
        return Objects.deepEquals(board, goState.board) && turn == goState.turn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(board), turn);
    }

    @Override
    public boolean test(Point point) {
        return point.x >= 0 && point.x < board.length && point.y >= 0 && point.y < board[0].length;
    }

    public Point[] getNeighbors(Point point) {
        Point[] neighbors = new Point[4];
        neighbors[0] = new Point(point.x - 1, point.y);
        neighbors[1] = new Point(point.x + 1, point.y);
        neighbors[2] = new Point(point.x, point.y - 1);
        neighbors[3] = new Point(point.x, point.y + 1);

        return Arrays.stream(neighbors).filter(this::test).toArray(Point[]::new);
    }

}