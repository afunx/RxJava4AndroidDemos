package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by afunx on 2017/11/9.
 * <p>
 * emit only the first item (or the first item that meets some condition) emitted by an Observable
 */

public class First extends BaseSample {

    private static final String TAG = "first";

    private First() {
    }

    public static First get() {
        return First.SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() First demo, 1, 2, 3, 4, 5 first(-1) filter");
        Observable.just(1, 2, 3, 4, 5)
                .first(-1)
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
        private static final First INSTANCE = new First();
    }
}
