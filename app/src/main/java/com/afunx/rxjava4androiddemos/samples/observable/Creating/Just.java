package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 25/10/2017.
 * <p>
 * create an Observable that emits a particular item
 */

public class Just extends BaseSample {

    private static final String TAG = "Just";

    private Just() {
    }

    public static Just get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Just simple demo");
        Observable.just("1", "2", "3").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "Consumer<String> accept() s: " + s);
            }
        });
    }

    private static class SingletonHolder {
        private static final Just INSTANCE = new Just();
    }
}