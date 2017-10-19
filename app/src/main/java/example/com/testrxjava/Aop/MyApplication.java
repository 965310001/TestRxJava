package example.com.testrxjava.Aop;

import android.app.Application;
import android.content.Context;

/**
 * Created by zkw on 2017/10/18.
 */

public class MyApplication extends Application {

    public static final boolean isLogin = true;

    public static Context myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }
}
