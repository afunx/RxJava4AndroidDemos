package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 21/10/2017.
 * <p>
 * do not create the Observable until the observer subscribes, and create a fresh Observable for each observer
 */

public class Defer extends BaseSample {

    private static final String TAG = "Defer";

    private Defer() {
    }

    public static Defer get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Defer simple demo, call()");
        Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                Log.d(TAG, "call()");
                return new ObservableSource<String>() {
                    @Override
                    public void subscribe(@NonNull Observer<? super String> observer) {
                        Log.d(TAG, "subscribe()");
                        for (int i = 0; i < 3; i++) {
                            observer.onNext(String.valueOf(i));
                        }
                    }
                };
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept() s: " + s);
            }
        });
    }

    @Override
    public void test1() {
        Log.i(TAG, "test1() Defer simple demo, call() twice");
        Observable<String> observable = Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                Log.d(TAG, "call()");
                return new ObservableSource<String>() {
                    @Override
                    public void subscribe(@NonNull Observer<? super String> observer) {
                        Log.d(TAG, "subscribe()");
                        for (int i = 0; i < 3; i++) {
                            observer.onNext(String.valueOf(i));
                        }
                    }
                };
            }
        });

        for (int time = 0; time < 2; time++) {
            observable.subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    Log.d(TAG, "accept() s: " + s);
                }
            });
        }
    }

    private static class SingletonHolder {
        private static final Defer INSTANCE = new Defer();
    }
}
