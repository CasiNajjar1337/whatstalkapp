package com.example.berat.whatstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    private FancyButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = (FancyButton) findViewById(R.id.btn_add_floating);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();


            ListItem listItem = new ListItem(
                    "berat",
                    "905416222987",
                    "3 dk 25 sn",
                    "15:15",
                    "15:29"
            );
            listItems.add(listItem);

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddNumberActivity.class));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_settings){
            Toast.makeText(this,"Settings Tıklandı", Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.action_privacy){
            startActivity(new Intent(HomeActivity.this, PrivacyPolicyActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    //    public void addNumber(View view) {
//        Intent intent = new Intent(this, AddNumberActivity.class);
//        startActivity(intent);
}