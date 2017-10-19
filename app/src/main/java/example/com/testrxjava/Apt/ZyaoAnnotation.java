package example.com.testrxjava.Apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zkw on 2017/10/19.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//编译时注解
public @interface ZyaoAnnotation {

    ViewType type()[] default ViewType.TEXT;

    int[] value();

    TextLength[] textLength();

    String[] lengthTag();

    boolean[] isNull();

    String[] nullTag();

}



