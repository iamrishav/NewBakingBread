package com.proyek.rahmanjai.eatitserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.proyek.rahmanjai.eatitserver.Common.Common;
import com.proyek.rahmanjai.eatitserver.Model.User;

import io.paperdb.Paper;

public class SignIn extends Fragment {

    EditText edtPhone, edtPassword;
    Button btnSignIn;

    FirebaseDatabase db;
    DatabaseReference users;
    TextView toSignUp;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in);
//
//        edtPassword = view.findViewById(R.id.edtPassword);
//        edtPhone = view.findViewById(R.id.edtPhone);
//        btnSignIn = view.findViewById(R.id.btnSignIn);
//
//
//
//        // Init Firebase
//        db = FirebaseDatabase.getInstance();
//        users = db.getReference("user");
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                signInUser(edtPhone.getText().toString(), edtPassword.getText().toString());
//            }
//        });
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void signInUser(String phone, String password) {
        final ProgressDialog mDialog = new ProgressDialog(getContext());
        mDialog.setMessage("Please wait...");
        mDialog.show();

        final String localPhone = phone;
        final String localPassword = password;
        users.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(edtPhone.getText().toString()).exists())
                {
                    mDialog.dismiss();
                    User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                    user.setPhone(edtPhone.getText().toString());
                    if (Boolean.parseBoolean(user.getIsStaff())) // If isStaff == true
                    {
                        if (user.getPassword().equals(localPassword))
                        {
                            //Login Ok
                            Toast.makeText(getContext(), "Login Successfully!", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(getActivity(), Home.class);
                            login.putExtra("localPhone",localPhone);
                            Common.currentUser = user;
                            startActivity(login);
                        }
                        else
                            Toast.makeText(getContext(), "Password wrong !", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getContext(), "\n" +
                                "Please login with a staff account", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mDialog.dismiss();
                    Toast.makeText(getContext(), "User not registered!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_sign_in, container, false);
        edtPassword = view.findViewById(R.id.edtPassword);
        edtPhone = view.findViewById(R.id.edtPhone);
        btnSignIn = view.findViewById(R.id.btnSignIn);



        // Init Firebase
        db = FirebaseDatabase.getInstance();
        users = db.getReference("user");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {



                signInUser(edtPhone.getText().toString(), edtPassword.getText().toString());
            }
        });
        return view;

    }
}
