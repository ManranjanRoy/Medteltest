package com.dca.medteltest.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dca.medteltest.R;
import com.dca.medteltest.model.UserModel;
import com.dca.medteltest.ui.UserinfoActivity;
import com.squareup.picasso.Picasso;


import java.util.List;

public class UserListAdaptor extends RecyclerView.Adapter<UserListAdaptor.ImageViewHolder> {
    private Context mContext;
    private List<UserModel> mUploads;


    public UserListAdaptor(Context mContext, List<UserModel> mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {

        final UserModel uploadCurrent = mUploads.get(position);
        holder.name.setText(uploadCurrent.getLogin());
        Picasso.with(mContext)
                .load(uploadCurrent.getAvatar_url())
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContext, UserinfoActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("name",uploadCurrent.getLogin());
                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public ImageViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);

        }


    }


}