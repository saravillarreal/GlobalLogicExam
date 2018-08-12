package com.freelance.saravillarreal.globallogicexam.presenters;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainInteractorInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainOnListener;
import com.freelance.saravillarreal.globallogicexam.views.MainActivity;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class MainPresenterImplTest {

    private static List<MockGlobal> mockGlobals = Lists.newArrayList(new MockGlobal("Title1", "Description1", ""),
            new MockGlobal("Title2", "Description2", ""));

    private MainPresenterImpl mMainPresenter;

    @Mock
    private MainInteractorInterface mMainInteractor;

    @Mock
    private MainActivity mMainActivityView;

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
    @Captor
    private ArgumentCaptor<MainOnListener> mLoadNotesCallbackCaptor;


    @Before
    public void setupNotesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mMainPresenter = new MainPresenterImpl(mMainInteractor, mMainActivityView);
    }

    @Test
    public void callList() {

        // When started app call List
        mMainPresenter.callList();

        // Callback is captured and invoked with list
        verify(mMainInteractor).callListService(mLoadNotesCallbackCaptor.capture());
        mLoadNotesCallbackCaptor.getValue().resultList(mockGlobals);

        // Then view shown items in UI
        verify(mMainActivityView).showItem(mockGlobals);
    }


}