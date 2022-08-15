package com.example.calculatorwithfragment

import kotlin.math.roundToInt

interface Functions {
    fun countPlusExpression(str: String): Double
    fun countMultiplyExpression(str: String): Double
    fun subtractFunction(str: String): Double
    fun countDivisionExpression(str: String): Double

}

class CalculatorMainFunctions (

) : Functions {

    override fun countPlusExpression(str: String): Double {
        val matchResult = Regex(MATCH_GROUP_ADD).find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        return container[0] + container[1]
    }

    override fun countMultiplyExpression(str: String): Double {
        val matchResult = Regex(MATCH_GROUP_MULTIPLY).find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        return container[0] * container[1]
    }

    override fun subtractFunction(str: String): Double {
        val matchResult = Regex(MATCH_GROUP_SUBSTRACT).find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        return container[0] - container[1]
    }

    override fun countDivisionExpression(str: String): Double {
        val matchResult = Regex(MATCH_GROUP_DIVISION).find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        val evaluateValue = ((container[0]/container[1])*100.0).roundToInt()
        return ((evaluateValue)/100.0)
    }

    companion object{
        const val MATCH_GROUP_ADD = """([-]?[0-9]*\.?[0-9]*)[+]([-]?[0-9]*\.?[0-9]*)"""
        const val MATCH_GROUP_MULTIPLY = """([-]?[0-9]*\.?[0-9]*)[*]([-]?[0-9]*\.?[0-9]*)"""
        const val MATCH_GROUP_SUBSTRACT = """([-]?[0-9]*\.?[0-9]*\b)[-]([-]?[0-9]*\.?[0-9]*)"""
        const val MATCH_GROUP_DIVISION = """([-]?[0-9]*\.?[0-9]*)[/]([-]?[0-9]*\.?[0-9]*)"""
        const val MATCH_GROUP_BRACKETS = """(\([-]?[0-9]*\.?[0-9]*)[+]?[-]?[/]?[*]?([-]?[0-9]*\.?[0-9]*[+]?[-]?[/]?[*]?[-]?[0-9]*\.?[0-9]*?\))"""
    }
}