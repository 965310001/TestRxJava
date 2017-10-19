package example.com.testrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;
import example.com.testrxjava.Aop.CheckLoginByValues;
import example.com.testrxjava.Aop.MyApplication;
import example.com.testrxjava.Dagger.DaggerUserComponent;
import example.com.testrxjava.Dagger.User;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements Observer<Object> {

    /*@Inject
    User user;*/

    /*TextView textView;*/
/*
    @ZyaoAnnotation(value = {R.id.tv, R.id.tv},
            type = {ViewType.PHONE, ViewType.TEXT},
            textLength = {{@TextLength(from = 6,to = 12)}},
            lengthTag = {"长度在6-12位", "长度在6-10位"},
            isNull = true, nullTag = {"请输入内容"})
    public void testZyaoAnnotation() {
        Log.d("MainActivity", "已经上传到了服务器了");
    }*/

    User user;

    // TODO: 2017/10/19 延迟注入  user = userLazy.get();
    @Inject
    Lazy<User> userLazy;

    // TODO: 2017/10/19 有时候不仅仅是注入单个实例，我们需要多个实例  user = userProvider.get();
    @Inject
    Provider<User> userProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test();

        DaggerUserComponent.create().inject(this);

        //返回实例
        user = userLazy.get();//延迟注入

        try {
            user = userProvider.get();

            Log.d("MainActivity", user.toString());
            Log.d("MainActivity", user.getName() + " " + user.getAge());

            user = userProvider.get();
            Log.d("MainActivity", user.toString());
            Log.d("MainActivity", user.getName() + " " + user.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }


        Intent intent=new Intent(this,VolleyActivity.class);
        startActivity(intent);






        /*Log.d("MainActivity", cloth.toString());*/

        /*PersonComponent personComponent = DaggerPersonComponent.builder()
                .personMoudule(new PersonMoudule()).build();

        personComponent.inject(this);

        Log.d("MainActivity", person.toString());*/

        /*User user = new User();
        user.name = "大哥";
        user.age = 10;
        Observable.just(user).subscribe(this);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*Person person = new Person();
        person.name = "农民";
        person.age = 111;
        person.info = "描述";
        Observable.just(person).subscribe(this);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            person = new Person();
            person.name = String.valueOf(i);
            person.age = i;
            person.info = person.name + " " + person.age;
            personList.add(person);
        }
        Observable.just(personList).subscribe(this);

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            user = new User();
            user.name = "name";
            user.age = i;
            userList.add(user);
        }
        Observable.just(userList).subscribe(this);*/

        /*testZyaoAnnotation();*/
    }

   /* @ZyaoAnnotation(value =)
    *//*@ZyaoAnnotation(name = "郭枫", age = 6)*//*
    private void testZyaoAnnotation() {
    }*/


    @CheckLoginByValues(isFlag = MyApplication.isLogin)
    /*@CheckLogin*/
    public void test() {
        Log.d("MainActivity", "已经登录了");
    }

    /*Disposable disposable;*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*disposable.dispose();*//*取消订阅*/
    }

    @Override
    public void onSubscribe(Disposable d) {
        /*disposable = d;*/
    }

    @Override
    public void onNext(Object o) {
        /*if (o instanceof User) {
            User user = (User) o;
            Log.d("MainActivity", user.name + " " + user.age);
        } else if (o instanceof Person) {
            Person person = (Person) o;
            Log.d("MainActivity", person.name + " " + person.age + " " + person.info);
        } else if (o instanceof List) {
            if (((List) o).get(0) instanceof User) {
                List<User> users = (List<User>) o;
                for (User user : users) {
                    Log.d("MainActivity", user.name + " " + user.age);
                }
            } else if (((List) o).get(0) instanceof Person) {
                List<Person> persons = (List<Person>) o;
                for (Person person : persons) {
                    Log.d("MainActivity", person.name + " " + person.age);
                }
            }
        }*/
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onComplete() {
    }

    /*class User {
        String name;
        int age;
    }*/

    /*class Person {
        String name;
        int age;
        String info;
    }*/
}
