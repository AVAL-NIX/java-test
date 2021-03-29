package com.zx.annation;

import java.lang.annotation.*;

// 依赖注入
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired
{
    String value() default "";
}
