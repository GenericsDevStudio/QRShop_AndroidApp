package com.example.qrshop_androidapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.qrshop_androidapp.model.Product;
import com.example.qrshop_androidapp.network.Resources;

import java.util.List;

public class CartList extends RecyclerView.Adapter<CartList.ViewHolder> {

    // LIST

    private List<Product> productsToShow;
    private Context context;

    public CartList(List<Product> productsToShow, Context context) {
        this.productsToShow = productsToShow;
        this.context = context;
    }

    // IMPLEMENTED METHODS

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_cart, viewGroup, false);
        final ViewHolder view = new ViewHolder(v);

        // ON CLICK LISTENERS

        view.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources.removeFromCart(view.getAdapterPosition());
                viewGroup.removeViewAt(view.getAdapterPosition());
            }
        });

        view.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
            }
        });

        //

        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Product toShow = productsToShow.get(i);
        viewHolder.productNameTextView.setText(toShow.getName());
        viewHolder.productPriceTextView.setText(toShow.getPrice());
    }

    @Override
    public int getItemCount() {
        return productsToShow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //FIELDS

        private TextView productNameTextView;
        private TextView productPriceTextView;
        private ImageButton deleteButton;
        private ImageButton buyButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            buyButton = itemView.findViewById(R.id.buyButton);
        }
    }

}
