package com.bx.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by eduardomedina on 26/01/17.
 */
public class MultipleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Object> objects;

    private final int MOVIE = 0, PLACE = 1;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.objects.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        public MovieViewHolder(View itemView) {
            super(itemView);
        }
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder{

        public PlaceViewHolder(View itemView) {
            super(itemView);
        }
    }
}
