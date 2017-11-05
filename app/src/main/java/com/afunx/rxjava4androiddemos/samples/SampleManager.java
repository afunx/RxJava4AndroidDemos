package com.afunx.rxjava4androiddemos.samples;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.observable.Creating.Create;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Defer;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Empty;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Error;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.From;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Interval;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Just;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Never;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Range;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Repeat;
import com.afunx.rxjava4androiddemos.samples.observable.Creating.Timer;
import com.afunx.rxjava4androiddemos.samples.observable.Filtering.Debounce;
import com.afunx.rxjava4androiddemos.samples.observable.Transforming.Buffer;
import com.afunx.rxjava4androiddemos.samples.observable.Transforming.FlatMap;
import com.afunx.rxjava4androiddemos.samples.observable.Transforming.GroupBy;
import com.afunx.rxjava4androiddemos.samples.observable.Transforming.Map;
import com.afunx.rxjava4androiddemos.samples.observable.Transforming.Scan;
import com.afunx.rxjava4androiddemos.samples.observable.Transforming.Window;

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
        testTransforming();
        testFiltering();
    }

    private void testCreating() {
        Log.d(TAG, "test observable.Creating");
        testCreate();
        testDefer();
        testEmpty();
        testNever();
        testError();
        testFrom();
        testJust();
        testInterval();
        testRange();
        testRepeat();
        testTimer();
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

    private void testError() {
        Log.d(TAG, "test observable.Creating.Error");
        Error.get().test0();
    }

    private void testFrom() {
        Log.d(TAG, "test observable.Creating.From");
        From.get().test0();
    }

    private void testJust() {
        Log.d(TAG, "test observable.Creating.Just");
        Just.get().test0();
    }

    private void testInterval() {
        Log.d(TAG, "test observable.Creating.Interval");
        Interval.get().test0();
    }

    private void testRange() {
        Log.d(TAG, "test observable.Creating.Range");
        Range.get().test0();
    }

    private void testRepeat() {
        Log.d(TAG, "test observable.Creating.Repeat");
        Repeat.get().test0();
        Repeat.get().test1();
    }

    private void testTimer() {
        Log.d(TAG, "test observable.Creating.Timer");
        Timer.get().test0();
    }

    private void testTransforming() {
        Log.d(TAG, "test observable.Transforming");
        testBuffer();
        testFlatMap();
        testGroupBy();
        testMap();
        testScan();
        testWindow();
    }

    private void testBuffer() {
        Log.d(TAG, "test observable.Transforming.Buffer");
        Buffer.get().test0();
    }

    private void testFlatMap() {
        Log.d(TAG, "test observable.Transforming.FlatMap");
        FlatMap.get().test0();
    }

    private void testGroupBy() {
        Log.d(TAG, "test observable.Transforming.GroupBy");
        GroupBy.get().test0();
    }

    private void testMap() {
        Log.d(TAG, "test observable.Transforming.Map");
        Map.get().test0();
    }

    private void testScan() {
        Log.d(TAG, "test observable.Transforming.Scan");
        Scan.get().test0();
    }

    private void testWindow() {
        Log.d(TAG, "test observable.Transforming.Window");
        Window.get().test0();
        Window.get().test1();
    }

    private void testFiltering() {
        Log.d(TAG, "test observable.Filtering");
        testDebounce();
    }

    private void testDebounce() {
        Log.d(TAG, "test observable.Filtering.Debounce");
        Debounce.get().test0();
    }

    private static class SingletonHolder {
        private static final SampleManager INSTANCE = new SampleManager();
    }
}
