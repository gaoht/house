package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.Neighbour;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_contract(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid \t\t\tvarchar,");
    localStringBuffer.append("contract_code \tvarchar,");
    localStringBuffer.append("stop_date varchar,");
    localStringBuffer.append("effect_date \t\tvarchar,");
    localStringBuffer.append("price \tvarchar,");
    localStringBuffer.append("address \t\t\tvarchar,");
    localStringBuffer.append("payment \t\tInteger,");
    localStringBuffer.append("house_code \t\tvarchar,");
    localStringBuffer.append("room_code \tvarchar,");
    localStringBuffer.append("contract_type \tvarchar,");
    localStringBuffer.append("contract_state \t\tvarchar,");
    localStringBuffer.append("hire_contract_code \t\tvarchar,");
    localStringBuffer.append("hire_commissioner_code \t\tvarchar,");
    localStringBuffer.append("hire_commissioner_name \t\tvarchar,");
    localStringBuffer.append("hire_commissioner_phone \t\tvarchar,");
    localStringBuffer.append("longitude \t\tvarchar,");
    localStringBuffer.append("is_ziroom        varchar,");
    localStringBuffer.append("city_code \t\tvarchar,");
    localStringBuffer.append("latitude \t\tvarchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_contract", new Object[0]);
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
    paramb = paramb.rawQuery("SELECT * FROM t_contract WHERE uid=? AND contract_code=?", new String[] { paramString1, paramString2 });
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
  
  public static Contract query(Context paramContext, String paramString1, String paramString2)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    for (;;)
    {
      try
      {
        paramString2 = localb.rawQuery("SELECT * FROM t_contract WHERE uid=? AND contract_code=?", new String[] { paramString1, paramString2 });
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
            paramString1 = new Contract();
          }
        }
        catch (Exception paramString1)
        {
          continue;
        }
        try
        {
          paramString1.setId(Integer.valueOf(paramString2.getInt(paramString2.getColumnIndex("id"))));
          paramString1.setUid(paramString2.getString(paramString2.getColumnIndex("uid")));
          paramString1.setContract_code(paramString2.getString(paramString2.getColumnIndex("contract_code")));
          paramString1.setStop_date(paramString2.getString(paramString2.getColumnIndex("stop_date")));
          paramString1.setEffect_date(paramString2.getString(paramString2.getColumnIndex("effect_date")));
          paramString1.setPrice(paramString2.getString(paramString2.getColumnIndex("price")));
          paramString1.setAddress(paramString2.getString(paramString2.getColumnIndex("address")));
          paramString1.setPayment(Integer.valueOf(paramString2.getInt(paramString2.getColumnIndex("payment"))));
          paramString1.setHouse_code(paramString2.getString(paramString2.getColumnIndex("house_code")));
          paramString1.setRoom_code(paramString2.getString(paramString2.getColumnIndex("room_code")));
          paramString1.setContract_type(paramString2.getString(paramString2.getColumnIndex("contract_type")));
          paramString1.setContract_state(paramString2.getString(paramString2.getColumnIndex("contract_state")));
          paramString1.setHire_contract_code(paramString2.getString(paramString2.getColumnIndex("hire_contract_code")));
          paramString1.setHire_commissioner_code(paramString2.getString(paramString2.getColumnIndex("hire_commissioner_code")));
          paramString1.setHire_commissioner_name(paramString2.getString(paramString2.getColumnIndex("hire_commissioner_name")));
          paramString1.setHire_commissioner_phone(paramString2.getString(paramString2.getColumnIndex("hire_commissioner_phone")));
          paramString1.setLongitude(paramString2.getString(paramString2.getColumnIndex("longitude")));
          paramString1.setLatitude(paramString2.getString(paramString2.getColumnIndex("latitude")));
          paramString1.setCity_code(paramString2.getString(paramString2.getColumnIndex("city_code")));
          paramString1.setIsZiroom(paramString2.getString(paramString2.getColumnIndex("is_ziroom")));
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
  
  public static List<Contract> query(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT * FROM t_contract WHERE uid=?", new String[] { paramString });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        Contract localContract = new Contract();
        localContract.setId(Integer.valueOf(paramString.getInt(paramString.getColumnIndex("id"))));
        localContract.setUid(paramString.getString(paramString.getColumnIndex("uid")));
        localContract.setContract_code(paramString.getString(paramString.getColumnIndex("contract_code")));
        localContract.setStop_date(paramString.getString(paramString.getColumnIndex("stop_date")));
        localContract.setEffect_date(paramString.getString(paramString.getColumnIndex("effect_date")));
        localContract.setPrice(paramString.getString(paramString.getColumnIndex("price")));
        localContract.setAddress(paramString.getString(paramString.getColumnIndex("address")));
        localContract.setPayment(Integer.valueOf(paramString.getInt(paramString.getColumnIndex("payment"))));
        localContract.setHouse_code(paramString.getString(paramString.getColumnIndex("house_code")));
        localContract.setRoom_code(paramString.getString(paramString.getColumnIndex("room_code")));
        localContract.setContract_type(paramString.getString(paramString.getColumnIndex("contract_type")));
        localContract.setContract_state(paramString.getString(paramString.getColumnIndex("contract_state")));
        localContract.setHire_contract_code(paramString.getString(paramString.getColumnIndex("hire_contract_code")));
        localContract.setHire_commissioner_code(paramString.getString(paramString.getColumnIndex("hire_commissioner_code")));
        localContract.setHire_commissioner_name(paramString.getString(paramString.getColumnIndex("hire_commissioner_name")));
        localContract.setHire_commissioner_phone(paramString.getString(paramString.getColumnIndex("hire_commissioner_phone")));
        localContract.setLongitude(paramString.getString(paramString.getColumnIndex("longitude")));
        localContract.setLatitude(paramString.getString(paramString.getColumnIndex("latitude")));
        localContract.setCity_code(paramString.getString(paramString.getColumnIndex("city_code")));
        localContract.setIsZiroom(paramString.getString(paramString.getColumnIndex("is_ziroom")));
        localArrayList.add(localContract);
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
  
  public static List<Contract> queryAddress(Context paramContext, String paramString, List<Neighbour> paramList)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    ArrayList localArrayList = new ArrayList();
    paramContext = null;
    try
    {
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        paramList = localb.rawQuery("SELECT * FROM t_contract WHERE uid=? AND house_code=?", new String[] { paramString, ((Neighbour)localIterator.next()).getHouse_code() });
        paramList.moveToFirst();
        for (;;)
        {
          paramContext = paramList;
          if (paramList.isAfterLast()) {
            break;
          }
          paramContext = new Contract();
          paramContext.setId(Integer.valueOf(paramList.getInt(paramList.getColumnIndex("id"))));
          paramContext.setUid(paramList.getString(paramList.getColumnIndex("uid")));
          paramContext.setContract_code(paramList.getString(paramList.getColumnIndex("contract_code")));
          paramContext.setStop_date(paramList.getString(paramList.getColumnIndex("stop_date")));
          paramContext.setEffect_date(paramList.getString(paramList.getColumnIndex("effect_date")));
          paramContext.setPrice(paramList.getString(paramList.getColumnIndex("price")));
          paramContext.setAddress(paramList.getString(paramList.getColumnIndex("address")));
          paramContext.setPayment(Integer.valueOf(paramList.getInt(paramList.getColumnIndex("payment"))));
          paramContext.setHouse_code(paramList.getString(paramList.getColumnIndex("house_code")));
          paramContext.setRoom_code(paramList.getString(paramList.getColumnIndex("room_code")));
          paramContext.setContract_type(paramList.getString(paramList.getColumnIndex("contract_type")));
          paramContext.setContract_state(paramList.getString(paramList.getColumnIndex("contract_state")));
          paramContext.setHire_contract_code(paramList.getString(paramList.getColumnIndex("hire_contract_code")));
          paramContext.setHire_commissioner_code(paramList.getString(paramList.getColumnIndex("hire_commissioner_code")));
          paramContext.setHire_commissioner_name(paramList.getString(paramList.getColumnIndex("hire_commissioner_name")));
          paramContext.setHire_commissioner_phone(paramList.getString(paramList.getColumnIndex("hire_commissioner_phone")));
          paramContext.setLongitude(paramList.getString(paramList.getColumnIndex("longitude")));
          paramContext.setLatitude(paramList.getString(paramList.getColumnIndex("latitude")));
          paramContext.setCity_code(paramList.getString(paramList.getColumnIndex("city_code")));
          paramContext.setIsZiroom(paramList.getString(paramList.getColumnIndex("is_ziroom")));
          localArrayList.add(paramContext);
          paramList.moveToNext();
        }
        locale.releaseSession(localb);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    for (;;)
    {
      return localArrayList;
      paramContext.close();
    }
  }
  
  public static void save(Context paramContext, Contract paramContract)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    for (;;)
    {
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("uid", paramContract.getUid());
        localContentValues.put("contract_code", paramContract.getContract_code());
        localContentValues.put("stop_date", paramContract.getStop_date());
        localContentValues.put("effect_date", paramContract.getEffect_date());
        localContentValues.put("price", paramContract.getPrice());
        localContentValues.put("address", paramContract.getAddress());
        localContentValues.put("payment", paramContract.getPayment());
        localContentValues.put("house_code", paramContract.getHouse_code());
        localContentValues.put("room_code", paramContract.getRoom_code());
        localContentValues.put("contract_type", paramContract.getContract_type());
        localContentValues.put("contract_state", paramContract.getContract_state());
        localContentValues.put("hire_contract_code", paramContract.getHire_contract_code());
        localContentValues.put("hire_commissioner_code", paramContract.getHire_commissioner_code());
        localContentValues.put("hire_commissioner_name", paramContract.getHire_commissioner_name());
        localContentValues.put("hire_commissioner_phone", paramContract.getHire_commissioner_phone());
        localContentValues.put("longitude", paramContract.getLongitude());
        localContentValues.put("latitude", paramContract.getLatitude());
        if (paramContract.getIsZiroom() != null) {
          localContentValues.put("is_ziroom", paramContract.getIsZiroom());
        }
        if (paramContract.getCity_code() != null) {
          localContentValues.put("city_code", paramContract.getCity_code());
        }
        if (exist(localb, paramContract.getUid(), paramContract.getContract_code())) {
          continue;
        }
        localb.insert("t_contract", null, localContentValues);
      }
      catch (Exception paramContract)
      {
        ContentValues localContentValues;
        paramContract.printStackTrace();
        continue;
      }
      paramContext.releaseSession(localb);
      return;
      localb.update("t_contract", localContentValues, "uid=? AND contract_code=?", new String[] { paramContract.getUid(), paramContract.getContract_code() });
    }
  }
  
  public static void save(Context paramContext, String paramString, List<Contract> paramList)
  {
    paramContext = new e(paramContext);
    paramString = paramContext.getSession();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Contract localContract = (Contract)paramList.next();
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("uid", localContract.getUid());
        localContentValues.put("contract_code", localContract.getContract_code());
        localContentValues.put("stop_date", localContract.getStop_date());
        localContentValues.put("effect_date", localContract.getEffect_date());
        localContentValues.put("price", localContract.getPrice());
        localContentValues.put("address", localContract.getAddress());
        localContentValues.put("payment", localContract.getPayment());
        localContentValues.put("house_code", localContract.getHouse_code());
        localContentValues.put("room_code", localContract.getRoom_code());
        localContentValues.put("contract_type", localContract.getContract_type());
        localContentValues.put("contract_state", localContract.getContract_state());
        localContentValues.put("hire_contract_code", localContract.getHire_commissioner_code());
        localContentValues.put("hire_commissioner_code", localContract.getHire_commissioner_code());
        localContentValues.put("hire_commissioner_name", localContract.getHire_commissioner_name());
        localContentValues.put("hire_commissioner_phone", localContract.getHire_commissioner_phone());
        localContentValues.put("longitude", localContract.getLongitude());
        localContentValues.put("latitude", localContract.getLatitude());
        if (localContract.getIsZiroom() != null) {
          localContentValues.put("is_ziroom", localContract.getIsZiroom());
        }
        if (localContract.getCity_code() != null) {
          localContentValues.put("city_code", localContract.getCity_code());
        }
        if (exist(paramString, localContract.getUid(), localContract.getContract_code())) {
          break label309;
        }
        paramString.insert("t_contract", null, localContentValues);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label309:
      paramString.update("t_contract", localContentValues, "uid=? AND contract_code=?", new String[] { localException.getUid(), localException.getContract_code() });
    }
    paramContext.releaseSession(paramString);
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_contract");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */