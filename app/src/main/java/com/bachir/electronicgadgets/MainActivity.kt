package com.bachir.electronicgadgets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var btnViewCart: Button
    private lateinit var rvMainActivity: RecyclerView

    companion object {
        private const val COLUMNS = 1;
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        val cartProducts = ArrayList<Product>()

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", R.drawable.ipadpro, R.drawable.app, 400.0))
        products.add(
            Product(
                "MacBook M3 Pro",
                "12-core CPU\n18-core GPU",
                R.drawable.makbook, R.drawable.app,
                2500.00
            )
        )
        products.add(
            Product(
                "Dell Inspiron",
                "13th Gen Intel® Core™ i7",
                R.drawable.dellproduct, R.drawable.delllogo,
                1499.00
            )
        )
        products.add(
            Product(
                "Logitech Keyboard",
                "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                R.drawable.keyboardproduct,
                R.drawable.logitechlogo,
                199.00
            )
        )
        products.add(
            Product(
                "MacBook M3 Max",
                "14-core CPU\n30-core GPU",
                R.drawable.ipadpro,
                R.drawable.app,
                3499.00
            )
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMainActivity = findViewById<RecyclerView>(R.id.rvMainActivity)
        rvMainActivity.layoutManager = GridLayoutManager(this, COLUMNS)
        rvMainActivity.setHasFixedSize(true)


        rvMainActivity.adapter = MainViewAdapter(this, products, object :
            MainViewAdapter.ItemClickedListener {
            override fun onItemClickListener(product: Product) {
                val intent = Intent(this@MainActivity, DetailedViewActivity::class.java)
                intent.putExtra("PROD", product)
                startActivity(intent)
            }

            override fun onAddClickListener(product: Product) {
                cartProducts.add(product)
            }
        })
        btnViewCart = findViewById(R.id.btnViewCart)
        btnViewCart.setOnClickListener {
            var listOfProducts = "list of added products: " + "\n"
            for (product in cartProducts) {
                listOfProducts = listOfProducts + product.productName + "\n"
            }
            Toast.makeText(this@MainActivity, listOfProducts, Toast.LENGTH_LONG).show()
        }
    }
}