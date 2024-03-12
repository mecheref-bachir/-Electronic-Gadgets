package com.bachir.electronicgadgets

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainViewAdapter(
    private val context: Context,
    private val productsList: ArrayList<Product>,
    private val  itemClickedListener: ItemClickedListener
) : RecyclerView.Adapter<MainViewAdapter.ViewHolder>() {


    interface ItemClickedListener{
    fun onItemClickListener(product: Product)
    fun onAddClickListener(product: Product)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     var view = LayoutInflater.from(context).inflate(R.layout.card_product,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
          return productsList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(productsList[position])
    }




    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(product: Product) {
             val tvPrice =     itemView.findViewById<TextView>(R.id.tvPrice)
             val tvDescription=     itemView.findViewById<TextView>(R.id.tvDescription)
             val tvProductName = itemView.findViewById<TextView>(R.id.tvProductName)
             val  ivLogo = itemView.findViewById<ImageView>(R.id.ivLogo)
             val ivProductImage = itemView.findViewById<ImageView>(R.id.ivProductImage)
             val btnAdd = itemView.findViewById<Button>(R.id.btnAdd)



            tvPrice.text = "$ ${product.cost.toString()}"
            tvDescription.text = product.productDescription
            tvProductName.text = product.productName
            ivProductImage.setImageResource(product.srcProduct)
            ivLogo.setImageResource(product.srcLogo)


            itemView.setOnClickListener{
                itemClickedListener.onItemClickListener(product)
            }
            btnAdd.setOnClickListener{
                itemClickedListener.onAddClickListener(product)
            }
            }
        }

}
