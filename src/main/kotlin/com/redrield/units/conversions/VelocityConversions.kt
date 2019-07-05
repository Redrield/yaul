package com.redrield.units.conversions

import com.redrield.units.Meter
import com.redrield.units.Radian
import com.redrield.units.SIUnit
import com.redrield.units.derived.Velocity
import com.redrield.units.meter

typealias LinearVelocity = Velocity<Meter>
typealias AngularVelocity = Velocity<Radian>

private val meterToFeet = 1.meter.feet
private val meterToInches = 1.meter.inch
private val secondsPerMinute = 1.minute.second

val SIUnit<LinearVelocity>.feetPerSecond get() = value * meterToFeet
val SIUnit<LinearVelocity>.feetPerMinute get() = feetPerSecond * secondsPerMinute
val SIUnit<LinearVelocity>.inchesPerSecond get() = value * meterToInches
