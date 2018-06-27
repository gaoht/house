package com.ziroom.ziroomcustomer.ziroomstation.baidumap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StationRoutePlanningActivity
  extends BaseActivity
  implements OnGetRoutePlanResultListener
{
  RoutePlanSearch a = null;
  private String b;
  private String c;
  private String d;
  private ListView e;
  private ArrayList<HashMap<String, Object>> f;
  private List<HashMap<String, String>> g;
  private a r;
  private List<TransitRouteLine> s;
  private TextView t;
  private ListView u;
  private List<Map<String, String>> v;
  
  private void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.v = new ArrayList();
    final Object localObject1 = paramSuggestAddrInfo.getSuggestEndNode();
    paramSuggestAddrInfo = paramSuggestAddrInfo.getSuggestStartNode();
    Object localObject2;
    if ((paramSuggestAddrInfo != null) && (paramSuggestAddrInfo.size() > 0))
    {
      this.v.clear();
      paramSuggestAddrInfo = paramSuggestAddrInfo.iterator();
      while (paramSuggestAddrInfo.hasNext())
      {
        localObject2 = (PoiInfo)paramSuggestAddrInfo.next();
        localHashMap = new HashMap();
        localHashMap.put("name", ((PoiInfo)localObject2).name);
        localHashMap.put("detail", ((PoiInfo)localObject2).address);
        this.v.add(localHashMap);
      }
      this.u.setAdapter(new b(this.v));
      this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          StationRoutePlanningActivity.a(StationRoutePlanningActivity.this, (String)((Map)StationRoutePlanningActivity.d(StationRoutePlanningActivity.this).get(paramAnonymousInt)).get("name"));
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            StationRoutePlanningActivity.d(StationRoutePlanningActivity.this).clear();
            paramAnonymousAdapterView = localObject1.iterator();
            while (paramAnonymousAdapterView.hasNext())
            {
              paramAnonymousView = (PoiInfo)paramAnonymousAdapterView.next();
              HashMap localHashMap = new HashMap();
              localHashMap.put("name", paramAnonymousView.name);
              localHashMap.put("detail", paramAnonymousView.address);
              StationRoutePlanningActivity.d(StationRoutePlanningActivity.this).add(localHashMap);
            }
            StationRoutePlanningActivity.e(StationRoutePlanningActivity.this).setAdapter(new StationRoutePlanningActivity.b(StationRoutePlanningActivity.this, StationRoutePlanningActivity.d(StationRoutePlanningActivity.this)));
            StationRoutePlanningActivity.e(StationRoutePlanningActivity.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              @Instrumented
              public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
              {
                VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
                StationRoutePlanningActivity.b(StationRoutePlanningActivity.this, (String)((Map)StationRoutePlanningActivity.d(StationRoutePlanningActivity.this).get(paramAnonymous2Int)).get("name"));
                paramAnonymous2AdapterView = PlanNode.withCityNameAndPlaceName(b.c, StationRoutePlanningActivity.f(StationRoutePlanningActivity.this));
                paramAnonymous2View = PlanNode.withCityNameAndPlaceName(b.c, StationRoutePlanningActivity.g(StationRoutePlanningActivity.this));
                StationRoutePlanningActivity.this.a.transitSearch(new TransitRoutePlanOption().from(paramAnonymous2AdapterView).city(b.c).to(paramAnonymous2View));
                StationRoutePlanningActivity.this.showProgress("");
                StationRoutePlanningActivity.h(StationRoutePlanningActivity.this).setText(StationRoutePlanningActivity.g(StationRoutePlanningActivity.this));
                StationRoutePlanningActivity.e(StationRoutePlanningActivity.this).setVisibility(8);
              }
            });
            StationRoutePlanningActivity.h(StationRoutePlanningActivity.this).setText("结束地点有歧义,请重新选择");
            StationRoutePlanningActivity.e(StationRoutePlanningActivity.this).setVisibility(0);
            return;
          }
          paramAnonymousAdapterView = PlanNode.withCityNameAndPlaceName(b.c, StationRoutePlanningActivity.f(StationRoutePlanningActivity.this));
          paramAnonymousView = PlanNode.withCityNameAndPlaceName(b.c, StationRoutePlanningActivity.g(StationRoutePlanningActivity.this));
          StationRoutePlanningActivity.this.a.transitSearch(new TransitRoutePlanOption().from(paramAnonymousAdapterView).city(b.c).to(paramAnonymousView));
          StationRoutePlanningActivity.this.showProgress("");
          StationRoutePlanningActivity.h(StationRoutePlanningActivity.this).setText(StationRoutePlanningActivity.g(StationRoutePlanningActivity.this));
          StationRoutePlanningActivity.e(StationRoutePlanningActivity.this).setVisibility(8);
        }
      });
      this.t.setText("开始地点有歧义,请重新选择");
      this.u.setVisibility(0);
    }
    while ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      HashMap localHashMap;
      return;
    }
    this.v.clear();
    paramSuggestAddrInfo = ((List)localObject1).iterator();
    while (paramSuggestAddrInfo.hasNext())
    {
      localObject1 = (PoiInfo)paramSuggestAddrInfo.next();
      localObject2 = new HashMap();
      ((Map)localObject2).put("name", ((PoiInfo)localObject1).name);
      ((Map)localObject2).put("detail", ((PoiInfo)localObject1).address);
      this.v.add(localObject2);
    }
    this.u.setAdapter(new b(this.v));
    this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        StationRoutePlanningActivity.b(StationRoutePlanningActivity.this, (String)((Map)StationRoutePlanningActivity.d(StationRoutePlanningActivity.this).get(paramAnonymousInt)).get("name"));
        paramAnonymousAdapterView = PlanNode.withCityNameAndPlaceName(b.c, StationRoutePlanningActivity.f(StationRoutePlanningActivity.this));
        paramAnonymousView = PlanNode.withCityNameAndPlaceName(b.c, StationRoutePlanningActivity.g(StationRoutePlanningActivity.this));
        StationRoutePlanningActivity.this.a.transitSearch(new TransitRoutePlanOption().from(paramAnonymousAdapterView).city(b.c).to(paramAnonymousView));
        StationRoutePlanningActivity.this.showProgress("");
        StationRoutePlanningActivity.h(StationRoutePlanningActivity.this).setText(StationRoutePlanningActivity.g(StationRoutePlanningActivity.this));
        StationRoutePlanningActivity.e(StationRoutePlanningActivity.this).setVisibility(8);
      }
    });
    this.t.setText("结束地点有歧义,请重新选择");
    this.u.setVisibility(0);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903521);
    this.b = getIntent().getStringExtra("search_node");
    this.c = getIntent().getStringExtra("resblock_name");
    this.d = getIntent().getStringExtra("search_location");
    this.e = ((ListView)findViewById(2131691217));
    this.a = RoutePlanSearch.newInstance();
    this.a.setOnGetRoutePlanResultListener(this);
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.r = new a();
    this.e.setAdapter(this.r);
    this.t = ((TextView)findViewById(2131689533));
    this.t.setText(this.c);
    this.u = ((ListView)findViewById(2131692233));
    ((ImageView)findViewById(2131689492)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        StationRoutePlanningActivity.this.finish();
      }
    });
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ApplicationEx.c.putData("RouteLines", StationRoutePlanningActivity.a(StationRoutePlanningActivity.this));
        ApplicationEx.c.putData("data", StationRoutePlanningActivity.b(StationRoutePlanningActivity.this));
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.setClass(StationRoutePlanningActivity.this, StationRoutePlanningMapActivity.class);
        paramAnonymousAdapterView.putExtra("key", "RouteLines");
        paramAnonymousAdapterView.putExtra("data", "data");
        paramAnonymousAdapterView.putExtra("position", paramAnonymousInt);
        StationRoutePlanningActivity.this.startActivity(paramAnonymousAdapterView);
      }
    });
    if (!TextUtils.isEmpty(this.c))
    {
      paramBundle = this.c;
      if (paramBundle.contains("号线")) {
        this.c = (paramBundle.substring(paramBundle.lastIndexOf("号线") + 2) + "地铁站");
      }
    }
    paramBundle = PlanNode.withCityNameAndPlaceName(b.c, this.b);
    PlanNode localPlanNode = PlanNode.withCityNameAndPlaceName(b.c, this.c);
    if ((this.d != null) && (this.d.length() > 0) && (!"null".equals(this.d)))
    {
      localPlanNode = PlanNode.withLocation(Str2LatLng(this.d));
      this.a.transitSearch(new TransitRoutePlanOption().from(paramBundle).city(b.c).to(localPlanNode));
    }
    for (;;)
    {
      showProgress("");
      return;
      this.a.transitSearch(new TransitRoutePlanOption().from(paramBundle).city(b.c).to(localPlanNode));
    }
  }
  
  public void onGetBikingRouteResult(BikingRouteResult paramBikingRouteResult) {}
  
  public void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult) {}
  
  public void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult)
  {
    dismissProgress();
    if (paramTransitRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
      a(paramTransitRouteResult.getSuggestAddrInfo());
    }
    do
    {
      return;
      if (paramTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        this.s = paramTransitRouteResult.getRouteLines();
        this.f.clear();
        Iterator localIterator = this.s.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (TransitRouteLine)localIterator.next();
          HashMap localHashMap1 = new HashMap();
          localHashMap1.put("totalTime", Integer.valueOf(((TransitRouteLine)localObject).getDuration()));
          localHashMap1.put("totalLength", Integer.valueOf(((TransitRouteLine)localObject).getDistance()));
          ArrayList localArrayList = new ArrayList();
          localObject = ((TransitRouteLine)localObject).getAllStep().iterator();
          while (((Iterator)localObject).hasNext())
          {
            TransitRouteLine.TransitStep localTransitStep = (TransitRouteLine.TransitStep)((Iterator)localObject).next();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("length", localTransitStep.getDistance() + "");
            if ((!"WAKLING".equals(localTransitStep.getStepType())) && (localTransitStep.getVehicleInfo() != null))
            {
              localHashMap2.put("name", localTransitStep.getVehicleInfo().getTitle());
              localHashMap2.put("stationNum", localTransitStep.getVehicleInfo().getPassStationNum() + "");
            }
            localHashMap2.put("type", localTransitStep.getStepType() + "");
            localArrayList.add(localHashMap2);
          }
          localHashMap1.put("detail", localArrayList);
          this.f.add(localHashMap1);
        }
        this.e.setVisibility(0);
        this.r.notifyDataSetChanged();
      }
    } while ((paramTransitRouteResult != null) && (paramTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR));
    g.textToast(this, "抱歉，未找到结果");
  }
  
  public void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult) {}
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return StationRoutePlanningActivity.c(StationRoutePlanningActivity.this).size();
    }
    
    public Map<String, Object> getItem(int paramInt)
    {
      return (Map)StationRoutePlanningActivity.c(StationRoutePlanningActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = StationRoutePlanningActivity.this.getLayoutInflater().inflate(2130904284, null);
      paramView = getItem(paramInt);
      TextView localTextView = (TextView)localView.findViewById(2131692236);
      Object localObject = (TextView)localView.findViewById(2131690567);
      String str = paramView.get("totalTime").toString();
      paramViewGroup = (List)paramView.get("detail");
      paramView = new StringBuffer();
      paramViewGroup = paramViewGroup.iterator();
      paramInt = 0;
      int j = 0;
      int i;
      if (paramViewGroup.hasNext())
      {
        Map localMap = (Map)paramViewGroup.next();
        i = j;
        if ("WAKLING".equals(((String)localMap.get("type")).toString())) {
          i = j + Integer.parseInt(((String)localMap.get("length")).toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localMap.get("name")))
        {
          paramView.append((String)localMap.get("name"));
          paramView.append("→");
        }
        if (TextUtils.isEmpty((CharSequence)localMap.get("stationNum"))) {
          break label384;
        }
        paramInt = Integer.parseInt(((String)localMap.get("stationNum")).toString()) + paramInt;
      }
      label384:
      for (;;)
      {
        j = i;
        break;
        paramViewGroup = paramView.toString();
        paramView = paramViewGroup;
        if (paramViewGroup.endsWith("→")) {
          paramView = paramViewGroup.substring(0, paramViewGroup.length() - 1);
        }
        localTextView.setText(paramView);
        paramViewGroup = "约" + m.secToTime(Integer.parseInt(str)) + "  |  " + paramInt + "站  |  步行" + j + "米";
        ((TextView)localObject).setText(paramViewGroup);
        localObject = new HashMap();
        ((HashMap)localObject).put("name", paramView);
        ((HashMap)localObject).put("detail", paramViewGroup);
        StationRoutePlanningActivity.b(StationRoutePlanningActivity.this).add(localObject);
        return localView;
      }
    }
  }
  
  class b
    extends BaseAdapter
  {
    private List<Map<String, String>> b;
    
    public b()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Map<String, String> getItem(int paramInt)
    {
      return (Map)this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = StationRoutePlanningActivity.this.getLayoutInflater().inflate(2130904852, null);
      paramViewGroup = (TextView)paramView.findViewById(2131690566);
      TextView localTextView = (TextView)paramView.findViewById(2131690567);
      paramViewGroup.setText((CharSequence)getItem(paramInt).get("name"));
      localTextView.setText((CharSequence)getItem(paramInt).get("detail"));
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/baidumap/StationRoutePlanningActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */