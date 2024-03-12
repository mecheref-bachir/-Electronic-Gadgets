package com.bachir.electronicgadgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView.FindListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailedViewActivity : AppCompatActivity() {

    private lateinit var btnBackHom: Button
    private lateinit var tvName:TextView
    private lateinit var tvPrice:TextView
    private lateinit var tvDescription:TextView
    private lateinit var ivDetailProductImage:ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        btnBackHom = findViewById(R.id.btnBackHome)
        tvName = findViewById(R.id.tvName)
        tvPrice = findViewById(R.id.tvProductPrice)
        tvDescription = findViewById(R.id.tvProductDescription)
        ivDetailProductImage= findViewById(R.id.ivDetailProductImage)

        if(intent.hasExtra("PROD")){
              val product = intent.getSerializableExtra("PROD") as Product
              if(product.productName != null){
                  tvName.text = product.productName
                  tvDescription.text = product.productDescription
                  tvPrice.text = product.cost.toString()
                  ivDetailProductImage.setImageResource(product.srcProduct)

            }

        }

        btnBackHom.setOnClickListener{
            this.finish()
        }

    }
}