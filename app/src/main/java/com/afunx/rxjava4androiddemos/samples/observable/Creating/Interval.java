package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by afunx on 25/10/2017.
 */

public class Interval extends BaseSample {

    private static final String TAG = "Interval";

    private Interval() {
    }

    public static Interval get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Interval simple demo");
        final Disposable disposable = Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "Consumer<String> accept() aLong: " + aLong);
                    }
                });
        // sleep 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // dispose
        Log.d(TAG, "test0() disposable.dispose()");
        disposable.dispose();
    }

    private static class SingletonHolder {
        private static final Interval INSTANCE = new Interval();
    }
}
