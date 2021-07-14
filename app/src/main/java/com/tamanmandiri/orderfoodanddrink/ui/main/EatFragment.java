package com.tamanmandiri.orderfoodanddrink.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.adapter.EatListAdapter;
import com.tamanmandiri.orderfoodanddrink.viewmodel.EatViewModel;

import org.jetbrains.annotations.NotNull;

public class EatFragment extends Fragment {

    public EatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        RecyclerView rvMenuEat;
        super.onViewCreated(view, savedInstanceState);

        rvMenuEat = view.findViewById(R.id.rv_menu_eat);
        rvMenuEat.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvMenuEat.setHasFixedSize(true);

        final EatListAdapter adapter = new EatListAdapter();
        rvMenuEat.setAdapter(adapter);

        EatViewModel eatViewModel = new ViewModelProvider(this).get(EatViewModel.class);
        eatViewModel.getAllEat().observe(this.requireActivity(), adapter::setEatModelList);

    }
}