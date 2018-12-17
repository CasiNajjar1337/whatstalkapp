package com.example.berat.whatstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
    }

    public void addNumber(View view) {
        Intent intent = new Intent(this, AddNumberActivity.class);
        startActivity(intent);
    }


}
