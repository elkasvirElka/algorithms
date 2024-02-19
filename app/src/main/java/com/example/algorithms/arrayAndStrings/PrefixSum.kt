package com.example.algorithms.arrayAndStrings

/*
Prefix sum is a technique that can be used on arrays (of numbers).
The idea is to create an array prefix where prefix[i] is the sum of all elements up to the index i (inclusive).
For example, given nums = [5, 2, 1, 6, 3, 8], we would have prefix = [5, 7, 8, 14, 17, 25]
 */
class PrefixSum {
    /*
    Example 1: Given an integer array nums, an array queries where queries[i] = [x, y] and an integer limit,
     return a boolean array that represents the answer to each query. A query is true if the sum of the subarray
      from x to y is less than limit, or false otherwise.
      For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and limit = 13,
       the answer is [true, false, true]. For each query, the subarray sums are [12, 14, 12].
       Complexity O(n+m)
     */
    fun answerQueries(nums: IntArray, queries: Array<IntArray>, limit: Int): BooleanArray {
        val prefix = IntArray(nums.size)
        prefix[0] = nums[0]
        for (i in 1 until nums.size) {
            prefix[i] = prefix[i - 1] + nums[i]
        }
        val ans = BooleanArray(queries.size)
        for (i in queries.indices) {
            val x = queries[i][0]
            val y = queries[i][1]
            val curr = prefix[y] - prefix[x] + nums[x]
            ans[i] = curr < limit
        }
        return ans
    }
    /*
    Given an integer array nums, find the number of ways to split the array into two parts so that
    the first section has a sum greater than or equal to the sum of the second section.
    The second section should have at least one number.
     */
    fun waysToSplitArray(nums: IntArray): Int {
        var ans = 0
        var leftSection: Long = 0
        var total: Long = 0
        for (num in nums) {
            total += num.toLong()
        }
        for (i in nums.indices - 1) {
            leftSection += nums[i].toLong()
            val rightSection = total - leftSection
            if (leftSection >= rightSection) {
                ans++
            }
        }
        return ans
    }

    /*
    Given an array of integers nums, you start with an initial positive value startValue.
    In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
    Return the minimum positive value of startValue such that the step by step sum is never less than 1.
     */
    fun minStartValue(nums: IntArray): Int {
        val prefix = IntArray(nums.size)
        var minSum = if(nums[0] > 0) 0 else nums[0]
        prefix[0] = nums[0]
        for (i in 1 until nums.size) {
            prefix[i] = prefix[i - 1] + nums[i]
            if(prefix[i] < minSum){
                minSum = prefix[i]
            }
        }
        return Math.abs(minSum) + 1
    }

    /*
    You are given a 0-indexed array nums of n integers, and an integer k.
    The k-radius average for a subarray of nums centered at some index i with the radius k is the
    average of all elements in nums between the indices i - k and i + k (inclusive).
    If there are less than k elements before or after the index i, then the k-radius average is -1.
    Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
    The average of x elements is the sum of the x elements divided by x, using integer division.
    The integer division truncates toward zero, which means losing its fractional part.
    For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
    Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
    Output: [-1,-1,-1,5,4,4,-1,-1,-1]
     */
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val prefix = LongArray(nums.size)
        prefix[0] = nums[0].toLong()
        for (i in 1 until nums.size) {
            prefix[i] = prefix[i - 1] + nums[i]
        }
        val windowSize = k*2+1
        val answer = IntArray(nums.size)
        for (i in nums.indices){
            if(i < k || i > nums.lastIndex - k){
                answer[i] = -1
            }else{
                val rightIndex = i+k
                val leftIndex = i-k
                answer[i] = ((prefix[rightIndex] - prefix[leftIndex] + nums[leftIndex])/windowSize).toInt()
            }
        }
        return answer
    }
}

