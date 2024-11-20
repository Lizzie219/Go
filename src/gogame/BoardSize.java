package gogame;

import java.util.Arrays;

/*

TODOs for students: create the following classes in package gogame:

enums BoardSize, Stone, BoardSpace
classes Point, GoState
JUnit GoStateTest

*/
public enum BoardSize
{
	NINE(9),
    THIRTEEN(13),
    NINETEEN(19);

    private final Integer size;

    public Integer getSize() {
        return size;
    }

    BoardSize(Integer size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return size + "x" + size;
    }

    public static BoardSize fromString(String s)
    {
        return Arrays.stream(BoardSize.values())
                .filter(b -> b.toString().equals(s))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid board size: " + s));
    }

    public static String[] getStringValues()
    {
        return Arrays.stream(BoardSize.values()).map(BoardSize::toString).toArray(String[]::new);
    }
}