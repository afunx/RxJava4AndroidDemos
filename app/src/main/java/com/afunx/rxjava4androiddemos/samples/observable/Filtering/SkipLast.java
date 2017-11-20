package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 20/11/2017.
 * <p>
 * suppress the final n items emitted by an Observable
 */

public class SkipLast extends BaseSample {

    private static final String TAG = "SkipLast";

    private SkipLast() {
    }

    public static SkipLast get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() SkipLast demo, 1, 2, 3, 4, 5 skipLast(2) filter");
        Observable.just(1, 2, 3, 4, 5)
                .skipLast(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer i) throws Exception {
                        Log.d(TAG, "Consumer<Integer> accept() i: " + i);
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
        private static final SkipLast INSTANCE = new SkipLast();
    }
}