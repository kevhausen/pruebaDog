package com.prueba.pruebadog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prueba.pruebadog.R;

import java.util.ArrayList;
import java.util.List;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.ListHolder>{

    private List<String> mBreedList= new ArrayList<String>();
    private Context mContext;

    public DogListAdapter(List<String> mBreedList, Context mContext) {
        this.mBreedList = mBreedList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        holder.singleTextBreed.setText(mBreedList.get(position)); //aca se asigna cada valor que se va recibiendo en la lista a nuestro texto que esta en el xml list_adapter

    }

    @Override
    public int getItemCount() {
        return mBreedList.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{
        private TextView singleTextBreed;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            singleTextBreed=itemView.findViewById(R.id.singleListAdapterXML);
        }
    }
}
