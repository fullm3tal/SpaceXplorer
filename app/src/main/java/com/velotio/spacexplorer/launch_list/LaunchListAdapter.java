package com.velotio.spacexplorer.launch_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.velotio.spacexplorer.R;
import com.velotio.spacexplorer.databinding.ViewLaunchItemBinding;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.ArrayList;

public class LaunchListAdapter extends RecyclerView.Adapter<LaunchListAdapter.LaunchListViewHolder> {

    ArrayList<LaunchInfo> list;
    public LaunchListViewModel viewModel;

    public LaunchListAdapter(LaunchListViewModel viewModel, ArrayList<LaunchInfo> list) {
        this.viewModel = viewModel;
        this.list = list;
    }

    @NonNull
    @Override
    public LaunchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewLaunchItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_launch_item, parent, false);
        return new LaunchListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LaunchListViewHolder holder, int position) {
        LaunchInfo info = list.get(position);
        holder.bind(info, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LaunchListViewHolder extends RecyclerView.ViewHolder {

        public ViewLaunchItemBinding launchBinding;

        public LaunchListViewHolder(@NonNull ViewLaunchItemBinding binding) {
            super(binding.getRoot());
            launchBinding = binding;
        }

        public void bind(LaunchInfo launchInfo, int position) {
            if (launchInfo != null) {
                launchInfo.updateSpaceLaunchStatus();
            }

            launchBinding.setLaunchInfo(launchInfo);
            launchBinding.executePendingBindings();
            launchBinding.ivFavorite.setOnClickListener(v -> {
                viewModel.setLaunchFavorite(!launchInfo.getFavorite(), position);
            });
        }

    }
}

