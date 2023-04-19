package easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        System.out.println(s.trim().lastIndexOf(' ') + 1);
        return  s.trim().substring(s.trim().lastIndexOf(' ') + 1).length();
    }
}
