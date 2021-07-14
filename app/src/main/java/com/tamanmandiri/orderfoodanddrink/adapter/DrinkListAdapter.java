package com.tamanmandiri.orderfoodanddrink.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.model.DrinkModel;
import com.tamanmandiri.orderfoodanddrink.ui.main.DetailActivity;

import org.jetbrains.annotations.NotNull;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DrinkListAdapter extends RecyclerView.Adapter<DrinkListAdapter.ViewHolder> {

    private List<DrinkModel> drinkModelList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public DrinkListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_drink,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DrinkListAdapter.ViewHolder holder, int position) {
        DrinkModel drinkModel = drinkModelList.get(position);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        holder.bind(drinkModel,formatRupiah);
    }

    @Override
    public int getItemCount() {
        return drinkModelList.size();
    }

    public void setDrinkModelList (List<DrinkModel> drinkModelList) {
        this.drinkModelList = drinkModelList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgDrink;
        private final TextView tvName;
        private final TextView tvPrice;
        private final TextView tvDetail;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgDrink=itemView.findViewById(R.id.img_item_drink);
            tvName=itemView.findViewById(R.id.tv_item_name_drink);
            tvPrice=itemView.findViewById(R.id.tv_item_price_drink);
            tvDetail=itemView.findViewById(R.id.tv_item_detail_drink);
        }

        public void bind(DrinkModel drinkModel, NumberFormat formatRupiah) {
            Glide.with(itemView.getContext()).load(drinkModel.getAvatar()).apply(new RequestOptions().override(250, 250)).into(imgDrink);
            tvName.setText(drinkModel.getName());
            tvDetail.setText(drinkModel.getDetail());
            tvPrice.setText(formatRupiah.format(drinkModel.getPrice()));

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID_ORDER,drinkModel.getDrinkId());
                intent.putExtra(DetailActivity.EXTRA_AVATAR_ORDER,drinkModel.getAvatar());
                intent.putExtra(DetailActivity.EXTRA_NAME_ORDER,drinkModel.getName());
                intent.putExtra(DetailActivity.EXTRA_DETAIL_ORDER,drinkModel.getDetail());
                intent.putExtra(DetailActivity.EXTRA_PRICE_ORDER,drinkModel.getPrice());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
