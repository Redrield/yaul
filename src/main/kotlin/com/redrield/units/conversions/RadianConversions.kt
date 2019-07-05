package com.redrield.units.conversions

import com.redrield.units.Radian
import com.redrield.units.SIUnit

val SIUnit<Radian>.radian get() = value
val SIUnit<Radian>.degree get() = Math.toDegrees(value)