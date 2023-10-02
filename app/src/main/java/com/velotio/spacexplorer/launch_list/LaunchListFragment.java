package com.velotio.spacexplorer.launch_list;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.velotio.spacexplorer.R;
import com.velotio.spacexplorer.databinding.FragmentLaunchListBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LaunchListFragment extends Fragment {
    private LaunchListViewModel mViewModel;
    LaunchListAdapter adapter;
    FragmentLaunchListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_launch_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LaunchListViewModel.class);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.rvLaunchList.setLayoutManager(manager);
        binding.swipeRefresh.setOnRefreshListener(() -> mViewModel.setLaunchList());

        mViewModel.getLaunchInfo().observe(getViewLifecycleOwner(), launchListResponse -> {
            if (launchListResponse.loading) {
                binding.rvLaunchList.setVisibility(View.INVISIBLE);
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.includeErrorLayout.clErrorLayout.setVisibility(View.INVISIBLE);
            }
            if (!launchListResponse.loading) {
                if (launchListResponse.list != null && launchListResponse.list.size() > 0) {
                    adapter = new LaunchListAdapter(mViewModel, launchListResponse.list);
                    binding.rvLaunchList.setAdapter(adapter);
                    binding.rvLaunchList.setVisibility(View.VISIBLE);
                    binding.progressBar.setVisibility(View.INVISIBLE);
                    binding.includeErrorLayout.clErrorLayout.setVisibility(View.INVISIBLE);
                    binding.swipeRefresh.setRefreshing(false);
                }
                if (launchListResponse.error != null && !launchListResponse.error.isEmpty()) {
                    binding.rvLaunchList.setVisibility(View.INVISIBLE);
                    binding.progressBar.setVisibility(View.INVISIBLE);
                    binding.includeErrorLayout.clErrorLayout.setVisibility(View.VISIBLE);
                    binding.includeErrorLayout.tvErrorMessage.setText(launchListResponse.error);
                    binding.swipeRefresh.setRefreshing(false);
                }
            }
        });

        mViewModel.favoriteLiveData.observe(getViewLifecycleOwner(), position -> {
            if (position != null) {
                adapter.notifyItemChanged(position);
            }
        });

    }

}