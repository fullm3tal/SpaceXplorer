package com.velotio.spacexplorer.launch_list;

import static org.mockito.Mockito.when;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;
import com.velotio.spacexplorer.launch_list.model.LaunchListResponse;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class LaunchListViewModelTest extends TestCase {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private ILaunchListRepository repository;

    @Mock
    private LaunchListViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        viewModel = new LaunchListViewModel(repository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fetchData_Success() {
        // Arrange
        MutableLiveData<LaunchListResponse> data = new MutableLiveData<>(new LaunchListResponse());
        ArrayList<LaunchInfo> list= new ArrayList<>();
        list.add(new LaunchInfo());
        LaunchListResponse response = new LaunchListResponse();
        response.loading = false;
        response.list = list;
        data.setValue(response);
        when(repository.fetchLaunchListFromServer()).thenReturn(data);
        viewModel.setLaunchList();
        // Act
        // Optional: Use LiveDataTestUtil or similar utility to get the LiveData value.
        LiveData<LaunchListResponse> value = viewModel.getLaunchInfo();
        assertEquals(response.list.size(), value.getValue().list.size());
    }

    @Test
    public void fetchData_Error() {
        // Arrange
        MutableLiveData<LaunchListResponse> data = new MutableLiveData<>(new LaunchListResponse());
        LaunchListResponse response = new LaunchListResponse();
        response.loading = false;
        response.error = "Something went wrong";
        data.setValue(response);
        when(repository.fetchLaunchListFromServer()).thenReturn(data);
        viewModel.setLaunchList();
        // Act
        // Optional: Use LiveDataTestUtil or similar utility to get the LiveData value.
        LiveData<LaunchListResponse> value = viewModel.getLaunchInfo();
        assertEquals(response.error, value.getValue().error);
    }

    @Test
    public void fetchData_Loading() {
        // Arrange
        MutableLiveData<LaunchListResponse> data = new MutableLiveData<>(new LaunchListResponse());
        when(repository.fetchLaunchListFromServer()).thenReturn(data);
        viewModel.setLaunchList();
        // Act
        // Optional: Use LiveDataTestUtil or similar utility to get the LiveData value.
        LiveData<LaunchListResponse> value = viewModel.getLaunchInfo();
        System.out.println("Value "+value.getValue().loading);
        assertEquals(data.getValue().loading, value.getValue().loading);
        LaunchListResponse response = new LaunchListResponse();
        response.loading = false;
        data.setValue(response);
        when(repository.fetchLaunchListFromServer()).thenReturn(data);
        viewModel.setLaunchList();
        value = viewModel.getLaunchInfo();
        System.out.println("Value "+value.getValue().loading);
        assertEquals(data.getValue().loading, value.getValue().loading);
    }

}