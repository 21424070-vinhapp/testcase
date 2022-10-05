package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.my_interface.IClickItemComponentListener;

import java.util.List;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.componentViewHolder> {
    List<String> mListFile;
    IClickItemComponentListener mIClickItemComponentListener;

    public ComponentAdapter(List<String> mListFile, IClickItemComponentListener iClickItemComponentListener) {
        this.mListFile = mListFile;
        mIClickItemComponentListener=iClickItemComponentListener;
    }

    @NonNull
    @Override
    public componentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component,parent,false);
        return new componentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull componentViewHolder holder, int position) {
        String data=mListFile.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        if(mListFile.size()!=0)
        {
            return mListFile.size();
        }
        return 0;
    }

    class componentViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtView;
        public componentViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtView=itemView.findViewById(R.id.txtView);
        }

        public void bind(String data)
        {
            mTxtView.setText(data.split(".yml")[0]);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mIClickItemComponentListener!=null)
                    {
                        mIClickItemComponentListener.onClick(data);
                    }
                }
            });
        }
    }
}
