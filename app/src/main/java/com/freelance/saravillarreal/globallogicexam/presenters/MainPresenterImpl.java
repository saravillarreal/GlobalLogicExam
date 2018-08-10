package com.freelance.saravillarreal.globallogicexam.presenters;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.interactors.MainInteractorImpl;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainInteractorInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainOnListener;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainPresenterInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainViewInterface;

import java.util.List;

public class MainPresenterImpl  implements MainPresenterInterface, MainOnListener {

    private MainViewInterface view;
    private MainInteractorInterface interactor;


    public MainPresenterImpl(MainViewInterface view) {
        this.view = view;
        this.interactor = new MainInteractorImpl();
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
