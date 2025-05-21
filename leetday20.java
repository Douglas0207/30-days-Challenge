public class leetday20 
{
    class Solution1 {
        public int findKthPositive(int[] arr, int k) 
        {
              int low = 0;
            int high = arr.length - 1;
            while(low<=high)
            {
                int mid = (low+high)/2;
                int missing = arr[mid] - (mid+1);
                if(missing<k)
                {
                    low = mid +1;
                }
                else
                {
                    high = mid -1;
                }
            }
            return low+k;
        }
    }
    class Solution2 {
        public int shipWithinDays(int[] arr, int days) 
        {
            int low = getHigh(arr);
           int high = getSum(arr);
           int ans = 0;
           while(low<=high)
           {
            int mid = (low+high)/2;
            int daysRequired = findDays(arr,mid);
            if(daysRequired<=days)
            {
                ans = mid;
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
           }
           return ans;
        }
        public static int findDays(int arr[], int capacity)
        {
            int day = 1;
            int load = 0;
            for(int i=0;i<arr.length;i++) // 1,2,3,4,5,6,7,8,9,10
            {
                if(load+arr[i]>capacity)//32
                {
                    day = day + 1;
                    load = arr[i]; // next day load
                }
                else
                {
                    load = load + arr[i]; // current day load
                }
            }
            return day;
        }
        public static int getSum(int arr[])
        {
            int sum = 0;
            for(int i=0;i<arr.length;i++)
            {
                sum = sum + arr[i];
            }
            return sum;
        }
        public static int getHigh(int arr[])
        {
            int high = Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]>high)
                {
                    high = arr[i];
                }
            }
            return high;
        }
    }
}
