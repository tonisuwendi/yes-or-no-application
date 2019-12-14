package com.example.cekricek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cekricek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        val navCtrl = this.findNavController(R.id.navhost_fragment)
        NavigationUI.setupActionBarWithNavController(this, navCtrl, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navCtrl)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        return NavigationUI.navigateUp(navCtrl, drawerLayout)
    }
}
