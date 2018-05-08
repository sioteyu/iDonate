package com.jograt.atenatics.idonate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity{
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        GridViewAdapter adapter = new GridViewAdapter(ResultActivity.this, imageID, itemName);

        grid =(GridView) findViewById(R.id.gridView);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ResultActivity.this, "You Clicked at " +itemName[+ position], Toast.LENGTH_SHORT).show();

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
