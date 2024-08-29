package com.example.datafromfirebase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ContentInfoCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<DataModel> modelArrayList;
    Context context;

    public MyAdapter(ArrayList<DataModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.info, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText((position+1)+". "+modelArrayList.get(position).getName());
        holder.language.setText(modelArrayList.get(position).getLanguage());
        holder.bio.setText(modelArrayList.get(position).getBio());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", modelArrayList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("language", modelArrayList.get(holder.getAdapterPosition()).getLanguage());
                intent.putExtra("bio", modelArrayList.get(holder.getAdapterPosition()).getBio());
                intent.putExtra("version", modelArrayList.get(holder.getAdapterPosition()).getVersion());
                intent.putExtra("id", modelArrayList.get(holder.getAdapterPosition()).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, language, bio;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            language = itemView.findViewById(R.id.language);
            bio = itemView.findViewById(R.id.bio);
        }
    }
}
