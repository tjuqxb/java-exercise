/**
 * Created by 17663 on 2017/6/19.
 */
public class OffByOne extends Palindrome implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int a = x - y;
        return (a == 1 || (a == -1));
    }
}
