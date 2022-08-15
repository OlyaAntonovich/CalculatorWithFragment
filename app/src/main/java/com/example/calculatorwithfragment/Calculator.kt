package com.example.calculatorwithfragment


import com.example.calculatorwithfragment.CalculatorMainFunctions.Companion.MATCH_GROUP_ADD
import com.example.calculatorwithfragment.CalculatorMainFunctions.Companion.MATCH_GROUP_BRACKETS
import com.example.calculatorwithfragment.CalculatorMainFunctions.Companion.MATCH_GROUP_DIVISION
import com.example.calculatorwithfragment.CalculatorMainFunctions.Companion.MATCH_GROUP_MULTIPLY
import com.example.calculatorwithfragment.CalculatorMainFunctions.Companion.MATCH_GROUP_SUBSTRACT

class Calculator {

    fun calculateWithBrackets(inter: Functions, str: String): Double {

        var newString = ""
        var result: Double
        var isExpression = true


        if (Regex(MATCH_GROUP_BRACKETS).containsMatchIn(str)) {

            var str1 = str

            while (isExpression) {

                val subString =
                    calculate(inter, (Regex(MATCH_GROUP_BRACKETS).find(str1)?.value.toString()))
                val subString1 = subString.replace("(", "")
                val subString2 = subString1.replace(")", "")

                newString = str1.replaceFirst(
                    MATCH_GROUP_BRACKETS.toRegex(),
                    subString2
                )

                if (Regex(MATCH_GROUP_BRACKETS).containsMatchIn(newString)) {
                    str1 = newString
                    isExpression = true
                } else {
                    str1 = newString
                    isExpression = false
                }

            }

            result = calculate(inter, str1).toDouble()

        } else {
            result = calculate(inter, str).toDouble()
        }


        return result

    }

    fun calculate(inter: Functions, str: String): String {
        var newString = str
        var isExpression = true

        while (isExpression) {
            if (Regex(MATCH_GROUP_MULTIPLY).containsMatchIn(newString)) {

                var stringReplace = inter.countMultiplyExpression(newString).toString()

                newString =
                    newString.replaceFirst(
                        (MATCH_GROUP_MULTIPLY).toRegex(),
                        stringReplace
                    )


            } else if (Regex(MATCH_GROUP_DIVISION).containsMatchIn(
                    newString
                )
            ) {
                var stringReplace = inter.countDivisionExpression(newString).toString()

                newString.replaceFirst(
                    (MATCH_GROUP_DIVISION).toRegex(),
                    stringReplace
                )
                    .also { newString = it }

            } else if (Regex(MATCH_GROUP_SUBSTRACT).containsMatchIn(
                    newString
                )
            ) {
                var stringReplace = inter.subtractFunction(newString).toString()
                newString =
                    newString.replaceFirst(
                        (MATCH_GROUP_SUBSTRACT).toRegex(),
                        stringReplace
                    )

            } else if (Regex(MATCH_GROUP_ADD).containsMatchIn(
                    newString
                )
            ) {
                var stringReplace = inter.countPlusExpression(newString).toString()
                newString =
                    newString.replaceFirst(
                        (MATCH_GROUP_ADD).toRegex(),
                        stringReplace
                    )
            } else isExpression = false

        }

        return newString
    }

}