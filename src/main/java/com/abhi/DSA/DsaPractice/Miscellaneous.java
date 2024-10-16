package com.abhi.DSA.DsaPractice;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Miscellaneous {
    // prime numbers
    // linked list
    // gcd
    // binary search + lowerBound

    public Miscellaneous() {
        System.out.println("Miscellaneous--------------");
        //binarySearch();
        // gcdPractice();
        //primeNumbers();

    }
    public void binarySearch() {
        List<Integer> ls = new ArrayList<>();
        ls.add(2);ls.add(3);ls.add(1);ls.add(5);ls.add(7);ls.add(4);ls.add(9);ls.add(8);

        Collections.sort(ls); // 1 2 3 4 5 7 8 9
        ls.forEach(x -> System.out.print(x + " "));

        int key = 5;
        int lo = -1, hi = ls.size();
        while(hi - lo > 1) {
            int mid = (lo + hi) / 2;
            if(ls.get(mid) <= key)
                lo = mid;
            else
                hi = mid;
        }
        // for lower bound print hi.
        System.out.println("\nindex:: " + lo);
    }

    public int gcd(int x, int y) {
        if(y == 0)
            return x;
        return gcd(y, x % y);
    }
    public void gcdPractice() {
        int x = 30, y = 75;
        System.out.println("\ngcd of " + x + ", " + y + " = " + gcd(x, y));
    }

    public void primeNumbers() {
       //list of prime number--
        int N = 100000;
        boolean[] h = new boolean[N];
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(h[i])
                continue;
            else
                ls.add(i);
            for(int j = i*2; j < N; j += i) {
                h[j] = true;
            }
        }
        int nthPrimeNumber = 5;
        System.out.println("\nnth prime number:: " + ls.get(nthPrimeNumber - 1));
    }


}
