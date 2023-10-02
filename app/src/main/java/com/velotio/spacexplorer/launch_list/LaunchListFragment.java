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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_launch_list
                , container, false
        );
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LaunchListViewModel.class);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.rvLaunchList.setLayoutManager(manager);
        mViewModel.fetchLaunchInfoFromServer();

        mViewModel.listLiveData.observe(getViewLifecycleOwner(), launchInfos -> {
            if (launchInfos.size() > 0) {
                adapter = new LaunchListAdapter(mViewModel, launchInfos);
                binding.rvLaunchList.setAdapter(adapter);
            }
        });

    }

}