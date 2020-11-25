package com.example.androidinterviewprep.drapanddrop.customui

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.androidinterviewprep.R

class DragAndDropContainer(
    context: Context,
    attrs: AttributeSet?
) : FrameLayout(context, attrs) {
    private var content: View? = null

    fun setContent(view: View) {
        removeAllViews()
        addView(view)
        updateChild()
    }
    fun removeContent(view: View) {
        view.setOnLongClickListener(null)
        removeView(view)
        updateChild()
    }
    private fun updateChild() {
        content = getFirstChild()
        content?.setOnLongClickListener { startDrag() }
    }
    private fun getFirstChild() = if (childCount == 1) getChildAt(0) else null

    private fun startDrag(): Boolean {
        content?.let {
            val tag = it.tag as? CharSequence
            val item = ClipData.Item(tag)
            val data = ClipData(tag, arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
            val shadow = DragShadowBuilder(it)
            if (Build.VERSION.SDK_INT >= 24) {
                it.startDragAndDrop(data, shadow, it, 0)
            } else {
                it.startDrag(data, shadow, it, 0)
            }
            return true
        } ?: return false
    }
    private val dragAndDropListener by lazy { DragAndDropListener() }

    init {
        setOnDragListener(dragAndDropListener)
    }
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        updateChild()
    }
}
class DragAndDropListener : View.OnDragListener {
    override fun onDrag(view: View, event: DragEvent): Boolean {
        return when (event.action) {
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.setDashedOutline(); true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                view.setSolidOutline(); true
            }
            DragEvent.ACTION_DROP -> {
                val draggingView = event.localState as View
                val draggingViewParent = draggingView.parent as DragAndDropContainer
                draggingViewParent.removeContent(draggingView)

                val landingContainer = view as DragAndDropContainer
                landingContainer.setContent(draggingView)
                landingContainer.setSolidOutline()
                true
            }
            DragEvent.ACTION_DRAG_STARTED -> event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            else -> true
        }
    }

    private fun View.setSolidOutline() {
        background = ContextCompat.getDrawable(context, R.drawable.outline_gray_solid)
    }

    private fun View.setDashedOutline() {
        background = ContextCompat.getDrawable(context, R.drawable.outline_gray_dashed)
    }
}