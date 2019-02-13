package com.example.prakash.registrationform;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class addUser extends Fragment {

    public EditText UserName,UserPassword,UserEmail,UserMobile;
    public Button register;



    public addUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_user, container, false);

        UserName = view.findViewById(R.id.user_name);
        UserPassword = view.findViewById(R.id.user_pass);
        UserEmail = view.findViewById(R.id.user_mail);
        UserMobile = view.findViewById(R.id.user_no);

        register = view.findViewById(R.id.savebtn);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = UserName.getText().toString();
                String userpassword = UserPassword.getText().toString();

                String useremail = UserEmail.getText().toString();

                int usermobile = Integer.parseInt(UserMobile.getText().toString());




                    User user = new User();

                    user.setName(username);
                    user.setPassword(userpassword);
                    user.setEmailaddress(useremail);

                    user.setPhonenumber(usermobile);

                    MainActivity.myDatabase.myDao().adduser(user);


                    Toast.makeText(getActivity(), "Signed Up successfully", Toast.LENGTH_SHORT).show();

                    /*UserName.setText(null);
                    UserPassword.setText(null);
                    UserEmail.setText(null);
                    UserMobile.setText(null);*/

                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new showUsers()).addToBackStack(null).commit();







            }
        });

        return view;



    }

   /* boolean checkDataEntered(){

        if(TextUtils.isEmpty(UserName.getText().toString())) {
            Toast.makeText(getActivity(), "Enter a Username to register", Toast.LENGTH_SHORT).show();
            return false;

        }

        if(TextUtils.isEmpty(UserPassword.getText().toString())){
            Toast.makeText(getActivity(),"Enter a password to register",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(UserPassword.getText().toString().length()<=3){
            Toast.makeText(getActivity(),"choose a password with size greater than 3",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(TextUtils.isEmpty(UserEmail.getText().toString()) || !(Patterns.EMAIL_ADDRESS.matcher(UserEmail.getText().toString()).matches())){
            Toast.makeText(getActivity(),"Enter a valid email",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }*/

}
