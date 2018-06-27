package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ASMSerializerFactory
  implements Opcodes
{
  static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
  static final String JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
  static final String JavaBeanSerializer_desc = "L" + ASMUtils.type(JavaBeanSerializer.class) + ";";
  static final String ObjectSerializer = ASMUtils.type(ObjectSerializer.class);
  static final String ObjectSerializer_desc = "L" + ObjectSerializer + ";";
  static final String SerialContext_desc = ASMUtils.desc(SerialContext.class);
  static final String SerializeFilterable_desc = ASMUtils.desc(SerializeFilterable.class);
  static final String SerializeWriter = ASMUtils.type(SerializeWriter.class);
  static final String SerializeWriter_desc = "L" + SerializeWriter + ";";
  protected final ASMClassLoader classLoader = new ASMClassLoader();
  private final AtomicLong seed = new AtomicLong();
  
  private void _after(MethodVisitor paramMethodVisitor, Context paramContext)
  {
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _apply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramFieldInfo = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (paramFieldInfo == Byte.TYPE)
    {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
    }
    for (;;)
    {
      paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
      return;
      if (paramFieldInfo == Short.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
      }
      else if (paramFieldInfo == Integer.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      }
      else if (paramFieldInfo == Character.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
      }
      else if (paramFieldInfo == Long.TYPE)
      {
        paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
      }
      else if (paramFieldInfo == Float.TYPE)
      {
        paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
      }
      else if (paramFieldInfo == Double.TYPE)
      {
        paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
      }
      else if (paramFieldInfo == Boolean.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
      }
      else if (paramFieldInfo == BigDecimal.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
      }
      else if (paramFieldInfo == String.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      }
      else if (paramFieldInfo.isEnum())
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      }
      else if (List.class.isAssignableFrom(paramFieldInfo))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      }
      else
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      }
    }
  }
  
  private void _before(MethodVisitor paramMethodVisitor, Context paramContext)
  {
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _decimal(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("decimal"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    Label localLabel3 = new Label();
    paramMethodVisitor.visitLabel(localLabel1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    paramMethodVisitor.visitJumpInsn(199, localLabel2);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, localLabel3);
    paramMethodVisitor.visitLabel(localLabel2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitJumpInsn(167, localLabel3);
    paramMethodVisitor.visitLabel(localLabel3);
    paramMethodVisitor.visitLabel(paramClass);
  }
  
  private void _double(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(57, paramContext.var("double", 2));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(paramClass);
  }
  
  private void _enum(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, localLabel2);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitTypeInsn(192, "java/lang/Enum");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("enum"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, localLabel2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    paramMethodVisitor.visitJumpInsn(199, paramClass);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, localLabel1);
    paramMethodVisitor.visitLabel(paramClass);
    if (paramContext.writeDirect)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
    }
    for (;;)
    {
      _seperator(paramMethodVisitor, paramContext);
      paramMethodVisitor.visitLabel(localLabel1);
      paramMethodVisitor.visitLabel(localLabel2);
      return;
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitInsn(3);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
    }
  }
  
  private void _filters(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel)
  {
    if (paramFieldInfo.fieldTransient)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
    }
    _notWriteDefault(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    if (paramContext.writeDirect) {
      return;
    }
    _apply(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
    _processKey(paramMethodVisitor, paramFieldInfo, paramContext);
    _processValue(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
  }
  
  private void _float(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(56, paramContext.var("float"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(paramClass);
  }
  
  private void _get(MethodVisitor paramMethodVisitor, Context paramContext, FieldInfo paramFieldInfo)
  {
    Method localMethod = paramFieldInfo.method;
    int i;
    if (localMethod != null)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("entity"));
      paramContext = localMethod.getDeclaringClass();
      if (paramContext.isInterface())
      {
        i = 185;
        paramMethodVisitor.visitMethodInsn(i, ASMUtils.type(paramContext), localMethod.getName(), ASMUtils.desc(localMethod));
        if (!localMethod.getReturnType().equals(paramFieldInfo.fieldClass)) {
          paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramFieldInfo.fieldClass));
        }
      }
    }
    do
    {
      return;
      i = 182;
      break;
      paramMethodVisitor.visitVarInsn(25, paramContext.var("entity"));
      paramContext = paramFieldInfo.field;
      paramMethodVisitor.visitFieldInsn(180, ASMUtils.type(paramFieldInfo.declaringClass), paramContext.getName(), ASMUtils.desc(paramContext.getType()));
    } while (paramContext.getType().equals(paramFieldInfo.fieldClass));
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramFieldInfo.fieldClass));
  }
  
  private void _getFieldSer(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_ser_", ObjectSerializer_desc);
    paramMethodVisitor.visitJumpInsn(199, localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + ObjectSerializer_desc);
    paramMethodVisitor.visitFieldInsn(181, paramContext.className, paramFieldInfo.name + "_asm_ser_", ObjectSerializer_desc);
    paramMethodVisitor.visitLabel(localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_ser_", ObjectSerializer_desc);
  }
  
  private void _getListFieldItemSer(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_list_item_ser_", ObjectSerializer_desc);
    paramMethodVisitor.visitJumpInsn(199, localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass)));
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + ObjectSerializer_desc);
    paramMethodVisitor.visitFieldInsn(181, paramContext.className, paramFieldInfo.name + "_asm_list_item_ser_", ObjectSerializer_desc);
    paramMethodVisitor.visitLabel(localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_list_item_ser_", ObjectSerializer_desc);
  }
  
  private void _if_write_null(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    Class localClass = paramFieldInfo.fieldClass;
    Label localLabel4 = new Label();
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    Label localLabel3 = new Label();
    paramMethodVisitor.visitLabel(localLabel4);
    paramFieldInfo = paramFieldInfo.getAnnotation();
    if (paramFieldInfo != null) {}
    for (int i = SerializerFeature.of(paramFieldInfo.serialzeFeatures());; i = 0)
    {
      if ((SerializerFeature.WRITE_MAP_NULL_FEATURES & i) == 0)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WRITE_MAP_NULL_FEATURES));
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
        paramMethodVisitor.visitJumpInsn(153, localLabel1);
      }
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      _writeFieldName(paramMethodVisitor, paramContext);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(i));
      if ((localClass == String.class) || (localClass == Character.class)) {
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
      }
      for (;;)
      {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "(II)V");
        _seperator(paramMethodVisitor, paramContext);
        paramMethodVisitor.visitJumpInsn(167, localLabel3);
        paramMethodVisitor.visitLabel(localLabel1);
        paramMethodVisitor.visitLabel(localLabel3);
        return;
        if (Number.class.isAssignableFrom(localClass)) {
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
        } else if (localClass == Boolean.class) {
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
        } else if ((Collection.class.isAssignableFrom(localClass)) || (localClass.isArray())) {
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
        } else {
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(0));
        }
      }
    }
  }
  
  private void _int(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, int paramInt, char paramChar)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramInt);
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramInt);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;" + paramChar + ")V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(paramClass);
  }
  
  private void _labelApply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel)
  {
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.label);
    paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  private void _list(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    java.lang.reflect.Type localType = TypeUtils.getCollectionItemType(paramFieldInfo.fieldType);
    paramClass = null;
    if ((localType instanceof Class)) {
      paramClass = (Class)localType;
    }
    Class<?> localClass;
    if (paramClass != Object.class)
    {
      localClass = paramClass;
      if (paramClass != Serializable.class) {}
    }
    else
    {
      localClass = null;
    }
    Label localLabel1 = new Label();
    paramClass = new Label();
    Label localLabel2 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, localLabel1);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitTypeInsn(192, "java/util/List");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, localLabel1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    paramMethodVisitor.visitJumpInsn(199, paramClass);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, localLabel2);
    paramMethodVisitor.visitLabel(paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    _writeFieldName(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    paramMethodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("size"));
    paramClass = new Label();
    Label localLabel3 = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("size"));
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitJumpInsn(160, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitLdcInsn("[]");
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitJumpInsn(167, localLabel3);
    paramMethodVisitor.visitLabel(paramClass);
    if (!paramContext.nonContext)
    {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }
    if ((localType == String.class) && (paramContext.writeDirect))
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Ljava/util/List;)V");
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "popContext", "()V");
      paramMethodVisitor.visitLabel(localLabel3);
      _seperator(paramMethodVisitor, paramContext);
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitLabel(localLabel1);
      return;
    }
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 91);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    Label localLabel4 = new Label();
    paramClass = new Label();
    Label localLabel5 = new Label();
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
    paramMethodVisitor.visitLabel(localLabel4);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("size"));
    paramMethodVisitor.visitJumpInsn(162, localLabel5);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitJumpInsn(153, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item"));
    Label localLabel6 = new Label();
    paramClass = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
    paramMethodVisitor.visitJumpInsn(199, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "()V");
    paramMethodVisitor.visitJumpInsn(167, localLabel6);
    paramMethodVisitor.visitLabel(paramClass);
    Label localLabel7 = new Label();
    Label localLabel8 = new Label();
    if ((localClass != null) && (Modifier.isPublic(localClass.getModifiers())))
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(localClass)));
      paramMethodVisitor.visitJumpInsn(166, localLabel8);
      _getListFieldItemSer(paramContext, paramMethodVisitor, paramFieldInfo, localClass);
      paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_desc"));
      Label localLabel9 = new Label();
      Label localLabel10 = new Label();
      if (paramContext.writeDirect)
      {
        if ((paramContext.nonContext) && (paramContext.writeDirect))
        {
          paramClass = "writeDirectNonContext";
          label1122:
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
          paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
          paramMethodVisitor.visitJumpInsn(153, localLabel9);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
          paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
          paramMethodVisitor.visitVarInsn(25, 1);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
          if (!paramContext.nonContext) {
            break label1675;
          }
          paramMethodVisitor.visitInsn(1);
          label1229:
          paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(localClass)));
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
          paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, paramClass, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          paramMethodVisitor.visitJumpInsn(167, localLabel10);
          paramMethodVisitor.visitLabel(localLabel9);
        }
      }
      else
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
        if (!paramContext.nonContext) {
          break label1709;
        }
        paramMethodVisitor.visitInsn(1);
        label1371:
        paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(localClass)));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(185, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        paramMethodVisitor.visitLabel(localLabel10);
        paramMethodVisitor.visitJumpInsn(167, localLabel7);
      }
    }
    else
    {
      paramMethodVisitor.visitLabel(localLabel8);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
      if (!paramContext.nonContext) {
        break label1743;
      }
      paramMethodVisitor.visitInsn(1);
      label1507:
      if ((localClass == null) || (!Modifier.isPublic(localClass.getModifiers()))) {
        break label1777;
      }
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localType)));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
    }
    for (;;)
    {
      paramMethodVisitor.visitLabel(localLabel7);
      paramMethodVisitor.visitLabel(localLabel6);
      paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
      paramMethodVisitor.visitJumpInsn(167, localLabel4);
      paramMethodVisitor.visitLabel(localLabel5);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 93);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      break;
      paramClass = "write";
      break label1122;
      label1675:
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      break label1229;
      label1709:
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      break label1371;
      label1743:
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      break label1507;
      label1777:
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }
  }
  
  private void _long(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(55, paramContext.var("long", 2));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(paramClass);
  }
  
  private void _nameApply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel)
  {
    if (!paramContext.writeDirect)
    {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
      _labelApply(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    }
    if (paramFieldInfo.field == null)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
    }
  }
  
  private void _notWriteDefault(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel)
  {
    if (paramContext.writeDirect) {
      return;
    }
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("notWriteDefaultValue"));
    paramMethodVisitor.visitJumpInsn(153, localLabel);
    paramFieldInfo = paramFieldInfo.fieldClass;
    if (paramFieldInfo == Boolean.TYPE)
    {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    }
    for (;;)
    {
      paramMethodVisitor.visitLabel(localLabel);
      return;
      if (paramFieldInfo == Byte.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
        paramMethodVisitor.visitJumpInsn(153, paramLabel);
      }
      else if (paramFieldInfo == Short.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
        paramMethodVisitor.visitJumpInsn(153, paramLabel);
      }
      else if (paramFieldInfo == Integer.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
        paramMethodVisitor.visitJumpInsn(153, paramLabel);
      }
      else if (paramFieldInfo == Long.TYPE)
      {
        paramMethodVisitor.visitVarInsn(22, paramContext.var("long"));
        paramMethodVisitor.visitInsn(9);
        paramMethodVisitor.visitInsn(148);
        paramMethodVisitor.visitJumpInsn(153, paramLabel);
      }
      else if (paramFieldInfo == Float.TYPE)
      {
        paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
        paramMethodVisitor.visitInsn(11);
        paramMethodVisitor.visitInsn(149);
        paramMethodVisitor.visitJumpInsn(153, paramLabel);
      }
      else if (paramFieldInfo == Double.TYPE)
      {
        paramMethodVisitor.visitVarInsn(24, paramContext.var("double"));
        paramMethodVisitor.visitInsn(14);
        paramMethodVisitor.visitInsn(151);
        paramMethodVisitor.visitJumpInsn(153, paramLabel);
      }
    }
  }
  
  private void _object(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("object"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _writeObject(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    paramMethodVisitor.visitLabel(paramClass);
  }
  
  private void _processKey(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("hasNameFilters"));
    paramMethodVisitor.visitJumpInsn(153, localLabel);
    paramFieldInfo = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (paramFieldInfo == Byte.TYPE)
    {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
    }
    for (;;)
    {
      paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      paramMethodVisitor.visitLabel(localLabel);
      return;
      if (paramFieldInfo == Short.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
      }
      else if (paramFieldInfo == Integer.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      }
      else if (paramFieldInfo == Character.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
      }
      else if (paramFieldInfo == Long.TYPE)
      {
        paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
      }
      else if (paramFieldInfo == Float.TYPE)
      {
        paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
      }
      else if (paramFieldInfo == Double.TYPE)
      {
        paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
      }
      else if (paramFieldInfo == Boolean.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
      }
      else if (paramFieldInfo == BigDecimal.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
      }
      else if (paramFieldInfo == String.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      }
      else if (paramFieldInfo.isEnum())
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      }
      else if (List.class.isAssignableFrom(paramFieldInfo))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      }
      else
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      }
    }
  }
  
  private void _processValue(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel)
  {
    Label localLabel1 = new Label();
    Class localClass = paramFieldInfo.fieldClass;
    if (localClass.isPrimitive())
    {
      Label localLabel2 = new Label();
      paramMethodVisitor.visitVarInsn(21, paramContext.var("checkValue"));
      paramMethodVisitor.visitJumpInsn(154, localLabel2);
      paramMethodVisitor.visitInsn(1);
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(58, Context.processValue);
      paramMethodVisitor.visitJumpInsn(167, localLabel1);
      paramMethodVisitor.visitLabel(localLabel2);
    }
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramContext.getFieldOrinal(paramFieldInfo.name)));
    paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "getBeanContext", "(I)" + ASMUtils.desc(BeanContext.class));
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (localClass == Byte.TYPE)
    {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    }
    for (;;)
    {
      paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "processValue", "(L" + JSONSerializer + ";" + ASMUtils.desc(BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;" + "Ljava/lang/Object;" + ")Ljava/lang/Object;");
      paramMethodVisitor.visitVarInsn(58, Context.processValue);
      paramMethodVisitor.visitVarInsn(25, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
      paramMethodVisitor.visitJumpInsn(165, localLabel1);
      _writeObject(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
      paramMethodVisitor.visitJumpInsn(167, paramLabel);
      paramMethodVisitor.visitLabel(localLabel1);
      return;
      if (localClass == Short.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == Integer.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == Character.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == Long.TYPE)
      {
        paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == Float.TYPE)
      {
        paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == Double.TYPE)
      {
        paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == Boolean.TYPE)
      {
        paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitVarInsn(58, Context.original);
      }
      else if (localClass == BigDecimal.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
        paramMethodVisitor.visitVarInsn(58, Context.original);
        paramMethodVisitor.visitVarInsn(25, Context.original);
      }
      else if (localClass == String.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
        paramMethodVisitor.visitVarInsn(58, Context.original);
        paramMethodVisitor.visitVarInsn(25, Context.original);
      }
      else if (localClass.isEnum())
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
        paramMethodVisitor.visitVarInsn(58, Context.original);
        paramMethodVisitor.visitVarInsn(25, Context.original);
      }
      else if (List.class.isAssignableFrom(localClass))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
        paramMethodVisitor.visitVarInsn(58, Context.original);
        paramMethodVisitor.visitVarInsn(25, Context.original);
      }
      else
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
        paramMethodVisitor.visitVarInsn(58, Context.original);
        paramMethodVisitor.visitVarInsn(25, Context.original);
      }
    }
  }
  
  private void _seperator(MethodVisitor paramMethodVisitor, Context paramContext)
  {
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _string(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext)
  {
    paramClass = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("string"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, paramClass);
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    paramMethodVisitor.visitJumpInsn(199, localLabel1);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, localLabel2);
    paramMethodVisitor.visitLabel(localLabel1);
    if (paramContext.writeDirect)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
    }
    for (;;)
    {
      _seperator(paramMethodVisitor, paramContext);
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitLabel(paramClass);
      return;
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
    }
  }
  
  private void _writeFieldName(MethodVisitor paramMethodVisitor, Context paramContext)
  {
    if (paramContext.writeDirect)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
      return;
    }
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
  }
  
  private void _writeObject(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel)
  {
    String str = paramFieldInfo.getFormat();
    Object localObject = paramFieldInfo.fieldClass;
    Label localLabel1 = new Label();
    int i;
    if (paramContext.writeDirect)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, paramContext.var("object"));
      paramMethodVisitor.visitJumpInsn(199, localLabel1);
      _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
      paramMethodVisitor.visitJumpInsn(167, paramLabel);
      paramMethodVisitor.visitLabel(localLabel1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      _writeFieldName(paramMethodVisitor, paramContext);
      localLabel1 = new Label();
      Label localLabel2 = new Label();
      if ((Modifier.isPublic(((Class)localObject).getModifiers())) && (!ParserConfig.isPrimitive((Class)localObject)))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
        paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject)));
        paramMethodVisitor.visitJumpInsn(166, localLabel2);
        _getFieldSer(paramContext, paramMethodVisitor, paramFieldInfo);
        paramMethodVisitor.visitVarInsn(58, paramContext.var("fied_ser"));
        localObject = new Label();
        Label localLabel3 = new Label();
        paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
        paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
        paramMethodVisitor.visitJumpInsn(153, (Label)localObject);
        if ((paramFieldInfo.serialzeFeatures & SerializerFeature.BeanToArray.mask) == 0) {
          break label818;
        }
        i = 1;
        label343:
        if ((!paramContext.nonContext) || (!paramContext.writeDirect)) {
          break label832;
        }
        if (i == 0) {
          break label824;
        }
        paramLabel = "writeAsArrayNonContext";
        label367:
        paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
        paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
        paramMethodVisitor.visitVarInsn(25, Context.fieldName);
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, paramLabel, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        paramMethodVisitor.visitJumpInsn(167, localLabel3);
        paramMethodVisitor.visitLabel((Label)localObject);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
        paramMethodVisitor.visitVarInsn(25, Context.fieldName);
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(185, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        paramMethodVisitor.visitLabel(localLabel3);
        paramMethodVisitor.visitJumpInsn(167, localLabel1);
      }
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitVarInsn(25, 1);
      if (!paramContext.writeDirect) {
        break label853;
      }
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      label758:
      if (str == null) {
        break label867;
      }
      paramMethodVisitor.visitLdcInsn(str);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
    }
    for (;;)
    {
      paramMethodVisitor.visitLabel(localLabel1);
      _seperator(paramMethodVisitor, paramContext);
      return;
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
      break;
      label818:
      i = 0;
      break label343;
      label824:
      paramLabel = "writeDirectNonContext";
      break label367;
      label832:
      if (i != 0)
      {
        paramLabel = "writeAsArray";
        break label367;
      }
      paramLabel = "write";
      break label367;
      label853:
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
      break label758;
      label867:
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      if ((!(paramFieldInfo.fieldType instanceof Class)) || (!((Class)paramFieldInfo.fieldType).isPrimitive())) {
        break label922;
      }
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }
    label922:
    if (paramFieldInfo.fieldClass == String.class) {
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(String.class)));
    }
    for (;;)
    {
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      break;
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
    }
  }
  
  private void generateWriteAsArray(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo[] paramArrayOfFieldInfo, Context paramContext)
    throws Exception
  {
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 91);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    int k = paramArrayOfFieldInfo.length;
    if (k == 0)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 93);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      return;
    }
    int i = 0;
    label101:
    int j;
    label121:
    FieldInfo localFieldInfo;
    if (i < k)
    {
      if (i != k - 1) {
        break label268;
      }
      j = 93;
      localFieldInfo = paramArrayOfFieldInfo[i];
      localObject1 = localFieldInfo.fieldClass;
      paramMethodVisitor.visitLdcInsn(localFieldInfo.name);
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      if ((localObject1 != Byte.TYPE) && (localObject1 != Short.TYPE) && (localObject1 != Integer.TYPE)) {
        break label275;
      }
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitInsn(89);
      _get(paramMethodVisitor, paramContext, localFieldInfo);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeInt", "(I)V");
      paramMethodVisitor.visitVarInsn(16, j);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    }
    for (;;)
    {
      i += 1;
      break label101;
      break;
      label268:
      j = 44;
      break label121;
      label275:
      if (localObject1 == Long.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeLong", "(J)V");
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      }
      else if (localObject1 == Float.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitInsn(4);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFloat", "(FZ)V");
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      }
      else if (localObject1 == Double.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitInsn(4);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeDouble", "(DZ)V");
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      }
      else if (localObject1 == Boolean.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Z)V");
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      }
      else if (localObject1 == Character.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      }
      else if (localObject1 == String.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      }
      else
      {
        if (!((Class)localObject1).isEnum()) {
          break label883;
        }
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitInsn(89);
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeEnum", "(Ljava/lang/Enum;)V");
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      }
    }
    label883:
    if (List.class.isAssignableFrom((Class)localObject1))
    {
      paramClass = localFieldInfo.fieldType;
      if ((paramClass instanceof Class)) {}
      for (localObject1 = Object.class;; localObject1 = ((java.lang.reflect.ParameterizedType)paramClass).getActualTypeArguments()[0])
      {
        paramClass = null;
        if ((localObject1 instanceof Class))
        {
          localObject2 = (Class)localObject1;
          paramClass = (Class<?>)localObject2;
          if (localObject2 == Object.class) {
            paramClass = null;
          }
        }
        _get(paramMethodVisitor, paramContext, localFieldInfo);
        paramMethodVisitor.visitTypeInsn(192, "java/util/List");
        paramMethodVisitor.visitVarInsn(58, paramContext.var("list"));
        if ((paramClass != String.class) || (!paramContext.writeDirect)) {
          break label1101;
        }
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Ljava/util/List;)V");
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitVarInsn(16, j);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
        break;
      }
      label1101:
      localObject2 = new Label();
      localLabel1 = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitJumpInsn(199, localLabel1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "()V");
      paramMethodVisitor.visitJumpInsn(167, (Label)localObject2);
      paramMethodVisitor.visitLabel(localLabel1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
      paramMethodVisitor.visitVarInsn(54, paramContext.var("size"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 91);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      localLabel1 = new Label();
      localLabel3 = new Label();
      localLabel2 = new Label();
      paramMethodVisitor.visitInsn(3);
      paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
      paramMethodVisitor.visitLabel(localLabel1);
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("size"));
      paramMethodVisitor.visitJumpInsn(162, localLabel2);
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitJumpInsn(153, localLabel3);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 44);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      paramMethodVisitor.visitLabel(localLabel3);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
      paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item"));
      localLabel3 = new Label();
      Label localLabel4 = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
      paramMethodVisitor.visitJumpInsn(199, localLabel4);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "()V");
      paramMethodVisitor.visitJumpInsn(167, localLabel3);
      paramMethodVisitor.visitLabel(localLabel4);
      localLabel4 = new Label();
      Label localLabel5 = new Label();
      if ((paramClass != null) && (Modifier.isPublic(paramClass.getModifiers())))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
        paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass)));
        paramMethodVisitor.visitJumpInsn(166, localLabel5);
        _getListFieldItemSer(paramContext, paramMethodVisitor, localFieldInfo, paramClass);
        paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_desc"));
        Label localLabel6 = new Label();
        Label localLabel7 = new Label();
        if (paramContext.writeDirect)
        {
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
          paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
          paramMethodVisitor.visitJumpInsn(153, localLabel6);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
          paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
          paramMethodVisitor.visitVarInsn(25, 1);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
          if (paramContext.nonContext)
          {
            paramMethodVisitor.visitInsn(1);
            label1883:
            paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass)));
            paramMethodVisitor.visitLdcInsn(Integer.valueOf(localFieldInfo.serialzeFeatures));
            paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeAsArrayNonContext", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            paramMethodVisitor.visitJumpInsn(167, localLabel7);
            paramMethodVisitor.visitLabel(localLabel6);
          }
        }
        else
        {
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_desc"));
          paramMethodVisitor.visitVarInsn(25, 1);
          paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
          if (!paramContext.nonContext) {
            break label2365;
          }
          paramMethodVisitor.visitInsn(1);
          label2027:
          paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass)));
          paramMethodVisitor.visitLdcInsn(Integer.valueOf(localFieldInfo.serialzeFeatures));
          paramMethodVisitor.visitMethodInsn(185, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          paramMethodVisitor.visitLabel(localLabel7);
          paramMethodVisitor.visitJumpInsn(167, localLabel4);
        }
      }
      else
      {
        paramMethodVisitor.visitLabel(localLabel5);
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item"));
        if (!paramContext.nonContext) {
          break label2399;
        }
        paramMethodVisitor.visitInsn(1);
        label2163:
        if ((paramClass == null) || (!Modifier.isPublic(paramClass.getModifiers()))) {
          break label2433;
        }
        paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject1)));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(localFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      }
      for (;;)
      {
        paramMethodVisitor.visitLabel(localLabel4);
        paramMethodVisitor.visitLabel(localLabel3);
        paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
        paramMethodVisitor.visitJumpInsn(167, localLabel1);
        paramMethodVisitor.visitLabel(localLabel2);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitVarInsn(16, 93);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
        paramMethodVisitor.visitLabel((Label)localObject2);
        break;
        paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        break label1883;
        label2365:
        paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        break label2027;
        label2399:
        paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
        paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        break label2163;
        label2433:
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
      }
    }
    paramClass = new Label();
    Object localObject2 = new Label();
    _get(paramMethodVisitor, paramContext, localFieldInfo);
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("field_" + localFieldInfo.fieldClass.getName()));
    paramMethodVisitor.visitJumpInsn(199, (Label)localObject2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeNull", "()V");
    paramMethodVisitor.visitJumpInsn(167, paramClass);
    paramMethodVisitor.visitLabel((Label)localObject2);
    localObject2 = new Label();
    Label localLabel1 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("field_" + localFieldInfo.fieldClass.getName()));
    paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject1)));
    paramMethodVisitor.visitJumpInsn(166, localLabel1);
    _getFieldSer(paramContext, paramMethodVisitor, localFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("fied_ser"));
    Label localLabel2 = new Label();
    Label localLabel3 = new Label();
    if ((paramContext.writeDirect) && (Modifier.isPublic(((Class)localObject1).getModifiers())))
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
      paramMethodVisitor.visitTypeInsn(193, JavaBeanSerializer);
      paramMethodVisitor.visitJumpInsn(153, localLabel2);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
      paramMethodVisitor.visitTypeInsn(192, JavaBeanSerializer);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("field_" + localFieldInfo.fieldClass.getName()));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject1)));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(localFieldInfo.serialzeFeatures));
      paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeAsArrayNonContext", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitJumpInsn(167, localLabel3);
      paramMethodVisitor.visitLabel(localLabel2);
    }
    paramMethodVisitor.visitVarInsn(25, paramContext.var("fied_ser"));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("field_" + localFieldInfo.fieldClass.getName()));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject1)));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(localFieldInfo.serialzeFeatures));
    paramMethodVisitor.visitMethodInsn(185, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
    paramMethodVisitor.visitLabel(localLabel3);
    paramMethodVisitor.visitJumpInsn(167, (Label)localObject2);
    paramMethodVisitor.visitLabel(localLabel1);
    Object localObject1 = localFieldInfo.getFormat();
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("field_" + localFieldInfo.fieldClass.getName()));
    if (localObject1 != null)
    {
      paramMethodVisitor.visitLdcInsn(localObject1);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
    }
    for (;;)
    {
      paramMethodVisitor.visitLabel((Label)localObject2);
      paramMethodVisitor.visitLabel(paramClass);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, j);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      break;
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      if (((localFieldInfo.fieldType instanceof Class)) && (((Class)localFieldInfo.fieldType).isPrimitive()))
      {
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
      }
      else
      {
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitFieldInsn(180, paramContext.className, localFieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(localFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      }
    }
  }
  
  private void generateWriteMethod(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo[] paramArrayOfFieldInfo, Context paramContext)
    throws Exception
  {
    Label localLabel1 = new Label();
    int k = paramArrayOfFieldInfo.length;
    Object localObject1;
    Object localObject2;
    int i;
    if (!paramContext.writeDirect)
    {
      localObject1 = new Label();
      localObject2 = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(154, (Label)localObject2);
      int m = paramArrayOfFieldInfo.length;
      int j = 0;
      i = 0;
      while (i < m)
      {
        if (paramArrayOfFieldInfo[i].method != null) {
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
        paramMethodVisitor.visitJumpInsn(153, (Label)localObject1);
        paramMethodVisitor.visitLabel((Label)localObject2);
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, 2);
        paramMethodVisitor.visitVarInsn(25, 3);
        paramMethodVisitor.visitVarInsn(25, 4);
        paramMethodVisitor.visitVarInsn(21, 5);
        paramMethodVisitor.visitMethodInsn(183, JavaBeanSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        paramMethodVisitor.visitInsn(177);
        paramMethodVisitor.visitLabel((Label)localObject1);
      }
    }
    else
    {
      if (!paramContext.nonContext)
      {
        localObject1 = new Label();
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, 2);
        paramMethodVisitor.visitVarInsn(21, 5);
        paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeReference", "(L" + JSONSerializer + ";Ljava/lang/Object;I)Z");
        paramMethodVisitor.visitJumpInsn(153, (Label)localObject1);
        paramMethodVisitor.visitInsn(177);
        paramMethodVisitor.visitLabel((Label)localObject1);
      }
      if (!paramContext.writeDirect) {
        break label1512;
      }
      if (!paramContext.nonContext) {
        break label1504;
      }
      localObject1 = "writeAsArrayNonContext";
      label468:
      if ((paramContext.beanInfo.features & SerializerFeature.BeanToArray.mask) != 0) {
        break label1520;
      }
      localObject2 = new Label();
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.BeanToArray.mask));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
      paramMethodVisitor.visitJumpInsn(153, (Label)localObject2);
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, 3);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(21, 5);
      paramMethodVisitor.visitMethodInsn(182, paramContext.className, (String)localObject1, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitInsn(177);
      paramMethodVisitor.visitLabel((Label)localObject2);
      label669:
      if (!paramContext.nonContext)
      {
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "getContext", "()" + SerialContext_desc);
        paramMethodVisitor.visitVarInsn(58, paramContext.var("parent"));
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, paramContext.var("parent"));
        paramMethodVisitor.visitVarInsn(25, 2);
        paramMethodVisitor.visitVarInsn(25, 3);
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramContext.beanInfo.features));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "setContext", "(" + SerialContext_desc + "Ljava/lang/Object;Ljava/lang/Object;I)V");
      }
      if (paramContext.writeDirect) {
        break label1629;
      }
      localObject1 = new Label();
      localObject2 = new Label();
      Label localLabel2 = new Label();
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
      paramMethodVisitor.visitJumpInsn(153, (Label)localObject2);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
      paramMethodVisitor.visitJumpInsn(165, (Label)localObject2);
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 123);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitMethodInsn(182, JavaBeanSerializer, "writeClassName", "(L" + JSONSerializer + ";Ljava/lang/Object;)V");
      paramMethodVisitor.visitVarInsn(16, 44);
      paramMethodVisitor.visitJumpInsn(167, (Label)localObject1);
      paramMethodVisitor.visitLabel((Label)localObject2);
      paramMethodVisitor.visitVarInsn(16, 123);
      paramMethodVisitor.visitLabel((Label)localObject1);
      label1148:
      paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
      if (!paramContext.writeDirect) {
        _before(paramMethodVisitor, paramContext);
      }
      if (!paramContext.writeDirect)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isNotWriteDefaultValue", "()Z");
        paramMethodVisitor.visitVarInsn(54, paramContext.var("notWriteDefaultValue"));
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "checkValue", "(" + SerializeFilterable_desc + ")Z");
        paramMethodVisitor.visitVarInsn(54, paramContext.var("checkValue"));
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "hasNameFilters", "(" + SerializeFilterable_desc + ")Z");
        paramMethodVisitor.visitVarInsn(54, paramContext.var("hasNameFilters"));
      }
      i = 0;
      label1393:
      if (i >= k) {
        break label1862;
      }
      localObject1 = paramArrayOfFieldInfo[i];
      localObject2 = ((FieldInfo)localObject1).fieldClass;
      paramMethodVisitor.visitLdcInsn(((FieldInfo)localObject1).name);
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      if ((localObject2 != Byte.TYPE) && (localObject2 != Short.TYPE) && (localObject2 != Integer.TYPE)) {
        break label1642;
      }
      _int(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext, paramContext.var(((Class)localObject2).getName()), 'I');
    }
    for (;;)
    {
      i += 1;
      break label1393;
      paramMethodVisitor.visitJumpInsn(167, (Label)localObject1);
      break;
      label1504:
      localObject1 = "writeAsArray";
      break label468;
      label1512:
      localObject1 = "writeAsArrayNormal";
      break label468;
      label1520:
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, 3);
      paramMethodVisitor.visitVarInsn(25, 4);
      paramMethodVisitor.visitVarInsn(21, 5);
      paramMethodVisitor.visitMethodInsn(182, paramContext.className, (String)localObject1, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      paramMethodVisitor.visitInsn(177);
      break label669;
      label1629:
      paramMethodVisitor.visitVarInsn(16, 123);
      break label1148;
      label1642:
      if (localObject2 == Long.TYPE) {
        _long(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else if (localObject2 == Float.TYPE) {
        _float(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else if (localObject2 == Double.TYPE) {
        _double(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else if (localObject2 == Boolean.TYPE) {
        _int(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext, paramContext.var("boolean"), 'Z');
      } else if (localObject2 == Character.TYPE) {
        _int(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext, paramContext.var("char"), 'C');
      } else if (localObject2 == String.class) {
        _string(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else if (localObject2 == BigDecimal.class) {
        _decimal(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else if (List.class.isAssignableFrom((Class)localObject2)) {
        _list(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else if (((Class)localObject2).isEnum()) {
        _enum(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      } else {
        _object(paramClass, paramMethodVisitor, (FieldInfo)localObject1, paramContext);
      }
    }
    label1862:
    if (!paramContext.writeDirect) {
      _after(paramMethodVisitor, paramContext);
    }
    paramClass = new Label();
    paramArrayOfFieldInfo = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitIntInsn(16, 123);
    paramMethodVisitor.visitJumpInsn(160, paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 123);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(paramClass);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 125);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(paramArrayOfFieldInfo);
    paramMethodVisitor.visitLabel(localLabel1);
    if (!paramContext.nonContext)
    {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("parent"));
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "setContext", "(" + SerialContext_desc + ")V");
    }
  }
  
  public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo paramSerializeBeanInfo)
    throws Exception
  {
    Class localClass = paramSerializeBeanInfo.beanType;
    if (localClass.isPrimitive()) {
      throw new d("unsupportd class " + localClass.getName());
    }
    Object localObject3 = (JSONType)localClass.getAnnotation(JSONType.class);
    Object localObject2 = paramSerializeBeanInfo.fields;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = localObject2[i];
      if ((((FieldInfo)localObject1).field == null) && (((FieldInfo)localObject1).method != null) && (((FieldInfo)localObject1).method.getDeclaringClass().isInterface())) {
        return new JavaBeanSerializer(localClass);
      }
      i += 1;
    }
    FieldInfo[] arrayOfFieldInfo = paramSerializeBeanInfo.sortedFields;
    if (paramSerializeBeanInfo.sortedFields == paramSerializeBeanInfo.fields) {}
    for (i = 1; arrayOfFieldInfo.length > 256; i = 0) {
      return new JavaBeanSerializer(localClass);
    }
    int k = arrayOfFieldInfo.length;
    j = 0;
    while (j < k)
    {
      if (!ASMUtils.checkName(arrayOfFieldInfo[j].getMember().getName())) {
        return new JavaBeanSerializer(localClass);
      }
      j += 1;
    }
    Object localObject1 = "ASMSerializer_" + this.seed.incrementAndGet() + "_" + localClass.getSimpleName();
    String str2 = ASMSerializerFactory.class.getPackage().getName();
    String str1 = str2.replace('.', '/') + "/" + (String)localObject1;
    str2 = str2 + "." + (String)localObject1;
    ClassWriter localClassWriter = new ClassWriter();
    localClassWriter.visit(49, 33, str1, JavaBeanSerializer, new String[] { ObjectSerializer });
    k = arrayOfFieldInfo.length;
    j = 0;
    if (j < k)
    {
      localObject1 = arrayOfFieldInfo[j];
      if ((((FieldInfo)localObject1).fieldClass.isPrimitive()) || (((FieldInfo)localObject1).fieldClass.isEnum()) || (((FieldInfo)localObject1).fieldClass == String.class)) {}
      for (;;)
      {
        j += 1;
        break;
        new FieldWriter(localClassWriter, 1, ((FieldInfo)localObject1).name + "_asm_fieldType", "Ljava/lang/reflect/Type;").visitEnd();
        if (List.class.isAssignableFrom(((FieldInfo)localObject1).fieldClass)) {
          new FieldWriter(localClassWriter, 1, ((FieldInfo)localObject1).name + "_asm_list_item_ser_", ObjectSerializer_desc).visitEnd();
        }
        new FieldWriter(localClassWriter, 1, ((FieldInfo)localObject1).name + "_asm_ser_", ObjectSerializer_desc).visitEnd();
      }
    }
    localObject1 = new MethodWriter(localClassWriter, 1, "<init>", "(" + ASMUtils.desc(SerializeBeanInfo.class) + ")V", null, null);
    ((MethodVisitor)localObject1).visitVarInsn(25, 0);
    ((MethodVisitor)localObject1).visitVarInsn(25, 1);
    ((MethodVisitor)localObject1).visitMethodInsn(183, JavaBeanSerializer, "<init>", "(" + ASMUtils.desc(SerializeBeanInfo.class) + ")V");
    j = 0;
    Object localObject4;
    while (j < arrayOfFieldInfo.length)
    {
      localObject4 = arrayOfFieldInfo[j];
      if ((((FieldInfo)localObject4).fieldClass.isPrimitive()) || (((FieldInfo)localObject4).fieldClass.isEnum()) || (((FieldInfo)localObject4).fieldClass == String.class))
      {
        j += 1;
      }
      else
      {
        ((MethodVisitor)localObject1).visitVarInsn(25, 0);
        if (((FieldInfo)localObject4).method != null)
        {
          ((MethodVisitor)localObject1).visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(((FieldInfo)localObject4).declaringClass)));
          ((MethodVisitor)localObject1).visitLdcInsn(((FieldInfo)localObject4).method.getName());
          ((MethodVisitor)localObject1).visitMethodInsn(184, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
        }
        for (;;)
        {
          ((MethodVisitor)localObject1).visitFieldInsn(181, str1, ((FieldInfo)localObject4).name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
          break;
          ((MethodVisitor)localObject1).visitVarInsn(25, 0);
          ((MethodVisitor)localObject1).visitLdcInsn(Integer.valueOf(j));
          ((MethodVisitor)localObject1).visitMethodInsn(183, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
      }
    }
    ((MethodVisitor)localObject1).visitInsn(177);
    ((MethodVisitor)localObject1).visitMaxs(4, 4);
    ((MethodVisitor)localObject1).visitEnd();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject3 != null)
    {
      localObject1 = ((JSONType)localObject3).serialzeFeatures();
      k = localObject1.length;
      j = 0;
      bool1 = bool2;
      if (j < k)
      {
        if (localObject1[j] != SerializerFeature.DisableCircularReferenceDetect) {
          break label1818;
        }
        bool1 = true;
      }
    }
    j = 0;
    label967:
    boolean bool3;
    if (j < 3)
    {
      bool2 = false;
      if (j == 0)
      {
        localObject1 = "write";
        bool2 = true;
        bool3 = bool1;
      }
      for (;;)
      {
        localObject4 = new Context(arrayOfFieldInfo, paramSerializeBeanInfo, str1, bool2, bool3);
        localObject1 = new MethodWriter(localClassWriter, 1, (String)localObject1, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[] { "java/io/IOException" });
        ((MethodVisitor)localObject1).visitVarInsn(25, 1);
        ((MethodVisitor)localObject1).visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
        ((MethodVisitor)localObject1).visitVarInsn(58, ((Context)localObject4).var("out"));
        Label localLabel1;
        if ((i == 0) && (!((Context)localObject4).writeDirect) && ((localObject3 == null) || (((JSONType)localObject3).alphabetic())))
        {
          localLabel1 = new Label();
          ((MethodVisitor)localObject1).visitVarInsn(25, ((Context)localObject4).var("out"));
          ((MethodVisitor)localObject1).visitMethodInsn(182, SerializeWriter, "isSortField", "()Z");
          ((MethodVisitor)localObject1).visitJumpInsn(154, localLabel1);
          ((MethodVisitor)localObject1).visitVarInsn(25, 0);
          ((MethodVisitor)localObject1).visitVarInsn(25, 1);
          ((MethodVisitor)localObject1).visitVarInsn(25, 2);
          ((MethodVisitor)localObject1).visitVarInsn(25, 3);
          ((MethodVisitor)localObject1).visitVarInsn(25, 4);
          ((MethodVisitor)localObject1).visitVarInsn(21, 5);
          ((MethodVisitor)localObject1).visitMethodInsn(182, str1, "writeUnsorted", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          ((MethodVisitor)localObject1).visitInsn(177);
          ((MethodVisitor)localObject1).visitLabel(localLabel1);
        }
        if ((((Context)localObject4).writeDirect) && (!bool3))
        {
          localLabel1 = new Label();
          Label localLabel2 = new Label();
          ((MethodVisitor)localObject1).visitVarInsn(25, 0);
          ((MethodVisitor)localObject1).visitVarInsn(25, 1);
          ((MethodVisitor)localObject1).visitMethodInsn(182, JavaBeanSerializer, "writeDirect", "(L" + JSONSerializer + ";)Z");
          ((MethodVisitor)localObject1).visitJumpInsn(154, localLabel2);
          ((MethodVisitor)localObject1).visitVarInsn(25, 0);
          ((MethodVisitor)localObject1).visitVarInsn(25, 1);
          ((MethodVisitor)localObject1).visitVarInsn(25, 2);
          ((MethodVisitor)localObject1).visitVarInsn(25, 3);
          ((MethodVisitor)localObject1).visitVarInsn(25, 4);
          ((MethodVisitor)localObject1).visitVarInsn(21, 5);
          ((MethodVisitor)localObject1).visitMethodInsn(182, str1, "writeNormal", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          ((MethodVisitor)localObject1).visitInsn(177);
          ((MethodVisitor)localObject1).visitLabel(localLabel2);
          ((MethodVisitor)localObject1).visitVarInsn(25, ((Context)localObject4).var("out"));
          ((MethodVisitor)localObject1).visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
          ((MethodVisitor)localObject1).visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
          ((MethodVisitor)localObject1).visitJumpInsn(153, localLabel1);
          ((MethodVisitor)localObject1).visitVarInsn(25, 0);
          ((MethodVisitor)localObject1).visitVarInsn(25, 1);
          ((MethodVisitor)localObject1).visitVarInsn(25, 2);
          ((MethodVisitor)localObject1).visitVarInsn(25, 3);
          ((MethodVisitor)localObject1).visitVarInsn(25, 4);
          ((MethodVisitor)localObject1).visitVarInsn(21, 5);
          ((MethodVisitor)localObject1).visitMethodInsn(182, str1, "writeDirectNonContext", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          ((MethodVisitor)localObject1).visitInsn(177);
          ((MethodVisitor)localObject1).visitLabel(localLabel1);
        }
        ((MethodVisitor)localObject1).visitVarInsn(25, 2);
        ((MethodVisitor)localObject1).visitTypeInsn(192, ASMUtils.type(localClass));
        ((MethodVisitor)localObject1).visitVarInsn(58, ((Context)localObject4).var("entity"));
        generateWriteMethod(localClass, (MethodVisitor)localObject1, arrayOfFieldInfo, (Context)localObject4);
        ((MethodVisitor)localObject1).visitInsn(177);
        ((MethodVisitor)localObject1).visitMaxs(7, ((Context)localObject4).variantIndex + 2);
        ((MethodVisitor)localObject1).visitEnd();
        j += 1;
        break label967;
        label1818:
        j += 1;
        break;
        if (j == 1)
        {
          localObject1 = "writeNormal";
          bool3 = bool1;
        }
        else
        {
          bool2 = true;
          bool3 = true;
          localObject1 = "writeDirectNonContext";
        }
      }
    }
    if (i == 0)
    {
      localObject1 = new Context(arrayOfFieldInfo, paramSerializeBeanInfo, str1, false, bool1);
      localObject3 = new MethodWriter(localClassWriter, 1, "writeUnsorted", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[] { "java/io/IOException" });
      ((MethodVisitor)localObject3).visitVarInsn(25, 1);
      ((MethodVisitor)localObject3).visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
      ((MethodVisitor)localObject3).visitVarInsn(58, ((Context)localObject1).var("out"));
      ((MethodVisitor)localObject3).visitVarInsn(25, 2);
      ((MethodVisitor)localObject3).visitTypeInsn(192, ASMUtils.type(localClass));
      ((MethodVisitor)localObject3).visitVarInsn(58, ((Context)localObject1).var("entity"));
      generateWriteMethod(localClass, (MethodVisitor)localObject3, (FieldInfo[])localObject2, (Context)localObject1);
      ((MethodVisitor)localObject3).visitInsn(177);
      ((MethodVisitor)localObject3).visitMaxs(7, ((Context)localObject1).variantIndex + 2);
      ((MethodVisitor)localObject3).visitEnd();
    }
    i = 0;
    if (i < 3)
    {
      bool2 = false;
      if (i == 0)
      {
        localObject1 = "writeAsArray";
        bool2 = true;
        bool3 = bool1;
      }
      for (;;)
      {
        localObject2 = new Context(arrayOfFieldInfo, paramSerializeBeanInfo, str1, bool2, bool3);
        localObject1 = new MethodWriter(localClassWriter, 1, (String)localObject1, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[] { "java/io/IOException" });
        ((MethodVisitor)localObject1).visitVarInsn(25, 1);
        ((MethodVisitor)localObject1).visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
        ((MethodVisitor)localObject1).visitVarInsn(58, ((Context)localObject2).var("out"));
        ((MethodVisitor)localObject1).visitVarInsn(25, 2);
        ((MethodVisitor)localObject1).visitTypeInsn(192, ASMUtils.type(localClass));
        ((MethodVisitor)localObject1).visitVarInsn(58, ((Context)localObject2).var("entity"));
        generateWriteAsArray(localClass, (MethodVisitor)localObject1, arrayOfFieldInfo, (Context)localObject2);
        ((MethodVisitor)localObject1).visitInsn(177);
        ((MethodVisitor)localObject1).visitMaxs(7, ((Context)localObject2).variantIndex + 2);
        ((MethodVisitor)localObject1).visitEnd();
        i += 1;
        break;
        if (i == 1)
        {
          localObject1 = "writeAsArrayNormal";
          bool3 = bool1;
        }
        else
        {
          bool2 = true;
          bool3 = true;
          localObject1 = "writeAsArrayNonContext";
        }
      }
    }
    localObject1 = localClassWriter.toByteArray();
    return (JavaBeanSerializer)this.classLoader.defineClassPublic(str2, (byte[])localObject1, 0, localObject1.length).getConstructor(new Class[] { SerializeBeanInfo.class }).newInstance(new Object[] { paramSerializeBeanInfo });
  }
  
  static class Context
  {
    static final int features = 5;
    static int fieldName = 6;
    static final int obj = 2;
    static int original = 7;
    static final int paramFieldName = 3;
    static final int paramFieldType = 4;
    static int processValue = 8;
    static final int serializer = 1;
    private final SerializeBeanInfo beanInfo;
    private final String className;
    private final FieldInfo[] getters;
    private boolean nonContext;
    private int variantIndex = 9;
    private Map<String, Integer> variants = new HashMap();
    private final boolean writeDirect;
    
    public Context(FieldInfo[] paramArrayOfFieldInfo, SerializeBeanInfo paramSerializeBeanInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.getters = paramArrayOfFieldInfo;
      this.className = paramString;
      this.beanInfo = paramSerializeBeanInfo;
      this.writeDirect = paramBoolean1;
      this.nonContext = paramBoolean2;
    }
    
    public int getFieldOrinal(String paramString)
    {
      int i = 0;
      int j = this.getters.length;
      while (i < j)
      {
        if (this.getters[i].name.equals(paramString)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    public int var(String paramString)
    {
      if ((Integer)this.variants.get(paramString) == null)
      {
        Map localMap = this.variants;
        int i = this.variantIndex;
        this.variantIndex = (i + 1);
        localMap.put(paramString, Integer.valueOf(i));
      }
      return ((Integer)this.variants.get(paramString)).intValue();
    }
    
    public int var(String paramString, int paramInt)
    {
      if ((Integer)this.variants.get(paramString) == null)
      {
        this.variants.put(paramString, Integer.valueOf(this.variantIndex));
        this.variantIndex += paramInt;
      }
      return ((Integer)this.variants.get(paramString)).intValue();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ASMSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */