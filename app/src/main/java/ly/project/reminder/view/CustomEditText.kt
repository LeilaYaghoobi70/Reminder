package ly.project.reminder.view

import android.content.Context
import android.graphics.Rect
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import ly.project.reminder.R


class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.editTextStyle,
) : AppCompatEditText(context, attrs, defStyleAttr) {
    private var mTypeface: Typeface =
        Typeface.createFromAsset(context.assets, "font/IRANYekanMobileRegular.ttf")

    init {
        typeface = mTypeface
        initAttar()
    }

    override fun setTypeface(tf: Typeface?, style: Int) {
        super.setTypeface(mTypeface, style)
    }

    override fun setTypeface(tf: Typeface?) {
        super.setTypeface(mTypeface)
    }

    private  fun initAttar(){
        background =   ContextCompat.getDrawable(context, R.drawable.corner_12_greenff)
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        background = if (isFocused)
            ContextCompat.getDrawable(context, R.drawable.corner_12_green)
        else
            ContextCompat.getDrawable(context, R.drawable.corner_12_greenff)
    }
}