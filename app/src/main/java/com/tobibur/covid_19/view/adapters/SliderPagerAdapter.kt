package com.tobibur.covid_19.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.tobibur.covid_19.R
import com.tobibur.covid_19.utils.load
import kotlinx.android.synthetic.main.image_slider_layout.view.*


class SliderPagerAdapter(context: Context) : PagerAdapter() {

    private val mContext = context

    private val imgList =
        listOf(R.drawable.safe_greetings, R.drawable.handshaking, R.drawable.wearing_gloves)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imgList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater.inflate(R.layout.image_slider_layout, null)
        v.precaution_banner.load(imgList[position], mContext)

        val vp = container as ViewPager
        vp.addView(v, 0)
        return v

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View?
        vp.removeView(view)
    }

}