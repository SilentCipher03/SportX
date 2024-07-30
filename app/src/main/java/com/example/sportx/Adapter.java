package com.example.sportx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.SportsViewHolder> {

    private List<SportX> sportList;

    public ItemClickListener clickListener;


    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }

    public Adapter(List<SportX> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item_layout,parent,false);


        return new SportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        SportX sport = sportList.get(position);

        holder.textView.setText(sport.sportName);
        holder.imageView.setImageResource(sport.sportImg);

    }

    @Override
    public int getItemCount() {

        return sportList.size();
    }


    public class SportsViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView textView;
        ImageView imageView;



        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(clickListener != null){
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }


}
