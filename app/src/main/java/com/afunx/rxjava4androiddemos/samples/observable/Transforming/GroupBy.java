package com.afunx.rxjava4androiddemos.samples.observable.Transforming;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * Created by afunx on 01/11/2017.
 */

public class GroupBy extends BaseSample {

    private static final String TAG = "GroupBy";

    private GroupBy() {
    }

    public static GroupBy get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() GroupBy simple demo, integer 1,2,3 group by i%2");
        Observable.just(1, 2, 3).groupBy(new Function<Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer) throws Exception {
                return integer % 2;
            }
        }).subscribe(new Consumer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void accept(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) throws Exception {
                final Integer key = integerIntegerGroupedObservable.getKey();
                Log.d(TAG, "accept() key: " + key);
                integerIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer i) throws Exception {
                        Log.d(TAG, "Consumer<String> accept() key: " + key + ", i: " + i);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "Consumer<Throwable> accept() throwable: " + throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "Action run() for onComplete() key: " + key);
                    }
                });
            }
        });
    }

    private static class SingletonHolder {
        private static final GroupBy INSTANCE = new GroupBy();
    }
}
