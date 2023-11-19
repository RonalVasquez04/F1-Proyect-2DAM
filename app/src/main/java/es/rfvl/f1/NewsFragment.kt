package es.rfvl.f1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import es.rfvl.f1.adapters.newsAdapter
import es.rfvl.f1.classes.News
import es.rfvl.f1.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        (requireActivity() as MainActivity2).changeToolbarTitle("NEWS")
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView(){
        val noticias = mutableListOf<News>(
            News(R.drawable.formula1logo,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix"),
            News(R.drawable.formula1logo,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix"),
            News(R.drawable.formula1logo,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix"),
            News(R.drawable.formula1logo,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix"),
            News(R.drawable.formula1logo,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix"),
            News(R.drawable.formula1logo,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix")

        )
        val newApad = newsAdapter(requireContext(),noticias)
        binding.recNews.adapter = newApad
        binding.recNews.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

    }

}