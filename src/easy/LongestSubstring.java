package easy;

import java.util.Stack;

public class LongestSubstring { //0000110001111    //0010011
    public int findTheLongestBalancedSubstring(String s) {
        int maxCount=0, tracker=0, count=0 ;
        boolean check=false;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') tracker++;
            else { tracker--; count++; }
            if( i+1!=s.length() && ( s.charAt(i)=='1' && s.charAt(i+1)=='0')  )  check=true;
            if (i==s.length()-1 || check){
                System.out.println("count: "+ count + "  tracker: "+ tracker);
                if(tracker <= 0) maxCount=Math.max(count+tracker, maxCount);
                else if (count >=1) maxCount=Math.max(count, maxCount);
                tracker=0; count=0;
                check=false;
            }
        }
        return maxCount+maxCount;
    }
}
