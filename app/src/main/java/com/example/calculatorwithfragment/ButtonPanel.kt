package com.example.calculatorwithfragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.calculatorwithfragment.databinding.ButtonPanelBinding


class ButtonPanel : Fragment() {
    private var _binding: ButtonPanelBinding? = null
    private val binding get() = requireNotNull(_binding)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ButtonPanelBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            button0.setOnClickListener { editText.append(button0.text.toString()) }
            button1.setOnClickListener { editText.append(button1.text.toString()) }
            button2.setOnClickListener { editText.append(button2.text.toString()) }
            button3.setOnClickListener { editText.append(button3.text.toString()) }
            button4.setOnClickListener { editText.append(button4.text.toString()) }
            button5.setOnClickListener { editText.append(button5.text.toString()) }
            button6.setOnClickListener { editText.append(button6.text.toString()) }
            button7.setOnClickListener { editText.append(button7.text.toString()) }
            button8.setOnClickListener { editText.append(button8.text.toString()) }
            button9.setOnClickListener { editText.append(button9.text.toString()) }
            buttonAdd.setOnClickListener { editText.append(buttonAdd.text.toString()) }
            buttonDivision.setOnClickListener { editText.append(buttonDivision.text.toString()) }
            buttonMultiply.setOnClickListener { editText.append(buttonMultiply.text.toString()) }
            buttonSubtraction.setOnClickListener { editText.append(buttonSubtraction.text.toString()) }
            buttonOpeningBracket.setOnClickListener { editText.append(buttonOpeningBracket.text.toString()) }
            buttonClosingBracket.setOnClickListener { editText.append(buttonClosingBracket.text.toString()) }
            buttonSeparator.setOnClickListener { editText.append(buttonSeparator.text.toString()) }

            buttonC.setOnClickListener {
                editText.setText("")
                editResult.setText("")
            }

            buttonBack.setOnClickListener {
                val strMathExpression = editText.text.toString()
                if (strMathExpression.isNotEmpty()) {
                    editText.setText(strMathExpression.substring(0, strMathExpression.length - 1))
                }
            }

            val сalculatorMainFunctions = CalculatorMainFunctions()
            val calculator = Calculator()

            buttonEquals.setOnClickListener {
                try {
                    editResult.setText(
                        calculator.calculateWithBrackets(
                            сalculatorMainFunctions,
                            editText.text.toString()
                        ).toString()
                    )
                } catch (e: IllegalArgumentException) {
                    val text = "ЪуЪ! Смотри, что вводишь!"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(activity, " $e +$text", duration)
                    toast.show()
                }

            }

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}