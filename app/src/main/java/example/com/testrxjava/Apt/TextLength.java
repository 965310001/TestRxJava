package example.com.testrxjava.Apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//编译时注解*/
public @interface TextLength {

    int from();

    int to();
}