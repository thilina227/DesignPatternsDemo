package designpatternsdemo.proxy;

import java.util.LinkedList;
import java.util.Random;


public class Client {
    public static void main(String[] args) {
//        PrimeNumberFinder primeFinder = new PrimeFinderProxy();
//        iGotAPrimeFinder(primeFinder);
//        printRandomPrime(primeFinder);

         PrimeFinderProxy proxy = new PrimeFinderProxy();
         iGotAPrimeFinder(proxy);
        
         printRandomPrime(proxy);
    }
    
    static void iGotAPrimeFinder(PrimeNumberFinder primeFinder) {
        System.out.println("I got a prime finder: " + primeFinder);
    }
    
    static void printRandomPrime(PrimeNumberFinder primeFinder) {
        System.out.println("Getting a random prime");
        System.out.println("Random Prime: " + primeFinder.getNthPrime(new Random().nextInt(20000)));
    }
 
}



interface PrimeNumberFinder {
    int getNthPrime(int n);
}



class TwentyThousandPrimes implements PrimeNumberFinder{
    private LinkedList<Integer> primeNumbers = new LinkedList<>();

    public TwentyThousandPrimes() {
        System.out.println("starting prime number generation");
        for (int i = 2; primeNumbers.size() <= 20000; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        System.out.println("prime numbers generated");
    }
    
    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int getNthPrime(int n) {
        return primeNumbers.get(n);
    }   
}



class PrimeFinderProxy implements PrimeNumberFinder {
    private static TwentyThousandPrimes primeFinder;
    
    @Override
    public int getNthPrime(int n) {
        if (primeFinder == null) {
            primeFinder = new TwentyThousandPrimes();
        }
        
        return primeFinder.getNthPrime(n);
    }
    
}

