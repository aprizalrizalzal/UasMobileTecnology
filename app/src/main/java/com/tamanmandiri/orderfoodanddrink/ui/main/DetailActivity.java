package com.tamanmandiri.orderfoodanddrink.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Dao;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.model.OrderModel;
import com.tamanmandiri.orderfoodanddrink.viewmodel.OrderViewModel;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID_ORDER = "order_id";
    public static final String EXTRA_AVATAR_ORDER = "avatar";
    public static final String EXTRA_NAME_ORDER = "name";
    public static final String EXTRA_DETAIL_ORDER = "detail";
    public static final String EXTRA_PRICE_ORDER = "price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() !=null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_NAME_ORDER));
        }

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        String orderId = getIntent().getStringExtra(EXTRA_ID_ORDER);
        int avatar = getIntent().getIntExtra(EXTRA_AVATAR_ORDER,0);
        String name = getIntent().getStringExtra(EXTRA_NAME_ORDER);
        int price = getIntent().getIntExtra(EXTRA_PRICE_ORDER,0);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL_ORDER);
        int amount = 1;

        ImageView imgAvatar = findViewById(R.id.img_avatar);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDetail = findViewById(R.id.tv_detail);
        TextView tvPrice = findViewById(R.id.tv_price);

        Glide.with(this).load(avatar).apply(new RequestOptions().override(500,500)).into(imgAvatar);

        tvName.setText(name);
        tvDetail.setText(detail);
        tvPrice.setText(formatRupiah.format(price));

        final Button btnAddCart = findViewById(R.id.btn_add_cart);
        btnAddCart.setOnClickListener(view -> {
            OrderModel orderModel;
            OrderViewModel orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

            orderModel = new OrderModel(orderId,avatar,name,price,amount);

            Toast.makeText(this, "Satu "+name+" telah ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
            orderViewModel.insert(orderModel);
        });

        final Button btnShare= findViewById(R.id.btn_share);
        btnShare.setOnClickListener(v -> {
            Toast.makeText(this,"Bagikan",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, name);
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text,name,formatRupiah.format(price)));
            startActivity(Intent.createChooser(intent, "Bagikan Melalui"));
        });
    }
}