package com.example.memesduniya.retrofit.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class photosViewModel extends ViewModel {

    private MutableLiveData<String>test;
    public photosViewModel(){

        init();
    }
    public void init(){

        test = new MutableLiveData<>("");



    }


    public MutableLiveData<String> getTest() {
        return test;
    }

    public void setTest(MutableLiveData<String> test) {
        this.test = test;
    }
}
