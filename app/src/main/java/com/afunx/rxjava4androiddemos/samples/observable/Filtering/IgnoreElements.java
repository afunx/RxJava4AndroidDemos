package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afun1 on 2017/11/10.
 */

public class IgnoreElements extends BaseSample {

    private static final String TAG = "IgnoreElements";

    private IgnoreElements() {
    }

    public static IgnoreElements get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() IgnoreElements demo, 1, 2, 3, 4, 5 ignoreElements()");
        Observable.just(1, 2, 3, 4, 5)
                .ignoreElements()
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "Action run() for onComplete()");
                    }
                });
    }

    private static class SingletonHolder {
        private static final IgnoreElements INSTANCE = new IgnoreElements();
    }
}
