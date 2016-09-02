package com.example.tan.socialbrothers;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tan on 2-9-2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private String[] champions = {"Anivia",
            "Blitzcrank",
            "Riven",
            "Jarvan",
            "Lee Sin",
            "Ahri",
            "Akali",
            "Volibear",
            "Zed",
            "Gragas"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details", "Item nine details", "Item ten details"};

    private int[] images = {R.drawable.anivia, R.drawable.blitzcrank, R.drawable.riven,
            R.drawable.jarvan, R.drawable.leesin, R.drawable.ahri, R.drawable.akali,
            R.drawable.volibear, R.drawable.zed, R.drawable.gragas
    };

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.person_photo);
            itemTitle = (TextView) itemView.findViewById(R.id.person_name);
            itemDetail =
                    (TextView) itemView.findViewById(R.id.person_age);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(champions[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return champions.length;
    }
}
