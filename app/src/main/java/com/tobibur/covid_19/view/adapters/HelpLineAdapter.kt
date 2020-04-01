package com.tobibur.covid_19.view.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Help
import com.tobibur.covid_19.utils.inflate
import kotlinx.android.synthetic.main.item_phone_numbers.view.*

class HelpLineAdapter(private val helplines: List<Help>) :
    RecyclerView.Adapter<HelpLineAdapter.HelpViewHolder>() {

    inner class HelpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        return HelpViewHolder(parent.inflate(R.layout.item_phone_numbers))
    }

    override fun getItemCount(): Int {
        return helplines.size
    }

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        val helpline = helplines[position]
        holder.itemView.apply {
            phoneName.text = helpline.place
            phoneNumber.text = helpline.helpline
        }
    }
}