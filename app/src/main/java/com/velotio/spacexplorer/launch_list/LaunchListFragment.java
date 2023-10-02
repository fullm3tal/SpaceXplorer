package com.velotio.spacexplorer.launch_list;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
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

    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_launch_list, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity() != null) {
            mViewModel = new ViewModelProvider(getActivity()).get(LaunchListViewModel.class);
        }
        navController = NavHostFragment.findNavController(this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.rvLaunchList.setLayoutManager(manager);
        adapter = new LaunchListAdapter(mViewModel);
        binding.rvLaunchList.setAdapter(adapter);

        binding.swipeRefresh.setOnRefreshListener(() -> mViewModel.setLaunchList());

        mViewModel.getSpaceLaunchInfo().observe(getViewLifecycleOwner(), launchListResponse -> {
            if (launchListResponse.loading) {
                binding.rvLaunchList.setVisibility(View.INVISIBLE);
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.includeErrorLayout.clErrorLayout.setVisibility(View.INVISIBLE);
            }
            if (!launchListResponse.loading) {
                if (launchListResponse.list != null && launchListResponse.list.size() > 0) {
                    adapter.updateLaunchInfos(launchListResponse.list);
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

        mViewModel.navigateLiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    navController.navigate(R.id.action_launchListFragment_to_launchDetailFragment);
                }
            }
        });

    }

}