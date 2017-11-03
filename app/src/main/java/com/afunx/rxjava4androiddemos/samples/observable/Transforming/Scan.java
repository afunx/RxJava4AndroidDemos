package com.afunx.rxjava4androiddemos.samples.observable.Transforming;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 03/11/2017.
 */

public class Scan extends BaseSample {

    private static final String TAG = "Scan";

    private Scan() {
    }

    public static Scan get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Scan simple demo, integer 1,2,3,4,5 transform to scan (integer1 + integer2)");
        /**
         *
         * e.g. 1,2,3,4,5 scan by integer1 + integer2
         *
         * 1, 2, 3, 4, 5
         * 1,
         * // 1 + 2 = 3
         * 1, 3
         * // 3 + 3 = 6
         * 1, 3, 6
         * // 6 + 4 = 10
         * 1, 3, 6, 10
         * // 10 + 5 = 15
         * 1, 3, 6, 10, 15
         */
        Observable.just(1, 2, 3, 4, 5).scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer1, @NonNull Integer integer2) throws Exception {
                return integer1 + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
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
        private static final Scan INSTANCE = new Scan();
    }
}
