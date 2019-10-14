package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DialogActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        button = findViewById(R.id.dialogbutton)
        var dlg = DialogFragment()

        button.setOnClickListener {
            dlg.show(supportFragmentManager, "dlg")
        }
    }
}
