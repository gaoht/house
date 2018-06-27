package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.f;
import com.alibaba.fastjson.i;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class MiscCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final MiscCodec instance = new MiscCodec();
  private static Method method_paths_get;
  private static boolean method_paths_get_error = false;
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = null;
    int i = 0;
    Object localObject = paramDefaultJSONParser.lexer;
    if (paramType == InetSocketAddress.class) {
      if (((JSONLexer)localObject).token() == 8) {
        ((JSONLexer)localObject).nextToken();
      }
    }
    label179:
    label321:
    label334:
    for (;;)
    {
      return null;
      paramDefaultJSONParser.accept(12);
      paramType = (Type)paramObject;
      paramObject = ((JSONLexer)localObject).stringVal();
      ((JSONLexer)localObject).nextToken(17);
      if (((String)paramObject).equals("address"))
      {
        paramDefaultJSONParser.accept(17);
        paramType = (InetAddress)paramDefaultJSONParser.parseObject(InetAddress.class);
      }
      for (;;)
      {
        if (((JSONLexer)localObject).token() != 16) {
          break label179;
        }
        ((JSONLexer)localObject).nextToken();
        break;
        if (((String)paramObject).equals("port"))
        {
          paramDefaultJSONParser.accept(17);
          if (((JSONLexer)localObject).token() != 2) {
            throw new d("port is not int");
          }
          i = ((JSONLexer)localObject).intValue();
          ((JSONLexer)localObject).nextToken();
        }
        else
        {
          paramDefaultJSONParser.accept(17);
          paramDefaultJSONParser.parse();
        }
      }
      paramDefaultJSONParser.accept(13);
      return new InetSocketAddress(paramType, i);
      if (paramDefaultJSONParser.resolveStatus == 2)
      {
        paramDefaultJSONParser.resolveStatus = 0;
        paramDefaultJSONParser.accept(16);
        if (((JSONLexer)localObject).token() == 4)
        {
          if (!"val".equals(((JSONLexer)localObject).stringVal())) {
            throw new d("syntax error");
          }
          ((JSONLexer)localObject).nextToken();
          paramDefaultJSONParser.accept(17);
          paramObject = paramDefaultJSONParser.parse();
          paramDefaultJSONParser.accept(13);
          if (paramObject != null) {
            break label321;
          }
        }
      }
      for (paramObject = null;; paramObject = (String)paramObject)
      {
        if ((paramObject == null) || (((String)paramObject).length() == 0)) {
          break label334;
        }
        if (paramType != UUID.class) {
          break label377;
        }
        return UUID.fromString((String)paramObject);
        throw new d("syntax error");
        paramObject = paramDefaultJSONParser.parse();
        break;
        if (!(paramObject instanceof String)) {
          break label336;
        }
      }
    }
    label336:
    if (((paramObject instanceof e)) && (paramType == Map.Entry.class)) {
      return (T)((e)paramObject).entrySet().iterator().next();
    }
    throw new d("expect string");
    label377:
    if (paramType == URI.class) {
      return URI.create((String)paramObject);
    }
    if (paramType == URL.class) {
      try
      {
        paramDefaultJSONParser = new URL((String)paramObject);
        return paramDefaultJSONParser;
      }
      catch (MalformedURLException paramDefaultJSONParser)
      {
        throw new d("create url error", paramDefaultJSONParser);
      }
    }
    if (paramType == Pattern.class) {
      return Pattern.compile((String)paramObject);
    }
    if (paramType == Locale.class)
    {
      paramDefaultJSONParser = ((String)paramObject).split("_");
      if (paramDefaultJSONParser.length == 1) {
        return new Locale(paramDefaultJSONParser[0]);
      }
      if (paramDefaultJSONParser.length == 2) {
        return new Locale(paramDefaultJSONParser[0], paramDefaultJSONParser[1]);
      }
      return new Locale(paramDefaultJSONParser[0], paramDefaultJSONParser[1], paramDefaultJSONParser[2]);
    }
    if (paramType == SimpleDateFormat.class)
    {
      paramDefaultJSONParser = new SimpleDateFormat((String)paramObject, ((JSONLexer)localObject).getLocale());
      paramDefaultJSONParser.setTimeZone(((JSONLexer)localObject).getTimeZone());
      return paramDefaultJSONParser;
    }
    if ((paramType == InetAddress.class) || (paramType == Inet4Address.class) || (paramType == Inet6Address.class)) {
      try
      {
        paramDefaultJSONParser = InetAddress.getByName((String)paramObject);
        return paramDefaultJSONParser;
      }
      catch (UnknownHostException paramDefaultJSONParser)
      {
        throw new d("deserialize inet adress error", paramDefaultJSONParser);
      }
    }
    if (paramType == File.class) {
      return new File((String)paramObject);
    }
    if (paramType == TimeZone.class) {
      return TimeZone.getTimeZone((String)paramObject);
    }
    localObject = paramType;
    if ((paramType instanceof ParameterizedType)) {
      localObject = ((ParameterizedType)paramType).getRawType();
    }
    if (localObject == Class.class) {
      return TypeUtils.loadClass((String)paramObject, paramDefaultJSONParser.getConfig().getDefaultClassLoader());
    }
    if (localObject == Charset.class) {
      return Charset.forName((String)paramObject);
    }
    if (localObject == Currency.class) {
      return Currency.getInstance((String)paramObject);
    }
    if (localObject == f.class) {
      return new f((String)paramObject);
    }
    paramDefaultJSONParser = ((Type)localObject).getTypeName();
    if (paramDefaultJSONParser.equals("java.nio.file.Path")) {}
    try
    {
      if ((method_paths_get == null) && (!method_paths_get_error)) {
        method_paths_get = TypeUtils.loadClass("java.nio.file.Paths").getMethod("get", new Class[] { String.class, String[].class });
      }
      if (method_paths_get != null) {
        return (T)method_paths_get.invoke(null, new Object[] { paramObject, new String[0] });
      }
      throw new d("Path deserialize erorr");
    }
    catch (NoSuchMethodException paramType)
    {
      method_paths_get_error = true;
      throw new d("MiscCodec not support " + paramDefaultJSONParser);
    }
    catch (IllegalAccessException paramDefaultJSONParser)
    {
      throw new d("Path deserialize erorr", paramDefaultJSONParser);
    }
    catch (InvocationTargetException paramDefaultJSONParser)
    {
      throw new d("Path deserialize erorr", paramDefaultJSONParser);
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    paramObject2 = paramObject1.getClass();
    if (paramObject2 == SimpleDateFormat.class)
    {
      String str = ((SimpleDateFormat)paramObject1).toPattern();
      paramObject2 = str;
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
      {
        paramObject2 = str;
        if (paramObject1.getClass() != paramType)
        {
          localSerializeWriter.write(123);
          localSerializeWriter.writeFieldName(a.c);
          paramJSONSerializer.write(paramObject1.getClass().getName());
          localSerializeWriter.writeFieldValue(',', "val", str);
          localSerializeWriter.write(125);
        }
      }
    }
    else
    {
      if (paramObject2 != Class.class) {
        break label128;
      }
      paramObject2 = ((Class)paramObject1).getName();
    }
    for (;;)
    {
      localSerializeWriter.writeString((String)paramObject2);
      return;
      label128:
      if (paramObject2 == InetSocketAddress.class)
      {
        paramObject1 = (InetSocketAddress)paramObject1;
        paramObject2 = ((InetSocketAddress)paramObject1).getAddress();
        localSerializeWriter.write(123);
        if (paramObject2 != null)
        {
          localSerializeWriter.writeFieldName("address");
          paramJSONSerializer.write(paramObject2);
          localSerializeWriter.write(44);
        }
        localSerializeWriter.writeFieldName("port");
        localSerializeWriter.writeInt(((InetSocketAddress)paramObject1).getPort());
        localSerializeWriter.write(125);
        return;
      }
      if ((paramObject1 instanceof File))
      {
        paramObject2 = ((File)paramObject1).getPath();
      }
      else if ((paramObject1 instanceof InetAddress))
      {
        paramObject2 = ((InetAddress)paramObject1).getHostAddress();
      }
      else if ((paramObject1 instanceof TimeZone))
      {
        paramObject2 = ((TimeZone)paramObject1).getID();
      }
      else
      {
        if (!(paramObject1 instanceof Currency)) {
          break;
        }
        paramObject2 = ((Currency)paramObject1).getCurrencyCode();
      }
    }
    if ((paramObject1 instanceof i))
    {
      ((i)paramObject1).writeJSONString(localSerializeWriter);
      return;
    }
    if ((paramObject1 instanceof Iterator))
    {
      writeIterator(paramJSONSerializer, localSerializeWriter, (Iterator)paramObject1);
      return;
    }
    if ((paramObject1 instanceof Iterable))
    {
      writeIterator(paramJSONSerializer, localSerializeWriter, ((Iterable)paramObject1).iterator());
      return;
    }
    if ((paramObject1 instanceof Map.Entry))
    {
      paramObject2 = (Map.Entry)paramObject1;
      paramObject1 = ((Map.Entry)paramObject2).getKey();
      paramObject2 = ((Map.Entry)paramObject2).getValue();
      if ((paramObject1 instanceof String))
      {
        paramObject1 = (String)paramObject1;
        if ((paramObject2 instanceof String)) {
          localSerializeWriter.writeFieldValueStringWithDoubleQuote('{', (String)paramObject1, (String)paramObject2);
        }
      }
      for (;;)
      {
        localSerializeWriter.write(125);
        return;
        localSerializeWriter.write(123);
        localSerializeWriter.writeFieldName((String)paramObject1);
        paramJSONSerializer.write(paramObject2);
        continue;
        localSerializeWriter.write(123);
        paramJSONSerializer.write(paramObject1);
        localSerializeWriter.write(58);
        paramJSONSerializer.write(paramObject2);
      }
    }
    if (paramObject1.getClass().getName().equals("net.sf.json.JSONNull"))
    {
      localSerializeWriter.writeNull();
      return;
    }
    throw new d("not support class : " + paramObject2);
  }
  
  protected void writeIterator(JSONSerializer paramJSONSerializer, SerializeWriter paramSerializeWriter, Iterator<?> paramIterator)
  {
    int i = 0;
    paramSerializeWriter.write(91);
    while (paramIterator.hasNext())
    {
      if (i != 0) {
        paramSerializeWriter.write(44);
      }
      paramJSONSerializer.write(paramIterator.next());
      i += 1;
    }
    paramSerializeWriter.write(93);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/MiscCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */