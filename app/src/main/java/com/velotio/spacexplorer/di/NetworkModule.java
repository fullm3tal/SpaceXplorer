package com.velotio.spacexplorer.di;

import com.velotio.spacexplorer.service.SpaceXService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
       return new Retrofit.Builder()
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.spacexdata.com").build();
    }

    @Singleton
    @Provides
    public SpaceXService provideSpaceXService(Retrofit retrofit){
        return  retrofit.create(SpaceXService.class);
    }

}
