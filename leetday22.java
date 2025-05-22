public class leetday22 {
    class Solution1 {
        public boolean searchMatrix(int[][] arr, int target) 
        {
            int n = arr.length;
            int m = arr[0].length;
            for(int i=0;i<n;i++)
            {
                if(arr[i][0]<= target && target <=arr[i][m-1])
                {
                    if(binarySearch(arr[i],target)==true)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        public static boolean binarySearch(int arr[], int target)
        {
            int low =0;
            int high = arr.length-1;
            while(low<=high)
            {
                int mid = (low+high)/2;
                if(arr[mid]==target)
                {
                    return true;
                }
                else if (arr[mid]<target)
                {
                    low = mid+1;
                }
                else 
                {
                    high= mid-1;
                }
            }
            return false;
        }
    }
    class Solution2 {
        public boolean searchMatrix(int[][] arr, int target) 
        {
            int n = arr.length;
            int m = arr[0].length;
            int row = 0;
            int col = m-1;
            while(row<n && col>=0)
            {
                if(arr[row][col]==target)
                {
                   return true;
                }
                else if(arr[row][col]<target)
                {
                    row++;
                }
                else{
                    col--;
                }
            }
            return false;
        }
        }
    
}
