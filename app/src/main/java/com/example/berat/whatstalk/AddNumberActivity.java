package com.example.berat.whatstalk;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
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
<<<<<<< Updated upstream
import com.hbb20.CountryCodePicker;
=======
import com.google.firebase.messaging.FirebaseMessagingService;
>>>>>>> Stashed changes

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class AddNumberActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    CountryCodePicker ccp;
    EditText editTextCarrierNumber;
    String countryCode, countryName;

    //Initialize Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_number);

    }
<<<<<<< Updated upstream

    public void getCountryCode(){
    countryCode = ccp.getFullNumber();
    countryName = ccp.getSelectedCountryName();
    }


=======
>>>>>>> Stashed changes
    public void onClickBtn(View v)
    {   EditText name = (EditText) findViewById(R.id.name_to_add);
//        EditText number = (EditText) findViewById(R.id.number_to_add);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);

        String nameToSend = name.getText().toString();
<<<<<<< Updated upstream
//        String numberToSend = number.getText().toString();

        editTextCarrierNumber = (EditText) findViewById(R.id.number_to_add);
        String numberToSend = editTextCarrierNumber.getText().toString();

        ccp.registerCarrierNumberEditText(editTextCarrierNumber);

        getCountryCode();

        myRef.child("users").child(numberToSend).child("name").setValue(nameToSend);
        myRef.child("users").child(numberToSend).child("number").setValue(countryCode+numberToSend);
=======
        final String numberToSend = number.getText().toString();
        String device_id = Settings.Secure.getString(getContentResolver(),
            Settings.Secure.ANDROID_ID);

        myRef.child("users").child(device_id).child("name").setValue(nameToSend);
        myRef.child("users").child(device_id).child("number").setValue("90"+ numberToSend);
        myRef.child("users").child(device_id).child("is_online").setValue("false");
        //myRef.child("users").child(numberToSend).child("device_id").setValue(device_id);
>>>>>>> Stashed changes

        openDialog();

    }

    public void openDialog(){
        NumberAddedDialog numberAddedDialog = new NumberAddedDialog();
        numberAddedDialog.show(getSupportFragmentManager(), "number added dialog");
    }
}
