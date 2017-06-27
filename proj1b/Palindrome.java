import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by 17663 on 2017/6/19.
 */
public class Palindrome implements CharacterComparator{
    CharacterComparator cc;
    public static Deque<Character> wortToDeque(String word){
        Deque wordDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public static boolean isPalindrome(String word,CharacterComparator cc){
        if (word.length() == 0 || word.length() == 1) {
            return true;
        } else if(word.length() == 2) {
            return cc.equalChars(word.charAt(0), word.charAt(1));
        } else {
            return (cc.equalChars(word.charAt(0),word.charAt(word.length()-1)) && (isPalindrome(word.substring(1, word.length()-1),cc)));
        }
    }

    @Override
    public boolean equalChars(char a, char b){
        return a == b;
    }



}
