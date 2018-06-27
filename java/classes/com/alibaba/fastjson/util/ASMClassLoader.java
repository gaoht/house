package com.alibaba.fastjson.util;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.c;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.f;
import com.alibaba.fastjson.g;
import com.alibaba.fastjson.h;
import com.alibaba.fastjson.i;
import com.alibaba.fastjson.k;
import com.alibaba.fastjson.m;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.LabelFilter;
import com.alibaba.fastjson.serializer.Labels;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerialContext;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeFilterable;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

public class ASMClassLoader
  extends ClassLoader
{
  private static ProtectionDomain DOMAIN;
  private static Map<String, Class<?>> classMapping = new HashMap();
  
  static
  {
    DOMAIN = (ProtectionDomain)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return ASMClassLoader.class.getProtectionDomain();
      }
    });
    Class[] arrayOfClass = new Class[56];
    arrayOfClass[0] = a.class;
    arrayOfClass[1] = e.class;
    arrayOfClass[2] = b.class;
    arrayOfClass[3] = f.class;
    arrayOfClass[4] = c.class;
    arrayOfClass[5] = d.class;
    arrayOfClass[6] = g.class;
    arrayOfClass[7] = h.class;
    arrayOfClass[8] = i.class;
    arrayOfClass[9] = k.class;
    arrayOfClass[10] = m.class;
    arrayOfClass[11] = FieldInfo.class;
    arrayOfClass[12] = TypeUtils.class;
    arrayOfClass[13] = IOUtils.class;
    arrayOfClass[14] = IdentityHashMap.class;
    arrayOfClass[15] = ParameterizedTypeImpl.class;
    arrayOfClass[16] = JavaBeanInfo.class;
    arrayOfClass[17] = ObjectSerializer.class;
    arrayOfClass[18] = JavaBeanSerializer.class;
    arrayOfClass[19] = SerializeFilterable.class;
    arrayOfClass[20] = SerializeBeanInfo.class;
    arrayOfClass[21] = JSONSerializer.class;
    arrayOfClass[22] = SerializeWriter.class;
    arrayOfClass[23] = SerializeFilter.class;
    arrayOfClass[24] = Labels.class;
    arrayOfClass[25] = LabelFilter.class;
    arrayOfClass[26] = ContextValueFilter.class;
    arrayOfClass[27] = AfterFilter.class;
    arrayOfClass[28] = BeforeFilter.class;
    arrayOfClass[29] = NameFilter.class;
    arrayOfClass[30] = PropertyFilter.class;
    arrayOfClass[31] = PropertyPreFilter.class;
    arrayOfClass[32] = ValueFilter.class;
    arrayOfClass[33] = SerializerFeature.class;
    arrayOfClass[34] = ContextObjectSerializer.class;
    arrayOfClass[35] = SerialContext.class;
    arrayOfClass[36] = SerializeConfig.class;
    arrayOfClass[37] = JavaBeanDeserializer.class;
    arrayOfClass[38] = ParserConfig.class;
    arrayOfClass[39] = DefaultJSONParser.class;
    arrayOfClass[40] = JSONLexer.class;
    arrayOfClass[41] = JSONLexerBase.class;
    arrayOfClass[42] = ParseContext.class;
    arrayOfClass[43] = JSONToken.class;
    arrayOfClass[44] = SymbolTable.class;
    arrayOfClass[45] = Feature.class;
    arrayOfClass[46] = JSONScanner.class;
    arrayOfClass[47] = JSONReaderScanner.class;
    arrayOfClass[48] = AutowiredObjectDeserializer.class;
    arrayOfClass[49] = ObjectDeserializer.class;
    arrayOfClass[50] = ExtraProcessor.class;
    arrayOfClass[51] = ExtraProcessable.class;
    arrayOfClass[52] = ExtraTypeProvider.class;
    arrayOfClass[53] = BeanContext.class;
    arrayOfClass[54] = FieldDeserializer.class;
    arrayOfClass[55] = DefaultFieldDeserializer.class;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      classMapping.put(localClass.getName(), localClass);
      i += 1;
    }
  }
  
  public ASMClassLoader()
  {
    super(getParentClassLoader());
  }
  
  public ASMClassLoader(ClassLoader paramClassLoader)
  {
    super(paramClassLoader);
  }
  
  static ClassLoader getParentClassLoader()
  {
    ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
    if (localClassLoader != null) {
      try
      {
        localClassLoader.loadClass(a.class.getName());
        return localClassLoader;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    return a.class.getClassLoader();
  }
  
  public Class<?> defineClassPublic(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ClassFormatError
  {
    return defineClass(paramString, paramArrayOfByte, paramInt1, paramInt2, DOMAIN);
  }
  
  public boolean isExternalClass(Class<?> paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramClass = this;
    if (localClassLoader == null) {
      return false;
    }
    do
    {
      paramClass = paramClass.getParent();
      if (paramClass == null) {
        break;
      }
    } while (paramClass != localClassLoader);
    return false;
    return true;
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    Class localClass = (Class)classMapping.get(paramString);
    if (localClass != null) {
      return localClass;
    }
    try
    {
      paramString = super.loadClass(paramString, paramBoolean);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/ASMClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */