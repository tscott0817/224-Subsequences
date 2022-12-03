import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyzer {

    //    static List<Integer> M = new ArrayList<>();
    List<Integer> M = new ArrayList<>();
    List<Integer> originalList = new ArrayList<>();
    List<Integer> lengths = new ArrayList<>();
    public int analyze(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            originalList.add(list.get(i));
            M.add(1);
        }
        M.set(M.size() - 1, 1);

        System.out.println(M);
        System.out.println(M.size());
        System.out.println(list);
        System.out.println("\n");

        // TODO: Out of bounds errors, looping to -1 to combat. This is the only setup that seems to work
        for (int i = list.size() - 1; i > -1; i--) {
            System.out.println("Outer loop");
            System.out.println("Current index of 'i': " + i);
            System.out.println("Current element of 'i': " + originalList.get(i));
            lengths.add(opt(i));
        }
        System.out.println(lengths);
        System.out.println(M);

        return 0;
    }

    public int opt(int i) {

        int val = 0;
        if (M.get(i) > 1) {
            System.out.println("M greater than 0. M at index " + i + " = " + M.get(i));
            System.out.println("\n");
            return M.get(i);
        }
        else {
            System.out.println("\n");
            System.out.println("M NOT greater than 0. M at index " + i + " = " + M.get(i));

            // TODO: Not sure if 'j' should be 'i' or 'i + 1'
            System.out.println("Current length at 'i': " + M.get(i));
            for (int j = i + 1; j < originalList.size(); j++) {
                System.out.println("Inner loop");
                System.out.println("Current index of 'j': " + j);
                System.out.println("Current element at 'j': " + originalList.get(j));
                System.out.println("Is " + originalList.get(i) + " < " + originalList.get(j) + " ?");

                if (originalList.get(i) < originalList.get(j)) {
                    val = 1 + M.get(j);
                    System.out.println("Yes, set length to: " + val);
                    System.out.println("New length value " + val + " at index: " + i);
                    M.set(i, val);
                    break;
                }
                // If no larger elements to right of 'i', i.e. just don't change length
                else {
                    val = M.get(i);
                    System.out.println("No, set length to " + M.get(i));
                    M.set(i, val);
                }
            }
            System.out.println("\n");
            return val;

        }
    }

    // TODO: The traceback function "unwinds" the computation of M[0] to show subsequence
    private List<Integer> traceback(int i) {

        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < M.size(); j++) {
            res.add(M.get(j));
        }
        return res;

    }

}