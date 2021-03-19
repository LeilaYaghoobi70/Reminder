package ly.project.reminder.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout

import android.widget.RelativeLayout
import androidx.annotation.DrawableRes
import ly.project.reminder.R
import ly.project.reminder.databinding.ToolbarBinding


class Toolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var binding = ToolbarBinding.inflate(LayoutInflater.from(context), this, true)


    fun setLeftIcon(@DrawableRes drawable: Int, setOnClickListener: OnClickListener?) {
        binding.startIcon.apply {
            setImageResource(drawable)
            setOnClickListener(setOnClickListener)
            visibility = VISIBLE
        }
    }

    fun setRightIcon(@DrawableRes drawable: Int, setOnClickListener: OnClickListener?) {
        binding.endIcon.apply {
            setImageResource(drawable)
            setOnClickListener(setOnClickListener)
            visibility = VISIBLE
        }
    }

    fun setCenterIcon(@DrawableRes drawable: Int, setOnClickListener: OnClickListener?) {
        binding.centerIcon.apply {
            setImageResource(drawable)
            setOnClickListener(setOnClickListener)
            visibility = VISIBLE
        }
    }


}