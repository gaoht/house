package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JSONSerializer
  extends SerializeFilterable
{
  protected final SerializeConfig config;
  protected SerialContext context;
  private DateFormat dateFormat;
  private String dateFormatPattern;
  private String indent = "\t";
  private int indentCount = 0;
  protected Locale locale = a.b;
  public final SerializeWriter out;
  protected IdentityHashMap<Object, SerialContext> references = null;
  protected TimeZone timeZone = a.a;
  
  public JSONSerializer()
  {
    this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeConfig paramSerializeConfig)
  {
    this(new SerializeWriter(), paramSerializeConfig);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter)
  {
    this(paramSerializeWriter, SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter, SerializeConfig paramSerializeConfig)
  {
    this.out = paramSerializeWriter;
    this.config = paramSerializeConfig;
  }
  
  public static void write(SerializeWriter paramSerializeWriter, Object paramObject)
  {
    new JSONSerializer(paramSerializeWriter).write(paramObject);
  }
  
  public static void write(Writer paramWriter, Object paramObject)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      new JSONSerializer(localSerializeWriter).write(paramObject);
      localSerializeWriter.writeTo(paramWriter);
      return;
    }
    catch (IOException paramWriter)
    {
      throw new d(paramWriter.getMessage(), paramWriter);
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public boolean checkValue(SerializeFilterable paramSerializeFilterable)
  {
    return ((this.valueFilters != null) && (this.valueFilters.size() > 0)) || ((this.contextValueFilters != null) && (this.contextValueFilters.size() > 0)) || ((paramSerializeFilterable.valueFilters != null) && (paramSerializeFilterable.valueFilters.size() > 0)) || ((paramSerializeFilterable.contextValueFilters != null) && (paramSerializeFilterable.contextValueFilters.size() > 0)) || (this.out.writeNonStringValueAsString);
  }
  
  public void close()
  {
    this.out.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.out.config(paramSerializerFeature, paramBoolean);
  }
  
  public boolean containsReference(Object paramObject)
  {
    if (this.references == null) {}
    do
    {
      return false;
      paramObject = (SerialContext)this.references.get(paramObject);
    } while (paramObject == null);
    paramObject = ((SerialContext)paramObject).fieldName;
    if ((paramObject == null) || ((paramObject instanceof Integer)) || ((paramObject instanceof String))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void decrementIdent()
  {
    this.indentCount -= 1;
  }
  
  public SerialContext getContext()
  {
    return this.context;
  }
  
  public DateFormat getDateFormat()
  {
    if ((this.dateFormat == null) && (this.dateFormatPattern != null))
    {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.locale);
      this.dateFormat.setTimeZone(this.timeZone);
    }
    return this.dateFormat;
  }
  
  public String getDateFormatPattern()
  {
    if ((this.dateFormat instanceof SimpleDateFormat)) {
      return ((SimpleDateFormat)this.dateFormat).toPattern();
    }
    return this.dateFormatPattern;
  }
  
  public int getIndentCount()
  {
    return this.indentCount;
  }
  
  public SerializeConfig getMapping()
  {
    return this.config;
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass)
  {
    return this.config.getObjectWriter(paramClass);
  }
  
  public SerializeWriter getWriter()
  {
    return this.out;
  }
  
  public boolean hasNameFilters(SerializeFilterable paramSerializeFilterable)
  {
    return ((this.nameFilters != null) && (this.nameFilters.size() > 0)) || ((paramSerializeFilterable.nameFilters != null) && (paramSerializeFilterable.nameFilters.size() > 0));
  }
  
  public void incrementIndent()
  {
    this.indentCount += 1;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return this.out.isEnabled(paramSerializerFeature);
  }
  
  public final boolean isWriteClassName(Type paramType, Object paramObject)
  {
    return (this.out.isEnabled(SerializerFeature.WriteClassName)) && ((paramType != null) || (!this.out.isEnabled(SerializerFeature.NotWriteRootClassName)) || (this.context.parent != null));
  }
  
  public void popContext()
  {
    if (this.context != null) {
      this.context = this.context.parent;
    }
  }
  
  public void println()
  {
    this.out.write(10);
    int i = 0;
    while (i < this.indentCount)
    {
      this.out.write(this.indent);
      i += 1;
    }
  }
  
  public void setContext(SerialContext paramSerialContext)
  {
    this.context = paramSerialContext;
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt)
  {
    setContext(paramSerialContext, paramObject1, paramObject2, paramInt, 0);
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    if (this.out.disableCircularReferenceDetect) {
      return;
    }
    this.context = new SerialContext(paramSerialContext, paramObject1, paramObject2, paramInt1, paramInt2);
    if (this.references == null) {
      this.references = new IdentityHashMap();
    }
    this.references.put(paramObject1, this.context);
  }
  
  public void setContext(Object paramObject1, Object paramObject2)
  {
    setContext(this.context, paramObject1, paramObject2, 0);
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    if (this.dateFormat != null) {
      this.dateFormat = null;
    }
  }
  
  public void setDateFormat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
    if (this.dateFormatPattern != null) {
      this.dateFormatPattern = null;
    }
  }
  
  public String toString()
  {
    return this.out.toString();
  }
  
  public final void write(Object paramObject)
  {
    if (paramObject == null)
    {
      this.out.writeNull();
      return;
    }
    ObjectSerializer localObjectSerializer = getObjectWriter(paramObject.getClass());
    try
    {
      localObjectSerializer.write(this, paramObject, null, null, 0);
      return;
    }
    catch (IOException paramObject)
    {
      throw new d(((IOException)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  public final void write(String paramString)
  {
    StringCodec.instance.write(this, paramString);
  }
  
  protected final void writeKeyValue(char paramChar, String paramString, Object paramObject)
  {
    if (paramChar != 0) {
      this.out.write(paramChar);
    }
    this.out.writeFieldName(paramString);
    write(paramObject);
  }
  
  public void writeNull()
  {
    this.out.writeNull();
  }
  
  public void writeReference(Object paramObject)
  {
    SerialContext localSerialContext2 = this.context;
    if (paramObject == localSerialContext2.object)
    {
      this.out.write("{\"$ref\":\"@\"}");
      return;
    }
    SerialContext localSerialContext3 = localSerialContext2.parent;
    SerialContext localSerialContext1 = localSerialContext2;
    if (localSerialContext3 != null)
    {
      localSerialContext1 = localSerialContext2;
      if (paramObject == localSerialContext3.object)
      {
        this.out.write("{\"$ref\":\"..\"}");
        return;
      }
    }
    while (localSerialContext1.parent != null) {
      localSerialContext1 = localSerialContext1.parent;
    }
    if (paramObject == localSerialContext1.object)
    {
      this.out.write("{\"$ref\":\"$\"}");
      return;
    }
    this.out.write("{\"$ref\":\"");
    this.out.write(((SerialContext)this.references.get(paramObject)).toString());
    this.out.write("\"}");
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2)
  {
    writeWithFieldName(paramObject1, paramObject2, null, 0);
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2, Type paramType, int paramInt)
  {
    if (paramObject1 == null) {}
    try
    {
      this.out.writeNull();
      return;
    }
    catch (IOException paramObject1)
    {
      throw new d(((IOException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
    getObjectWriter(paramObject1.getClass()).write(this, paramObject1, paramObject2, paramType, paramInt);
  }
  
  public final void writeWithFormat(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Date))
    {
      DateFormat localDateFormat = getDateFormat();
      Object localObject = localDateFormat;
      if (localDateFormat == null)
      {
        localObject = new SimpleDateFormat(paramString, this.locale);
        ((DateFormat)localObject).setTimeZone(this.timeZone);
      }
      paramObject = ((DateFormat)localObject).format((Date)paramObject);
      this.out.writeString((String)paramObject);
      return;
    }
    write(paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */