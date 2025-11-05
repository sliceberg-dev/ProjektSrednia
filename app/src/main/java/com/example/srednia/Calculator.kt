package com.example.srednia

class Calculator {
    fun weightedAverage(grades: List<Double>, weights: List<Double>): Double {
        var sum = 0.0
        var total = 0.0
        for (i in grades.indices) {
            sum += grades[i] * weights[i]
            total += weights[i]
        }
        return if (total > 0) sum / total else 0.0
    }
}
