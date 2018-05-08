package com.jograt.atenatics.idonate;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.jograt.atenatics.idonate.bean.ImageBean;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MaterialSearchBar.OnSearchActionListener {
    private List<String> lastSearches;
    private MaterialSearchBar searchBar;
    private FragmentManager manager;

    private RecyclerView mHorizontalRecyclerView, mHorizontalRecyclerView2;
    private HorizontalRecyclerViewAdapter horizontalAdapter;
    private LinearLayoutManager horizontalLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setOnSearchActionListener(this);

        mHorizontalRecyclerView = (RecyclerView) findViewById(R.id.horizontalRecyclerView);
        mHorizontalRecyclerView2 = (RecyclerView) findViewById(R.id.horizontalRecyclerView2);

        horizontalAdapter = new HorizontalRecyclerViewAdapter(fillWithData(), getApplication());
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        mHorizontalRecyclerView.setAdapter(horizontalAdapter);

        horizontalAdapter = new HorizontalRecyclerViewAdapter(fillWithData(), getApplication());
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView2.setLayoutManager(horizontalLayoutManager);
        mHorizontalRecyclerView2.setAdapter(horizontalAdapter);

    }

    public ArrayList<ImageBean> fillWithData() {
        ArrayList<ImageBean> imageModelArrayList = new ArrayList<>();
        ImageBean imageModel0 = new ImageBean();
        imageModel0.setId(1);
        imageModel0.setImageUrl("https://i.ytimg.com/vi/SfLV8hD7zX4/maxresdefault.jpg");
        imageModelArrayList.add(imageModel0);

        ImageBean imageModel1 = new ImageBean();
        imageModel1.setId(2);
        imageModel1.setImageUrl("https://www.petmd.com/sites/default/files/petmd-cat-happy-13.jpg");
        imageModelArrayList.add(imageModel1);

        ImageBean imageModel2 = new ImageBean();
        imageModel2.setId(3);
        imageModel2.setImageUrl("https://i.ytimg.com/vi/SfLV8hD7zX4/maxresdefault.jpg");
        imageModelArrayList.add(imageModel2);

        ImageBean imageModel3 = new ImageBean();
        imageModel3.setId(3);
        imageModel3.setImageUrl("https://i.ytimg.com/vi/SfLV8hD7zX4/maxresdefault.jpg");
        imageModelArrayList.add(imageModel3);

        ImageBean imageModel4 = new ImageBean();
        imageModel4.setId(3);
        imageModel4.setImageUrl("https://i.ytimg.com/vi/SfLV8hD7zX4/maxresdefault.jpg");
        imageModelArrayList.add(imageModel4);

        return imageModelArrayList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_donate) {
            DonateFrgament fragment = new DonateFrgament();
            manager.beginTransaction().replace(R.id.include, fragment).addToBackStack(null).commit();
        } else if (id == R.id.nav_profile) {
            ProfileFragment fragment = new ProfileFragment();
            manager.beginTransaction().replace(R.id.include, fragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_rewards) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, LoginActivity.class ));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {

    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }

    @Override
    public void onButtonClicked(int buttonCode) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        switch (buttonCode){
            case MaterialSearchBar.BUTTON_NAVIGATION:
                drawer.openDrawer(Gravity.LEFT);
                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                break;
            case MaterialSearchBar.BUTTON_BACK:
                searchBar.disableSearch();
                break;
        }
    }
}
