package com.example.udemy

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    // Valores pueden ser nulos
    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: SegundoFragmentArgs by navArgs() // delegacion con navArgs

    // La mejor forma de acceder a los metedos, se crea el fragment e inicializamos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Con el plugin sefArgs
        nombre = args.nombre
        edad = args.edad

            //Con let evitamos null(fragments)
        /*arguments?.let { bundle ->
            nombre = bundle.getString(MI_NOMBRE)
            edad = bundle.getInt(MI_EDAD)
        }*/

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val texto = view.findViewById<TextView>(R.id.tvOutput)
        val button = view.findViewById<Button>(R.id.btn2)
        val result = "Resultado"

        button.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("bundleKey" to result)) // nos pide un requestKey
            //findNavController().navigate(R.id.product_graph)
            findNavController().navigate(Uri.parse("ruta://card")) //Deep link para moverse entre varios fragments
        }

        texto.text = "$nombre $edad"

    }

    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre:String, edad:Int) = SegundoFragment().apply{
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }

    }

}