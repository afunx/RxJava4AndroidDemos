package com.afunx.rxjava4androiddemos.samples;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.observable.Creating.Create;

/**
 * Created by afunx on 21/10/2017.
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
    }

    private void testCreate() {
        Log.d(TAG, "test observable.Creating.Create");
        Create.get().test0();
        Create.get().test1();
        Create.get().test2();
    }

    private static class SingletonHolder {
        private static final SampleManager INSTANCE = new SampleManager();
    }
}
