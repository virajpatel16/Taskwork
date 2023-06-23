package com.example.taskwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.taskwork.Fragment.calendarFragment
import com.example.taskwork.Fragment.mineFragment
import com.example.taskwork.Fragment.tasksFragment
import com.example.taskwork.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.BottomNav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId){
                    R.id.Tasks->{

                        loadfragment(tasksFragment())

                    }
                    R.id.Calendar->{
                        loadfragment(calendarFragment())
                    }

                    R.id.Mine->{
                        loadfragment(mineFragment())
                    }

                }

                return true
            }


        })

        binding.btnnext.setOnClickListener {
startActivity(Intent(this@MainActivity,addtask::class.java))
        }
    }

    private fun loadfragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fram,fragment)
            .commit()

    }
}