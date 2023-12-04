<<<<<<< HEAD
public class Leetcode455 {
=======
import java.util.Arrays;

public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        int g_index=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            if (g_index<g.length&&s[i] >= g[g_index]) {
                g_index++;
            }
        }
        return  g_index;
    }
>>>>>>> master
}
