package com.ziroom.ziroomcustomer.ziroomapartment.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.ziroomapartment.a.b;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ApartmentSearchActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZryuSearchConditionRecord
{
  public static final String SEARCH_CONDITION_RESULT = "search_condition_result";
  public static final int SEARCH_REQUEST_CODE = 43981;
  private static ZryuSearchConditionRecord instance;
  private final String ERROR_MESSAGE_SHOW = "网络不佳，请稍后再试！";
  private String mCurrentHouseId;
  private String mCurrentProjectId;
  private WeakReference<Context> mHouseContext;
  private ZryuSearchConditionResult mHouseRecord;
  private ZryuSearchCondition mHouseType;
  private ZryuSearchCondition mProject;
  private WeakReference<Context> mProjectContext;
  private ZryuSearchConditionResult mProjectRecord = new ZryuSearchConditionResult();
  private ZryuSearchCondition mRoom;
  private WeakReference<Context> mRoomContext;
  private ZryuSearchConditionResult mRoomRecord;
  
  public static ZryuSearchConditionRecord getInstance()
  {
    if (instance == null) {
      instance = new ZryuSearchConditionRecord();
    }
    return instance;
  }
  
  public ZryuSearchCondition getHouseCondition()
  {
    return this.mHouseType;
  }
  
  public ZryuSearchConditionResult getHouseRecord()
  {
    return this.mHouseRecord;
  }
  
  public ZryuSearchCondition getProjectCondition()
  {
    return this.mProject;
  }
  
  public ZryuSearchConditionResult getProjectRecord()
  {
    return this.mProjectRecord;
  }
  
  public ZryuSearchCondition getRoomCondition()
  {
    return this.mRoom;
  }
  
  public ZryuSearchConditionResult getRoomRecord()
  {
    return this.mRoomRecord;
  }
  
  public void setHouseRecord(ZryuSearchConditionResult paramZryuSearchConditionResult)
  {
    this.mHouseRecord = paramZryuSearchConditionResult;
  }
  
  public void setProjectRecord(ZryuSearchConditionResult paramZryuSearchConditionResult)
  {
    this.mProjectRecord = paramZryuSearchConditionResult;
  }
  
  public void setRoomRecord(ZryuSearchConditionResult paramZryuSearchConditionResult)
  {
    this.mRoomRecord = paramZryuSearchConditionResult;
  }
  
  public void startHouseSearchActivity(BaseActivity paramBaseActivity, final String paramString)
  {
    if (!paramString.equals(this.mCurrentProjectId))
    {
      this.mCurrentProjectId = paramString;
      this.mHouseRecord = null;
    }
    this.mHouseContext = new WeakReference(paramBaseActivity);
    HashMap localHashMap = new HashMap();
    b.convertor(ApplicationEx.c, localHashMap);
    localHashMap.put("projectId", paramString);
    e.getHouseTypeSearchCondition(paramBaseActivity, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        paramAnonymousk = (ZryuSearchCondition)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())) && (paramAnonymousk.getData() != null) && (paramAnonymousk.getData().getSortList() != null) && (paramAnonymousk.getData().getSortList().size() > 0))
        {
          ZryuSearchConditionRecord.access$202(ZryuSearchConditionRecord.this, paramAnonymousk);
          paramAnonymousk = (BaseActivity)ZryuSearchConditionRecord.this.mHouseContext.get();
          if (paramAnonymousk != null)
          {
            Intent localIntent = new Intent(paramAnonymousk, ApartmentSearchActivity.class);
            localIntent.putExtra("apartment_search_type", 2);
            localIntent.putExtra("apartment_search_project_id", paramString);
            paramAnonymousk.startActivityForResult(localIntent, 43981);
          }
          return;
        }
        if ((paramAnonymousk != null) && (!TextUtils.isEmpty(paramAnonymousk.getError_message())))
        {
          af.showToast(ApplicationEx.c, paramAnonymousk.getError_message());
          return;
        }
        af.showToast(ApplicationEx.c, "网络不佳，请稍后再试！");
      }
    }, localHashMap, true);
  }
  
  public void startProjectSearchActivity(final BaseActivity paramBaseActivity)
  {
    this.mProjectContext = new WeakReference(paramBaseActivity);
    HashMap localHashMap = new HashMap();
    b.convertor(ApplicationEx.c, localHashMap);
    e.getProjectSearchCondition(paramBaseActivity, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        paramAnonymousk = (ZryuSearchCondition)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())) && (paramAnonymousk.getData() != null) && (paramAnonymousk.getData().getSortList() != null) && (paramAnonymousk.getData().getSortList().size() > 0))
        {
          ZryuSearchConditionRecord.access$002(ZryuSearchConditionRecord.this, paramAnonymousk);
          paramAnonymousk = (BaseActivity)ZryuSearchConditionRecord.this.mProjectContext.get();
          Intent localIntent;
          if (paramAnonymousk != null)
          {
            localIntent = new Intent(paramAnonymousk, ApartmentSearchActivity.class);
            localIntent.putExtra("apartment_search_type", 1);
            if ((paramBaseActivity instanceof MainActivity)) {
              paramAnonymousk.startActivity(localIntent);
            }
          }
          else
          {
            return;
          }
          paramAnonymousk.startActivityForResult(localIntent, 43981);
          return;
        }
        if ((paramAnonymousk != null) && (!TextUtils.isEmpty(paramAnonymousk.getError_message())))
        {
          af.showToast(ApplicationEx.c, paramAnonymousk.getError_message());
          return;
        }
        af.showToast(ApplicationEx.c, "网络不佳，请稍后再试！");
      }
    }, localHashMap, true);
  }
  
  public void startRoomSearchActivity(BaseActivity paramBaseActivity, final String paramString)
  {
    if (!paramString.equals(this.mCurrentHouseId))
    {
      this.mCurrentHouseId = paramString;
      this.mRoomRecord = null;
    }
    this.mRoomContext = new WeakReference(paramBaseActivity);
    HashMap localHashMap = new HashMap();
    b.convertor(ApplicationEx.c, localHashMap);
    localHashMap.put("houseTypeId", paramString);
    e.getRoomSearchCondition(paramBaseActivity, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        paramAnonymousk = (ZryuSearchCondition)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())) && (paramAnonymousk.getData() != null) && (paramAnonymousk.getData().getSortList() != null) && (paramAnonymousk.getData().getSortList().size() > 0))
        {
          ZryuSearchConditionRecord.access$402(ZryuSearchConditionRecord.this, paramAnonymousk);
          paramAnonymousk = (BaseActivity)ZryuSearchConditionRecord.this.mRoomContext.get();
          if (paramAnonymousk != null)
          {
            Intent localIntent = new Intent(paramAnonymousk, ApartmentSearchActivity.class);
            localIntent.putExtra("apartment_search_type", 3);
            localIntent.putExtra("apartment_search_house_id", paramString);
            paramAnonymousk.startActivityForResult(localIntent, 43981);
          }
          return;
        }
        if ((paramAnonymousk != null) && (!TextUtils.isEmpty(paramAnonymousk.getError_message())))
        {
          af.showToast(ApplicationEx.c, paramAnonymousk.getError_message());
          return;
        }
        af.showToast(ApplicationEx.c, "网络不佳，请稍后再试！");
      }
    }, localHashMap, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuSearchConditionRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */