public class leetday28 
{
    class Solution1 {
        public int myAtoi(String s)
        {
         int i = 0 ;
         int n = s.length();
         int sign = 1;
         int result =0;
         while(i<n && s.charAt(i)==' ')
         {
            i++;
         } 
         if(i<n && (s.charAt(i)=='+'||s.charAt(i)=='-'))
         {
            if(s.charAt(i)=='+')
            {
                sign = 1;
            }
            else 
            {
                sign = -1;
            }
            i++;
         }
         while(i<n && Character.isDigit(s.charAt(i)))
         {
            int digit = s.charAt(i) - '0';
            if(result>(Integer.MAX_VALUE-digit)/10)
            {
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }
                else
                {
                    return Integer.MIN_VALUE;
                }
            }
            result = (result * 10) + digit;
            i++;
         }
         return result*sign;
        }
    }
    class Solution2 {
        public String longestPalindrome(String s) 
        {
            int n = s.length();
            if(s==null || n<1)
            {
                return "";
            }
            int start = 0;
            int end = 0;
            for(int i=0;i<n;i++)
            {
               int len1 = expandAroundMid(s,i,i);
               int len2 = expandAroundMid(s,i,i+1);
               int len = Math.max(len1,len2);
    
               if(len>end - start)
               {
                start = i - (len-1)/2;
                end = i+len/2;
               }
            }
            return s.substring(start,end+1);
        }
        public int expandAroundMid(String s , int left , int right )
        {
            while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right))
            {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}
