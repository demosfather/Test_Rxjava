package com.nby.test_rxjava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nby.test_rxjava.entity.Fruit;
import com.nby.test_rxjava.entity.News;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/7/20.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    List<Fruit> fruits;
    Context context;

    public FruitAdapter(List<Fruit> fruits, Context context) {
        this.fruits = fruits;
        this.context=context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_test)
        ImageView ivTest;
        @BindView(R.id.tv_test)
        TextView tvTest;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ivTest = (ImageView) itemView.findViewById(R.id.iv_test);
            tvTest = (TextView) itemView.findViewById(R.id.tv_test);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.ivTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "想看什么图", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context,SecondActivity.class));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.ivTest.setImageResource(fruit.getImage());
        holder.tvTest.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

}
