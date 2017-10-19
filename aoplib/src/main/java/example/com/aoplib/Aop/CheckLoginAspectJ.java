package example.com.aoplib.Aop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * Created by zkw on 2017/10/18.
 */

@Aspect
public class CheckLoginAspectJ {

    /**
     * 找到处理的切点
     * * *(..)  可以处理CheckLogin这个类所有的方法
     */
    @Pointcut("execution(@example.com.testrxjava.Aop.CheckLogin  * *(..))")
    public void executionCheckLogin() {
    }

    /**
     * 处理切面
     *
     * @param joinPoint
     * @return
     */
    @Around("executionCheckLogin()")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLogin checkLogin = signature.getMethod().getAnnotation(CheckLogin.class);
        if (checkLogin != null) {
            Context context = (Context) joinPoint.getThis();
            if (MyApplication.isLogin) {
                Log.i("MainActivity", "checkLogin: 登录成功 ");
                return joinPoint.proceed();
            } else {
                /*Log.i("MainActivity", "checkLogin: 请登录");*/
                Toast.makeText(context, "请登录", Toast.LENGTH_SHORT).show();

                /*Intent intent = new Intent(context, LoginActivity.class);*/
                /*context.startActivity(intent);*/
                /*((Activity)context).finish();*/
                return null;
            }
        }
        return joinPoint.proceed();
    }

}
