package com.denztri.postdudeclient.ui.history;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denztri.postdudeclient.R;
import com.denztri.postdudeclient.database.entity.RequestHistoryModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private final Context context;
    private List<RequestHistoryModel> historyModels;

    public HistoryAdapter(Context context){
        this.context = context;
    }

    public List<RequestHistoryModel> getHistoryModels() {
        return historyModels;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setHistoryModels(List<RequestHistoryModel> historyModels) {
        this.historyModels = historyModels;
        notifyDataSetChanged();
    }

    public void setHistoryModel(RequestHistoryModel historyModel){
        this.historyModels.add(historyModel);
        notifyItemChanged(-1);
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_history, parent,false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.url.setText(historyModels.get(position).getUrl());
        holder.method.setText(historyModels.get(position).getHttpMethod());
    }

    @Override
    public int getItemCount() {
        if (historyModels != null) return historyModels.size();
        return 0;
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder{
        TextView method;
        TextView url;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            method = itemView.findViewById(R.id.history_row_method);
            url = itemView.findViewById(R.id.history_row_url);
        }
    }
}
