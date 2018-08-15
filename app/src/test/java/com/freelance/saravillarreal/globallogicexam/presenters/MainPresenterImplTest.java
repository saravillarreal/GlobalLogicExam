package com.freelance.saravillarreal.globallogicexam.presenters;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainInteractorInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainOnListener;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainViewInterface;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.List;




import static org.mockito.Mockito.verify;

public class MainPresenterImplTest {

    private static List<MockGlobal> mockGlobals = Lists.newArrayList(new MockGlobal("Title1", "Description1", ""),
            new MockGlobal("Title2", "Description2", ""));

    private MainPresenterImpl mMainPresenter;

    @Mock
    private MainInteractorInterface mMainInteractor;

    @Mock
    private MainViewInterface mMainActivityView;

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
    @Captor
    private ArgumentCaptor<MainOnListener> mLoadListCallbackCaptor;


    @Before
    public void setupMainPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);// required for the "@Mock" annotations

        // Make presenter a mock while using mock repository and viewContract created above
        mMainPresenter = Mockito.spy(new MainPresenterImpl(mMainInteractor, mMainActivityView));
    }

    @Test
    public void callList() {

        // When started app call List
        mMainPresenter.callList();

        // Callback is captured and invoked with list
        verify(mMainInteractor).callListService(mLoadListCallbackCaptor.capture());
        mLoadListCallbackCaptor.getValue().resultList(mockGlobals);

        // Then view shown items in UI
        Mockito.verify(mMainActivityView).showItem(mockGlobals);

    }

    @Test
    public void callListNullResult() {

        // When started app call List
        mMainPresenter.callList();

        // Callback is captured and invoked with list
        verify(mMainInteractor).callListService(mLoadListCallbackCaptor.capture());
        mLoadListCallbackCaptor.getValue().resultList(null);

        // Then view shown items in UI
        Mockito.verify(mMainActivityView).showItem(null);

    }





}