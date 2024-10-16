package com.abhi.DSA.DsaPractice;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Sorting {
    List<Integer> list = new ArrayList<>();

    public Sorting(){

        System.out.println("------------------sorting-------------------");
        list.add(5);list.add(9);list.add(1);list.add(3);list.add(4);list.add(7);list.add(2);list.add(3);

//        // quickSort
//        List<Integer> quickList = new ArrayList<>(list);
//        quickSort(0, quickList.size() - 1, quickList);
//        System.out.println("quick sorting");
//        quickList.stream().forEach(x -> System.out.print(x + " "));
//
//        //merge sort
//        List<Integer> mergeList = new ArrayList<>(list);
//        mergeSort(0, mergeList.size() - 1, mergeList);
//        System.out.println("\nmerge sorting");
//        mergeList.stream().forEach(x -> System.out.print(x + " "));
//
//        //bubble sorting
//        List<Integer> bubbleList = new ArrayList<>(list);
//        bubbleSort(bubbleList);
//        System.out.println("\nbubble sorting");
//        mergeList.stream().forEach(x -> System.out.print(x + " "));
//
//
//        //bubble sorting
//        List<Integer> heapList = new ArrayList<>(list);
//        heapSort(heapList);
//        System.out.println("\nheap sorting");
//        heapList.stream().forEach(x -> System.out.print(x + " "));

        //heap sorting
        comparator();

        System.out.println();
    }

    // quick sort -- Time complexity(n*logn), worst time complexity - (n2) if array is sorted
    // first select a pivot, selecting random pivot is always beneficial in terms of time complexity. But for simplicity , I am choosing the first one.
    public void quickSort(int l, int r, List<Integer> ls) {
        if(l >= r)
            return;
        int pivot = l;
        l++;
        int i = pivot;
        int j = i + 1;
        // motive is to traverse all the elements and put elements smaller than pivot behind pivot
        while(j <= r) {
            if(ls.get(j) < ls.get(pivot))
                Collections.swap(ls, ++i, j);
            j++;
        }
        Collections.swap(ls, pivot, i);
        quickSort(pivot, i - 1, ls);
        quickSort(i + 1, r, ls);
    }

    // merge sort -- time and space complexity O(n*logn)
    private void mergeSort(int l, int r, List<Integer> ls) {
        if(l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSort(l, mid, ls);
        mergeSort(mid + 1, r, ls);
        merge(l, mid, r, ls);
    }
    private void merge(int l, int mid, int r,  List<Integer> ls) {
        int x = l;
        int y = mid + 1;
        List<Integer> tmp = new ArrayList<>();
        while(x <= mid && y <= r) {
            if(ls.get(x) < ls.get(y))
                tmp.add(ls.get(x++));
            else
                tmp.add(ls.get(y++));
        }
        while(x <= mid)
            tmp.add(ls.get(x++));
        while(y <= r)
            tmp.add(ls.get(y++));

        x = 0;
        while(l <= r)
            ls.set(l++, tmp.get(x++));
    }

    // bubble sort
    private void bubbleSort(List<Integer> ls) {
        int n = ls.size();
        for(int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while(j > i && ls.get(j) < ls.get(j - 1))
                Collections.swap(ls, j - 1, j--);
        }
    }

    // heap sort
    private void heapSort(List<Integer> heapList) {

    }

    //comparator
    public void comparator() {
        // copying list initialized in constructor
        ArrayList<Integer> ls = new ArrayList<>(list); // we cannot provide comparator during initialization in arraylist
        ls.sort((x, y) -> y - x);   //one way of sorting
        Collections.sort(ls, (x, y) -> x - y);  // other way of sorting
        ls.forEach(x -> System.out.print(x + " "));


        // we need to provide comparator to TreeSet during initialization
        TreeSet<Integer>  st = new TreeSet<>((x, y) -> {    // We are managing duplicates here as they are not allowed in set
            if(x.equals(y)) // by default, it will try to subtract one number from another and in case of 0, it will discard that number
                return 1;
            else
                return x - y;
        });
        st.add(1);st.add(10);st.add(10);st.add(1);st.add(3);st.add(4);st.add(4);st.add(6);
        System.out.println("\noutput of treeset::");
        Iterator<Integer> it = st.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // remember not to provide comparator in hashset
    }

}
