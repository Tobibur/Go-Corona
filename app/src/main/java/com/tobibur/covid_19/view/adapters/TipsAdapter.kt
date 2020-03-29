package com.tobibur.covid_19.view.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Tips
import com.tobibur.covid_19.utils.inflate
import com.tobibur.covid_19.utils.load
import kotlinx.android.synthetic.main.item_precaution_tips.view.*

class TipsAdapter(
    private val itemClickListener: TipsClickListner
) :
    ListAdapter<Tips, TipsAdapter.TipsViewHolder>(TipsDiffUtil()) {

    inner class TipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        return TipsViewHolder(parent.inflate(R.layout.item_precaution_tips))
    }


    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        val tips = getItem(position)
        holder.itemView.apply {

            tip_img.load(tips.tipsImage, context)
            tip_title.text = tips.tipTitle

            recent_topics_container.setOnClickListener {

                itemClickListener.onTipsClick(tips)

            }
        }
    }
}

class TipsDiffUtil : DiffUtil.ItemCallback<Tips>() {
    override fun areItemsTheSame(oldItem: Tips, newItem: Tips): Boolean =
        oldItem.tipTitle == newItem.tipTitle

    override fun areContentsTheSame(oldItem: Tips, newItem: Tips): Boolean = oldItem == newItem

}

interface TipsClickListner {
    fun onTipsClick(tip: Tips)
}