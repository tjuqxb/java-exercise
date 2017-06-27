import java.io.*;
import java.util.ArrayDeque;

/**
 * Created by 17663 on 2017/6/19.
 */



    /**
     * Created by 17663 on 2017/6/19.
     */
    public class PalindromeFinder {
        String input;
        Palindrome func;
        CharacterComparator method;
        public ArrayDeque wordList() throws IOException{
            ArrayDeque re = new ArrayDeque();
            InputStreamReader ir = new InputStreamReader(new FileInputStream(input));
            BufferedReader br = new BufferedReader(ir);
            String temp = null;
            temp = br.readLine();
            Palindrome p = new Palindrome();
            CharacterComparator cc = func;
            while (temp != null){
                if (p.isPalindrome(temp,cc) == true){
                    re.addLast(temp);
                }
                temp = br.readLine();
            }
            return re;
        }

        public PalindromeFinder(String file, Palindrome y){
            this.func = y;
            this.input = file;
        }

        public static void main(String[] args) {
            Palindrome cc = new OffByN(0);
            PalindromeFinder a = new PalindromeFinder("words.txt", cc);
            try {
                for (Object x :
                        a.wordList()) {System.out.println(x);}
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }


