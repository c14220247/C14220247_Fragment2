package piu.piu.Fragment2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private var currentChar = 'A'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frameContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Load halaman 1 saat pertama kali aplikasi dibuka
        loadFragment(Halaman1.newInstance(currentChar), "Halaman 1")

        // Set up button listeners
        findViewById<Button>(R.id.buttonHalaman1).setOnClickListener {
            loadFragment(Halaman1.newInstance(currentChar), "Halaman 1")
            incrementChar()
        }

        findViewById<Button>(R.id.buttonHalaman2).setOnClickListener {
            loadFragment(Halaman2.newInstance(currentChar), "Halaman 2")
            incrementChar()
        }

        findViewById<Button>(R.id.buttonHalaman3).setOnClickListener {
            loadFragment(Halaman3.newInstance(currentChar), "Halaman 3")
            incrementChar()
        }
    }

    private fun loadFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, tag)
            .commit()
    }

    private fun incrementChar() {
        currentChar++
    }
}
