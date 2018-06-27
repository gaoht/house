package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.NewHouseMapSearchActivity;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.PrintStream;

public class MinsuHouseMapLocationActivity
  extends BaseActivity
{
  private ImageView a;
  private MapView b;
  private BaiduMap c;
  private LinearLayout d;
  private EditText e;
  private ImageView f;
  
  private void a()
  {
    this.f = ((ImageView)findViewById(2131691426));
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = MinsuHouseMapLocationActivity.this.getIntent().getStringExtra("search_location");
        if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (!"null".equals(paramAnonymousView)))
        {
          paramAnonymousView = MinsuHouseMapLocationActivity.this.Str2LatLng(paramAnonymousView);
          MinsuHouseMapLocationActivity.a(MinsuHouseMapLocationActivity.this, 17.0F);
          MinsuHouseMapLocationActivity.a(MinsuHouseMapLocationActivity.this, paramAnonymousView);
        }
      }
    });
    this.d = ((LinearLayout)findViewById(2131690903));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(MinsuHouseMapLocationActivity.this, NewHouseMapSearchActivity.class);
        paramAnonymousView.putExtra("StartActivityName", "HouseMapLocationActivity");
        paramAnonymousView.putExtra("resblock_name", MinsuHouseMapLocationActivity.this.getIntent().getStringExtra("resblock_name"));
        MinsuHouseMapLocationActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.a = ((ImageView)findViewById(2131689492));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseMapLocationActivity.this.finish();
      }
    });
    this.b = ((MapView)findViewById(2131690823));
    this.c = this.b.getMap();
    Object localObject = MapStatusUpdateFactory.zoomTo(17.0F);
    this.c.setMapStatus((MapStatusUpdate)localObject);
    this.c.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback()
    {
      public void onMapLoaded()
      {
        System.out.println("地图加载完成");
        Object localObject = MinsuHouseMapLocationActivity.this.getIntent().getStringExtra("search_location");
        if ((localObject != null) && (((String)localObject).length() > 0) && (!"null".equals(localObject)))
        {
          localObject = MinsuHouseMapLocationActivity.this.Str2LatLng((String)localObject);
          MinsuHouseMapLocationActivity.a(MinsuHouseMapLocationActivity.this, (LatLng)localObject, 17);
          MinsuHouseMapLocationActivity.a(MinsuHouseMapLocationActivity.this, 17.0F);
          MinsuHouseMapLocationActivity.a(MinsuHouseMapLocationActivity.this, (LatLng)localObject);
        }
      }
    });
    localObject = getIntent().getStringExtra("resblock_name");
    this.e = ((EditText)findViewById(2131690905));
    this.e.setText((CharSequence)localObject);
    this.e.setSelection(((String)localObject).length());
  }
  
  private void a(float paramFloat)
  {
    MapStatusUpdate localMapStatusUpdate = MapStatusUpdateFactory.zoomTo(paramFloat);
    this.c.setMapStatus(localMapStatusUpdate);
  }
  
  private void a(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      paramLatLng = MapStatusUpdateFactory.newLatLng(paramLatLng);
      this.c.animateMapStatus(paramLatLng);
    }
  }
  
  private void a(LatLng paramLatLng, int paramInt)
  {
    if (paramLatLng != null)
    {
      paramLatLng = new MarkerOptions().position(paramLatLng).icon(BitmapDescriptorFactory.fromResource(2130838541)).zIndex(paramInt);
      this.c.addOverlay(paramLatLng);
    }
  }
  
  public LatLng Str2LatLng(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (ae.notNull(paramString))
    {
      localObject1 = localObject2;
      if (paramString.contains(","))
      {
        paramString = paramString.split(",");
        localObject1 = localObject2;
        if (paramString.length > 1) {
          localObject1 = new LatLng(Double.parseDouble(paramString[1]), Double.parseDouble(paramString[0]));
        }
      }
    }
    return (LatLng)localObject1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903286);
    a();
  }
  
  protected void onDestroy()
  {
    this.b.onDestroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    this.b.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    this.b.onResume();
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseMapLocationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */