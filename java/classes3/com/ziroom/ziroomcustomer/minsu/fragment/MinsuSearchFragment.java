package com.ziroom.ziroomcustomer.minsu.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.a.a;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCityListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseListBadActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSearchTimesSelectingActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHistoryBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHouseInfoBean;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.f.z;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MinsuSearchFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private String a = "";
  private Calendar b;
  private Calendar c;
  private View d;
  private TextView e;
  private View f;
  private View g;
  private LinearLayout h;
  private ListViewForScrollView i;
  private List<MinsuSearchHistoryBean> j;
  private a k;
  private TextView l;
  private TextView m;
  private Calendar n = null;
  private Calendar o = null;
  
  private String a(Calendar paramCalendar)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(paramCalendar.getTime());
  }
  
  private void a(int paramInt)
  {
    v.onClick(getContext(), "M-People_number_choice");
    Object localObject2 = Integer.valueOf(Integer.parseInt(this.e.getText().toString()));
    Object localObject1 = localObject2;
    if (paramInt == 1)
    {
      this.g.setEnabled(true);
      localObject2 = Integer.valueOf(((Integer)localObject2).intValue() + 1);
      localObject1 = localObject2;
      if (((Integer)localObject2).intValue() >= 10)
      {
        localObject1 = Integer.valueOf(10);
        this.f.setEnabled(false);
      }
    }
    localObject2 = localObject1;
    if (paramInt == -1)
    {
      this.f.setEnabled(true);
      localObject1 = Integer.valueOf(((Integer)localObject1).intValue() - 1);
      localObject2 = localObject1;
      if (((Integer)localObject1).intValue() <= 1)
      {
        localObject2 = Integer.valueOf(1);
        this.g.setEnabled(false);
      }
    }
    this.e.setText(localObject2 + "");
  }
  
  private void a(View paramView)
  {
    initTitle(paramView);
    e(paramView);
    c(paramView);
    d(paramView);
    f(paramView);
    g(paramView);
    b(paramView);
  }
  
  private void a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if (paramCalendar1 != null)
    {
      paramCalendar1 = m.getFormatDate(paramCalendar1.getTime(), m.h);
      TextView localTextView = (TextView)this.d.findViewById(2131691212);
      localTextView.setTextColor(Color.parseColor("#666666"));
      localTextView.setText(paramCalendar1);
    }
    while (paramCalendar2 != null)
    {
      paramCalendar1 = m.getFormatDate(paramCalendar2.getTime(), m.h);
      paramCalendar2 = (TextView)this.d.findViewById(2131691214);
      paramCalendar2.setTextColor(Color.parseColor("#666666"));
      paramCalendar2.setText(paramCalendar1);
      return;
      paramCalendar1 = (TextView)this.d.findViewById(2131691212);
      paramCalendar1.setTextColor(Color.parseColor("#999999"));
      paramCalendar1.setText("日期选择");
    }
    paramCalendar1 = (TextView)this.d.findViewById(2131691214);
    paramCalendar1.setTextColor(Color.parseColor("#999999"));
    paramCalendar1.setText("日期选择");
  }
  
  private Calendar b(String paramString)
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
  
  private void b(int paramInt)
  {
    this.b = Calendar.getInstance();
    this.c = Calendar.getInstance();
    this.b.set(5, 1);
    this.b.add(2, 7);
    Intent localIntent = new Intent(getActivity(), MinsuSearchTimesSelectingActivity.class);
    localIntent.putExtra("lastDate", this.c);
    localIntent.putExtra("nextDate", this.b);
    if (this.n == null)
    {
      str = "";
      localIntent.putExtra("startDate", str);
      if (this.o != null) {
        break label130;
      }
    }
    label130:
    for (String str = "";; str = m.getFormatDate(this.o.getTime(), m.b))
    {
      localIntent.putExtra("endDate", str);
      startActivityForResult(localIntent, 113);
      return;
      str = m.getFormatDate(this.n.getTime(), m.b);
      break;
    }
  }
  
  private void b(View paramView)
  {
    this.h = ((LinearLayout)paramView.findViewById(2131691649));
    this.i = ((ListViewForScrollView)paramView.findViewById(2131694355));
  }
  
  private void c()
  {
    this.j = z.getSearchHistory(getActivity());
    if ((this.j != null) && (!this.j.isEmpty()))
    {
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      this.h.setVisibility(0);
      if (this.k == null)
      {
        this.k = new a(getActivity(), this.j, 2130904345)
        {
          public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, MinsuSearchHistoryBean paramAnonymousMinsuSearchHistoryBean)
          {
            paramAnonymousb.setText(2131690049, paramAnonymousMinsuSearchHistoryBean.cityName);
            String str;
            if (ae.isNull(paramAnonymousMinsuSearchHistoryBean.startDate))
            {
              str = "";
              if (!ae.isNull(paramAnonymousMinsuSearchHistoryBean.endDate)) {
                break label102;
              }
            }
            label102:
            for (paramAnonymousMinsuSearchHistoryBean = "";; paramAnonymousMinsuSearchHistoryBean = m.getFormatDate(m.strToDate(paramAnonymousMinsuSearchHistoryBean.endDate, m.b), m.l))
            {
              if ((!ae.notNull(str)) && (!ae.notNull(paramAnonymousMinsuSearchHistoryBean))) {
                break label122;
              }
              paramAnonymousb.setText(2131693265, str + "--" + paramAnonymousMinsuSearchHistoryBean);
              return;
              str = m.getFormatDate(m.strToDate(paramAnonymousMinsuSearchHistoryBean.startDate, m.b), m.l);
              break;
            }
            label122:
            paramAnonymousb.setText(2131693265, "");
          }
        };
        this.i.setAdapter(this.k);
        this.i.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (ae.notNull(((MinsuSearchHistoryBean)MinsuSearchFragment.a(MinsuSearchFragment.this).get(paramAnonymousInt)).startDate))
            {
              paramAnonymousAdapterView = Calendar.getInstance();
              paramAnonymousAdapterView.setTime(m.strToDate(((MinsuSearchHistoryBean)MinsuSearchFragment.a(MinsuSearchFragment.this).get(paramAnonymousInt)).startDate, m.b));
              MinsuSearchFragment.a(MinsuSearchFragment.this, paramAnonymousAdapterView);
              if (!ae.notNull(((MinsuSearchHistoryBean)MinsuSearchFragment.a(MinsuSearchFragment.this).get(paramAnonymousInt)).endDate)) {
                break label260;
              }
              paramAnonymousAdapterView = Calendar.getInstance();
              paramAnonymousAdapterView.setTime(m.strToDate(((MinsuSearchHistoryBean)MinsuSearchFragment.a(MinsuSearchFragment.this).get(paramAnonymousInt)).endDate, m.b));
              MinsuSearchFragment.b(MinsuSearchFragment.this, paramAnonymousAdapterView);
            }
            for (;;)
            {
              MinsuSearchFragment.a(MinsuSearchFragment.this, MinsuSearchFragment.b(MinsuSearchFragment.this), MinsuSearchFragment.c(MinsuSearchFragment.this));
              MinsuSearchFragment.a(MinsuSearchFragment.this, ((MinsuSearchHistoryBean)MinsuSearchFragment.a(MinsuSearchFragment.this).get(paramAnonymousInt)).cityCode);
              ((TextView)MinsuSearchFragment.d(MinsuSearchFragment.this).findViewById(2131690748)).setText(((MinsuSearchHistoryBean)MinsuSearchFragment.a(MinsuSearchFragment.this).get(paramAnonymousInt)).cityName);
              MinsuSearchFragment.e(MinsuSearchFragment.this);
              v.onClick(MinsuSearchFragment.this.getActivity(), "M-Search_searchcookie");
              return;
              MinsuSearchFragment.a(MinsuSearchFragment.this, null);
              break;
              label260:
              MinsuSearchFragment.b(MinsuSearchFragment.this, null);
            }
          }
        });
      }
      this.k.setDatas(this.j);
      if ((this.j == null) || (this.j.isEmpty()))
      {
        this.k.notifyDataSetInvalidated();
        return;
      }
      this.k.notifyDataSetChanged();
      return;
    }
    this.l.setVisibility(0);
    this.m.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private void c(View paramView)
  {
    paramView.findViewById(2131694351).setOnClickListener(this);
  }
  
  private void d()
  {
    MinsuSearchHouseInfoBean localMinsuSearchHouseInfoBean = new MinsuSearchHouseInfoBean();
    if (ae.isNull(this.a))
    {
      showToast("城市不能为空");
      return;
    }
    localMinsuSearchHouseInfoBean.setCityCode(this.a);
    if (this.d.findViewById(2131694352).getVisibility() == 0)
    {
      localObject = Integer.valueOf(Integer.parseInt(this.e.getText().toString()));
      if ((((Integer)localObject).intValue() >= 1) && (((Integer)localObject).intValue() <= 10)) {
        localMinsuSearchHouseInfoBean.setPersonCount((Integer)localObject);
      }
    }
    if (this.o != null) {
      localMinsuSearchHouseInfoBean.setEndTime(a(this.o));
    }
    if (this.n != null) {
      localMinsuSearchHouseInfoBean.setStartTime(a(this.n));
    }
    MinsuSearchHistoryBean localMinsuSearchHistoryBean = new MinsuSearchHistoryBean();
    localMinsuSearchHistoryBean.cityCode = this.a;
    localMinsuSearchHistoryBean.cityName = com.ziroom.ziroomcustomer.minsu.d.b.getIntance(getActivity()).getName(this.a);
    localMinsuSearchHistoryBean.city_latitude = com.ziroom.ziroomcustomer.minsu.d.b.getIntance(getActivity()).getCityBean(this.a).latitude;
    localMinsuSearchHistoryBean.city_longitude = com.ziroom.ziroomcustomer.minsu.d.b.getIntance(getActivity()).getCityBean(this.a).longitude;
    if (this.n == null)
    {
      localObject = "";
      localMinsuSearchHistoryBean.startDate = ((String)localObject);
      if (this.o != null) {
        break label288;
      }
    }
    label288:
    for (Object localObject = "";; localObject = a(this.o))
    {
      localMinsuSearchHistoryBean.endDate = ((String)localObject);
      z.putSearchHistory(getActivity(), localMinsuSearchHistoryBean);
      localObject = new Intent(getActivity(), MinsuHouseListBadActivity.class);
      ((Intent)localObject).putExtra("search", localMinsuSearchHouseInfoBean);
      getActivity().startActivity((Intent)localObject);
      return;
      localObject = a(this.n);
      break;
    }
  }
  
  private void d(View paramView)
  {
    paramView.findViewById(2131691211).setOnClickListener(this);
    paramView.findViewById(2131691213).setOnClickListener(this);
  }
  
  private void e(View paramView)
  {
    this.l = ((TextView)paramView.findViewById(2131694356));
    this.l.setOnClickListener(this);
    this.m = ((TextView)paramView.findViewById(2131694357));
    this.m.setOnClickListener(this);
  }
  
  private void f(View paramView) {}
  
  private void g(View paramView)
  {
    this.g = paramView.findViewById(2131691634);
    this.g.setOnClickListener(this);
    this.f = paramView.findViewById(2131689574);
    this.f.setOnClickListener(this);
    this.g.setEnabled(false);
    this.e = ((TextView)paramView.findViewById(2131694354));
  }
  
  public static MinsuSearchFragment newInstance()
  {
    MinsuSearchFragment localMinsuSearchFragment = new MinsuSearchFragment();
    localMinsuSearchFragment.setArguments(new Bundle());
    return localMinsuSearchFragment;
  }
  
  public void initData() {}
  
  public void initTitle(View paramView)
  {
    paramView = (CommonTitle)paramView.findViewById(2131691272);
    paramView.setMiddleText(getString(2131297415));
    paramView.showRightText(false, null);
    paramView.setLeftButtonType(0);
    paramView.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSearchFragment.this.getActivity().finish();
      }
    });
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    initData();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    while (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    case 112: 
    default: 
      return;
    case 111: 
      paramIntent = (MinsuSearchHouseInfoBean)paramIntent.getSerializableExtra("search");
      this.a = paramIntent.getCityCode();
      com.ziroom.ziroomcustomer.minsu.b.c.a = this.a;
      ((TextView)this.d.findViewById(2131690748)).setText(paramIntent.getCityName());
      return;
    }
    String str2 = paramIntent.getStringExtra("startDate");
    String str1 = paramIntent.getStringExtra("endDate");
    if (ae.isNull(str2))
    {
      paramIntent = null;
      this.n = paramIntent;
      if (!ae.isNull(str1)) {
        break label166;
      }
    }
    label166:
    for (paramIntent = (Intent)localObject;; paramIntent = b(str1))
    {
      this.o = paramIntent;
      a(this.n, this.o);
      return;
      paramIntent = b(str2);
      break;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131694351: 
      startActivityForResult(new Intent(getActivity(), MinsuCityListActivity.class), 111);
      return;
    case 2131691211: 
      b(0);
      return;
    case 2131691213: 
      b(1);
      return;
    case 2131694356: 
    case 2131694357: 
      d();
      return;
    case 2131691634: 
      a(-1);
      return;
    }
    a(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = paramLayoutInflater.inflate(2130903982, paramViewGroup, false);
    return this.d;
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
    if (paramBoolean) {
      c();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/fragment/MinsuSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */