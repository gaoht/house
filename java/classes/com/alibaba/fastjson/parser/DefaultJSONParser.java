package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser
  implements Closeable
{
  public static final int NONE = 0;
  public static final int NeedToResolve = 1;
  public static final int TypeNameRedirect = 2;
  private static final Set<Class<?>> primitiveClasses = new HashSet();
  protected ParserConfig config;
  protected ParseContext context;
  private ParseContext[] contextArray;
  private int contextArrayIndex = 0;
  private DateFormat dateFormat;
  private String dateFormatPattern = a.e;
  private List<ExtraProcessor> extraProcessors = null;
  private List<ExtraTypeProvider> extraTypeProviders = null;
  protected FieldTypeResolver fieldTypeResolver = null;
  public final Object input;
  protected transient BeanContext lastBeanContext;
  public final JSONLexer lexer;
  public int resolveStatus = 0;
  private List<ResolveTask> resolveTaskList;
  public final SymbolTable symbolTable;
  
  static
  {
    primitiveClasses.add(Boolean.TYPE);
    primitiveClasses.add(Byte.TYPE);
    primitiveClasses.add(Short.TYPE);
    primitiveClasses.add(Integer.TYPE);
    primitiveClasses.add(Long.TYPE);
    primitiveClasses.add(Float.TYPE);
    primitiveClasses.add(Double.TYPE);
    primitiveClasses.add(Boolean.class);
    primitiveClasses.add(Byte.class);
    primitiveClasses.add(Short.class);
    primitiveClasses.add(Integer.class);
    primitiveClasses.add(Long.class);
    primitiveClasses.add(Float.class);
    primitiveClasses.add(Double.class);
    primitiveClasses.add(BigInteger.class);
    primitiveClasses.add(BigDecimal.class);
    primitiveClasses.add(String.class);
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer)
  {
    this(paramJSONLexer, ParserConfig.getGlobalInstance());
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer, ParserConfig paramParserConfig)
  {
    this(null, paramJSONLexer, paramParserConfig);
  }
  
  public DefaultJSONParser(Object paramObject, JSONLexer paramJSONLexer, ParserConfig paramParserConfig)
  {
    this.lexer = paramJSONLexer;
    this.input = paramObject;
    this.config = paramParserConfig;
    this.symbolTable = paramParserConfig.symbolTable;
    int i = paramJSONLexer.getCurrent();
    if (i == 123)
    {
      paramJSONLexer.next();
      ((JSONLexerBase)paramJSONLexer).token = 12;
      return;
    }
    if (i == 91)
    {
      paramJSONLexer.next();
      ((JSONLexerBase)paramJSONLexer).token = 14;
      return;
    }
    paramJSONLexer.nextToken();
  }
  
  public DefaultJSONParser(String paramString)
  {
    this(paramString, ParserConfig.getGlobalInstance(), a.f);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig)
  {
    this(paramString, new JSONScanner(paramString, a.f), paramParserConfig);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt)
  {
    this(paramString, new JSONScanner(paramString, paramInt), paramParserConfig);
  }
  
  public DefaultJSONParser(char[] paramArrayOfChar, int paramInt1, ParserConfig paramParserConfig, int paramInt2)
  {
    this(paramArrayOfChar, new JSONScanner(paramArrayOfChar, paramInt1, paramInt2), paramParserConfig);
  }
  
  private void addContext(ParseContext paramParseContext)
  {
    int i = this.contextArrayIndex;
    this.contextArrayIndex = (i + 1);
    if (this.contextArray == null) {
      this.contextArray = new ParseContext[8];
    }
    for (;;)
    {
      this.contextArray[i] = paramParseContext;
      return;
      if (i >= this.contextArray.length)
      {
        ParseContext[] arrayOfParseContext = new ParseContext[this.contextArray.length * 3 / 2];
        System.arraycopy(this.contextArray, 0, arrayOfParseContext, 0, this.contextArray.length);
        this.contextArray = arrayOfParseContext;
      }
    }
  }
  
  public final void accept(int paramInt)
  {
    JSONLexer localJSONLexer = this.lexer;
    if (localJSONLexer.token() == paramInt)
    {
      localJSONLexer.nextToken();
      return;
    }
    throw new d("syntax error, expect " + JSONToken.name(paramInt) + ", actual " + JSONToken.name(localJSONLexer.token()));
  }
  
  public final void accept(int paramInt1, int paramInt2)
  {
    JSONLexer localJSONLexer = this.lexer;
    if (localJSONLexer.token() == paramInt1)
    {
      localJSONLexer.nextToken(paramInt2);
      return;
    }
    throwException(paramInt1);
  }
  
  public void acceptType(String paramString)
  {
    JSONLexer localJSONLexer = this.lexer;
    localJSONLexer.nextTokenWithColon();
    if (localJSONLexer.token() != 4) {
      throw new d("type not match error");
    }
    if (paramString.equals(localJSONLexer.stringVal()))
    {
      localJSONLexer.nextToken();
      if (localJSONLexer.token() == 16) {
        localJSONLexer.nextToken();
      }
      return;
    }
    throw new d("type not match error");
  }
  
  public void addResolveTask(ResolveTask paramResolveTask)
  {
    if (this.resolveTaskList == null) {
      this.resolveTaskList = new ArrayList(2);
    }
    this.resolveTaskList.add(paramResolveTask);
  }
  
  public void checkListResolve(Collection paramCollection)
  {
    if (this.resolveStatus == 1)
    {
      if ((paramCollection instanceof List))
      {
        int i = paramCollection.size();
        paramCollection = (List)paramCollection;
        localResolveTask = getLastResolveTask();
        localResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, paramCollection, i - 1);
        localResolveTask.ownerContext = this.context;
        setResolveStatus(0);
      }
    }
    else {
      return;
    }
    ResolveTask localResolveTask = getLastResolveTask();
    localResolveTask.fieldDeserializer = new ResolveFieldDeserializer(paramCollection);
    localResolveTask.ownerContext = this.context;
    setResolveStatus(0);
  }
  
  public void checkMapResolve(Map paramMap, Object paramObject)
  {
    if (this.resolveStatus == 1)
    {
      paramMap = new ResolveFieldDeserializer(paramMap, paramObject);
      paramObject = getLastResolveTask();
      ((ResolveTask)paramObject).fieldDeserializer = paramMap;
      ((ResolveTask)paramObject).ownerContext = this.context;
      setResolveStatus(0);
    }
  }
  
  public void close()
  {
    JSONLexer localJSONLexer = this.lexer;
    try
    {
      if ((localJSONLexer.isEnabled(Feature.AutoCloseSource)) && (localJSONLexer.token() != 20)) {
        throw new d("not close json text, token : " + JSONToken.name(localJSONLexer.token()));
      }
    }
    finally
    {
      localJSONLexer.close();
    }
    localJSONLexer.close();
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.lexer.config(paramFeature, paramBoolean);
  }
  
  public ParserConfig getConfig()
  {
    return this.config;
  }
  
  public ParseContext getContext()
  {
    return this.context;
  }
  
  public String getDateFomartPattern()
  {
    return this.dateFormatPattern;
  }
  
  public DateFormat getDateFormat()
  {
    if (this.dateFormat == null)
    {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
      this.dateFormat.setTimeZone(this.lexer.getTimeZone());
    }
    return this.dateFormat;
  }
  
  public List<ExtraProcessor> getExtraProcessors()
  {
    if (this.extraProcessors == null) {
      this.extraProcessors = new ArrayList(2);
    }
    return this.extraProcessors;
  }
  
  public List<ExtraTypeProvider> getExtraTypeProviders()
  {
    if (this.extraTypeProviders == null) {
      this.extraTypeProviders = new ArrayList(2);
    }
    return this.extraTypeProviders;
  }
  
  public FieldTypeResolver getFieldTypeResolver()
  {
    return this.fieldTypeResolver;
  }
  
  public String getInput()
  {
    if ((this.input instanceof char[])) {
      return new String((char[])this.input);
    }
    return this.input.toString();
  }
  
  public ResolveTask getLastResolveTask()
  {
    return (ResolveTask)this.resolveTaskList.get(this.resolveTaskList.size() - 1);
  }
  
  public JSONLexer getLexer()
  {
    return this.lexer;
  }
  
  public Object getObject(String paramString)
  {
    int i = 0;
    while (i < this.contextArrayIndex)
    {
      if (paramString.equals(this.contextArray[i].toString())) {
        return this.contextArray[i].object;
      }
      i += 1;
    }
    return null;
  }
  
  public int getResolveStatus()
  {
    return this.resolveStatus;
  }
  
  public List<ResolveTask> getResolveTaskList()
  {
    if (this.resolveTaskList == null) {
      this.resolveTaskList = new ArrayList(2);
    }
    return this.resolveTaskList;
  }
  
  public SymbolTable getSymbolTable()
  {
    return this.symbolTable;
  }
  
  public void handleResovleTask(Object paramObject)
  {
    if (this.resolveTaskList == null) {
      return;
    }
    int j = this.resolveTaskList.size();
    int i = 0;
    label20:
    Object localObject2;
    if (i < j)
    {
      localObject2 = (ResolveTask)this.resolveTaskList.get(i);
      localObject1 = ((ResolveTask)localObject2).referenceValue;
      paramObject = null;
      if (((ResolveTask)localObject2).ownerContext != null) {
        paramObject = ((ResolveTask)localObject2).ownerContext.object;
      }
      if (!((String)localObject1).startsWith("$")) {
        break label112;
      }
    }
    label112:
    for (Object localObject1 = getObject((String)localObject1);; localObject1 = ((ResolveTask)localObject2).context.object)
    {
      localObject2 = ((ResolveTask)localObject2).fieldDeserializer;
      if (localObject2 != null) {
        ((FieldDeserializer)localObject2).setValue(paramObject, localObject1);
      }
      i += 1;
      break label20;
      break;
    }
  }
  
  public boolean isEnabled(Feature paramFeature)
  {
    return this.lexer.isEnabled(paramFeature);
  }
  
  public Object parse()
  {
    return parse(null);
  }
  
  public Object parse(Object paramObject)
  {
    Object localObject1 = null;
    JSONLexer localJSONLexer = this.lexer;
    switch (localJSONLexer.token())
    {
    case 5: 
    case 10: 
    case 11: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      throw new d("syntax error, " + localJSONLexer.info());
    case 21: 
      localJSONLexer.nextToken();
      localObject1 = new HashSet();
      parseArray((Collection)localObject1, paramObject);
      paramObject = localObject1;
    }
    do
    {
      do
      {
        do
        {
          return paramObject;
          localJSONLexer.nextToken();
          localObject1 = new TreeSet();
          parseArray((Collection)localObject1, paramObject);
          return localObject1;
          localObject1 = new b();
          parseArray((Collection)localObject1, paramObject);
          paramObject = localObject1;
        } while (!localJSONLexer.isEnabled(Feature.UseObjectArray));
        return ((b)localObject1).toArray();
        return parseObject(new e(localJSONLexer.isEnabled(Feature.OrderedField)), paramObject);
        paramObject = localJSONLexer.integerValue();
        localJSONLexer.nextToken();
        return paramObject;
        paramObject = localJSONLexer.decimalValue(localJSONLexer.isEnabled(Feature.UseBigDecimal));
        localJSONLexer.nextToken();
        return paramObject;
        localObject1 = localJSONLexer.stringVal();
        localJSONLexer.nextToken(16);
        paramObject = localObject1;
      } while (!localJSONLexer.isEnabled(Feature.AllowISO8601DateFormat));
      paramObject = new JSONScanner((String)localObject1);
      try
      {
        if (((JSONScanner)paramObject).scanISO8601DateIfMatch())
        {
          localObject1 = ((JSONScanner)paramObject).getCalendar().getTime();
          return localObject1;
        }
        return localObject1;
      }
      finally
      {
        ((JSONScanner)paramObject).close();
      }
      localJSONLexer.nextToken();
      return null;
      localJSONLexer.nextToken();
      return null;
      localJSONLexer.nextToken();
      return Boolean.TRUE;
      localJSONLexer.nextToken();
      return Boolean.FALSE;
      localJSONLexer.nextToken(18);
      if (localJSONLexer.token() != 18) {
        throw new d("syntax error");
      }
      localJSONLexer.nextToken(10);
      accept(10);
      long l = localJSONLexer.integerValue().longValue();
      accept(2);
      accept(11);
      return new Date(l);
      paramObject = localObject2;
    } while (localJSONLexer.isBlankInput());
    throw new d("unterminated json string, " + localJSONLexer.info());
  }
  
  public <T> List<T> parseArray(Class<T> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    parseArray(paramClass, localArrayList);
    return localArrayList;
  }
  
  public void parseArray(Class<?> paramClass, Collection paramCollection)
  {
    parseArray(paramClass, paramCollection);
  }
  
  public void parseArray(Type paramType, Collection paramCollection)
  {
    parseArray(paramType, paramCollection, null);
  }
  
  public void parseArray(Type paramType, Collection paramCollection, Object paramObject)
  {
    if ((this.lexer.token() == 21) || (this.lexer.token() == 22)) {
      this.lexer.nextToken();
    }
    if (this.lexer.token() != 14) {
      throw new d("exepct '[', but " + JSONToken.name(this.lexer.token()) + ", " + this.lexer.info());
    }
    Object localObject;
    ParseContext localParseContext;
    int i;
    if (Integer.TYPE == paramType)
    {
      localObject = IntegerCodec.instance;
      this.lexer.nextToken(2);
      localParseContext = this.context;
      setContext(paramCollection, paramObject);
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (!this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
          break label249;
        }
        if (this.lexer.token() != 16) {
          break label249;
        }
        this.lexer.nextToken();
        continue;
        if (String.class != paramType) {
          break label220;
        }
      }
      finally
      {
        setContext(localParseContext);
      }
      localObject = StringCodec.instance;
      this.lexer.nextToken(4);
      break;
      label220:
      localObject = this.config.getDeserializer(paramType);
      this.lexer.nextToken(((ObjectDeserializer)localObject).getFastMatchToken());
      break;
      label249:
      int j = this.lexer.token();
      if (j == 15)
      {
        setContext(localParseContext);
        this.lexer.nextToken(16);
        return;
      }
      if (Integer.TYPE == paramType)
      {
        paramCollection.add(IntegerCodec.instance.deserialze(this, null, null));
        if (this.lexer.token() == 16) {
          this.lexer.nextToken(((ObjectDeserializer)localObject).getFastMatchToken());
        }
      }
      else
      {
        if (String.class == paramType)
        {
          if (this.lexer.token() == 4)
          {
            paramObject = this.lexer.stringVal();
            this.lexer.nextToken(16);
          }
          for (;;)
          {
            paramCollection.add(paramObject);
            break;
            paramObject = parse();
            if (paramObject == null) {
              paramObject = null;
            } else {
              paramObject = paramObject.toString();
            }
          }
        }
        if (this.lexer.token() == 8) {
          this.lexer.nextToken();
        }
        for (paramObject = null;; paramObject = ((ObjectDeserializer)localObject).deserialze(this, paramType, Integer.valueOf(i)))
        {
          paramCollection.add(paramObject);
          checkListResolve(paramCollection);
          break;
        }
      }
      i += 1;
    }
  }
  
  public final void parseArray(Collection paramCollection)
  {
    parseArray(paramCollection, null);
  }
  
  public final void parseArray(Collection paramCollection, Object paramObject)
  {
    JSONLexer localJSONLexer = this.lexer;
    if ((localJSONLexer.token() == 21) || (localJSONLexer.token() == 22)) {
      localJSONLexer.nextToken();
    }
    if (localJSONLexer.token() != 14) {
      throw new d("syntax error, expect [, actual " + JSONToken.name(localJSONLexer.token()) + ", pos " + localJSONLexer.pos());
    }
    localJSONLexer.nextToken(4);
    ParseContext localParseContext = this.context;
    setContext(paramCollection, paramObject);
    int i = 0;
    for (;;)
    {
      try
      {
        if (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
          if (localJSONLexer.token() == 16)
          {
            localJSONLexer.nextToken();
            continue;
          }
        }
        switch (localJSONLexer.token())
        {
        }
      }
      finally
      {
        setContext(localParseContext);
      }
      for (;;)
      {
        paramObject = parse();
        for (;;)
        {
          paramCollection.add(paramObject);
          checkListResolve(paramCollection);
          if (localJSONLexer.token() != 16) {
            break;
          }
          localJSONLexer.nextToken(4);
          break;
          paramObject = localJSONLexer.integerValue();
          localJSONLexer.nextToken(16);
          continue;
          if (localJSONLexer.isEnabled(Feature.UseBigDecimal)) {}
          for (paramObject = localJSONLexer.decimalValue(true);; paramObject = localJSONLexer.decimalValue(false))
          {
            localJSONLexer.nextToken(16);
            break;
          }
          Object localObject = localJSONLexer.stringVal();
          localJSONLexer.nextToken(16);
          paramObject = localObject;
          if (localJSONLexer.isEnabled(Feature.AllowISO8601DateFormat))
          {
            JSONScanner localJSONScanner = new JSONScanner((String)localObject);
            paramObject = localObject;
            if (localJSONScanner.scanISO8601DateIfMatch()) {
              paramObject = localJSONScanner.getCalendar().getTime();
            }
            localJSONScanner.close();
            continue;
            paramObject = Boolean.TRUE;
            localJSONLexer.nextToken(16);
            continue;
            paramObject = Boolean.FALSE;
            localJSONLexer.nextToken(16);
            continue;
            paramObject = parseObject(new e(localJSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
            continue;
            localObject = new b();
            parseArray((Collection)localObject, Integer.valueOf(i));
            paramObject = localObject;
            if (localJSONLexer.isEnabled(Feature.UseObjectArray))
            {
              paramObject = ((Collection)localObject).toArray();
              continue;
              localJSONLexer.nextToken(4);
              paramObject = null;
              continue;
              localJSONLexer.nextToken(4);
              paramObject = null;
            }
          }
        }
        localJSONLexer.nextToken(16);
        setContext(localParseContext);
        return;
        throw new d("unclosed jsonArray");
      }
      i += 1;
    }
  }
  
  public Object[] parseArray(Type[] paramArrayOfType)
  {
    if (this.lexer.token() == 8)
    {
      this.lexer.nextToken(16);
      return null;
    }
    if (this.lexer.token() != 14) {
      throw new d("syntax error : " + this.lexer.tokenName());
    }
    Object[] arrayOfObject = new Object[paramArrayOfType.length];
    if (paramArrayOfType.length == 0)
    {
      this.lexer.nextToken(15);
      if (this.lexer.token() != 15) {
        throw new d("syntax error");
      }
      this.lexer.nextToken(16);
      return new Object[0];
    }
    this.lexer.nextToken(2);
    int i = 0;
    Object localObject;
    if (i < paramArrayOfType.length)
    {
      if (this.lexer.token() != 8) {
        break label232;
      }
      this.lexer.nextToken(16);
      localObject = null;
    }
    label187:
    label232:
    Type localType;
    for (;;)
    {
      arrayOfObject[i] = localObject;
      if (this.lexer.token() != 15) {
        break label610;
      }
      if (this.lexer.token() == 15) {
        break label702;
      }
      throw new d("syntax error");
      localType = paramArrayOfType[i];
      if ((localType == Integer.TYPE) || (localType == Integer.class))
      {
        if (this.lexer.token() == 2)
        {
          localObject = Integer.valueOf(this.lexer.intValue());
          this.lexer.nextToken(16);
        }
        else
        {
          localObject = TypeUtils.cast(parse(), localType, this.config);
        }
      }
      else
      {
        if (localType != String.class) {
          break;
        }
        if (this.lexer.token() == 4)
        {
          localObject = this.lexer.stringVal();
          this.lexer.nextToken(16);
        }
        else
        {
          localObject = TypeUtils.cast(parse(), localType, this.config);
        }
      }
    }
    boolean bool;
    if ((i == paramArrayOfType.length - 1) && ((localType instanceof Class)))
    {
      localObject = (Class)localType;
      bool = ((Class)localObject).isArray();
      localObject = ((Class)localObject).getComponentType();
    }
    for (;;)
    {
      if ((bool) && (this.lexer.token() != 14))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = this.config.getDeserializer((Type)localObject);
        int j = ((ObjectDeserializer)localObject).getFastMatchToken();
        if (this.lexer.token() != 15)
        {
          for (;;)
          {
            localArrayList.add(((ObjectDeserializer)localObject).deserialze(this, localType, null));
            if (this.lexer.token() != 16) {
              break;
            }
            this.lexer.nextToken(j);
          }
          if (this.lexer.token() != 15) {}
        }
        else
        {
          localObject = TypeUtils.cast(localArrayList, localType, this.config);
          break label187;
        }
        throw new d("syntax error :" + JSONToken.name(this.lexer.token()));
      }
      localObject = this.config.getDeserializer(localType).deserialze(this, localType, null);
      break label187;
      label610:
      if (this.lexer.token() != 16) {
        throw new d("syntax error :" + JSONToken.name(this.lexer.token()));
      }
      if (i == paramArrayOfType.length - 1) {
        this.lexer.nextToken(15);
      }
      for (;;)
      {
        i += 1;
        break;
        this.lexer.nextToken(2);
      }
      label702:
      this.lexer.nextToken(16);
      return arrayOfObject;
      localObject = null;
      bool = false;
    }
  }
  
  public Object parseArrayWithType(Type paramType)
  {
    if (this.lexer.token() == 8)
    {
      this.lexer.nextToken();
      return null;
    }
    Object localObject1 = ((ParameterizedType)paramType).getActualTypeArguments();
    if (localObject1.length != 1) {
      throw new d("not support type " + paramType);
    }
    localObject1 = localObject1[0];
    if ((localObject1 instanceof Class))
    {
      paramType = new ArrayList();
      parseArray((Class)localObject1, paramType);
      return paramType;
    }
    Object localObject2;
    if ((localObject1 instanceof WildcardType))
    {
      localObject2 = (WildcardType)localObject1;
      localObject1 = localObject2.getUpperBounds()[0];
      if (Object.class.equals(localObject1))
      {
        if (((WildcardType)localObject2).getLowerBounds().length == 0) {
          return parse();
        }
        throw new d("not support type : " + paramType);
      }
      paramType = new ArrayList();
      parseArray((Class)localObject1, paramType);
      return paramType;
    }
    if ((localObject1 instanceof TypeVariable))
    {
      localObject2 = (TypeVariable)localObject1;
      Type[] arrayOfType = ((TypeVariable)localObject2).getBounds();
      if (arrayOfType.length != 1) {
        throw new d("not support : " + localObject2);
      }
      localObject2 = arrayOfType[0];
      if ((localObject2 instanceof Class))
      {
        paramType = new ArrayList();
        parseArray((Class)localObject2, paramType);
        return paramType;
      }
    }
    if ((localObject1 instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)localObject1;
      localObject1 = new ArrayList();
      parseArray(paramType, (Collection)localObject1);
      return localObject1;
    }
    throw new d("TODO : " + paramType);
  }
  
  public void parseExtra(Object paramObject, String paramString)
  {
    this.lexer.nextTokenWithColon();
    Object localObject = null;
    Iterator localIterator1 = null;
    if (this.extraTypeProviders != null)
    {
      Iterator localIterator2 = this.extraTypeProviders.iterator();
      for (localObject = localIterator1; localIterator2.hasNext(); localObject = ((ExtraTypeProvider)localIterator2.next()).getExtraType(paramObject, paramString)) {}
    }
    if (localObject == null)
    {
      localObject = parse();
      if (!(paramObject instanceof ExtraProcessable)) {
        break label103;
      }
      ((ExtraProcessable)paramObject).processExtra(paramString, localObject);
    }
    for (;;)
    {
      return;
      localObject = parseObject((Type)localObject);
      break;
      label103:
      if (this.extraProcessors != null)
      {
        localIterator1 = this.extraProcessors.iterator();
        while (localIterator1.hasNext()) {
          ((ExtraProcessor)localIterator1.next()).processExtra(paramObject, paramString, localObject);
        }
      }
    }
  }
  
  public Object parseKey()
  {
    if (this.lexer.token() == 18)
    {
      String str = this.lexer.stringVal();
      this.lexer.nextToken(16);
      return str;
    }
    return parse(null);
  }
  
  public e parseObject()
  {
    return (e)parseObject(new e(this.lexer.isEnabled(Feature.OrderedField)));
  }
  
  public <T> T parseObject(Class<T> paramClass)
  {
    return (T)parseObject(paramClass, null);
  }
  
  public <T> T parseObject(Type paramType)
  {
    return (T)parseObject(paramType, null);
  }
  
  public <T> T parseObject(Type paramType, Object paramObject)
  {
    int i = this.lexer.token();
    if (i == 8)
    {
      this.lexer.nextToken();
      return null;
    }
    if (i == 4)
    {
      if (paramType == byte[].class)
      {
        paramType = this.lexer.bytesValue();
        this.lexer.nextToken();
        return paramType;
      }
      if (paramType == char[].class)
      {
        paramType = this.lexer.stringVal();
        this.lexer.nextToken();
        return paramType.toCharArray();
      }
    }
    ObjectDeserializer localObjectDeserializer = this.config.getDeserializer(paramType);
    try
    {
      paramType = localObjectDeserializer.deserialze(this, paramType, paramObject);
      return paramType;
    }
    catch (d paramType)
    {
      throw paramType;
    }
    catch (Throwable paramType)
    {
      throw new d(paramType.getMessage(), paramType);
    }
  }
  
  public Object parseObject(Map paramMap)
  {
    return parseObject(paramMap, null);
  }
  
  public final Object parseObject(Map paramMap, Object paramObject)
  {
    JSONLexer localJSONLexer = this.lexer;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      return null;
    }
    if (localJSONLexer.token() == 13)
    {
      localJSONLexer.nextToken();
      return paramMap;
    }
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new d("syntax error, expect {, actual " + localJSONLexer.tokenName() + ", " + localJSONLexer.info());
    }
    Object localObject1 = this.context;
    int i = 0;
    int j;
    int k;
    Object localObject2;
    label437:
    label630:
    label790:
    label814:
    label956:
    label1163:
    label1197:
    label1521:
    label1780:
    label1898:
    label1929:
    Object localObject6;
    for (;;)
    {
      localObject4 = localObject1;
      try
      {
        localJSONLexer.skipWhitespace();
        localObject4 = localObject1;
        j = localJSONLexer.getCurrent();
        k = j;
        localObject4 = localObject1;
        if (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
          for (;;)
          {
            k = j;
            if (j != 44) {
              break;
            }
            localObject4 = localObject1;
            localJSONLexer.next();
            localObject4 = localObject1;
            localJSONLexer.skipWhitespace();
            localObject4 = localObject1;
            j = localJSONLexer.getCurrent();
          }
        }
        if (k == 34)
        {
          localObject4 = localObject1;
          localObject3 = localJSONLexer.scanSymbol(this.symbolTable, '"');
          localObject4 = localObject1;
          localJSONLexer.skipWhitespace();
          localObject4 = localObject1;
          localObject2 = localObject3;
          if (localJSONLexer.getCurrent() == ':') {
            break label3139;
          }
          localObject4 = localObject1;
          throw new d("expect ':' at " + localJSONLexer.pos() + ", name " + localObject3);
        }
      }
      finally
      {
        setContext((ParseContext)localObject4);
      }
      if (k == 125)
      {
        localObject4 = localObject1;
        localJSONLexer.next();
        localObject4 = localObject1;
        localJSONLexer.resetStringPosition();
        localObject4 = localObject1;
        localJSONLexer.nextToken();
        if (i != 0) {
          break label3151;
        }
        localObject4 = localObject1;
        if (this.context != null)
        {
          localObject4 = localObject1;
          if (paramObject == this.context.fieldName)
          {
            localObject4 = localObject1;
            if (paramMap == this.context.object)
            {
              localObject4 = localObject1;
              paramObject = this.context;
            }
          }
        }
        do
        {
          setContext((ParseContext)paramObject);
          return paramMap;
          localObject4 = localObject1;
          paramObject = setContext(paramMap, paramObject);
        } while (localObject1 == null);
        break label3151;
      }
      if (k == 39)
      {
        localObject4 = localObject1;
        if (!localJSONLexer.isEnabled(Feature.AllowSingleQuotes))
        {
          localObject4 = localObject1;
          throw new d("syntax error");
        }
        localObject4 = localObject1;
        localObject2 = localJSONLexer.scanSymbol(this.symbolTable, '\'');
        localObject4 = localObject1;
        localJSONLexer.skipWhitespace();
        localObject4 = localObject1;
        if (localJSONLexer.getCurrent() == ':') {
          break label3139;
        }
        localObject4 = localObject1;
        throw new d("expect ':' at " + localJSONLexer.pos());
      }
      if (k == 26)
      {
        localObject4 = localObject1;
        throw new d("syntax error");
      }
      if (k != 44) {
        break label3157;
      }
      localObject4 = localObject1;
      throw new d("syntax error");
      localObject4 = localObject1;
      localJSONLexer.resetStringPosition();
      localObject4 = localObject1;
      localJSONLexer.scanNumber();
      localObject4 = localObject1;
      try
      {
        if (localJSONLexer.token() == 2) {
          localObject4 = localObject1;
        }
        for (localObject2 = localJSONLexer.integerValue();; localObject2 = localJSONLexer.decimalValue(true))
        {
          localObject4 = localObject1;
          if (localJSONLexer.getCurrent() == ':') {
            break;
          }
          localObject4 = localObject1;
          throw new d("parse number key error" + localJSONLexer.info());
          localObject4 = localObject1;
        }
        localObject4 = localObject1;
      }
      catch (NumberFormatException paramMap)
      {
        localObject4 = localObject1;
        throw new d("parse number key error" + localJSONLexer.info());
      }
      localJSONLexer.nextToken();
      localObject4 = localObject1;
      localObject2 = parse();
      j = 1;
      if (j == 0)
      {
        localObject4 = localObject1;
        localJSONLexer.next();
        localObject4 = localObject1;
        localJSONLexer.skipWhitespace();
      }
      localObject4 = localObject1;
      j = localJSONLexer.getCurrent();
      localObject4 = localObject1;
      localJSONLexer.resetStringPosition();
      localObject4 = localObject1;
      if (localObject2 == a.c)
      {
        localObject4 = localObject1;
        if (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))
        {
          localObject4 = localObject1;
          localObject2 = localJSONLexer.scanSymbol(this.symbolTable, '"');
          localObject4 = localObject1;
          localObject3 = TypeUtils.loadClass((String)localObject2, this.config.getDefaultClassLoader());
          if (localObject3 == null)
          {
            localObject4 = localObject1;
            paramMap.put(a.c, localObject2);
            continue;
            localObject4 = localObject1;
            if (!localJSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames))
            {
              localObject4 = localObject1;
              throw new d("syntax error");
            }
            localObject4 = localObject1;
            localObject2 = localJSONLexer.scanSymbolUnQuoted(this.symbolTable);
            localObject4 = localObject1;
            localJSONLexer.skipWhitespace();
            localObject4 = localObject1;
            char c = localJSONLexer.getCurrent();
            if (c == ':') {
              break label3139;
            }
            localObject4 = localObject1;
            throw new d("expect ':' at " + localJSONLexer.pos() + ", actual " + c);
          }
          localObject4 = localObject1;
          localJSONLexer.nextToken(16);
          localObject4 = localObject1;
          if (localJSONLexer.token() == 13)
          {
            localObject4 = localObject1;
            localJSONLexer.nextToken(16);
            localObject4 = localObject1;
            try
            {
              paramMap = this.config.getDeserializer((Type)localObject3);
              localObject4 = localObject1;
              if (!(paramMap instanceof JavaBeanDeserializer)) {
                break label3134;
              }
              localObject4 = localObject1;
              paramObject = ((JavaBeanDeserializer)paramMap).createInstance(this, (Type)localObject3);
              paramMap = (Map)paramObject;
              if (paramObject == null)
              {
                if (localObject3 != Cloneable.class) {
                  break label1197;
                }
                localObject4 = localObject1;
                paramMap = new HashMap();
              }
              for (;;)
              {
                setContext((ParseContext)localObject1);
                return paramMap;
                localObject4 = localObject1;
                if ("java.util.Collections$EmptyMap".equals(localObject2))
                {
                  localObject4 = localObject1;
                  paramMap = Collections.emptyMap();
                }
                else
                {
                  localObject4 = localObject1;
                  paramMap = ((Class)localObject3).newInstance();
                }
              }
              localObject4 = localObject1;
            }
            catch (Exception paramMap)
            {
              localObject4 = localObject1;
              throw new d("create instance error", paramMap);
            }
          }
          setResolveStatus(2);
          localObject4 = localObject1;
          if (this.context != null)
          {
            localObject4 = localObject1;
            if (!(paramObject instanceof Integer))
            {
              localObject4 = localObject1;
              popContext();
            }
          }
          localObject4 = localObject1;
          if (paramMap.size() > 0)
          {
            localObject4 = localObject1;
            paramMap = TypeUtils.cast(paramMap, (Class)localObject3, this.config);
            localObject4 = localObject1;
            parseObject(paramMap);
            setContext((ParseContext)localObject1);
            return paramMap;
          }
          localObject4 = localObject1;
          paramMap = this.config.getDeserializer((Type)localObject3).deserialze(this, (Type)localObject3, paramObject);
          setContext((ParseContext)localObject1);
          return paramMap;
        }
      }
      if (localObject2 == "$ref")
      {
        localObject4 = localObject1;
        if (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))
        {
          localObject4 = localObject1;
          localJSONLexer.nextToken(4);
          localObject4 = localObject1;
          if (localJSONLexer.token() == 4)
          {
            localObject4 = localObject1;
            localObject2 = localJSONLexer.stringVal();
            localObject4 = localObject1;
            localJSONLexer.nextToken(13);
            paramObject = null;
            paramMap = null;
            localObject4 = localObject1;
            if ("@".equals(localObject2))
            {
              localObject4 = localObject1;
              if (this.context == null) {
                break label3206;
              }
              localObject4 = localObject1;
              localObject2 = this.context;
              localObject4 = localObject1;
              paramObject = ((ParseContext)localObject2).object;
              localObject4 = localObject1;
              if ((paramObject instanceof Object[])) {
                break label3198;
              }
              localObject4 = localObject1;
              if ((paramObject instanceof Collection)) {
                break label3198;
              }
            }
            for (;;)
            {
              localObject4 = localObject1;
              if (localJSONLexer.token() == 13) {
                break label1780;
              }
              localObject4 = localObject1;
              throw new d("syntax error");
              localObject4 = localObject1;
              if (((ParseContext)localObject2).parent == null) {
                break label3200;
              }
              localObject4 = localObject1;
              paramMap = ((ParseContext)localObject2).parent.object;
              break label3200;
              localObject4 = localObject1;
              if (!"..".equals(localObject2)) {
                break;
              }
              localObject4 = localObject1;
              if (((ParseContext)localObject1).object != null)
              {
                localObject4 = localObject1;
                paramMap = ((ParseContext)localObject1).object;
              }
              else
              {
                localObject4 = localObject1;
                addResolveTask(new ResolveTask((ParseContext)localObject1, (String)localObject2));
                localObject4 = localObject1;
                setResolveStatus(1);
                paramMap = null;
              }
            }
            localObject4 = localObject1;
            if ("$".equals(localObject2))
            {
              for (paramMap = (Map)localObject1;; paramMap = paramMap.parent)
              {
                localObject4 = localObject1;
                if (paramMap.parent == null) {
                  break;
                }
                localObject4 = localObject1;
              }
              localObject4 = localObject1;
              if (paramMap.object != null)
              {
                localObject4 = localObject1;
                paramMap = paramMap.object;
                break label3203;
              }
              localObject4 = localObject1;
              addResolveTask(new ResolveTask(paramMap, (String)localObject2));
              localObject4 = localObject1;
              setResolveStatus(1);
              paramMap = (Map)paramObject;
              break label3203;
            }
            localObject4 = localObject1;
            addResolveTask(new ResolveTask((ParseContext)localObject1, (String)localObject2));
            localObject4 = localObject1;
            setResolveStatus(1);
            break label3206;
            localObject4 = localObject1;
            localJSONLexer.nextToken(16);
            setContext((ParseContext)localObject1);
            return paramMap;
          }
          localObject4 = localObject1;
          throw new d("illegal ref, " + JSONToken.name(localJSONLexer.token()));
        }
      }
      if (i != 0) {
        break label3131;
      }
      localObject4 = localObject1;
      if (this.context == null) {
        break;
      }
      localObject4 = localObject1;
      if (paramObject != this.context.fieldName) {
        break;
      }
      localObject4 = localObject1;
      if (paramMap != this.context.object) {
        break;
      }
      localObject4 = localObject1;
      localObject1 = this.context;
      localObject4 = localObject1;
      localObject3 = localObject2;
      if (paramMap.getClass() == e.class)
      {
        if (localObject2 != null) {
          break label2124;
        }
        localObject2 = "null";
        break label3211;
      }
      if (j != 34) {
        break label3228;
      }
      localObject4 = localObject1;
      localJSONLexer.scanString();
      localObject4 = localObject1;
      localObject5 = localJSONLexer.stringVal();
      localObject4 = localObject1;
      localObject2 = localObject5;
      if (localJSONLexer.isEnabled(Feature.AllowISO8601DateFormat))
      {
        localObject4 = localObject1;
        localObject6 = new JSONScanner((String)localObject5);
        localObject4 = localObject1;
        localObject2 = localObject5;
        if (((JSONScanner)localObject6).scanISO8601DateIfMatch())
        {
          localObject4 = localObject1;
          localObject2 = ((JSONScanner)localObject6).getCalendar().getTime();
        }
        localObject4 = localObject1;
        ((JSONScanner)localObject6).close();
      }
      localObject4 = localObject1;
      paramMap.put(localObject3, localObject2);
      localObject4 = localObject1;
      localJSONLexer.skipWhitespace();
      localObject4 = localObject1;
      j = localJSONLexer.getCurrent();
      if (j != 44) {
        break label2998;
      }
      localObject4 = localObject1;
      localJSONLexer.next();
    }
    Object localObject4 = localObject1;
    Object localObject5 = setContext(paramMap, paramObject);
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = localObject5;
      break label3218;
      label2124:
      localObject4 = localObject1;
      localObject2 = localObject2.toString();
    }
    for (;;)
    {
      label2138:
      localObject4 = localObject1;
      localJSONLexer.scanNumber();
      localObject4 = localObject1;
      if (localJSONLexer.token() == 2) {
        localObject4 = localObject1;
      }
      for (localObject2 = localJSONLexer.integerValue();; localObject2 = localJSONLexer.decimalValue(localJSONLexer.isEnabled(Feature.UseBigDecimal)))
      {
        localObject4 = localObject1;
        paramMap.put(localObject3, localObject2);
        break;
        localObject4 = localObject1;
      }
      label2520:
      label2751:
      label2998:
      label3116:
      label3125:
      label3131:
      label3134:
      label3139:
      label3151:
      label3157:
      label3198:
      label3200:
      label3203:
      label3206:
      label3211:
      label3218:
      label3228:
      do
      {
        if (j == 91)
        {
          localObject4 = localObject1;
          localJSONLexer.nextToken();
          localObject4 = localObject1;
          localObject5 = new b();
          if (paramObject != null)
          {
            localObject4 = localObject1;
            if (paramObject.getClass() != Integer.class) {}
          }
          if (paramObject == null)
          {
            localObject4 = localObject1;
            setContext((ParseContext)localObject1);
          }
          localObject4 = localObject1;
          parseArray((Collection)localObject5, localObject3);
          localObject4 = localObject1;
          localObject2 = localObject5;
          if (localJSONLexer.isEnabled(Feature.UseObjectArray))
          {
            localObject4 = localObject1;
            localObject2 = ((b)localObject5).toArray();
          }
          localObject4 = localObject1;
          paramMap.put(localObject3, localObject2);
          localObject4 = localObject1;
          if (localJSONLexer.token() == 13)
          {
            localObject4 = localObject1;
            localJSONLexer.nextToken();
            setContext((ParseContext)localObject1);
            return paramMap;
          }
          localObject4 = localObject1;
          if (localJSONLexer.token() == 16) {
            break;
          }
          localObject4 = localObject1;
          throw new d("syntax error");
        }
        if (j == 123)
        {
          localObject4 = localObject1;
          localJSONLexer.nextToken();
          if (paramObject != null)
          {
            localObject4 = localObject1;
            if (paramObject.getClass() == Integer.class)
            {
              j = 1;
              localObject4 = localObject1;
              localObject6 = new e(localJSONLexer.isEnabled(Feature.OrderedField));
              if (j != 0) {
                break label3125;
              }
              localObject4 = localObject1;
            }
          }
        }
        for (localObject5 = setContext((ParseContext)localObject1, localObject6, localObject3);; localObject5 = null)
        {
          localObject4 = localObject1;
          if (this.fieldTypeResolver != null) {
            if (localObject3 != null)
            {
              localObject4 = localObject1;
              localObject2 = localObject3.toString();
              localObject4 = localObject1;
              localObject2 = this.fieldTypeResolver.resolve(paramMap, (String)localObject2);
              if (localObject2 == null) {
                break label3116;
              }
              localObject4 = localObject1;
              localObject2 = this.config.getDeserializer((Type)localObject2).deserialze(this, (Type)localObject2, localObject3);
            }
          }
          for (k = 1;; k = 0)
          {
            if (k == 0)
            {
              localObject4 = localObject1;
              localObject2 = parseObject((Map)localObject6, localObject3);
            }
            if ((localObject5 != null) && (localObject6 != localObject2))
            {
              localObject4 = localObject1;
              ((ParseContext)localObject5).object = paramMap;
            }
            localObject4 = localObject1;
            checkMapResolve(paramMap, localObject3.toString());
            localObject4 = localObject1;
            if (paramMap.getClass() == e.class)
            {
              localObject4 = localObject1;
              paramMap.put(localObject3.toString(), localObject2);
            }
            for (;;)
            {
              if (j != 0)
              {
                localObject4 = localObject1;
                setContext(localObject2, localObject3);
              }
              localObject4 = localObject1;
              if (localJSONLexer.token() != 13) {
                break label2751;
              }
              localObject4 = localObject1;
              localJSONLexer.nextToken();
              localObject4 = localObject1;
              setContext((ParseContext)localObject1);
              setContext((ParseContext)localObject1);
              return paramMap;
              j = 0;
              break;
              localObject2 = null;
              break label2520;
              localObject4 = localObject1;
              paramMap.put(localObject3, localObject2);
            }
            localObject4 = localObject1;
            if (localJSONLexer.token() == 16)
            {
              if (j != 0)
              {
                localObject4 = localObject1;
                popContext();
                break;
              }
              localObject4 = localObject1;
              setContext((ParseContext)localObject1);
              break;
            }
            localObject4 = localObject1;
            throw new d("syntax error, " + localJSONLexer.tokenName());
            localObject4 = localObject1;
            localJSONLexer.nextToken();
            localObject4 = localObject1;
            localObject5 = parse();
            localObject4 = localObject1;
            if (paramMap.getClass() == e.class) {
              localObject4 = localObject1;
            }
            for (localObject2 = localObject3.toString();; localObject2 = localObject3)
            {
              localObject4 = localObject1;
              paramMap.put(localObject2, localObject5);
              localObject4 = localObject1;
              if (localJSONLexer.token() == 13)
              {
                localObject4 = localObject1;
                localJSONLexer.nextToken();
                setContext((ParseContext)localObject1);
                return paramMap;
              }
              localObject4 = localObject1;
              if (localJSONLexer.token() == 16) {
                break;
              }
              localObject4 = localObject1;
              throw new d("syntax error, position at " + localJSONLexer.pos() + ", name " + localObject2);
              if (j == 125)
              {
                localObject4 = localObject1;
                localJSONLexer.next();
                localObject4 = localObject1;
                localJSONLexer.resetStringPosition();
                localObject4 = localObject1;
                localJSONLexer.nextToken();
                localObject4 = localObject1;
                setContext(localObject2, localObject3);
                setContext((ParseContext)localObject1);
                return paramMap;
              }
              localObject4 = localObject1;
              throw new d("syntax error, position at " + localJSONLexer.pos() + ", name " + localObject3);
            }
            localObject2 = null;
          }
        }
        break label1898;
        paramObject = null;
        break label1163;
        j = 0;
        break label814;
        j = 0;
        break label814;
        paramObject = localObject1;
        break label437;
        if (((k >= 48) && (k <= 57)) || (k == 45)) {
          break label630;
        }
        if (k == 123) {
          break label790;
        }
        if (k != 91) {
          break label956;
        }
        break label790;
        paramMap = (Map)paramObject;
        break label1521;
        break label1521;
        paramMap = null;
        break label1521;
        localObject3 = localObject2;
        break label1929;
        i = 1;
        localObject1 = localObject3;
        break label1898;
        if ((j >= 48) && (j <= 57)) {
          break label2138;
        }
      } while (j != 45);
    }
  }
  
  public void parseObject(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    Object localObject1 = this.config.getDeserializer(localClass);
    if ((localObject1 instanceof JavaBeanDeserializer)) {}
    for (JavaBeanDeserializer localJavaBeanDeserializer = (JavaBeanDeserializer)localObject1;; localJavaBeanDeserializer = null)
    {
      if ((this.lexer.token() != 12) && (this.lexer.token() != 16)) {
        throw new d("syntax error, expect {, actual " + this.lexer.tokenName());
      }
      while ((this.lexer.token() == 16) && (this.lexer.isEnabled(Feature.AllowArbitraryCommas)))
      {
        localObject1 = this.lexer.scanSymbol(this.symbolTable);
        if (localObject1 == null) {
          if (this.lexer.token() == 13)
          {
            this.lexer.nextToken(16);
            return;
          }
        }
      }
      if (localJavaBeanDeserializer != null) {}
      for (FieldDeserializer localFieldDeserializer = localJavaBeanDeserializer.getFieldDeserializer((String)localObject1);; localFieldDeserializer = null)
      {
        if (localFieldDeserializer == null)
        {
          if (!this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
            throw new d("setter not found, class " + localClass.getName() + ", property " + (String)localObject1);
          }
          this.lexer.nextTokenWithColon();
          parse();
          if (this.lexer.token() != 13) {
            break;
          }
          this.lexer.nextToken();
          return;
        }
        Object localObject2 = localFieldDeserializer.fieldInfo.fieldClass;
        localObject1 = localFieldDeserializer.fieldInfo.fieldType;
        if (localObject2 == Integer.TYPE)
        {
          this.lexer.nextTokenWithColon(2);
          localObject1 = IntegerCodec.instance.deserialze(this, (Type)localObject1, null);
        }
        for (;;)
        {
          localFieldDeserializer.setValue(paramObject, localObject1);
          if ((this.lexer.token() == 16) || (this.lexer.token() != 13)) {
            break;
          }
          this.lexer.nextToken(16);
          return;
          if (localObject2 == String.class)
          {
            this.lexer.nextTokenWithColon(4);
            localObject1 = StringCodec.deserialze(this);
          }
          else if (localObject2 == Long.TYPE)
          {
            this.lexer.nextTokenWithColon(2);
            localObject1 = LongCodec.instance.deserialze(this, (Type)localObject1, null);
          }
          else
          {
            localObject2 = this.config.getDeserializer((Class)localObject2, (Type)localObject1);
            this.lexer.nextTokenWithColon(((ObjectDeserializer)localObject2).getFastMatchToken());
            localObject1 = ((ObjectDeserializer)localObject2).deserialze(this, (Type)localObject1, null);
          }
        }
      }
    }
  }
  
  public void popContext()
  {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
      return;
    }
    this.context = this.context.parent;
    this.contextArray[(this.contextArrayIndex - 1)] = null;
    this.contextArrayIndex -= 1;
  }
  
  public void setConfig(ParserConfig paramParserConfig)
  {
    this.config = paramParserConfig;
  }
  
  public ParseContext setContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2)
  {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
      return null;
    }
    this.context = new ParseContext(paramParseContext, paramObject1, paramObject2);
    addContext(this.context);
    return this.context;
  }
  
  public ParseContext setContext(Object paramObject1, Object paramObject2)
  {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
      return null;
    }
    return setContext(this.context, paramObject1, paramObject2);
  }
  
  public void setContext(ParseContext paramParseContext)
  {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
      return;
    }
    this.context = paramParseContext;
  }
  
  public void setDateFomrat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    this.dateFormat = null;
  }
  
  public void setFieldTypeResolver(FieldTypeResolver paramFieldTypeResolver)
  {
    this.fieldTypeResolver = paramFieldTypeResolver;
  }
  
  public void setResolveStatus(int paramInt)
  {
    this.resolveStatus = paramInt;
  }
  
  public void throwException(int paramInt)
  {
    throw new d("syntax error, expect " + JSONToken.name(paramInt) + ", actual " + JSONToken.name(this.lexer.token()));
  }
  
  public static class ResolveTask
  {
    public final ParseContext context;
    public FieldDeserializer fieldDeserializer;
    public ParseContext ownerContext;
    public final String referenceValue;
    
    public ResolveTask(ParseContext paramParseContext, String paramString)
    {
      this.context = paramParseContext;
      this.referenceValue = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/DefaultJSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */