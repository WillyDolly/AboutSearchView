package com.example.huuloc.aboutsearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
ListView LV;
    SearchView searchView;
    String[] team={"Manchester","chelsea","barcelona","Real Madrid","Valencia","Liverpool","Lazio"};
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LV = (ListView)findViewById(R.id.LV);
        searchView = (SearchView)findViewById(R.id.searchView);
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,team);
        LV.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);//outcome is words which have their initials matched the searched letter
                return false;
            }
        });
    }
}
