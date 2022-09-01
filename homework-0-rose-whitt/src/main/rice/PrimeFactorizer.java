package main.rice;

import java.util.Arrays;

/**
 * This class implements a relatively simple algorithm for computing the prime factors
 * of a number.  At initialization, a list of primes is computed. Given a number, this
 * list is used to efficiently compute the prime factors of that number.
 */
public class PrimeFactorizer {

    // Fields
    /**
     * primeCandidates is an array that will be appropriately filled with integers
     * in the primeCandidatesFiller method
     */
    private int[] primeCandidates;
    /**
     *  crossedPrimes is not a group of prime numbers having a good night, but rather an array that
     *  will contain the results of the sieveOfEratosthenes method.
     */
    private int[] crossedPrimes;
    /**
     * allPrimes is an array that will contain the prime numbers from 2 to the square root of
     * the maxNumToFactorize
     */
    private int[] allPrimes;
    /**
     * tempPrimeFactors initialized in computePrimeFactorization to size of numToFactorize,
     * filled with zeros (default), prime factors added to array in ascending order.
     */
    private int[] tempPrimeFactors;
    /**
     * primeFactorization initialized in computePrimeFactorization to size of num of prime factors
     * found, will contain prime factors of numToFactorize, computePrimeFactorization returns it
     */
    private int[] primeFactorization;
    /**
     * maxNumToFactorize is an integer storing the maximum number to be factorized
     */
    private int maxNumToFactorize;

    /**
     * The constructor for a PrimeFactorizer takes in the integer maxNumToFactorize and is able to
     * efficiently compute the prime factorization of many different numbers using helper methods.
     * First, an array is filled with all of the prime candidates and then
     * the sieve of eratosthenes algorithm "crosses out" candidates that are not prime.
     * Finally, the array allPrimes, is assigned the candidates that have not been crossed out
     * (the prime numbers).
     *
     * @param maxNumToFactorize- an integer that represents the maximum value that this PrimeFactorizer
     *                         will be capable of factorizing
     */
    public PrimeFactorizer(int maxNumToFactorize) {
        this.primeCandidates = primeCandidatesFiller(maxNumToFactorize);
        this.crossedPrimes = sieveOfEratosthenes(primeCandidates);
        this.allPrimes = allPrimes(crossedPrimes);
        this.maxNumToFactorize = maxNumToFactorize;
    }

    // constructor helper methods

    /**
     * This is a helper method for the constructor that fills an array with the "prime candidates",
     * or the integers from 2 to the square root of length, inclusive.
     *
     * @param length- the number that the size of the array will be calculated by (maxNumToFactorize)
     * @return- primeCandidates, an array containing all numbers 2 : square root of length
     */
    private int[] primeCandidatesFiller(int length) {
        int maxPrime = (int) Math.ceil(Math.sqrt(length));
        // maxPrime - 1 since array begins at 2
        this.primeCandidates = new int[maxPrime - 1];

        // iterate over primeCandidates and assign values accordingly
        for (int i = 0; i < primeCandidates.length; i++) {
            primeCandidates[i] = i + 2;
        }
        return primeCandidates;
    }

    /**
     * This is a helper method for the constructor that utilizes the Sieve of Eratosthenes algorithm.
     * The algorithm iteratively determines which candidates from the input array, primeCandidates,
     * are actually prime by using the known primes to "cross out" the larger candidates
     * that are multiples of the known primes.
     *
     * @param array- an integer array, primeCandidates, that the method will perform the algorithm on
     * @return- array, the input array with composites set to 0
     */
    private int[] sieveOfEratosthenes(int[] array) {
        // iterate over array
        for (int i = 0; i < array.length; i++) {
            // num is not crossed out
            if (array[i] != 0) {
                // iterate through elements to the right of array[i]
                for (int j = i + 1; j < array.length; j++) {
                    // if num2 is a multiple of num1, not prime
                    if (array[j] % array[i] == 0) {
                        // "cross out" by setting equal to zero
                        array[j] = 0;
                    }
                }
            }
        }

        return array;
    }

