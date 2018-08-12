package com.freelance.saravillarreal.globallogicexam.presenters;

import android.support.annotation.NonNull;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.interactors.MainInteractorImpl;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainInteractorInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainOnListener;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainPresenterInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainViewInterface;
import com.freelance.saravillarreal.globallogicexam.views.MainActivity;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainPresenterImpl  implements MainPresenterInterface, MainOnListener {

    private MainViewInterface view;
    private MainInteractorInterface interactor;


    public MainPresenterImpl(MainViewInterface view) {
        this.view = view;
        this.interactor = new MainInteractorImpl();
    }

    public MainPresenterImpl(
            @NonNull MainInteractorInterface interactor, @NonNull MainActivity mainView) {
        this.interactor = checkNotNull(interactor, "notesRepository cannot be null");
        this.view = checkNotNull(mainView, "notesView cannot be null!");
    }

    @Override
    public void callList() {
        interactor.callListService(this);
    }

    @Override
    public void resultList(List<MockGlobal> list) {
        view.showItem(list);
    }

    @Override
    public void resultListError() {
        view.showErrorService();
    }
}
