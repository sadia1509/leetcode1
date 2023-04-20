package easy;

public class PalindromeNumber {
    int remainder=0, reverse=0, number=0;
    public boolean isPalindrome(int x) {
        if (x*-1>0) return false;
        number=x;
        while (x!=0){
            remainder = x%10;
            reverse *= 10;
            reverse += remainder;
            x /= 10;
        }
        return number==reverse;
    }

    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (int front=0, end=s.length()-1; front<s.length(); front++,end--)
            if(s.charAt(front) != s.charAt(end)) return false;
        return true;
    }


}
