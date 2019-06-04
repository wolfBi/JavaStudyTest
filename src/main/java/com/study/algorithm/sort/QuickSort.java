package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 快速排序   时间复杂度 O(N*log2N)   算法复杂度最佳 O(n log n)  最糟情况：算法复杂度O(n^2)
 * 性能高度依赖于你选择的基准值。
 * 1、n大时好，快速排序比较占用内存，内存随n的增大而增大，但却是效率高不稳定的排序算法。
 * 2、划分之后一边是一个，一边是n-1个，
 * 这种极端情况的时间复杂度就是O(N^2)
 * 3、最好的情况是每次都能均匀的划分序列，O(N*log2N)
 * <p>
 * 基本思想
 * 随机找出一个数，可以随机取，也可以取固定位置，
 * 一般是取第一个或最后一个称为基准，然后就是比基准小的在左边，
 * 比基准大的放到右边，如何放做，就是和基准进行交换，
 * 这样交换完左边都是比基准小的，右边都是比较基准大的，
 * 这样就将一个数组分成了两个子数组，
 * 然后再按照同样的方法把子数组再分成更小的子数组，直到不能分解为止。
 * https://www.cnblogs.com/redbear/p/8891730.html
 * https://baijiahao.baidu.com/s?id=1617821935743300963&wfr=spider&for=pc
 */
public class QuickSort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0, 100000, 100000);
        new QuickSort(sortArr).go("快速",true);
    }

    /**
     * !useOptimize 100000 20ms
     * useOptimize  100000 15ms
     * @return
     */
    @Override
    int[] sort() {
        //查看数组是否为空
        if (sortArr.length > 0) {
            quickSort(sortArr, 0, sortArr.length - 1,true);
        }
        return sortArr;
    }

    /**
     * 优化的
     * @param arr 带排序数组
     * @param l     开始位置
     * @param r    结束位置
     */
    public int getMiddle2(int[] arr, int l, int r) {
        int randInt =(int)(Math.random()*1000)%(r-l+1)+l;
        swap(arr,l,randInt);
        int v = arr[l];
        int i = l+1, j = r;
        while (true){
            while (i <= r && arr[i] <v) i++;
            while (j >= l+1 && arr[j] > v) j--;
            if(i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    public int getMiddle(int[] numbers, int low, int high) {
        int i,j,temp,t;
        if(low>high){
            return -1;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = numbers[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=numbers[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=numbers[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        numbers[low] = numbers[i];
        numbers[i] = temp;

        return j; // 返回中轴的位置
    }

    /**
     * 递归形式的分治排序算法
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public void quickSort(int[] numbers, int low, int high,boolean useOptimize) {

        if(high-low <= 15){//优化一
            insertionSort(numbers,low,high);
        }else if (low < high) {
            int middle;
            if(useOptimize){
                middle = getMiddle2(numbers, low, high); //将numbers数组进行一分为二
            }else{
                middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            }
            if(middle>=0){
//                System.out.println("middle = [" + middle + "], low = [" + low + "], high = [" + high + "]");
                quickSort(numbers, low, middle - 1,useOptimize);   //对低字段表进行递归排序
//                System.out.println("对低字段表进行递归排序");
//                output();
                quickSort(numbers, middle + 1, high,useOptimize); //对高字段表进行递归排序
//                System.out.println("对高字段表进行递归排序");
//                output();
            }
        }
    }

    public QuickSort(int[] sortArr) {
        super(sortArr);
    }

}
