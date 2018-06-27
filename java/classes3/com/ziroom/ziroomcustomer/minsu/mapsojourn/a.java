package com.ziroom.ziroomcustomer.minsu.mapsojourn;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.model.LatLng;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.bean.MinsuMapBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.model.d;
import java.util.List;

public abstract interface a
{
  public static abstract interface a
    extends com.ziroom.ziroomcustomer.a
  {
    public abstract void changeCity();
    
    public abstract void changeCount();
    
    public abstract void changeDate();
    
    public abstract void changeDistrict();
    
    public abstract void changeFilter();
    
    public abstract void changeKeyword();
    
    public abstract void getBuildMapData();
    
    public abstract void getBusinessCircleMapData();
    
    public abstract void getData();
    
    public abstract void getDistrictMapData();
    
    public abstract void goBrowseRecently();
    
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract void onBottomHiden();
    
    public abstract void onHouseClick(String paramString);
    
    public abstract void onLocInfo(int paramInt);
    
    public abstract void onMapLoaded();
    
    public abstract void showBottomRvMinsu(RecyclerView paramRecyclerView, RelativeLayout paramRelativeLayout, TextView paramTextView, String paramString, boolean paramBoolean);
    
    public abstract void showBottomRvZry(RecyclerView paramRecyclerView, String paramString);
    
    public abstract void updateDate();
  }
  
  public static abstract interface b
    extends b<a.a>
  {
    public abstract void animateMapStatus(LatLng paramLatLng, float paramFloat);
    
    public abstract void cityName();
    
    public abstract void clearMap();
    
    public abstract void dateStartEnd(String paramString);
    
    public abstract Activity getActivity();
    
    public abstract RecyclerView getBottomRv();
    
    public abstract d getMapStatus();
    
    public abstract int getMapZoomType();
    
    public abstract void hideBottom();
    
    public abstract void hideFilter();
    
    public abstract void keyWord(String paramString);
    
    public abstract void location(String paramString);
    
    public abstract void moveMap(LatLng paramLatLng);
    
    public abstract void personCount(int paramInt);
    
    public abstract void removeBusinessCircleLocationMarker();
    
    public abstract void showBusinessCircleMapData(List<? extends MinsuMapBean> paramList, boolean paramBoolean);
    
    public abstract void showDistrictMapData(List<? extends MinsuMapBean> paramList, boolean paramBoolean);
    
    public abstract void showFilterArea();
    
    public abstract void showMinsuBuildMapData(boolean paramBoolean1, List<? extends MinsuMapBean> paramList, boolean paramBoolean2);
    
    public abstract void showRedDot(boolean paramBoolean);
    
    public abstract void showTopNavigation(boolean paramBoolean);
    
    public abstract void updateClickBusinessCircleFlag(boolean paramBoolean, LatLng paramLatLng, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */