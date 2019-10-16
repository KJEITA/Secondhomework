package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FirstActivity : AppCompatActivity() {

    //TODO Я не буду ничего менять сама, только оставлю комментарии, чтобы ты сам мог себя поправить.

    //TODO Обязательно удаляй из манифеста удалённые активности.
    // Например в этой ветке у тебя в манифесте как ошибка выделена MainActivity, ведь её больше нет в проекте.
    // Так же фильтр стартовой активности должен быть только у одной активности.
    // Иначе в некоторых случаях приложение может вылетать от подобной неопределённости.

    //TODO У тебя неплохо со стилем кода, но делай форматирование.
    // Сделай ctrl + alt + L и посмотри, как среда всё отформаттирует.
    // Между методами нужно делать отступы, кое-где не лишними будут пробелы.


    private lateinit var indicatorButton:Button
    private lateinit var counterButton:Button
    private lateinit var textField:TextView
    private lateinit var nextActivityButton:Button

    private var indBool = false
    private var currentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initialization()
        setOnClickListener()

        if(savedInstanceState != null)

            reWrite(savedInstanceState)
    }
    //TODO Имя метода всегда должно быть глаголом, не существительным. В данном случае или init, или initialize
    private fun initialization(){
        indicatorButton = findViewById<Button>(R.id.indicator_button)
        counterButton = findViewById<Button>(R.id.counter_button)
        textField = findViewById<TextView>(R.id.text_field)
        nextActivityButton = findViewById<Button>(R.id.next_activity_button)
    }
    private fun setOnClickListener(){
        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
            indBool = true
        }
        counterButton.setOnClickListener {
            currentCount++
            counterButton.text  = currentCount.toString()
        }
        nextActivityButton.setOnClickListener {
            val intent = Intent(FirstActivity@this, SecondActivity::class.java)

            intent.putExtra("Indicator", indBool)
            intent.putExtra("Counts", currentCount)
            intent.putExtra("Text", textField.text.toString())

            startActivity(intent)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("Indicator", indBool)
        outState.putInt("Counts", currentCount)
        outState.putString("Text", textField.text.toString())
        //outState.putInt("Counts", currentCount)
    }
    fun reWrite(savedInstanceState:Bundle){
        indBool = savedInstanceState.getBoolean("Indicator")
        if(indBool) indicatorButton.isEnabled = false

        currentCount = savedInstanceState.getInt("Counts")
        counterButton.text = currentCount.toString()

        textField.text = savedInstanceState.getString("Text")
    }
}
