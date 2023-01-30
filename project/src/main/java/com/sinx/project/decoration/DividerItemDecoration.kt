package com.sinx.project.decoration

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration(
    private val mDivider: Drawable?
) : RecyclerView.ItemDecoration() {

    companion object {
        const val DIVIDER_LEFT = 88
    }

    override fun onDraw(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemCount = parent.adapter?.itemCount ?: 0
        parent.children.forEach { view ->
            val childAdapterPosition = parent.getChildAdapterPosition(view)
                .let { if (it == RecyclerView.NO_POSITION) return else it }
            if (childAdapterPosition in 0 until itemCount - 1) {
                val dividerLeft = DIVIDER_LEFT
                val dividerRight: Int = parent.width - DIVIDER_LEFT
                val dividerTop: Int = view.bottom
                val dividerBottom: Int =
                    view.bottom + (mDivider?.intrinsicHeight ?: 0) + view.paddingBottom

                mDivider?.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                mDivider?.draw(c)
            }
        }
    }
}