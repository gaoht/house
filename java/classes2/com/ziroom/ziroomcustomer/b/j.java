package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.LeasePayDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_lease_pay_detail(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid \t\t\tvarchar,");
    localStringBuffer.append("contract_code \tvarchar,");
    localStringBuffer.append("periods \t\tvarchar,");
    localStringBuffer.append("money \t\t\tvarchar,");
    localStringBuffer.append("creation_date\tvarchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static boolean exist(b paramb, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_lease_pay_detail WHERE uid=? AND contract_code=? AND periods=? AND creation_date=?", new String[] { paramString1, paramString2, String.valueOf(paramInt), paramString3 });
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
  
  public static List<LeasePayDetail> query(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString1 = localb.rawQuery("SELECT * FROM t_lease_pay_detail WHERE uid=? AND contract_code=? AND periods=?", new String[] { paramString1, paramString2, String.valueOf(paramInt) });
      paramString1.moveToFirst();
      while (!paramString1.isAfterLast())
      {
        paramString2 = new LeasePayDetail();
        paramString2.setId(paramString1.getInt(paramString1.getColumnIndex("id")));
        paramString2.setUid(paramString1.getString(paramString1.getColumnIndex("uid")));
        paramString2.setContractCode(paramString1.getString(paramString1.getColumnIndex("contract_code")));
        paramString2.setPeriods(Integer.valueOf(paramString1.getInt(paramString1.getColumnIndex("periods"))));
        paramString2.setPayMoney(paramString1.getString(paramString1.getColumnIndex("money")));
        paramString2.setPayDate(paramString1.getString(paramString1.getColumnIndex("creation_date")));
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
  
  public static void save(Context paramContext, LeasePayDetail paramLeasePayDetail)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramLeasePayDetail.getUid());
      localContentValues.put("contract_code", paramLeasePayDetail.getContractCode());
      localContentValues.put("periods", paramLeasePayDetail.getPeriods());
      localContentValues.put("money", paramLeasePayDetail.getPayMoney());
      localContentValues.put("creation_date", paramLeasePayDetail.getPayDate());
      if (!exist(localb, paramLeasePayDetail.getUid(), paramLeasePayDetail.getContractCode(), paramLeasePayDetail.getPeriods().intValue(), paramLeasePayDetail.getPayDate())) {
        localb.insert("t_lease_pay_detail", null, localContentValues);
      }
      for (;;)
      {
        paramContext.releaseSession(localb);
        return;
        localb.update("t_lease_pay_detail", localContentValues, "uid=? AND contract_code=? AND periods=? AND creation_date=?", new String[] { paramLeasePayDetail.getUid(), paramLeasePayDetail.getContractCode(), String.valueOf(paramLeasePayDetail.getPeriods()), paramLeasePayDetail.getPayDate() });
      }
    }
    catch (Exception paramLeasePayDetail)
    {
      for (;;)
      {
        paramLeasePayDetail.printStackTrace();
      }
    }
  }
  
  public static void save(Context paramContext, String paramString, List<LeasePayDetail> paramList)
  {
    paramContext = new e(paramContext);
    paramString = paramContext.getSession();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LeasePayDetail localLeasePayDetail = (LeasePayDetail)paramList.next();
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("uid", localLeasePayDetail.getUid());
        localContentValues.put("contract_code", localLeasePayDetail.getContractCode());
        localContentValues.put("periods", localLeasePayDetail.getPeriods());
        localContentValues.put("money", localLeasePayDetail.getPayMoney());
        localContentValues.put("creation_date", localLeasePayDetail.getPayDate());
        if (exist(paramString, localLeasePayDetail.getUid(), localLeasePayDetail.getContractCode(), localLeasePayDetail.getPeriods().intValue(), localLeasePayDetail.getPayDate())) {
          break label151;
        }
        paramString.insert("t_lease_pay_detail", null, localContentValues);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label151:
      paramString.update("t_lease_pay_detail", localContentValues, "uid=? AND contract_code=? AND periods=? AND creation_date=?", new String[] { localException.getUid(), localException.getContractCode(), String.valueOf(localException.getPeriods()), localException.getPayDate() });
    }
    paramContext.releaseSession(paramString);
  }
  
  public void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_lease_pay_detail", new Object[0]);
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
      localb.execSQL("drop table t_lease_pay_detail");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */