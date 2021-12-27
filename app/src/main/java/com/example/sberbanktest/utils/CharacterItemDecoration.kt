package com.example.sberbanktest.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class CharacterItemDecoration(space: Int, verticalOrientation: Boolean) : ItemDecoration() {
    private var mSpace = space
    private var mVerticalOrientation = verticalOrientation

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = SizeUtils.dp2px(view.context, mSpace)
        if (mVerticalOrientation) {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect[0, SizeUtils.dp2px(view.context, mSpace), 0] = SizeUtils.dp2px(view.context, mSpace)
            } else {
                outRect[0, 0, 0] = SizeUtils.dp2px(view.context, mSpace)
            }
        } else {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect[SizeUtils.dp2px(view.context, mSpace), 0, 0] = 0
            } else {
                outRect[SizeUtils.dp2px(view.context, mSpace), 0, SizeUtils.dp2px(view.context, mSpace)] = 0
            }
        }
    }
}

object SizeUtils {
    fun dp2px(context: Context, dpValue: Int): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}

