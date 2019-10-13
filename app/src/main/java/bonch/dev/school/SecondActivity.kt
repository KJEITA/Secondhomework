package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById<TextView>(R.id.text_view)

        var ind =  intent.getBooleanExtra ("Indicator",false)
        var count =  intent.getIntExtra ("Counts",0)
        var text =  intent.getStringExtra ("Text")

        textView.text = "$ind\n$count\n$text"
    }
}
