package com.brainacad.bacookrecipes.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Step;

import java.util.List;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder>{

    private List<Step> steps;

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_step_list, null);

        return new StepViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        Step step = steps.get(position);
        holder.stepsTxt.setText(step.getDescStep());
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    class StepViewHolder extends RecyclerView.ViewHolder{

        private TextView stepsTxt;

        public StepViewHolder(View itemView) {
            super(itemView);
            stepsTxt = itemView.findViewById(R.id.step_instruction);
        }
    }
}
