package com.afunx.rxjava4androiddemos.samples.observable.Transforming;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by afunx on 31/10/2017.
 * <p>
 * transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
 */

public class FlatMap extends BaseSample {

    private static final String TAG = "FlatMap";

    private FlatMap() {
    }

    public static FlatMap get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() FlatMap simple demo, integer 1,2,3 transform to string 2,3,4,6,6,9");
        Observable.just(1, 2, 3).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                return Observable.just(integer * 2 + "", integer * 3 + "");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "Consumer<String> accept() s: " + s);
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
        private static final FlatMap INSTANCE = new FlatMap();
    }
}