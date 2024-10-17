package com.school.algorithm.randomquicksort;

/**
 * 求解数组中第k大的元素
 * 以升序数组为例，第k大的元素下标为 array.length - k。
 * 无序数组排序后其中元素位置确定，可以利用排序后定位求解，但不佳。
 * 既是求解元素排序后位置，利用荷兰国旗（三分区）问题可以直接定位元素。
 *
 * @author 黄兴鑫
 * @since 2024/10/17 20:59
 */
public class KthLargestElement {
    private static int left;
    private static int right;

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int i = nums.length - k;
        while (l <= r) {
            partition(nums, l, r, nums[l + (int)(Math.random() * (r - l + 1))]);
            if (i < left) {
                r = left - 1;
            } else if (i > right) {
                l = right + 1;
            } else {
                break;
            }
        }
        return nums[i];
    }

//    2 5 4 5 6 5 7 8   5
//        a
//              b
//            i
    public void partition(int[] nums, int l, int r, int baseline) {
        int a = l;
        int b = r;
        int i = l;
        while (i <= b) {
            if (nums[i] < baseline) {
                swap(nums, a++, i++);
            } else if (nums[i] == baseline) {
                i++;
            } else {
                swap(nums, b--, i);
            }
        }
        left = a;
        right = b;
    }

    private void swap(int[] nums, int locA, int locB) {
        int temp = nums[locA];
        nums[locA] = nums[locB];
        nums[locB] = temp;
    }
}
