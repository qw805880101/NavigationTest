package com.example.tc.navigationtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomTestView : View {

    constructor(mContext: Context) : super(mContext)
    constructor(mContext: Context, attributeSet: AttributeSet) : super(mContext, attributeSet)
    constructor(mContext: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attributeSet,
        defStyleAttr
    )

    private val mPaint = Paint()
    private var mWidth = 0
    private var mHeight = 0
    private var color = Color.RED
    private var text = ""

    init {
        mPaint.color = Color.RED
        mPaint.textSize = 40f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        mWidth = widthMeasureSpec
//        mHeight = heightMeasureSpec

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        mWidth = width
        mHeight = height

        canvas.drawColor(color)
        canvas.drawText(text, width / 2f, height / 2f, mPaint)
    }

    fun setColor(color: String) {
        this.text = color
        this.color = Color.parseColor(color)
        invalidate()
    }
}