package com.redrield.units.tests

import com.redrield.units.*
import com.redrield.units.derived.Velocity
import org.junit.Assert
import org.junit.Test

class BasicTypeckTest {
    @Test
    fun compileTimeTest() {
        val vel = 2.meter.velocity

        val x1: SIUnit<Meter> = vel * 2.second
        val x2: SIUnit<Meter> = 2.second * vel

        x1 + x2

        val charge: SIUnit<Mult<Ampere, Second>> = 2.amp * 1.second

        charge + charge

        val vel2 = 2.meter.velocity
        val temp: SIUnit<Meter> = vel2 * 2.second

        temp + temp
    }
    @Test
    fun testArithmetic() {
        val x = 3.meter
        val y = 4.meter

        Assert.assertEquals(7, (x + y).value.toInt())
        Assert.assertEquals(-1, (x - y).value.toInt())
        Assert.assertEquals(0.75, x / y, 0.0)

        Assert.assertEquals(1.0, 1.kilo.gram.value, 0.0)
//        Assert.assertFalse(2.second == 2.second)
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