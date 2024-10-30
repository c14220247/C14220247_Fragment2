package piu.piu.Fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_CHAR = "param_char"

class Halaman1 : Fragment() {

    private var displayChar: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            displayChar = it.getChar(ARG_CHAR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_halaman1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewChar = view.findViewById<TextView>(R.id.textViewChar)
        val textViewPage = view.findViewById<TextView>(R.id.textViewPage)
        textViewChar.text = displayChar.toString()
        textViewPage.text = "Halaman 1"
    }

    companion object {
        fun newInstance(char: Char) = Halaman1().apply {
            arguments = Bundle().apply {
                putChar(ARG_CHAR, char)
            }
        }
    }
}
