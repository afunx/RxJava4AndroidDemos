package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 22/10/2017.
 * <p>
 * create an Observable that emits no items but terminates normally
 */

public class Empty extends BaseSample {

    private static final String TAG = "Empty";

    private Empty() {
    }

    public static Empty get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Empty simple demo");
        //noinspection unchecked
        Observable.empty()
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "Action run() for onComplete()");
                    }
                });
    }

    private static class SingletonHolder {
        private static final Empty INSTANCE = new Empty();
    }
}