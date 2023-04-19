package common;

public class RandomTest {
    public static void main (String[]args){
       check();
    }

    static void check(){
        String s = "()[";
        System.out.println(s.substring(0, s.length()-1));
    }
}
