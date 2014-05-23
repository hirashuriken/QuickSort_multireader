package quick_sort;

import java.util.ArrayList;


public class QuickSorter extends Thread{
    private ArrayList<Integer> arr;
    int left;
    int right;
    public QuickSorter(ArrayList<Integer> arr, int left, int right, ThreadGroup g)
    {
        super(g, "QuickSorter");
        this.arr = arr;
        this.left = left;
        this.right = right;

    }
    public void run()
    {
        if(left >= right || left < 0 || right >= arr.size())
        {
            return;
        }
        if(right - left < 20)
        {
            for(int i = left; i <= right; i++)
            {
                int tmp = arr.get(i);
                int j = i;
                for(; j > 0 && tmp < arr.get(j - 1); j--)
                    arr.set(j, arr.get(j - 1));

                arr.set(j, tmp);//[j] = tmp;
            }
            return;
        }
        int pivotIdx = (right + left) / 2;
        int pivot = arr.get(pivotIdx);
        int i = left;
        int j = right;

        while(i < j)
        {
            while(arr.get(i) < pivot)
                i++;

            while(arr.get(j) > pivot)
                j--;
            if(i >= j)
                break;
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }
        QuickSorter leftQS = new QuickSorter(arr, left, i - 1, this.getThreadGroup());
        leftQS.start();
        QuickSorter rightQS = new QuickSorter(arr, i + 1, right, this.getThreadGroup());
        rightQS.start();

    }
}

