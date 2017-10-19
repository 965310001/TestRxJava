package example.com.testrxjava.Aop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.w3c.dom.Text;

import example.com.testrxjava.Apt.ViewType;
import example.com.testrxjava.Apt.ZyaoAnnotation;
import example.com.testrxjava.LoginActivity;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static example.com.testrxjava.Apt.ViewType.IDCARD;

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

    @Pointcut("execution(@example.com.testrxjava.Aop.CheckLoginByValues  * *(..))")
    public void executionCheckLoginByValues() {
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
                Toast.makeText(context, "请登录", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "大哥");
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                ((Activity) context).finish();
                return null;
            }
        }
        return joinPoint.proceed();
    }

    @Around("executionCheckLoginByValues()")
    public Object checkLoginByValues(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLoginByValues checkLogin = signature.getMethod().getAnnotation(CheckLoginByValues.class);
        if (checkLogin != null) {
            Context context = (Context) joinPoint.getThis();
            if (checkLogin.isFlag()) {
                Log.i("MainActivity", "checkLogin: 登录成功 ");
                return joinPoint.proceed();
            } else {
                Log.i("MainActivity", "checkLogin: 请去登录 ");
                Toast.makeText(context, "请登录", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                ((Activity) context).finish();
                return null;
            }
        }
        return joinPoint.proceed();
    }


    // TODO: 2017/10/19 判断是否有内容
    @Pointcut("execution(@example.com.testrxjava.Apt.ZyaoAnnotation  * *(..))")
    public void excutionZyaoAnnotation() {
    }

    @Around("excutionZyaoAnnotation()")
    public Object zyaoAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ZyaoAnnotation zyaoAnnotation = methodSignature.getMethod().getAnnotation(ZyaoAnnotation.class);
        /*Activity activity = (Activity) joinPoint.getThis();
        TextView textView = (TextView) activity.findViewById(zyaoAnnotation.value());

        if (zyaoAnnotation.isNull()) {//true 要判断是否为空
            if (TextUtils.isEmpty(textView.getText().toString().trim())) {
                Toast.makeText(activity, zyaoAnnotation.nullTag(), Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        switch (zyaoAnnotation.type()) {
            case TEXT:
                break;
            case PHONE:
                break;
            case EMAIL:
                break;
            case NAME:
                break;
            case IDCARD:
                break;
            default:
                break;
        }

       *//* if (zyaoAnnotation.isNull()) {//true 要判断是否为空
            if (TextUtils.isEmpty(textView.getText().toString().trim())) {
                Toast.makeText(activity, zyaoAnnotation.nullTag(), Toast.LENGTH_SHORT).show();
                return null;
            }
        }*//*
        int length = textView.length();
        if (!(zyaoAnnotation.from() <= length && zyaoAnnotation.to() >= length)) {
            Toast.makeText(activity, zyaoAnnotation.lengthTag(), Toast.LENGTH_SHORT).show();
            return null;
        }*/
        return joinPoint.proceed();
    }
}
