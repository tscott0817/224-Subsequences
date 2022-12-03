 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Analyzer {

    List<Integer> M = new ArrayList<>();
    List<Integer> originalList = new ArrayList<>();
    public int analyze(List<Integer> list) {

        // Copy list for class use and initialize memoized list
        for (int i = 0; i < list.size(); i++) {
            originalList.add(list.get(i));
            M.add(0);
        }
        M.set(M.size() - 1, 1);  // Set last element to length of 1

        // Iterate backwards from last element of list
        for (int i = list.size() - 1; i >= 0; i--) {
            opt(i);
        }
        //System.out.print(traceback(0));

        return Collections.max(M);
    }

    public int opt(int i) {

        int val = 0;
        if (M.get(i) > 0) {
            return M.get(i);
        }
        else {
            // Start at next position and check all elements until the end of list
            for (int j = i + 1; j < originalList.size(); j++) {

                // Call recursively for each element that is larger than 'i'
                if (originalList.get(i) < originalList.get(j)) {
                    val = 1 + opt(j);
                    M.set(i, val);

                    // Compare against max value and choose to continue or return
                    if (val != Collections.max(M) & j < originalList.size() - 1) {
                        val = opt(j + 1);

                    }
                    else {
                        return val;
                    }
                }
                // If no larger elements to right, length is 1
                else {
                    val = 1;
                    M.set(i, val);
                }
            }
            return val;

        }
    }

    // TODO: The traceback function "unwinds" the computation of M[0] to show subsequence
    private List<Integer> traceback(int i) {

        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < M.size(); j++) {
            if (M.get(i) == 1 + M.get(j)) {


            }
        }
        return res;

    }

}
