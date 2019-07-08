//@file:JvmName("FracCancelTimes")
package com.redrield.units

operator fun <T: Key, U: Key> SIUnit<Fraction<T, U>>.times(other: SIUnit<U>) = SIUnit<T>(value * other.value)