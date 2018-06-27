package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class k
  implements Closeable, Flushable
{
  private SerializeWriter a;
  private JSONSerializer b;
  private j c;
  
  public k(Writer paramWriter)
  {
    this.a = new SerializeWriter(paramWriter);
    this.b = new JSONSerializer(this.a);
  }
  
  private void a()
  {
    int i = this.c.b;
    switch (this.c.b)
    {
    case 1003: 
    default: 
      throw new d("illegal state : " + i);
    case 1002: 
      this.a.write(58);
    case 1001: 
    case 1004: 
      return;
    }
    this.a.write(44);
  }
  
  private void b()
  {
    this.c = this.c.a;
    if (this.c == null) {
      return;
    }
    int i;
    switch (this.c.b)
    {
    case 1003: 
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.c.b = i;
      return;
      i = 1003;
      continue;
      i = 1005;
      continue;
      i = -1;
      continue;
      i = 1002;
    }
  }
  
  private void c()
  {
    if (this.c == null) {
      return;
    }
    switch (this.c.b)
    {
    case 1001: 
    case 1004: 
    default: 
      return;
    case 1002: 
      this.a.write(58);
      return;
    case 1003: 
      this.a.write(44);
      return;
    }
    this.a.write(44);
  }
  
  private void d()
  {
    if (this.c == null) {
      return;
    }
    int i;
    switch (this.c.b)
    {
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.c.b = i;
      return;
      i = 1003;
      continue;
      i = 1002;
      continue;
      i = 1005;
      continue;
      i = -1;
    }
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.a.config(paramSerializerFeature, paramBoolean);
  }
  
  public void endArray()
  {
    this.a.write(93);
    b();
  }
  
  public void endObject()
  {
    this.a.write(125);
    b();
  }
  
  public void flush()
    throws IOException
  {
    this.a.flush();
  }
  
  public void startArray()
  {
    if (this.c != null) {
      a();
    }
    this.c = new j(this.c, 1004);
    this.a.write(91);
  }
  
  public void startObject()
  {
    if (this.c != null) {
      a();
    }
    this.c = new j(this.c, 1001);
    this.a.write(123);
  }
  
  @Deprecated
  public void writeEndArray()
  {
    endArray();
  }
  
  @Deprecated
  public void writeEndObject()
  {
    endObject();
  }
  
  public void writeKey(String paramString)
  {
    writeObject(paramString);
  }
  
  public void writeObject(Object paramObject)
  {
    c();
    this.b.write(paramObject);
    d();
  }
  
  public void writeObject(String paramString)
  {
    c();
    this.b.write(paramString);
    d();
  }
  
  @Deprecated
  public void writeStartArray()
  {
    startArray();
  }
  
  @Deprecated
  public void writeStartObject()
  {
    startObject();
  }
  
  public void writeValue(Object paramObject)
  {
    writeObject(paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */