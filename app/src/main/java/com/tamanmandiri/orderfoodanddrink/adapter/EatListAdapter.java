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
import com.tamanmandiri.orderfoodanddrink.model.EatModel;
import com.tamanmandiri.orderfoodanddrink.ui.main.DetailActivity;

import org.jetbrains.annotations.NotNull;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EatListAdapter extends RecyclerView.Adapter<EatListAdapter.ViewHolder>{

    private List<EatModel> eatModelList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public EatListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_eat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EatListAdapter.ViewHolder holder, int position) {
        EatModel eatModel = eatModelList.get(position);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        holder.bind(eatModel,formatRupiah);
    }

    @Override
    public int getItemCount() {
        return eatModelList.size();
    }

    public void setEatModelList (List<EatModel> eatModelList) {
        this.eatModelList = eatModelList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgEat;
        private final TextView tvName;
        private final TextView tvPrice;
        private final TextView tvDetail;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgEat=itemView.findViewById(R.id.img_item_eat);
            tvName=itemView.findViewById(R.id.tv_item_name_eat);
            tvPrice=itemView.findViewById(R.id.tv_item_price_eat);
            tvDetail=itemView.findViewById(R.id.tv_item_detail_eat);
        }

        public void bind(EatModel eatModel, NumberFormat formatRupiah) {
            Glide.with(itemView.getContext()).load(eatModel.getAvatar()).apply(new RequestOptions().override(250, 250)).into(imgEat);
            tvName.setText(eatModel.getName());
            tvDetail.setText(eatModel.getDetail());
            tvPrice.setText(formatRupiah.format(eatModel.getPrice()));

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID_ORDER,eatModel.getEatId());
                intent.putExtra(DetailActivity.EXTRA_AVATAR_ORDER,eatModel.getAvatar());
                intent.putExtra(DetailActivity.EXTRA_NAME_ORDER,eatModel.getName());
                intent.putExtra(DetailActivity.EXTRA_DETAIL_ORDER,eatModel.getDetail());
                intent.putExtra(DetailActivity.EXTRA_PRICE_ORDER,eatModel.getPrice());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
