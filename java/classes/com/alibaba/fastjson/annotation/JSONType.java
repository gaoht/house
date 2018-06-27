package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JSONType
{
  boolean alphabetic() default true;
  
  boolean asm() default true;
  
  Class<?> builder() default Void.class;
  
  Class<?> deserializer() default Void.class;
  
  String[] ignores() default {};
  
  String[] includes() default {};
  
  Class<?> mappingTo() default Void.class;
  
  String[] orders() default {};
  
  Feature[] parseFeatures() default {};
  
  Class<?>[] seeAlso() default {};
  
  boolean serializeEnumAsJavaBean() default false;
  
  Class<?> serializer() default Void.class;
  
  SerializerFeature[] serialzeFeatures() default {};
  
  String typeName() default "";
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/annotation/JSONType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */