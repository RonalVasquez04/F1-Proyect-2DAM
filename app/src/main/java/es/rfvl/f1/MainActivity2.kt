package es.rfvl.f1

import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import es.rfvl.f1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigationDrawer()

        val bottonNavigationView: BottomNavigationView = this.findViewById(R.id.bottomNavigationView)
        bottonNavigationView.visibility = View.VISIBLE

        bottonNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.news -> {


                    val nuevoFragmento = NewsFragment()
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentcontainerview, nuevoFragmento)
                        .addToBackStack(null)
                        .commit()

                    true
                }
                R.id.drivers -> {

                    val nuevoFragmento = DriversFragment()
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentcontainerview, nuevoFragmento)
                        .addToBackStack(null)
                        .commit()

                    true
                }
                R.id.racing -> {

                    val nuevoFragmento = RacingFragment(222)
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentcontainerview, nuevoFragmento)
                        .addToBackStack(null)
                        .commit()


                    true
                }
                R.id.circuits -> {

                    val nuevoFragmento = CircuitsFragment()
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentcontainerview, nuevoFragmento)
                        .addToBackStack(null)
                        .commit()

                    true
                }
                else -> false
            }
        }
    }

    private fun setUpNavigationDrawer(){
        val toggle = ActionBarDrawerToggle(
            this,binding.drawerLayout, binding.myToolBar, R.string.navOpen,R.string.navClose
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.inflateMenu(R.menu.navigation_menu)

        val switchMenuItem = navigationView.menu.findItem(R.id.menu_switch)

        val featureSwitch = switchMenuItem.actionView as Switch

        featureSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }

    fun changeToolbarTitle(newTitle: String) {
        binding.myToolBar.title = newTitle
    }



}