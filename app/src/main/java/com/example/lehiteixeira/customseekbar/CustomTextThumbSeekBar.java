package com.example.lehiteixeira.customseekbar;

/**
 * Created by Lehiteixeira on 31/08/17.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;

/**
 * Created by lteixeira on 19/05/2017.
 */
public class CustomTextThumbSeekBar extends android.support.v7.widget.AppCompatSeekBar {

    private int mThumbSize;
    private TextPaint mTextPaint;
    private int previuslevel;
    private int currentPointsCn;

    public CustomTextThumbSeekBar(Context context) {
        this(context, null);
    }

    public CustomTextThumbSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.seekBarStyle);
    }

    public CustomTextThumbSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mThumbSize = getResources().getDimensionPixelSize(R.dimen.thumb_width);

        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(getResources().getDimensionPixelSize(R.dimen.thumb_text_size));
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String progressText = String.valueOf(currentPointsCn);
        Rect bounds = new Rect();
        mTextPaint.getTextBounds(progressText, 0, progressText.length(), bounds);

        int leftPadding = getPaddingLeft() - getThumbOffset();
        int rightPadding = getPaddingRight() - getThumbOffset();
        int width = getWidth() - leftPadding - rightPadding;
        float progressRatio = (float) getProgress() / getMax();
        float thumbOffset = mThumbSize * (.5f - progressRatio);
        float thumbX = progressRatio * width + leftPadding + thumbOffset;
        float thumbY = getHeight() / 2f + bounds.height() / 2f;
        canvas.drawText(progressText + " pts", thumbX, thumbY, mTextPaint);
    }

    public void setPreviusLevelProgress(int previuslevel){

        this.previuslevel = previuslevel;
    }

    public void setCurrentPointsCn(int currentPointsCn) {
        this.currentPointsCn = currentPointsCn;
    }
}
