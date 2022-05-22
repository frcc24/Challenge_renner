package com.example.rennerapp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.marginEnd
import androidx.core.view.setMargins
import com.example.rennerapp.R
import com.example.rennerapp.models.Product
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.app_bar_main.*

class ProductDetailsActivity : BaseActivity() {
    lateinit var product: Product


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        product = intent.getSerializableExtra("product") as Product

        val colors_btn_layout = findViewById<LinearLayout>(R.id.colors_btn_layout)

        for(  colors in product.colors )
        {
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                            LinearLayout.LayoutParams.WRAP_CONTENT)
           (button.layoutParams as LinearLayout.LayoutParams).setMargins(0,0,10,0)

            if(colors.equals("PRETO")) {
                button.setBackgroundColor(Color.BLACK)
                button.setOnClickListener(View.OnClickListener {
                    // button.text = "You just clicked me"
                    txt_cor.text = "PRETO"
                })
            }
            else if(colors.equals("AZUL")){
                button.setBackgroundColor(Color.BLUE)
                button.setOnClickListener(View.OnClickListener {
                    // button.text = "You just clicked me"
                    txt_cor.text = "AZUL"
                })
            }
            else {
                button.setBackgroundColor(Color.RED)
                button.setOnClickListener(View.OnClickListener {
                    // button.text = "You just clicked me"
                    txt_cor.text = "VERMELHO"
                })

            }
            colors_btn_layout.addView(button)
        }

        val size_btn_layout = findViewById<LinearLayout>(R.id.size_btn_layout)
        for(  size in product.size )
        {
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
            (button.layoutParams as LinearLayout.LayoutParams).setMargins(0,0,10,0)
            button.text = size

            if(size.equals("P")) {
                button.setBackgroundColor(Color.WHITE)
                button.setOnClickListener(View.OnClickListener {
                    // button.text = "You just clicked me"
                    txt_size.text = "Tamanho: P"
                })
            }
            else if(size.equals("M")){
                button.setBackgroundColor(Color.WHITE)
                button.setOnClickListener(View.OnClickListener {
                    // button.text = "You just clicked me"
                    txt_size.text = "Tamanho: M"

                })
            }
            else {
                button.setBackgroundColor(Color.WHITE)
                button.setOnClickListener(View.OnClickListener {
                    // button.text = "You just clicked me"
                    txt_size.text = "Tamanho: G"

                })

            }
            size_btn_layout.addView(button)
        }

        ic_fav.setOnClickListener {
            ic_fav.setImageResource(R.drawable.ic_fav_red)
        }

        img_prod_ac_top.setImageResource( product.icon )
        txt_prod_name.text = product.name
        txt_prod_price.text = "R\$ ${(product.price)}"
        txt_prod_details.text = product.description
        txt_cor.text = product.colors[0]
        txt_size.text = "Tamanho: ${product.size[0]}"

    }


}