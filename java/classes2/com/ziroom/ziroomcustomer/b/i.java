package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_lease(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid \t\t\tvarchar,");
    localStringBuffer.append("contract_code \tvarchar,");
    localStringBuffer.append("sys_contract_id varchar,");
    localStringBuffer.append("stop_date \t\tvarchar,");
    localStringBuffer.append("effect_date \tvarchar,");
    localStringBuffer.append("price \t\t\tvarchar,");
    localStringBuffer.append("address \t\tvarchar,");
    localStringBuffer.append("payment \t\tvarchar,");
    localStringBuffer.append("contract_state \tvarchar,");
    localStringBuffer.append("contract_type \tvarchar,");
    localStringBuffer.append("room_code \t\tvarchar,");
    localStringBuffer.append("house_code \t\tvarchar,");
    localStringBuffer.append("room_name \t\tvarchar");
    localStringBuffer.append("property_state \t\tvarchar,");
    localStringBuffer.append("is_blank \t\tvarchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      u.d("lanzhihong", "deletet_lease");
      localb.execSQL("DELETE FROM t_lease", new Object[0]);
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
  
  public static boolean exist(b paramb, String paramString1, String paramString2)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_lease WHERE uid=? AND contract_code=?", new String[] { paramString1, paramString2 });
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
  
  public static LeaseInfo query(Context paramContext, String paramString1, String paramString2)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    for (;;)
    {
      try
      {
        paramString2 = localb.rawQuery("SELECT * FROM t_lease WHERE uid=? AND contract_code=?", new String[] { paramString1, paramString2 });
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
            paramString1 = new LeaseInfo();
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
          paramString1.setSysContractId(paramString2.getString(paramString2.getColumnIndex("sys_contract_id")));
          paramString1.setStopDate(paramString2.getString(paramString2.getColumnIndex("stop_date")));
          paramString1.setEffectDate(paramString2.getString(paramString2.getColumnIndex("effect_date")));
          paramString1.setPrice(Integer.parseInt(paramString2.getString(paramString2.getColumnIndex("price"))));
          paramString1.setAddress(paramString2.getString(paramString2.getColumnIndex("address")));
          paramString1.setPaymentType(paramString2.getString(paramString2.getColumnIndex("payment")));
          paramString1.setContractState(paramString2.getString(paramString2.getColumnIndex("contract_state")));
          paramString1.setContractType(paramString2.getString(paramString2.getColumnIndex("contract_type")));
          paramString1.setRoomCode(paramString2.getString(paramString2.getColumnIndex("room_code")));
          paramString1.setHouseCode(paramString2.getString(paramString2.getColumnIndex("house_code")));
          paramString1.setRoomName(paramString2.getString(paramString2.getColumnIndex("room_name")));
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
  
  public static List<LeaseInfo> query(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT * FROM t_lease WHERE uid=?", new String[] { paramString });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        LeaseInfo localLeaseInfo = new LeaseInfo();
        localLeaseInfo.setId(paramString.getInt(paramString.getColumnIndex("id")));
        localLeaseInfo.setUid(paramString.getString(paramString.getColumnIndex("uid")));
        localLeaseInfo.setContractCode(paramString.getString(paramString.getColumnIndex("contract_code")));
        localLeaseInfo.setSysContractId(paramString.getString(paramString.getColumnIndex("sys_contract_id")));
        localLeaseInfo.setStopDate(paramString.getString(paramString.getColumnIndex("stop_date")));
        localLeaseInfo.setEffectDate(paramString.getString(paramString.getColumnIndex("effect_date")));
        localLeaseInfo.setPrice(Integer.parseInt(paramString.getString(paramString.getColumnIndex("price"))));
        localLeaseInfo.setAddress(paramString.getString(paramString.getColumnIndex("address")));
        localLeaseInfo.setPaymentType(paramString.getString(paramString.getColumnIndex("payment")));
        localLeaseInfo.setContractState(paramString.getString(paramString.getColumnIndex("contract_state")));
        localLeaseInfo.setContractType(paramString.getString(paramString.getColumnIndex("contract_type")));
        localLeaseInfo.setRoomCode(paramString.getString(paramString.getColumnIndex("room_code")));
        localLeaseInfo.setHouseCode(paramString.getString(paramString.getColumnIndex("house_code")));
        localLeaseInfo.setRoomName(paramString.getString(paramString.getColumnIndex("room_name")));
        localArrayList.add(localLeaseInfo);
        paramString.moveToNext();
        continue;
        paramContext.releaseSession(localb);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      return localArrayList;
      paramString.close();
    }
  }
  
  public static void save(Context paramContext, LeaseInfo paramLeaseInfo)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramLeaseInfo.getUid());
      localContentValues.put("contract_code", paramLeaseInfo.getContractCode());
      localContentValues.put("sys_contract_id", paramLeaseInfo.getSysContractId());
      localContentValues.put("stop_date", paramLeaseInfo.getStopDate());
      localContentValues.put("effect_date", paramLeaseInfo.getEffectDate());
      localContentValues.put("price", Float.valueOf(paramLeaseInfo.getPrice()));
      localContentValues.put("address", paramLeaseInfo.getAddress());
      localContentValues.put("payment", paramLeaseInfo.getPaymentType());
      localContentValues.put("contract_state", paramLeaseInfo.getContractState());
      localContentValues.put("contract_type", paramLeaseInfo.getContractType());
      localContentValues.put("room_code", paramLeaseInfo.getRoomCode());
      localContentValues.put("house_code", paramLeaseInfo.getHouseCode());
      localContentValues.put("room_name", paramLeaseInfo.getRoomName());
      if (!exist(localb, paramLeaseInfo.getUid(), paramLeaseInfo.getContractCode())) {
        localb.insert("t_lease", null, localContentValues);
      }
      for (;;)
      {
        paramContext.releaseSession(localb);
        return;
        localb.update("t_lease", localContentValues, "uid=? AND contract_code=?", new String[] { paramLeaseInfo.getUid(), paramLeaseInfo.getContractCode() });
      }
    }
    catch (Exception paramLeaseInfo)
    {
      for (;;)
      {
        paramLeaseInfo.printStackTrace();
      }
    }
  }
  
  public static void save(Context paramContext, String paramString, List<LeaseInfo> paramList)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LeaseInfo localLeaseInfo = (LeaseInfo)paramList.next();
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("uid", paramString);
        localContentValues.put("contract_code", localLeaseInfo.getContractCode());
        localContentValues.put("sys_contract_id", localLeaseInfo.getSysContractId());
        localContentValues.put("stop_date", localLeaseInfo.getStopDate());
        localContentValues.put("effect_date", localLeaseInfo.getEffectDate());
        localContentValues.put("price", Float.valueOf(localLeaseInfo.getPrice()));
        localContentValues.put("address", localLeaseInfo.getAddress());
        localContentValues.put("payment", localLeaseInfo.getPaymentType());
        localContentValues.put("contract_state", localLeaseInfo.getContractState());
        localContentValues.put("contract_type", localLeaseInfo.getContractType());
        localContentValues.put("room_code", localLeaseInfo.getRoomCode());
        localContentValues.put("house_code", localLeaseInfo.getHouseCode());
        localContentValues.put("property_state", localLeaseInfo.getPropertyState());
        localContentValues.put("is_blank", localLeaseInfo.getIsBlank());
        if (exist(localb, paramString, localLeaseInfo.getContractCode())) {
          break label256;
        }
        localb.insert("t_lease", null, localContentValues);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label256:
      localb.update("t_lease", localContentValues, "uid=? AND contract_code=?", new String[] { localException.getUid(), localException.getContractCode() });
    }
    paramContext.releaseSession(localb);
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_lease");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */