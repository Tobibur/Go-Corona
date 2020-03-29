package com.tobibur.covid_19.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Tips
import com.tobibur.covid_19.view.adapters.SliderPagerAdapter
import com.tobibur.covid_19.view.adapters.TipsAdapter
import com.tobibur.covid_19.view.adapters.TipsClickListner
import kotlinx.android.synthetic.main.guide_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class GuideFragment : Fragment(), TipsClickListner {

    companion object {
        fun newInstance() = GuideFragment()
    }

    private val guideViewModel: GuideViewModel by viewModel()
    lateinit var tipsAdapter: TipsAdapter
    private var dotscount = 0
    private var dots = mutableListOf<ImageView>()
    private lateinit var mSliderLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.guide_fragment, container, false)
        mSliderLayout = v.findViewById(R.id.SliderDots)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = SliderPagerAdapter(activity!!)
        vp_slider.adapter = viewPagerAdapter


        dotscount = viewPagerAdapter.count

        for (i in 0 until dotscount) {
            dots.add(ImageView(activity))
            dots[i].setImageDrawable(
                ContextCompat.getDrawable(
                    activity!!,
                    R.drawable.non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            mSliderLayout.addView(dots[i], params)
        }

        dots[0].setImageDrawable(
            ContextCompat.getDrawable(
                activity!!,
                R.drawable.active_dot
            )
        )

        vp_slider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i].setImageDrawable(
                        ContextCompat.getDrawable(
                            activity!!,
                            R.drawable.non_active_dot
                        )
                    )
                }

                dots[position].setImageDrawable(
                    ContextCompat.getDrawable(
                        activity!!,
                        R.drawable.active_dot
                    )
                )
            }

        })

        initList()

        fillTipsList()

    }

    private fun fillTipsList() {
        tipsAdapter.submitList(guideViewModel.tipsMutableList)
    }

    private fun initList() {
        tipsAdapter = TipsAdapter(this)
        tips_list.adapter = tipsAdapter
    }

    override fun onTipsClick(tip: Tips) {
//        TODo: go to detailed writeup.


        findNavController().navigate(
            GuideFragmentDirections.actionGuideFragmentToTipDetailFragment(
                tip
            )
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mSliderLayout.removeAllViews()
    }

}
