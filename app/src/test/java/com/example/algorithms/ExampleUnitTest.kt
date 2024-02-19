package com.example.algorithms

import com.example.algorithms.arrayAndStrings.PrefixSum
import com.example.algorithms.arrayAndStrings.SlidingWindow
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertArrayEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testSlidingWindow() {
        val slidingWindow = SlidingWindow()
        val findMaxAverage = slidingWindow.findMaxAverage(intArrayOf(0, 4, 0, 3, 2), 1)
        assertEquals(findMaxAverage, 4.0)
        val longestOnes = slidingWindow.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2)
        assertEquals(longestOnes, 6)
    }
    @Test
    fun testPrefixSum() {
        val prefixSum = PrefixSum()
        val minStartValue = prefixSum.minStartValue(intArrayOf(-3,2,-3,4,2))
        assertEquals(minStartValue, 5)
        val getAverages =  prefixSum.getAverages(intArrayOf(7,4,3,9,1,8,5,2,6),3)
        assertArrayEquals(getAverages, intArrayOf(-1,-1,-1,5,4,4,-1,-1,-1))
        val getAverages2 =  prefixSum.getAverages(intArrayOf(0),0)
        assertArrayEquals(getAverages2, intArrayOf(0))
    }
}
