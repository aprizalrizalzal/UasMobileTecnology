package com.tamanmandiri.orderfoodanddrink.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.adapter.OrderListAdapter;
import com.tamanmandiri.orderfoodanddrink.model.OrderModel;
import com.tamanmandiri.orderfoodanddrink.viewmodel.OrderViewModel;

public class OrderActivity extends AppCompatActivity {


    private OrderViewModel orderViewModel;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        RecyclerView rvOrder = findViewById(R.id.rv_menu_order);
        rvOrder.setLayoutManager(new LinearLayoutManager(this));
        rvOrder.setHasFixedSize(true);

        OrderListAdapter adapter = new OrderListAdapter();
        rvOrder.setAdapter(adapter);

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.getAllOrder().observe(this, adapter::setOrderModelList);

        view = findViewById(android.R.id.content);

        adapter.setOnItemDeleteClickCallback(orderModel -> orderViewModel.delete(orderModel));
        adapter.setOnItemUpdateClickCallback((orderModel) -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView= inflater.inflate(R.layout.alert_label_editor, null);

            dialog.setView(dialogView);
            dialog.setTitle(orderModel.getName());

            EditText edtAmount = dialogView.findViewById(R.id.edt_amount_order);
            edtAmount.setText(String.valueOf(orderModel.getAmount()));

            dialog.setPositiveButton(R.string.save, (dialogSave, which) -> {
                String defaultAmount = "1";
                String amount =  edtAmount.getText().toString().trim();

                if (amount.isEmpty()){
                    edtAmount.setText(defaultAmount);
                    return;
                }
                orderViewModel.updateAmount(Integer.parseInt(amount),orderModel.getId());
            });

            dialog.setCancelable(true);
            dialog.create().show();
        });

        Button btnBuy = findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(v -> {

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem about = menu.findItem(R.id.menu_about);
//        MenuItem deleteAll = menu.findItem(R.id.menu_delete_all);
        about.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void setMode(int itemId) {
        if (itemId == R.id.menu_delete_all) {
            orderViewModel.deleteAllOrder();
            Snackbar.make(view,"Semua Data Pesanan sudah Terhapus", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}