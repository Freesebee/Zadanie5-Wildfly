package wipb.jsfdemo.web.service;

import javax.ejb.*;
import java.math.BigInteger;

@Stateless
public class PrimeNumberService {
    public boolean primeCheck(BigInteger number) {
        if (!number.isProbablePrime(5))
            return false;

        BigInteger two = new BigInteger("2");
        if (two.equals(number) || BigInteger.ZERO.equals(number.mod(two)))
            return false;

        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) {
            if (BigInteger.ZERO.equals(number.mod(i)))
                return false;
        }
        return true;
    }
}

