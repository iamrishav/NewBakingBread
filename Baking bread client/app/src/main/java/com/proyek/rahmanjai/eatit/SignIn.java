package com.proyek.rahmanjai.eatit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

import io.paperdb.Paper;

public class SignIn extends Fragment {

    EditText edtPhone, edtPassword;
    Button btnSignIn;
    com.rey.material.widget.CheckBox ckbRemember;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in);
//
//        edtPassword = (MaterialEditText) view.findViewById(R.id.edtPassword);
//        edtPhone = (MaterialEditText) view.findViewById(R.id.edtPhone);
//        btnSignIn = (Button) view.findViewById(R.id.btnSignIn);
//        ckbRemember = view.findViewById(R.id.ckbRemember);
//
//
//        Paper.init(this);
//
//        // Init Firebase
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference table_user = database.getReference("user");
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (Common.isConnectedToInternet(getBaseContext())) {
//
//                    //Save user and password
//
//                    if(ckbRemember.isChecked()){
//                        Paper.book().write(Common.USER_KEY,edtPhone.getText().toString());
//                        Paper.book().write(Common.PWD_KEY,edtPassword.getText().toString());
//
//                    }
//
//
//                    final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
//                    mDialog.setMessage("Please wait...");
//                    mDialog.show();
//
//                    table_user.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//
//
//                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
//
//                                mDialog.dismiss();
//                                User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
//                                user.setPhone(edtPhone.getText().toString()); // set Phone
//                                if (user.getPassword().equals(edtPassword.getText().toString())) {
//                                    Toast.makeText(SignIn.this, "SignIn Successful !!!", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(SignIn.this, Main2Activity.class);
//                                    Common.currentUser = user;
//                                    startActivity(intent);
//                                    finish();
//                                } else {
//                                    Toast.makeText(SignIn.this, "Password wrong!!!", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                mDialog.dismiss();
//                                Toast.makeText(SignIn.this, "Your number is not registered !!!", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//
//                        }
//                    });
//                } else {
//                    Toast.makeText(SignIn.this, "\n" +
//                            "Please check your internet connection!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//        });
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_sign_in, container, false);
        edtPassword = view.findViewById(R.id.edtPassword);
        edtPhone =  view.findViewById(R.id.edtPhone);
        btnSignIn = (Button) view.findViewById(R.id.btnSignIn);


        Paper.init(view.getContext());

        // Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Common.isConnectedToInternet(view.getContext())) {

                    //Save user and password




                    final ProgressDialog mDialog = new ProgressDialog(getContext());
                    mDialog.setMessage("Please wait...");
                    mDialog.show();

                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {


                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                                mDialog.dismiss();
                                User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                                user.setPhone(edtPhone.getText().toString()); // set Phone
                                if (user.getPassword().equals(edtPassword.getText().toString())) {
                                    Toast.makeText(view.getContext(), "SignIn Successful !!!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getActivity(), Main2Activity.class);
                                    Common.currentUser = user;
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getContext(), "Password wrong!!!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                mDialog.dismiss();
                                Toast.makeText(getContext(), "Your number is not registered !!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                } else {
                    Toast.makeText(getContext(), "\n" +
                            "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        
        return view;
    }
}