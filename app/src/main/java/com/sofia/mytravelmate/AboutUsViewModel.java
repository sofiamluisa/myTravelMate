package com.sofia.mytravelmate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutUsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AboutUsViewModel() {
        mText = new MutableLiveData<>();
      //  mText.setValue("\"Hello, my name is Luisa, I am a young developer willing to start a career in the IT domain. This is my first app in Android and I hope you find it useful. The main purpose of the app is to help travelers to find affordable vacations that they will enjoy");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

