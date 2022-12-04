 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyzer {

    List<Integer> lengths = new ArrayList<>();  // The array of lengths
    List<Integer> originalList = new ArrayList<>();  // The list we're finding MIS of
    List<Integer> tracebackResults = new ArrayList<>();  // The actual MIS

    public int analyze(List<Integer> list) {

        // Copy list for class use and initialize length list
        for (int i = 0; i < list.size(); i++) {
            originalList.add(list.get(i));
            lengths.add(0);
        }
        lengths.set(lengths.size() - 1, 1);  // Set last element to length of 1

        // Iterate backwards starting from last element of list ss
        for (int i = list.size() - 1; i >= 0; i--) {
            opt(i);

            // Print traceback results when at desired position
            if (i == 0) {
                System.out.print("Traceback Results: " + traceback(i));
                System.out.print("\n");
            }
        }
        return Collections.max(lengths);
    }

    public int opt(int i) {

        int maxLength = 0;
        if (lengths.get(i) > 0) {
            return lengths.get(i);
        }
        else {
            // Start at next position and check all elements until the end of list
            for (int j = i + 1; j < originalList.size(); j++) {

                // Recursively check for elements larger than current position
                if (originalList.get(i) < originalList.get(j)) {
                    maxLength = 1 + opt(j);
                    lengths.set(i, maxLength);

                    // Compare against max value and choose to continue or return
                    if (maxLength != Collections.max(lengths) & j < originalList.size() - 1) {
                        maxLength = opt(j + 1);
                    }
                    else {
                        return maxLength;
                    }
                }
                // If no larger elements to right, length is 1
                else {
                    maxLength = 1;
                    lengths.set(i, maxLength);
                }
            }
            return maxLength;
        }
    }

    private List<Integer> traceback(int i) {

        // Append new element to results after each recursive call
        tracebackResults.add(originalList.get(i));

        // Check each 'j' index to get list of max distance elements
        for (int j = 0; j < originalList.size(); j++) {
            if (lengths.get(i) == 1 + lengths.get(j) & j > i & tracebackResults.size() <= Collections.max(lengths) - 1) {
                traceback(j);
            }
        }
        return tracebackResults;
    }
}
