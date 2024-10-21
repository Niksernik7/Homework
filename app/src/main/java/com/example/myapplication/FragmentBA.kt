package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlin.random.Random
//import android.graphics.drawable.ColorDrawable

class FragmentBA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSetColor: Button = view.findViewById(R.id.button_set_color)
        buttonSetColor.setOnClickListener {
            val randomColor = getRandomColor()
            Log.d("сообщение", "Устанавливаем цвет: $randomColor")
            val bundle = Bundle()
            bundle.putInt("color", randomColor) // Сохраняем цвет в бандл
            val fragmentBB = activity?.supportFragmentManager?.findFragmentByTag("FRAGMENT_BB") as? FragmentBB
            if (fragmentBB != null) {
                fragmentBB.arguments = bundle // Устанавливаем аргументы
                fragmentBB.view?.let { it1 -> fragmentBB.changeColor(it1) }
            } else {
                Log.e("сообщение", "FragmentBB не найден!")
            }
        }
    }

    private fun getRandomColor(): Int {
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        return Color.rgb(r, g, b)
    }
}
