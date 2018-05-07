package com.jograt.atenatics.idonate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;

    public GridViewAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setBackground(ContextCompat.getDrawable(mContext, mThumbIds[position]));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.MarginLayoutParams.MATCH_PARENT, 500);
        layoutParams.setMargins(150, 150, 150, 150);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.placeholderimage, R.drawable.placeholderimage,
            R.drawable.placeholderimage, R.drawable.placeholderimage,
            R.drawable.placeholderimage, R.drawable.placeholderimage,
            R.drawable.placeholderimage, R.drawable.placeholderimage
    };
}
