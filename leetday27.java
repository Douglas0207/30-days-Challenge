import java.util.HashMap;

public class leetday27 {
    class Solution1 {
        public int maxDepth(String s) 
        {
            int depth = 0;
            int maxDepth = 0;
            for(char ch:s.toCharArray())
            {
                if(ch=='(')
                {
                    depth++;
                    maxDepth = Math.max(maxDepth,depth);
                }
                if(ch==')')
                {
                    depth--;
                }
            }
                return maxDepth;
        }
    }
    class Solution2 {
    public int romanToInt(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result =0;
        for(int i=0;i<s.length();i++)
        {
            int value = map.get(s.charAt(i));
            if(i+1<s.length() && value<map.get(s.charAt(i+1)))
            {
                result = result - value;
            }
            else 
            {
                result = result + value;
            }
        }
        return result;
    }

}
}
