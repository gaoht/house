package com.alibaba.fastjson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JSONPOJOBuilder
{
  String buildMethod() default "build";
  
  String withPrefix() default "with";
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/annotation/JSONPOJOBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */