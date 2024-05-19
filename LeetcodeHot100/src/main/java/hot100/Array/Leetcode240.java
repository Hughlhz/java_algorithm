package hot100.Array;

public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=matrix[0].length-1;

        while(i>=0&&i<matrix.length&&j>=0){
            if(target>matrix[i][j]){
                i++;
            }else if(target<matrix[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode240 leetcode240 = new Leetcode240();
        leetcode240.searchMatrix(new int[][]{{-1, 3}},3);
    }
}
