package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.util.Log
import android.graphics.Color


class FragmentBB : Fragment() {

    companion object {
        fun newInstance(): FragmentBB {
            val fragment = FragmentBB()
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("сообщение", "живем")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt("color")
        if (color != null) {
            view.setBackgroundColor(color) // Устанавливаем цвет
            Log.d("сообщение", "Извлеченный цвет: $color")
        } else {
            Log.d("сообщение", "Цвет не передан через Bundle")
        }

        val buttonOpenFragmentBA: Button = view.findViewById(R.id.button_open_fragment_ba)
        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
            // Скрываем кнопку, так как FragmentBA уже открыт
            buttonOpenFragmentBA.visibility = View.GONE
        } else {
            // Показать кнопку в портретной ориентации
            buttonOpenFragmentBA.visibility = View.VISIBLE
            buttonOpenFragmentBA.setOnClickListener {
                (activity as ActivityA).openFragmentBA()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("сообщение", "фрагмент ББ создался")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("сообщение", "фрагмент ББ умер")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("сообщение", "фрагмент ББ умер ПОЛНОСТЬЮ")
    }

    fun changeColor(view: View) {
        val color = arguments?.getInt("color")
        if (color != null) {
            view.setBackgroundColor(color) // Устанавливаем цвет
            Log.d("сообщение", "Извлеченный цвет: $color")
        } else {
            Log.d("сообщение", "Цвет не передан через Bundle")
        }

    }


}