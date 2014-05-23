package quick_sort;

import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;

public class QuickSort{
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 10; i > 0; i--)
            arr.add(i);

        System.out.println("Array_start:");
        for(Integer m:arr){
            System.out.print(m + " ");
        }

        ThreadGroup group = new ThreadGroup("QuickSorter");
        Thread t = new QuickSorter(arr, 0, arr.size() - 1, group);
        t.start();
            while(t.isAlive())
            {
            }
        long after = System.currentTimeMillis();
        long diff = after - before;
        System.out.println("\nArray_end:");
        for(Integer m:arr){
            System.out.print(m + " ");
        }
        System.out.println("\nTime:" + diff);
    }

}