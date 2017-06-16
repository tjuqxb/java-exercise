/**
 * Created by 17663 on 2017/6/12.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void test(){
        int a = 1;
        int b = 1;
        int c = 2;
        assertTrue(Flik.isSameNumber(a,b));
        assertFalse(Flik.isSameNumber(a,c));
        assertTrue(Flik.isSameNumber(127,127));
        assertTrue(Flik.isSameNumber(128,128));

    }
}
