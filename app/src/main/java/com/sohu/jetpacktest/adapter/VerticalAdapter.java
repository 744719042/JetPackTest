package com.sohu.jetpacktest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sohu.jetpacktest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */

public class VerticalAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Movie> data = new ArrayList<Movie>() {
        {
            add(new Movie(R.drawable.rmdmy,"人民的名义", "中央军委后勤保障部金盾影视中心出品的检察反腐电视剧"));
            add(new Movie(R.drawable.qm,"法医秦明", "法医秦明与法医助理大宝、刑警队大队长林涛屡破要案的故事"));
            add(new Movie(R.drawable.bigbang,"生活大爆炸", "讲述的是四个宅男科学家和一个美女邻居发生的搞笑生活故事"));
        }
    };

    public VerticalAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Movie getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.movie_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.desc);
            viewHolder.portrait = (ImageView) convertView.findViewById(R.id.portrait);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), getItem(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        bindView(getItem(position), viewHolder);
        return convertView;
    }

    private void bindView(Movie item, ViewHolder viewHolder) {
        viewHolder.portrait.setImageResource(item.getPortrait());
        viewHolder.name.setText(item.getName());
        viewHolder.desc.setText(item.getDescription());
    }

    private static class ViewHolder {
        ImageView portrait;
        TextView name;
        TextView desc;
    }
}