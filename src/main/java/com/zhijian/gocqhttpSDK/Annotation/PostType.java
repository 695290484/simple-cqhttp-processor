package com.zhijian.gocqhttpSDK.Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface PostType {
    PT value() default PT.message;
    int order() default 0;
    String pluginName() default "";
}