    /**
     * This is a helper method for the constructor that removes elements that were "crossed out"
     * in the Sieve of Eratosthenes algorithm and assigns the leftover elements, the primes, to a
     * new array, allPrimes.
     * @param array- the primeCandidates array after being passed through the Sieve of Eratosthenes algorithm
     * @return allPrimes- an integer array containing all of the prime numbers from 2 to the square root
     *                      of maxNumToFactorize, inclusive.
     */
    private int[] allPrimes (int[] array) {
        // count num of primes
        int countPrime = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                countPrime++;
            }
        }

        // initialize new array for primes
        this.allPrimes = new int[countPrime];
        int allPrimesIndex = 0;
        // iterate over crossed out array
        for (int i = 0; i < array.length; i++) {
            // if the element has not been crossed out, it is prime
            if (array[i] != 0) {
                // add the prime to the allPrimes array at the proper index
                allPrimes[allPrimesIndex] = array[i];
                allPrimesIndex++;
            }
        }

        return allPrimes;
    }


    /**
     * Using helper methods, this method computes and returns the prime factorization
     * of the input number in the form of an array of prime integers sorted in ascending order.
     *
     * @param numToFactorize- an integer that represents the maximum value that this PrimeFactorizer
     *      *                 will be capable of factorizing
     * @return primeFactorization- represents the prime factorization of the inputm number in the form
     *                              of an array of prime integers sorted in ascending order
     */
    public int[] computePrimeFactorization(int numToFactorize) {
        // if input is -1, 0, 1, > max: null
        if (numToFactorize == -1 || numToFactorize == 0 || numToFactorize == 1 || numToFactorize > maxNumToFactorize) {
            return null;
        }

        // maximum prime factor is the square root of the number you want to factorize
        int maxPrimeFactor = (int) Math.ceil(Math.sqrt(numToFactorize));

        // create array size of original num
        tempPrimeFactors = new int[maxPrimeFactor];

        // copy original num to be changed
        int numToFactorizeCopy = numToFactorize;

        int numFactors = 0;

        // if originally prime
        if (isPrime(numToFactorize)) {
            primeFactorization = new int[]{numToFactorizeCopy};
        } else {
            // while the new num isn't prime
            while (inAllPrimes(numToFactorizeCopy) != true) {
                // for each prime (starting at smallest)
                if (isPrime(numToFactorizeCopy) && numToFactorizeCopy > allPrimes[allPrimes.length-1]) {
                    break;
                }

                for (int i = 0; i < allPrimes.length; i++) {
                    // if the number is divisible by a prime (or any integer), it cannot be prime
                    if (numToFactorizeCopy % allPrimes[i] == 0) {
                        // make first non-zero == num to factorize copy
                        for (int j = 0; j < tempPrimeFactors.length; j++) {
                            // if you have reached your first empty element
                            if (tempPrimeFactors[j] == 0) {
                                // add your prime factor to the factorization tree (tempPrimeFactors)
                                tempPrimeFactors[j] = allPrimes[i];
                                break;
                            }
                        }

                        // update the number you are computing a prime factorization on
                        numToFactorizeCopy = numToFactorizeCopy / allPrimes[i];
                        break;
                    }
                }
            }
        }

        // add the final prime factor
        for (int j = 0; j < tempPrimeFactors.length; j++) {

            if (tempPrimeFactors[j] == 0) {
                tempPrimeFactors[j] = numToFactorizeCopy;

                break;
            }
        }

        // count number of factors
        for (int a = 0; a < tempPrimeFactors.length; a++) {
            // non-zero entries are the prime factors
            if (tempPrimeFactors[a] != 0) {
                numFactors++;
            } else {
                break;
            }

        }

        // initialize primeFactorization with size of number of factors
        primeFactorization = new int[numFactors];
        // transfer prime factors over to final array, primeFactorization
        for (int k = 0; k < primeFactorization.length; k++) {
            primeFactorization[k] = tempPrimeFactors[k];
        }
        return primeFactorization;
    }



    // computePrimeFactorization helper methods

    /**
     * This is a helper method for computePrimeFactorization that indicates whether the input,
     * numToFactorize, is a prime number by searching the array allPrimes and returning a boolean value.
     * If it is true, the input number is prime. This method is used when determining if an integer
     * is in the allPrimes array and thus prime/a prime factor.
     *
     * @param numToFactorize- an integer that represents the maximum value that this PrimeFactorizer
     *                      will be capable of factorizing
     * @return- boolean (true, false) indicating whether the input is in allPrimes or not
     */
    private boolean inAllPrimes(int numToFactorize) {
        for (int i = 0; i < this.allPrimes.length; i++) {
            // if the input is found in the allPrimes array, it must be prime
            if (this.allPrimes[i] == numToFactorize) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is a helper method for computePrimeFactorization that indicates if the input is prime by
     * iterating over the allPrimes array and dividing the input by each element. If the input can be
     * divided without a remainder, the input cannot be a prime. This method is used when determining
     * if a number greater than the maximum prime factor, the square root of numToFactorize, is prime.
     *
     * @param numToFactorize
     * @return boolean (true, false) indicating whether the input is a prime number or not
     */
    private boolean isPrime(int numToFactorize) {
        for (int i = 0; i < this.allPrimes.length; i++) {
            // if the input is divisible by an element in allPrimes (or any number), it cannot be prime
            if (numToFactorize % this.allPrimes[i] == 0) {
                return false;
            }
        }
        return true;
    }



}
