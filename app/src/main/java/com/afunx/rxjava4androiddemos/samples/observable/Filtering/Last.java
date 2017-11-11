package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 2017/11/11.
 * <p>
 * emit only the last item (or the last item that meets some condition) emitted by an Observable
 */

public class Last extends BaseSample {

    private static final String TAG = "Last";

    private Last() {
    }

    public static Last get() {
        return Last.SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Last demo, 1, 2, 3, 4, 5 last(-1) filter");
        Observable.just(1, 2, 3, 4, 5)
                .last(-1)
                .subscribe(new Consumer<Integer>() {
        @Override
        public void accept(Integer i) throws Exception {
            Log.d(TAG, "Consumer<String> accept() i: " + i);
        }
    }
                        , new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) throws Exception {
            Log.d(TAG, "Consumer<Throwable> accept() throwable: " + throwable);
        }
    });
}

    private static class SingletonHolder {
        private static final Last INSTANCE = new Last();
    }
}
