package com.example.algorithms.arrayAndStrings

class TwoPointers {
    /*
    Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
     */
    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.size - 1
        while (i < j) {
            val letter = s[i]
            s[i] = s[j]
            s[j] = letter
            i += 1
            j -= 1
        }
    }

    /*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
    Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
     */
    fun sortedSquares(nums: IntArray): IntArray {
        var kIndex = 0
        for (i in 0..nums.size - 1) {
            if (nums[i] < 0) {
                kIndex = i
            }
        }
        var newNums = intArrayOf()
        var j = kIndex
        var i = kIndex + 1
        while (j >= 0 && i < nums.size) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                newNums += (nums[i] * nums[i])
                i += 1
            } else {
                newNums += (nums[j] * nums[j])
                j -= 1
            }
        }

        while (i < nums.size) {
            newNums += (nums[i] * nums[i])
            i += 1
        }
        while (j >= 0) {
            newNums += (nums[j] * nums[j])
            j -= 1
        }

        return newNums
    }
}
