package com.example.myapplication

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlin.random.Random

class FragmentBA : Fragment() {

    companion object {
        fun newInstance(): FragmentBA {
            return FragmentBA()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("сообщение", "onCreateAA")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("сообщение", "onCreateViewAA")
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSetColor: Button = view.findViewById(R.id.button_set_color)
        buttonSetColor.setOnClickListener {
            val randomColor = getRandomColor()
            Log.d("сообщение", "Устанавливаем цвет: $randomColor")
            val resultBundle = Bundle().apply {
                putInt("colorKey", randomColor) // Сохраняем цвет в бандл
            }
            parentFragmentManager.setFragmentResult("colorRequestKey", resultBundle) // Отправляем результат
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                (activity as? ActivityA)?.openOrReuseFragmentBB()
            }
        }
    }

    private fun getRandomColor(): Int {
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        return Color.rgb(r, g, b)
    }
    override fun onResume() {
        super.onResume()
        Log.d("сообщение", "ResumeAA")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("сообщение", "DestroyViewAA")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("сообщение", "DestroyAA")
    }
}
