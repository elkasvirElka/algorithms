package com.example.algorithms

import com.example.algorithms.arrayAndStrings.SlidingWindow
import junit.framework.Assert.assertEquals
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
}
