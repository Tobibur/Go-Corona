package com.tobibur.covid_19.view.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Help
import com.tobibur.covid_19.utils.inflate
import kotlinx.android.synthetic.main.item_phone_numbers.view.*


class HelpLineAdapter(private val helplines: List<Help>, private val mContext: Context) :
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

        holder.itemView.recent_topics_container.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${helpline.helpline}")
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${helpline.helpline}")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            mContext.startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "HelpLineAdapter"
    }
}