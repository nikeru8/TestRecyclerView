package com.hello.kaiser.testrecyclerview;

/**
 * Created by kaiser on 2017/9/29.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class TestRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Cell> things = new ArrayList<>();

    private enum ITEM_TYPE {
        STYLE_01,
        STYLE_02
    }

    TestRecyclerView(List<Cell> things) {
        this.things = things;
    }

//    class TestHolder extends RecyclerView.ViewHolder {
//
//        public TestHolder(View itemView) {
//            super(itemView);
//        }
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE.STYLE_01.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_duck, parent, false);
            return new ViewHolder01(view);
        } else if (viewType == ITEM_TYPE.STYLE_02.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
            return new ViewHolder02(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder01) {
            ((ViewHolder01) holder).itemName.setText(things.get(position).getType());
        } else if (holder instanceof ViewHolder02) {
            ((ViewHolder02) holder).itemName.setText(things.get(position).getType());
        }

    }

    @Override
    public int getItemCount() {
        return things.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (things.get(position).getType() == "DUCK") {
            return ITEM_TYPE.STYLE_01.ordinal();
        } else { //CAR
            return ITEM_TYPE.STYLE_02.ordinal();
        }
    }

    private class ViewHolder01 extends RecyclerView.ViewHolder {
        private TextView itemName;

        ViewHolder01(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_duck);
        }
    }

    private class ViewHolder02 extends RecyclerView.ViewHolder {
        private TextView itemName;

        ViewHolder02(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_car);
        }
    }
}

