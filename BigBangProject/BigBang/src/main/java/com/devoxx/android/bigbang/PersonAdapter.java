package com.devoxx.android.bigbang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.devoxx.android.bigbang.dummy.DummyData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter between the BigBang characters and a listview.
 */
public class PersonAdapter extends ArrayAdapter<DummyData.BigBangCharacter> {

    private final Context context;
    private final List<DummyData.BigBangCharacter> persons;

    public PersonAdapter(Context context, List<DummyData.BigBangCharacter> persons) {
        super(context, R.layout.list_item, persons);
        this.context = context;
        this.persons = persons;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.list_item_photo);
            holder.label = (TextView) convertView.findViewById(R.id.list_item_label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DummyData.BigBangCharacter person = getItem(position);

        holder.label.setText(person.toString());

        Picasso.with(context).load(person.imageResource).into(holder.image);
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView label;
    }
}
