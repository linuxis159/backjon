package math.encrypyion;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class P3734_RSA인수분해_Pollard_Rho {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger N = sc.nextBigInteger();
        int K = sc.nextInt(); // 큰 수를 여기에 입력
        System.out.println("One of the factors: " + pollardsRho(N));
    }

    // Pollard's Rho 알고리즘 구현
    public static BigInteger pollardsRho(BigInteger n) {
        if (n.mod(TWO).compareTo(ZERO) == 0) return TWO;
        BigInteger x = new BigInteger(n.bitLength(), random); // 무작위 시작점
        BigInteger y = x;
        BigInteger c = new BigInteger(n.bitLength(), random); // 무작위 상수
        BigInteger d = ONE;
        while (d.compareTo(ONE) == 0) {
            x = x.multiply(x).mod(n).add(c).mod(n);
            y = y.multiply(y).mod(n).add(c).mod(n);
            y = y.multiply(y).mod(n).add(c).mod(n);
            d = x.subtract(y).gcd(n);
        }
        return d;
    }
}
