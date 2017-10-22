package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 22/10/2017.
 * <p>
 * create an Observable that emits no items and does not terminate
 */

public class Never extends BaseSample {

    private static final String TAG = "Never";

    private Never() {
    }

    public static Never get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Never simple demo");
        //noinspection unchecked
        Observable.never().subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d(TAG, "Consumer<String> accept() o: " + o);
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
        private static final Never INSTANCE = new Never();
    }
}
