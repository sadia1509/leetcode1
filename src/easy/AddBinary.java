package easy;

import java.math.BigInteger;

public class AddBinary {
    public String addBinary(String a, String b) {
        System.out.println((int)Math.sqrt(8));
        return (new BigInteger(a,2).add(new BigInteger(b,2))).toString(2);
    }
}
