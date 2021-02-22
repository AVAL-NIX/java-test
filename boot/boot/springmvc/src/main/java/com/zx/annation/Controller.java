package com.zx.annation;

import java.lang.annotation.*;

//类注解
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller
{
    String value() default "";
}
