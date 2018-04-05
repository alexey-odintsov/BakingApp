package com.alekso.bakingapp.ui.step;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alekso.bakingapp.R;
import com.alekso.bakingapp.model.Step;

import java.util.List;

public class RecipeStepsAdapter extends RecyclerView.Adapter<RecipeStepsAdapter.ViewHolder> {
    @NonNull
    private OnItemClickListener onItemClickListener;
    private int recipeId;
    @NonNull
    private List<Step> items;

    public RecipeStepsAdapter(int recipeId, @NonNull List<Step> items, @NonNull OnItemClickListener onItemClickListener) {
        this.recipeId = recipeId;
        this.items = items;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecipeStepsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_step, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(items.get(position).id + ".");
        holder.name.setText(items.get(position).shortDescription);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int recipeId, int stepId);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @NonNull
        private OnItemClickListener onItemClickListener;
        private TextView id;
        private TextView name;

        public ViewHolder(View itemView, @NonNull OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onItemClickListener = onItemClickListener;
            id = itemView.findViewById(R.id.tv_title);
            name = itemView.findViewById(R.id.tv_description);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(recipeId, items.get(getAdapterPosition()).id);
        }
    }
}
