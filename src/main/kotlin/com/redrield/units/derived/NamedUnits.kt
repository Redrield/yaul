package com.redrield.units.derived

import com.redrield.units.*

typealias Velocity<T> = Fraction<T, Second>
typealias Acceleration<T> = Fraction<Velocity<T>, Second>

typealias Hertz = Inverse<Second>
typealias Curvature = Inverse<Meter>

typealias Coulomb = Mult<Ampere, Second>
typealias Volt = Fraction<Joule, Coulomb>
typealias Ohm = Fraction<Volt, Ampere>

typealias Newton = Mult<Kilogram, Acceleration<Meter>>
typealias Joule = Mult<Newton, Meter>
typealias Watt = Fraction<Joule, Second>
