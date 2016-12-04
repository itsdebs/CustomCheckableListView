package com.vagabond.customcheckablelistview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vagabond.customcheckablelistview.databinding.ListItemBinding;

/**
 * Created by debanjan on 4/12/16.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }

    //for testing purpose
    private static final String[] TEST_DATA = {"one","two","three"};


    @Override
    public int getCount() {
        return TEST_DATA.length;
    }

    @Override
    public String getItem(int i) {
        return TEST_DATA[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ListItemBinding itemBinding;
        if(convertView == null){
            itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_item, viewGroup, false);
            convertView = itemBinding.getRoot();
            convertView.setTag(itemBinding);
        }
        else {
            itemBinding = (ListItemBinding) convertView.getTag();
        }
        itemBinding.cardNumber.setText(getItem(i));
        return convertView;
    }
}
