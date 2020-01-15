package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 堆的某个节点的值总是大于等于子节点的值，并且堆是一颗完全二叉树.
 * 通过上浮和下沉来保持堆的性质。
 */
public class HeapSort {
    int size;
    int[] heap;

    public void heapify() {
        size = 1;
        for (int i = 1; i < heap.length; ++i) {
            insert(i);
        }
    }

    public void insert(int k) {
        swim(k);
        ++size;
    }

    public void delete(int k) {
        --size;
        swap(0, k);
        sink(0);
    }

    public void swim(int k) {
        while (k >= 1 && heap[k] > heap[k/2]) {
            swap(k, k/2);
            k /= 2;
        }
    }

    public void sink(int k) {
        while (2 * k + 1 < size) {
            int i = 2 * k + 1;
            if (i + 1 < size && heap[i+1]  > heap[i]) i = i + 1;
            if (heap[k] < heap[i]) {
                swap(k, i);
                k = i;
            } else break;
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapSort(int[] n) {
        heap = n;
        heapify();
        for (int i = n.length - 1; i > 0; --i) delete(i);
    }

    public void sort(int[] n) {
        heapSort(n);
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        HeapSort solution = new HeapSort();
        solution.test();
    }
}
