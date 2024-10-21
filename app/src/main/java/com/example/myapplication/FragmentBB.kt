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
        Log.d("сообщение", "onCreateBB")

        if (savedInstanceState != null) {
            backgroundColor = savedInstanceState.getInt("bg_color", Color.WHITE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
                val fragmentBA = FragmentBA.newInstance()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentBA, "FRAGMENT_BB")
                    .addToBackStack(null) // добавляем в back stack, если нужно
                    .commit()
            }
        }
        parentFragmentManager.setFragmentResultListener("colorRequestKey", this) { _, bundle ->
            val color = bundle.getInt("colorKey")
            view.setBackgroundColor(color) // Устанавливаем цвет
            Log.d("сообщение", "Извлеченный цвет: $color")
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d("сообщение", "ResumeBB")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("сообщение", "ResueDestroyViewBB")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("сообщение", "ResumeDestroyBB")
    }

    fun getBackgroundColor(): Int {
        return backgroundColor
    }

    // Метод для изменения фонового цвета
    fun setBackgroundColor(color: Int) {
        backgroundColor = color
        view?.setBackgroundColor(color)
    }
}