package com.sinx.project.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecorator(
    context: Context,
    resId: Int
) : RecyclerView.ItemDecoration() {

    private val mDivider: Drawable = ContextCompat.getDrawable(context, resId)!!

    override fun onDraw(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val dividerLeft = 88
        val dividerRight: Int = parent.width - 88

        for (i in 0 until parent.childCount - 2) {

            if (i != parent.childCount - 1) {
                val child: View = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams

                val dividerTop: Int = child.bottom + params.bottomMargin
                val dividerBottom: Int = dividerTop + mDivider.intrinsicHeight

                mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                mDivider.draw(c)
            }
        }
    }
}