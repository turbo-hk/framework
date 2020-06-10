package com.story.code.helper;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/29 by Storys.Zhang
 */
public class HeapSortTest {


    @Test
    public void test() {

        int arr[] = {9,5,8,5,0,2,4,7,1,9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr){
        //构建大顶堆
        for (int i = arr.length/2-1; i >= 0 ; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //调整堆结构，交换堆顶元素和末尾元素
        for (int i = arr.length-1; i >0 ; i--) {
            swap(arr, 0, i);//堆顶元素和末尾元素进行互换
            adjustHeap(arr, 0, i);
        }

    }

    private void swap(int[] arr, int i, int i1) {

        int temp = arr[i];  

        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    private void adjustHeap(int[] arr, int i, int len){
        int temp = arr[i];

        for (int k = 2*i + 1; k < len; k = 2*k+1){
            if (k+1 < len && arr[k] <arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                swap(arr, i, k);

                i = k;
            }else {
                break;
            }
        }

    }
}
