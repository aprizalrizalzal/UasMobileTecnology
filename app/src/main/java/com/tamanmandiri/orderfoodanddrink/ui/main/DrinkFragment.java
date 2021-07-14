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
import com.tamanmandiri.orderfoodanddrink.adapter.DrinkListAdapter;
import com.tamanmandiri.orderfoodanddrink.viewmodel.DrinkViewModel;

import org.jetbrains.annotations.NotNull;

public class DrinkFragment extends Fragment {

    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        RecyclerView rvMenuDrink;
        super.onViewCreated(view, savedInstanceState);

        rvMenuDrink = view.findViewById(R.id.rv_menu_drink);

        rvMenuDrink.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvMenuDrink.setHasFixedSize(true);

        final DrinkListAdapter adapter = new DrinkListAdapter();
        rvMenuDrink.setAdapter(adapter);

        DrinkViewModel drinkViewModel = new ViewModelProvider(this).get(DrinkViewModel.class);
        drinkViewModel.getAllDrink().observe(this.requireActivity(), adapter::setDrinkModelList);
    }
}