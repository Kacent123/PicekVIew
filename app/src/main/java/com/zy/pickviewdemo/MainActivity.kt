package com.zy.pickviewdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zy.pickview.WheelView
import com.zy.pickview.listener.OnItemSelectedListener
import com.zy.pickviewdemo.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
    }

    private fun initView() {
        initPickerLeft()
        initPickerRight()
    }

    private fun initPickerRight() {
        mBinding.wvFocal.setTextSize(14f)
        mBinding.wvFocal.setLineSpacingMultiplier(3.5f)
        mBinding.wvFocal.setDividerWidth(5)
        mBinding.wvFocal.setItemsVisibleCount(16)
        mBinding.wvFocal.setDividerType(WheelView.DividerType.FILL)
        val mOptionsItems = ArrayList<String>()
        val df = DecimalFormat("#.#")
        var i = 30f
        while (i >= 0.9f) {
            mOptionsItems.add("X${df.format(i.toDouble())}")
            i -= 0.1f
        }

        mBinding.wvFocal.adapter = ArrayWheelAdapter(mOptionsItems)
        val itemSelectedListener = OnItemSelectedListener { index ->
            Toast.makeText(
                this@MainActivity, "" + mOptionsItems[index], Toast.LENGTH_SHORT
            ).show()
        }
        mBinding.wvFocal.setOnItemSelectedListener(itemSelectedListener)
        mBinding.wvFocal.setCyclic(false)
        //
        mBinding.wvFocal.currentItem = mOptionsItems.lastIndex
    }

    private fun initPickerLeft() {
        mBinding.wvHeight.setTextSize(14f)
        mBinding.wvHeight.setLineSpacingMultiplier(3.5f)
        mBinding.wvHeight.setDividerWidth(5)
        mBinding.wvHeight.setItemsVisibleCount(16)
        mBinding.wvHeight.setDividerType(WheelView.DividerType.FILL)
        val mOptionsItems = ArrayList<String>()
        var i = 7510
        while (i >= -7500) {
            mOptionsItems.add(i.toString())
            i -= 10
        }

        mBinding.wvHeight.adapter = ArrayWheelAdapter(mOptionsItems)
        mBinding.wvHeight.setOnItemSelectedListener { index ->
            Toast.makeText(
                this@MainActivity, "" + mOptionsItems[index], Toast.LENGTH_SHORT
            ).show()
        }
        mBinding.wvHeight.setCyclic(false)
    }
}