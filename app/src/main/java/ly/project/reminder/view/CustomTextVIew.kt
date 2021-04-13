package ly.project.reminder.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import ly.project.reminder.R


class CustomTextVIew @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr){
    private var mTypeface: Typeface = Typeface.createFromAsset(context.assets, "font/IRANYekanMobileMedium.ttf")

    init {
        typeface = mTypeface
    }
    override fun setTypeface(tf: Typeface?, style: Int) {
        super.setTypeface(mTypeface, style)
    }
    override fun setTypeface(tf: Typeface?) {
        super.setTypeface(mTypeface)
    }
}