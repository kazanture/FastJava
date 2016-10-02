import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebayram on 2.10.2016.
 */
public class PrimeNumbers {

    public static void main(String[] args) throws IOException {
        new PrimeNumbers().main();
    }
    void main() throws IOException {
        init();
        run();
    }
    boolean isPrime(long primeCandidate) {
        BigInteger candidate=BigInteger.valueOf(primeCandidate);
        if (!candidate.isProbablePrime(3)) {
            return false;
        } else {
            int n = 1;
            long nthPrime = getNthPrime(n++);
            while (nthPrime<primeCandidate/2) {
                if (primeCandidate%nthPrime == 0) {
                    return false;
                }
                nthPrime = getNthPrime(n++);
            }
            return true;
        }
    }
    List<Long> primeNumbers = new ArrayList<>();

    long getNthPrime(int n) {
        long biggestPrime = primeNumbers.get(primeNumbers.size() - 1);
        long candidate=biggestPrime+1;
        while (primeNumbers.size() < n) {

            if (isPrime(candidate)) {
                primeNumbers.add(candidate);
            }
            candidate +=1;
        }
        return primeNumbers.get(n-1);

    }
    private void init() {
        primeNumbers.add(2L);
        primeNumbers.add(3L);
        primeNumbers.add(5L);
        primeNumbers.add(7L);
        primeNumbers.add(11L);
        primeNumbers.add(13L);
        primeNumbers.add(17L);
        primeNumbers.add(19L);
        primeNumbers.add(23L);
        primeNumbers.add(29L);
    }
    public void run() throws IOException {
        System.out.println("is 321312323 prime="+isPrime(321312323));
        System.out.println("is 117763 prime="+isPrime(117763));
        System.out.println("is 6739695643 prime="+isPrime(6739695643L));
        System.out.println("is 380291 prime="+isPrime(380291));
        System.out.println("is 3 prime="+isPrime(3));
        System.out.println("is 2 prime="+isPrime(2));
        System.out.println("is 4 prime="+isPrime(4));


    }
}
