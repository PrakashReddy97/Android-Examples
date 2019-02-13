package com.example.prakash.registrationform;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class showUsers extends Fragment {

    private TextView txtinfo;
    public showUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_show_users, container, false);

        txtinfo = view.findViewById(R.id.user_info);

        List<User> users = MainActivity.myDatabase.myDao().getUsers();
        String info ="";

        for(User user:users){
            String name = user.getName();
            String password = user.getPassword();
            String email = user.getEmailaddress();
            int id = user.getPhonenumber();

            info = info+"\n\n+Id is: "+id+"\n Name: "+name+"\n password: "+password+"\n email is: "+email;



        }

        txtinfo.setText(info);


        return view;





    }

}
