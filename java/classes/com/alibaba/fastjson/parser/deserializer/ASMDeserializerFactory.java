package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory
  implements Opcodes
{
  static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
  static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
  public final ASMClassLoader classLoader;
  protected final AtomicLong seed = new AtomicLong();
  
  public ASMDeserializerFactory(ClassLoader paramClassLoader)
  {
    if ((paramClassLoader instanceof ASMClassLoader)) {}
    for (paramClassLoader = (ASMClassLoader)paramClassLoader;; paramClassLoader = new ASMClassLoader(paramClassLoader))
    {
      this.classLoader = paramClassLoader;
      return;
    }
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    _batchSet(paramContext, paramMethodVisitor, true);
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor, boolean paramBoolean)
  {
    int i = 0;
    int j = paramContext.fieldInfoList.length;
    while (i < j)
    {
      Label localLabel = new Label();
      if (paramBoolean) {
        _isFlag(paramMethodVisitor, paramContext, i, localLabel);
      }
      _loadAndSet(paramContext, paramMethodVisitor, paramContext.fieldInfoList[i]);
      if (paramBoolean) {
        paramMethodVisitor.visitLabel(localLabel);
      }
      i += 1;
    }
  }
  
  private void _createInstance(ClassWriter paramClassWriter, Context paramContext)
  {
    if (!Modifier.isPublic(paramContext.beanInfo.defaultConstructor.getModifiers())) {
      return;
    }
    paramClassWriter = new MethodWriter(paramClassWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
    paramClassWriter.visitTypeInsn(187, ASMUtils.type(paramContext.getInstClass()));
    paramClassWriter.visitInsn(89);
    paramClassWriter.visitMethodInsn(183, ASMUtils.type(paramContext.getInstClass()), "<init>", "()V");
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitMaxs(3, 3);
    paramClassWriter.visitEnd();
  }
  
  private void _createInstance(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    Constructor localConstructor = paramContext.beanInfo.defaultConstructor;
    if (Modifier.isPublic(localConstructor.getModifiers()))
    {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(paramContext.getInstClass()));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(localConstructor.getDeclaringClass()), "<init>", "()V");
      paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
      return;
    }
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
    paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramContext.getInstClass()));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
  }
  
  private void _deserObject(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt)
  {
    _getFieldDeser(paramContext, paramMethodVisitor, paramFieldInfo);
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    if ((paramFieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0)
    {
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
      paramMethodVisitor.visitJumpInsn(153, localLabel1);
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
      paramMethodVisitor.visitVarInsn(25, 1);
      if ((paramFieldInfo.fieldType instanceof Class))
      {
        paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
        paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.parserFeatures));
        paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
        paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
        paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.name + "_asm"));
        paramMethodVisitor.visitJumpInsn(167, localLabel2);
        paramMethodVisitor.visitLabel(localLabel1);
      }
    }
    else
    {
      paramMethodVisitor.visitVarInsn(25, 1);
      if (!(paramFieldInfo.fieldType instanceof Class)) {
        break label438;
      }
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    }
    for (;;)
    {
      paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
      paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.name + "_asm"));
      paramMethodVisitor.visitLabel(localLabel2);
      return;
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
      break;
      label438:
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
    }
  }
  
  private void _deserialize_endCheck(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel)
  {
    paramMethodVisitor.visitIntInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitJumpInsn(158, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(13));
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _quickNextTokenComma(paramContext, paramMethodVisitor);
  }
  
  private void _deserialze(ClassWriter paramClassWriter, Context paramContext)
  {
    if (paramContext.fieldInfoList.length == 0) {
      return;
    }
    Object localObject1 = paramContext.fieldInfoList;
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label100;
      }
      localObject3 = localObject1[i];
      localObject2 = ((FieldInfo)localObject3).fieldClass;
      localObject3 = ((FieldInfo)localObject3).fieldType;
      if ((localObject2 == Character.TYPE) || ((Collection.class.isAssignableFrom((Class)localObject2)) && ((!(localObject3 instanceof ParameterizedType)) || (!(((ParameterizedType)localObject3).getActualTypeArguments()[0] instanceof Class))))) {
        break;
      }
      i += 1;
    }
    label100:
    Object localObject4 = paramContext.beanInfo;
    Context.access$202(paramContext, ((JavaBeanInfo)localObject4).sortedFields);
    paramClassWriter = new MethodWriter(paramClassWriter, 1, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
    localObject1 = new Label();
    Object localObject2 = new Label();
    Object localObject3 = new Label();
    Label localLabel = new Label();
    defineVarLexer(paramContext, paramClassWriter);
    Object localObject5 = new Label();
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramClassWriter.visitLdcInsn(Integer.valueOf(14));
    paramClassWriter.visitJumpInsn(160, (Label)localObject5);
    if ((((JavaBeanInfo)localObject4).parserFeatures & Feature.SupportArrayToBean.mask) == 0)
    {
      paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
      paramClassWriter.visitVarInsn(21, 4);
      paramClassWriter.visitLdcInsn(Integer.valueOf(Feature.SupportArrayToBean.mask));
      paramClassWriter.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(II)Z");
      paramClassWriter.visitJumpInsn(153, (Label)localObject5);
    }
    paramClassWriter.visitVarInsn(25, 0);
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitVarInsn(25, 2);
    paramClassWriter.visitVarInsn(25, 3);
    paramClassWriter.visitInsn(1);
    paramClassWriter.visitMethodInsn(183, paramContext.className, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitLabel((Label)localObject5);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(Integer.valueOf(Feature.SortFeidFastMatch.mask));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(I)Z");
    paramClassWriter.visitJumpInsn(153, (Label)localObject2);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(paramContext.clazz.getName());
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanType", "(Ljava/lang/String;)I");
    paramClassWriter.visitLdcInsn(Integer.valueOf(-1));
    paramClassWriter.visitJumpInsn(159, (Label)localObject2);
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitMethodInsn(182, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
    paramClassWriter.visitVarInsn(58, paramContext.var("mark_context"));
    paramClassWriter.visitInsn(3);
    paramClassWriter.visitVarInsn(54, paramContext.var("matchedCount"));
    _createInstance(paramContext, paramClassWriter);
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitMethodInsn(182, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
    paramClassWriter.visitVarInsn(58, paramContext.var("context"));
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitVarInsn(25, paramContext.var("context"));
    paramClassWriter.visitVarInsn(25, paramContext.var("instance"));
    paramClassWriter.visitVarInsn(25, 3);
    paramClassWriter.visitMethodInsn(182, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
    paramClassWriter.visitVarInsn(58, paramContext.var("childContext"));
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
    paramClassWriter.visitLdcInsn(Integer.valueOf(4));
    paramClassWriter.visitJumpInsn(159, (Label)localObject3);
    paramClassWriter.visitInsn(3);
    paramClassWriter.visitIntInsn(54, paramContext.var("matchStat"));
    j = paramContext.fieldInfoList.length;
    i = 0;
    while (i < j)
    {
      paramClassWriter.visitInsn(3);
      paramClassWriter.visitVarInsn(54, paramContext.var("_asm_flag_" + i / 32));
      i += 32;
    }
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(I)Z");
    paramClassWriter.visitIntInsn(54, paramContext.var("initStringFieldAsEmpty"));
    i = 0;
    label1310:
    Object localObject6;
    Object localObject7;
    if (i < j)
    {
      localObject4 = paramContext.fieldInfoList[i];
      localObject5 = ((FieldInfo)localObject4).fieldClass;
      if ((localObject5 == Boolean.TYPE) || (localObject5 == Byte.TYPE) || (localObject5 == Short.TYPE) || (localObject5 == Integer.TYPE))
      {
        paramClassWriter.visitInsn(3);
        paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject4).name + "_asm"));
      }
      for (;;)
      {
        i += 1;
        break;
        if (localObject5 == Long.TYPE)
        {
          paramClassWriter.visitInsn(9);
          paramClassWriter.visitVarInsn(55, paramContext.var(((FieldInfo)localObject4).name + "_asm", 2));
        }
        else if (localObject5 == Float.TYPE)
        {
          paramClassWriter.visitInsn(11);
          paramClassWriter.visitVarInsn(56, paramContext.var(((FieldInfo)localObject4).name + "_asm"));
        }
        else
        {
          if (localObject5 != Double.TYPE) {
            break label1310;
          }
          paramClassWriter.visitInsn(14);
          paramClassWriter.visitVarInsn(57, paramContext.var(((FieldInfo)localObject4).name + "_asm", 2));
        }
      }
      if (localObject5 == String.class)
      {
        localObject6 = new Label();
        localObject7 = new Label();
        paramClassWriter.visitVarInsn(21, paramContext.var("initStringFieldAsEmpty"));
        paramClassWriter.visitJumpInsn(153, (Label)localObject7);
        _setFlag(paramClassWriter, paramContext, i);
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitMethodInsn(182, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
        paramClassWriter.visitJumpInsn(167, (Label)localObject6);
        paramClassWriter.visitLabel((Label)localObject7);
        paramClassWriter.visitInsn(1);
        paramClassWriter.visitLabel((Label)localObject6);
      }
      for (;;)
      {
        paramClassWriter.visitTypeInsn(192, ASMUtils.type((Class)localObject5));
        paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject4).name + "_asm"));
        break;
        paramClassWriter.visitInsn(1);
      }
    }
    i = 0;
    if (i < j)
    {
      localObject5 = paramContext.fieldInfoList[i];
      localObject6 = ((FieldInfo)localObject5).fieldClass;
      localObject7 = ((FieldInfo)localObject5).fieldType;
      localObject4 = new Label();
      if (localObject6 == Boolean.TYPE)
      {
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitVarInsn(25, 0);
        paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
        paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldBoolean", "([C)Z");
        paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
        label1660:
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        localObject5 = new Label();
        paramClassWriter.visitJumpInsn(158, (Label)localObject5);
        _setFlag(paramClassWriter, paramContext, i);
        paramClassWriter.visitLabel((Label)localObject5);
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        paramClassWriter.visitInsn(89);
        paramClassWriter.visitVarInsn(54, paramContext.var("matchStat"));
        paramClassWriter.visitLdcInsn(Integer.valueOf(-1));
        paramClassWriter.visitJumpInsn(159, (Label)localObject1);
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        paramClassWriter.visitJumpInsn(158, (Label)localObject4);
        paramClassWriter.visitVarInsn(21, paramContext.var("matchedCount"));
        paramClassWriter.visitInsn(4);
        paramClassWriter.visitInsn(96);
        paramClassWriter.visitVarInsn(54, paramContext.var("matchedCount"));
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        paramClassWriter.visitLdcInsn(Integer.valueOf(4));
        paramClassWriter.visitJumpInsn(159, localLabel);
        paramClassWriter.visitLabel((Label)localObject4);
        if (i == j - 1)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
          paramClassWriter.visitLdcInsn(Integer.valueOf(4));
          paramClassWriter.visitJumpInsn(160, (Label)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localObject6 == Byte.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
          paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == Short.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
          paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == Integer.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
          paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == Long.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldLong", "([C)J");
          paramClassWriter.visitVarInsn(55, paramContext.var(((FieldInfo)localObject5).name + "_asm", 2));
          break label1660;
        }
        if (localObject6 == Float.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloat", "([C)F");
          paramClassWriter.visitVarInsn(56, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == Double.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldDouble", "([C)D");
          paramClassWriter.visitVarInsn(57, paramContext.var(((FieldInfo)localObject5).name + "_asm", 2));
          break label1660;
        }
        if (localObject6 == String.class)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
          paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == int[].class)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldIntArray", "([C)[I");
          paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == float[].class)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloatArray", "([C)[F");
          paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (localObject6 == float[][].class)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloatArray2", "([C)[[F");
          paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (((Class)localObject6).isEnum())
        {
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          _getFieldDeser(paramContext, paramClassWriter, (FieldInfo)localObject5);
          paramClassWriter.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", "(L" + JSONLexerBase + ";[C" + ASMUtils.desc(ObjectDeserializer.class) + ")Ljava/lang/Enum;");
          paramClassWriter.visitTypeInsn(192, ASMUtils.type((Class)localObject6));
          paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
          break label1660;
        }
        if (Collection.class.isAssignableFrom((Class)localObject6))
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(25, 0);
          paramClassWriter.visitFieldInsn(180, paramContext.className, ((FieldInfo)localObject5).name + "_asm_prefix__", "[C");
          localObject7 = TypeUtils.getCollectionItemClass((java.lang.reflect.Type)localObject7);
          if (localObject7 == String.class)
          {
            paramClassWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject6)));
            paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.desc(Collection.class));
            paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).name + "_asm"));
            break label1660;
          }
          _deserialze_list_obj(paramContext, paramClassWriter, (Label)localObject1, (FieldInfo)localObject5, (Class)localObject6, (Class)localObject7, i);
          if (i != j - 1) {
            continue;
          }
          _deserialize_endCheck(paramContext, paramClassWriter, (Label)localObject1);
          continue;
        }
        _deserialze_obj(paramContext, paramClassWriter, (Label)localObject1, (FieldInfo)localObject5, (Class)localObject6, i);
        if (i == j - 1) {
          _deserialize_endCheck(paramContext, paramClassWriter, (Label)localObject1);
        }
      }
    }
    paramClassWriter.visitLabel(localLabel);
    if ((!paramContext.clazz.isInterface()) && (!Modifier.isAbstract(paramContext.clazz.getModifiers()))) {
      _batchSet(paramContext, paramClassWriter);
    }
    paramClassWriter.visitLabel((Label)localObject3);
    _setContext(paramContext, paramClassWriter);
    paramClassWriter.visitVarInsn(25, paramContext.var("instance"));
    localObject3 = paramContext.beanInfo.buildMethod;
    if (localObject3 != null) {
      paramClassWriter.visitMethodInsn(182, ASMUtils.type(paramContext.getInstClass()), ((Method)localObject3).getName(), "()" + ASMUtils.desc(((Method)localObject3).getReturnType()));
    }
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitLabel((Label)localObject1);
    _batchSet(paramContext, paramClassWriter);
    paramClassWriter.visitVarInsn(25, 0);
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitVarInsn(25, 2);
    paramClassWriter.visitVarInsn(25, 3);
    paramClassWriter.visitVarInsn(25, paramContext.var("instance"));
    paramClassWriter.visitVarInsn(21, 4);
    paramClassWriter.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "parseRest", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
    paramClassWriter.visitTypeInsn(192, ASMUtils.type(paramContext.clazz));
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitLabel((Label)localObject2);
    paramClassWriter.visitVarInsn(25, 0);
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitVarInsn(25, 2);
    paramClassWriter.visitVarInsn(25, 3);
    paramClassWriter.visitVarInsn(21, 4);
    paramClassWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitMaxs(6, paramContext.variantIndex);
    paramClassWriter.visitEnd();
  }
  
  private void _deserialzeArrayMapping(ClassWriter paramClassWriter, Context paramContext)
  {
    paramClassWriter = new MethodWriter(paramClassWriter, 1, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
    defineVarLexer(paramContext, paramClassWriter);
    _createInstance(paramContext, paramClassWriter);
    Object localObject1 = paramContext.beanInfo.sortedFields;
    int m = localObject1.length;
    int i = 0;
    if (i < m)
    {
      int j;
      label87:
      int k;
      if (i == m - 1)
      {
        j = 1;
        if (j == 0) {
          break label230;
        }
        k = 93;
        label96:
        localObject2 = localObject1[i];
        localObject3 = ((FieldInfo)localObject2).fieldClass;
        localObject4 = ((FieldInfo)localObject2).fieldType;
        if ((localObject3 != Byte.TYPE) && (localObject3 != Short.TYPE) && (localObject3 != Integer.TYPE)) {
          break label237;
        }
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitVarInsn(16, k);
        paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
        paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label87;
        label230:
        k = 44;
        break label96;
        label237:
        if (localObject3 == Long.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(16, k);
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
          paramClassWriter.visitVarInsn(55, paramContext.var(((FieldInfo)localObject2).name + "_asm", 2));
        }
        else if (localObject3 == Boolean.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(16, k);
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
          paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
        }
        else if (localObject3 == Float.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(16, k);
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
          paramClassWriter.visitVarInsn(56, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
        }
        else if (localObject3 == Double.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(16, k);
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
          paramClassWriter.visitVarInsn(57, paramContext.var(((FieldInfo)localObject2).name + "_asm", 2));
        }
        else if (localObject3 == Character.TYPE)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(16, k);
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
          paramClassWriter.visitInsn(3);
          paramClassWriter.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
          paramClassWriter.visitVarInsn(54, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
        }
        else if (localObject3 == String.class)
        {
          paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
          paramClassWriter.visitVarInsn(16, k);
          paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
          paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
        }
        else
        {
          Label localLabel2;
          if (((Class)localObject3).isEnum())
          {
            localObject4 = new Label();
            localLabel1 = new Label();
            localLabel2 = new Label();
            Label localLabel3 = new Label();
            paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
            paramClassWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
            paramClassWriter.visitInsn(89);
            paramClassWriter.visitVarInsn(54, paramContext.var("ch"));
            paramClassWriter.visitLdcInsn(Integer.valueOf(110));
            paramClassWriter.visitJumpInsn(159, localLabel3);
            paramClassWriter.visitVarInsn(21, paramContext.var("ch"));
            paramClassWriter.visitLdcInsn(Integer.valueOf(34));
            paramClassWriter.visitJumpInsn(160, (Label)localObject4);
            paramClassWriter.visitLabel(localLabel3);
            paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
            paramClassWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject3)));
            paramClassWriter.visitVarInsn(25, 1);
            paramClassWriter.visitMethodInsn(182, DefaultJSONParser, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
            paramClassWriter.visitVarInsn(16, k);
            paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc(SymbolTable.class) + "C)Ljava/lang/Enum;");
            paramClassWriter.visitJumpInsn(167, localLabel2);
            paramClassWriter.visitLabel((Label)localObject4);
            paramClassWriter.visitVarInsn(21, paramContext.var("ch"));
            paramClassWriter.visitLdcInsn(Integer.valueOf(48));
            paramClassWriter.visitJumpInsn(161, localLabel1);
            paramClassWriter.visitVarInsn(21, paramContext.var("ch"));
            paramClassWriter.visitLdcInsn(Integer.valueOf(57));
            paramClassWriter.visitJumpInsn(163, localLabel1);
            _getFieldDeser(paramContext, paramClassWriter, (FieldInfo)localObject2);
            paramClassWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
            paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
            paramClassWriter.visitVarInsn(16, k);
            paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
            paramClassWriter.visitMethodInsn(182, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
            paramClassWriter.visitJumpInsn(167, localLabel2);
            paramClassWriter.visitLabel(localLabel1);
            paramClassWriter.visitVarInsn(25, 0);
            paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
            paramClassWriter.visitVarInsn(16, k);
            paramClassWriter.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", "(L" + JSONLexerBase + ";C)Ljava/lang/Enum;");
            paramClassWriter.visitLabel(localLabel2);
            paramClassWriter.visitTypeInsn(192, ASMUtils.type((Class)localObject3));
            paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
          }
          else
          {
            if (Collection.class.isAssignableFrom((Class)localObject3))
            {
              localObject4 = TypeUtils.getCollectionItemClass((java.lang.reflect.Type)localObject4);
              if (localObject4 == String.class)
              {
                if ((localObject3 == List.class) || (localObject3 == Collections.class) || (localObject3 == ArrayList.class))
                {
                  paramClassWriter.visitTypeInsn(187, ASMUtils.type(ArrayList.class));
                  paramClassWriter.visitInsn(89);
                  paramClassWriter.visitMethodInsn(183, ASMUtils.type(ArrayList.class), "<init>", "()V");
                }
                for (;;)
                {
                  paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
                  paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
                  paramClassWriter.visitVarInsn(25, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
                  paramClassWriter.visitVarInsn(16, k);
                  paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanStringArray", "(Ljava/util/Collection;C)V");
                  localObject3 = new Label();
                  paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
                  paramClassWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                  paramClassWriter.visitLdcInsn(Integer.valueOf(5));
                  paramClassWriter.visitJumpInsn(160, (Label)localObject3);
                  paramClassWriter.visitInsn(1);
                  paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
                  paramClassWriter.visitLabel((Label)localObject3);
                  break;
                  paramClassWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject3)));
                  paramClassWriter.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                }
              }
              localLabel1 = new Label();
              paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
              paramClassWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
              paramClassWriter.visitVarInsn(54, paramContext.var("token"));
              paramClassWriter.visitVarInsn(21, paramContext.var("token"));
              if (i == 0) {}
              for (j = 14;; j = 16)
              {
                paramClassWriter.visitLdcInsn(Integer.valueOf(j));
                paramClassWriter.visitJumpInsn(159, localLabel1);
                paramClassWriter.visitVarInsn(25, 1);
                paramClassWriter.visitVarInsn(21, paramContext.var("token"));
                paramClassWriter.visitMethodInsn(182, DefaultJSONParser, "throwException", "(I)V");
                paramClassWriter.visitLabel(localLabel1);
                localLabel1 = new Label();
                localLabel2 = new Label();
                paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
                paramClassWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
                paramClassWriter.visitVarInsn(16, 91);
                paramClassWriter.visitJumpInsn(160, localLabel1);
                paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
                paramClassWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
                paramClassWriter.visitInsn(87);
                paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
                paramClassWriter.visitLdcInsn(Integer.valueOf(14));
                paramClassWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
                paramClassWriter.visitJumpInsn(167, localLabel2);
                paramClassWriter.visitLabel(localLabel1);
                paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
                paramClassWriter.visitLdcInsn(Integer.valueOf(14));
                paramClassWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
                paramClassWriter.visitLabel(localLabel2);
                _newCollection(paramClassWriter, (Class)localObject3, i, false);
                paramClassWriter.visitInsn(89);
                paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
                _getCollectionFieldItemDeser(paramContext, paramClassWriter, (FieldInfo)localObject2, (Class)localObject4);
                paramClassWriter.visitVarInsn(25, 1);
                paramClassWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc((Class)localObject4)));
                paramClassWriter.visitVarInsn(25, 3);
                paramClassWriter.visitMethodInsn(184, ASMUtils.type(JavaBeanDeserializer.class), "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc(ObjectDeserializer.class) + "L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                break;
              }
            }
            if (!((Class)localObject3).isArray()) {
              break label2483;
            }
            paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
            paramClassWriter.visitLdcInsn(Integer.valueOf(14));
            paramClassWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
            paramClassWriter.visitVarInsn(25, 1);
            paramClassWriter.visitVarInsn(25, 0);
            paramClassWriter.visitLdcInsn(Integer.valueOf(i));
            paramClassWriter.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            paramClassWriter.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            paramClassWriter.visitTypeInsn(192, ASMUtils.type((Class)localObject3));
            paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
          }
        }
      }
      label2483:
      localObject4 = new Label();
      Label localLabel1 = new Label();
      if (localObject3 == Date.class)
      {
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
        paramClassWriter.visitLdcInsn(Integer.valueOf(49));
        paramClassWriter.visitJumpInsn(160, (Label)localObject4);
        paramClassWriter.visitTypeInsn(187, ASMUtils.type(Date.class));
        paramClassWriter.visitInsn(89);
        paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
        paramClassWriter.visitVarInsn(16, k);
        paramClassWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
        paramClassWriter.visitMethodInsn(183, ASMUtils.type(Date.class), "<init>", "(J)V");
        paramClassWriter.visitVarInsn(58, paramContext.var(((FieldInfo)localObject2).name + "_asm"));
        paramClassWriter.visitJumpInsn(167, localLabel1);
      }
      paramClassWriter.visitLabel((Label)localObject4);
      _quickNextToken(paramContext, paramClassWriter, 14);
      _deserObject(paramContext, paramClassWriter, (FieldInfo)localObject2, (Class)localObject3, i);
      paramClassWriter.visitVarInsn(25, 0);
      paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
      if (j == 0) {
        paramClassWriter.visitLdcInsn(Integer.valueOf(16));
      }
      for (;;)
      {
        paramClassWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "check", "(" + ASMUtils.desc(JSONLexer.class) + "I)V");
        paramClassWriter.visitLabel(localLabel1);
        break;
        paramClassWriter.visitLdcInsn(Integer.valueOf(15));
      }
    }
    _batchSet(paramContext, paramClassWriter, false);
    localObject1 = new Label();
    Object localObject2 = new Label();
    Object localObject3 = new Label();
    Object localObject4 = new Label();
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
    paramClassWriter.visitInsn(89);
    paramClassWriter.visitVarInsn(54, paramContext.var("ch"));
    paramClassWriter.visitVarInsn(16, 44);
    paramClassWriter.visitJumpInsn(160, (Label)localObject2);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramClassWriter.visitInsn(87);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(Integer.valueOf(16));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramClassWriter.visitJumpInsn(167, (Label)localObject4);
    paramClassWriter.visitLabel((Label)localObject2);
    paramClassWriter.visitVarInsn(21, paramContext.var("ch"));
    paramClassWriter.visitVarInsn(16, 93);
    paramClassWriter.visitJumpInsn(160, (Label)localObject3);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramClassWriter.visitInsn(87);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(Integer.valueOf(15));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramClassWriter.visitJumpInsn(167, (Label)localObject4);
    paramClassWriter.visitLabel((Label)localObject3);
    paramClassWriter.visitVarInsn(21, paramContext.var("ch"));
    paramClassWriter.visitVarInsn(16, 26);
    paramClassWriter.visitJumpInsn(160, (Label)localObject1);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramClassWriter.visitInsn(87);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(Integer.valueOf(20));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramClassWriter.visitJumpInsn(167, (Label)localObject4);
    paramClassWriter.visitLabel((Label)localObject1);
    paramClassWriter.visitVarInsn(25, paramContext.var("lexer"));
    paramClassWriter.visitLdcInsn(Integer.valueOf(16));
    paramClassWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramClassWriter.visitLabel((Label)localObject4);
    paramClassWriter.visitVarInsn(25, paramContext.var("instance"));
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitMaxs(5, paramContext.variantIndex);
    paramClassWriter.visitEnd();
  }
  
  private void _deserialze_list_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass1, Class<?> paramClass2, int paramInt)
  {
    Label localLabel1 = new Label();
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(153, localLabel1);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    Label localLabel2 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(8));
    paramMethodVisitor.visitJumpInsn(160, localLabel2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(16));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, localLabel1);
    paramMethodVisitor.visitLabel(localLabel2);
    localLabel2 = new Label();
    Label localLabel3 = new Label();
    Label localLabel4 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(21));
    paramMethodVisitor.visitJumpInsn(160, localLabel3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(14));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    _newCollection(paramMethodVisitor, paramClass1, paramInt, true);
    paramMethodVisitor.visitJumpInsn(167, localLabel2);
    paramMethodVisitor.visitLabel(localLabel3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(14));
    paramMethodVisitor.visitJumpInsn(159, localLabel4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(12));
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _newCollection(paramMethodVisitor, paramClass1, paramInt, false);
    paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.name + "_asm"));
    _getCollectionFieldItemDeser(paramContext, paramMethodVisitor, paramFieldInfo, paramClass2);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass2)));
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_value"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_value"));
    if (paramClass1.isInterface())
    {
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
      paramMethodVisitor.visitInsn(87);
      paramMethodVisitor.visitJumpInsn(167, localLabel1);
      paramMethodVisitor.visitLabel(localLabel4);
      _newCollection(paramMethodVisitor, paramClass1, paramInt, false);
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.name + "_asm"));
      boolean bool = ParserConfig.isPrimitive(paramFieldInfo.fieldClass);
      _getCollectionFieldItemDeser(paramContext, paramMethodVisitor, paramFieldInfo, paramClass2);
      if (!bool) {
        break label1722;
      }
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
      paramMethodVisitor.visitVarInsn(54, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
      label847:
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
      paramMethodVisitor.visitVarInsn(58, paramContext.var("listContext"));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
      paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
      paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
      paramMethodVisitor.visitInsn(87);
      localLabel2 = new Label();
      localLabel3 = new Label();
      paramMethodVisitor.visitInsn(3);
      paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(15));
      paramMethodVisitor.visitJumpInsn(159, localLabel3);
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass2)));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
      paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_value"));
      paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_value"));
      if (!paramClass1.isInterface()) {
        break label1767;
      }
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
      label1370:
      paramMethodVisitor.visitInsn(87);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
      paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "checkListResolve", "(Ljava/util/Collection;)V");
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(16));
      paramMethodVisitor.visitJumpInsn(160, localLabel2);
      if (!bool) {
        break label1790;
      }
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    }
    for (;;)
    {
      paramMethodVisitor.visitJumpInsn(167, localLabel2);
      paramMethodVisitor.visitLabel(localLabel3);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("listContext"));
      paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(15));
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      _quickNextTokenComma(paramContext, paramMethodVisitor);
      paramMethodVisitor.visitLabel(localLabel1);
      return;
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
      break;
      label1722:
      paramMethodVisitor.visitInsn(87);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(12));
      paramMethodVisitor.visitVarInsn(54, paramContext.var("fastMatchToken"));
      _quickNextToken(paramContext, paramMethodVisitor, 12);
      break label847;
      label1767:
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
      break label1370;
      label1790:
      _quickNextToken(paramContext, paramMethodVisitor, 12);
    }
  }
  
  private void _deserialze_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt)
  {
    paramLabel = new Label();
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_prefix__", "[C");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(154, paramLabel);
    paramMethodVisitor.visitInsn(1);
    paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.name + "_asm"));
    paramMethodVisitor.visitJumpInsn(167, localLabel);
    paramMethodVisitor.visitLabel(paramLabel);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitInsn(4);
    paramMethodVisitor.visitInsn(96);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("matchedCount"));
    _deserObject(paramContext, paramMethodVisitor, paramFieldInfo, paramClass, paramInt);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getResolveStatus", "()I");
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1));
    paramMethodVisitor.visitJumpInsn(160, localLabel);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getLastResolveTask", "()" + ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc(FieldDeserializer.class));
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(0));
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "setResolveStatus", "(I)V");
    paramMethodVisitor.visitLabel(localLabel);
  }
  
  private void _getCollectionFieldItemDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramClass)));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(ParserConfig.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitFieldInsn(181, paramContext.className, paramFieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
  }
  
  private void _getFieldDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(ParserConfig.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitFieldInsn(181, paramContext.className, paramFieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, paramFieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
  }
  
  private void _init(ClassWriter paramClassWriter, Context paramContext)
  {
    int j = paramContext.fieldInfoList.length;
    int i = 0;
    FieldInfo localFieldInfo;
    while (i < j)
    {
      localFieldInfo = paramContext.fieldInfoList[i];
      new FieldWriter(paramClassWriter, 1, localFieldInfo.name + "_asm_prefix__", "[C").visitEnd();
      i += 1;
    }
    j = paramContext.fieldInfoList.length;
    i = 0;
    if (i < j)
    {
      localFieldInfo = paramContext.fieldInfoList[i];
      Class localClass = localFieldInfo.fieldClass;
      if (localClass.isPrimitive()) {}
      for (;;)
      {
        i += 1;
        break;
        if (Collection.class.isAssignableFrom(localClass)) {
          new FieldWriter(paramClassWriter, 1, localFieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
        } else {
          new FieldWriter(paramClassWriter, 1, localFieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
        }
      }
    }
    paramClassWriter = new MethodWriter(paramClassWriter, 1, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V", null, null);
    paramClassWriter.visitVarInsn(25, 0);
    paramClassWriter.visitVarInsn(25, 1);
    paramClassWriter.visitVarInsn(25, 2);
    paramClassWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V");
    j = paramContext.fieldInfoList.length;
    i = 0;
    while (i < j)
    {
      localFieldInfo = paramContext.fieldInfoList[i];
      paramClassWriter.visitVarInsn(25, 0);
      paramClassWriter.visitLdcInsn("\"" + localFieldInfo.name + "\":");
      paramClassWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
      paramClassWriter.visitFieldInsn(181, paramContext.className, localFieldInfo.name + "_asm_prefix__", "[C");
      i += 1;
    }
    paramClassWriter.visitInsn(177);
    paramClassWriter.visitMaxs(4, 4);
    paramClassWriter.visitEnd();
  }
  
  private void _isFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, Label paramLabel)
  {
    paramMethodVisitor.visitVarInsn(21, paramContext.var("_asm_flag_" + paramInt / 32));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(126);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  private void _loadAndSet(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.fieldClass;
    java.lang.reflect.Type localType = paramFieldInfo.fieldType;
    if (localClass == Boolean.TYPE)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var(paramFieldInfo.name + "_asm"));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
    }
    do
    {
      return;
      if ((localClass == Byte.TYPE) || (localClass == Short.TYPE) || (localClass == Integer.TYPE) || (localClass == Character.TYPE))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(21, paramContext.var(paramFieldInfo.name + "_asm"));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      }
      if (localClass != Long.TYPE) {
        break label314;
      }
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(22, paramContext.var(paramFieldInfo.name + "_asm", 2));
      if (paramFieldInfo.method == null) {
        break;
      }
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramContext.getInstClass()), paramFieldInfo.method.getName(), ASMUtils.desc(paramFieldInfo.method));
    } while (paramFieldInfo.method.getReturnType().equals(Void.TYPE));
    paramMethodVisitor.visitInsn(87);
    return;
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
    return;
    label314:
    if (localClass == Float.TYPE)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(23, paramContext.var(paramFieldInfo.name + "_asm"));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    }
    if (localClass == Double.TYPE)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(24, paramContext.var(paramFieldInfo.name + "_asm", 2));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    }
    if (localClass == String.class)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    }
    if (localClass.isEnum())
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    }
    if (Collection.class.isAssignableFrom(localClass))
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      if (TypeUtils.getCollectionItemClass(localType) == String.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
        paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(localClass));
      }
      for (;;)
      {
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
        paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
      }
    }
    paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.name + "_asm"));
    _set(paramContext, paramMethodVisitor, paramFieldInfo);
  }
  
  private void _newCollection(MethodVisitor paramMethodVisitor, Class<?> paramClass, int paramInt, boolean paramBoolean)
  {
    if ((paramClass.isAssignableFrom(ArrayList.class)) && (!paramBoolean))
    {
      paramMethodVisitor.visitTypeInsn(187, "java/util/ArrayList");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
    }
    for (;;)
    {
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
      return;
      if ((paramClass.isAssignableFrom(LinkedList.class)) && (!paramBoolean))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedList.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
      }
      else if (paramClass.isAssignableFrom(HashSet.class))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
      }
      else if (paramClass.isAssignableFrom(TreeSet.class))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(TreeSet.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
      }
      else if (paramClass.isAssignableFrom(LinkedHashSet.class))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedHashSet.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
      }
      else if (paramBoolean)
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
      }
      else
      {
        paramMethodVisitor.visitVarInsn(25, 0);
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
        paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        paramMethodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
      }
    }
  }
  
  private void _quickNextToken(Context paramContext, MethodVisitor paramMethodVisitor, int paramInt)
  {
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
    if (paramInt == 12) {
      paramMethodVisitor.visitVarInsn(16, 123);
    }
    for (;;)
    {
      paramMethodVisitor.visitJumpInsn(160, localLabel1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
      paramMethodVisitor.visitInsn(87);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
      paramMethodVisitor.visitJumpInsn(167, localLabel2);
      paramMethodVisitor.visitLabel(localLabel1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
      paramMethodVisitor.visitLabel(localLabel2);
      return;
      if (paramInt != 14) {
        break;
      }
      paramMethodVisitor.visitVarInsn(16, 91);
    }
    throw new IllegalStateException();
  }
  
  private void _quickNextTokenComma(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    Label localLabel1 = new Label();
    Label localLabel2 = new Label();
    Label localLabel3 = new Label();
    Label localLabel4 = new Label();
    Label localLabel5 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "getCurrent", "()C");
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitJumpInsn(160, localLabel2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(16));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, localLabel5);
    paramMethodVisitor.visitLabel(localLabel2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 125);
    paramMethodVisitor.visitJumpInsn(160, localLabel3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(13));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, localLabel5);
    paramMethodVisitor.visitLabel(localLabel3);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 93);
    paramMethodVisitor.visitJumpInsn(160, localLabel4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "next", "()C");
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(15));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, localLabel5);
    paramMethodVisitor.visitLabel(localLabel4);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("ch"));
    paramMethodVisitor.visitVarInsn(16, 26);
    paramMethodVisitor.visitJumpInsn(160, localLabel1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(20));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "setToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, localLabel5);
    paramMethodVisitor.visitLabel(localLabel1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "()V");
    paramMethodVisitor.visitLabel(localLabel5);
  }
  
  private void _set(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    paramContext = paramFieldInfo.method;
    if (paramContext != null)
    {
      if (paramContext.getDeclaringClass().isInterface()) {}
      for (int i = 185;; i = 182)
      {
        paramMethodVisitor.visitMethodInsn(i, ASMUtils.type(paramFieldInfo.declaringClass), paramContext.getName(), ASMUtils.desc(paramContext));
        if (!paramFieldInfo.method.getReturnType().equals(Void.TYPE)) {
          paramMethodVisitor.visitInsn(87);
        }
        return;
      }
    }
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
  }
  
  private void _setContext(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("context"));
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitJumpInsn(198, localLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
    paramMethodVisitor.visitLabel(localLabel);
  }
  
  private void _setFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt)
  {
    String str = "_asm_flag_" + paramInt / 32;
    paramMethodVisitor.visitVarInsn(21, paramContext.var(str));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(128);
    paramMethodVisitor.visitVarInsn(54, paramContext.var(str));
  }
  
  private Class<?> defineClassPublic(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.classLoader.defineClassPublic(paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void defineVarLexer(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
    paramMethodVisitor.visitTypeInsn(192, JSONLexerBase);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("lexer"));
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo)
    throws Exception
  {
    Object localObject1 = paramJavaBeanInfo.clazz;
    if (((Class)localObject1).isPrimitive()) {
      throw new IllegalArgumentException("not support type :" + ((Class)localObject1).getName());
    }
    String str = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + "_" + ((Class)localObject1).getSimpleName();
    Object localObject2 = ASMDeserializerFactory.class.getPackage().getName();
    localObject1 = ((String)localObject2).replace('.', '/') + "/" + str;
    str = (String)localObject2 + "." + str;
    localObject2 = new ClassWriter();
    ((ClassWriter)localObject2).visit(49, 33, (String)localObject1, ASMUtils.type(JavaBeanDeserializer.class), null);
    _init((ClassWriter)localObject2, new Context((String)localObject1, paramParserConfig, paramJavaBeanInfo, 3));
    _createInstance((ClassWriter)localObject2, new Context((String)localObject1, paramParserConfig, paramJavaBeanInfo, 3));
    _deserialze((ClassWriter)localObject2, new Context((String)localObject1, paramParserConfig, paramJavaBeanInfo, 5));
    _deserialzeArrayMapping((ClassWriter)localObject2, new Context((String)localObject1, paramParserConfig, paramJavaBeanInfo, 4));
    localObject1 = ((ClassWriter)localObject2).toByteArray();
    return (ObjectDeserializer)defineClassPublic(str, (byte[])localObject1, 0, localObject1.length).getConstructor(new Class[] { ParserConfig.class, JavaBeanInfo.class }).newInstance(new Object[] { paramParserConfig, paramJavaBeanInfo });
  }
  
  static class Context
  {
    static final int fieldName = 3;
    static final int parser = 1;
    static final int type = 2;
    private final JavaBeanInfo beanInfo;
    private final String className;
    private final Class<?> clazz;
    private FieldInfo[] fieldInfoList;
    private int variantIndex = -1;
    private final Map<String, Integer> variants = new HashMap();
    
    public Context(String paramString, ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, int paramInt)
    {
      this.className = paramString;
      this.clazz = paramJavaBeanInfo.clazz;
      this.variantIndex = paramInt;
      this.beanInfo = paramJavaBeanInfo;
      this.fieldInfoList = paramJavaBeanInfo.fields;
    }
    
    public Class<?> getInstClass()
    {
      Class localClass2 = this.beanInfo.builderClass;
      Class localClass1 = localClass2;
      if (localClass2 == null) {
        localClass1 = this.clazz;
      }
      return localClass1;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ASMDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */