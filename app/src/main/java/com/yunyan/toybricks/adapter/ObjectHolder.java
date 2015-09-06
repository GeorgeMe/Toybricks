package com.yunyan.toybricks.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.yunyan.toybricks.R;
import com.yunyan.toybricks.entity.ToyBricksProduct;


/**
 * Created by saravana on 6/14/2015.
 */
public  class ObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    ImageView imageView;
    public IMyViewHolderClicks mListener;

    View vi;

    ToyBricksProduct msong;

    public ObjectHolder(View itemView, IMyViewHolderClicks listener)
    {
        super(itemView);
        mListener = listener;

        vi = itemView;
        imageView = (ImageView) itemView.findViewById( R.id.toybricks_image);;

        itemView.setOnClickListener(this);

    }

    public void bindSong(ToyBricksProduct song,int pos)
    {
        msong = song;
        vi.setTag(pos);
        imageView.setImageResource(R.drawable.ic_launcher);
    }

    @Override
    public void onClick(View view)
    {
        mListener.onPlay(view);
    }

    public static interface IMyViewHolderClicks {
        public void onPlay(View caller);

    }

}
