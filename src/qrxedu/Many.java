package qrxedu;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Many {
    public static int size = 5;
    public static CyclicBarrier cb;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//申请资源
                        System.out.println(Thread.currentThread().getName()+"抢到车位");
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()+"归还车位");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //释放资源
                        semaphore.release();
                    }

                }
            },"线程"+i).start();
        }
    }
    static class myThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "wait");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "go");
        }
    }

    /*
        直接插入排序
        选择排序
        冒泡排序
        堆排序
        快排
        归并排序
     */
    // 直接插入排序
    public void insertSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int j = i-1;
            int num = arr[i];
            for(; j >= 0; j--){
                if(num < arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = num;
        }
    }

    // 选择排序
    public void selectSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int k = i;
            for(int j = i; j < n; j++){
                if(arr[j] < arr[i]){
                    k = j;
                }
            }
            if(i != k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }

    // 冒泡排序
    public void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n -1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // 堆排序
    public void heapSort(int[] arr){
        createHeap(arr);
        int end = arr.length - 1;
        // 升序排列--->创建大顶堆,然后每次将堆顶元素移到末尾,然后针对0~end的元素重新建堆
        while (end > 0) {
            int temp = arr[end];
            arr[end] = arr[0];
            arr[0] = temp;
            shiftDown(arr, 0, end);
            end--;
        }
    }

    private void createHeap(int[] arr){
        for(int parent = (arr.length-1-1)/2;parent >= 0; parent--){
            shiftDown(arr,parent,arr.length);
        }

    }
    private void shiftDown(int[] arr,int parent,int len){

        while(parent * 2 + 1 < len){
            int child = 2 * parent + 1;
            if(child + 1 < len && arr[child+1] > arr[child]){
                child++;
            }
            if(arr[child] > arr[parent]){
                int temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
            }
            parent = child;
        }
    }

    // 非递归快排
    public void quickSortNor(int[] arr){
        int l = 0,r = arr.length-1;
        Stack<Integer> s = new Stack<>();
        int pivot = partition(arr,l,r);
        if(l< pivot){
            s.push(l);
            s.push(pivot);
        }
        if(pivot + 1 < r){
            s.push(pivot+1);
            s.push(r);
        }
        while(!s.isEmpty()){
            int right = s.pop();
            int left = s.pop();
            int p = partition(arr,left,right);
            if(left < p){
                s.push(left);
                s.push(p);
            }
            if(p + 1 < right){
                s.push(p+1);
                s.push(right);
            }
        }
    }

    // 递归快排
    public void quickSort(int[] arr){
        quickSortChild(arr,0,arr.length-1);
    }
    private void quickSortChild(int[] arr,int l,int r){
        int pivot = partition(arr,l,r);
        if(l < r) {
            quickSortChild(arr,l,pivot);
            quickSortChild(arr,pivot+1,r);
        }

    }
    private int partition(int[] arr,int left,int right){
        int num = arr[left];
        while(left < right){
            while(left < right && arr[right] >= num){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= num){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = num;
        return left;
    }

    public void mergeSortNor(int[] arr){
        int cap = 1;
        int n = arr.length;
        while(cap < n) {
            for (int i = 0; i < n; i += 2 * cap) {
                int l = i;
                int mid = i + cap - 1;
                int r = mid + cap;
                if (r < n) {
                    combineTwoArr(arr, l, mid, r);
                }
            }
            cap *= 2;
        }
    }
    // 递归归并排序
    public void mergeSort(int[] arr){
        merge(arr,0,arr.length-1);
    }
    private void merge(int[] arr,int l,int r){
        if(l < r){
            int mid = l + r >> 1;
            merge(arr,l,mid);
            merge(arr,mid+1,r);
            combineTwoArr(arr,l,mid,r);
        }
    }
    private void combineTwoArr(int[] arr,int l,int mid,int r){
        int[] curArr = new int[r-l+1];
        int idx = 0;
        int i1 = l,i2 = mid+1;
        while(i1 <= mid && i2 <= r){
            if(arr[i1] <= arr[i2]){
                curArr[idx++] = arr[i1++];
            }else{
                curArr[idx++] = arr[i2++];
            }
        }
        if(i1 > mid){
            for(;i2 <= r; i2++){
                curArr[idx++] = arr[i2];
            }
        }else{
            for(;i1 <= mid; i1++){
                curArr[idx++] = arr[i1];
            }
        }
        for(int i = 0; i < curArr.length; i++){
            arr[i+l] = curArr[i];
        }
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<TreeNode>> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int row = 0;
        q.offer(root);
        while(!q.isEmpty()){

            int size = q.size();
            List<TreeNode> curL = new ArrayList<>();
            while(size != 0){
                TreeNode cur = q.poll();
                curL.add(cur);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            if(row % 2 != 0){
                reverse(curL);
            }
            row++;
            l.add(curL);
        }
        int n = l.size();
        for(int i = 0; i < n-1; i++){
            List<TreeNode> list = l.get(i);
            for(int j = 0; j < list.size(); j++){
                TreeNode node = list.get(j);
                node.left = l.get(i+1).get(j*2);
                node.right = l.get(i+1).get(j*2+1);
            }
        }
        return l.get(0).get(0);
    }
    private void reverse(List<TreeNode> list){
        int l = 0,r = list.size()-1;
        while(l < r){
            TreeNode cur = list.get(l);
            list.set(l,list.get(r));
            list.set(r,cur);
            l++;
            r--;

        }
    }
    public int[] sumPrefixScores(String[] words) {
        Map<String,HashSet<Integer>> map = new HashMap<>();
        int n = words.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            String word = words[i];
            for(int j = 0; j < word.length(); j++){
                String s = word.substring(0,j+1);
                if(map.containsKey(s)){
                    map.get(s).add(i);
                }else{
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(s,set);
                }
            }
        }
        Set<String> set = map.keySet();
        for(String s : set){
            HashSet<Integer> l = map.get(s);
            for(int index : l){
                answer[index]+=l.size();
            }
        }

        return answer;
    }
    @Test
    public void show() {

        String[] s = {"abc","ab","bc","b"};
        System.out.println(sumPrefixScores(s));
//        TreeNode r1 = new TreeNode(2);
//        TreeNode r2 = new TreeNode(3);
//        TreeNode r3 = new TreeNode(5);
//        TreeNode r4 = new TreeNode(8);
//        TreeNode r5 = new TreeNode(13);
//        TreeNode r6 = new TreeNode(21);
//        TreeNode r7 = new TreeNode(34);
//        r1.left = r2;
//        r1.right = r3;
//        r2.left = r4;
//        r2.right = r5;
//        r3.left = r6;
//        r3.right = r7;
//        System.out.println(reverseOddLevels(r1));
    }
}














//    public static void dfs(List<File> list,char key,File dirFile) throws IOException {
//        File[] files = dirFile.listFiles();
//        if(files == null || files.length == 0){
//            return;
//        }
//        for(File file : files) {
//            if (file.isDirectory()) {
//                dfs(list, key, file);
//            } else {
//                Reader reader = new FileReader(file);
//                char[] buf = new char[1024];
//                int len = 0;
//                while(true){
//                    len = reader.read(buf);
//                    if(len == -1){
//                        break;
//                    }
//                    if(new String(buf,0,len).contains(key+"")){
//                        list.add(file);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//}
