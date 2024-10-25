package com.example.myapplication

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.util.Log


class FragmentBB : Fragment() {

    private var backgroundColor: Int = Color.WHITE

    companion object {
        fun newInstance(): FragmentBB {
            return FragmentBB()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            Log.d("сообщение", "ДОСТАЛИ ЦВЕТ")
            backgroundColor = savedInstanceState.getInt("bg_color")
        }
        Log.d("сообщение", "onCreateBB")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("сообщение", "onCreateViewBB")
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBackgroundColor(backgroundColor)

        val buttonOpenFragmentBA: Button = view.findViewById(R.id.button_open_fragment_ba)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Скрываем кнопку, так как FragmentBA уже открыт
            buttonOpenFragmentBA.visibility = View.GONE
        } else {
            // Показать кнопку в портретной ориентации
            buttonOpenFragmentBA.visibility = View.VISIBLE
            buttonOpenFragmentBA.setOnClickListener {

                val fragmentBA: FragmentBA? =
                    parentFragmentManager.findFragmentByTag("FRAGMENT_BA") as? FragmentBA

                if (fragmentBA == null) {
                    Log.d("сообщение", "Создание нового FragmentBA")
                    val newFragmentBA = FragmentBA.newInstance()
                    parentFragmentManager.beginTransaction()
                        .add(R.id.fragment_container, newFragmentBA, "FRAGMENT_BA")
                        .addToBackStack(null)
                        .commit()
                } else {
                    Log.d("сообщение", "Использование существующего FragmentBA")
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragmentBA, "FRAGMENT_BA")
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
        parentFragmentManager.setFragmentResultListener("colorRequestKey", this) { _, bundle ->
            val color = bundle.getInt("colorKey")
            view.setBackgroundColor(color)
            backgroundColor = color // Устанавливаем цвет
            Log.d("сообщение", "Извлеченный цвет: $color")
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d("сообщение", "ResumeBB")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("сообщение", "DestroyViewBB")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("сообщение", "DestroyBB")
    }

    fun getBackgroundColor(): Int {
        return backgroundColor
    }

    // Метод для изменения фонового цвета
    fun setBackgroundColor(color: Int) {
        backgroundColor = color
        view?.setBackgroundColor(backgroundColor)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("сообщение", "запомнили")
        outState.putInt("bg_color", this.getBackgroundColor()) // Предполагается, что вы создадите метод для получения цвета
    }


}