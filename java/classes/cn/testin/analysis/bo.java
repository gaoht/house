package cn.testin.analysis;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bo
{
  private static final Class<?>[] d = new Class[0];
  private static final List<by> e = Collections.emptyList();
  private final cd a;
  private final an b;
  private dl c;
  
  public bo(cd paramcd, an paraman, dl paramdl)
  {
    this.a = paramcd;
    this.b = paraman;
    this.c = paramdl;
  }
  
  private bq a(JSONObject paramJSONObject, List<String> paramList)
  {
    try
    {
      if (paramJSONObject.isNull("url")) {
        throw new dg("Can't construct a BitmapDrawable with a null url");
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw new dg("Couldn't read drawable description", paramJSONObject);
    }
    String str = paramJSONObject.getString("url");
    if (TextUtils.isEmpty(str)) {
      throw new dg("Can't construct a BitmapDrawable with a null url");
    }
    if (!str.startsWith("@"))
    {
      boolean bool = paramList.contains(str);
      if (bool) {}
    }
    try
    {
      this.b.a(str);
      paramList.add(str);
      return new bq(str, paramJSONObject.optBoolean("isLimit", false));
    }
    catch (ap paramJSONObject)
    {
      throw new dh(paramJSONObject.getMessage(), paramJSONObject.getCause());
    }
  }
  
  private cc a(Class<?> paramClass, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("name");
        if (paramJSONObject.has("get"))
        {
          Object localObject2 = paramJSONObject.getJSONObject("get");
          localObject1 = ((JSONObject)localObject2).getString("selector");
          localObject2 = Class.forName(((JSONObject)localObject2).getJSONObject("result").getString("type"));
          localObject1 = cz.a(paramClass, (String)localObject1, d, (Class)localObject2, this.b, this.c);
          if (paramJSONObject.has("set"))
          {
            paramJSONObject = paramJSONObject.getJSONObject("set").getString("selector");
            paramClass = new cc(str, paramClass, (cz)localObject1, paramJSONObject, this.b, this.c);
            return paramClass;
          }
          paramJSONObject = null;
          continue;
        }
        Object localObject1 = null;
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new dg("Can't create property reader", paramClass);
      }
      catch (JSONException paramClass)
      {
        throw new dg("Can't read property JSON", paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new dg("Can't read property JSON, relevant arg/return class not found", paramClass);
      }
    }
  }
  
  private Integer a(int paramInt, String paramString, cd paramcd)
  {
    if (paramString != null) {
      if (!paramcd.a(paramString)) {}
    }
    for (int i = paramcd.b(paramString); (-1 != i) && (-1 != paramInt) && (i != paramInt); i = -1)
    {
      Log.e("Protocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
      return null;
      Log.w("Protocol", "Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"" + paramString + "\"");
      return null;
    }
    if (-1 != i) {
      return Integer.valueOf(i);
    }
    return Integer.valueOf(paramInt);
  }
  
  private Object a(Object paramObject, String paramString, List<String> paramList)
  {
    try
    {
      if ("java.lang.CharSequence".equals(paramString)) {
        return paramObject;
      }
      if ((!"boolean".equals(paramString)) && (!"java.lang.Boolean".equals(paramString)))
      {
        if (("int".equals(paramString)) || ("java.lang.Integer".equals(paramString))) {
          return Integer.valueOf(((Number)paramObject).intValue());
        }
        if (("float".equals(paramString)) || ("java.lang.Float".equals(paramString))) {
          return Float.valueOf(((Number)paramObject).floatValue());
        }
        if ("android.graphics.drawable.Drawable".equals(paramString)) {
          return a((JSONObject)paramObject, paramList);
        }
        if ("android.graphics.drawable.BitmapDrawable".equals(paramString)) {
          return a((JSONObject)paramObject, paramList);
        }
        if ("android.graphics.drawable.ColorDrawable".equals(paramString)) {
          return Integer.valueOf(((Number)paramObject).intValue());
        }
        if (!"android.graphics.Typeface".equals(paramString))
        {
          if ("android.content.res.ColorStateList".equals(paramString)) {
            return ColorStateList.valueOf(((Number)paramObject).intValue());
          }
          if ("android.widget.ImageView$ScaleType".equals(paramString)) {
            return ImageView.ScaleType.valueOf((String)paramObject);
          }
          throw new dg("Don't know how to interpret type " + paramString + " (arg was " + paramObject + ")");
        }
      }
    }
    catch (ClassCastException paramList)
    {
      throw new dg("Couldn't interpret <" + paramObject + "> as " + paramString);
    }
    return paramObject;
  }
  
  public br a(JSONObject paramJSONObject, cs paramcs)
  {
    String str2;
    try
    {
      String str1 = paramJSONObject.getString("event_name");
      str2 = paramJSONObject.getString("event_type");
      String str3 = paramJSONObject.optString("id");
      String str4 = paramJSONObject.optString("exp_id");
      String str5 = paramJSONObject.getString("target_activity");
      paramJSONObject = paramJSONObject.getJSONArray("path");
      if ("click".equals(str2)) {
        return new br(new cn(1, str1, str3, str4, paramcs), str5, paramJSONObject, null);
      }
      if ("selected".equals(str2)) {
        return new br(new cn(4, str1, str3, str4, paramcs), str5, paramJSONObject, null);
      }
      if ("text_changed".equals(str2))
      {
        paramJSONObject = new br(new cp(str1, str3, str4, paramcs), str5, paramJSONObject, null);
        return paramJSONObject;
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw new dg("Can't interpret instructions due to JSONException", paramJSONObject);
    }
    throw new dg("Testin can't track event type \"" + str2 + "\"");
  }
  
  public String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      String str = paramJSONObject.optString("id");
      paramJSONObject = paramJSONObject.optString("exp_id");
      return str + "," + paramJSONObject;
    }
    return null;
  }
  
  List<by> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.getJSONObject(i);
      Object localObject1 = aq.a((JSONObject)localObject2, "prefix");
      String str1 = aq.a((JSONObject)localObject2, "view_class");
      int k = ((JSONObject)localObject2).optInt("index", -1);
      String str2 = aq.a((JSONObject)localObject2, "contentDescription");
      int m = ((JSONObject)localObject2).optInt("id", -1);
      String str3 = aq.a((JSONObject)localObject2, "mp_id_name");
      localObject2 = aq.a((JSONObject)localObject2, "tag");
      if ("shortest".equals(localObject1)) {}
      for (int j = 1;; j = 0)
      {
        localObject1 = a(m, str3, this.a);
        if (localObject1 != null) {
          break label181;
        }
        return e;
        if (localObject1 != null) {
          break;
        }
      }
      Log.w("Protocol", "Unrecognized prefix type \"" + (String)localObject1 + "\". No views will be matched");
      return e;
      label181:
      localArrayList.add(new by(j, str1, k, ((Integer)localObject1).intValue(), str2, (String)localObject2));
      i += 1;
    }
    if (localArrayList.size() == 0) {
      throw new dj("Edit will not be bound to any element in the UI.");
    }
    return localArrayList;
  }
  
  /* Error */
  public br b(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 329	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 330	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_1
    //   11: ldc_w 294
    //   14: invokevirtual 298	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   17: astore 4
    //   19: aload_1
    //   20: ldc_w 292
    //   23: invokevirtual 70	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 5
    //   28: aload_1
    //   29: ldc_w 385
    //   32: invokevirtual 70	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: ldc_w 387
    //   38: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +252 -> 293
    //   44: aload_1
    //   45: ldc_w 387
    //   48: invokevirtual 136	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: ldc_w 389
    //   54: invokevirtual 70	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 6
    //   59: aload 6
    //   61: ifnonnull +27 -> 88
    //   64: new 56	cn/testin/analysis/dg
    //   67: dup
    //   68: ldc_w 391
    //   71: invokespecial 61	cn/testin/analysis/dg:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_1
    //   76: new 56	cn/testin/analysis/dg
    //   79: dup
    //   80: ldc_w 393
    //   83: aload_1
    //   84: invokespecial 66	cn/testin/analysis/dg:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: aload 6
    //   90: invokestatic 146	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   93: astore 7
    //   95: aload_0
    //   96: aload 7
    //   98: aload_1
    //   99: ldc_w 387
    //   102: invokevirtual 136	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   105: invokespecial 395	cn/testin/analysis/bo:a	(Ljava/lang/Class;Lorg/json/JSONObject;)Lcn/testin/analysis/cc;
    //   108: astore 6
    //   110: aload_1
    //   111: ldc_w 397
    //   114: invokevirtual 298	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 335	org/json/JSONArray:length	()I
    //   122: anewarray 4	java/lang/Object
    //   125: astore 7
    //   127: iload_2
    //   128: aload_1
    //   129: invokevirtual 335	org/json/JSONArray:length	()I
    //   132: if_icmpge +82 -> 214
    //   135: aload_1
    //   136: iload_2
    //   137: invokevirtual 400	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   140: astore 8
    //   142: aload 7
    //   144: iload_2
    //   145: aload_0
    //   146: aload 8
    //   148: iconst_0
    //   149: invokevirtual 403	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   152: aload 8
    //   154: iconst_1
    //   155: invokevirtual 406	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   158: aload_3
    //   159: invokespecial 408	cn/testin/analysis/bo:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/util/List;)Ljava/lang/Object;
    //   162: aastore
    //   163: iload_2
    //   164: iconst_1
    //   165: iadd
    //   166: istore_2
    //   167: goto -40 -> 127
    //   170: astore_1
    //   171: new 56	cn/testin/analysis/dg
    //   174: dup
    //   175: new 184	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 410
    //   185: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 6
    //   190: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload_1
    //   197: invokespecial 66	cn/testin/analysis/dg:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: athrow
    //   201: astore_1
    //   202: new 56	cn/testin/analysis/dg
    //   205: dup
    //   206: ldc_w 321
    //   209: aload_1
    //   210: invokespecial 66	cn/testin/analysis/dg:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: athrow
    //   214: aload 6
    //   216: aload 7
    //   218: invokevirtual 413	cn/testin/analysis/cc:a	([Ljava/lang/Object;)Lcn/testin/analysis/cz;
    //   221: astore_1
    //   222: aload_1
    //   223: ifnonnull +41 -> 264
    //   226: new 56	cn/testin/analysis/dg
    //   229: dup
    //   230: new 184	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 415
    //   240: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 6
    //   245: getfield 418	cn/testin/analysis/cc:a	Ljava/lang/String;
    //   248: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 420
    //   254: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokespecial 61	cn/testin/analysis/dg:<init>	(Ljava/lang/String;)V
    //   263: athrow
    //   264: new 422	cn/testin/analysis/ct
    //   267: dup
    //   268: aload_1
    //   269: aload 6
    //   271: getfield 425	cn/testin/analysis/cc:c	Lcn/testin/analysis/cz;
    //   274: invokespecial 428	cn/testin/analysis/ct:<init>	(Lcn/testin/analysis/cz;Lcn/testin/analysis/cz;)V
    //   277: astore_1
    //   278: new 302	cn/testin/analysis/br
    //   281: dup
    //   282: aload_1
    //   283: aload 5
    //   285: aload 4
    //   287: aload_3
    //   288: aconst_null
    //   289: invokespecial 431	cn/testin/analysis/br:<init>	(Lcn/testin/analysis/cm;Ljava/lang/String;Lorg/json/JSONArray;Ljava/util/List;Lcn/testin/analysis/bp;)V
    //   292: areturn
    //   293: new 56	cn/testin/analysis/dg
    //   296: dup
    //   297: ldc_w 433
    //   300: invokespecial 61	cn/testin/analysis/dg:<init>	(Ljava/lang/String;)V
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	bo
    //   0	304	1	paramJSONObject	JSONObject
    //   1	166	2	i	int
    //   9	279	3	localArrayList	ArrayList
    //   17	269	4	localJSONArray1	JSONArray
    //   26	258	5	str	String
    //   57	213	6	localObject1	Object
    //   93	124	7	localObject2	Object
    //   140	13	8	localJSONArray2	JSONArray
    // Exception table:
    //   from	to	target	type
    //   10	59	75	java/lang/NoSuchMethodException
    //   64	75	75	java/lang/NoSuchMethodException
    //   88	95	75	java/lang/NoSuchMethodException
    //   95	127	75	java/lang/NoSuchMethodException
    //   127	163	75	java/lang/NoSuchMethodException
    //   171	201	75	java/lang/NoSuchMethodException
    //   214	222	75	java/lang/NoSuchMethodException
    //   226	264	75	java/lang/NoSuchMethodException
    //   264	278	75	java/lang/NoSuchMethodException
    //   293	304	75	java/lang/NoSuchMethodException
    //   88	95	170	java/lang/ClassNotFoundException
    //   10	59	201	org/json/JSONException
    //   64	75	201	org/json/JSONException
    //   88	95	201	org/json/JSONException
    //   95	127	201	org/json/JSONException
    //   127	163	201	org/json/JSONException
    //   171	201	201	org/json/JSONException
    //   214	222	201	org/json/JSONException
    //   226	264	201	org/json/JSONException
    //   264	278	201	org/json/JSONException
    //   293	304	201	org/json/JSONException
  }
  
  public ch c(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("classes");
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.getJSONObject(i);
          Class localClass = Class.forName(((JSONObject)localObject).getString("name"));
          localObject = ((JSONObject)localObject).getJSONArray("properties");
          int j = 0;
          if (j < ((JSONArray)localObject).length())
          {
            localArrayList.add(a(localClass, ((JSONArray)localObject).getJSONObject(j)));
            j += 1;
            continue;
          }
        }
        else
        {
          paramJSONObject = new ch(localArrayList, this.a);
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        throw new dg("Can't read snapshot configuration", paramJSONObject);
      }
      catch (ClassNotFoundException paramJSONObject)
      {
        throw new dg("Can't resolve types for snapshot configuration", paramJSONObject);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */