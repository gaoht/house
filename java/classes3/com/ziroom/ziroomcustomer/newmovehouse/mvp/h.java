package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newmovehouse.widget.MoveEvalWidget;

public abstract interface h
{
  public static abstract interface a
    extends a
  {
    public abstract void chargeViewControl();
    
    public abstract void destoryPollTask();
    
    public abstract void getData();
    
    public abstract int getIsShowMap();
    
    public abstract String getOrderId();
    
    public abstract int getTempState();
    
    public abstract void onKeyBack();
    
    public abstract void setMoverId(String paramString);
    
    public abstract void setTempState(int paramInt);
    
    public abstract void stopPollTask(boolean paramBoolean);
    
    public abstract void useCouponBean(boolean paramBoolean, ak paramak);
  }
  
  public static abstract interface b
    extends b<h.a>
  {
    public abstract void doneLoad();
    
    public abstract BaseActivity getActivity();
    
    public abstract BaiduMap getBaiduMap();
    
    public abstract BottomSheetBehavior getBehavior();
    
    public abstract TextView getBtn();
    
    public abstract MoveEvalWidget getEvalWidgth();
    
    public abstract Intent getExtras();
    
    public abstract ImageView getIvPull();
    
    public abstract MapView getMapView();
    
    public abstract RelativeLayout getRlPull();
    
    public abstract RecyclerView getRvChargeDetail();
    
    public abstract SwipeRefreshLayout getSrlRefreshView();
    
    public abstract TextView getTvPull();
    
    public abstract TextView getTvTitle();
    
    public abstract View getViewConver();
    
    public abstract View getViewCopy();
    
    public abstract TextView getmTvReminder();
    
    public abstract void mapResControl(boolean paramBoolean);
    
    public abstract void onMapClicked();
    
    public abstract void setEvalCamera(int paramInt);
    
    public abstract void setPayContainerVisiable(boolean paramBoolean);
    
    public abstract void setPayMoney(String paramString);
    
    public abstract void showDetail(MovingVanDetail paramMovingVanDetail);
    
    public abstract void switchBehaviorByMapStatus();
    
    public abstract void switchRefrushAbledByBehaviorStatusAndMapStatus();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */