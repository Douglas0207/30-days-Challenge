public class leetday29 {
    class Solution1 {
        public int beautySum(String s) 
        {
            int n = s.length();
            int beauty = 0;
            for(int i=0;i<n;i++)
            {
                int [] freq = new int [26];
                for(int j=i;j<n;j++)
                {
                    char ch = s.charAt(j);
                    freq[ch-'a']++;
    
                    int maxFreq = 0;
                    int minFreq = Integer.MAX_VALUE;
    
                    for(int k=0;k<26;k++)
                    {
                        if(freq[k]>0)
                        {
                            maxFreq = Math.max(maxFreq,freq[k]);
                            minFreq = Math.min(minFreq,freq[k]);
                        }
                    }
                    beauty = beauty + (maxFreq - minFreq);
                }
            }
            return beauty;
        }
    }
    class Solution2 {
        public String reverseWords(String s) 
        {
             s=s.trim();
             String words [] = s.split("\\s+");
             StringBuilder result = new StringBuilder();
             for(int i=words.length-1;i>=0;i--)
             {
                result.append(words[i]);
                if(i!=0)
                {
                    result.append(" ");
                }
             }
             return result.toString();
        }
    }
}
