package ly.project.reminder.calenderpager

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import androidx.core.content.ContextCompat
import ly.project.reminder.R
import ly.project.reminder.utils.formatNumber
import ly.project.reminder.utils.isHighTextContrastEnabled
import ly.project.reminder.utils.isNonArabicScriptSelected
import kotlin.math.min

class DayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) :
    View(context, attrs) {

    private val halfEventBarWidth = context.resources
        .getDimensionPixelSize(R.dimen.day_item_event_bar_width) / 2
    private val appointmentYOffset = context.resources
        .getDimensionPixelSize(R.dimen.day_item_appointment_y_offset)
    private val eventYOffset = context.resources
        .getDimensionPixelSize(R.dimen.day_item_event_y_offset)
    private val eventBarPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = context.resources
            .getDimensionPixelSize(R.dimen.day_item_event_bar_thickness).toFloat()
    }
    private val selectedPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = ContextCompat.getColor(context, R.color.green65)
    }
    private val todayPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = context.resources
            .getDimensionPixelSize(R.dimen.day_item_today_indicator_thickness).toFloat()
        color = ContextCompat.getColor(context, R.color.green65)
    }
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mWidth = width
    private val mHeight = height

    private val bounds = Rect()
    private val drawingRect = RectF()
    private val headerPaint = Paint()
    private val headerRect = RectF()
    private var text = ""
    private var today: Boolean = false
    private var dayIsSelected: Boolean = false
    private var hasEvent: Boolean = false
    private var hasAppointment: Boolean = false
    private var holiday: Boolean = false
    private var textSize: Int = 0
    var jdn: Long = -1
        private set
    var dayOfMonth = -1
        private set
    private var isNumber: Boolean = false
    private var header = ""

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width
        val height = height
        val radius = min(width, height) / 2

        getDrawingRect(bounds)
        drawingRect.set(bounds)
        drawingRect.inset(radius * 0.1f, radius * 0.1f)
        val yOffsetToApply = 0



        if (dayIsSelected) {
            canvas.drawRoundRect(
              drawingRect, 20f,  20f,
                selectedPaint
            )

        }

        if (today) {
            canvas.drawRoundRect(drawingRect, 20f,  20f, todayPaint)
        }

        val color: Int = if (isNumber) {
            if (holiday)
                if (dayIsSelected) ContextCompat.getColor(context,R.color.white) else ContextCompat.getColor(context,R.color.holiday_green)
            else
                if (dayIsSelected)  ContextCompat.getColor(context,R.color.white) else  ContextCompat.getColor(context,R.color.number_color)
        } else {
            ContextCompat.getColor(context,R.color.number_color)
        }

        if (!isNumber){
            headerPaint.color  = ContextCompat.getColor(context, R.color.background_view_pager_color)
            headerRect.set(0F,0F+2 , width.toFloat() , drawingRect.height() +10)
            canvas.drawRoundRect(headerRect,0F,0F ,headerPaint )
        }

        eventBarPaint.color =
            if (dayIsSelected) ContextCompat.getColor(context, R.color.green65) else color

        if (isHighTextContrastEnabled && holiday)
            eventBarPaint.color = ContextCompat.getColor(context,R.color.number_color)

        if (hasEvent) {
            canvas.drawLine(
                width / 2f - halfEventBarWidth,
                (height - eventYOffset + yOffsetToApply).toFloat(),
                width / 2f + halfEventBarWidth,
                (height - eventYOffset + yOffsetToApply).toFloat(), eventBarPaint
            )
        }

        if (hasAppointment) {
            canvas.drawLine(
                width / 2f - halfEventBarWidth,
                (height - appointmentYOffset + yOffsetToApply).toFloat(),
                width / 2f + halfEventBarWidth,
                (height - appointmentYOffset + yOffsetToApply).toFloat(),
                eventBarPaint
            )
        }

        // TODO: Better to not change resource's paint objects, but for now
        textPaint.color = color
        textPaint.textSize = textSize.toFloat()

        val xPos = (width - textPaint.measureText(text).toInt()) / 2
        val textToMeasureHeight =
            if (isNumber) text else if (isNonArabicScriptSelected()) "Y" else "شچ"
        textPaint.getTextBounds(textToMeasureHeight, 0, textToMeasureHeight.length, bounds)
        var yPos = (height + bounds.height()) / 2
        yPos += yOffsetToApply
        canvas.drawText(text, xPos.toFloat(), yPos.toFloat(), textPaint)

        textPaint.color = if (dayIsSelected) ContextCompat.getColor(
            context, R.color.green65
        ) else ContextCompat.getColor(context, R.color.green65)

        textPaint.textSize = textSize / 2f
        if (header.isNotEmpty()) {
            val headerXPos = (width - textPaint.measureText(header).toInt()) / 2F
            canvas.drawText(header, headerXPos, yPos * 0.87f - bounds.height(), textPaint)
        }
    }

    private fun setAll(
        text: String, isToday: Boolean, isSelected: Boolean,
        hasEvent: Boolean, hasAppointment: Boolean, isHoliday: Boolean,
        textSize: Int, jdn: Long, dayOfMonth: Int, isNumber: Boolean,
        header: String
    ) {
        this.text = text
        this.today = isToday
        this.dayIsSelected = isSelected
        this.hasEvent = hasEvent
        this.hasAppointment = hasAppointment
        this.holiday = isHoliday
        this.textSize = textSize
        this.jdn = jdn
        this.dayOfMonth = dayOfMonth
        this.isNumber = isNumber
        this.header = header
        postInvalidate()
    }

    fun setDayOfMonthItem(
        isToday: Boolean, isSelected: Boolean,
        hasEvent: Boolean, hasAppointment: Boolean, isHoliday: Boolean,
        textSize: Int, jdn: Long, dayOfMonth: Int, header: String
    ) = setAll(
        formatNumber(dayOfMonth), isToday, isSelected, hasEvent, hasAppointment,
        isHoliday, textSize, jdn, dayOfMonth, true, header
    )

    fun setNonDayOfMonthItem(text: String, textSize: Int) = setAll(
        text, isToday = false, isSelected = false, hasEvent = false, hasAppointment = false,
        isHoliday = false, textSize = textSize, jdn = -1, dayOfMonth = -1, isNumber = false,
        header = ""
    )
}
