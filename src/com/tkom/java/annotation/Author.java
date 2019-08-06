package com.tkom.java.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2019/8/6 0006.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Author {
    String description() default "hahah";
}
