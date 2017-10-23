package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 23/10/2017.
 * <p>
 * convert various other objects and data types into Observables
 */

public class From extends BaseSample {

    private static final String TAG = "From";

    private From() {
    }

    public static From get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() From simple demo");
        Observable.fromArray("1", "2", "3")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, "Consumer<String> accept() s: " + s);
                    }
                });
    }

    private static class SingletonHolder {
        private static final From INSTANCE = new From();
    }
}