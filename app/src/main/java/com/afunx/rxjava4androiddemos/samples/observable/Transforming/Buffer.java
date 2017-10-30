package com.afunx.rxjava4androiddemos.samples.observable.Transforming;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 30/10/2017.
 * <p>
 * periodically gather items from an Observable into bundles and emit these bundles rather than emitting the items one at a time
 */

public class Buffer extends BaseSample {

    private static final String TAG = "Buffer";

    private Buffer() {
    }

    public static Buffer get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Buffer simple demo, 1,2,3 buffer(2)");
        Observable.just("1", "2", "3").buffer(2).subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {
                Log.d(TAG, "Consumer<String> accept() strings: " + strings);
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
        private static final Buffer INSTANCE = new Buffer();
    }
}