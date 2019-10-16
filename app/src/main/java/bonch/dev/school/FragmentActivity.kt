package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.fragments.FirstFragment
import bonch.dev.school.fragments.SecondFragment

class FragmentActivity : AppCompatActivity() {

    val fragmentManager = supportFragmentManager
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val firstFragment = FirstFragment()
        fragmentManager.beginTransaction().add(R.id.fragment, firstFragment)
            .commit()

            //button = findViewById<Button>(R.id.next_activity_button)

        /*button.setOnClickListener(View.OnClickListener {
            replaceFragment()
        })
    }*/
    }
     fun replaceFragment(view :View){
         //TODO Ты создал один фрагмент, а менеджеру присвоил новый
         // (Если вдруг не очень хорошо с ООП — ты в менеджере вызвал конструктор и создал новый объект, а не передал предыдущий).
         // Или передавай в менеджер secondActivity, или создавай фрагмент в менеджере, но убери неиспользуемый secondFragment
        val secondFragment = SecondFragment()
        fragmentManager.beginTransaction().add(R.id.fragment, SecondFragment()).addToBackStack("thirdFragment")
            .commit()
    }
}
