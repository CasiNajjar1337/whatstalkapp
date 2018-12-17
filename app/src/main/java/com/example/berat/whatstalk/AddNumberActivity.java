package com.example.berat.whatstalk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class AddNumberActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    //Initialize Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_number);

    }

    public void onClickBtn(View v)
    {   EditText name = (EditText) findViewById(R.id.name_to_add);
        EditText number = (EditText) findViewById(R.id.number_to_add);
        String nameToSend = name.getText().toString();
        String numberToSend = number.getText().toString();

        myRef.child("users").child(numberToSend).child("name").setValue(nameToSend);
        myRef.child("users").child(numberToSend).child("number").setValue(numberToSend);

        openDialog();


    }

    public void openDialog(){
        NumberAddedDialog numberAddedDialog = new NumberAddedDialog();
        numberAddedDialog.show(getSupportFragmentManager(), "number added dialog");
    }

}
