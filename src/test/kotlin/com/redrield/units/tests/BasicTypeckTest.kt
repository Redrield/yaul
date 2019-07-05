package com.redrield.units.tests

import com.redrield.units.*
import com.redrield.units.derived.Newton
import com.redrield.units.derived.Velocity
import org.junit.Assert
import org.junit.Test

class BasicTypeckTest {
    @Test
    fun testArithmetic() {
        val x = 3.meter
        val y = 4.meter

        Assert.assertEquals(7, (x + y).value.toInt())
        Assert.assertEquals(-1, (x - y).value.toInt())
        Assert.assertEquals(0.75, (x / y).value, 0.0)

        Assert.assertEquals(1.0, 1.kilo.gram.value, 0.0)
        Assert.assertTrue(2.second >= 1.5.second)
    }

    @Test
    fun testDerivatives() {
        val x = 10.meter
        val t = 2.second

        val v: SIUnit<Velocity<Meter>> = x / t
        Assert.assertEquals(5, v.value.toInt())
        Assert.assertEquals(5.0, (v * 1.second).value, 0.0)

        val a = x / t / 1.second
        Assert.assertEquals((x / t).value, (a * 1.second).value, 0.0)
        Assert.assertEquals(x.value, (a * t * 1.second).value, 0.0)
    }
}