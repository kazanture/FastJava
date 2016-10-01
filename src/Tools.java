import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebayram on 1.10.2016.
 */
public class Tools {
    List<BigInteger> primeNumbers = new ArrayList<>();
    BigInteger getNthPrime(int n) {
        BigInteger biggestPrime = primeNumbers.get(primeNumbers.size() - 1);
        BigInteger candidate = biggestPrime.add(BigInteger.ONE);
        while (primeNumbers.size() < n) {

            if (isPrime(candidate)) {
                primeNumbers.add(candidate);
            }
            candidate = candidate.add(BigInteger.ONE);
        }
        return primeNumbers.get(n-1);

    }
    boolean isPrime(BigInteger primeCandidate) {
        if (!primeCandidate.isProbablePrime(2)) {
            return false;
        } else {
            int n = 1;
            BigInteger nthPrime = getNthPrime(n++);
            while (nthPrime.compareTo(primeCandidate.divide(BigInteger.valueOf(2))) == -1) {
                if (primeCandidate.mod(nthPrime).compareTo(BigInteger.valueOf(0)) == 0) {
                    return false;
                }
                nthPrime = getNthPrime(n++);
            }
            return true;
        }
    }
    BigInteger getNthTriangleNumber(BigInteger n){
        return n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
    }
    long getDivisorCount(BigInteger n){
        int primeIndex=1;
        BigInteger currentPrime=getNthPrime(primeIndex++);
        long divisorCount=0;
        while(currentPrime.compareTo(n)==-1){
            int currentPrimeDivCount=0;
            while(n.mod(currentPrime).compareTo(BigInteger.ZERO)==0){
                currentPrimeDivCount++;
            }
            divisorCount+=currentPrimeDivCount;
            currentPrime=getNthPrime(primeIndex++);
        }
        return  divisorCount;
    }
}
