package com.ziroom.ziroomcustomer.findhouse;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.f.g;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.b.d;
import com.ziroom.ziroomcustomer.findhouse.model.RentSearchHistory;
import com.ziroom.ziroomcustomer.findhouse.model.RentSearchHistoryUtil;
import com.ziroom.ziroomcustomer.findhouse.model.SearchSuggestion;
import com.ziroom.ziroomcustomer.findhouse.model.SearchSuggestion.Item;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.view.HouseMapSearchActivity;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SearchHouseActivity
  extends BaseActivity
{
  private String a;
  private int b;
  private boolean c = false;
  private boolean d;
  private Context e;
  @BindView(2131690906)
  EditText etSearch;
  private com.ziroom.ziroomcustomer.findhouse.a.e f;
  @BindView(2131692265)
  FlexboxLayout flexHotSearch;
  private LayoutInflater g;
  @BindView(2131692259)
  ImageView ivSearchRemove;
  @BindView(2131690323)
  LinearLayout llHistory;
  @BindView(2131692262)
  ListViewForScrollView lvHistory;
  @BindView(2131692269)
  ListView lvSuggestion;
  @BindView(2131692267)
  ListViewForScrollView lvfsvNearby;
  private List<SearchCondition> r = new ArrayList();
  private Handler s = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      SearchHouseActivity.c(SearchHouseActivity.this);
    }
  };
  @BindView(2131689709)
  ScrollView scrollView;
  @BindView(2131690169)
  TextView tvCancel;
  @BindView(2131692260)
  TextView tvHistory;
  @BindView(2131692261)
  TextView tvHistoryClear;
  @BindView(2131692264)
  TextView tvHotSearch;
  @BindView(2131692266)
  TextView tvNearby;
  @BindView(2131692268)
  View vDividerNearby;
  @BindView(2131692263)
  View vHistoryDivider;
  
  private LinearLayout a(SearchCondition paramSearchCondition)
  {
    if (paramSearchCondition == null) {
      return null;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    int i = ah.dip2px(this.e, 20.0F);
    localLinearLayout.setPadding(0, i, 0, i);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(this.e);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(this.e.getResources().getColor(2131624416));
    Object localObject2 = paramSearchCondition.getAreaText();
    Object localObject1;
    if (!TextUtils.isEmpty(paramSearchCondition.getKeywords()))
    {
      localObject1 = paramSearchCondition.getKeywords();
      localTextView.setText((CharSequence)localObject1);
      localLinearLayout.addView(localTextView);
      localObject1 = new TextView(this.e);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).topMargin = ah.dip2px(this.e, 6.0F);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setTextColor(this.e.getResources().getColor(2131624417));
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      localObject2 = new StringBuilder();
      if ((paramSearchCondition.getTypeSet() != null) && (paramSearchCondition.getTypeSet().size() > 0)) {
        ((StringBuilder)localObject2).append(a.getHouseTypeText(paramSearchCondition.getTypeSet())).append(" · ");
      }
      a((StringBuilder)localObject2, paramSearchCondition.getRapidBeanList());
      if ((paramSearchCondition.getMinPrice() != 0) || (paramSearchCondition.getMaxPrice() != 0)) {
        break label447;
      }
    }
    for (;;)
    {
      a((StringBuilder)localObject2, paramSearchCondition.getFaceBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.getrFaceBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.gethFaceBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.getAreaBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.getFeatureBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.getAroundBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.getLeaseTypeBeanList());
      a((StringBuilder)localObject2, paramSearchCondition.getTagsBeanList());
      if (((StringBuilder)localObject2).indexOf(" · ") != -1) {
        ((StringBuilder)localObject2).delete(((StringBuilder)localObject2).length() - 3, ((StringBuilder)localObject2).length() - 1);
      }
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      localLinearLayout.addView((View)localObject1);
      return localLinearLayout;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"商圈".equals(localObject2)))
      {
        localObject1 = localObject2;
        if (!"地铁".equals(localObject2)) {
          break;
        }
      }
      localObject1 = "全城";
      break;
      label447:
      if ((paramSearchCondition.getMinPrice() == 0) || (paramSearchCondition.getMaxPrice() != 0)) {
        ((StringBuilder)localObject2).append(paramSearchCondition.getMaxPrice()).append("元以下 · ");
      } else if ((paramSearchCondition.getMinPrice() != 0) || (paramSearchCondition.getMaxPrice() == 0)) {
        ((StringBuilder)localObject2).append(paramSearchCondition.getMinPrice()).append("元以上 · ");
      } else {
        ((StringBuilder)localObject2).append(paramSearchCondition.getMinPrice()).append("-").append(paramSearchCondition.getMaxPrice()).append(" · ");
      }
    }
  }
  
  private TextView a(Context paramContext, String paramString)
  {
    Object localObject = getResources().getDisplayMetrics();
    float f1 = ((DisplayMetrics)localObject).density;
    int i = (int)((((DisplayMetrics)localObject).widthPixels - 30.0F * f1) / 2.0F);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextSize(2, 14.0F);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColor(2131624415));
    ((TextView)localObject).setGravity(17);
    paramContext = new FlexboxLayout.LayoutParams(-2, -2);
    paramContext.b = 0.0F;
    int j = (int)(f1 * 10.0F);
    paramContext.h = i;
    paramContext.bottomMargin = j;
    paramContext.rightMargin = j;
    ((TextView)localObject).setLayoutParams(paramContext);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setBackgroundResource(2130837998);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setPadding(j, j, j, j);
    ((TextView)localObject).setTag(paramString);
    return (TextView)localObject;
  }
  
  private void a()
  {
    this.g = LayoutInflater.from(this);
    if (this.b == 0) {
      this.d = true;
    }
    for (;;)
    {
      i();
      h();
      return;
      if (this.b == 1)
      {
        this.etSearch.setHint("请输入您的公司、写字楼、学校");
        this.d = false;
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ("houseMap".equals(this.a)) {
      paramIntent.setClass(this.e, HouseMapSearchActivity.class);
    }
    for (;;)
    {
      setResult(-1, paramIntent);
      return;
      paramIntent.setClass(this.e, HouseListActivity.class);
    }
  }
  
  private void a(StringBuilder paramStringBuilder, List<SelectBean> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SelectBean localSelectBean = (SelectBean)paramList.next();
        if (localSelectBean != null) {
          paramStringBuilder.append(localSelectBean.getTitle()).append(" · ");
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.tvHotSearch.setVisibility(0);
      this.flexHotSearch.setVisibility(0);
      return;
    }
    this.tvHotSearch.setVisibility(8);
    this.flexHotSearch.setVisibility(8);
  }
  
  private void b()
  {
    if (!ah.checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    if (this.d) {
      e();
    }
    a(this.d);
    f();
    k();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.scrollView.setVisibility(8);
      this.tvHistoryClear.setVisibility(8);
      this.lvSuggestion.setVisibility(0);
      return;
    }
    this.scrollView.setVisibility(0);
    this.tvHistoryClear.setVisibility(0);
    this.lvSuggestion.setVisibility(8);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.llHistory.setVisibility(0);
      this.tvHistory.setVisibility(0);
      this.lvHistory.setVisibility(0);
      this.tvHistoryClear.setVisibility(0);
      this.vHistoryDivider.setVisibility(0);
      return;
    }
    this.llHistory.setVisibility(8);
    this.tvHistory.setVisibility(8);
    this.lvHistory.setVisibility(8);
    this.tvHistoryClear.setVisibility(8);
    this.vHistoryDivider.setVisibility(8);
  }
  
  private void e()
  {
    j.getHotSearch(this, new com.ziroom.ziroomcustomer.findhouse.b.b(this.e, new d(String.class))
    {
      public void onSuccess(int paramAnonymousInt, List paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList == null) || (paramAnonymousList.size() < 1)) {
          SearchHouseActivity.a(SearchHouseActivity.this, false);
        }
        for (;;)
        {
          return;
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousList.size())
          {
            final String str = (String)paramAnonymousList.get(paramAnonymousInt);
            TextView localTextView = SearchHouseActivity.a(SearchHouseActivity.this, SearchHouseActivity.this, str);
            localTextView.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                paramAnonymous2View = new Intent();
                paramAnonymous2View.putExtra("etSearch", str);
                SearchHouseActivity.a(SearchHouseActivity.this, paramAnonymous2View);
                com.ziroom.ziroomcustomer.b.q.save(SearchHouseActivity.this, str, str, 1, -1, null, null, null, com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
                SearchHouseActivity.this.finish();
              }
            });
            SearchHouseActivity.this.flexHotSearch.addView(localTextView);
            paramAnonymousInt += 1;
          }
        }
      }
    });
  }
  
  private void f()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject = RentSearchHistoryUtil.getList();
        if ((localObject == null) || (((List)localObject).size() < 1)) {}
        do
        {
          return;
          Collections.sort((List)localObject);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            RentSearchHistory localRentSearchHistory = (RentSearchHistory)((Iterator)localObject).next();
            if (localRentSearchHistory != null) {
              SearchHouseActivity.a(SearchHouseActivity.this).add(localRentSearchHistory.getSearchCondition());
            }
          }
        } while ((SearchHouseActivity.a(SearchHouseActivity.this) == null) || (SearchHouseActivity.a(SearchHouseActivity.this).size() < 1));
        SearchHouseActivity.b(SearchHouseActivity.this).sendEmptyMessage(0);
      }
    }).start();
  }
  
  private void g()
  {
    if ((this.r == null) || (this.r.size() < 1))
    {
      c(false);
      return;
    }
    c(true);
    a locala = new a(this.r);
    this.lvHistory.setAdapter(locala);
  }
  
  private void h()
  {
    this.etSearch.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)SearchHouseActivity.this.getSystemService("input_method");
        localInputMethodManager.showSoftInput(SearchHouseActivity.this.etSearch, 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 300L);
  }
  
  private void i()
  {
    this.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 3)
        {
          if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(SearchHouseActivity.this.etSearch).toString().trim())) {
            return false;
          }
          ((InputMethodManager)SearchHouseActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(SearchHouseActivity.this.etSearch.getWindowToken(), 0);
          paramAnonymousTextView = VdsAgent.trackEditTextSilent(SearchHouseActivity.this.etSearch).toString().trim();
          paramAnonymousKeyEvent = new Intent();
          paramAnonymousKeyEvent.putExtra("etSearch", paramAnonymousTextView);
          SearchHouseActivity.a(SearchHouseActivity.this, paramAnonymousKeyEvent);
          com.ziroom.ziroomcustomer.b.q.save(SearchHouseActivity.this, paramAnonymousTextView, paramAnonymousTextView, 1, -1, "", "", "", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
          SearchHouseActivity.this.finish();
          return true;
        }
        return false;
      }
    });
    this.etSearch.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        SearchHouseActivity.d(SearchHouseActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          ((InputMethodManager)SearchHouseActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(SearchHouseActivity.this.etSearch.getWindowToken(), 0);
        }
      }
    });
  }
  
  private void j()
  {
    String str = VdsAgent.trackEditTextSilent(this.etSearch).toString().trim();
    if (TextUtils.isEmpty(str))
    {
      b(false);
      return;
    }
    j.getSuggestion(this, str, 10, new com.ziroom.ziroomcustomer.e.a.e(this, new com.ziroom.ziroomcustomer.e.c.q(SearchSuggestion.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        SearchHouseActivity.b(SearchHouseActivity.this, false);
      }
      
      public void onSuccess(int paramAnonymousInt, final SearchSuggestion paramAnonymousSearchSuggestion)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousSearchSuggestion);
        if ((paramAnonymousSearchSuggestion == null) || (paramAnonymousSearchSuggestion.getItems() == null) || (paramAnonymousSearchSuggestion.getItems().size() < 1) || (TextUtils.isEmpty(paramAnonymousSearchSuggestion.getQuery())) || (!paramAnonymousSearchSuggestion.getQuery().equals(VdsAgent.trackEditTextSilent(SearchHouseActivity.this.etSearch).toString())))
        {
          SearchHouseActivity.b(SearchHouseActivity.this, false);
          return;
        }
        SearchHouseActivity.b(SearchHouseActivity.this, true);
        SearchHouseActivity.c(SearchHouseActivity.this, true);
        SearchHouseActivity.a(SearchHouseActivity.this, new com.ziroom.ziroomcustomer.findhouse.a.e(this.e, paramAnonymousSearchSuggestion));
        SearchHouseActivity.this.lvSuggestion.setAdapter(SearchHouseActivity.e(SearchHouseActivity.this));
        paramAnonymousSearchSuggestion = paramAnonymousSearchSuggestion.getItems();
        SearchHouseActivity.this.lvSuggestion.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
          {
            VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
            paramAnonymous2AdapterView = (SearchSuggestion.Item)paramAnonymousSearchSuggestion.get(paramAnonymous2Int);
            paramAnonymous2View = new Intent();
            paramAnonymous2View.putExtra("suggestion_type", paramAnonymous2AdapterView.getFlag() + "");
            paramAnonymous2View.putExtra("suggestion_value", paramAnonymous2AdapterView.getValue());
            paramAnonymous2View.putExtra("etSearch", paramAnonymous2AdapterView.getName());
            SearchHouseActivity.a(SearchHouseActivity.this, paramAnonymous2View);
            com.ziroom.ziroomcustomer.b.q.save(SearchHouseActivity.this, paramAnonymous2AdapterView.getName(), paramAnonymous2AdapterView.getValue(), 2, paramAnonymous2AdapterView.getFlag(), paramAnonymous2AdapterView.getIcon(), paramAnonymous2AdapterView.getMemo(), paramAnonymous2AdapterView.getHousenum(), com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
            SearchHouseActivity.this.finish();
          }
        });
      }
    });
  }
  
  private void k()
  {
    Object localObject = ApplicationEx.c.getLocation();
    if ((localObject != null) && ((((BDLocation)localObject).getLocType() == 65) || (((BDLocation)localObject).getLocType() == 61) || (((BDLocation)localObject).getLocType() == 161) || (((BDLocation)localObject).getLocType() == 66) || (((BDLocation)localObject).getLocType() == 68))) {}
    for (localObject = ((BDLocation)localObject).getLongitude() + "," + ((BDLocation)localObject).getLatitude();; localObject = "0,0")
    {
      j.getSuggestion(this, (String)localObject, 10, new com.ziroom.ziroomcustomer.e.a.e(this, new o())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          SearchHouseActivity.this.tvNearby.setVisibility(8);
          SearchHouseActivity.this.lvfsvNearby.setVisibility(8);
          SearchHouseActivity.this.vDividerNearby.setVisibility(8);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("items")))
          {
            com.alibaba.fastjson.b localb = paramAnonymouse.getJSONArray("items");
            if ((localb != null) && (localb.size() > 0))
            {
              if (paramAnonymouse.containsKey("title")) {
                SearchHouseActivity.this.tvNearby.setText(paramAnonymouse.getString("title"));
              }
              SearchHouseActivity.this.lvfsvNearby.setAdapter(new SearchHouseActivity.b(SearchHouseActivity.this, localb));
              return;
            }
          }
          SearchHouseActivity.this.tvNearby.setVisibility(8);
          SearchHouseActivity.this.lvfsvNearby.setVisibility(8);
          SearchHouseActivity.this.vDividerNearby.setVisibility(8);
        }
      });
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903467);
    ButterKnife.bind(this);
    this.e = this;
    this.a = getIntent().getStringExtra("pageFlag");
    this.b = getIntent().getIntExtra("type", 0);
    a();
    b();
  }
  
  @OnClick({2131692259, 2131690169, 2131692261})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692259: 
      this.etSearch.setText("");
      return;
    case 2131690169: 
      finish();
      return;
    }
    RentSearchHistoryUtil.clearHistory();
    c(false);
  }
  
  private class a
    extends BaseAdapter
  {
    List<SearchCondition> a;
    
    public a()
    {
      List localList;
      this.a = localList;
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      paramView = (SearchCondition)this.a.get(paramInt);
      paramViewGroup = SearchHouseActivity.a(SearchHouseActivity.this, paramView);
      if (paramViewGroup == null) {
        return new View(SearchHouseActivity.g(SearchHouseActivity.this));
      }
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("searchCondition", paramView);
          SearchHouseActivity.a(SearchHouseActivity.this, paramAnonymousView);
          SearchHouseActivity.this.finish();
        }
      });
      return paramViewGroup;
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private com.alibaba.fastjson.b b;
    
    b(com.alibaba.fastjson.b paramb)
    {
      this.b = paramb;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = SearchHouseActivity.f(SearchHouseActivity.this).inflate(2130904487, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690073));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        final com.alibaba.fastjson.e locale = (com.alibaba.fastjson.e)getItem(paramInt);
        if (locale != null)
        {
          paramViewGroup.a.setText(locale.getString("name"));
          paramViewGroup.b.setText(locale.getString("memo"));
        }
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("suggestion_type", locale.getInteger("flag") + "");
            paramAnonymousView.putExtra("suggestion_value", locale.getString("value"));
            paramAnonymousView.putExtra("etSearch", locale.getString("name"));
            SearchHouseActivity.a(SearchHouseActivity.this, paramAnonymousView);
            com.ziroom.ziroomcustomer.b.q.save(SearchHouseActivity.this, locale.getString("name"), locale.getString("value"), 2, locale.getInteger("flag").intValue(), locale.getString("icon"), locale.getString("memo"), locale.getString("housenum"), com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
            SearchHouseActivity.this.finish();
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      TextView a;
      TextView b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/SearchHouseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */