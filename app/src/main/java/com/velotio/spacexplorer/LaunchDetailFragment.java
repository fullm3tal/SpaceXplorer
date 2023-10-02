package com.velotio.spacexplorer;

import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.velotio.spacexplorer.databinding.FragmentLaunchDetailBinding;
import com.velotio.spacexplorer.launch_list.LaunchListViewModel;

public class LaunchDetailFragment extends Fragment {

    private LaunchListViewModel mViewModel;

    FragmentLaunchDetailBinding binding;

    NavController navController;

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_launch_detail, container, false);
        return binding.getRoot();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        binding.toolbar.setNavigationOnClickListener(v -> navController.navigateUp());
        if (getActivity() != null) {
            mViewModel = new ViewModelProvider(getActivity()).get(LaunchListViewModel.class);
        }
        mViewModel.getTimer().getCountdownFlowable().subscribe(countdown -> {
            // Update UI or perform actions in the MainFragment
            binding.setCountDown(countdown);
        });
        binding.setLaunchInfo(mViewModel.getLaunchInfo());
        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.baseline_image).error(R.drawable.baseline_error);
        Glide.with(this).load(mViewModel.getLaunchInfo().getLinks().getMissionPatch()).apply(options).into(binding.ivMissionPatch);
        binding.btnWatch.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mViewModel.getLaunchInfo().getLinks().getVideoLink()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.google.android.youtube");
            startActivity(intent);
        });


    }

}