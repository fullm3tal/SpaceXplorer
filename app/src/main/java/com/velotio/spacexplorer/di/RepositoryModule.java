package com.velotio.spacexplorer.di;


import com.velotio.spacexplorer.launch_list.ILaunchListRepository;
import com.velotio.spacexplorer.launch_list.LaunchListRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    public ILaunchListRepository providesLaunchListRepository(SpaceXService service) {
        return new LaunchListRepositoryImpl(service);
    }

}
