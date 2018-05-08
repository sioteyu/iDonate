package com.jograt.atenatics.idonate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.jograt.atenatics.idonate.bean.ImageBean;

import java.util.ArrayList;

/**
 * Created by Greg on 08/05/2018.
 */

public class homeFragment extends Fragment {
    private RecyclerView mHorizontalRecyclerView, mHorizontalRecyclerView2;
    private HorizontalRecyclerViewAdapter horizontalAdapter;
    private LinearLayoutManager horizontalLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mHorizontalRecyclerView = (RecyclerView) view.findViewById(R.id.horizontalRecyclerView);
        mHorizontalRecyclerView2 = (RecyclerView) view.findViewById(R.id.horizontalRecyclerView2);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


        horizontalAdapter = new HorizontalRecyclerViewAdapter(fillWithData(), getContext());
        horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        mHorizontalRecyclerView.setAdapter(horizontalAdapter);

        horizontalAdapter = new HorizontalRecyclerViewAdapter(fillWithData(), getContext());
        horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView2.setLayoutManager(horizontalLayoutManager);
        mHorizontalRecyclerView2.setAdapter(horizontalAdapter);
    }

    public ArrayList<ImageBean> fillWithData() {
        ArrayList<ImageBean> imageModelArrayList = new ArrayList<>();
        ImageBean imageModel0 = new ImageBean();
        imageModel0.setId(1);
        imageModel0.setImageUrl("http://www.cetis.org/wp-content/uploads/wooden-furniture-300x300.jpg");
        imageModelArrayList.add(imageModel0);

        ImageBean imageModel1 = new ImageBean();
        imageModel1.setId(2);
        imageModel1.setImageUrl("https://www.justthewoods.com/wp-content/uploads/2017/04/poster-board-to-protect-furniture-300x300.jpg");
        imageModelArrayList.add(imageModel1);

        ImageBean imageModel2 = new ImageBean();
        imageModel2.setId(3);
        imageModel2.setImageUrl("https://i0.wp.com/athomewithashley.com/wp-content/uploads/2016/05/how-to-update-your-old-patio-furniture-4.jpg?resize=300%2C300&ssl=1");
        imageModelArrayList.add(imageModel2);

        ImageBean imageModel3 = new ImageBean();
        imageModel3.setId(3);
        imageModel3.setImageUrl("http://valdostatoday.com/wp-content/uploads/2015/04/IMG_3011-300x300.jpg");
        imageModelArrayList.add(imageModel3);

        ImageBean imageModel4 = new ImageBean();
        imageModel4.setId(3);
        imageModel4.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCQiO0KIQyYz9o51eq3nRRuc9sOhDIBKx0L4H0wBE6dDTSJvSr");
        imageModelArrayList.add(imageModel4);

        return imageModelArrayList;
    }
}
