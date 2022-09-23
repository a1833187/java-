package qrxedu.sort;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 直接插入排序
 * 适用于数据量小，且整体数据趋于有序
 *
 * @author qiu
 * @version 1.8.0
 */
public class TesSort {
    /**
     * 直接插入排序
     * 稳定性：稳定
     *
     * @param array
     */

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 每次预排序
     *
     * @param array 待排序序列
     * @param gap   组数
     */
    public void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度(和增量有关系)：O(n^1.3-n^1.5)
     * 稳定性：不稳定
     *
     * @param array
     */
    public void shellSort(int[] array) {
        int gap = array.length;
        //预排序
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        //最终排序
        shell(array, 1);
    }

    /**
     * 选择排序
     */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 堆排序
     * 时间复杂度：O(n * logn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public void heapSort(int[] array) {
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            int temp = array[end];
            array[end] = array[0];
            array[0] = temp;
            shiftDown(array, 0, end);
            end--;
        }
    }

    public void createHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    public void shiftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }

        }
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * 快排优化都是基于基准值的优化：
     * 1.随机选取基准值
     * 2.三数取中法选取基准值
     * 3.在partition中将与基准值相同的元素移到跟前:思路；在找到基准值之后，遍历基准值左边的区间找到相同的值移到
     * 跟前，遍历基准值右边的值移到跟前，并记录左右两侧边缘的下标，然后将左右递归的下标改成新纪录的左右 下标
     * 4.当某个分段的大小小于某个阈值时，可以直接使用直接插入排序
     * 时间复杂度：最好：O(n * log n)  最坏：O(n^2)(数组有序----> 单分支)
     * 空间复杂度：最好：O(log n)      最坏：O(n)
     * 稳定性：不稳定
     * 对于基准值的选择当中，如果选择边上的作为基准值，在面对大数据有序的情况下可能会发生栈溢出的情况
     * 因此可以采用三数取中法(实质上就是尽可能的让 树 更倾向于完全二叉树)
     */
    public void quickSortNor(int[] array) {
        int left = 0;
        int right = array.length - 1;
        Stack<Integer> stack = new Stack<>();
        int pivot = partition(array, left, right);
        if (pivot > left + 1) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot < right - 1) {
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(array, left, right);
            if (pivot > left + 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot < right - 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }

    }

    public void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public void insertSort(int[] array, int start, int end) {

    }

    public void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //直接插入排序优化快排
        if (right - left + 1 < 100) {
            insertSort(array, left, right);
            return;
        }
        //三数取中法
        int midIndex = findMidIndex(array, left, right);
        int temp = array[left];
        array[left] = array[midIndex];
        array[midIndex] = temp;
        int pivot = partition(array, left, right);
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    /**
     * 三数取中法
     *
     * @param array 待排序序列
     * @param start 起始下标
     * @param end   末尾下标
     * @return
     */
    public int findMidIndex(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        if (array[start] < array[end]) {
            if (array[mid] < array[start]) {
                return start;
            } else if (array[mid] > array[end]) {
                return end;
            } else {
                return mid;
            }
        } else {
            if (array[mid] < array[end]) {
                return end;
            } else if (array[mid] > array[start]) {
                return start;
            } else {
                return mid;
            }
        }
    }

    public int partition(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= tmp) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }

//    public int[] mergeArray(int[] arr1, int[] arr2) {
//        int z1 = 0, z2 = 0;
//        int len1 = arr1.length, len2 = arr2.length;
//        int[] res = new int[len1 + len2];
//        int k = 0;
//        while (z1 < len1 && z2 < len2) {
//            if (arr1[z1] <= arr2[z2]) {
//                res[k] = arr1[z1];
//                k++;
//                z1++;
//            } else {
//                res[k] = arr2[z2];
//                k++;
//                z2++;
//            }
//        }
//        if (z1 == len1) {
//            for (int i = z2; i < len2; i++) {
//                res[k++] = arr2[i];
//            }
//        } else {
//            for (int i = z1; i < len1; i++) {
//                res[k++] = arr1[i];
//            }
//        }
//        return res;
//    }

    public void mergeSort(int[] array) {
        mergeSortFunc(array,0,array.length-1);
    }

    public void mergeSortFunc(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortFunc(array,low,mid);
        mergeSortFunc(array,mid+1,high);
        merge(array,low,mid,high);
    }
    public void merge(int[] array, int low, int mid, int high){
        int[] res = new int[high - low + 1];
        int k = 0;
        int z1 = low,z2 = mid + 1;
        int len1 = mid - low + 1,len2 = high - mid;
        while (z1 < len1 && z2 < len2) {
            if (array[z1] <= array[z2]) {
                res[k] = array[z1];
                k++;
                z1++;
            } else {
                res[k] = array[z2];
                k++;
                z2++;
            }
        }
        if (z1 == len1) {
            for (int i = z2; i < len2; i++) {
                res[k++] = array[i];
            }
        } else {
            for (int i = z1; i < len1; i++) {
                res[k++] = array[i];
            }
        }
        for(int i = 0; i < k; i++){
            array[low + i] = res[i];
        }
    }
    public void mergeSortNor(int[] array){
        int nums = 1;
        while(nums < array.length){
            for(int i = 0; i < array.length;i += 2 * nums){
                int left = i;
                int mid = left + nums - 1;
                if(mid >= array.length){
                    mid = array.length - 1;
                }
                int right = mid + nums;
                if(right >= array.length){
                    right = array.length - 1;
                }
                merge(array,left,mid,right);
            }
            nums *= 2;
        }
    }

}
