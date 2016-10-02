import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ebayram on 1.10.2016.
 */
public class Tools {
    Map<Long,Long> divisorCountMap=new HashMap<>();
    long getDivisorCount(long n){
        if(n==1)
        {
            return 1;
        }
        if(isPrime(n)){
            return 2;
        }
        Long divisorCount=divisorCountMap.get(n);
        if(divisorCount==null) {
            divisorCount=new Long(1);
            int index=1;
            long nClone=n;
            while(nClone!=1) {
                long prime = getNthPrime(index);

                long currentCount = 0;
                while (nClone % prime == 0) {
                    nClone = nClone / prime;
                    currentCount++;
                }
                divisorCount*=currentCount+1;
                index++;
            }
            divisorCountMap.put(n,divisorCount);
        }

        return  divisorCount;
    }
    boolean isPrime(long primeCandidate) {
        BigInteger candidate=BigInteger.valueOf(primeCandidate);
        if (!candidate.isProbablePrime(3)) {
            return false;
        } else {
            int n = 1;
            long nthPrime = getNthPrime(n++);
            long sqrt=(long)Math.sqrt(primeCandidate);
            while (nthPrime<sqrt) {
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
}
