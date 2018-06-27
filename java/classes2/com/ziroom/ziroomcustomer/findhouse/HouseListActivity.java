package com.ziroom.ziroomcustomer.findhouse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.DraweeTransition;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.d.b;
import com.ziroom.ziroomcustomer.b.h;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.b;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.model.HouseItem;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListItem;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListOptions;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListOptions.LiveBean;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListOptions.LiveBean.ChildrenBean;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListOptions.LiveBean.ChildrenBean.TypeBean;
import com.ziroom.ziroomcustomer.findhouse.model.HouselistSuggestBean;
import com.ziroom.ziroomcustomer.findhouse.model.RentSearchHistory;
import com.ziroom.ziroomcustomer.findhouse.model.RentSearchHistoryUtil;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition;
import com.ziroom.ziroomcustomer.findhouse.view.HouseMapSearchActivity;
import com.ziroom.ziroomcustomer.findhouse.widget.HouseList_ConditionalView;
import com.ziroom.ziroomcustomer.findhouse.widget.HouseList_ConditionalView.a;
import com.ziroom.ziroomcustomer.findhouse.widget.a.a;
import com.ziroom.ziroomcustomer.home.bean.MoreBean;
import com.ziroom.ziroomcustomer.home.bean.MoreBean.TypeBean;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.p;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;
import com.ziroom.ziroomcustomer.widget.HouseListXListView.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HouseListActivity
  extends BaseActivity
{
  public static String a = "";
  public static String b = "";
  public static HashSet<Integer> c = new HashSet();
  public static boolean d = false;
  public static boolean e = false;
  private boolean A;
  private final int B = 101;
  private Handler C = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      HouseListActivity.this.mIv_tips_zhuanzu.setVisibility(8);
    }
  };
  private String f;
  private Intent g;
  @BindView(2131690901)
  ImageView iv_collect_tips;
  @BindView(2131690896)
  HouseList_ConditionalView mConditionalView;
  @BindView(2131689940)
  TextView mEditSearch;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690895)
  ImageView mIvMap;
  @BindView(2131690899)
  ImageView mIv_tips_zhuanzu;
  @BindView(2131690897)
  RecyclerView mRvRapid;
  @BindView(2131690900)
  TextView mTv_sort;
  @BindView(2131690898)
  HouseListXListView mXListView;
  private SearchCondition r;
  private int s = 1;
  private int t = 10;
  private boolean u = false;
  private List<HouseItem> v = new ArrayList();
  private com.ziroom.ziroomcustomer.adapter.d w;
  private SelectCondition x;
  private List<SelectBean> y = new ArrayList();
  private List<String> z = Arrays.asList(new String[] { "您想住哪儿", "您想住哪儿", "您跟谁一起住", "您的预算是多少" });
  
  private void a()
  {
    final SharedPreferences localSharedPreferences = getSharedPreferences("rent_house_detail", 0);
    if (localSharedPreferences.getBoolean("flag_house_list_detail_tips", true))
    {
      this.iv_collect_tips.setVisibility(0);
      this.iv_collect_tips.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          HouseListActivity.this.iv_collect_tips.setVisibility(8);
          paramAnonymousView = localSharedPreferences.edit();
          paramAnonymousView.putBoolean("flag_house_list_detail_tips", false);
          paramAnonymousView.apply();
        }
      });
    }
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent = (MoreBean)paramIntent.getSerializableExtra("more");
    Object localObject1;
    if ((paramIntent != null) && (paramIntent.getType() != null) && (paramIntent.getType().size() > 0))
    {
      Object localObject2 = new StringBuilder();
      localObject1 = new HashSet();
      try
      {
        Iterator localIterator = paramIntent.getType().iterator();
        while (localIterator.hasNext())
        {
          MoreBean.TypeBean localTypeBean = (MoreBean.TypeBean)localIterator.next();
          ((StringBuilder)localObject2).append(localTypeBean.getValue()).append("|");
          ((HashSet)localObject1).add(Integer.valueOf(Integer.parseInt(localTypeBean.getType())));
        }
        if (!((HashSet)localObject1).contains(Integer.valueOf(1))) {
          break label346;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        localObject2 = ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1).toString();
        this.r.setType((String)localObject2);
        this.r.setTypeSet((HashSet)localObject1);
        this.r.setVersion("");
        if (((HashSet)localObject1).size() != 1) {
          break label346;
        }
      }
      this.r.setTypeName("合租");
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getLeasetype() != null) && (paramIntent.getLeasetype().size() > 0)) {
        this.r.setLeasetype(((MoreBean.TypeBean)paramIntent.getLeasetype().get(0)).getValue());
      }
      if ((paramIntent != null) && (paramIntent.getTag() != null) && (paramIntent.getTag().size() > 0))
      {
        localObject1 = new StringBuilder();
        try
        {
          paramIntent = paramIntent.getTag().iterator();
          while (paramIntent.hasNext()) {
            ((StringBuilder)localObject1).append(((MoreBean.TypeBean)paramIntent.next()).getValue()).append("|");
          }
          return;
        }
        catch (NumberFormatException paramIntent)
        {
          paramIntent.printStackTrace();
          if (((StringBuilder)localObject1).length() > 1) {
            this.r.setTags(((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1).toString());
          }
        }
      }
      label346:
      if ((((HashSet)localObject1).size() == 1) && ((((HashSet)localObject1).contains(Integer.valueOf(2))) || (((HashSet)localObject1).contains(Integer.valueOf(5))))) {
        this.r.setTypeName("整租");
      } else if ((((HashSet)localObject1).size() == 2) && (((HashSet)localObject1).contains(Integer.valueOf(2))) && (((HashSet)localObject1).contains(Integer.valueOf(5)))) {
        this.r.setTypeName("整租");
      } else {
        this.r.setTypeName("合租/整租");
      }
    }
  }
  
  private void a(HouseListItem paramHouseListItem)
  {
    boolean bool = getPreferences(0).getBoolean("houselist_ad_show_flag", true);
    if ((TextUtils.isEmpty(this.f)) && (bool) && (paramHouseListItem.getOptions() != null) && (!TextUtils.isEmpty(paramHouseListItem.getOptions().getAdv_one())))
    {
      this.f = paramHouseListItem.getOptions().getAdv_one();
      j.getCommonJson(this, this.f, new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, final com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          final Object localObject = paramAnonymouse.getString("switch");
          if ((localObject != null) && ("Y".equals(localObject)) && (paramAnonymouse != null) && (!TextUtils.isEmpty(paramAnonymouse.getString("photo"))))
          {
            localObject = LayoutInflater.from(HouseListActivity.this).inflate(2130904726, HouseListActivity.this.mXListView, false);
            SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)((View)localObject).findViewById(2131691098);
            ImageView localImageView = (ImageView)((View)localObject).findViewById(2131690588);
            localSimpleDraweeView.setController(c.frescoController(paramAnonymouse.getString("photo")));
            if (!TextUtils.isEmpty(paramAnonymouse.getString("link"))) {
              localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  JsBridgeWebActivity.start(HouseListActivity.this, paramAnonymouse.getString("title"), paramAnonymouse.getString("link"));
                }
              });
            }
            localImageView.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                HouseListActivity.this.mXListView.removeHeaderView(localObject);
                paramAnonymous2View = HouseListActivity.this.getPreferences(0).edit();
                paramAnonymous2View.putBoolean("houselist_ad_show_flag", false);
                paramAnonymous2View.apply();
              }
            });
            HouseListActivity.this.mXListView.addHeaderView((View)localObject);
          }
        }
      });
    }
  }
  
  private void a(List<SelectBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mRvRapid.setVisibility(0);
      this.mRvRapid.setLayoutManager(new LinearLayoutManager(this, 0, false));
      this.mRvRapid.setAdapter(new a(paramList));
      return;
    }
    this.mRvRapid.setVisibility(8);
  }
  
  private void b()
  {
    Object localObject = getSharedPreferences("zhuanzu_tips", 0);
    if (((SharedPreferences)localObject).getBoolean("isFirst", true))
    {
      this.mIv_tips_zhuanzu.setVisibility(0);
      this.mIv_tips_zhuanzu.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          HouseListActivity.h(HouseListActivity.this).sendEmptyMessage(101);
        }
      });
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("isFirst", false);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  private void b(HouseListItem paramHouseListItem)
  {
    this.w.setIsOptionsVisible(false);
    if (g()) {}
    while ((c(paramHouseListItem)) || (!d(paramHouseListItem))) {
      return;
    }
  }
  
  private boolean c(HouseListItem paramHouseListItem)
  {
    if ((TextUtils.isEmpty(this.r.getType())) && (TextUtils.isEmpty(this.r.getLive())) && (paramHouseListItem.getOptions() != null) && (paramHouseListItem.getOptions().getLive() != null))
    {
      paramHouseListItem = paramHouseListItem.getOptions().getLive();
      this.w.setmTitleLabel((String)this.z.get(2));
      if (paramHouseListItem.size() >= 1) {}
    }
    else
    {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    label94:
    if (i < paramHouseListItem.size())
    {
      Object localObject = (HouseListOptions.LiveBean)paramHouseListItem.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break label94;
        SelectBean localSelectBean = new SelectBean();
        localSelectBean.setTitle(((HouseListOptions.LiveBean)localObject).getTitle());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((HouseListOptions.LiveBean)localObject).getValue()).append("#");
        if ((((HouseListOptions.LiveBean)localObject).getChildren() == null) || (((HouseListOptions.LiveBean)localObject).getChildren().getType() == null) || (((HouseListOptions.LiveBean)localObject).getChildren().getType().size() < 1)) {
          break;
        }
        localObject = ((HouseListOptions.LiveBean)localObject).getChildren().getType();
        int j = 0;
        HouseListOptions.LiveBean.ChildrenBean.TypeBean localTypeBean;
        if (j < ((List)localObject).size())
        {
          localTypeBean = (HouseListOptions.LiveBean.ChildrenBean.TypeBean)((List)localObject).get(j);
          if (localTypeBean == null) {}
          for (;;)
          {
            j += 1;
            break;
            localStringBuilder.append(localTypeBean.getType()).append("|");
          }
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        localStringBuilder.append("#");
        j = 0;
        if (j < ((List)localObject).size())
        {
          localTypeBean = (HouseListOptions.LiveBean.ChildrenBean.TypeBean)((List)localObject).get(j);
          if (localTypeBean == null) {}
          for (;;)
          {
            j += 1;
            break;
            localStringBuilder.append(localTypeBean.getValue()).append("|");
          }
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        localStringBuilder.append("#");
        if (((List)localObject).size() == 1) {
          localStringBuilder.append(((HouseListOptions.LiveBean.ChildrenBean.TypeBean)((List)localObject).get(0)).getShow());
        }
        localSelectBean.setValue(localStringBuilder.toString());
        localArrayList.add(localSelectBean);
      }
    }
    this.w.setmListOptions(localArrayList);
    this.w.setIsOptionsVisible(true);
    this.w.setOnLabelClickListener(new d.b()
    {
      public void onLabelClick(SelectBean paramAnonymousSelectBean)
      {
        if ((paramAnonymousSelectBean == null) || (paramAnonymousSelectBean.getValue() == null)) {
          return;
        }
        paramAnonymousSelectBean = paramAnonymousSelectBean.getValue().split("#", 4);
        HashSet localHashSet = new HashSet();
        try
        {
          String[] arrayOfString = paramAnonymousSelectBean[1].split("\\|");
          int i;
          if ((arrayOfString != null) && (arrayOfString.length > 1)) {
            i = 0;
          }
          while (i < arrayOfString.length)
          {
            localHashSet.add(Integer.valueOf(Integer.parseInt(arrayOfString[i])));
            i += 1;
            continue;
            HouseListActivity.b = paramAnonymousSelectBean[3];
          }
          HouseListActivity.e(HouseListActivity.this).setTypeSet(localHashSet);
          HouseListActivity.e(HouseListActivity.this).setLive(paramAnonymousSelectBean[0]);
          HouseListActivity.e(HouseListActivity.this).setType(paramAnonymousSelectBean[2]);
          HouseListActivity.e(HouseListActivity.this).setTypeName(paramAnonymousSelectBean[3]);
          HouseListActivity.this.mConditionalView.initState(HouseListActivity.e(HouseListActivity.this));
          HouseListActivity.a = paramAnonymousSelectBean[2];
          HouseListActivity.c = localHashSet;
          HouseListActivity.g(HouseListActivity.this);
          HouseListActivity.this.mXListView.setSelection(0);
          return;
        }
        catch (NumberFormatException paramAnonymousSelectBean)
        {
          paramAnonymousSelectBean.printStackTrace();
        }
      }
    });
    return true;
  }
  
  private boolean d(HouseListItem paramHouseListItem)
  {
    if ((this.r.getMinPrice() == 0) && (this.r.getMaxPrice() == 0) && (paramHouseListItem.getOptions() != null) && (paramHouseListItem.getOptions().getPrice() != null) && (paramHouseListItem.getOptions().getPrice().size() > 0))
    {
      this.y = paramHouseListItem.getOptions().getPrice();
      com.freelxl.baselibrary.f.d.d("listPrice", this.y);
      this.w.setmTitleLabel((String)this.z.get(3));
      this.w.setmListOptions(this.y);
      this.w.setIsOptionsVisible(true);
      this.w.setOnLabelClickListener(new d.b()
      {
        public void onLabelClick(SelectBean paramAnonymousSelectBean)
        {
          int j = 0;
          try
          {
            Object localObject = paramAnonymousSelectBean.getValue().split(",", 2);
            paramAnonymousSelectBean = localObject[0];
            localObject = localObject[1];
            int i;
            if ("".equals(paramAnonymousSelectBean))
            {
              i = 0;
              if (!"".equals(localObject)) {
                break label107;
              }
            }
            for (;;)
            {
              HouseListActivity.e(HouseListActivity.this).setMinPrice(i);
              HouseListActivity.e(HouseListActivity.this).setMaxPrice(j);
              HouseListActivity.g(HouseListActivity.this);
              HouseListActivity.this.mXListView.setSelection(0);
              HouseListActivity.this.mConditionalView.setTimeText("");
              return;
              i = Integer.parseInt(paramAnonymousSelectBean);
              break;
              label107:
              j = Integer.parseInt((String)localObject);
            }
            return;
          }
          catch (Exception paramAnonymousSelectBean) {}
        }
      });
      return true;
    }
    return false;
  }
  
  private void e()
  {
    this.v.clear();
    this.s = 1;
    this.u = false;
    f();
    if (this.x == null) {
      i();
    }
  }
  
  private void f()
  {
    Object localObject;
    if ((this.mConditionalView != null) && (this.mConditionalView.getHouseTypeSet() != null) && (this.mConditionalView.getHouseTypeSet().size() > 0))
    {
      localObject = new StringBuffer();
      if (this.mConditionalView.getHouseTypeSet().contains(Integer.valueOf(1))) {
        ((StringBuffer)localObject).append(",友家列表");
      }
      if (this.mConditionalView.getHouseTypeSet().contains(Integer.valueOf(2))) {
        ((StringBuffer)localObject).append(",整租列表");
      }
      if (this.mConditionalView.getHouseTypeSet().contains(Integer.valueOf(5))) {
        ((StringBuffer)localObject).append(",直租列表");
      }
      if (((StringBuffer)localObject).length() > 1) {
        GrowingIO.getInstance().setPS4(this, ((StringBuffer)localObject).substring(1));
      }
    }
    for (;;)
    {
      localObject = q.b + e.b.U + "?" + ah.encodeGetParams(com.ziroom.ziroomcustomer.e.g.buildHouseList(this.r, this.s, this.t));
      com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_tiaojian", (String)localObject, d(), "");
      com.freelxl.baselibrary.d.a.get((String)localObject).tag(this).addHeader("Accept", "application/json;version=6").enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(this, new com.ziroom.ziroomcustomer.findhouse.b.e(HouseListItem.class))
      {
        public void onSuccess(int paramAnonymousInt, HouseListItem paramAnonymousHouseListItem)
        {
          if (HouseListActivity.e(HouseListActivity.this) != null) {
            super.onSuccess(paramAnonymousInt, paramAnonymousHouseListItem);
          }
          if (paramAnonymousHouseListItem == null) {
            return;
          }
          HouseListActivity.a(HouseListActivity.this, paramAnonymousHouseListItem);
          List localList = paramAnonymousHouseListItem.getRooms();
          com.freelxl.baselibrary.f.d.d("findHouse", localList.toString());
          if ((HouseListActivity.i(HouseListActivity.this) == 1) && ((localList == null) || (localList.size() < 1)))
          {
            HouseListActivity.a(HouseListActivity.this, true);
            HouseListActivity.b(HouseListActivity.this);
            return;
          }
          if ((HouseListActivity.i(HouseListActivity.this) == 1) && (HouseListActivity.d(HouseListActivity.this) != null)) {
            HouseListActivity.d(HouseListActivity.this).clear();
          }
          if ((localList == null) || (localList.size() < HouseListActivity.j(HouseListActivity.this)))
          {
            HouseListActivity.d(HouseListActivity.this).addAll(localList);
            paramAnonymousHouseListItem = new HouseItem();
            paramAnonymousHouseListItem.setIs_End(1);
            HouseListActivity.d(HouseListActivity.this).add(paramAnonymousHouseListItem);
            HouseListActivity.k(HouseListActivity.this).notifyDataSetChanged();
            HouseListActivity.this.mXListView.setPullLoadEnable(false);
            return;
          }
          HouseListActivity.this.mXListView.setPullLoadEnable(true);
          HouseListActivity.d(HouseListActivity.this).addAll(localList);
          if ((HouseListActivity.i(HouseListActivity.this) == 1) && (localList.size() == HouseListActivity.j(HouseListActivity.this))) {
            HouseListActivity.b(HouseListActivity.this, paramAnonymousHouseListItem);
          }
          HouseListActivity.k(HouseListActivity.this).notifyDataSetChanged();
          HouseListActivity.l(HouseListActivity.this);
        }
      });
      return;
      GrowingIO.getInstance().setPS4(this, "友家列表,整租列表,直租列表");
      continue;
      GrowingIO.getInstance().setPS4(this, "友家列表,整租列表,直租列表");
    }
  }
  
  private boolean g()
  {
    if ((!TextUtils.isEmpty(this.r.getKeywords())) || (!TextUtils.isEmpty(this.r.getSuggestion_value())) || (!TextUtils.isEmpty(this.r.getSuggestion_type())) || (!TextUtils.isEmpty(this.r.getSubway())) || (!TextUtils.isEmpty(this.r.getSubway_line())) || (!TextUtils.isEmpty(this.r.getDistrict())) || (!TextUtils.isEmpty(this.r.getDistrictName())) || (!TextUtils.isEmpty(this.r.getBizcircle_name())) || (!TextUtils.isEmpty(this.r.getBizcircle_code())) || ((!TextUtils.isEmpty(this.r.getClng())) && (d)) || ((!TextUtils.isEmpty(this.r.getClat())) && (d))) {
      return false;
    }
    this.w.setIsOptionsVisible(true);
    this.w.setmTitleLabel((String)this.z.get(0));
    int j = com.ziroom.ziroomcustomer.b.g.getBizCount(this);
    int i = h.getResblockCount(this);
    ArrayList localArrayList;
    Object localObject;
    if ((i < 4) || (i + j < 8))
    {
      localArrayList = new ArrayList();
      localObject = new SelectBean();
      ((SelectBean)localObject).setTitle("按商圈找");
      ((SelectBean)localObject).setValue("1");
      localArrayList.add(localObject);
      localObject = new SelectBean();
      ((SelectBean)localObject).setTitle("按地铁找");
      ((SelectBean)localObject).setValue("2");
      localArrayList.add(localObject);
      this.w.setmListOptions(localArrayList);
      this.w.setOnLabelClickListener(new d.b()
      {
        public void onLabelClick(SelectBean paramAnonymousSelectBean)
        {
          if ("按商圈找".equals(paramAnonymousSelectBean.getTitle()))
          {
            HouseListActivity.this.mConditionalView.showArea(1);
            return;
          }
          HouseListActivity.this.mConditionalView.showArea(2);
        }
      });
    }
    for (;;)
    {
      return true;
      i = j;
      if (j > 4) {
        i = 4;
      }
      localArrayList = new ArrayList();
      localArrayList.addAll(com.ziroom.ziroomcustomer.b.g.queryBizcircle(this, i));
      localArrayList.addAll(h.queryResblock(this, 8 - i));
      localObject = new ArrayList();
      i = 0;
      while (i < localArrayList.size())
      {
        SelectBean localSelectBean = new SelectBean();
        HouselistSuggestBean localHouselistSuggestBean = (HouselistSuggestBean)localArrayList.get(i);
        localSelectBean.setTitle(localHouselistSuggestBean.getName());
        localSelectBean.setValue(localHouselistSuggestBean.getId());
        ((List)localObject).add(localSelectBean);
        i += 1;
      }
      this.w.setmListOptions((List)localObject);
      this.w.setOnLabelClickListener(new d.b()
      {
        public void onLabelClick(SelectBean paramAnonymousSelectBean)
        {
          Intent localIntent = new Intent(HouseListActivity.this, HouseListActivity.class);
          localIntent.putExtra("etSearch", paramAnonymousSelectBean.getTitle());
          HouseListActivity.this.mXListView.setSelection(0);
          HouseListActivity.this.onNewIntent(localIntent);
        }
      });
    }
  }
  
  private void h()
  {
    String str = q.b + e.b.V + "?" + ah.encodeGetParams(com.ziroom.ziroomcustomer.e.g.buildHouseList(this.r, this.s, this.t));
    com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_tiaojian", str, d(), "");
    com.freelxl.baselibrary.d.a.get(str).tag(this).addHeader("Accept", "application/json;version=6").enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(this, new com.ziroom.ziroomcustomer.findhouse.b.d(HouseItem.class))
    {
      public void onSuccess(int paramAnonymousInt, List paramAnonymousList)
      {
        if (HouseListActivity.e(HouseListActivity.this) != null) {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
        }
        if (paramAnonymousList == null) {
          return;
        }
        com.freelxl.baselibrary.f.d.d("findHouse", paramAnonymousList.toString());
        HouseItem localHouseItem;
        if (HouseListActivity.i(HouseListActivity.this) == 1)
        {
          HouseListActivity.d(HouseListActivity.this).clear();
          localHouseItem = new HouseItem();
          if (paramAnonymousList.size() != 0) {
            break label156;
          }
          localHouseItem.setIs_recommend(2);
        }
        for (;;)
        {
          HouseListActivity.d(HouseListActivity.this).add(localHouseItem);
          if ((paramAnonymousList == null) || (paramAnonymousList.size() >= HouseListActivity.j(HouseListActivity.this))) {
            break;
          }
          HouseListActivity.d(HouseListActivity.this).addAll(paramAnonymousList);
          new HouseItem().setIs_End(1);
          HouseListActivity.k(HouseListActivity.this).notifyDataSetChanged();
          HouseListActivity.this.mXListView.setPullLoadEnable(false);
          return;
          label156:
          localHouseItem.setIs_recommend(1);
        }
        HouseListActivity.this.mXListView.setPullLoadEnable(true);
        HouseListActivity.d(HouseListActivity.this).addAll(paramAnonymousList);
        HouseListActivity.k(HouseListActivity.this).notifyDataSetChanged();
        HouseListActivity.l(HouseListActivity.this);
      }
    });
  }
  
  private void i()
  {
    HashMap localHashMap = new HashMap();
    com.freelxl.baselibrary.d.a.get(q.b + e.b.Y + "?" + ah.encodeGetParams(com.ziroom.ziroomcustomer.e.g.getHouseListFilter(localHashMap, ""))).tag(this).addHeader("Accept", "application/json;version=6").enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(this, new com.ziroom.ziroomcustomer.findhouse.b.e(SelectCondition.class))
    {
      public void onSuccess(int paramAnonymousInt, SelectCondition paramAnonymousSelectCondition)
      {
        if ((HouseListActivity.d(HouseListActivity.this) != null) && (HouseListActivity.d(HouseListActivity.this).size() > 0)) {
          super.onSuccess(paramAnonymousInt, paramAnonymousSelectCondition);
        }
        HouseListActivity.a(HouseListActivity.this, paramAnonymousSelectCondition);
        com.freelxl.baselibrary.f.d.d("findHouse", HouseListActivity.m(HouseListActivity.this));
        HouseListActivity.this.mConditionalView.setSelection(HouseListActivity.m(HouseListActivity.this));
        HouseListActivity.a(HouseListActivity.this, HouseListActivity.m(HouseListActivity.this).getRapid());
      }
    });
  }
  
  private void j()
  {
    if (this.x == null)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "服务器异常，正在努力抢修中，请稍后再试!");
      return;
    }
    com.ziroom.ziroomcustomer.findhouse.widget.a locala = new com.ziroom.ziroomcustomer.findhouse.widget.a(this);
    Window localWindow = locala.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    locala.show(this.x.getSort(), this.r);
    locala.setDataListener(new a.a()
    {
      public void getData(SearchCondition paramAnonymousSearchCondition)
      {
        if (paramAnonymousSearchCondition == null) {
          return;
        }
        HouseListActivity.a(HouseListActivity.this, paramAnonymousSearchCondition);
        HouseListActivity.d(HouseListActivity.this).clear();
        HouseListActivity.a(HouseListActivity.this, 1);
        HouseListActivity.a(HouseListActivity.this, false);
        HouseListActivity.c(HouseListActivity.this);
        HouseListActivity.this.mXListView.setSelection(0);
      }
    });
  }
  
  private void k()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        RentSearchHistoryUtil.saveHistory(new RentSearchHistory(HouseListActivity.e(HouseListActivity.this)));
      }
    }).start();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {
      return;
    }
    Object localObject = (SearchCondition)paramIntent.getSerializableExtra("searchCondition");
    if (localObject == null)
    {
      onNewIntent(paramIntent);
      return;
    }
    this.r = ((SearchCondition)localObject);
    this.mConditionalView.initState(this.r);
    if (this.x != null) {
      a(this.x.getRapid());
    }
    localObject = this.r.getKeywords();
    paramIntent = (Intent)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramIntent = (Intent)localObject;
      if (!TextUtils.isEmpty(this.r.getSuggestion_value())) {
        paramIntent = this.r.getAreaText();
      }
    }
    this.mEditSearch.setText(paramIntent);
    this.mConditionalView.dismissAllPop();
    e();
    k();
  }
  
  @OnClick({2131689492, 2131690895, 2131690900, 2131689940})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131689940: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_top_search", "", d(), "");
      this.g = new Intent(this, SearchHouseActivity.class);
      this.g.putExtra("isHotSearchShow", true);
      this.g.putExtra("etSearch", this.mEditSearch.getText().toString());
      startActivityForResult(this.g, 0);
      return;
    case 2131690895: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_top_map", "", d(), "");
      this.g = new Intent(this, HouseMapSearchActivity.class);
      if ((this.v != null) && (this.v.size() > 0)) {
        if ((this.u) && (this.v.size() > 1))
        {
          this.r.setClat(((HouseItem)this.v.get(1)).getLat() + "");
          this.r.setClng(((HouseItem)this.v.get(1)).getLng() + "");
        }
      }
      for (;;)
      {
        this.g.putExtra("search_condition", this.r);
        this.g.putExtra("select_condition", this.x);
        this.g.putExtra("isFromHouseList", true);
        startActivityForResult(this.g, 0);
        return;
        if (this.u)
        {
          this.r.setClat(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLat() + "");
          this.r.setClng(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLng() + "");
        }
        else
        {
          this.r.setClat(((HouseItem)this.v.get(0)).getLat() + "");
          this.r.setClng(((HouseItem)this.v.get(0)).getLng() + "");
          continue;
          this.r.setClat(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLat() + "");
          this.r.setClng(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLng() + "");
        }
      }
    }
    com.ziroom.ziroomcustomer.a.a.onClickEvent("searchlist_paixu", "", d(), "");
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903206);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setSharedElementExitTransition(DraweeTransition.createTransitionSet(ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP));
      getWindow().setSharedElementReenterTransition(null);
    }
    ButterKnife.bind(this);
    e = true;
    p.showGuide(this, "house_map_list_01", 2130904683, new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        p.showGuide(HouseListActivity.this, "house_map_list_02", 2130904684, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            p.showGuide(HouseListActivity.this, "house_map_list_03", 2130904685, null, null);
          }
        }, null);
      }
    }, null);
    paramBundle = GrowingIO.getInstance();
    paramBundle.setPageGroup(this, "YZList");
    paramBundle.setPS3(this, com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
    this.r = ((SearchCondition)getIntent().getSerializableExtra("searchCondition"));
    this.A = getIntent().getBooleanExtra("isSpecified", false);
    if (this.r == null) {
      this.r = new SearchCondition();
    }
    if (!TextUtils.isEmpty(a))
    {
      this.r.setClat("");
      this.r.setClng("");
    }
    d = false;
    if (!this.A)
    {
      this.r.setType(a);
      this.r.setTypeName(b);
      this.r.setTypeSet(c);
    }
    a(getIntent());
    paramBundle = getIntent().getStringExtra("etSearch");
    this.r.setKeywords(paramBundle);
    this.mEditSearch.setText(paramBundle);
    this.mConditionalView.initState(this.r);
    if (this.x != null) {
      a(this.x.getRapid());
    }
    w.onEventToZiroomAndUmeng("5houselist_load");
    this.mXListView.setPullRefreshEnable(false);
    this.w = new com.ziroom.ziroomcustomer.adapter.d(this.v, this, this.y, (String)this.z.get(0));
    this.mXListView.setAdapter(this.w);
    this.mXListView.setPullLoadEnable(false);
    this.mXListView.setXListViewListener(new HouseListXListView.a()
    {
      public void onLoadMore()
      {
        if (HouseListActivity.a(HouseListActivity.this))
        {
          HouseListActivity.b(HouseListActivity.this);
          return;
        }
        HouseListActivity.c(HouseListActivity.this);
      }
      
      public void onRefresh() {}
    });
    b();
    a();
    this.mConditionalView.setDataListener(new HouseList_ConditionalView.a()
    {
      public void getData(SearchCondition paramAnonymousSearchCondition)
      {
        if (paramAnonymousSearchCondition == null) {
          return;
        }
        HouseListActivity.a(HouseListActivity.this, paramAnonymousSearchCondition);
        HouseListActivity.d(HouseListActivity.this).clear();
        HouseListActivity.a(HouseListActivity.this, 1);
        HouseListActivity.a(HouseListActivity.this, false);
        HouseListActivity.c(HouseListActivity.this);
        HouseListActivity.this.mXListView.setSelection(0);
        if ((!TextUtils.isEmpty(HouseListActivity.e(HouseListActivity.this).getDistrict())) || (!TextUtils.isEmpty(HouseListActivity.e(HouseListActivity.this).getBizcircle_code()))) {
          HouseListActivity.this.mEditSearch.setText("");
        }
        HouseListActivity.f(HouseListActivity.this);
      }
    });
    this.mIvBack.post(new Runnable()
    {
      public void run()
      {
        HouseListActivity.g(HouseListActivity.this);
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e = false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.mConditionalView.isPopShowing()))
    {
      this.mConditionalView.dismissAllPop();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    Object localObject = (SearchCondition)paramIntent.getSerializableExtra("searchCondition");
    if (localObject != null)
    {
      this.r = ((SearchCondition)localObject);
      if (!TextUtils.isEmpty(a))
      {
        this.r.setClat("");
        this.r.setClng("");
      }
      d = false;
      this.r.setType(a);
      this.r.setTypeName(b);
      this.r.setTypeSet(c);
      a(paramIntent);
      this.mConditionalView.initState(this.r);
      this.mConditionalView.dismissAllPop();
      e();
      return;
    }
    localObject = paramIntent.getStringExtra("etSearch");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.r.setDistrict("");
      this.r.setBizcircle_code("");
      this.r.setSubway("");
      this.r.setSubway_line("");
      this.r.setClat("");
      this.r.setClng("");
      this.r.setSuggestion_type("");
      this.r.setSuggestion_value("");
      this.r.setKeywords((String)localObject);
      this.mEditSearch.setText((CharSequence)localObject);
      this.mConditionalView.initState(this.r);
      k();
    }
    String str = paramIntent.getStringExtra("suggestion_value");
    paramIntent = paramIntent.getStringExtra("suggestion_type");
    if (!TextUtils.isEmpty(str))
    {
      this.r.setDistrict("");
      this.r.setBizcircle_code("");
      this.r.setSubway("");
      this.r.setSubway_line("");
      this.r.setClat("");
      this.r.setClng("");
      this.r.setKeywords("");
      this.r.setAreaText((String)localObject);
      this.r.setSuggestion_type(paramIntent);
      this.r.setSuggestion_value(str);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label552;
      }
      this.mEditSearch.setText(str);
    }
    for (;;)
    {
      this.mConditionalView.initState(this.r);
      if ((this.r.getType() != null) && (!this.r.getType().equals(a)))
      {
        this.r.setRface("");
        this.r.setHface("");
        this.r.setFace("");
        this.r.setBedroom(new SelectBean());
        this.r.setFeature("");
        this.r.setVersion("");
        this.r.setStyle("");
        this.r.setArea("");
      }
      this.r.setType(a);
      this.r.setTypeName(b);
      this.r.setTypeSet(c);
      this.mConditionalView.initState(this.r);
      if (this.x != null) {
        a(this.x.getRapid());
      }
      this.mConditionalView.dismissAllPop();
      e();
      return;
      label552:
      this.mEditSearch.setText((CharSequence)localObject);
    }
  }
  
  private class a
    extends RecyclerView.a<HouseListActivity.b>
  {
    private List<SelectBean> b;
    
    a()
    {
      List localList;
      this.b = localList;
    }
    
    private SelectBean a(SelectBean paramSelectBean)
    {
      if ((paramSelectBean != null) && (HouseListActivity.e(HouseListActivity.this) != null) && (HouseListActivity.e(HouseListActivity.this).getRapidBeanList() != null))
      {
        Iterator localIterator = HouseListActivity.e(HouseListActivity.this).getRapidBeanList().iterator();
        while (localIterator.hasNext())
        {
          SelectBean localSelectBean = (SelectBean)localIterator.next();
          if ((localSelectBean.getValue() != null) && (localSelectBean.getValue().equals(paramSelectBean.getValue()))) {
            return localSelectBean;
          }
        }
      }
      return null;
    }
    
    private String a(List<SelectBean> paramList)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder("");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localStringBuilder.append(((SelectBean)paramList.next()).getValue());
          localStringBuilder.append("|");
        }
        if (localStringBuilder.length() > 0) {
          return localStringBuilder.substring(0, localStringBuilder.length() - 1);
        }
      }
      return "";
    }
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public void onBindViewHolder(HouseListActivity.b paramb, int paramInt)
    {
      boolean bool = true;
      final SelectBean localSelectBean1 = (SelectBean)this.b.get(paramInt);
      paramb.a.setText(localSelectBean1.getTitle());
      SelectBean localSelectBean2 = a(localSelectBean1);
      label83:
      CheckBox localCheckBox;
      if (localSelectBean1.getHot() == 1)
      {
        paramb.a.setBackground(ContextCompat.getDrawable(HouseListActivity.this, 2130837769));
        if (localSelectBean2 == null) {
          break label137;
        }
        paramb.a.setTextColor(ContextCompat.getColor(HouseListActivity.this, 2131624583));
        localCheckBox = paramb.a;
        if (localSelectBean2 == null) {
          break label184;
        }
      }
      for (;;)
      {
        localCheckBox.setChecked(bool);
        paramb.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            List localList;
            Object localObject;
            if (HouseListActivity.e(HouseListActivity.this) != null)
            {
              localList = HouseListActivity.e(HouseListActivity.this).getRapidBeanList();
              if (!paramAnonymousBoolean) {
                break label225;
              }
              if (localList != null) {
                break label190;
              }
              localObject = new ArrayList();
              ((List)localObject).add(localSelectBean1);
              HouseListActivity.e(HouseListActivity.this).setRapidBeanList((List)localObject);
              HouseListActivity.e(HouseListActivity.this).setRapid(HouseListActivity.a.a(HouseListActivity.a.this, (List)localObject));
              paramAnonymousCompoundButton.setTextColor(ContextCompat.getColor(HouseListActivity.this, 2131624583));
            }
            for (;;)
            {
              if ((!HouseListActivity.d) && (HouseListActivity.e(HouseListActivity.this) != null))
              {
                HouseListActivity.e(HouseListActivity.this).setClng("");
                HouseListActivity.e(HouseListActivity.this).setClat("");
              }
              HouseListActivity.g(HouseListActivity.this);
              HouseListActivity.f(HouseListActivity.this);
              HouseListActivity.a.this.notifyDataSetChanged();
              return;
              label190:
              localObject = localList;
              if (HouseListActivity.a.a(HouseListActivity.a.this, localSelectBean1) != null) {
                break;
              }
              localList.add(localSelectBean1);
              localObject = localList;
              break;
              label225:
              localObject = HouseListActivity.a.a(HouseListActivity.a.this, localSelectBean1);
              if (localList != null)
              {
                localList.remove(localObject);
                HouseListActivity.e(HouseListActivity.this).setRapid(HouseListActivity.a.a(HouseListActivity.a.this, localList));
              }
              for (;;)
              {
                if (localSelectBean1.getHot() != 1) {
                  break label321;
                }
                paramAnonymousCompoundButton.setTextColor(ContextCompat.getColor(HouseListActivity.this, 2131624390));
                break;
                HouseListActivity.e(HouseListActivity.this).setRapid("");
              }
              label321:
              paramAnonymousCompoundButton.setTextColor(ContextCompat.getColor(HouseListActivity.this, 2131624516));
            }
          }
        });
        return;
        paramb.a.setBackground(ContextCompat.getDrawable(HouseListActivity.this, 2130837768));
        break;
        label137:
        if (localSelectBean1.getHot() == 1)
        {
          paramb.a.setTextColor(ContextCompat.getColor(HouseListActivity.this, 2131624516));
          break label83;
        }
        paramb.a.setTextColor(ContextCompat.getColor(HouseListActivity.this, 2131624391));
        break label83;
        label184:
        bool = false;
      }
    }
    
    public HouseListActivity.b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new HouseListActivity.b(HouseListActivity.this, LayoutInflater.from(HouseListActivity.this).inflate(2130904232, paramViewGroup, false));
    }
  }
  
  private class b
    extends RecyclerView.u
  {
    CheckBox a;
    
    public b(View paramView)
    {
      super();
      this.a = ((CheckBox)paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/HouseListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */