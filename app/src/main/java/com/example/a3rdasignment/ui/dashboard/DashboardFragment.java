package com.example.a3rdasignment.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.a3rdasignment.Model.Student;
import com.example.a3rdasignment.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {

    private DashboardViewModel dashboardViewModel;
    EditText editn, editage,editaddress;
    RadioGroup radioGroup;
    String name,gender, age, address;

    int image;

    Button submit;

    public static List<Student> studentlist = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        editn    =root.findViewById(R.id.editTextName);
        editage   = root.findViewById(R.id.editAge);

        editaddress    = root.findViewById(R.id.editTextaddress);
        radioGroup      = root.findViewById(R.id.gender_radio_group);

        submit       = root.findViewById(R.id.SaveButton);
        radioGroup.setOnCheckedChangeListener(this);

        submit.setOnClickListener(this);
        return root;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.Rmale){
            gender = "Male";
            image= R.drawable.male;


        }

        if(checkedId == R.id.Rfemale){
            gender = "Female";
            image=R.drawable.female;

        }

        if(checkedId == R.id.Rother){
            gender = "Other";
            image=R.drawable.male;
        }
    }

    @Override
    public void onClick(View v) {
        name = editn.getText().toString();
        age = editage.getText().toString();

        address = editaddress.getText().toString();



        if (v.getId() == R.id.SaveButton) {

            if (validate()) {


                studentlist.add(new Student(name, age, gender, address,image));
                Toast.makeText(getActivity(),"Save", Toast.LENGTH_SHORT).show();


            }

        }
    }
    private boolean validate(){
        if (TextUtils.isEmpty(name)) {
            editn.setError("Please Enter Full Name");
            editn.requestFocus();
            return false;

        }
        if (TextUtils.isEmpty(age)) {
            editage.setError("Please Enter Age");
            editage.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(address)) {
            editaddress.setError("Please Enter Address");
            editaddress.requestFocus();
            return false;
        }

        return true;
    }


}
