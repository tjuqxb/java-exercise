/**
 * Created by 17663 on 2017/6/19.
 */
public class OffByN extends Palindrome implements CharacterComparator {
    int num = 0;


    public OffByN(int m){
        this.num = m;
    }
    @Override
    public boolean equalChars(char a, char b){
        int off = a - b;
        return (off == num || (off == -num));
    }
}
