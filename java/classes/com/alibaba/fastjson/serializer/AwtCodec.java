package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

public class AwtCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final AwtCodec instance = new AwtCodec();
  
  private Object parseRef(DefaultJSONParser paramDefaultJSONParser, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    localJSONLexer.nextTokenWithColon(4);
    String str = localJSONLexer.stringVal();
    paramDefaultJSONParser.setContext(paramDefaultJSONParser.getContext(), paramObject);
    paramDefaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(paramDefaultJSONParser.getContext(), str));
    paramDefaultJSONParser.popContext();
    paramDefaultJSONParser.setResolveStatus(1);
    localJSONLexer.nextToken(13);
    paramDefaultJSONParser.accept(13);
    return null;
  }
  
  public static boolean support(Class<?> paramClass)
  {
    return (paramClass == Point.class) || (paramClass == Rectangle.class) || (paramClass == Font.class) || (paramClass == Color.class);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject = paramDefaultJSONParser.lexer;
    if (((JSONLexer)localObject).token() == 8)
    {
      ((JSONLexer)localObject).nextToken(16);
      return null;
    }
    if ((((JSONLexer)localObject).token() != 12) && (((JSONLexer)localObject).token() != 16)) {
      throw new d("syntax error");
    }
    ((JSONLexer)localObject).nextToken();
    if (paramType == Point.class) {
      paramType = parsePoint(paramDefaultJSONParser, paramObject);
    }
    for (;;)
    {
      localObject = paramDefaultJSONParser.getContext();
      paramDefaultJSONParser.setContext(paramType, paramObject);
      paramDefaultJSONParser.setContext((ParseContext)localObject);
      return paramType;
      if (paramType == Rectangle.class)
      {
        paramType = parseRectangle(paramDefaultJSONParser);
      }
      else if (paramType == Color.class)
      {
        paramType = parseColor(paramDefaultJSONParser);
      }
      else
      {
        if (paramType != Font.class) {
          break;
        }
        paramType = parseFont(paramDefaultJSONParser);
      }
    }
    throw new d("not support awt class : " + paramType);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  protected Color parseColor(DefaultJSONParser paramDefaultJSONParser)
  {
    int n = 0;
    paramDefaultJSONParser = paramDefaultJSONParser.lexer;
    int m = 0;
    int k = 0;
    int j = 0;
    if (paramDefaultJSONParser.token() == 13)
    {
      paramDefaultJSONParser.nextToken();
      return new Color(j, k, m, n);
    }
    String str;
    int i;
    int i3;
    int i2;
    int i1;
    if (paramDefaultJSONParser.token() == 4)
    {
      str = paramDefaultJSONParser.stringVal();
      paramDefaultJSONParser.nextTokenWithColon(2);
      if (paramDefaultJSONParser.token() != 2) {
        break label179;
      }
      i = paramDefaultJSONParser.intValue();
      paramDefaultJSONParser.nextToken();
      if (!str.equalsIgnoreCase("r")) {
        break label189;
      }
      i3 = i;
      i2 = k;
      i1 = m;
      i = n;
    }
    for (;;)
    {
      n = i;
      m = i1;
      k = i2;
      j = i3;
      if (paramDefaultJSONParser.token() != 16) {
        break;
      }
      paramDefaultJSONParser.nextToken(4);
      n = i;
      m = i1;
      k = i2;
      j = i3;
      break;
      throw new d("syntax error");
      label179:
      throw new d("syntax error");
      label189:
      if (str.equalsIgnoreCase("g"))
      {
        i2 = i;
        i = n;
        i1 = m;
        i3 = j;
      }
      else if (str.equalsIgnoreCase("b"))
      {
        i1 = i;
        i = n;
        i2 = k;
        i3 = j;
      }
      else
      {
        if (!str.equalsIgnoreCase("alpha")) {
          break label265;
        }
        i1 = m;
        i2 = k;
        i3 = j;
      }
    }
    label265:
    throw new d("syntax error, " + str);
  }
  
  protected Font parseFont(DefaultJSONParser paramDefaultJSONParser)
  {
    int j = 0;
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    paramDefaultJSONParser = null;
    int i = 0;
    if (localJSONLexer.token() == 13)
    {
      localJSONLexer.nextToken();
      return new Font(paramDefaultJSONParser, j, i);
    }
    Object localObject;
    int m;
    int k;
    if (localJSONLexer.token() == 4)
    {
      localObject = localJSONLexer.stringVal();
      localJSONLexer.nextTokenWithColon(2);
      if (!((String)localObject).equalsIgnoreCase("name")) {
        break label174;
      }
      if (localJSONLexer.token() != 4) {
        break label164;
      }
      localObject = localJSONLexer.stringVal();
      localJSONLexer.nextToken();
      m = i;
      k = j;
    }
    for (;;)
    {
      paramDefaultJSONParser = (DefaultJSONParser)localObject;
      j = k;
      i = m;
      if (localJSONLexer.token() != 16) {
        break;
      }
      localJSONLexer.nextToken(4);
      paramDefaultJSONParser = (DefaultJSONParser)localObject;
      j = k;
      i = m;
      break;
      throw new d("syntax error");
      label164:
      throw new d("syntax error");
      label174:
      if (((String)localObject).equalsIgnoreCase("style"))
      {
        if (localJSONLexer.token() == 2)
        {
          k = localJSONLexer.intValue();
          localJSONLexer.nextToken();
          localObject = paramDefaultJSONParser;
          m = i;
        }
        else
        {
          throw new d("syntax error");
        }
      }
      else
      {
        if (!((String)localObject).equalsIgnoreCase("size")) {
          break label286;
        }
        if (localJSONLexer.token() != 2) {
          break label276;
        }
        m = localJSONLexer.intValue();
        localJSONLexer.nextToken();
        localObject = paramDefaultJSONParser;
        k = j;
      }
    }
    label276:
    throw new d("syntax error");
    label286:
    throw new d("syntax error, " + (String)localObject);
  }
  
  protected Point parsePoint(DefaultJSONParser paramDefaultJSONParser, Object paramObject)
  {
    int k = 0;
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    int j = 0;
    String str;
    for (;;)
    {
      if (localJSONLexer.token() == 13)
      {
        localJSONLexer.nextToken();
        return new Point(j, k);
      }
      if (localJSONLexer.token() != 4) {
        break label192;
      }
      str = localJSONLexer.stringVal();
      if (!a.c.equals(str)) {
        break;
      }
      paramDefaultJSONParser.acceptType("java.awt.Point");
    }
    if ("$ref".equals(str)) {
      return (Point)parseRef(paramDefaultJSONParser, paramObject);
    }
    localJSONLexer.nextTokenWithColon(2);
    int i = localJSONLexer.token();
    label139:
    int m;
    if (i == 2)
    {
      i = localJSONLexer.intValue();
      localJSONLexer.nextToken();
      if (!str.equalsIgnoreCase("x")) {
        break label259;
      }
      m = i;
      i = k;
    }
    for (;;)
    {
      k = i;
      j = m;
      if (localJSONLexer.token() != 16) {
        break;
      }
      localJSONLexer.nextToken(4);
      k = i;
      j = m;
      break;
      label192:
      throw new d("syntax error");
      if (i == 3)
      {
        i = (int)localJSONLexer.floatValue();
        localJSONLexer.nextToken();
        break label139;
      }
      throw new d("syntax error : " + localJSONLexer.tokenName());
      label259:
      if (!str.equalsIgnoreCase("y")) {
        break label276;
      }
      m = j;
    }
    label276:
    throw new d("syntax error, " + str);
  }
  
  protected Rectangle parseRectangle(DefaultJSONParser paramDefaultJSONParser)
  {
    int n = 0;
    paramDefaultJSONParser = paramDefaultJSONParser.lexer;
    int m = 0;
    int k = 0;
    int j = 0;
    if (paramDefaultJSONParser.token() == 13)
    {
      paramDefaultJSONParser.nextToken();
      return new Rectangle(j, k, m, n);
    }
    String str;
    int i;
    label98:
    int i3;
    int i2;
    int i1;
    if (paramDefaultJSONParser.token() == 4)
    {
      str = paramDefaultJSONParser.stringVal();
      paramDefaultJSONParser.nextTokenWithColon(2);
      i = paramDefaultJSONParser.token();
      if (i != 2) {
        break label181;
      }
      i = paramDefaultJSONParser.intValue();
      paramDefaultJSONParser.nextToken();
      if (!str.equalsIgnoreCase("x")) {
        break label213;
      }
      i3 = i;
      i2 = k;
      i1 = m;
      i = n;
    }
    for (;;)
    {
      n = i;
      m = i1;
      k = i2;
      j = i3;
      if (paramDefaultJSONParser.token() != 16) {
        break;
      }
      paramDefaultJSONParser.nextToken(4);
      n = i;
      m = i1;
      k = i2;
      j = i3;
      break;
      throw new d("syntax error");
      label181:
      if (i == 3)
      {
        i = (int)paramDefaultJSONParser.floatValue();
        paramDefaultJSONParser.nextToken();
        break label98;
      }
      throw new d("syntax error");
      label213:
      if (str.equalsIgnoreCase("y"))
      {
        i2 = i;
        i = n;
        i1 = m;
        i3 = j;
      }
      else if (str.equalsIgnoreCase("width"))
      {
        i1 = i;
        i = n;
        i2 = k;
        i3 = j;
      }
      else
      {
        if (!str.equalsIgnoreCase("height")) {
          break label289;
        }
        i1 = m;
        i2 = k;
        i3 = j;
      }
    }
    label289:
    throw new d("syntax error, " + str);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull();
      return;
    }
    if ((paramObject1 instanceof Point))
    {
      paramObject1 = (Point)paramObject1;
      paramJSONSerializer.writeFieldValue(writeClassName(paramJSONSerializer, Point.class, '{'), "x", ((Point)paramObject1).x);
      paramJSONSerializer.writeFieldValue(',', "y", ((Point)paramObject1).y);
    }
    for (;;)
    {
      paramJSONSerializer.write(125);
      return;
      if ((paramObject1 instanceof Font))
      {
        paramObject1 = (Font)paramObject1;
        paramJSONSerializer.writeFieldValue(writeClassName(paramJSONSerializer, Font.class, '{'), "name", ((Font)paramObject1).getName());
        paramJSONSerializer.writeFieldValue(',', "style", ((Font)paramObject1).getStyle());
        paramJSONSerializer.writeFieldValue(',', "size", ((Font)paramObject1).getSize());
      }
      else if ((paramObject1 instanceof Rectangle))
      {
        paramObject1 = (Rectangle)paramObject1;
        paramJSONSerializer.writeFieldValue(writeClassName(paramJSONSerializer, Rectangle.class, '{'), "x", ((Rectangle)paramObject1).x);
        paramJSONSerializer.writeFieldValue(',', "y", ((Rectangle)paramObject1).y);
        paramJSONSerializer.writeFieldValue(',', "width", ((Rectangle)paramObject1).width);
        paramJSONSerializer.writeFieldValue(',', "height", ((Rectangle)paramObject1).height);
      }
      else
      {
        if (!(paramObject1 instanceof Color)) {
          break;
        }
        paramObject1 = (Color)paramObject1;
        paramJSONSerializer.writeFieldValue(writeClassName(paramJSONSerializer, Color.class, '{'), "r", ((Color)paramObject1).getRed());
        paramJSONSerializer.writeFieldValue(',', "g", ((Color)paramObject1).getGreen());
        paramJSONSerializer.writeFieldValue(',', "b", ((Color)paramObject1).getBlue());
        if (((Color)paramObject1).getAlpha() > 0) {
          paramJSONSerializer.writeFieldValue(',', "alpha", ((Color)paramObject1).getAlpha());
        }
      }
    }
    throw new d("not support awt class : " + paramObject1.getClass().getName());
  }
  
  protected char writeClassName(SerializeWriter paramSerializeWriter, Class<?> paramClass, char paramChar)
  {
    if (paramSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
    {
      paramSerializeWriter.write(123);
      paramSerializeWriter.writeFieldName(a.c);
      paramSerializeWriter.writeString(paramClass.getName());
      paramChar = ',';
    }
    return paramChar;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/AwtCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */