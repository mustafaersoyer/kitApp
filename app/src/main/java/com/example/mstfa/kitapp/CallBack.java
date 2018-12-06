package com.example.mstfa.kitapp;

import java.util.ArrayList;

public interface CallBack {
        void onSuccess(ArrayList<Paylasim> liste);
        void onFail(String msg);
}
