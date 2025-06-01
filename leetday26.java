import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetday26 {
    class Solution1 {
        public boolean isAnagram(String first, String second) {
             if(first.length()!=second.length())
            {
                return false;
            }
            int frequencyArray [] = new int [26];
    
            for(int i=0;i<first.length();i++)
            {
               frequencyArray[first.charAt(i)-'a']++;
               frequencyArray[second.charAt(i)-'a']--;
            }
            for(int count:frequencyArray)
            {
                if(count!=0)
                {
                    return false;
                }
            }
            return true;
        }
    }
    class Solution2 {
    public String frequencySort(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
        {
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character>[] Bucket = new ArrayList[s.length()+1];
        for(char key:map.keySet())
        {
            int freq = map.get(key);
            if(Bucket[freq]==null)
            {
                Bucket[freq] = new ArrayList<>();
            }
            Bucket[freq].add(key);
        }
        StringBuilder result = new StringBuilder();
        for(int i=Bucket.length-1;i>=0;i--)
        {
            if(Bucket[i]!=null)
            {
                for(char c:Bucket[i])
                {
                    for(int j=0;j<i;j++)
                    {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}
}
