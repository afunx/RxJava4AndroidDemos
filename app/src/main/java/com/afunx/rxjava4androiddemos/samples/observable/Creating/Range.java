package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 26/10/2017.
 */

public class Range extends BaseSample {

    private static final String TAG = "Range";

    private Range() {
    }

    public static Range get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Range simple demo, start is 2 and count is 3");
        Observable.range(2, 3).subscribe(new Consumer<Integer>() {
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
        private static final Range INSTANCE = new Range();
    }
}
