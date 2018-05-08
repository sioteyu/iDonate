package com.jograt.atenatics.idonate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] imageID;
    private String[] itemName;

    public GridViewAdapter(Context c, Integer[] imageID, String[] itemName) {
        mContext = c;
        this.imageID = imageID;
        this.itemName = itemName;
    }

    public int getCount() {
        return imageID.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.fragment_result_item, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.itemName);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.itemImage);
            textViewAndroid.setText(itemName[position]);
            imageViewAndroid.setImageResource(imageID[position]);
        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }


}
