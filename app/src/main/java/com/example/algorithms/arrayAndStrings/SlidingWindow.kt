package com.example.algorithms.arrayAndStrings

//given a positive integer array nums and an integer k.
// We need to find the length of the longest subarray that has a sum less than or equal to k.
// For this example, let nums = [3, 2, 1, 3, 1, 1] and k = 5.
/*
    function fn(nums, k):
        left = 0
        curr = 0
        answer = 0
        for (int right = 0; right < nums.length; right++):
            curr += nums[right]
            while (curr > k):
                curr -= nums[left]
                left++

            answer = max(answer, right - left + 1)

        return answer
    *//*
For any array, how many subarrays are there?
If the array has a length of n, there are n subarrays of length 1. Then there are n - 1 subarrays
of length 2 (every index except the last one can be a starting index), n - 2 subarrays of length 3
and so on until there is only 1 subarray of length n
sliding window algorithms run in O(n)
 */
class SlidingWindow {


    /*
    You are given an integer array nums consisting of n elements, and an integer k.
    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    Any answer with a calculation error less than 10-5 will be accepted.
    Example
    Input: nums = [1,12,-5,-6,5,5,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     */
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var left = 0
        var sum = 0
        for (i in left until k) {
            sum += nums[i]
        }
        var currSum = sum
        for (right in k until nums.size) {
            currSum = currSum + nums[right] - nums[left]
            if (currSum > sum) {
                sum = currSum
            }
            left++
        }
        return sum / k.toDouble()
    }

    /*
     Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     Example 1:
     Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     Output: 6
     Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     */
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var maxOnes = 0
        var takenK = 0
        var currMaxOnes = maxOnes
        for (right in 0 until nums.size) {
            if (nums[right] == 0) {
                while (takenK >= k) {
                    if (nums[left] == 0) {
                        takenK--
                    }
                    currMaxOnes--
                    left++
                }
                takenK++

            }
            currMaxOnes++
            if (currMaxOnes > maxOnes) {
                maxOnes = currMaxOnes
            }
        }
        return maxOnes
    }
}
