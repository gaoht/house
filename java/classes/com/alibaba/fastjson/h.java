package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class h
  implements Closeable
{
  private final DefaultJSONParser a;
  private j b;
  
  public h(DefaultJSONParser paramDefaultJSONParser)
  {
    this.a = paramDefaultJSONParser;
  }
  
  public h(JSONLexer paramJSONLexer)
  {
    this(new DefaultJSONParser(paramJSONLexer));
  }
  
  public h(Reader paramReader)
  {
    this(paramReader, new Feature[0]);
  }
  
  public h(Reader paramReader, Feature... paramVarArgs)
  {
    this(new JSONReaderScanner(paramReader));
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      config(paramVarArgs[i], true);
      i += 1;
    }
  }
  
  private void a()
  {
    switch (this.b.b)
    {
    default: 
      throw new d("illegal state : " + this.b.b);
    case 1002: 
      this.a.accept(17);
    case 1001: 
    case 1004: 
      return;
    }
    this.a.accept(16);
  }
  
  private void b()
  {
    this.b = this.b.a;
    if (this.b == null) {
      return;
    }
    int i;
    switch (this.b.b)
    {
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.b.b = i;
      return;
      i = 1003;
      continue;
      i = 1005;
      continue;
      i = 1002;
    }
  }
  
  private void c()
  {
    int i = this.b.b;
    switch (i)
    {
    default: 
      throw new d("illegal state : " + i);
    case 1002: 
      this.a.accept(17);
    case 1001: 
    case 1004: 
      return;
    case 1003: 
      this.a.accept(16, 18);
      return;
    }
    this.a.accept(16);
  }
  
  private void d()
  {
    int i = 1002;
    int j = this.b.b;
    switch (j)
    {
    default: 
      throw new d("illegal state : " + j);
    case 1002: 
      i = 1003;
    }
    for (;;)
    {
      if (i != -1) {
        this.b.b = i;
      }
      return;
      i = -1;
      continue;
      i = 1005;
    }
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.a.config(paramFeature, paramBoolean);
  }
  
  public void endArray()
  {
    this.a.accept(15);
    b();
  }
  
  public void endObject()
  {
    this.a.accept(13);
    b();
  }
  
  public Locale getLocal()
  {
    return this.a.lexer.getLocale();
  }
  
  public TimeZone getTimzeZone()
  {
    return this.a.lexer.getTimeZone();
  }
  
  public boolean hasNext()
  {
    if (this.b == null) {
      throw new d("context is null");
    }
    int i = this.a.lexer.token();
    int j = this.b.b;
    switch (j)
    {
    case 1002: 
    default: 
      throw new d("illegal state : " + j);
    case 1004: 
    case 1005: 
      if (i == 15) {
        break;
      }
    }
    do
    {
      return true;
      return false;
    } while (i != 13);
    return false;
  }
  
  public int peek()
  {
    return this.a.lexer.token();
  }
  
  public Integer readInteger()
  {
    Object localObject;
    if (this.b == null) {
      localObject = this.a.parse();
    }
    for (;;)
    {
      return TypeUtils.castToInt(localObject);
      c();
      localObject = this.a.parse();
      d();
    }
  }
  
  public Long readLong()
  {
    Object localObject;
    if (this.b == null) {
      localObject = this.a.parse();
    }
    for (;;)
    {
      return TypeUtils.castToLong(localObject);
      c();
      localObject = this.a.parse();
      d();
    }
  }
  
  public Object readObject()
  {
    if (this.b == null) {
      return this.a.parse();
    }
    c();
    switch (this.b.b)
    {
    }
    for (Object localObject = this.a.parse();; localObject = this.a.parseKey())
    {
      d();
      return localObject;
    }
  }
  
  public <T> T readObject(m<T> paramm)
  {
    return (T)readObject(paramm.getType());
  }
  
  public <T> T readObject(Class<T> paramClass)
  {
    if (this.b == null) {
      return (T)this.a.parseObject(paramClass);
    }
    c();
    paramClass = this.a.parseObject(paramClass);
    d();
    return paramClass;
  }
  
  public <T> T readObject(Type paramType)
  {
    if (this.b == null) {
      return (T)this.a.parseObject(paramType);
    }
    c();
    paramType = this.a.parseObject(paramType);
    d();
    return paramType;
  }
  
  public Object readObject(Map paramMap)
  {
    if (this.b == null) {
      return this.a.parseObject(paramMap);
    }
    c();
    paramMap = this.a.parseObject(paramMap);
    d();
    return paramMap;
  }
  
  public void readObject(Object paramObject)
  {
    if (this.b == null)
    {
      this.a.parseObject(paramObject);
      return;
    }
    c();
    this.a.parseObject(paramObject);
    d();
  }
  
  public String readString()
  {
    Object localObject;
    if (this.b == null)
    {
      localObject = this.a.parse();
      return TypeUtils.castToString(localObject);
    }
    c();
    JSONLexer localJSONLexer = this.a.lexer;
    if ((this.b.b == 1001) && (localJSONLexer.token() == 18))
    {
      localObject = localJSONLexer.stringVal();
      localJSONLexer.nextToken();
    }
    for (;;)
    {
      d();
      break;
      localObject = this.a.parse();
    }
  }
  
  public void setLocale(Locale paramLocale)
  {
    this.a.lexer.setLocale(paramLocale);
  }
  
  public void setTimzeZone(TimeZone paramTimeZone)
  {
    this.a.lexer.setTimeZone(paramTimeZone);
  }
  
  public void startArray()
  {
    if (this.b == null) {}
    for (this.b = new j(null, 1004);; this.b = new j(this.b, 1004))
    {
      this.a.accept(14);
      return;
      a();
    }
  }
  
  public void startObject()
  {
    if (this.b == null) {}
    for (this.b = new j(null, 1001);; this.b = new j(this.b, 1001))
    {
      this.a.accept(12, 18);
      return;
      a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */