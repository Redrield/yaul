//@file:JvmName("FracCancelTimesCommute")
package com.redrield.units

operator fun <T: Key, U: Key> SIUnit<U>.times(other: SIUnit<Fraction<T, U>>) = SIUnit<T>(value * other.value)