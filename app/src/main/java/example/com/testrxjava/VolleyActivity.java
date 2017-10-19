package example.com.testrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 测试Volley 网络框架
 */
public class VolleyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);


        /*HttpUtil.getInstance().request("https://book.douban.com/subject/2243615/", null, new HttpCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                Log.d("VolleyActivity", data);
            }

            @Override
            public void onFail(String msg) {
                Log.d("VolleyActivity", msg);
            }
        });*/

        /*Map<String, String> param = new HashMap<>();
        param.put("account", "zhijieeeeee");
        param.put("password", "123456");
        HttpUtil.getInstance().request("UserController/login", param, new HttpCallBack<User>() {
            @Override
            public void onSuccess(User user) {
            }

            @Override
            public void onFail(String msg) {
            }
        });*/
    }
}
