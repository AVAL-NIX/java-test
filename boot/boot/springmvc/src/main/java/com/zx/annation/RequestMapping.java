package com.zx.annation;

import java.lang.annotation.*;

//路径注解
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping
{
    String value() default "";
}
