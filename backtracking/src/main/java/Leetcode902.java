import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode902 {
    List<List<Character>> result;
    LinkedList<Character> path;
    String[] digits;
    int target;
    int tarLen;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits=digits;
        target=n;
        tarLen = String.valueOf(target).length();
        path = new LinkedList<>();
        result = new ArrayList<>();
        backtracking(0);
        return result.size();
    }

    private boolean backtracking(int index) {
        if (!path.isEmpty()) {
            if(path.size()<tarLen) {
                result.add(new ArrayList<>(path));
            }
            else if((path.size()==tarLen&&isLess(path,target))) {
                result.add(new ArrayList<>(path));
            }else{
                return false;
            }
        }

        for (int i = 0; i < digits.length; i++) {
            path.add(digits[i].charAt(0));
            if(!backtracking(i)){
                path.removeLast();
                continue;
            }

            path.removeLast();
        }
        return true;
    }

    private boolean isLess(LinkedList<Character> path, int target) {
        String s = String.valueOf(target);
        for (int i = 0; i < tarLen; i++) {
            if (path.get(tarLen - 1 - i) < s.charAt(i)) {
                return true;
            } else if (path.get(tarLen - 1 - i) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
