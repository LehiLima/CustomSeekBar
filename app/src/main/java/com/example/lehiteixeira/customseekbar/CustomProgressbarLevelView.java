package com.example.lehiteixeira.customseekbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by lteixeira on 29/05/17.
 */

public class CustomProgressbarLevelView extends RelativeLayout {

    TextView txtPreviusLevel;
    TextView txtNextLevel;
    ImageView imgPreviousLevel;
    ImageView imgNextLevel;
    CustomTextThumbSeekBar seekBar2;

    public CustomProgressbarLevelView(Context context) {
        super(context);
        init();
    }

    public CustomProgressbarLevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.view_seekbar_progressbar, this, true);

        txtNextLevel = (TextView) findViewById(R.id.txtNextLevel);
        txtPreviusLevel = (TextView) findViewById(R.id.txtPreviuslevel);
        imgPreviousLevel = (ImageView) findViewById(R.id.imgPreviousLevel);
        imgNextLevel = (ImageView) findViewById(R.id.imgNextLevel);
        seekBar2 = (CustomTextThumbSeekBar) findViewById(R.id.seekBar2);
    }

    public void changeLevelbar(String previouslevel, String nextlevel, String cuurentlevel, int cnpoints, int nextlevelpoints, int currentLevelInitPoints){
        txtPreviusLevel.setText(Integer.toString(currentLevelInitPoints));
        txtNextLevel.setText(Integer.toString(nextlevelpoints)  );
        seekBar2.setMax(nextlevelpoints - currentLevelInitPoints);

        Drawable backgroundPrevious = imgPreviousLevel.getBackground();
        Drawable backgroundNext = imgNextLevel.getBackground();
        // Set previus level and next level for lollipop
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            if(previouslevel == null){
                imgPreviousLevel.setVisibility(GONE);
            } else {
                ((GradientDrawable) backgroundPrevious).setColor(Color.parseColor(previouslevel));
            }

            if(nextlevel == null){
                imgNextLevel.setVisibility(GONE);
            } else {
                ((GradientDrawable) backgroundNext).setColor(Color.parseColor(nextlevel));
            }

        }
        // Set previus level and next level for lollipop and above
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if(previouslevel == null){
                imgPreviousLevel.setVisibility(GONE);
            } else {
                backgroundPrevious.setTint(Color.parseColor(previouslevel));
            }

            if(nextlevel == null){
                imgNextLevel.setVisibility(GONE);
            } else {
                backgroundNext.setTint(Color.parseColor(nextlevel));
            }

        } else {
            if(previouslevel == null){
                imgPreviousLevel.setVisibility(GONE);
            } else {
                ((GradientDrawable) backgroundPrevious).setColor(Color.parseColor(previouslevel));
            }

            if(nextlevel == null){
                imgNextLevel.setVisibility(GONE);
            } else {
                ((GradientDrawable) backgroundNext).setColor(Color.parseColor(nextlevel));
            }

        }

        seekBar2.setProgress(cnpoints - currentLevelInitPoints);
        seekBar2.setPreviusLevelProgress(currentLevelInitPoints);
        seekBar2.setCurrentPointsCn(cnpoints);
        //seekBar2.getThumb().setColorFilter(Color.parseColor(cuurentlevel), PorterDuff.Mode.SRC_IN);

        LayerDrawable d = (LayerDrawable) seekBar2.getThumb().getCurrent();
        d.findDrawableByLayerId(R.id.prog).setColorFilter(Color.parseColor(cuurentlevel), PorterDuff.Mode.SRC_IN);

        // Set progress color
        LayerDrawable bgDrawable = (LayerDrawable) seekBar2.getProgressDrawable();
        final ClipDrawable shape = (ClipDrawable) bgDrawable.findDrawableByLayerId(R.id.progress);
        shape.setColorFilter(Color.parseColor(cuurentlevel), PorterDuff.Mode.SRC_IN);

        seekBar2.setOnTouchListener(new OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

}
