import java.util.ArrayList;
import java.util.List;

public class leetday30 {

public class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // First pass: Find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify actual counts
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}
class Solution2 {
    public static int nCr(int n, int r) {
       long res = 1;
       // calculating nCr:
       for (int i = 0; i < r; i++) {
           res = res * (n - i);
           res = res / (i + 1);
       }
       return (int) res;
   }
   public List<List<Integer>> generate(int n) {
       List<List<Integer>> ans = new ArrayList<>();
       for (int row = 0; row < n; row++) {
           List<Integer> tempLst = new ArrayList<>(); 
           for (int col = 0; col <= row; col++) {
               tempLst.add(nCr(row,col));
           }
           ans.add(tempLst);
       }
       return ans;
   }
   }

}