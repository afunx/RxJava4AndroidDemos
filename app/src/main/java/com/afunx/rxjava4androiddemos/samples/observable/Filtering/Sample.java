package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by afunx on 2017/11/13.
 */

public class Sample extends BaseSample {

    private static final String TAG = "Sample";

    private Sample() {
    }

    public static Sample get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Sample demo, timer(100, TimeUnit.MILLISECONDS).sample(2, TimeUnit.MILLISECONDS)");

        final Disposable disposable = Observable.interval(100, TimeUnit.MILLISECONDS).sample(200, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long l) throws Exception {
                Log.d(TAG, "Consumer<Long> accept() l: " + l);
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
        Log.d(TAG, "test0() sleeping");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "test0() sleep");
        disposable.dispose();
    }

    private static class SingletonHolder {
        private static final Sample INSTANCE = new Sample();
    }
}
