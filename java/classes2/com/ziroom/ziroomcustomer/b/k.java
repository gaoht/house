package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_lease_pay_plan(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid \t\t\tvarchar,");
    localStringBuffer.append("contract_code \tvarchar,");
    localStringBuffer.append("periods  \t\tinteger,");
    localStringBuffer.append("pay_count \t\tinteger,");
    localStringBuffer.append("receivable_date varchar,");
    localStringBuffer.append("receivable_cycle varchar,");
    localStringBuffer.append("fee    \t\t\tvarchar,");
    localStringBuffer.append("pay_fee \t\tvarchar,");
    localStringBuffer.append("status    \t\tvarchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static boolean exist(b paramb, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_lease_pay_plan WHERE uid=? AND contract_code=? AND periods=?", new String[] { paramString1, paramString2, String.valueOf(paramInt) });
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
  
  public static LeasePayPlan query(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    for (;;)
    {
      try
      {
        paramString2 = localb.rawQuery("SELECT * FROM t_lease_pay_plan WHERE uid=? AND contract_code=? AND periods=?", new String[] { paramString1, paramString2, String.valueOf(paramInt) });
        paramString2.moveToFirst();
        paramContext = null;
      }
      catch (Exception paramString1)
      {
        paramContext = null;
      }
      for (;;)
      {
        try
        {
          if (!paramString2.isAfterLast()) {
            paramString1 = new LeasePayPlan();
          }
        }
        catch (Exception paramString1)
        {
          continue;
        }
        try
        {
          paramString1.setId(paramString2.getInt(paramString2.getColumnIndex("id")));
          paramString1.setUid(paramString2.getString(paramString2.getColumnIndex("uid")));
          paramString1.setContractCode(paramString2.getString(paramString2.getColumnIndex("contract_code")));
          paramString1.setContractCode(paramString2.getString(paramString2.getColumnIndex("periods")));
          paramString1.setPayCount(Integer.valueOf(paramString2.getInt(paramString2.getColumnIndex("pay_count"))));
          paramString1.setReceivableDate(paramString2.getString(paramString2.getColumnIndex("receivable_date")));
          paramString1.setReceivableCycle(paramString2.getString(paramString2.getColumnIndex("receivable_cycle")));
          paramString1.setFee(paramString2.getString(paramString2.getColumnIndex("fee")));
          paramString1.setPayFee(paramString2.getString(paramString2.getColumnIndex("pay_fee")));
          paramString1.setStatus(paramString2.getString(paramString2.getColumnIndex("status")));
          paramContext = paramString1;
        }
        catch (Exception paramString2)
        {
          paramContext = paramString1;
          paramString1 = paramString2;
        }
      }
    }
    paramString2.close();
    for (;;)
    {
      locale.releaseSession(localb);
      return paramContext;
      paramString1.printStackTrace();
    }
  }
  
  public static List<LeasePayPlan> query(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString1 = localb.rawQuery("SELECT * FROM t_lease_pay_plan WHERE uid=? AND contract_code=?", new String[] { paramString1, paramString2 });
      paramString1.moveToFirst();
      while (!paramString1.isAfterLast())
      {
        paramString2 = new LeasePayPlan();
        paramString2.setId(paramString1.getInt(paramString1.getColumnIndex("id")));
        paramString2.setUid(paramString1.getString(paramString1.getColumnIndex("uid")));
        paramString2.setContractCode(paramString1.getString(paramString1.getColumnIndex("contract_code")));
        paramString2.setContractCode(paramString1.getString(paramString1.getColumnIndex("periods")));
        paramString2.setPayCount(Integer.valueOf(paramString1.getInt(paramString1.getColumnIndex("pay_count"))));
        paramString2.setReceivableDate(paramString1.getString(paramString1.getColumnIndex("receivable_date")));
        paramString2.setReceivableCycle(paramString1.getString(paramString1.getColumnIndex("receivable_cycle")));
        paramString2.setFee(paramString1.getString(paramString1.getColumnIndex("fee")));
        paramString2.setPayFee(paramString1.getString(paramString1.getColumnIndex("pay_fee")));
        paramString2.setStatus(paramString1.getString(paramString1.getColumnIndex("status")));
        localArrayList.add(paramString2);
        paramString1.moveToNext();
        continue;
        paramContext.releaseSession(localb);
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    for (;;)
    {
      return localArrayList;
      paramString1.close();
    }
  }
  
  public static void save(Context paramContext, LeasePayPlan paramLeasePayPlan)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramLeasePayPlan.getUid());
      localContentValues.put("contract_code", paramLeasePayPlan.getContractCode());
      localContentValues.put("periods", paramLeasePayPlan.getPeriods());
      localContentValues.put("pay_count", paramLeasePayPlan.getPayCount());
      localContentValues.put("receivable_date", paramLeasePayPlan.getReceivableDate());
      localContentValues.put("receivable_cycle", paramLeasePayPlan.getReceivableCycle());
      localContentValues.put("fee", paramLeasePayPlan.getFee());
      localContentValues.put("pay_fee", paramLeasePayPlan.getPayFee());
      localContentValues.put("status", paramLeasePayPlan.getStatus());
      if (exist(localb, paramLeasePayPlan.getUid(), paramLeasePayPlan.getContractCode(), paramLeasePayPlan.getPeriods().intValue())) {
        localb.insert("t_lease_pay_plan", null, localContentValues);
      }
      for (;;)
      {
        paramContext.releaseSession(localb);
        return;
        localb.update("t_lease_pay_plan", localContentValues, "uid=? AND contract_code=? AND periods=?", new String[] { paramLeasePayPlan.getUid(), paramLeasePayPlan.getContractCode(), String.valueOf(paramLeasePayPlan.getPeriods()) });
      }
    }
    catch (Exception paramLeasePayPlan)
    {
      for (;;)
      {
        paramLeasePayPlan.printStackTrace();
      }
    }
  }
  
  public static void save(Context paramContext, String paramString, List<LeasePayPlan> paramList)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LeasePayPlan localLeasePayPlan = (LeasePayPlan)paramList.next();
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("uid", paramString);
        localContentValues.put("contract_code", localLeasePayPlan.getContractCode());
        localContentValues.put("periods", localLeasePayPlan.getPeriods());
        localContentValues.put("pay_count", localLeasePayPlan.getPayCount());
        localContentValues.put("receivable_date", localLeasePayPlan.getReceivableDate());
        localContentValues.put("receivable_cycle", localLeasePayPlan.getReceivableCycle());
        localContentValues.put("fee", localLeasePayPlan.getFee());
        localContentValues.put("pay_fee", localLeasePayPlan.getPayFee());
        localContentValues.put("status", localLeasePayPlan.getStatus());
        if (!exist(localb, localLeasePayPlan.getUid(), localLeasePayPlan.getContractCode(), localLeasePayPlan.getPeriods().intValue())) {
          break label202;
        }
        localb.insert("t_lease_pay_plan", null, localContentValues);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label202:
      localb.update("t_lease_pay_plan", localContentValues, "uid=? AND contract_code=? AND periods=?", new String[] { localException.getUid(), localException.getContractCode(), String.valueOf(localException.getPeriods()) });
    }
    paramContext.releaseSession(localb);
  }
  
  public void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_lease_pay_plan", new Object[0]);
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
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_lease_pay_plan");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */