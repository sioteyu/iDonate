package com.jograt.atenatics.idonate;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ResultFragment extends Fragment{
    private GridView grid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        grid =(GridView) view.findViewById(R.id.gridView);

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

        GridViewAdapter adapter = new GridViewAdapter(getActivity(), imageID, itemName);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +itemName[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }

    private Integer[] imageID = {
            R.drawable.placeholderimage, R.drawable.placeholderimage,
            R.drawable.placeholderimage, R.drawable.placeholderimage,
            R.drawable.placeholderimage, R.drawable.placeholderimage,
            R.drawable.placeholderimage, R.drawable.placeholderimage
    };

    private String[] itemName = {
            "itemName", "itemName",
            "itemName", "itemName",
            "itemName", "itemName",
            "itemName", "itemName"
    };
}
