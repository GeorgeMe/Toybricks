package com.yunyan.toybricks.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunyan.toybricks.R;
import com.yunyan.toybricks.entity.ToyBricksProduct;

import java.util.List;

/**
 * Created by saravana on 6/14/2015.
 */
public class ObjectGridAdapter extends RecyclerView.Adapter<ObjectHolder>
{

    List<ToyBricksProduct> contents;

    Context ctx;


    public ObjectGridAdapter(List<ToyBricksProduct> contents, Context ctx)
    {
        this.ctx = ctx;
        this.contents = contents;
    }

    @Override
    public ObjectHolder onCreateViewHolder(ViewGroup parent, final int viewType)
    {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.toybricks_grid_item_card, parent, false);
        return new ObjectHolder(view , new ObjectHolder.IMyViewHolderClicks()
        {
            @Override
            public void onPlay(View caller)
            {
                //Toast.makeText(ctx,contents.get((int)caller.getTag()).getTitle(),Toast.LENGTH_SHORT).show();
            }
        }){};

    }

    @Override
    public void onBindViewHolder(ObjectHolder holder, int position)
    {
        ToyBricksProduct song = contents.get(position);
        holder.bindSong(song,position);
    }



    @Override
    public int getItemCount()
    {
        return contents.size();
    }
}
