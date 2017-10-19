package example.com.testrxjava.Dagger;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zkw on 2017/10/19.
 */
@Module
public class UserModule {

    /*@Singleton*/
    @Provides
    public User getUser() {
        User user = new User();
        user.setName("我是测试人员");
        user.setAge(10);
        return user;
    }
}
