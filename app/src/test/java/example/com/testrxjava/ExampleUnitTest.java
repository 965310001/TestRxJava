package example.com.testrxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import static android.R.attr.value;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test() {
        /*被观察者*/
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("observable");
                e.onComplete();
            }
        });

        /*观察者*/
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                /*d.dispose(); 解除订阅*/
                /*d.isDisposed();*/
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            //观察者接收到通知,进行相关操作
            public void onNext(String aLong) {
                System.out.println("我接收到数据了" + aLong);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        /*订阅者*/
        observable.subscribe(observer);
    }

    @Test
    public void testJust() {
        Observable<String> observable = Observable.just("大家好梦");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(String value) {
                System.out.println("我接收到数据了:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }

    @Test
    public void testObj() {
        //传递对象
        User user = new User();
        user.name = "郭枫";
        user.age = 10;
        Observable<User> observable = Observable.just(user);
        Observer<User> observer = new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(User user) {
                System.out.println("我接收到数据了:" + user.name + " " + user.age);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }

    @Test
    public void testFromIterable() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        Observable<String> observable = Observable.fromIterable(list);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(String value) {
                System.out.println("我接收到数据了:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }

    @Test
    public void testFromIterableByObj() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.name = "name" + String.valueOf(i);
            user.age = i;
            list.add(user);
        }
        Observable<User> observable = Observable.fromIterable(list);
        Observer<User> observer = new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(User user) {
                System.out.println("我接收到数据了:" + user.name + " " + user.age);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);

    }

    /*有问题*/
   /* @Test
    public void testInterval() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .take(61)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        System.out.println(aLong);
                        return 60 - aLong;
                    }
                });
        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(Long value) {
                System.out.println("计时:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }*/

    @Test
    public void testRange() {
        Observable<Integer> observable = Observable.range(0, 20);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("我接收到数据了:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }

    @Test
    public void testMap() {
        Observable<Integer> observable = Observable.just("12")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return s.length();
                    }
                });
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("我接收到数据了:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }

    @Test
    public void testFlatMap() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        Observable<String> observable = Observable.just(list)
                .flatMap(new Function<List<String>, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(List<String> strings) throws Exception {
                        return Observable.fromIterable(strings);
                    }
                });
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable:" + d.toString());
            }

            @Override
            public void onNext(String value) {
                System.out.println("我接收到数据了:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }


    class User {
        String name;
        int age;
    }
}