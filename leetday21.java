public class leetday21 
{
    class Solution1 {
        public int splitArray(int[] arr, int k) 
        {
             int low = getMax(arr);
            int high = getSum(arr);
            int ans = -1;
            while(low<=high)
            {
                int mid = (low+high)/2;
                if(canDo(arr,k,mid)==true)
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
        public static int getMax(int[] arr) {
            int max = Integer.MIN_VALUE;
            for (int num : arr) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }
         public static int getSum(int[] arr) {
            int sum = 0;
            for (int num : arr) 
            {
                sum += num;
            }
            return sum;
        }
        public static boolean canDo(int arr[], int k, int limit)
        {
           int Count = 1;
           int currentSum = arr[0];
           for(int i=1;i<arr.length;i++)
           {
             if(arr[i]+currentSum>limit)
             {
                Count = Count +1;
                currentSum = arr[i];
             }
             else
             {
                currentSum = currentSum+arr[i];
             }
           }
           if(Count <= k)
           {
            return true;
           }
           return false;
        }
        }
        class Solution2 {
            public double findMedianSortedArrays(int[] arr1, int[] arr2) 
            {
                int n1 = arr1.length;
                int n2 = arr2.length;
        
                // Correction 1: Always do binary search on smaller array
                if(n1 > n2)
                {
                    return findMedianSortedArrays(arr2, arr1);
                }
        
                int low = 0;
                int high = n1;   // Correction 2: high = n1 not max(n1,n2)
                int left = (n1+n2+1)/2;
                int n = n1+n2;
                double ans = 0;
        
                while(low <= high)
                {
                    int mid1 = (low+high)/2;
                    int mid2 = left - mid1;
        
                    int l1 = Integer.MIN_VALUE;
                    int l2 = Integer.MIN_VALUE;
                    int r1 = Integer.MAX_VALUE;
                    int r2 = Integer.MAX_VALUE;
        
                    if(mid1 < n1)
                    {
                        r1 = arr1[mid1];
                    }
                    if(mid2 < n2)
                    {
                        r2 = arr2[mid2];
                    }
                    if(mid1-1 >= 0)
                    {
                        l1 = arr1[mid1-1];
                    }
                    if(mid2-1 >= 0)
                    {
                        l2 = arr2[mid2-1];
                    }
        
                    if(l1 <= r2 && l2 <= r1)
                    {
                        if(n%2 == 1)
                        {
                           ans = Math.max(l1, l2);
                        }
                        else
                        {
                            ans = ((double)(Math.max(l1, l2) + Math.min(r1, r2)))/2.0;
                        }
                        return ans;
                    }
                    else if (l1 > r2)
                    {
                        high = mid1 - 1;
                    }
                    else
                    {
                        low = mid1 + 1;
                    }
                }
                return -1;
            }
        }
}
