package com.example.firstapp

import android.content.Context
import android.content.res.Configuration
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale
import java.util.stream.IntStream.range


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    var users: MutableList<User> = mutableListOf()
    lateinit var userAdapter: UserAdapter

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    val view: View = binding.root
    setContentView(view)



    //binding.name="Hiii"


    users = mutableListOf(
        User("Group 1","",1),
        User("Ahmed","Ahmed@gmail.com",2),
        User("Mahmoud Mohamed","Mahmoud@gmail.com",2),
        User("Mona Ahmed","Mona@gmail.com",2),
        User("Group 2","",1),
        User("Menna Ali","Menna@gmail.com",2),
        User("Youssef Mohamed","Youssef@gmail.com",2),
        User("Ahmed Mohamed","Ahmed@gmail.com",2),
        User("Group 3","",1),
        User("Mahmoud Ahmed","Mahmoud@gmail.com",2),
        User("Yasmine Ahmed","Mona@gmail.com",2),
        User("Mohamed Ali","Menna@gmail.com",2),
        User("Farida Mohamed","Youssef@gmail.com",2)
    )

    val userAdapter = UserAdapter(users)
    binding.rvUsers.layoutManager= LinearLayoutManager(this)
    binding.rvUsers.adapter=userAdapter

    binding.toolbar.materialToolbar.setOnMenuItemClickListener {
        when (it.itemId) {
            R.id.search -> {
                Toast.makeText(this, R.string.search_clicked, Toast.LENGTH_SHORT).show()
                true
            }

            R.id.profile -> {
                Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                true
            }

            R.id.settings -> {
                Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                true
            }

            else -> false
        }
    }


    binding.toolbar.materialToolbar.setNavigationOnClickListener {
        binding.drawerLayout.open()
    }


    binding.navigationView.setNavigationItemSelectedListener {
        when(it.itemId){
            R.id.home -> {
                Toast.makeText(this, R.string.home_clicked, Toast.LENGTH_SHORT).show()
                binding.drawerLayout.close()
                true
            }

            R.id.gallery -> {
                Toast.makeText(this, R.string.gallery_clicked, Toast.LENGTH_SHORT).show()
                binding.drawerLayout.close()
                true
            }
            R.id.slideshow -> {
                Toast.makeText(this, R.string.slideshow_clicked, Toast.LENGTH_SHORT).show()
                binding.drawerLayout.close()
                true
            }

            else -> false
        }
    }
    binding.bottomNavigation.setOnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.home -> {
                Toast.makeText(this, R.string.home_clicked, Toast.LENGTH_SHORT).show()
                true
            }

            R.id.profile -> {
                Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                true
            }

            R.id.settings -> {
                Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                true
            }

            else -> false
        }
    }
    binding.floatingActionButton.setOnClickListener {
        // showCustomDialog()

        Snackbar.make(binding.coordinatorLayout, R.string.user_added, Snackbar.LENGTH_LONG)
            .setAction(R.string.dismiss) {
                // Responds to click on the action
            }
            .show()

    }
    fun updateLocale(context: Context, languageCode: String) {

        // locale  ar  direction

        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
            context.createConfigurationContext(config)
        } else {
            config.locale = locale
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }

        // Update layout direction
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale)
        }

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        //restart activity

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
}



//    lateinit var btn: Button
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_main)//R redefined class
//
//        btn = findViewById(R.id.btn)
//        btn.text = "Hello Android"
//        btn.setOnClickListener {
//            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
//        }
//    }
//}