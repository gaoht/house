package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListTypeFieldDeserializer
  extends FieldDeserializer
{
  private ObjectDeserializer deserializer;
  private int itemFastMatchToken;
  private final Type itemType;
  
  public ArrayListTypeFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
    if ((paramFieldInfo.fieldType instanceof ParameterizedType))
    {
      paramClass = ((ParameterizedType)paramFieldInfo.fieldType).getActualTypeArguments()[0];
      paramParserConfig = paramClass;
      if ((paramClass instanceof WildcardType))
      {
        paramFieldInfo = ((WildcardType)paramClass).getUpperBounds();
        paramParserConfig = paramClass;
        if (paramFieldInfo.length == 1) {
          paramParserConfig = paramFieldInfo[0];
        }
      }
      this.itemType = paramParserConfig;
      return;
    }
    this.itemType = Object.class;
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public final void parseArray(DefaultJSONParser paramDefaultJSONParser, Type paramType, Collection paramCollection)
  {
    Type localType = this.itemType;
    Object localObject3 = this.deserializer;
    Object localObject2 = localType;
    Object localObject1 = localObject3;
    if ((paramType instanceof ParameterizedType))
    {
      if (!(localType instanceof TypeVariable)) {
        break label287;
      }
      localObject1 = (TypeVariable)localType;
      localObject2 = (ParameterizedType)paramType;
      if (!(((ParameterizedType)localObject2).getRawType() instanceof Class)) {
        break label659;
      }
    }
    label243:
    label287:
    label405:
    label506:
    label586:
    label659:
    for (paramType = (Class)((ParameterizedType)localObject2).getRawType();; paramType = null)
    {
      int i;
      int j;
      if (paramType != null)
      {
        i = 0;
        j = paramType.getTypeParameters().length;
        if (i < j) {
          if (!paramType.getTypeParameters()[i].getName().equals(((TypeVariable)localObject1).getName())) {}
        }
      }
      for (;;)
      {
        paramType = localType;
        if (i != -1)
        {
          localObject1 = localObject2.getActualTypeArguments()[i];
          paramType = (Type)localObject1;
          if (!localObject1.equals(this.itemType))
          {
            localObject2 = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject1);
            paramType = (Type)localObject1;
          }
        }
        for (localObject1 = localObject2;; localObject1 = localObject3)
        {
          localObject2 = paramType;
          ParameterizedType localParameterizedType1;
          Type[] arrayOfType;
          do
          {
            do
            {
              do
              {
                localObject3 = paramDefaultJSONParser.lexer;
                if (((JSONLexer)localObject3).token() != 14) {
                  break label586;
                }
                paramType = (Type)localObject1;
                if (localObject1 == null)
                {
                  paramType = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject2);
                  this.deserializer = paramType;
                  this.itemFastMatchToken = this.deserializer.getFastMatchToken();
                }
                ((JSONLexer)localObject3).nextToken(this.itemFastMatchToken);
                i = 0;
                if (!((JSONLexer)localObject3).isEnabled(Feature.AllowArbitraryCommas)) {
                  break label506;
                }
                while (((JSONLexer)localObject3).token() == 16) {
                  ((JSONLexer)localObject3).nextToken();
                }
                i += 1;
                break;
                localObject2 = localType;
                localObject1 = localObject3;
              } while (!(localType instanceof ParameterizedType));
              localParameterizedType1 = (ParameterizedType)localType;
              arrayOfType = localParameterizedType1.getActualTypeArguments();
              localObject2 = localType;
              localObject1 = localObject3;
            } while (arrayOfType.length != 1);
            localObject2 = localType;
            localObject1 = localObject3;
          } while (!(arrayOfType[0] instanceof TypeVariable));
          localObject1 = (TypeVariable)arrayOfType[0];
          ParameterizedType localParameterizedType2 = (ParameterizedType)paramType;
          if ((localParameterizedType2.getRawType() instanceof Class)) {}
          for (paramType = (Class)localParameterizedType2.getRawType();; paramType = null)
          {
            if (paramType != null)
            {
              i = 0;
              j = paramType.getTypeParameters().length;
              if (i < j) {
                if (!paramType.getTypeParameters()[i].getName().equals(((TypeVariable)localObject1).getName())) {}
              }
            }
            for (;;)
            {
              localObject2 = localType;
              localObject1 = localObject3;
              if (i == -1) {
                break;
              }
              arrayOfType[0] = localParameterizedType2.getActualTypeArguments()[i];
              localObject2 = new ParameterizedTypeImpl(arrayOfType, localParameterizedType1.getOwnerType(), localParameterizedType1.getRawType());
              localObject1 = localObject3;
              break;
              i += 1;
              break label405;
              if (((JSONLexer)localObject3).token() == 15)
              {
                ((JSONLexer)localObject3).nextToken(16);
                return;
              }
              paramCollection.add(paramType.deserialze(paramDefaultJSONParser, (Type)localObject2, Integer.valueOf(i)));
              paramDefaultJSONParser.checkListResolve(paramCollection);
              if (((JSONLexer)localObject3).token() == 16) {
                ((JSONLexer)localObject3).nextToken(this.itemFastMatchToken);
              }
              i += 1;
              break label243;
              paramType = (Type)localObject1;
              if (localObject1 == null)
              {
                paramType = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject2);
                this.deserializer = paramType;
              }
              paramCollection.add(paramType.deserialze(paramDefaultJSONParser, (Type)localObject2, Integer.valueOf(0)));
              paramDefaultJSONParser.checkListResolve(paramCollection);
              return;
              i = -1;
            }
          }
        }
        i = -1;
      }
    }
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (paramDefaultJSONParser.lexer.token() == 8)
    {
      setValue(paramObject, null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ParseContext localParseContext = paramDefaultJSONParser.getContext();
    paramDefaultJSONParser.setContext(localParseContext, paramObject, this.fieldInfo.name);
    parseArray(paramDefaultJSONParser, paramType, localArrayList);
    paramDefaultJSONParser.setContext(localParseContext);
    if (paramObject == null)
    {
      paramMap.put(this.fieldInfo.name, localArrayList);
      return;
    }
    setValue(paramObject, localArrayList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */