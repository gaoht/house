package com.ziroom.ziroomcustomer.findhouse;

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
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RoutePlanningActivity
  extends BaseActivity
  implements OnGetRoutePlanResultListener
{
  RoutePlanSearch a = null;
  private String b;
  private String c;
  private ListView d;
  private ArrayList<HashMap<String, Object>> e;
  private List<HashMap<String, String>> f;
  private a g;
  private List<TransitRouteLine> r;
  private TextView s;
  private ListView t;
  private List<Map<String, String>> u;
  
  private void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.u = new ArrayList();
    final Object localObject1 = paramSuggestAddrInfo.getSuggestEndNode();
    paramSuggestAddrInfo = paramSuggestAddrInfo.getSuggestStartNode();
    Object localObject2;
    if ((paramSuggestAddrInfo != null) && (paramSuggestAddrInfo.size() > 0))
    {
      this.u.clear();
      paramSuggestAddrInfo = paramSuggestAddrInfo.iterator();
      while (paramSuggestAddrInfo.hasNext())
      {
        localObject2 = (PoiInfo)paramSuggestAddrInfo.next();
        localHashMap = new HashMap();
        localHashMap.put("name", ((PoiInfo)localObject2).name);
        localHashMap.put("detail", ((PoiInfo)localObject2).address);
        this.u.add(localHashMap);
      }
      this.t.setAdapter(new b(this.u));
      this.t.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          RoutePlanningActivity.a(RoutePlanningActivity.this, (String)((Map)RoutePlanningActivity.d(RoutePlanningActivity.this).get(paramAnonymousInt)).get("name"));
          if ((localObject1 != null) && (localObject1.size() > 0))
          {
            RoutePlanningActivity.d(RoutePlanningActivity.this).clear();
            paramAnonymousAdapterView = localObject1.iterator();
            while (paramAnonymousAdapterView.hasNext())
            {
              paramAnonymousView = (PoiInfo)paramAnonymousAdapterView.next();
              HashMap localHashMap = new HashMap();
              localHashMap.put("name", paramAnonymousView.name);
              localHashMap.put("detail", paramAnonymousView.address);
              RoutePlanningActivity.d(RoutePlanningActivity.this).add(localHashMap);
            }
            RoutePlanningActivity.e(RoutePlanningActivity.this).setAdapter(new RoutePlanningActivity.b(RoutePlanningActivity.this, RoutePlanningActivity.d(RoutePlanningActivity.this)));
            RoutePlanningActivity.e(RoutePlanningActivity.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              @Instrumented
              public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
              {
                VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
                RoutePlanningActivity.b(RoutePlanningActivity.this, (String)((Map)RoutePlanningActivity.d(RoutePlanningActivity.this).get(paramAnonymous2Int)).get("name"));
                paramAnonymous2AdapterView = PlanNode.withCityNameAndPlaceName(b.c, RoutePlanningActivity.f(RoutePlanningActivity.this));
                paramAnonymous2View = PlanNode.withCityNameAndPlaceName(b.c, RoutePlanningActivity.g(RoutePlanningActivity.this));
                RoutePlanningActivity.this.a.transitSearch(new TransitRoutePlanOption().from(paramAnonymous2AdapterView).city(b.c).to(paramAnonymous2View));
                RoutePlanningActivity.this.showProgress("");
                RoutePlanningActivity.h(RoutePlanningActivity.this).setText(RoutePlanningActivity.g(RoutePlanningActivity.this));
                RoutePlanningActivity.e(RoutePlanningActivity.this).setVisibility(8);
              }
            });
            RoutePlanningActivity.h(RoutePlanningActivity.this).setText("结束地点有歧义,请重新选择");
            RoutePlanningActivity.e(RoutePlanningActivity.this).setVisibility(0);
            return;
          }
          paramAnonymousAdapterView = PlanNode.withCityNameAndPlaceName(b.c, RoutePlanningActivity.f(RoutePlanningActivity.this));
          paramAnonymousView = PlanNode.withCityNameAndPlaceName(b.c, RoutePlanningActivity.g(RoutePlanningActivity.this));
          RoutePlanningActivity.this.a.transitSearch(new TransitRoutePlanOption().from(paramAnonymousAdapterView).city(b.c).to(paramAnonymousView));
          RoutePlanningActivity.this.showProgress("");
          RoutePlanningActivity.h(RoutePlanningActivity.this).setText(RoutePlanningActivity.g(RoutePlanningActivity.this));
          RoutePlanningActivity.e(RoutePlanningActivity.this).setVisibility(8);
        }
      });
      this.s.setText("开始地点有歧义,请重新选择");
      this.t.setVisibility(0);
    }
    while ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      HashMap localHashMap;
      return;
    }
    this.u.clear();
    paramSuggestAddrInfo = ((List)localObject1).iterator();
    while (paramSuggestAddrInfo.hasNext())
    {
      localObject1 = (PoiInfo)paramSuggestAddrInfo.next();
      localObject2 = new HashMap();
      ((Map)localObject2).put("name", ((PoiInfo)localObject1).name);
      ((Map)localObject2).put("detail", ((PoiInfo)localObject1).address);
      this.u.add(localObject2);
    }
    this.t.setAdapter(new b(this.u));
    this.t.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        RoutePlanningActivity.b(RoutePlanningActivity.this, (String)((Map)RoutePlanningActivity.d(RoutePlanningActivity.this).get(paramAnonymousInt)).get("name"));
        paramAnonymousAdapterView = PlanNode.withCityNameAndPlaceName(b.c, RoutePlanningActivity.f(RoutePlanningActivity.this));
        paramAnonymousView = PlanNode.withCityNameAndPlaceName(b.c, RoutePlanningActivity.g(RoutePlanningActivity.this));
        RoutePlanningActivity.this.a.transitSearch(new TransitRoutePlanOption().from(paramAnonymousAdapterView).city(b.c).to(paramAnonymousView));
        RoutePlanningActivity.this.showProgress("");
        RoutePlanningActivity.h(RoutePlanningActivity.this).setText(RoutePlanningActivity.g(RoutePlanningActivity.this));
        RoutePlanningActivity.e(RoutePlanningActivity.this).setVisibility(8);
      }
    });
    this.s.setText("结束地点有歧义,请重新选择");
    this.t.setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903460);
    this.b = getIntent().getStringExtra("search_node");
    this.c = getIntent().getStringExtra("resblock_name");
    this.d = ((ListView)findViewById(2131691217));
    this.a = RoutePlanSearch.newInstance();
    this.a.setOnGetRoutePlanResultListener(this);
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new a();
    this.d.setAdapter(this.g);
    this.s = ((TextView)findViewById(2131689533));
    this.s.setText(this.c);
    this.t = ((ListView)findViewById(2131692233));
    ((ImageView)findViewById(2131689492)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RoutePlanningActivity.this.finish();
      }
    });
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ApplicationEx.c.putData("RouteLines", RoutePlanningActivity.a(RoutePlanningActivity.this));
        ApplicationEx.c.putData("data", RoutePlanningActivity.b(RoutePlanningActivity.this));
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.setClass(RoutePlanningActivity.this, RoutePlanningMapActivity.class);
        paramAnonymousAdapterView.putExtra("key", "RouteLines");
        paramAnonymousAdapterView.putExtra("data", "data");
        paramAnonymousAdapterView.putExtra("position", paramAnonymousInt);
        RoutePlanningActivity.this.startActivity(paramAnonymousAdapterView);
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
    this.a.transitSearch(new TransitRoutePlanOption().from(paramBundle).city(b.c).to(localPlanNode));
    showProgress("");
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
        this.r = paramTransitRouteResult.getRouteLines();
        this.e.clear();
        Iterator localIterator = this.r.iterator();
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
          this.e.add(localHashMap1);
        }
        this.d.setVisibility(0);
        this.g.notifyDataSetChanged();
      }
    } while ((paramTransitRouteResult != null) && (paramTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR));
    g.textToast(this, "抱歉，未找到结果", 0);
  }
  
  public void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult) {}
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return RoutePlanningActivity.c(RoutePlanningActivity.this).size();
    }
    
    public Map<String, Object> getItem(int paramInt)
    {
      return (Map)RoutePlanningActivity.c(RoutePlanningActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = RoutePlanningActivity.this.getLayoutInflater().inflate(2130904284, null);
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
        RoutePlanningActivity.b(RoutePlanningActivity.this).add(localObject);
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
      paramView = RoutePlanningActivity.this.getLayoutInflater().inflate(2130904852, null);
      paramViewGroup = (TextView)paramView.findViewById(2131690566);
      TextView localTextView = (TextView)paramView.findViewById(2131690567);
      paramViewGroup.setText((CharSequence)getItem(paramInt).get("name"));
      localTextView.setText((CharSequence)getItem(paramInt).get("detail"));
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/RoutePlanningActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */