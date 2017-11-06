package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 06/11/2017.
 * <p>
 * suppress duplicate items emitted by an Observable
 */

public class Distinct extends BaseSample {

    private static final String TAG = "Distinct";

    private Distinct() {
    }

    public static Distinct get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Distinct simple demo, 1, 2, 2, 1, 3");
        Observable.just(1, 2, 2, 1, 3)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer i) throws Exception {
                        Log.d(TAG, "Consumer<String> accept() i: " + i);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "Consumer<Throwable> accept() throwable: " + throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "Action run() for onComplete()");
                    }
                });
    }

    private static class SingletonHolder {
        private static final Distinct INSTANCE = new Distinct();
    }
}
