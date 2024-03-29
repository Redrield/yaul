package com.redrield.units

/**
 * A newtype container representing some type-safe unit of measurement
 * The concrete unit this represents is encoded in <T>. Operations on this unit will yield new units whose generic is modified
 * according to the operation performed
 *
 * Conversions from this wrapper back to doubles can be found for each defined unit under the conversions package. If something is not defined,
 * scaling the value returned from `value` appropriate to the prefix of the unit is equivalent.
 *
 * NOTE: Comparisons using == and != should NOT be used with this wrapper, as it disregards the unit type and only compares the value stored within.
 * <, <=, >, and >= however, are typechecked and safe to use
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS") //May change if Kotlin changes
inline class SIUnit<T: Key> internal constructor(val value: Double) : Comparable<SIUnit<T>> {
    operator fun plus(other: SIUnit<T>) = SIUnit<T>(value + other.value)
    operator fun minus(other: SIUnit<T>) = SIUnit<T>(value - other.value)
    operator fun times(scalar: Double) = SIUnit<T>(value * scalar)
    operator fun div(scalar: Double) = SIUnit<T>(value / scalar)

    operator fun div(other: SIUnit<T>) = value / other.value

    override fun compareTo(other: SIUnit<T>) = value.compareTo(other.value)
}

operator fun <T: Key, U: Key> SIUnit<T>.div(other: SIUnit<U>) = SIUnit<Fraction<T, U>>(value / other.value)
operator fun <T: Key, U: Key> SIUnit<T>.times(other: SIUnit<U>) = SIUnit<Mult<T, U>>(value * other.value)
