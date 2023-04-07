package com.geeks.notes;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> list = new ArrayList<>();

    public void setList(List<Note> list){
//        this.list = list;
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addNote(Note note){
        list.add(note);
        notifyDataSetChanged();
    }

    public Note getItem(int pos){
        return list.get(pos);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.desc.setText(list.get(position).getDesc());
        Glide.with(holder.itemView)
                .load(list.get(position).getImage())
                .transform(new CenterCrop(),new RoundedCorners(25))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.item_desc);
        }
    }
}
