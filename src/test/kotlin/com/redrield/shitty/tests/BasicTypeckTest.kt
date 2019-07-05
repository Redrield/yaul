package com.redrield.shitty.tests

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
        Assert.assertEquals(0.75, x / y, 0.0)

        Assert.assertEquals(1000.0, 1.kilo.meter.value, 0.0)
    }

    @Test
    fun testDerivatives() {
        val x = 10.meter
        val t = 2.second

        val v: SIUnit<Velocity> = x / t
        Assert.assertEquals(5, v.value.toInt())
        Assert.assertEquals(5.0, (v * 1.second).value, 0.0)

        val a = x / t / 1.second
        Assert.assertEquals(x / t, a * 1.second)
        Assert.assertEquals(x, a * t * 1.second)
    }
}