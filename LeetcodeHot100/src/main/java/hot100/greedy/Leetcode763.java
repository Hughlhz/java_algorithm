package hot100.greedy;

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {

    public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            List<Integer> partition = new ArrayList<Integer>();
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return partition;
    }


    public List<Integer> partitionLabels_(String s) {
        int left=0;
        int right=s.length()-1;
        int cut;
        char ch ;

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i < s.length(); ) {
            cut=left;
            i=left;
            while (i<=cut){
                ch=s.charAt(i);
                right=s.length()-1;
                while (right > cut) {
                    if (ch != s.charAt(right)) {
                        right--;
                    }else {
                        cut=right;
                    }
                }
                i++;
            }
            result.add(cut-left+1);
            left=cut+1;
        }
        return result;
    }
}
