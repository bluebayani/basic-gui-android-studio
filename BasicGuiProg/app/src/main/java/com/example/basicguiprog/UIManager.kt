package com.example.basicguiprog

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class UIManager(val ctx: Context) {
    fun createFullScreen(): View {
        val lLayoutObj = LinearLayout(ctx)
        val lp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        lLayoutObj.setBackgroundColor(Color.GRAY)
        lLayoutObj.layoutParams = lp
        lLayoutObj.orientation = LinearLayout.VERTICAL

        var lObj = createSideBySideTextView(Color.YELLOW, Color.GREEN)
        var llp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        llp.weight = 1.0F
        lObj.layoutParams = llp
        lLayoutObj.addView(lObj)

        lObj = createSideBySideTextView(Color.GREEN, Color.YELLOW)
        llp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        llp.weight = 1.0F
        lObj.layoutParams = llp
        lLayoutObj.addView(lObj)

        return lLayoutObj
    }

    fun createSideBySideTextView(col1: Int, col2: Int): View {

        val lLayoutObj = LinearLayout(ctx)
        val lp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lLayoutObj.setBackgroundColor(Color.GRAY)
        lLayoutObj.layoutParams = lp
        lLayoutObj.orientation = LinearLayout.HORIZONTAL

        //add two text views
        var tv = createTextView("Label 1", col1)
        var viewlayoutparam = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        viewlayoutparam.marginStart = 40
        viewlayoutparam.marginEnd = 40
        viewlayoutparam.topMargin = 40
        viewlayoutparam.weight = 1.0F
        tv.layoutParams = viewlayoutparam
        lLayoutObj.addView(tv)


        tv = createTextView("Label 2", col2)
        viewlayoutparam = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        viewlayoutparam.weight = 1.0F
        tv.layoutParams = viewlayoutparam
        lLayoutObj.addView(tv)


        return lLayoutObj
    }

    fun createTextView(content: String, col: Int): View {
        lateinit var tv: TextView
        //create the TextView widget object
        tv = TextView(ctx)
        tv.text = content
        tv.setTextColor(Color.RED)
        tv.setBackgroundColor(col)
        tv.setTypeface(Typeface.create("monospace", Typeface.BOLD_ITALIC))
        //size of text - use sp
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
        //padding - sets the inner border of the text to 50px. can also use dp. better to use dp
        // just eyeball
//        tv.setPadding(50,50,50,50)
        //gravity- the text will fall to the center vertical
//        tv.gravity = Gravity.CENTER_VERTICAL
        return tv
    }
}