package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public abstract class a
  implements c, i
{
  public static TimeZone a = ;
  public static Locale b = Locale.getDefault();
  public static String c = "@type";
  static final SerializeFilter[] d = new SerializeFilter[0];
  public static String e = "yyyy-MM-dd HH:mm:ss";
  public static int f = Feature.AutoCloseSource.getMask() | 0x0 | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
  public static int g = SerializerFeature.QuoteFieldNames.getMask() | 0x0 | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
  private static final ThreadLocal<byte[]> h = new ThreadLocal();
  private static final ThreadLocal<char[]> i = new ThreadLocal();
  
  private static byte[] a(int paramInt)
  {
    byte[] arrayOfByte2 = (byte[])h.get();
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null) {
      if (paramInt <= 65536)
      {
        arrayOfByte1 = new byte[65536];
        h.set(arrayOfByte1);
      }
    }
    do
    {
      return arrayOfByte1;
      return new byte[paramInt];
      arrayOfByte1 = arrayOfByte2;
    } while (arrayOfByte2.length >= paramInt);
    return new byte[paramInt];
  }
  
  private static char[] b(int paramInt)
  {
    char[] arrayOfChar2 = (char[])i.get();
    char[] arrayOfChar1;
    if (arrayOfChar2 == null) {
      if (paramInt <= 65536)
      {
        arrayOfChar1 = new char[65536];
        i.set(arrayOfChar1);
      }
    }
    do
    {
      return arrayOfChar1;
      return new char[paramInt];
      arrayOfChar1 = arrayOfChar2;
    } while (arrayOfChar2.length >= paramInt);
    return new char[paramInt];
  }
  
  public static Object parse(String paramString)
  {
    return parse(paramString, f);
  }
  
  public static Object parse(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), paramInt);
    Object localObject = paramString.parse();
    paramString.handleResovleTask(localObject);
    paramString.close();
    return localObject;
  }
  
  public static Object parse(String paramString, Feature... paramVarArgs)
  {
    int k = f;
    int m = paramVarArgs.length;
    int j = 0;
    while (j < m)
    {
      k = Feature.config(k, paramVarArgs[j], true);
      j += 1;
    }
    return parse(paramString, k);
  }
  
  public static Object parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, int paramInt3)
  {
    paramCharsetDecoder.reset();
    char[] arrayOfChar = b((int)(paramInt2 * paramCharsetDecoder.maxCharsPerByte()));
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    CharBuffer localCharBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, paramArrayOfByte, localCharBuffer);
    paramArrayOfByte = new DefaultJSONParser(arrayOfChar, localCharBuffer.position(), ParserConfig.getGlobalInstance(), paramInt3);
    paramCharsetDecoder = paramArrayOfByte.parse();
    paramArrayOfByte.handleResovleTask(paramCharsetDecoder);
    paramArrayOfByte.close();
    return paramCharsetDecoder;
  }
  
  public static Object parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Feature... paramVarArgs)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    int k = f;
    int m = paramVarArgs.length;
    int j = 0;
    while (j < m)
    {
      k = Feature.config(k, paramVarArgs[j], true);
      j += 1;
    }
    return parse(paramArrayOfByte, paramInt1, paramInt2, paramCharsetDecoder, k);
  }
  
  public static Object parse(byte[] paramArrayOfByte, Feature... paramVarArgs)
  {
    char[] arrayOfChar = b(paramArrayOfByte.length);
    return parse(new String(arrayOfChar, 0, IOUtils.decodeUTF8(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfChar)), paramVarArgs);
  }
  
  public static b parseArray(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer localJSONLexer = localDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      paramString = (String)localObject;
    }
    for (;;)
    {
      localDefaultJSONParser.close();
      return paramString;
      paramString = (String)localObject;
      if (localJSONLexer.token() != 20)
      {
        paramString = new b();
        localDefaultJSONParser.parseArray(paramString);
        localDefaultJSONParser.handleResovleTask(paramString);
      }
    }
  }
  
  public static <T> List<T> parseArray(String paramString, Class<T> paramClass)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer localJSONLexer = localDefaultJSONParser.lexer;
    int j = localJSONLexer.token();
    if (j == 8)
    {
      localJSONLexer.nextToken();
      paramString = (String)localObject;
    }
    for (;;)
    {
      localDefaultJSONParser.close();
      return paramString;
      if (j == 20)
      {
        paramString = (String)localObject;
        if (localJSONLexer.isBlankInput()) {}
      }
      else
      {
        paramString = new ArrayList();
        localDefaultJSONParser.parseArray(paramClass, paramString);
        localDefaultJSONParser.handleResovleTask(paramString);
      }
    }
  }
  
  public static List<Object> parseArray(String paramString, Type[] paramArrayOfType)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    paramString = localDefaultJSONParser.parseArray(paramArrayOfType);
    if (paramString == null) {}
    for (paramString = (String)localObject;; paramString = Arrays.asList(paramString))
    {
      localDefaultJSONParser.handleResovleTask(paramString);
      localDefaultJSONParser.close();
      return paramString;
    }
  }
  
  public static e parseObject(String paramString)
  {
    paramString = parse(paramString);
    if ((paramString instanceof e)) {
      return (e)paramString;
    }
    return (e)toJSON(paramString);
  }
  
  public static e parseObject(String paramString, Feature... paramVarArgs)
  {
    return (e)parse(paramString, paramVarArgs);
  }
  
  public static <T> T parseObject(InputStream paramInputStream, Type paramType, Feature... paramVarArgs)
    throws IOException
  {
    return (T)parseObject(paramInputStream, IOUtils.UTF8, paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(InputStream paramInputStream, Charset paramCharset, Type paramType, Feature... paramVarArgs)
    throws IOException
  {
    if (paramCharset == null) {
      paramCharset = IOUtils.UTF8;
    }
    for (;;)
    {
      Object localObject = a(65536);
      int j = 0;
      for (;;)
      {
        int k = paramInputStream.read((byte[])localObject, j, localObject.length - j);
        if (k == -1) {
          return (T)parseObject((byte[])localObject, 0, j, paramCharset, paramType, paramVarArgs);
        }
        k = j + k;
        j = k;
        if (k == localObject.length)
        {
          byte[] arrayOfByte = new byte[localObject.length * 3 / 2];
          System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
          localObject = arrayOfByte;
          j = k;
        }
      }
    }
  }
  
  public static <T> T parseObject(String paramString, m<T> paramm, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramm.b, ParserConfig.global, f, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass)
  {
    return (T)parseObject(paramString, paramClass, new Feature[0]);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass, ParseProcess paramParseProcess, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramClass, ParserConfig.global, paramParseProcess, f, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramClass, ParserConfig.global, null, f, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, int paramInt, Feature... paramVarArgs)
  {
    if (paramString == null) {
      return null;
    }
    int m = paramVarArgs.length;
    int k = 0;
    int j = paramInt;
    paramInt = k;
    while (paramInt < m)
    {
      j = Feature.config(j, paramVarArgs[paramInt], true);
      paramInt += 1;
    }
    paramString = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), j);
    paramType = paramString.parseObject(paramType);
    paramString.handleResovleTask(paramType);
    paramString.close();
    return paramType;
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, int paramInt, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, paramParserConfig, null, paramInt, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, ParseProcess paramParseProcess, int paramInt, Feature... paramVarArgs)
  {
    if (paramString == null) {
      return null;
    }
    int k = paramInt;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      for (;;)
      {
        k = paramInt;
        if (j >= m) {
          break;
        }
        paramInt |= paramVarArgs[j].mask;
        j += 1;
      }
    }
    paramString = new DefaultJSONParser(paramString, paramParserConfig, k);
    if (paramParseProcess != null)
    {
      if ((paramParseProcess instanceof ExtraTypeProvider)) {
        paramString.getExtraTypeProviders().add((ExtraTypeProvider)paramParseProcess);
      }
      if ((paramParseProcess instanceof ExtraProcessor)) {
        paramString.getExtraProcessors().add((ExtraProcessor)paramParseProcess);
      }
      if ((paramParseProcess instanceof FieldTypeResolver)) {
        paramString.setFieldTypeResolver((FieldTypeResolver)paramParseProcess);
      }
    }
    paramType = paramString.parseObject(paramType, null);
    paramString.handleResovleTask(paramType);
    paramString.close();
    return paramType;
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, paramParserConfig, null, f, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParseProcess paramParseProcess, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, ParserConfig.global, paramParseProcess, f, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, ParserConfig.global, f, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Charset paramCharset, Type paramType, Feature... paramVarArgs)
  {
    Charset localCharset = paramCharset;
    if (paramCharset == null) {
      localCharset = IOUtils.UTF8;
    }
    if (localCharset == IOUtils.UTF8) {
      paramCharset = b(paramArrayOfByte.length);
    }
    for (paramArrayOfByte = new String(paramCharset, 0, IOUtils.decodeUTF8(paramArrayOfByte, paramInt1, paramInt2, paramCharset));; paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, localCharset)) {
      return (T)parseObject(paramArrayOfByte, paramType, paramVarArgs);
    }
  }
  
  public static <T> T parseObject(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Type paramType, Feature... paramVarArgs)
  {
    paramCharsetDecoder.reset();
    char[] arrayOfChar = b((int)(paramInt2 * paramCharsetDecoder.maxCharsPerByte()));
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    CharBuffer localCharBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, paramArrayOfByte, localCharBuffer);
    return (T)parseObject(arrayOfChar, localCharBuffer.position(), paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfByte, Type paramType, Feature... paramVarArgs)
  {
    return (T)parseObject(paramArrayOfByte, 0, paramArrayOfByte.length, IOUtils.UTF8, paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(char[] paramArrayOfChar, int paramInt, Type paramType, Feature... paramVarArgs)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      return null;
    }
    int k = f;
    int m = paramVarArgs.length;
    int j = 0;
    while (j < m)
    {
      k = Feature.config(k, paramVarArgs[j], true);
      j += 1;
    }
    paramArrayOfChar = new DefaultJSONParser(paramArrayOfChar, paramInt, ParserConfig.getGlobalInstance(), k);
    paramType = paramArrayOfChar.parseObject(paramType);
    paramArrayOfChar.handleResovleTask(paramType);
    paramArrayOfChar.close();
    return paramType;
  }
  
  public static void setDefaultTypeKey(String paramString)
  {
    c = paramString;
    ParserConfig.global.symbolTable.addSymbol(paramString, 0, paramString.length(), paramString.hashCode());
  }
  
  public static Object toJSON(Object paramObject)
  {
    return toJSON(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Object toJSON(Object paramObject, ParserConfig paramParserConfig)
  {
    return toJSON(paramObject, SerializeConfig.globalInstance);
  }
  
  public static Object toJSON(Object paramObject, SerializeConfig paramSerializeConfig)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    Class localClass;
    do
    {
      do
      {
        return localObject;
        localObject = paramObject;
      } while ((paramObject instanceof a));
      if ((paramObject instanceof Map))
      {
        paramSerializeConfig = (Map)paramObject;
        paramObject = new e(paramSerializeConfig.size());
        paramSerializeConfig = paramSerializeConfig.entrySet().iterator();
        while (paramSerializeConfig.hasNext())
        {
          localObject = (Map.Entry)paramSerializeConfig.next();
          ((e)paramObject).put(TypeUtils.castToString(((Map.Entry)localObject).getKey()), toJSON(((Map.Entry)localObject).getValue()));
        }
        return paramObject;
      }
      if ((paramObject instanceof Collection))
      {
        paramSerializeConfig = (Collection)paramObject;
        paramObject = new b(paramSerializeConfig.size());
        paramSerializeConfig = paramSerializeConfig.iterator();
        while (paramSerializeConfig.hasNext()) {
          ((b)paramObject).add(toJSON(paramSerializeConfig.next()));
        }
        return paramObject;
      }
      localClass = paramObject.getClass();
      if (localClass.isEnum()) {
        return ((Enum)paramObject).name();
      }
      if (localClass.isArray())
      {
        int k = Array.getLength(paramObject);
        paramSerializeConfig = new b(k);
        int j = 0;
        while (j < k)
        {
          paramSerializeConfig.add(toJSON(Array.get(paramObject, j)));
          j += 1;
        }
        return paramSerializeConfig;
      }
      localObject = paramObject;
    } while (ParserConfig.isPrimitive(localClass));
    paramSerializeConfig = paramSerializeConfig.getObjectWriter(localClass);
    if ((paramSerializeConfig instanceof JavaBeanSerializer))
    {
      localObject = (JavaBeanSerializer)paramSerializeConfig;
      paramSerializeConfig = new e();
      try
      {
        paramObject = ((JavaBeanSerializer)localObject).getFieldValuesMap(paramObject).entrySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject = (Map.Entry)((Iterator)paramObject).next();
          paramSerializeConfig.put((String)((Map.Entry)localObject).getKey(), toJSON(((Map.Entry)localObject).getValue()));
        }
        return paramSerializeConfig;
      }
      catch (Exception paramObject)
      {
        throw new d("toJSON error", (Throwable)paramObject);
      }
    }
    return parse(toJSONString(paramObject));
  }
  
  public static byte[] toJSONBytes(Object paramObject, int paramInt, SerializerFeature... paramVarArgs)
  {
    return toJSONBytes(paramObject, SerializeConfig.globalInstance, paramInt, paramVarArgs);
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, int paramInt, SerializerFeature... paramVarArgs)
  {
    paramVarArgs = new SerializeWriter(null, paramInt, paramVarArgs);
    try
    {
      new JSONSerializer(paramVarArgs, paramSerializeConfig).write(paramObject);
      paramObject = paramVarArgs.toBytes(IOUtils.UTF8);
      return (byte[])paramObject;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    return toJSONBytes(paramObject, paramSerializeConfig, g, paramVarArgs);
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializerFeature... paramVarArgs)
  {
    return toJSONBytes(paramObject, g, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject)
  {
    return toJSONString(paramObject, d, new SerializerFeature[0]);
  }
  
  public static String toJSONString(Object paramObject, int paramInt, SerializerFeature... paramVarArgs)
  {
    paramVarArgs = new SerializeWriter((Writer)null, paramInt, paramVarArgs);
    try
    {
      new JSONSerializer(paramVarArgs).write(paramObject);
      paramObject = paramVarArgs.toString();
      return (String)paramObject;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs)
  {
    int j = g;
    return toJSONString(paramObject, paramSerializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, j, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, String paramString, int paramInt, SerializerFeature... paramVarArgs)
  {
    paramVarArgs = new SerializeWriter(null, paramInt, paramVarArgs);
    try
    {
      paramSerializeConfig = new JSONSerializer(paramVarArgs, paramSerializeConfig);
      if ((paramString != null) && (paramString.length() != 0))
      {
        paramSerializeConfig.setDateFormat(paramString);
        paramSerializeConfig.config(SerializerFeature.WriteDateUseDateFormat, true);
      }
      if (paramArrayOfSerializeFilter != null)
      {
        int j = paramArrayOfSerializeFilter.length;
        paramInt = 0;
        while (paramInt < j)
        {
          paramSerializeConfig.addFilter(paramArrayOfSerializeFilter[paramInt]);
          paramInt += 1;
        }
      }
      paramSerializeConfig.write(paramObject);
      paramObject = paramVarArgs.toString();
      return (String)paramObject;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, paramSerializeConfig, paramArrayOfSerializeFilter, null, g, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, paramSerializeConfig, (SerializeFilter)null, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs)
  {
    SerializeConfig localSerializeConfig = SerializeConfig.globalInstance;
    int j = g;
    return toJSONString(paramObject, localSerializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, j, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return toJSONString(paramObject);
    }
    return toJSONString(paramObject, new SerializerFeature[] { SerializerFeature.PrettyFormat });
  }
  
  public static String toJSONString(Object paramObject, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, paramArrayOfSerializeFilter, null, g, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, g, paramVarArgs);
  }
  
  public static String toJSONStringWithDateFormat(Object paramObject, String paramString, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, paramString, g, paramVarArgs);
  }
  
  public static String toJSONStringZ(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    return toJSONString(paramObject, paramSerializeConfig, d, null, 0, paramVarArgs);
  }
  
  public static <T> T toJavaObject(a parama, Class<T> paramClass)
  {
    return (T)TypeUtils.cast(parama, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Object paramObject, int paramInt, SerializerFeature... paramVarArgs)
    throws IOException
  {
    return writeJSONString(paramOutputStream, IOUtils.UTF8, paramObject, SerializeConfig.globalInstance, null, null, paramInt, paramVarArgs);
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Object paramObject, SerializerFeature... paramVarArgs)
    throws IOException
  {
    return writeJSONString(paramOutputStream, paramObject, g, paramVarArgs);
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Charset paramCharset, Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, String paramString, int paramInt, SerializerFeature... paramVarArgs)
    throws IOException
  {
    paramVarArgs = new SerializeWriter(null, paramInt, paramVarArgs);
    try
    {
      paramSerializeConfig = new JSONSerializer(paramVarArgs, paramSerializeConfig);
      if ((paramString != null) && (paramString.length() != 0))
      {
        paramSerializeConfig.setDateFormat(paramString);
        paramSerializeConfig.config(SerializerFeature.WriteDateUseDateFormat, true);
      }
      if (paramArrayOfSerializeFilter != null)
      {
        int j = paramArrayOfSerializeFilter.length;
        paramInt = 0;
        while (paramInt < j)
        {
          paramSerializeConfig.addFilter(paramArrayOfSerializeFilter[paramInt]);
          paramInt += 1;
        }
      }
      paramSerializeConfig.write(paramObject);
      paramInt = paramVarArgs.writeToEx(paramOutputStream, paramCharset);
      return paramInt;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static final int writeJSONString(OutputStream paramOutputStream, Charset paramCharset, Object paramObject, SerializerFeature... paramVarArgs)
    throws IOException
  {
    return writeJSONString(paramOutputStream, paramCharset, paramObject, SerializeConfig.globalInstance, null, null, g, paramVarArgs);
  }
  
  public static void writeJSONString(Writer paramWriter, Object paramObject, int paramInt, SerializerFeature... paramVarArgs)
  {
    paramWriter = new SerializeWriter(paramWriter, paramInt, paramVarArgs);
    try
    {
      new JSONSerializer(paramWriter).write(paramObject);
      return;
    }
    finally
    {
      paramWriter.close();
    }
  }
  
  public static void writeJSONString(Writer paramWriter, Object paramObject, SerializerFeature... paramVarArgs)
  {
    writeJSONString(paramWriter, paramObject, g, paramVarArgs);
  }
  
  public static void writeJSONStringTo(Object paramObject, Writer paramWriter, SerializerFeature... paramVarArgs)
  {
    writeJSONString(paramWriter, paramObject, paramVarArgs);
  }
  
  public String toJSONString()
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      new JSONSerializer(localSerializeWriter).write(this);
      String str = localSerializeWriter.toString();
      return str;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public <T> T toJavaObject(Class<T> paramClass)
  {
    return (T)TypeUtils.cast(this, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public String toString()
  {
    return toJSONString();
  }
  
  public void writeJSONString(Appendable paramAppendable)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      new JSONSerializer(localSerializeWriter).write(this);
      paramAppendable.append(localSerializeWriter.toString());
      return;
    }
    catch (IOException paramAppendable)
    {
      throw new d(paramAppendable.getMessage(), paramAppendable);
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */