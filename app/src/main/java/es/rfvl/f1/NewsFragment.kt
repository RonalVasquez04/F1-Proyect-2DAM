package es.rfvl.f1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
            News(R.drawable.news1,"Red Bull unveil special fan-designed Las Vegas livery ahead of weekend's inaugural Grand Prix"),
            News(R.drawable.news2,"5 Winners and 5 losers from Las Vegas - Who hit the jackpot in Sin City?"),
            News(R.drawable.news3,"SAY WHAT?! Verstappen croons, Norris crashes and Leclerc yee-haws in the best team radio from Las Vegas"),
            News(R.drawable.news4,"Verstappen understands date change for Dutch Grand Prix"),
            News(R.drawable.news5,"These drivers will be in action during FP1 for the Abu Dhabi GP"),
            News(R.drawable.news6,"Formula 1 releases 2024 calendar with more Saturday races, return of Chinese Grand Prix"),
            News(R.drawable.news2,"5 Winners and 5 losers from Las Vegas - Who hit the jackpot in Sin City?"),
            News(R.drawable.news3,"SAY WHAT?! Verstappen croons, Norris crashes and Leclerc yee-haws in the best team radio from Las Vegas"),
            News(R.drawable.news4,"Verstappen understands date change for Dutch Grand Prix"),
            News(R.drawable.news5,"These drivers will be in action during FP1 for the Abu Dhabi GP"),
            News(R.drawable.news6,"Formula 1 releases 2024 calendar with more Saturday races, return of Chinese Grand Prix"),
            News(R.drawable.news2,"5 Winners and 5 losers from Las Vegas - Who hit the jackpot in Sin City?"),
            News(R.drawable.news3,"SAY WHAT?! Verstappen croons, Norris crashes and Leclerc yee-haws in the best team radio from Las Vegas"),
            News(R.drawable.news4,"Verstappen understands date change for Dutch Grand Prix"),
            News(R.drawable.news5,"These drivers will be in action during FP1 for the Abu Dhabi GP"),
            News(R.drawable.news6,"Formula 1 releases 2024 calendar with more Saturday races, return of Chinese Grand Prix"),
            News(R.drawable.news2,"5 Winners and 5 losers from Las Vegas - Who hit the jackpot in Sin City?"),
            News(R.drawable.news3,"SAY WHAT?! Verstappen croons, Norris crashes and Leclerc yee-haws in the best team radio from Las Vegas"),
            News(R.drawable.news4,"Verstappen understands date change for Dutch Grand Prix"),
            News(R.drawable.news5,"These drivers will be in action during FP1 for the Abu Dhabi GP"),
            News(R.drawable.news6,"Formula 1 releases 2024 calendar with more Saturday races, return of Chinese Grand Prix")

        )
        val newApad = newsAdapter(requireContext(),noticias)
        binding.recNews.adapter = newApad
        binding.recNews.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

    }

}