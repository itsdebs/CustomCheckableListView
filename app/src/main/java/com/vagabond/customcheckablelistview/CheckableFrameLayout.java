package com.vagabond.customcheckablelistview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * Created by debanjan on 4/12/16.
 */

public class CheckableFrameLayout extends FrameLayout implements Checkable {
    private boolean isChecked;
    public CheckableFrameLayout(Context context) {
        super(context);
    }

    public CheckableFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CheckableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setChecked(boolean b) {
        setEnabled(b);
        isChecked = b;
        traverseAndCheck(this, b);
    }

    @Override
    public boolean callOnClick() {
        return super.callOnClick();
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    private void traverseAndCheck(View v, boolean b){
        if(v instanceof ViewGroup){
            int count = ((ViewGroup)v).getChildCount();
            for(int i = 0; i< count; i++){
                View c = ((ViewGroup)v).getChildAt(i);
                if(c instanceof Checkable){
                    ((Checkable)c).setChecked(b);
                }
                else if (c instanceof ViewGroup) {
                    traverseAndCheck(c, b);
                }
            }
        }
        refreshDrawableState();
    }
    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        isChecked = !isChecked;
        setEnabled(isChecked);
        traverseAndToggle(this);
    }
    private void traverseAndToggle(View v) {
        if (v instanceof ViewGroup) {
            int count = ((ViewGroup)v).getChildCount();
            for (int i = 0; i < count; i++) {
                View c = ((ViewGroup)v).getChildAt(i);
                if (c instanceof Checkable) {
                    ((Checkable)c).toggle();
                }
                else if(c instanceof ViewGroup) {
                    traverseAndToggle(c);
                }
            }
        }
        refreshDrawableState();
    }

    @Override
    public void setActivated(boolean activated) {
        super.setActivated(activated);
    }
}