package es.rfvl.f1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import es.rfvl.f1.adapters.carrerasAdapter
import es.rfvl.f1.classes.Carreras
import es.rfvl.f1.databinding.FragmentRacingBinding


class RacingFragment : Fragment() , carrerasAdapter.OnRaceClickListener{

    private lateinit var binding: FragmentRacingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRacingBinding.inflate(layoutInflater)
        (requireActivity() as MainActivity2).changeToolbarTitle("RACING")
        val view = inflater.inflate(R.layout.fragment_racing, container, false)
        setUpRecyclerViewRace()
        return binding.root


    }

    private fun setUpRecyclerViewRace(){
        val race = mutableListOf<Carreras>(
            Carreras("Round 1","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 2","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 3","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 4","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 5","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 6","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 7","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 8","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023"),
            Carreras("Round 9","Bahrain","Formula 1 Gulf Air Bahrain grand prix 2023")


        )
        race.reverse()
        val raceAdapter = carrerasAdapter(requireContext(), race, this)
        binding.recyclerCarreras.adapter = raceAdapter
        binding.recyclerCarreras.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

    }

    override fun onRaceClick(c: Carreras) {
        val snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_INDEFINITE)

        val snackbarView = snackbar.view as Snackbar.SnackbarLayout
        val customView = layoutInflater.inflate(R.layout.custom_snackbar, null)

        customView.findViewById<Button>(R.id.btnYes).setOnClickListener {
            Toast.makeText(requireContext(),"APRETADO SI",Toast.LENGTH_SHORT).show()
            snackbar.dismiss()
        }

        customView.findViewById<Button>(R.id.btnNo).setOnClickListener {
            Toast.makeText(requireContext(),"APRETADO NO",Toast.LENGTH_SHORT).show()
            snackbar.dismiss()
        }

        snackbarView.addView(customView)

        snackbar.show()
    }





}