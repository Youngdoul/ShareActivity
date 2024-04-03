package edu.temple.funwithintents

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)

        // When the user clicks this button, share the text if not empty
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {
               val textToShare = editText.text.toString()
            if (textToShare.isEmpty()) {
                Toast.makeText(this, "Please enter some text to share.", Toast.LENGTH_SHORT).show()
            } else {
                // Use Android's Intent framework to share the text
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                    type = "text/plain"
                }
                // Use Intent.createChooser to let user choose the app to share through
                val chooser = Intent.createChooser(shareIntent, "Share text using...")
                startActivity(chooser)
            }

        }
    }
}
