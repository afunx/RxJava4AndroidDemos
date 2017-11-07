package com.afunx.rxjava4androiddemos.samples.observable.Filtering;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 07/11/2017.
 * <p>
 * emit only item n emitted by an Observable
 */

public class ElementAt extends BaseSample {

    private static final String TAG = "ElementAt";

    private ElementAt() {
    }

    public static ElementAt get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() ElementAt simple demo, 1, 2, 3, 4, 5 at 2");
        Observable.just(1, 2, 3, 4, 5)
                .elementAt(2)
                .subscribe(new Consumer<Integer>() {
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

    @Override
    public void test1() {
        Log.i(TAG, "test1() ElementAt simple demo, 1, 2, 3, 4, 5 at 6");
        Observable.just(1, 2, 3, 4, 5)
                .elementAt(6)
                .subscribe(new Consumer<Integer>() {
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
        private static final ElementAt INSTANCE = new ElementAt();
    }
}
