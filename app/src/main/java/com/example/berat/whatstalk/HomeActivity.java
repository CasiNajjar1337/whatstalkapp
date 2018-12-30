package com.example.berat.whatstalk;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

public class HomeActivity extends AppCompatActivity {

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    private FancyButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        String device_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("numbers/"+device_id+"/number");

        //myRef.setValue("Hello, World!");


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
                boolean isConnected = isNetworkAvailable();

                if(isConnected == false){
                    openDialog();
                }

                else{

                    // Read from the database
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            boolean childNumberExists = dataSnapshot.exists();
                            Log.d("value_tag", "Value is: " + childNumberExists);

                            if(childNumberExists){
                                startActivity(new Intent(HomeActivity.this, RegisteredNumberActivity.class));

                            }

                            else{
                                startActivity(new Intent(HomeActivity.this, AddNumberActivity.class));

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            //Log.w("value_tag", "Failed to read value.", error.toException());
                        }
                    });







                    //startActivity(new Intent(HomeActivity.this, AddNumberActivity.class));
                }
            }
        });
    }

    public void openDialog(){
        NoConnectionDialog noConnectionDialog = new NoConnectionDialog();
        noConnectionDialog.show(getSupportFragmentManager(), "no connection dialog");
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