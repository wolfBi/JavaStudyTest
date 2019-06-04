package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 堆排序  O(N*log2N)
 * 是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，
 * 它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * 堆是具有以下性质的完全二叉树：
 * 每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 * 每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 * 用简单的公式来描述一下堆的定义就是：
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 */
public class HeapSort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,100000,100000);
        new HeapSort(sortArr).go("堆",true);
    }

    public HeapSort(int[] sortArr) {
        super(sortArr);
    }

    @Override
    int[] sort() {
        return sort1();
    }

    /**
     * 100000  24ms
     * @return
     */
    int[] sort1() {
        //1.构建大顶堆
        for(int i=sortArr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(sortArr,i,sortArr.length);
//            output();
        }
//        System.out.println("构建结束");
//        output();
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=sortArr.length-1;j>0;j--){
            swap(sortArr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(sortArr,0,j);//重新对堆进行调整
//            output();
        }
        return sortArr;
    }
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
//        System.out.print("sort "+i+" val:"+ arr[i]);
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
//            System.out.print(";\t adjust "+k+" val:"+ arr[k]);
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
//                System.out.print("; 左子结点"+arr[k]+"小于右子结点"+arr[k+1]+"，k指向右子结点"+ arr[k]);
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                System.out.print("; 子节点"+arr[k]+"大于父节点"+arr[i]+"，将子节点值赋给父节点");
                arr[i] = arr[k];
                i = k;
            }else{
//                System.out.print("; break "+k);
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

}
