package com.vagabond.customcheckablelistview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Checkable;

import static android.content.ContentValues.TAG;

/**
 * Created by debanjan on 4/12/16.
 */

public class CheckableCardView extends CardView implements Checkable {
    public CheckableCardView(Context context) {
        super(context);
    }

    public CheckableCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckableCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setChecked(boolean b) {
        Log.e(TAG, "setChecked: "+ b);
    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {
        Log.e(TAG, "toggle: " );
    }
}
