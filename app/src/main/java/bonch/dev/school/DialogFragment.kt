package bonch.dev.school

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogFragment : DialogFragment() {
    private lateinit var button_ok: Button
    private lateinit var button_cancel: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = inflater.inflate(R.layout.fragment_dialog, container, false)
        button_cancel = v.findViewById(R.id.cancel_button)
        button_ok = v.findViewById(R.id.ok_button)

        button_ok.setOnClickListener {
            //TODO с тостами для краткости можно писать прямо в ряд:
            // Toast.makeText(...).show()
            // Даже без объявление. Это так, приятная мелочь)
            val toast = Toast.makeText(
                context,
                "OK", Toast.LENGTH_SHORT
            )
            toast.show()
            dismiss()
        }
        button_cancel.setOnClickListener {
            val toast = Toast.makeText(
                context,
                "Cancel", Toast.LENGTH_SHORT
            )
            toast.show()
            dismiss()
        }
        return v
    }
}