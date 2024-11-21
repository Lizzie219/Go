package gogame;

import java.util.Arrays;

public enum BoardSpace {
    EMPTY(null),
    BLACK(Stone.BLACK),
    WHITE(Stone.WHITE);

    public final Stone stone;

    BoardSpace(Stone stone) {
        this.stone = stone;
    }

    public static BoardSpace fromStone(Stone stone) {
        return Arrays.stream(BoardSpace.values()).filter(s -> s.stone == stone).findFirst().orElse(EMPTY);
    }
}
