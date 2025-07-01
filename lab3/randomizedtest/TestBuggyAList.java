package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  @Test
    public void testThreeRemove(){
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> bug  = new BuggyAList<>();
      correct.addLast(4);
      bug.addLast(4);
      correct.addLast(5);
      bug.addLast(5);
      correct.addLast(6);
      bug.addLast(6);
      assertEquals(correct.removeLast(), bug.removeLast());
      assertEquals(correct.removeLast(), bug.removeLast());
      assertEquals(correct.removeLast(), bug.removeLast());
  }
  @Test
    public  void AListrandom(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> bug  = new BuggyAList<>();
      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 3);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              bug.addLast(randVal);

          } else if (operationNumber ==1&&L.size()!=0) {
              int number = L.getLast();
              int number2 = bug.getLast();
              assertEquals(number,number2);

          }
          else{
              if(L.size()==0)continue;
              int number = L.removeLast();
              int number2 = bug.removeLast();
              assertEquals(number,number2);

          }
      }

  }
}
