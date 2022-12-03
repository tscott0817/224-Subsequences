// jdh CS224 Fall 2022

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String argv[]) {
    testOne();
//    testTwo();
  }

  //---------------------------------------------------------------------
  // answer is 6: (4, 5, 6, 7, 13, 15)
  public static void testOne() {
    List<Integer> list = Arrays.asList(4, 10, 5, 6, 11, 7, 13, 2, 15, 6);

    for (Integer o: list)
      System.out.print((int) o + " ");
    System.out.println();

    Analyzer analyzer = new Analyzer();
    int result = analyzer.analyze(list);
    System.out.println("result is " + result);
  } // testOne()

  //---------------------------------------------------------------------

  // answer is 9: (4, 5, 6, 7, 8, 9, 10, 11, 12)
  public static void testTwo() {
    List<Integer> list = Arrays.asList(4, 10, 6, 12, 2, 8, 16, 11, 18, 10, 5, 6, 7, 8, 9, 10, 11, 12);

    for (Integer o: list)
      System.out.print((int) o + " ");
    System.out.println();

    Analyzer analyzer = new Analyzer();
    int result = analyzer.analyze(list);
    System.out.println("result is " + result);
  } // testTwo()
}
