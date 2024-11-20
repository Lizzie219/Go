package gogame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardSizeTest {
    @ParameterizedTest
    @EnumSource(BoardSize.class)
    public void testFromString(BoardSize boardSize)
    {
        assertEquals(boardSize, BoardSize.fromString(boardSize.toString()));
    }

    @Test
    public void testFailingFromString()
    {
        assertThrows(IllegalArgumentException.class, () -> BoardSize.fromString("Hello"));
    }

}