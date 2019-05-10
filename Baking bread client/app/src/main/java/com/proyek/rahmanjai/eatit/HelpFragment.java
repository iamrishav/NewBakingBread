package com.proyek.rahmanjai.eatit;
// Lily: Finished all design for this fragment.

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HelpFragment extends AppCompatActivity {
    Button mButtonConfirm;
    EditText mEditSubject, mEditContent;

    public HelpFragment() {
        // Required empty public constructor
    }





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_help);
        mEditContent = (EditText) findViewById(R.id.help_email_subject);
        mEditSubject = (EditText) findViewById(R.id.help_email_content);
        mButtonConfirm = (Button) findViewById(R.id.help_email_send);
        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void sendEmail() {
        String subject = mEditSubject.getText().toString();
        String message = mEditContent.getText().toString();
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "rishav673@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        try {
            startActivity(Intent.createChooser(email, "Send mail..."));
            Log.i("Finished", "");
            mEditContent.setText("");
            mEditSubject.setText("");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

}
