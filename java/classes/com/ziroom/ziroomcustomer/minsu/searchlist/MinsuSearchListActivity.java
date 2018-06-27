package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.home.view.CustomTabLayout;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseListSearchActivity;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.SearchTab;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.a.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.m;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class MinsuSearchListActivity
  extends BaseFluxActivity
  implements com.ziroom.ziroomcustomer.minsu.searchlist.base.a
{
  private ValueAnimator A;
  private ValueAnimator B;
  private boolean C = true;
  private BroadcastReceiver D = new MinsuSearchListActivity.10(this);
  public int b = 0;
  @BindView(2131691651)
  View btn_clean_keyword;
  @BindView(2131691664)
  View btn_clean_keyword_out;
  private Context c;
  @BindView(2131691657)
  CustomTabLayout ctl_tab_container;
  private Unbinder d;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a e;
  @BindView(2131691401)
  EditText et_search;
  @BindView(2131691663)
  EditText et_search_out;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a f;
  private Calendar g = null;
  @BindView(2131691652)
  View ic_minsu_map;
  @BindView(2131691667)
  View iv_arrow_up_out;
  @BindView(2131696323)
  View iv_condition;
  @BindView(2131691659)
  CardView ll_minsu_search_condition_bottom;
  @BindView(2131691656)
  LinearLayout ll_search_container;
  @BindView(2131691660)
  View ll_search_cover_container;
  private Calendar r = null;
  @BindView(2131691654)
  View rl_clear_container;
  @BindView(2131691653)
  RelativeLayout rl_search_lite_container;
  @BindView(2131691392)
  RelativeLayout rl_title_container;
  private String s = "";
  @BindView(2131691456)
  SearchListScrollView slsv_root;
  private String t = "";
  @BindView(2131691406)
  TextView tv_clear_global_condition;
  @BindView(2131691668)
  View tv_clear_out;
  @BindView(2131696322)
  TextView tv_condition;
  @BindView(2131696324)
  TextView tv_condition_num;
  @BindView(2131691571)
  TextView tv_info;
  @BindView(2131690748)
  TextView tv_location;
  @BindView(2131691407)
  TextView tv_search_city;
  @BindView(2131691670)
  TextView tv_search_city_out;
  @BindView(2131691655)
  TextView tv_search_condition_combination;
  @BindView(2131691410)
  TextView tv_search_count;
  @BindView(2131691672)
  TextView tv_search_count_out;
  @BindView(2131691408)
  TextView tv_search_date;
  @BindView(2131691671)
  TextView tv_search_date_out;
  @BindView(2131690900)
  TextView tv_sort;
  private List<BaseSearchListFragment> u;
  private com.ziroom.ziroomcustomer.minsu.searchlist.b.b v;
  @BindView(2131691658)
  ViewPager vp_fragment_container;
  private int w = 0;
  private boolean x = true;
  private int y;
  private int z;
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.c).registerReceiver(this.D, localIntentFilter);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    setStartDate(paramString1);
    setEndDate(paramString2);
    Object localObject1;
    if (ae.isNull(this.s))
    {
      localObject1 = null;
      this.g = ((Calendar)localObject1);
      if (!ae.isNull(this.t)) {
        break label217;
      }
      localObject1 = localObject2;
      label46:
      this.r = ((Calendar)localObject1);
      setDateStart(this.g);
      setDateEnd(this.r);
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        break label236;
      }
      int i = this.g.getTime().getMonth();
      int j = this.r.getTime().getMonth();
      paramString2 = m.getFormatDate(this.g.getTime(), "M月d日");
      localObject1 = this.r.getTime();
      if (i != j) {
        break label230;
      }
    }
    label217:
    label230:
    for (paramString1 = "d日";; paramString1 = "M月d日")
    {
      paramString1 = m.getFormatDate((Date)localObject1, paramString1);
      this.tv_search_date.setText(paramString2 + "-" + paramString1);
      this.tv_search_date_out.setText(paramString2 + "-" + paramString1);
      return;
      localObject1 = g(this.s);
      break;
      localObject1 = g(this.t);
      break label46;
    }
    label236:
    this.tv_search_date.setText("");
    this.tv_search_date_out.setText("");
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext()) {
        ((BaseSearchListFragment)localIterator.next()).reset();
      }
    }
    ((BaseSearchListFragment)this.u.get(this.vp_fragment_container.getCurrentItem())).request();
  }
  
  private void b()
  {
    if (this.A == null)
    {
      this.A = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.A.addUpdateListener(new MinsuSearchListActivity.1(this));
      this.A.setDuration(300L);
      this.A.addListener(new MinsuSearchListActivity.3(this));
    }
    if ((!this.A.isRunning()) && (this.rl_title_container.getLayoutParams().height <= 0) && ((this.B == null) || (!this.B.isRunning()))) {
      this.A.start();
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 9)
    {
      this.tv_search_count.setText("9+人");
      this.tv_search_count_out.setText("9+人");
      return;
    }
    if (paramInt <= 0)
    {
      this.tv_search_count.setText("");
      this.tv_search_count_out.setText("");
      return;
    }
    this.tv_search_count.setText(paramInt + "人");
    this.tv_search_count_out.setText(paramInt + "人");
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ll_search_cover_container.setVisibility(0);
      this.ll_minsu_search_condition_bottom.setVisibility(8);
    }
    do
    {
      return;
      this.ll_search_cover_container.setVisibility(8);
    } while (this.vp_fragment_container.getCurrentItem() != 0);
    this.ll_minsu_search_condition_bottom.setVisibility(0);
  }
  
  private void c(int paramInt)
  {
    k.toMinsuSearchTabActivity(this, paramInt);
  }
  
  private void d(String paramString)
  {
    this.tv_sort.setText(paramString);
  }
  
  private void e()
  {
    if (this.B == null)
    {
      this.B = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.B.addUpdateListener(new MinsuSearchListActivity.4(this));
      this.B.setDuration(300L);
      this.B.addListener(new MinsuSearchListActivity.5(this));
    }
    if ((!this.B.isRunning()) && (this.rl_title_container.getLayoutParams().height > 0) && ((this.A == null) || (!this.A.isRunning()))) {
      this.B.start();
    }
  }
  
  private void e(String paramString)
  {
    this.tv_location.setText(paramString);
  }
  
  private void f()
  {
    this.slsv_root.setOnScrollListener(new MinsuSearchListActivity.6(this));
    this.et_search.addTextChangedListener(new MinsuSearchListActivity.7(this));
    this.et_search_out.addTextChangedListener(new MinsuSearchListActivity.8(this));
    this.y = com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 44.0F);
    this.z = com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 46.0F);
  }
  
  private void f(String paramString)
  {
    this.et_search.setText(paramString);
    this.et_search_out.setText(paramString);
  }
  
  private Calendar g(String paramString)
  {
    Calendar localCalendar = null;
    if (ae.isNull(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      return localCalendar;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localCalendar;
      }
    }
  }
  
  private void g()
  {
    this.w = getIntent().getIntExtra("tab", 0);
    this.u = new ArrayList();
    this.u.add(MinsuSearchListFragment.getInstance());
    this.u.add(StationSearchListFragment.getInstance());
    this.u.add(StrategySearchListFragment.getInstance());
    this.v = new com.ziroom.ziroomcustomer.minsu.searchlist.b.b(getSupportFragmentManager(), this.u);
    this.vp_fragment_container.setAdapter(this.v);
    this.vp_fragment_container.setOffscreenPageLimit(3);
    this.ctl_tab_container.setTabsFromPagerAdapter(this.v);
    this.ctl_tab_container.setupWithViewPager(this.vp_fragment_container);
    this.ctl_tab_container.setTabTextColors(Color.parseColor("#444444"), Color.parseColor("#ffa000"));
    this.vp_fragment_container.addOnPageChangeListener(new MinsuSearchListActivity.9(this));
    this.slsv_root.getHelper().setCurrentScrollableContainer((a.a)this.u.get(this.w));
    this.ll_minsu_search_condition_bottom.setVisibility(0);
    h();
  }
  
  private void h()
  {
    int i = 0;
    if (!TextUtils.isEmpty(c.getInstance().getCityName())) {
      k();
    }
    if (!TextUtils.isEmpty(c.getInstance().getJiaxinDiscount())) {
      this.iv_condition.setVisibility(8);
    }
    int j = c.getInstance().getMinsuConditionCount();
    if (j > 0)
    {
      this.tv_condition_num.setText("" + j);
      this.tv_condition_num.setVisibility(0);
    }
    if (!TextUtils.isEmpty(c.getInstance().getKeyword())) {
      f(c.getInstance().getKeyword());
    }
    Integer localInteger = c.getInstance().getPersonCount();
    if (localInteger == null) {}
    for (;;)
    {
      b(i);
      if (!TextUtils.isEmpty(c.getInstance().getLocationName())) {
        e(c.getInstance().getLocationName());
      }
      if (!TextUtils.isEmpty(c.getInstance().getSortPositionName())) {
        d(c.getInstance().getSortPositionName());
      }
      a(c.getInstance().getStartTime(), c.getInstance().getEndTime());
      m();
      return;
      i = localInteger.intValue();
    }
  }
  
  private void i()
  {
    this.f = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.f);
    this.e = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  private void j()
  {
    if (TextUtils.isEmpty(c.getInstance().getLocationName())) {
      e("位置");
    }
    for (;;)
    {
      f(c.getInstance().getKeyword());
      setSearchCount(c.getInstance().getMinsuConditionCount());
      h();
      a(true);
      return;
      e(c.getInstance().getLocationName());
    }
  }
  
  private void k()
  {
    this.tv_search_city.setText(c.getInstance().getCityName());
    this.tv_search_city_out.setText(c.getInstance().getCityName());
  }
  
  private Bitmap l()
  {
    return com.ziroom.ziroomcustomer.minsu.f.n.convertViewToBitmap(getWindow().getDecorView());
  }
  
  private void m()
  {
    StringBuilder localStringBuilder;
    if ((this.tv_search_count.getText().length() == 0) && (this.tv_search_city.getText().length() == 0) && (this.tv_search_date.getText().length() == 0))
    {
      this.tv_clear_global_condition.setVisibility(8);
      this.tv_clear_out.setVisibility(8);
      localStringBuilder = new StringBuilder();
      if (this.tv_search_city.getText().length() != 0) {
        break label187;
      }
      localStringBuilder.append("城市");
      label94:
      localStringBuilder.append(" • ");
      if (this.tv_search_date.getText().length() != 0) {
        break label207;
      }
      localStringBuilder.append("日期");
      label125:
      localStringBuilder.append(" • ");
      if (this.tv_search_count.getText().length() != 0) {
        break label227;
      }
      localStringBuilder.append("人数");
    }
    for (;;)
    {
      this.tv_search_condition_combination.setText(localStringBuilder.toString());
      return;
      this.tv_clear_global_condition.setVisibility(0);
      this.tv_clear_out.setVisibility(0);
      break;
      label187:
      localStringBuilder.append(this.tv_search_city.getText().toString());
      break label94;
      label207:
      localStringBuilder.append(this.tv_search_date.getText().toString());
      break label125;
      label227:
      localStringBuilder.append(this.tv_search_count.getText().toString());
    }
  }
  
  private void n()
  {
    if ((this.w == 0) && (!aa.getString(this, MinsuSearchListActivity.class.getSimpleName() + "guide", "").equals("one"))) {
      this.ll_search_container.getViewTreeObserver().addOnGlobalLayoutListener(new MinsuSearchListActivity.2(this));
    }
  }
  
  @OnClick({2131696328, 2131696325, 2131696321, 2131689936, 2131691399, 2131691401, 2131691408, 2131691410, 2131691407, 2131691406, 2131691651, 2131691655, 2131691667, 2131691668, 2131691670, 2131691672, 2131691671, 2131691660, 2131691663, 2131691664, 2131691662, 2131691405, 2131691652})
  public void OnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696328: 
      k.toMinsuHistory(this);
      return;
    case 2131696325: 
      c(2);
      return;
    case 2131696321: 
      c(1);
      return;
    case 2131689936: 
      if (ae.isNull(c.getInstance().getCityCode()))
      {
        k.toMinsuCityListActivityForResult(this);
        return;
      }
      k.toLocationInfo(this);
      return;
    case 2131691399: 
      finish();
      return;
    case 2131691662: 
      b(false);
      return;
    case 2131691401: 
    case 2131691663: 
      com.ziroom.ziroomcustomer.minsu.d.a.getInstance().doBlurInBack(this, l());
      paramView = new Intent(this.c, MinsuHouseListSearchActivity.class);
      paramView.putExtra("key", c.getInstance().getKeyword());
      paramView.putExtra("cityCode", c.getInstance().getCityCode());
      startActivityForResult(paramView, 120);
      return;
    case 2131691410: 
    case 2131691672: 
      k.toMinsuPersonActivityForResult(this, c.getInstance().getPersonCount());
      b(false);
      return;
    case 2131691407: 
    case 2131691670: 
      k.toMinsuCityListActivityForResult(this);
      b(false);
      return;
    case 2131691408: 
    case 2131691671: 
      k.toMinsuTimeSelectActivityForResult(this, this.g, this.r);
      b(false);
      return;
    case 2131691406: 
      c.getInstance().clearGlobalCondition();
      c.getInstance().clearMinsuLocationCondition();
      c.getInstance().clearMinsuSortCondition();
      e("位置");
      d("排序");
      af.showToast(this.c, "清除成功");
      this.r = null;
      this.g = null;
      setDateStart(null);
      setDateEnd(null);
      this.tv_search_count.setText("");
      this.tv_search_count_out.setText("");
      this.tv_search_city.setText("");
      this.tv_search_city_out.setText("");
      this.tv_search_date.setText("");
      this.tv_search_date_out.setText("");
      m();
      a(true);
      return;
    case 2131691651: 
    case 2131691664: 
      f("");
      c.getInstance().setKeyword(null);
      b(false);
      a(true);
      return;
    case 2131691655: 
      b(true);
      return;
    case 2131691405: 
      this.slsv_root.scrollToMaxTop();
      return;
    case 2131691667: 
      b(false);
      return;
    case 2131691668: 
      c.getInstance().clearGlobalCondition();
      c.getInstance().clearMinsuLocationCondition();
      c.getInstance().clearMinsuSortCondition();
      e("位置");
      d("排序");
      af.showToast(this.c, "清除成功");
      this.r = null;
      this.g = null;
      setDateStart(null);
      setDateEnd(null);
      this.tv_search_count.setText("");
      this.tv_search_count_out.setText("");
      this.tv_search_city.setText("");
      this.tv_search_city_out.setText("");
      this.tv_search_date.setText("");
      this.tv_search_date_out.setText("");
      m();
      b(false);
      a(true);
      return;
    case 2131691660: 
      b(false);
      return;
    }
    if (ae.isNull(c.getInstance().getCityCode()))
    {
      k.toMinsuCityListActivityForResult(this, "map");
      return;
    }
    k.toMinsuMap(this);
  }
  
  public void finish()
  {
    super.finish();
    this.r = null;
    this.g = null;
    setDateStart(null);
    setDateEnd(null);
  }
  
  public Calendar getDateEnd()
  {
    return this.r;
  }
  
  public Calendar getDateStart()
  {
    return this.g;
  }
  
  public String getEndDate()
  {
    return this.t;
  }
  
  public String getStartDate()
  {
    return this.s;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
    case 111: 
    case 123: 
    case 120: 
    case 113: 
    case 125: 
    case 134: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt2 != -1) {
                  break;
                }
              } while ((paramIntent != null) && ("map".equals(paramIntent.getStringExtra("from"))));
              c.getInstance().clearMinsuLocationCondition();
              c.getInstance().clearMinsuSortCondition();
              com.ziroom.ziroomcustomer.minsu.b.c.a = c.getInstance().getCityCode();
              k();
              e("位置");
              d("排序");
              a(true);
              m();
              return;
              if (paramInt2 == -1)
              {
                paramInt1 = paramIntent.getIntExtra("index", -1);
                localObject = paramIntent.getStringExtra("text");
                switch (paramInt1)
                {
                }
                for (;;)
                {
                  ((BaseSearchListFragment)this.u.get(0)).reset();
                  ((BaseSearchListFragment)this.u.get(0)).request();
                  return;
                  e((String)localObject);
                  continue;
                  setSearchCount(paramIntent.getIntExtra("confCount", 0));
                  this.tv_condition.setText((CharSequence)localObject);
                  continue;
                  d((String)localObject);
                }
              }
            } while (paramInt2 != 11);
            this.tv_condition.setText("筛选");
            this.tv_condition_num.setVisibility(8);
            this.iv_condition.setVisibility(0);
            c.getInstance().clearMinsuConditionCondition();
            ((BaseSearchListFragment)this.u.get(0)).reset();
            ((BaseSearchListFragment)this.u.get(0)).request();
            return;
          } while (-1 != paramInt2);
          if ("keyWord".equals(paramIntent.getStringExtra("type")))
          {
            paramIntent = paramIntent.getStringExtra("key");
            c.getInstance().setKeyword(paramIntent);
            f(paramIntent + "");
          }
          a(true);
          return;
          if (paramInt2 == -1)
          {
            localObject = paramIntent.getStringExtra("startDate");
            paramIntent = paramIntent.getStringExtra("endDate");
            c.getInstance().setStartTime((String)localObject);
            c.getInstance().setEndTime(paramIntent);
            a((String)localObject, paramIntent);
            a(true);
          }
          m();
          return;
        } while (paramInt2 != -1);
        paramInt1 = paramIntent.getIntExtra("personNum", 0);
        Object localObject = c.getInstance();
        if (paramInt1 <= 0) {}
        for (paramIntent = null;; paramIntent = Integer.valueOf(paramInt1))
        {
          ((c)localObject).setPersonCount(paramIntent);
          b(paramInt1);
          m();
          a(true);
          return;
        }
        if (paramInt2 == -1)
        {
          ((BaseSearchListFragment)this.u.get(0)).reset();
          ((BaseSearchListFragment)this.u.get(0)).request();
          e(c.getInstance().getLocationName());
          return;
        }
      } while (paramInt2 != 11);
      e("位置");
      c.getInstance().clearMinsuLocationCondition();
      ((BaseSearchListFragment)this.u.get(0)).reset();
      ((BaseSearchListFragment)this.u.get(0)).request();
      return;
    case 119: 
      ((BaseSearchListFragment)this.u.get(0)).onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903327);
    this.c = this;
    this.d = ButterKnife.bind(this);
    c.getInstance().setInit(true);
    c.getInstance().addSearchListCount();
    f();
    i();
    g();
    n();
    a();
  }
  
  public void onDestroy()
  {
    this.a.unregister(this.f);
    if (this.d != null) {
      this.d.unbind();
    }
    com.freelxl.baselibrary.d.a.cancel(this);
    if (this.D != null) {
      LocalBroadcastManager.getInstance(this.c).unregisterReceiver(this.D);
    }
    c.getInstance().pop();
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama.getType().getClass();
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onMinsuMapUI(com.ziroom.ziroomcustomer.minsu.mapsojourn.model.a parama)
  {
    j();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.x)
    {
      this.x = false;
      this.vp_fragment_container.setCurrentItem(this.w);
    }
    if ((this.u != null) && (this.vp_fragment_container != null) && (c.getInstance().testRequest())) {
      ((BaseSearchListFragment)this.u.get(this.vp_fragment_container.getCurrentItem())).request();
    }
  }
  
  public void onScrolledDistance(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 1)
    {
      if (paramInt1 > 20)
      {
        e();
        this.C = false;
      }
      while (paramInt1 >= -20) {
        return;
      }
      b();
      this.C = true;
      return;
    }
    b();
    this.C = true;
  }
  
  public void setDateEnd(Calendar paramCalendar)
  {
    this.r = paramCalendar;
  }
  
  public void setDateStart(Calendar paramCalendar)
  {
    this.g = paramCalendar;
  }
  
  public void setEndDate(String paramString)
  {
    this.t = paramString;
  }
  
  public void setListTopBar()
  {
    if (this.b == 0)
    {
      this.tv_info.setText(SearchTab.MINSU.getSuggestMsg());
      this.tv_info.setVisibility(SearchTab.MINSU.getVisibility());
    }
    do
    {
      return;
      if (this.b == 1)
      {
        this.tv_info.setText(SearchTab.STATION.getSuggestMsg());
        this.tv_info.setVisibility(SearchTab.STATION.getVisibility());
        return;
      }
    } while (this.b != 2);
    this.tv_info.setText(SearchTab.STRATEGY.getSuggestMsg());
    this.tv_info.setVisibility(SearchTab.STRATEGY.getVisibility());
  }
  
  public void setSearchCount(int paramInt)
  {
    if (paramInt > 0)
    {
      this.tv_condition_num.setVisibility(0);
      this.tv_condition_num.setText(paramInt + "");
      this.iv_condition.setVisibility(8);
      return;
    }
    this.tv_condition_num.setVisibility(8);
    this.iv_condition.setVisibility(0);
  }
  
  public void setStartDate(String paramString)
  {
    this.s = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/MinsuSearchListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */