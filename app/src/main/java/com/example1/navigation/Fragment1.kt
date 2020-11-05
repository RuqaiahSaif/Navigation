package com.example1.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"



class Fragment1 : Fragment() {
    private lateinit var text: TextView
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


       var view= inflater.inflate(R.layout.fragment_1, container, false)
        text = view.findViewById(R.id.text) as TextView
        when(param1) {
            "profile" -> {
        view.setBackgroundResource(R.color.colorPrimary)
        text.setText("$param1 is selected")
            }
            "people" -> {
                view.setBackgroundResource(R.color.colorPrimaryDark)
                text.setText("$param1 is selected")
            }
            "setting" -> {
                view.setBackgroundResource(R.color.colorAccent)
                text.setText("$param1 is selected")

            }
            else -> null
        }

        return view
    }

    companion object {

        fun newInstance(param1: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}