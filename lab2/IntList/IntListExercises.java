package IntList;

public class IntListExercises {

    /**
     * Part A: Fixed mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        while (head != null) {  // Fixed: now processes all nodes including the last one
            head.first += c;
            head = head.rest;
        }
    }

    /**
     * Part B: Fixed method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            int currentMax = max(p);
            boolean firstEqualsLast = firstDigitEqualsLastDigit(currentMax);
            if (firstEqualsLast) {
                p.first = 0;
            }
            p = p.rest;
        }
    }

    /** Returns the max value in the IntList starting at L. */
    public static int max(IntList L) {
        int max = L.first;
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

    /** Returns true if the last digit of x is equal to
     *  the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        if (x < 0) x = -x;  // Handle negative numbers
        if (x == 0) return true;  // Special case for 0
        int lastDigit = x % 10;
        while (x >= 10) {  // Fixed: now correctly handles numbers ending with 0
            x = x / 10;
        }
        int firstDigit = x;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: Fixed mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        if (lst == null) {
            return false;
        }
        boolean currElemIsPrime = Primes.isPrime(lst.first);
        if (currElemIsPrime) {
            lst.first *= lst.first;
        }
        boolean restChanged = squarePrimes(lst.rest);  // Fixed: ensures recursion always executes
        return currElemIsPrime || restChanged;
    }
}