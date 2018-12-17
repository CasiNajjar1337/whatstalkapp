package com.example.berat.whatstalk;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class NumberAddedDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Tebrikler!")
                .setMessage("Tebrikler. Numarayı başarılı bir şekilde listeye eklediniz. Takip işlemi 2 saat içerisinde aktif olacak ve numara Whatsapp'ta online olduğunda bildirim almaya başlayacaksınız.")
                .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
