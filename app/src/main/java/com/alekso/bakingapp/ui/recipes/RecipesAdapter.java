package com.alekso.bakingapp.ui.recipes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alekso.bakingapp.R;
import com.alekso.bakingapp.model.Recipe;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    @NonNull
    private OnRecipeClickListener onRecipeClickListener;
    @NonNull
    private List<Recipe> items;

    public RecipesAdapter(@NonNull List<Recipe> items, @NonNull OnRecipeClickListener onRecipeClickListener) {
        this.items = items;
        this.onRecipeClickListener = onRecipeClickListener;
    }

    @NonNull
    @Override
    public RecipesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view, onRecipeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(items.get(position).name);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    interface OnRecipeClickListener {
        void onItemClick(int recipeId);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @NonNull
        private OnRecipeClickListener onRecipeClickListener;
        private TextView name;

        public ViewHolder(View itemView, @NonNull OnRecipeClickListener onRecipeClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onRecipeClickListener = onRecipeClickListener;
            name = itemView.findViewById(R.id.tv_name);
        }

        @Override
        public void onClick(View v) {
            onRecipeClickListener.onItemClick(items.get(getAdapterPosition()).id);
        }
    }
}
