package com.zlcoder.core.extension

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * 保留一位小数
 */
fun Float.toOneDecimal(): String {
    val format = DecimalFormat("0.#")
    //未保留小数的舍弃规则，RoundingMode.FLOOR表示直接舍弃。
    format.roundingMode = RoundingMode.FLOOR
    return format.format(this)
}