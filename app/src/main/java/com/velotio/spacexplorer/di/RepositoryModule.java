package com.velotio.spacexplorer.di;


import com.velotio.spacexplorer.db.LaunchInfoDao;
import com.velotio.spacexplorer.launch_list.ILaunchListRepository;
import com.velotio.spacexplorer.launch_list.LaunchListRepositoryImpl;
import com.velotio.spacexplorer.service.SpaceXService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    public ILaunchListRepository providesLaunchListRepository(SpaceXService service, LaunchInfoDao dao) {
        return new LaunchListRepositoryImpl(service, dao);
    }

}
