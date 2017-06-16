/**
 * Created by 17663 on 2017/6/16.
 */
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

/*public class StudentArrayDequeLauncher {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        sad1.addLast(5);
        sad1.addLast(10);
        sad1.printDeque();
    }
}*/
public class TestArrayDeque1B {
   @Test
    public void testArrayDeque(){
       StudentArrayDeque<Integer> t1 = new StudentArrayDeque<>();
       ArrayDequeSolution<Integer> t2 = new ArrayDequeSolution<>();
       FailureSequence fs = new FailureSequence();
       for (int i = 0; i < 2; i++) {
           for (int x=0; x< 20; x++) {
                Integer a = StdRandom.uniform(10000);
                DequeOperation op1 = new DequeOperation("addFirst", a);
                fs.addOperation(op1);
                t1.addFirst(a);
                t2.addFirst(a);

                Integer b = StdRandom.uniform(10000);
                DequeOperation op2 = new DequeOperation("addLast", b);
                fs.addOperation(op2);
                t1.addLast(b);
                t2.addLast(b);
           }
           for (int y = 0; y < 20; y++) {
                DequeOperation op3 = new DequeOperation("removeFirst");
                fs.addOperation(op3);
                assertEquals(fs.toString(),t2.removeFirst(),t1.removeFirst());
                DequeOperation op4 = new DequeOperation("removeLast");
                fs.addOperation(op4);
                assertEquals(fs.toString(),t2.removeLast(),t1.removeLast());}
       }

   }

   public static void main(String[] args){
       jh61b.junit.TestRunner.runTests(TestArrayDeque1B.class);
   }


}
