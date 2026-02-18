class Solution {
    public boolean hasAlternatingBits(int n) {
       
        String t=Integer.toBinaryString(n);
        
        for(int i=1;i<t.length();i++)
        {
            if(t.charAt(i)==t.charAt(i-1)) return false;    
        }
        return true;
    }
}