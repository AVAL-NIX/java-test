package com.zx.annation;

import java.lang.annotation.*;

//service
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service
{
    String value() default "";
}
