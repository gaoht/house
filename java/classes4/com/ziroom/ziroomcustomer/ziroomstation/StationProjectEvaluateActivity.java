package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.f.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.view.CustomTabLayout;
import com.ziroom.ziroomcustomer.home.view.CustomTabLayout.a;
import com.ziroom.ziroomcustomer.home.view.CustomTabLayout.b;
import com.ziroom.ziroomcustomer.newclean.d.bo;
import com.ziroom.ziroomcustomer.newclean.d.bo.a;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationDescription;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StationProjectEvaluateActivity
  extends BaseActivity
{
  RelativeLayout a;
  CustomTabLayout b;
  @BindView(2131690078)
  View btn_back;
  private Context c;
  private int d = 1;
  private boolean e = false;
  private int f = 1;
  private String g;
  private a r;
  @BindView(2131692586)
  RelativeLayout rl_out_container;
  @BindView(2131692585)
  RecyclerView rv_eva;
  private List<StationDescription> s;
  private int t = -1;
  @BindView(2131692584)
  TextView tv_title_project_name;
  private int u = -1;
  @BindView(2131689863)
  View v_divider;
  @BindView(2131692587)
  View v_out_line;
  
  private void a()
  {
    this.rv_eva.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (!StationProjectEvaluateActivity.this.rv_eva.canScrollVertically(1)) {
          StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this);
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)StationProjectEvaluateActivity.this.rv_eva.getLayoutManager();
        paramAnonymousInt1 = paramAnonymousRecyclerView.findFirstVisibleItemPosition();
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.findViewByPosition(paramAnonymousInt1);
        paramAnonymousInt2 = paramAnonymousRecyclerView.getHeight();
        int i = paramAnonymousRecyclerView.getTop();
        if ((StationProjectEvaluateActivity.b(StationProjectEvaluateActivity.this) > 0) && (StationProjectEvaluateActivity.c(StationProjectEvaluateActivity.this) > 0))
        {
          if (StationProjectEvaluateActivity.b(StationProjectEvaluateActivity.this) <= paramAnonymousInt1 * paramAnonymousInt2 - i) {
            break label220;
          }
          if ((StationProjectEvaluateActivity.this.rl_out_container.getChildCount() == 1) && ((StationProjectEvaluateActivity.this.rl_out_container.getChildAt(0) instanceof CustomTabLayout)))
          {
            ((RelativeLayout)StationProjectEvaluateActivity.this.b.getParent()).removeView(StationProjectEvaluateActivity.this.b);
            StationProjectEvaluateActivity.this.a.addView(StationProjectEvaluateActivity.this.b);
            StationProjectEvaluateActivity.this.rl_out_container.setVisibility(8);
            StationProjectEvaluateActivity.this.v_out_line.setVisibility(8);
            StationProjectEvaluateActivity.this.tv_title_project_name.setVisibility(8);
            StationProjectEvaluateActivity.this.v_divider.setVisibility(8);
          }
        }
        label220:
        while ((StationProjectEvaluateActivity.this.a.getChildCount() != 1) || (!(StationProjectEvaluateActivity.this.a.getChildAt(0) instanceof CustomTabLayout))) {
          return;
        }
        ((RelativeLayout)StationProjectEvaluateActivity.this.b.getParent()).removeView(StationProjectEvaluateActivity.this.b);
        StationProjectEvaluateActivity.this.rl_out_container.addView(StationProjectEvaluateActivity.this.b);
        StationProjectEvaluateActivity.this.rl_out_container.setVisibility(0);
        StationProjectEvaluateActivity.this.v_out_line.setVisibility(0);
        StationProjectEvaluateActivity.this.tv_title_project_name.setVisibility(0);
        StationProjectEvaluateActivity.this.v_divider.setVisibility(0);
      }
    });
  }
  
  private void b()
  {
    this.rv_eva.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
  }
  
  private List<StationDescription> d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramString);
      com.freelxl.baselibrary.f.d.i("Http evaluate items nums:", "array.length()" + localJSONArray1.length());
      int k = 0;
      if (k < localJSONArray1.length())
      {
        StationDescription localStationDescription = new StationDescription();
        JSONArray localJSONArray2 = (JSONArray)localJSONArray1.opt(k);
        int i = 0;
        int j = 0;
        int m = 0;
        label97:
        JSONObject localJSONObject;
        int n;
        label296:
        Object localObject1;
        int i1;
        if (m < localJSONArray2.length())
        {
          localJSONObject = (JSONObject)localJSONArray2.opt(m);
          if (TextUtils.isEmpty(localStationDescription.text_date)) {
            localStationDescription.text_date = localJSONObject.optString("evaluateDate");
          }
          if (TextUtils.isEmpty(localStationDescription.evaluatorId)) {
            localStationDescription.text_phone = localJSONObject.optString("evaluatorId");
          }
          if (TextUtils.isEmpty(localStationDescription.orderCode)) {
            localStationDescription.orderCode = localJSONObject.optString("orderCode");
          }
          if (TextUtils.isEmpty(localStationDescription.ext)) {
            localStationDescription.ext = localJSONObject.optString("ext");
          }
          paramString = new JSONArray(localJSONObject.optString("answers")).toString();
          paramString = paramString.substring(1, paramString.length() - 1);
          if (i.TextisEmpty(paramString))
          {
            n = i;
            i = j;
            j = n;
            break label640;
          }
          if ((!"5".equals(localJSONObject.optString("optionType"))) && (!"2".equals(localJSONObject.optString("optionType"))))
          {
            paramString = paramString.split(",");
            localObject1 = new ArrayList();
            i1 = paramString.length;
            n = 0;
          }
        }
        for (;;)
        {
          Object localObject2;
          if (n < i1)
          {
            CharSequence localCharSequence = paramString[n];
            localObject2 = localObject1;
            if (i.TextisEmpty(localCharSequence)) {
              break label661;
            }
            localObject2 = localCharSequence.substring(localCharSequence.indexOf("\"") + 1, localCharSequence.lastIndexOf("\""));
            if ("5".equals(localJSONObject.optString("optionType")))
            {
              localObject2 = Arrays.asList(((String)localObject2).replace("\\", "").split(","));
              break label661;
              paramString = new String[] { paramString };
              break label296;
            }
            ((List)localObject1).add(localObject2);
            localObject2 = localObject1;
            break label661;
          }
          if ("2".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.text_desc = i.listToString((List)localObject1);
          }
          if ("4".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.tags = ((List)localObject1);
          }
          if ("5".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.imgUrls = ((List)localObject1);
          }
          if ("6".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.room_types = ((List)localObject1);
          }
          boolean bool = "7".equals(localJSONObject.optString("optionType"));
          if (bool)
          {
            n = j + 1;
            try
            {
              paramString = ((List)localObject1).iterator();
              j = i;
              while (paramString.hasNext())
              {
                i = Integer.valueOf((String)paramString.next()).intValue();
                j += i;
              }
              i = n;
            }
            catch (Exception paramString)
            {
              j = 0;
              i = n;
            }
            localStationDescription.count_star = Math.round(i / j);
            localArrayList.add(localStationDescription);
            k += 1;
            break;
          }
          n = j;
          j = i;
          i = n;
          label640:
          n = m + 1;
          m = j;
          j = i;
          i = m;
          m = n;
          break label97;
          label661:
          n += 1;
          localObject1 = localObject2;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString) {}
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("eva_grade");
    int i = localIntent.getIntExtra("eva_count", 0);
    String str1 = localIntent.getStringExtra("project_name");
    this.g = localIntent.getStringExtra("project_id");
    try
    {
      f1 = Float.parseFloat(str2);
      this.tv_title_project_name.setText(str1);
      this.r = new a(this.c, this.s, str1, f1, i);
      this.rv_eva.setAdapter(this.r);
      f();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        float f1 = 0.0F;
      }
    }
  }
  
  private void f()
  {
    if (!this.e)
    {
      this.e = true;
      if (!TextUtils.isEmpty(this.g))
      {
        Object localObject = this.g;
        int i = this.d;
        this.d = (i + 1);
        localObject = b.buildGetZryEvaluate((String)localObject, i, 5, this.f);
        com.freelxl.baselibrary.d.a.post(q.U + com.ziroom.ziroomcustomer.ziroomstation.b.d.A).params((Map)localObject).enqueue(new com.ziroom.commonlibrary.a.a(this.c, new e())
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
            StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this, false);
          }
          
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousString);
            paramAnonymousString = h.getJsonString(paramAnonymousString, "data");
            paramAnonymousString = StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this, paramAnonymousString);
            if (StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this) == null) {
              StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this, new ArrayList());
            }
            if (paramAnonymousString != null)
            {
              Object localObject = new StringBuilder();
              Iterator localIterator = paramAnonymousString.iterator();
              while (localIterator.hasNext()) {
                ((StringBuilder)localObject).append(((StationDescription)localIterator.next()).text_phone).append(",");
              }
              if (((StringBuilder)localObject).length() > 0)
              {
                ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
                localObject = b.buildStationUserInfo(StationProjectEvaluateActivity.e(StationProjectEvaluateActivity.this), ((StringBuilder)localObject).toString(), 0);
                com.freelxl.baselibrary.d.a.post(q.B + com.ziroom.ziroomcustomer.ziroomstation.b.d.J).params((Map)localObject).enqueue(new com.ziroom.commonlibrary.a.a(StationProjectEvaluateActivity.e(StationProjectEvaluateActivity.this), new com.freelxl.baselibrary.d.f.d(bo.class))
                {
                  public void onSuccess(int paramAnonymous2Int, bo paramAnonymous2bo)
                  {
                    super.onSuccess(paramAnonymous2Int, paramAnonymous2bo);
                    if ((paramAnonymous2bo != null) && (paramAnonymous2bo.getData() != null))
                    {
                      paramAnonymous2bo = paramAnonymous2bo.getData().iterator();
                      while (paramAnonymous2bo.hasNext())
                      {
                        bo.a locala = (bo.a)paramAnonymous2bo.next();
                        paramAnonymous2Int = 0;
                        while (paramAnonymous2Int < StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).size())
                        {
                          if ((!TextUtils.isEmpty(((StationDescription)StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).get(paramAnonymous2Int)).text_phone)) && (((StationDescription)StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).get(paramAnonymous2Int)).text_phone.equals(locala.getUid())))
                          {
                            ((StationDescription)StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).get(paramAnonymous2Int)).headerUrl = locala.getHead_img();
                            ((StationDescription)StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).get(paramAnonymous2Int)).nickname = locala.getNick_name();
                          }
                          paramAnonymous2Int += 1;
                        }
                      }
                      if ((StationProjectEvaluateActivity.f(StationProjectEvaluateActivity.this) != null) && (StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this) != null)) {
                        StationProjectEvaluateActivity.f(StationProjectEvaluateActivity.this).setDatas(StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this));
                      }
                    }
                  }
                });
              }
              StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).addAll(paramAnonymousString);
              StationProjectEvaluateActivity.f(StationProjectEvaluateActivity.this).setDatas(StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this));
            }
            StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this, false);
          }
        });
      }
    }
  }
  
  @OnClick({2131690078})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903520);
    this.c = this;
    ButterKnife.bind(this);
    b();
    e();
    a();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  class a
    extends RecyclerView.a<b>
  {
    private Context b;
    private List<StationDescription> c;
    private String d;
    private float e;
    private int f;
    private boolean g = false;
    private SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public a(List<StationDescription> paramList, String paramString, float paramFloat, int paramInt)
    {
      this.b = paramList;
      this.c = paramString;
      this.d = paramFloat;
      int i;
      this.f = i;
      this.e = paramInt;
    }
    
    public int getItemCount()
    {
      if (this.c == null) {
        return 1;
      }
      return this.c.size() + 1;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == 0) {
        return 1;
      }
      return 2;
    }
    
    public void onBindViewHolder(final b paramb, int paramInt)
    {
      Object localObject1;
      if ((paramInt == 0) && (!this.g))
      {
        this.g = true;
        if (this.e == 0.0F)
        {
          paramb.p.setText("0.0");
          localObject2 = paramb.q;
          if (this.d != null) {
            break label230;
          }
          localObject1 = "";
          ((TextView)localObject2).setText((CharSequence)localObject1);
          paramb.r.setText(this.f + "条评价");
          StationProjectEvaluateActivity.this.b.setTabTextColors(Color.parseColor("#999999"), Color.parseColor("#ffa000"));
          StationProjectEvaluateActivity.this.b.addTab(StationProjectEvaluateActivity.this.b.newTab().setText("全部"), false);
          StationProjectEvaluateActivity.this.b.addTab(StationProjectEvaluateActivity.this.b.newTab().setText("有图"), true);
          StationProjectEvaluateActivity.this.b.setOnTabSelectedListener(new CustomTabLayout.a()
          {
            public void onTabReselected(CustomTabLayout.b paramAnonymousb) {}
            
            public void onTabSelected(CustomTabLayout.b paramAnonymousb)
            {
              StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this, paramAnonymousb.getPosition());
              StationProjectEvaluateActivity.b(StationProjectEvaluateActivity.this, 1);
              if (StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this) != null) {
                StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this).clear();
              }
              StationProjectEvaluateActivity.a(StationProjectEvaluateActivity.this);
            }
            
            public void onTabUnselected(CustomTabLayout.b paramAnonymousb) {}
          });
          StationProjectEvaluateActivity.this.b.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public boolean onPreDraw()
            {
              StationProjectEvaluateActivity.c(StationProjectEvaluateActivity.this, StationProjectEvaluateActivity.this.a.getTop());
              StationProjectEvaluateActivity.d(StationProjectEvaluateActivity.this, StationProjectEvaluateActivity.this.b.getBottom() - StationProjectEvaluateActivity.this.b.getTop());
              ViewGroup.LayoutParams localLayoutParams = StationProjectEvaluateActivity.this.a.getLayoutParams();
              localLayoutParams.height = StationProjectEvaluateActivity.c(StationProjectEvaluateActivity.this);
              StationProjectEvaluateActivity.this.a.setLayoutParams(localLayoutParams);
              StationProjectEvaluateActivity.this.b.getViewTreeObserver().removeOnPreDrawListener(this);
              return false;
            }
          });
        }
      }
      label198:
      label230:
      while (paramInt <= 0) {
        for (;;)
        {
          return;
          localObject1 = new DecimalFormat(".0").format(this.e);
          paramb.p.setText((CharSequence)localObject1);
          continue;
          localObject1 = this.d;
        }
      }
      paramInt -= 1;
      Object localObject2 = paramb.b;
      if (((StationDescription)this.c.get(paramInt)).headerUrl == null)
      {
        localObject1 = "";
        label276:
        ((SimpleDraweeView)localObject2).setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject1));
        localObject2 = paramb.d;
        if (!TextUtils.isEmpty(((StationDescription)this.c.get(paramInt)).nickname)) {
          break label937;
        }
        localObject1 = this.b.getResources().getString(2131297472);
        label328:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        if ((((StationDescription)this.c.get(paramInt)).imgUrls != null) && (((StationDescription)this.c.get(paramInt)).imgUrls.size() != 0)) {
          break label958;
        }
        paramb.c.setVisibility(8);
        paramb.j.setVisibility(8);
        label396:
        if (TextUtils.isEmpty(((StationDescription)this.c.get(paramInt)).text_date)) {}
      }
      for (;;)
      {
        try
        {
          l1 = this.h.parse(((StationDescription)this.c.get(paramInt)).text_date).getTime();
          l2 = System.currentTimeMillis() - l1;
          f1 = (float)(l2 / 86400000L);
          if (f1 >= 1.0F) {
            continue;
          }
          paramb.e.setText(new SimpleDateFormat("H").format(new Date(l2)) + "小时前");
        }
        catch (ParseException localParseException)
        {
          long l1;
          long l2;
          float f1;
          localParseException.printStackTrace();
          continue;
          if (f1 >= 365.0F) {
            continue;
          }
          paramb.e.setText(new SimpleDateFormat("MM/dd").format(new Date(l1)));
          continue;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label937:
          label958:
          localNumberFormatException.printStackTrace();
          continue;
          paramb.e.setText(((StationDescription)this.c.get(paramInt)).text_date.split(" ")[0]);
          continue;
          paramb.g.setVisibility(0);
          paramb.g.setText(((StationDescription)this.c.get(paramInt)).text_desc);
          paramb.g.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public boolean onPreDraw()
            {
              if (paramb.g.getLineCount() > 3)
              {
                paramb.g.setMaxLines(3);
                paramb.h.setVisibility(0);
                paramb.h.setOnClickListener(new View.OnClickListener()
                {
                  @Instrumented
                  public void onClick(View paramAnonymous2View)
                  {
                    VdsAgent.onClick(this, paramAnonymous2View);
                    StationProjectEvaluateActivity.a.4.this.a.h.setVisibility(8);
                    StationProjectEvaluateActivity.a.4.this.a.g.setMaxLines(100);
                  }
                });
                paramb.g.getViewTreeObserver().removeOnPreDrawListener(this);
              }
              return true;
            }
          });
          continue;
          paramb.k.setImageResource(2130839774);
          paramb.l.setImageResource(2130839775);
          paramb.m.setImageResource(2130839775);
          paramb.n.setImageResource(2130839775);
          paramb.o.setImageResource(2130839775);
          continue;
          paramb.k.setImageResource(2130839774);
          paramb.l.setImageResource(2130839774);
          paramb.m.setImageResource(2130839775);
          paramb.n.setImageResource(2130839775);
          paramb.o.setImageResource(2130839775);
          continue;
          paramb.k.setImageResource(2130839774);
          paramb.l.setImageResource(2130839774);
          paramb.m.setImageResource(2130839774);
          paramb.n.setImageResource(2130839775);
          paramb.o.setImageResource(2130839775);
          continue;
          paramb.k.setImageResource(2130839774);
          paramb.l.setImageResource(2130839774);
          paramb.m.setImageResource(2130839774);
          paramb.n.setImageResource(2130839774);
          paramb.o.setImageResource(2130839775);
          continue;
          paramb.k.setImageResource(2130839774);
          paramb.l.setImageResource(2130839774);
          paramb.m.setImageResource(2130839774);
          paramb.n.setImageResource(2130839774);
          paramb.o.setImageResource(2130839774);
          continue;
          paramb.i.setVisibility(8);
        }
        if (!TextUtils.isEmpty(((StationDescription)this.c.get(paramInt)).text_desc)) {
          continue;
        }
        paramb.g.setVisibility(8);
        paramb.h.setVisibility(8);
        localObject1 = new DecimalFormat(".0").format(((StationDescription)this.c.get(paramInt)).count_star);
        paramb.f.setText((CharSequence)localObject1);
        switch (((StationDescription)this.c.get(paramInt)).count_star)
        {
        default: 
          paramb.k.setImageResource(2130839775);
          paramb.l.setImageResource(2130839775);
          paramb.m.setImageResource(2130839775);
          paramb.n.setImageResource(2130839775);
          paramb.o.setImageResource(2130839775);
          if ((((StationDescription)this.c.get(paramInt)).tags == null) || (((StationDescription)this.c.get(paramInt)).tags.size() <= 0)) {
            continue;
          }
          paramb.i.removeAllViews();
          paramb.i.setVisibility(0);
          localObject1 = ((StationDescription)this.c.get(paramInt)).tags.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label198;
          }
          Object localObject3 = (String)((Iterator)localObject1).next();
          localObject2 = new TextView(this.b);
          ((TextView)localObject2).setText((CharSequence)localObject3);
          ((TextView)localObject2).setTextColor(this.b.getResources().getColor(2131624550));
          ((TextView)localObject2).setBackgroundResource(2130839680);
          ((TextView)localObject2).setTextSize(10.0F);
          paramInt = n.dip2px(this.b, 6.0F);
          ((TextView)localObject2).setPadding(paramInt, paramInt, paramInt, paramInt);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).setMargins(0, paramInt, paramInt, 0);
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramb.i.addView((View)localObject2);
          continue;
          localObject1 = ((StationDescription)this.c.get(paramInt)).headerUrl;
          break label276;
          localObject1 = ((StationDescription)this.c.get(paramInt)).nickname;
          break label328;
          if (((StationDescription)this.c.get(paramInt)).imgUrls.size() == 1)
          {
            paramb.c.setVisibility(0);
            paramb.j.setVisibility(8);
            paramb.c.setController(com.freelxl.baselibrary.f.c.frescoController((String)((StationDescription)this.c.get(paramInt)).imgUrls.get(0)));
            paramb.c.setTag(((StationDescription)this.c.get(paramInt)).imgUrls.get(0));
            paramb.c.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                Object localObject = (String)paramAnonymousView.getTag();
                paramAnonymousView = new ArrayList();
                paramAnonymousView.add(localObject);
                localObject = new Intent(StationProjectEvaluateActivity.a.a(StationProjectEvaluateActivity.a.this), PhotoPreviewActivity.class);
                ((Intent)localObject).putStringArrayListExtra("photoDescription", paramAnonymousView);
                ((Intent)localObject).putExtra("position", 0);
                ((Intent)localObject).putExtra("isDeleteable", false);
                ((Activity)StationProjectEvaluateActivity.a.a(StationProjectEvaluateActivity.a.this)).startActivityForResult((Intent)localObject, 257);
              }
            });
            break label396;
          }
          paramb.c.setVisibility(8);
          paramb.j.setVisibility(0);
          paramb.j.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
          paramb.j.setAdapter(new a(((StationDescription)this.c.get(paramInt)).imgUrls, this.b));
          break label396;
          if (f1 >= 4.0F) {
            continue;
          }
          paramb.e.setText(Integer.parseInt(new SimpleDateFormat("d").format(new Date(l2))) - 1 + "天前");
        }
      }
    }
    
    public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = null;
      switch (paramInt)
      {
      default: 
        paramViewGroup = (ViewGroup)localObject;
      }
      for (;;)
      {
        return new b(paramViewGroup);
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904554, paramViewGroup, false);
        paramViewGroup.setTag(Integer.valueOf(1));
        continue;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904553, paramViewGroup, false);
        paramViewGroup.setTag(Integer.valueOf(2));
      }
    }
    
    public void setDatas(List<StationDescription> paramList)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
    
    class a
      extends RecyclerView.a<a>
    {
      private ArrayList<String> b = new ArrayList();
      private Context c;
      
      public a(Context paramContext)
      {
        int i = 0;
        while ((paramContext != null) && (i < paramContext.size()))
        {
          this.b.add(paramContext.get(i));
          i += 1;
        }
        Context localContext;
        this.c = localContext;
      }
      
      public int getItemCount()
      {
        if (this.b == null) {
          return 0;
        }
        return this.b.size();
      }
      
      public void onBindViewHolder(a parama, int paramInt)
      {
        Object localObject = new DisplayMetrics();
        ((Activity)this.c).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        int i = (((DisplayMetrics)localObject).widthPixels - n.dip2px(this.c, 103.0F)) / 4;
        localObject = parama.a;
        int j;
        label64:
        SimpleDraweeView localSimpleDraweeView;
        if (i > 0)
        {
          j = i;
          if (i <= 0) {
            break label143;
          }
          ((SimpleDraweeView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, i));
          localSimpleDraweeView = parama.a;
          if (this.b.get(paramInt) != null) {
            break label148;
          }
        }
        label143:
        label148:
        for (localObject = "";; localObject = (String)this.b.get(paramInt))
        {
          localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject));
          parama.a.setTag(Integer.valueOf(paramInt));
          parama.a.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if (StationProjectEvaluateActivity.a.a.a(StationProjectEvaluateActivity.a.a.this) == null) {
                return;
              }
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = new Intent(StationProjectEvaluateActivity.a.a.b(StationProjectEvaluateActivity.a.a.this), PhotoPreviewActivity.class);
              paramAnonymousView.putStringArrayListExtra("photoDescription", StationProjectEvaluateActivity.a.a.a(StationProjectEvaluateActivity.a.a.this));
              paramAnonymousView.putExtra("position", i);
              paramAnonymousView.putExtra("isDeleteable", false);
              ((Activity)StationProjectEvaluateActivity.a.a.b(StationProjectEvaluateActivity.a.a.this)).startActivityForResult(paramAnonymousView, 257);
            }
          });
          return;
          j = -1;
          break;
          i = -1;
          break label64;
        }
      }
      
      public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
      {
        return new a(LayoutInflater.from(this.c).inflate(2130904555, paramViewGroup, false));
      }
      
      class a
        extends RecyclerView.u
      {
        SimpleDraweeView a;
        View b;
        
        public a(View paramView)
        {
          super();
          this.b = paramView;
          this.a = ((SimpleDraweeView)paramView.findViewById(2131694859));
        }
      }
    }
    
    class b
      extends RecyclerView.u
    {
      View a;
      SimpleDraweeView b;
      SimpleDraweeView c;
      TextView d;
      TextView e;
      TextView f;
      TextView g;
      View h;
      FlowLayout i;
      RecyclerView j;
      ImageView k;
      ImageView l;
      ImageView m;
      ImageView n;
      ImageView o;
      TextView p;
      TextView q;
      TextView r;
      
      public b(View paramView)
      {
        super();
        this.a = paramView;
        int i1 = ((Integer)paramView.getTag()).intValue();
        if (i1 == 1)
        {
          this.p = ((TextView)paramView.findViewById(2131695762));
          this.q = ((TextView)paramView.findViewById(2131692543));
          this.r = ((TextView)paramView.findViewById(2131691382));
          StationProjectEvaluateActivity.this.b = ((CustomTabLayout)paramView.findViewById(2131690785));
          StationProjectEvaluateActivity.this.a = ((RelativeLayout)paramView.findViewById(2131695763));
        }
        while (i1 != 2) {
          return;
        }
        this.b = ((SimpleDraweeView)paramView.findViewById(2131695112));
        this.c = ((SimpleDraweeView)paramView.findViewById(2131695743));
        this.d = ((TextView)paramView.findViewById(2131690049));
        this.e = ((TextView)paramView.findViewById(2131689852));
        this.f = ((TextView)paramView.findViewById(2131695740));
        this.g = ((TextView)paramView.findViewById(2131691383));
        this.h = paramView.findViewById(2131695741);
        this.i = ((FlowLayout)paramView.findViewById(2131695759));
        this.j = ((RecyclerView)paramView.findViewById(2131695742));
        this.k = ((ImageView)paramView.findViewById(2131695735));
        this.l = ((ImageView)paramView.findViewById(2131695736));
        this.m = ((ImageView)paramView.findViewById(2131695737));
        this.n = ((ImageView)paramView.findViewById(2131695738));
        this.o = ((ImageView)paramView.findViewById(2131695739));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationProjectEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */