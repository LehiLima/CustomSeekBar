package com.example.lehiteixeira.customseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.naturaprogressbar)
    CustomProgressbarLevelView CustomSeekbarprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        CustomSeekbarprogressbar.changeLevelbar("#5C6BC0", "#9575CD", "#8BC34A", 150, 200, 100);

    }
}
