package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class FirstActivity : AppCompatActivity() {

    private lateinit var secondActivityButton: Button
    private lateinit var thirdActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        secondActivityButton = findViewById(R.id.second_activity_button)
        thirdActivityButton = findViewById(R.id.third_activity_button)

        secondActivityButton.setOnClickListener {
            val intent = Intent(FirstActivity@ this, SecondActivity::class.java)

            startActivityForResult(intent, 1)
        }

        thirdActivityButton.setOnClickListener {
            val intent = Intent(FirstActivity@ this, ThirdActivity::class.java)

            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == 1) {
            if (requestCode == 1) {
                val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка нажата из второй активности", Toast.LENGTH_SHORT
                )
                toast.show()
            }else if(requestCode == 2){
                val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка нажата из третьей активности", Toast.LENGTH_SHORT
                )
                toast.show()
            }
        } else {
            val toast = Toast.makeText(
                applicationContext,
                "Кнопка НЕ нажата", Toast.LENGTH_SHORT
            )
            toast.show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
