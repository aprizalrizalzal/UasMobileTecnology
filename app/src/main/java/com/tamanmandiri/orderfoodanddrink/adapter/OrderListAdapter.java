package com.tamanmandiri.orderfoodanddrink.adapter;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;
import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.model.OrderModel;

import org.jetbrains.annotations.NotNull;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder>{

    private List<OrderModel>orderModelList = new ArrayList<>();
    private OnItemUpdateClickCallback onItemUpdateClickCallback;
    private OnItemDeleteClickCallback onItemDeleteClickCallback;

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_order,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderListAdapter.ViewHolder holder, int position) {
        OrderModel orderModel = orderModelList.get(position);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        holder.bind(orderModel,formatRupiah);
        holder.imgBtnEdit.setOnClickListener(v -> onItemUpdateClickCallback.onItemUpdate(orderModelList.get(position)));

        int orderTotal = orderModel.getPrice() * orderModel.getAmount();
        holder.tvTotal.setText(formatRupiah.format(orderTotal));

        holder.itemView.setOnLongClickListener(v ->
        {
            AlertDialog builder = new AlertDialog.Builder(v.getContext())
                    .setTitle("Hapus")
                    .setMessage("Anda yakin ingin menghapus "+orderModel.getName())
                    .setNegativeButton(android.R.string.no, (dialog, which) -> Toast.makeText(v.getContext(), "Batal Menghapus "+orderModel.getName(), Toast.LENGTH_SHORT).show())
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        onItemDeleteClickCallback.onItemDelete(orderModelList.get(position));
                        Snackbar.make(v,orderModel.getName()+" Telah Terhapus", Snackbar.LENGTH_LONG)
                                .setAction("Action", null)
                                .show();
                    })
                    .create();
            builder.show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public void setOrderModelList(List<OrderModel> orderModelList) {
        this.orderModelList = orderModelList;
        notifyDataSetChanged();
    }

    public void setOnItemUpdateClickCallback(OnItemUpdateClickCallback onItemUpdateClickCallback) {
        this.onItemUpdateClickCallback = onItemUpdateClickCallback;
    }

    public void setOnItemDeleteClickCallback(OnItemDeleteClickCallback onItemDeleteClickCallback) {
        this.onItemDeleteClickCallback = onItemDeleteClickCallback;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgOrder;
        private final TextView tvName;
        private final TextView tvPrice;
        private final TextView tvAmount;
        private final ImageButton imgBtnEdit;
        private final TextView tvTotal;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgOrder=itemView.findViewById(R.id.img_item_order);
            tvName=itemView.findViewById(R.id.tv_item_name_order);
            tvPrice=itemView.findViewById(R.id.tv_item_price_order);
            tvAmount=itemView.findViewById(R.id.tv_item_amount_order);
            imgBtnEdit=itemView.findViewById(R.id.img_btn_edit);
            tvTotal=itemView.findViewById(R.id.tv_item_total_order);
        }

        public void bind(OrderModel orderModel, NumberFormat formatRupiah) {
            Glide.with(itemView.getContext()).load(orderModel.getAvatar()).apply(new RequestOptions().override(255, 255)).into(imgOrder);
            tvName.setText(orderModel.getName());
            tvPrice.setText(formatRupiah.format(orderModel.getPrice()));
            tvAmount.setText(String.valueOf(orderModel.getAmount()));
        }
    }
    public interface OnItemDeleteClickCallback {
        void onItemDelete(OrderModel orderModel);
    }

    public interface OnItemUpdateClickCallback {
        void onItemUpdate(OrderModel orderModel);
    }
}
