package gogame;

public enum Stone
{
    BLACK, WHITE;

    public static Stone opposite(Stone stone)
    {
        return stone == BLACK ? WHITE : BLACK;
    }
}