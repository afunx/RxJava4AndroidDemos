package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 13/11/2017.
 * <p>
 * suppress the first n items emitted by an Observable
 */

public class Skip extends BaseSample {

    private static final String TAG = "Skip";

    private Skip() {
    }

    public static Skip get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Skip demo, 1, 2, 3, 4, 5 skip(2) filter");
        Observable.just(1, 2, 3, 4, 5)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer i) throws Exception {
                        Log.d(TAG, "Consumer<Integer> accept() i: " + i);
                    }
                });
    }

    private static class SingletonHolder {
        private static final Skip INSTANCE = new Skip();
    }
}