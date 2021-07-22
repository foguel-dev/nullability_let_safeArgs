package com.example.udemy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btnNavergar)
        val resultado = view.findViewById<TextView>(R.id.tvOutputPrimerFragment)
        setFragmentResultListener("requestKey"){ key, bundle ->
            val result = bundle.getString("bundleKey")
            resultado.text = result
        }

        button.setOnClickListener {
            /*Pasar datos mediante el plugin sefargs*/
            val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment() // si no pasamos nada, tendria que pasar los datos por default
            findNavController().navigate(action)

            /*Pasar datos entre fragments*/
            /*findNavController().navigate(R.id.action_primerFragment_to_segundoFragment, bundleOf("nombre" to "Yamil","edad" to 25))*/

            /*Pasar datos entre activities*/
            /*requireActivity().supportFragmentManager.commit{
                //add(R.id.fragmentContainer, SegundoFragment()) Se sobre ponen los fragments
                replace(R.id.fragmentContainer, SegundoFragment.newInstance("Yamil",25)) // Reemplaza fragment
                addToBackStack("primerFragment")*/
            }
        }
    }
