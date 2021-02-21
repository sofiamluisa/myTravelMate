package com.sofia.mytravelmate;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
      //  mText.setValue("If you like this app you can share it with your friends");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
