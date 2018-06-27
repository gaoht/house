package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r
{
  private static String a(b paramb, SKUMo paramSKUMo)
  {
    int i = 9;
    int j = Integer.valueOf(paramSKUMo.getCount()).intValue();
    if (a(paramb, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode())) {
      if (b(paramb, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode()) + j <= 9) {}
    }
    for (;;)
    {
      return i + "";
      i = b(paramb, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode()) + j;
      continue;
      i = j;
    }
  }
  
  private static boolean a(b paramb, String paramString1, String paramString2)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_sku WHERE skuCode=? AND cityCode=?", new String[] { paramString1, paramString2 });
    paramb.moveToFirst();
    if (!paramb.isAfterLast()) {
      paramb.moveToNext();
    }
    for (;;)
    {
      paramb.close();
      return bool;
      bool = false;
    }
  }
  
  private static int b(b paramb, String paramString1, String paramString2)
  {
    int i = 0;
    int j = 0;
    paramb = paramb.rawQuery("SELECT count FROM t_sku WHERE skuCode='" + paramString1 + "' AND cityCode='" + paramString2 + "'", null);
    if (paramb != null) {
      i = j;
    }
    try
    {
      if (paramb.moveToNext()) {
        i = Integer.valueOf(paramb.getString(paramb.getColumnIndex("count"))).intValue();
      }
      return i;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      return 0;
    }
    finally
    {
      paramb.close();
    }
  }
  
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_sku(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("productCode \tvarchar,");
    localStringBuffer.append("skuCode \tvarchar,");
    localStringBuffer.append("amount varchar,");
    localStringBuffer.append("count varchar,");
    localStringBuffer.append("isChecked varchar,");
    localStringBuffer.append("price varchar,");
    localStringBuffer.append("skuName varchar,");
    localStringBuffer.append("cityName varchar,");
    localStringBuffer.append("cityCode varchar,");
    localStringBuffer.append("skuImg varchar,");
    localStringBuffer.append("freight varchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext, SKUMo paramSKUMo)
  {
    if ((paramSKUMo != null) && (!TextUtils.isEmpty(paramSKUMo.getSkuCode()))) {
      delete(paramContext, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode());
    }
  }
  
  public static void delete(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_sku WHERE skuCode = '" + paramString1 + "' AND cityCode='" + paramString2 + "'", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void deleteSkus(Context paramContext, List<SKUMo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      delete(paramContext, (SKUMo)paramList.next());
    }
  }
  
  public static int getSKUNum(Context paramContext, SKUMo paramSKUMo)
  {
    return b(new e(paramContext).getSession(), paramSKUMo.getSkuCode(), paramSKUMo.getCityCode());
  }
  
  public static List<SKUMo> getSKUs(Context paramContext, String paramString)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    try
    {
      Cursor localCursor = localb.rawQuery("SELECT * FROM t_sku WHERE cityCode = '" + paramString + "'", null);
      paramContext = new ArrayList();
      try
      {
        localCursor.moveToFirst();
        for (;;)
        {
          paramString = paramContext;
          if (localCursor.isAfterLast()) {
            break;
          }
          paramString = new SKUMo();
          paramString.setProductCode(localCursor.getString(localCursor.getColumnIndex("productCode")));
          paramString.setSkuCode(localCursor.getString(localCursor.getColumnIndex("skuCode")));
          paramString.setAmount(localCursor.getInt(localCursor.getColumnIndex("amount")));
          paramString.setCount(localCursor.getInt(localCursor.getColumnIndex("count")));
          paramString.setCityName(localCursor.getString(localCursor.getColumnIndex("cityName")));
          paramString.setCityCode(localCursor.getString(localCursor.getColumnIndex("cityCode")));
          paramString.setPrice(Double.valueOf(localCursor.getDouble(localCursor.getColumnIndex("price"))));
          paramString.setSkuName(localCursor.getString(localCursor.getColumnIndex("skuName")));
          paramString.setSkuImg(localCursor.getString(localCursor.getColumnIndex("skuImg")));
          paramString.setFreight(localCursor.getDouble(localCursor.getColumnIndex("freight")));
          paramString.setChecked("true".equals(localCursor.getString(localCursor.getColumnIndex("isChecked"))));
          paramContext.add(paramString);
          localCursor.moveToNext();
        }
        paramString.printStackTrace();
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    paramString = paramContext;
    locale.releaseSession(localb);
    return paramString;
  }
  
  public static int getShoppingNum(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    int i = 0;
    int j = 0;
    paramString = localb.rawQuery("SELECT count FROM t_sku WHERE cityCode = '" + paramString + "'", null);
    if (paramString != null) {
      i = j;
    }
    try
    {
      while (paramString.moveToNext())
      {
        j = Integer.valueOf(paramString.getString(paramString.getColumnIndex("count"))).intValue();
        i += j;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
    }
    paramContext.releaseSession(localb);
    return i;
  }
  
  public static int save(Context paramContext, SKUMo paramSKUMo)
  {
    int i = 0;
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      if (!a(localb, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode()))
      {
        localContentValues.put("productCode", paramSKUMo.getProductCode());
        localContentValues.put("skuCode", paramSKUMo.getSkuCode());
        localContentValues.put("amount", Integer.valueOf(paramSKUMo.getAmount()));
        localContentValues.put("count", Integer.valueOf(paramSKUMo.getCount()));
        localContentValues.put("isChecked", paramSKUMo.isChecked() + "");
        localContentValues.put("price", paramSKUMo.getPrice());
        localContentValues.put("skuName", paramSKUMo.getSkuName());
        localContentValues.put("cityName", paramSKUMo.getCityName());
        localContentValues.put("cityCode", paramSKUMo.getCityCode());
        localContentValues.put("skuImg", paramSKUMo.getSkuImg());
        localContentValues.put("freight", Double.valueOf(paramSKUMo.getFreight()));
        localb.insert("t_sku", null, localContentValues);
        return paramSKUMo.getCount();
      }
      if (b(localb, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode()) < 9)
      {
        i = b(localb, paramSKUMo.getSkuCode(), paramSKUMo.getCityCode());
        String str = a(localb, paramSKUMo);
        localContentValues.put("count", str);
        localContentValues.put("amount", Integer.valueOf(paramSKUMo.getAmount()));
        localb.update("t_sku", localContentValues, "skuCode=? AND cityCode=?", new String[] { paramSKUMo.getSkuCode(), paramSKUMo.getCityCode() });
        int j = Integer.parseInt(str);
        return j - i;
      }
    }
    catch (Exception paramSKUMo)
    {
      paramSKUMo.printStackTrace();
      paramContext.releaseSession(localb);
      i = -1;
    }
    return i;
  }
  
  public static void updataGoodsCount(Context paramContext, List<SKUMo> paramList)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SKUMo localSKUMo = (SKUMo)paramList.next();
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("count", Integer.valueOf(localSKUMo.getCount()));
        localb.update("t_sku", localContentValues, "skuCode=? AND cityCode=?", new String[] { localSKUMo.getSkuCode(), localSKUMo.getCityCode() });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    paramContext.releaseSession(localb);
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_sku");
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */