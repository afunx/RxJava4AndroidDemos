package com.afunx.rxjava4androiddemos.samples;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.observable.Creating.Create;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Defer;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Empty;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Never;

/**
 * Created by afunx on 21/10/2017.
 * <p>
 * SampleManager manage all samples
 */

public class SampleManager {

    private static final String TAG = "SampleManager";

    private SampleManager() {
    }

    public static SampleManager get() {
        return SingletonHolder.INSTANCE;
    }

    public void test() {
        Log.d(TAG, "test()");
        testObservable();
    }

    private void testObservable() {
        Log.d(TAG, "test observable");
        testCreating();
    }

    private void testCreating() {
        Log.d(TAG, "test observable.Creating");
        testCreate();
        testDefer();
        testEmpty();
        testNever();
    }

    private void testCreate() {
        Log.d(TAG, "test observable.Creating.Create");
        Create.get().test0();
        Create.get().test1();
        Create.get().test2();
        Create.get().test3();
        Create.get().test4();
    }

    private void testDefer() {
        Log.d(TAG, "test observable.Creating.Defer");
        Defer.get().test0();
        Defer.get().test1();
    }

    private void testEmpty() {
        Log.d(TAG, "test observable.Creating.Empty");
        Empty.get().test0();
    }

    private void testNever() {
        Log.d(TAG, "test observable.Creating.Never");
        Never.get().test0();
    }

    private static class SingletonHolder {
        private static final SampleManager INSTANCE = new SampleManager();
    }
}
