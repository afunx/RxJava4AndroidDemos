package com.afunx.rxjava4androiddemos.samples.observable.Creating;

import android.util.Log;

import com.afunx.rxjava4androiddemos.samples.BaseSample;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by afunx on 21/10/2017.
 * <p>
 * create an Observable from scratch by calling observer methods programmatically
 */

public class Create extends BaseSample {

    private static final String TAG = "Create";

    private Create() {
    }

    public static Create get() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void test0() {
        Log.i(TAG, "test0() Create simple demo, onNext()");
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(String.valueOf(i));
                }
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "Consumer<String> accept() s: " + s);
            }
        });
    }

    @Override
    public void test1() {
        Log.i(TAG, "test1() Create simple demo, onNext() and onError()");
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    if (i == 1) {
                        e.onError(new IllegalStateException("Just for test"));
                    }
                    e.onNext(String.valueOf(i));
                }
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "Consumer<String> accept() s: " + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d(TAG, "Consumer<Throwable> accept() throwable: " + throwable);
            }
        });
    }

    @Override
    public void test2() {
        Log.i(TAG, "test2() Create simple demo, onNext() and onComplete()");
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(String.valueOf(i));
                }
                e.onComplete();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "Consumer<String> accept() s: " + s);
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
    public void test3() {
        Log.i(TAG, "test3() Create simple demo, onNext() twice");
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(String.valueOf(i));
                }
            }
        });
        for (int time = 0; time < 2; time++) {
            observable.subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    Log.d(TAG, "Consumer<String> accept() s: " + s);
                }
            });
        }
    }

    @Override
    public void test4() {
        Log.i(TAG, "test4() Create simple demo, onNext() and onComplete() twice");
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(String.valueOf(i));
                }
                e.onComplete();
            }
        });
        for (int time = 0; time < 2; time++) {
            observable.subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    Log.d(TAG, "Consumer<String> accept() s: " + s);
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
    }

    private static class SingletonHolder {
        private static final Create INSTANCE = new Create();
    }
}
