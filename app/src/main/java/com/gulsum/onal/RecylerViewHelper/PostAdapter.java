package com.gulsum.onal.RecylerViewHelper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gulsum.onal.Helper.PostModel;
import com.gulsum.onal.Menu.ReadMore;
import com.gulsum.onal.R;

import java.util.ArrayList;

public class PostAdapter  extends RecyclerView.Adapter<PostViewHolder>{
    ArrayList<PostModel> model;
    Context context;

    public PostAdapter(ArrayList<PostModel> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, final int position)
    {
        holder.setMainText(model.get(position).getMainText());
        holder.setProfileImage(model.get(position).getProfileImage());
        holder.setTimeAgo(model.get(position).getTime());
        holder.setUserName(model.get(position).getSenderName());
        holder.setTitle(model.get(position).getTitle());
        holder.itemView.findViewById(R.id.readMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ReadMore.class);
                i.putExtra("post",model.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
