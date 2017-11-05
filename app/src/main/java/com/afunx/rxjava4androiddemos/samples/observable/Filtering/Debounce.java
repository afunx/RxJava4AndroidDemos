package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 05/11/2017.
 * <p>
 * only emit an item from an Observable if a particular timespan has passed without it emitting another item
 */

public class Debounce extends BaseSample {

    private static final String TAG = "Debounce";

    private Debounce() {
    }

    public static Debounce get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Debounce simple demo, interval(100, TimeUnit.MILLISECONDS).debounde(100, TimeUnit.MILLISECONDS)");
        Disposable disposable = Observable.interval(100, TimeUnit.MILLISECONDS)
                .debounce(100, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
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
        private static final Debounce INSTANCE = new Debounce();
    }
}
