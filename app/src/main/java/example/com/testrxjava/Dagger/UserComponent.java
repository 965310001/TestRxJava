package example.com.testrxjava.Dagger;

import dagger.Component;
import example.com.testrxjava.MainActivity;

/**
 * Created by zkw on 2017/10/19.
 */

@Component(modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity activity);
}
