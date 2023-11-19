package es.rfvl.f1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import es.rfvl.f1.adapters.CircuitsAdapter
import es.rfvl.f1.classes.Circuits
import es.rfvl.f1.databinding.FragmentCircuitsBinding


class CircuitsFragment : Fragment(), CircuitsAdapter.OnCircuitsClickListener {

    private lateinit var binding: FragmentCircuitsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCircuitsBinding.inflate(layoutInflater)
        (requireActivity() as MainActivity2).changeToolbarTitle("CIRCUITS")
        val view = inflater.inflate(R.layout.fragment_circuits, container, false)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView(){
        val circuits = mutableListOf<Circuits>(
            Circuits("Internacional de Bahréin",R.drawable.formula1logo,"57","308.2 km","España","VACIO"),
            Circuits("Jeddah Corniche Circuit",R.drawable.formula1logo,"50","308.5 km","España","VACIO"),
            Circuits("Circuito de Albert Park",R.drawable.formula1logo,"58","306.1 km","España","VACIO"),
            Circuits("Circuito Urbano de Bakú",R.drawable.formula1logo,"51","306.0 km","España","VACIO"),
            Circuits("Miami International Autodrome",R.drawable.formula1logo,"57","308.3 km","España","VACIO"),
            Circuits("Autódromo Enzo",R.drawable.formula1logo,"63","309.0 km","España","VACIO"),
            Circuits("Circuito de Mónaco",R.drawable.formula1logo,"78","260.3 km","España","VACIO"),
            Circuits("Circuit de Barcelona",R.drawable.formula1logo,"66","307.2 km","España","VACIO")
        )
        val circuitsAdapt = CircuitsAdapter(requireContext(),circuits,this)
        binding.recyclerCircuits.adapter = circuitsAdapt
        binding.recyclerCircuits.layoutManager = GridLayoutManager(requireContext(),2)

    }

    override fun onCircuitClick(c: Circuits) {
        val nuevoFragmento = MyDialogCircuitsFragment()
        val args = Bundle()

        args.putString("nombreCircuitoDialog", c.nombreCircuito)
        args.putInt("imagen",c.image)
        args.putString("vueltas",c.nVueltas)
        args.putString("distancia",c.km)
        args.putString("pais",c.pais)
        args.putString("informacion",c.info)

        nuevoFragmento.arguments = args
        nuevoFragmento.show(requireActivity().supportFragmentManager, "Circuits Dialog")
    }

}