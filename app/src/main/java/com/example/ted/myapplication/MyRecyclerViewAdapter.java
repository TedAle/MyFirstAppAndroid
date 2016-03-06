package com.example.ted.myapplication;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static final String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<DataObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView detail;
        ImageView icon;
        ImageView favorite;
        Boolean fav;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            detail = (TextView) itemView.findViewById(R.id.tv_detail);
            fav = Boolean.FALSE;
            favorite = (ImageView) itemView.findViewById(R.id.img_fav);
            icon = (ImageView) itemView.findViewById(R.id.img_icon);
            icon.setClickable(Boolean.TRUE);
            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = Integer.parseInt((String) v.getTag());
                    if (DataObjectContainer.getDatas().get(pos).getFavorite()) {
                        ((ImageView) v).setImageDrawable(v.getResources().getDrawable(android.R.drawable.star_off));
                        DataObjectContainer.getDatas().get(pos).setFavorite(Boolean.FALSE);
                    } else {
                        ((ImageView) v).setImageDrawable(v.getResources().getDrawable(android.R.drawable.star_on));
                        DataObjectContainer.getDatas().get(pos).setFavorite(Boolean.TRUE);
                    }
                }
            });
//            favorite = (ImageButton) itemView.findViewById(R.id.btn_favorite);

//            favorite.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (v instanceof ImageButton) {
//                        String already_fav = (String)((ImageButton)v).getTag();
//                        if (already_fav.equals("already_fav")) {
////                            fav = Boolean.FALSE;
//                            ((ImageButton)v).setImageDrawable(v.getContext().getResources().getDrawable(android.R.drawable.star_big_off));
//                            ((ImageButton)v).setTag("not_fav");
//                            Log.d(LOG_TAG, "FAVORITE FALSE");
//                        } else {
////                            fav = Boolean.TRUE;
//                            ((ImageButton)v).setImageDrawable(v.getContext().getResources().getDrawable(android.R.drawable.star_big_on));
//                            ((ImageButton)v).setTag("already_fav");
//                            Log.d(LOG_TAG, "FAVORITE TRUE");
//                        }
//                    }
//                }
//            });


            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        if (position >= 0 && mDataset != null && mDataset.get(position) != null) {
            holder.name.setText(mDataset.get(position).getName());
            holder.detail.setText(mDataset.get(position).getDetail());
            holder.fav = (mDataset.get(position).getFavorite());
            holder.favorite.setTag("" + position);

            if (DataObjectContainer.getDatas().get(position).getFavorite()) {
                holder.favorite.setImageDrawable(holder.icon.getResources().getDrawable(android.R.drawable.star_on));
            } else {
                holder.favorite.setImageDrawable(holder.icon.getResources().getDrawable(android.R.drawable.star_off));
            }
            Log.d(LOG_TAG, "NAME: " + holder.name.getText() + " DETAIL: " + holder.detail.getText() + " FAV: " + holder.fav + " POSITION: " + position);
            //holder.icon.setSRC(mDataset.get(position).getIcon());
            //TODO
            /*
            if (mDataset.get(position).getFavorite()!=null){
				mDataset.get(position).getFavorite() ? holder.favorite.setBackground(mDataset.get(position).getFavorite()) : holder.favorite.setBackground(mDataset.get(position).getFavorite()) ;
			}
			*/
        }
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}