package com.zx.annation;

import java.lang.annotation.*;

//参数注解
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam
{
    String value() default "";
}
