package qrxedu.sort;

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
     * 时间复杂度：最好：O(n * log n)  最坏：O(n^2)(数组有序----> 单分支)
     * 空间复杂度：最好：O(log n)      最坏：O(n)
     * 稳定性：不稳定
     */
    public void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
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
}
