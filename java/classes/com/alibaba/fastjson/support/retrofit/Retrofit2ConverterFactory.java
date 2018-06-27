package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public class Retrofit2ConverterFactory
  extends Converter.Factory
{
  private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
  private int featureValues = a.f;
  private Feature[] features;
  private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
  private SerializeConfig serializeConfig;
  private SerializerFeature[] serializerFeatures;
  
  public ParserConfig getParserConfig()
  {
    return this.parserConfig;
  }
  
  public int getParserFeatureValues()
  {
    return this.featureValues;
  }
  
  public Feature[] getParserFeatures()
  {
    return this.features;
  }
  
  public SerializeConfig getSerializeConfig()
  {
    return this.serializeConfig;
  }
  
  public SerializerFeature[] getSerializerFeatures()
  {
    return this.serializerFeatures;
  }
  
  public Converter<?, RequestBody> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
  {
    return new RequestBodyConverter();
  }
  
  public Converter<ResponseBody, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    return new ResponseBodyConverter(paramType);
  }
  
  public Retrofit2ConverterFactory setParserConfig(ParserConfig paramParserConfig)
  {
    this.parserConfig = paramParserConfig;
    return this;
  }
  
  public Retrofit2ConverterFactory setParserFeatureValues(int paramInt)
  {
    this.featureValues = paramInt;
    return this;
  }
  
  public Retrofit2ConverterFactory setParserFeatures(Feature[] paramArrayOfFeature)
  {
    this.features = paramArrayOfFeature;
    return this;
  }
  
  public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig paramSerializeConfig)
  {
    this.serializeConfig = paramSerializeConfig;
    return this;
  }
  
  public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] paramArrayOfSerializerFeature)
  {
    this.serializerFeatures = paramArrayOfSerializerFeature;
    return this;
  }
  
  final class RequestBodyConverter<T>
    implements Converter<T, RequestBody>
  {
    RequestBodyConverter() {}
    
    public RequestBody convert(T paramT)
      throws IOException
    {
      SerializeConfig localSerializeConfig;
      if (Retrofit2ConverterFactory.this.serializeConfig == null)
      {
        localSerializeConfig = SerializeConfig.globalInstance;
        if (Retrofit2ConverterFactory.this.serializerFeatures != null) {
          break label54;
        }
      }
      label54:
      for (SerializerFeature[] arrayOfSerializerFeature = SerializerFeature.EMPTY;; arrayOfSerializerFeature = Retrofit2ConverterFactory.this.serializerFeatures)
      {
        paramT = a.toJSONBytes(paramT, localSerializeConfig, arrayOfSerializerFeature);
        return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, paramT);
        localSerializeConfig = Retrofit2ConverterFactory.this.serializeConfig;
        break;
      }
    }
  }
  
  final class ResponseBodyConverter<T>
    implements Converter<ResponseBody, T>
  {
    private Type type;
    
    ResponseBodyConverter(Type paramType)
    {
      this.type = paramType;
    }
    
    /* Error */
    public T convert(ResponseBody paramResponseBody)
      throws IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 38	okhttp3/ResponseBody:string	()Ljava/lang/String;
      //   4: astore 4
      //   6: aload_0
      //   7: getfield 23	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory$ResponseBodyConverter:type	Ljava/lang/reflect/Type;
      //   10: astore 5
      //   12: aload_0
      //   13: getfield 18	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory$ResponseBodyConverter:this$0	Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;
      //   16: invokestatic 42	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory:access$000	(Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;)Lcom/alibaba/fastjson/parser/ParserConfig;
      //   19: astore 6
      //   21: aload_0
      //   22: getfield 18	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory$ResponseBodyConverter:this$0	Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;
      //   25: invokestatic 46	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory:access$100	(Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;)I
      //   28: istore_2
      //   29: aload_0
      //   30: getfield 18	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory$ResponseBodyConverter:this$0	Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;
      //   33: invokestatic 50	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory:access$200	(Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;)[Lcom/alibaba/fastjson/parser/Feature;
      //   36: ifnull +29 -> 65
      //   39: aload_0
      //   40: getfield 18	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory$ResponseBodyConverter:this$0	Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;
      //   43: invokestatic 50	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory:access$200	(Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;)[Lcom/alibaba/fastjson/parser/Feature;
      //   46: astore_3
      //   47: aload 4
      //   49: aload 5
      //   51: aload 6
      //   53: iload_2
      //   54: aload_3
      //   55: invokestatic 56	com/alibaba/fastjson/a:parseObject	(Ljava/lang/String;Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/parser/ParserConfig;I[Lcom/alibaba/fastjson/parser/Feature;)Ljava/lang/Object;
      //   58: astore_3
      //   59: aload_1
      //   60: invokevirtual 59	okhttp3/ResponseBody:close	()V
      //   63: aload_3
      //   64: areturn
      //   65: invokestatic 63	com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory:access$300	()[Lcom/alibaba/fastjson/parser/Feature;
      //   68: astore_3
      //   69: goto -22 -> 47
      //   72: astore_3
      //   73: aload_1
      //   74: invokevirtual 59	okhttp3/ResponseBody:close	()V
      //   77: aload_3
      //   78: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	79	0	this	ResponseBodyConverter
      //   0	79	1	paramResponseBody	ResponseBody
      //   28	26	2	i	int
      //   46	23	3	localObject1	Object
      //   72	6	3	localObject2	Object
      //   4	44	4	str	String
      //   10	40	5	localType	Type
      //   19	33	6	localParserConfig	ParserConfig
      // Exception table:
      //   from	to	target	type
      //   0	47	72	finally
      //   47	59	72	finally
      //   65	69	72	finally
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */