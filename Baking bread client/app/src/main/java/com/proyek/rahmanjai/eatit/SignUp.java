package com.proyek.rahmanjai.eatit;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.proyek.rahmanjai.eatit.Common.Common;
import com.proyek.rahmanjai.eatit.Model.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends Fragment {

    EditText edtPhone, edtName, edtPassword;
    Button btnSignUp;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        edtName = view.findViewById(R.id.edtName);
//        edtPassword = view.findViewById(R.id.edtPassword);
//        edtPhone =  view.findViewById(R.id.edtPhone);
//
//        btnSignUp = view.findViewById(R.id.btnSignUp);
//
//        // Init Firebase
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference table_user = database.getReference("user");
//
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Common.isConnectedToInternet(getBaseContext())) {
//                    final ProgressDialog mDialog = new ProgressDialog(getContext());
//                    mDialog.setMessage("\n" +
//                            "Please wait...");
//                    mDialog.show();
//
//                    table_user.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//
//                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
//                                mDialog.dismiss();
//                                Toast.makeText(getContext(), "Phone Number Registered !!", Toast.LENGTH_SHORT);
//                            } else {
//                                mDialog.dismiss();
//                                User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
//                                table_user.child(edtPhone.getText().toString()).setValue(user);
//                                Toast.makeText(getContext(), "Signup Successful !!", Toast.LENGTH_SHORT);
//                                finish();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//
//                        }
//                    });
//                }else {
//                    Toast.makeText(getContext(), "Please check your internet connection!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_sign_up, container, false);

        edtName = view.findViewById(R.id.edtName);
        edtPassword = view.findViewById(R.id.edtPassword);
        edtPhone =  view.findViewById(R.id.edtPhone);

        btnSignUp = view.findViewById(R.id.btnSignUp);

        // Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isConnectedToInternet(getContext())) {
                    final ProgressDialog mDialog = new ProgressDialog(getContext());
                    mDialog.setMessage("\n" +
                            "Please wait...");
                    mDialog.show();

                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

//                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
//                                mDialog.dismiss();
//                                Toast.makeText(getContext(), "Phone Number Registered !!", Toast.LENGTH_SHORT);
//                            } else {
                                mDialog.dismiss();
                                User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
                                table_user.child(edtPhone.getText().toString()).setValue(user);

                                Toast.makeText(getContext(), "Signup Successful !!", Toast.LENGTH_SHORT);
                                
//                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }else {
                    Toast.makeText(getContext(), "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
        
    }
}
