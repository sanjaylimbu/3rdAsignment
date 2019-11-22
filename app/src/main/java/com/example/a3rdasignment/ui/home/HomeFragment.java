package com.example.a3rdasignment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3rdasignment.R;
import com.example.a3rdasignment.Stu_Adapter;
import com.example.a3rdasignment.ui.dashboard.DashboardFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recycler = root.findViewById(R.id.recycler);


        Stu_Adapter adapter = new Stu_Adapter(getActivity(), DashboardFragment.studentlist);
        recycler.setAdapter(adapter);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }


}