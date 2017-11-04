package com.afunx.rxjava4androiddemos.samples.observable.Transforming;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 04/11/2017.
 * <p>
 * periodically subdivide items from an Observable into Observable windows and emit these windows rather than emitting the items one at a time
 */

public class Window extends BaseSample {

    private static final String TAG = "Window";

    private Window() {
    }

    public static Window get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Window simple demo, 1,2,3,4,5,6 window(2,3)");
        Observable.just(1, 2, 3, 4, 5, 6)
                .window(2, 3)
                .subscribe(new Consumer<Observable<Integer>>() {
                    @Override
                    public void accept(Observable<Integer> integerObservable) throws Exception {
                        Log.d(TAG, "Consume<Observable<Integer>> o: " + integerObservable);
                        integerObservable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer i) throws Exception {
                                Log.d(TAG, "Consumer<Integer> accept() i: " + i);
                            }
                        });
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
        Log.i(TAG, "test1() Window simple demo, 1,2,3,4,5 window(1,TimeUnit.SECONDS,2)");
        Observable.just(1, 2, 3, 4, 5, 6)
                .window(1, TimeUnit.SECONDS, 2)
                .subscribe(new Consumer<Observable<Integer>>() {
                    @Override
                    public void accept(Observable<Integer> integerObservable) throws Exception {
                        Log.d(TAG, "Consume<Observable<Integer>> o: " + integerObservable);
                        integerObservable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer i) throws Exception {
                                Log.d(TAG, "Consumer<Integer> accept() i: " + i);
                            }
                        });
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
        private static final Window INSTANCE = new Window();
    }
}
