package ly.project.reminder.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import ly.project.reminder.R

class CustomBottom @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.editTextStyle,
) : AppCompatButton(context, attrs, defStyleAttr) {
    init {
        val tf = Typeface.createFromAsset(context.assets, "font/IRANYekanMobileMedium.ttf")
        typeface = tf
    }
}