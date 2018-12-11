package com.sohu.jetpacktest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.room.entity.MovieEntity;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    ImageView portrait;
    TextView name;
    TextView desc;

    public MovieViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.desc);
        portrait = itemView.findViewById(R.id.portrait);
    }

    public void bindView(MovieEntity item) {
        portrait.setImageResource(item.getPortrait());
        name.setText(item.getName());
        desc.setText(item.getDescription());
    }
}
