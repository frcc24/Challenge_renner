package com.example.rennerapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.rennerapp.R
import com.example.rennerapp.adapters.ItemAdapter
import com.example.rennerapp.models.Product
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.main_content.*
import java.io.Serializable

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val itemAdapter by lazy {
        ItemAdapter { position: Int, item: Product ->
            Toast.makeText(this@MainActivity, "Pos ${item.name}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ProductDetailsActivity::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("product", item)
            startActivity(intent)

            item_list.smoothScrollToPosition(position)
        } }

    private val itemAdapter2 by lazy {
        ItemAdapter { position: Int, item: Product ->
            Toast.makeText(this@MainActivity, "Pos ${item.name}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ProductDetailsActivity::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("product", item)
            startActivity(intent)

            item_list.smoothScrollToPosition(position)
        } }

    private val possibleItems = listOf(
        Product("Blusas de Frio", 51.90,"Camisa Manga Longa",
            R.drawable.img05, listOf("VERMELHO", "AZUL"),
            listOf("P", "G")),
        Product("Blusas Manga Curta", 42.50,"Camisa manga Curta Cropped",
            R.drawable.img04, listOf("AZUL", "VERMELHO"),
            listOf("P", "M", "G")),

        Product("Blusa Social Renner Jeans", 112.12,"Camisa Social",
            R.drawable.img03, listOf("VERMELHO", "PRETO"),
            listOf("P", "M", "G")),

        Product("CONJUNTO TOP COM CAMISA E JEANS", 122.40,"Conjunto Alameda",
            R.drawable.img02, listOf("AZUL", "VERMELHO"),
            listOf("P", "G")),

        Product("Vestido Longo",
            129.90,"VESTIDO LONGO COM MIX DE ESTAMPAS MARROM",
            R.drawable.img01,
            listOf("PRETO", "VERMELHO", "AZUL"),
            listOf("P", "M", "G")),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar();

        nav_view.setNavigationItemSelectedListener(this)

        item_list.initialize(itemAdapter)
        item_list.setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
        itemAdapter.setItems(getLargeListOfItems())

        item_list02.initialize(itemAdapter2)
        item_list02.setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
        itemAdapter2.setItems(getLargeListOfItems())


    }

    private fun getLargeListOfItems(): List<Product> {
        val items = mutableListOf<Product>()
        (0..10).map { items.add(possibleItems.random()) }
        return items
    }

    private fun setupActionBar(){
        setSupportActionBar(toolbar_main_activity)
        toolbar_main_activity.setNavigationIcon(R.drawable.ic_nav_drawer)
        toolbar_main_activity.setNavigationOnClickListener{
            toggleDrawer()
        }
    }

    private fun toggleDrawer(){
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            doubleBackToExit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_my_profile -> {
                Toast.makeText(this@MainActivity, "Meu perfil", Toast.LENGTH_LONG)
            }
            R.id.nav_signout -> {
                Toast.makeText(this@MainActivity, "Logout", Toast.LENGTH_LONG)
                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}


