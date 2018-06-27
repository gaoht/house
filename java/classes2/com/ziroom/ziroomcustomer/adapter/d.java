package com.ziroom.ziroomcustomer.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.a.a;
import com.ziroom.ziroomcustomer.findhouse.model.HouseItem;
import com.ziroom.ziroomcustomer.findhouse.model.HouseItem.TagsBean;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.view.HouseListItemSearchView;
import com.ziroom.ziroomcustomer.findhouse.view.HouseListItemSearchView.b;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.util.w;
import java.util.List;

public class d
  extends BaseAdapter
{
  private List<HouseItem> a;
  private Context b;
  private List<SelectBean> c;
  private String d;
  private b e;
  private boolean f = false;
  private final int g = 0;
  private final int h = 1;
  private final int i = 2;
  private boolean j = true;
  
  public d(List<HouseItem> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public d(List<HouseItem> paramList, Context paramContext, List<SelectBean> paramList1, String paramString)
  {
    this.a = paramList;
    this.b = paramContext;
    this.c = paramList1;
    this.d = paramString;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
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
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a != null) && (paramInt == 0) && ((((HouseItem)this.a.get(paramInt)).getIs_recommend() == 1) || (((HouseItem)this.a.get(paramInt)).getIs_recommend() == 2))) {
      return 1;
    }
    if ((this.a != null) && (paramInt == this.a.size() - 1) && (((HouseItem)this.a.get(paramInt)).getIs_End() == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.b, 2130904451, null);
        paramViewGroup = new c(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690073));
        paramView.setTag(paramViewGroup);
      }
      while ((this.a != null) && (paramInt == this.a.size() - 1) && (((HouseItem)this.a.get(paramInt)).getIs_End() == 1))
      {
        paramViewGroup.a.setText("房源已加载完毕");
        return paramView;
        paramViewGroup = (c)paramView.getTag();
      }
      if ((this.a != null) && (((HouseItem)this.a.get(paramInt)).getIs_recommend() == 2))
      {
        paramViewGroup.a.setText("未搜索到对应房源");
        return paramView;
      }
      paramViewGroup.a.setText("未搜索到对应房源，以下是推荐房源");
      return paramView;
    }
    final HouseItem localHouseItem;
    label426:
    Object localObject2;
    Object localObject1;
    int k;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904237, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695075));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690970));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695076));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695077));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131690972));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131695078));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131695079));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131695080));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131695081));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131690971));
      paramViewGroup.k = ((TextView)paramView.findViewById(2131695083));
      paramViewGroup.m = paramView.findViewById(2131689774);
      paramViewGroup.l = ((TextView)paramView.findViewById(2131695084));
      paramViewGroup.n = ((HouseListItemSearchView)paramView.findViewById(2131695085));
      c.frescoHierarchyController(paramViewGroup.a, 2130838349);
      paramView.setTag(paramViewGroup);
      localHouseItem = (HouseItem)this.a.get(paramInt);
      if ((!f.notNull(localHouseItem.getWill_unrent_date())) || (1 == localHouseItem.getTurn())) {
        break label990;
      }
      paramViewGroup.d.setVisibility(0);
      localObject2 = localHouseItem.getType_text() + "·" + localHouseItem.getName();
      localObject1 = "¥" + localHouseItem.getPrice() + localHouseItem.getPrice_unit();
      paramViewGroup.f.setText("");
      paramViewGroup.f.setVisibility(4);
      if (localHouseItem.getType() != 8) {
        break label1002;
      }
      localObject2 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject2).setSpan(new com.ziroom.ziroomcustomer.findhouse.widget.b(this.b, localHouseItem.getType_text(), this.b.getResources().getIntArray(2131361818)), 0, localHouseItem.getType_text().length(), 17);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), 0, localHouseItem.getType_text().length(), 17);
      paramViewGroup.c.setText((CharSequence)localObject2);
      localObject2 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject2).setSpan(new com.ziroom.ziroomcustomer.findhouse.widget.b(this.b, (String)localObject1, this.b.getResources().getIntArray(2131361819)), 0, ((String)localObject1).length(), 17);
      if (!TextUtils.isEmpty(localHouseItem.getPrice_unit()))
      {
        k = localHouseItem.getPrice_unit().length();
        ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(13, true), ((String)localObject1).length() - k, ((String)localObject1).length(), 33);
      }
      paramViewGroup.e.setText((CharSequence)localObject2);
      label718:
      if (1 != localHouseItem.getTurn()) {
        break label1085;
      }
      label727:
      paramViewGroup.j.setText(localHouseItem.getSubway_station_info());
      paramViewGroup.k.setText(localHouseItem.getType_text());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localHouseItem.getArea()).append("㎡ | ").append(localHouseItem.getFloor()).append("/").append(localHouseItem.getFloor_total()).append("层");
      paramViewGroup.b.setText(((StringBuilder)localObject1).toString());
      localObject1 = localHouseItem.getTags();
      localObject2 = new TextView[3];
      localObject2[0] = paramViewGroup.g;
      localObject2[1] = paramViewGroup.h;
      localObject2[2] = paramViewGroup.i;
      if (localObject1 == null) {
        break label1167;
      }
      k = 0;
      label862:
      if (k >= 3) {
        break label1167;
      }
      if (k >= ((List)localObject1).size()) {
        break label1132;
      }
      localObject2[k].setVisibility(0);
      localObject2[k].setText(((HouseItem.TagsBean)((List)localObject1).get(k)).getTitle());
      localObject2[k].setPadding(12, 6, 12, 6);
      if (localHouseItem.getType() != 8) {
        break label1097;
      }
      localObject2[k].setBackgroundResource(2130839635);
      localObject2[k].setTextColor(this.b.getResources().getColor(2131624587));
    }
    for (;;)
    {
      k += 1;
      break label862;
      paramViewGroup = (a)paramView.getTag();
      break;
      label990:
      paramViewGroup.d.setVisibility(8);
      break label426;
      label1002:
      paramViewGroup.c.setText((CharSequence)localObject2);
      localObject2 = new SpannableString((CharSequence)localObject1);
      if (!TextUtils.isEmpty(localHouseItem.getPrice_unit()))
      {
        k = localHouseItem.getPrice_unit().length();
        ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(13, true), ((String)localObject1).length() - k, ((String)localObject1).length(), 33);
      }
      paramViewGroup.e.setText((CharSequence)localObject2);
      break label718;
      label1085:
      paramViewGroup.l.setVisibility(8);
      break label727;
      label1097:
      localObject2[k].setBackgroundResource(2130839627);
      localObject2[k].setTextColor(this.b.getResources().getColor(2131624417));
      continue;
      label1132:
      localObject2[k].setVisibility(8);
      localObject2[k].setText("");
      localObject2[k].setPadding(0, 0, 0, 0);
    }
    label1167:
    paramViewGroup.a.setController(c.frescoController(localHouseItem.getPhoto_min()));
    if (this.j)
    {
      paramViewGroup.m.setVisibility(0);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        boolean a = false;
        
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (this.a) {
            return;
          }
          this.a = true;
          a.onClickEvent("searchlist_list", "sld=" + (paramInt + 1), com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode(), "");
          w.onEvent(d.a(d.this), "roomlist_roomdetail");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("id", localHouseItem.getId());
          paramAnonymousView.putExtra("house_id", localHouseItem.getHouse_id());
          paramAnonymousView.putExtra("bannerUrl", localHouseItem.getPhoto_min());
          if (localHouseItem.getType() == 8) {
            paramAnonymousView.putExtra("placeholder_type", 2);
          }
          paramAnonymousView.setClass(d.a(d.this), RentHouseDetailActivity.class);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ActivityOptionsCompat localActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)d.a(d.this), paramViewGroup.a, "sdv_banner");
            ActivityCompat.startActivity(d.a(d.this), paramAnonymousView, localActivityOptionsCompat.toBundle());
          }
          for (;;)
          {
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                d.1.this.a = false;
              }
            }, 600L);
            return;
            d.a(d.this).startActivity(paramAnonymousView);
          }
        }
      });
      if ((paramInt != 9) || (!this.f)) {
        break label1285;
      }
      paramViewGroup.n.setmLabels(this.c);
      paramViewGroup.n.setmSearchTitle(this.d);
      paramViewGroup.n.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.n.setLabelClickListener(new HouseListItemSearchView.b()
      {
        public void onLabelClick(SelectBean paramAnonymousSelectBean)
        {
          if (paramAnonymousSelectBean != null) {
            a.onClickEvent("searchlist_zhu", "nxzn=" + paramAnonymousSelectBean.getTitle(), com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode(), "");
          }
          if (d.b(d.this) != null) {
            d.b(d.this).onLabelClick(paramAnonymousSelectBean);
          }
        }
      });
      return paramView;
      paramViewGroup.m.setVisibility(8);
      break;
      label1285:
      paramViewGroup.n.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setData(List<HouseItem> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public void setIsDividerShow(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setIsOptionsVisible(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setOnLabelClickListener(b paramb)
  {
    this.e = paramb;
  }
  
  public void setmListOptions(List<SelectBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void setmTitleLabel(String paramString)
  {
    this.d = paramString;
    notifyDataSetChanged();
  }
  
  private class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public HouseListItemSearchView n;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onLabelClick(SelectBean paramSelectBean);
  }
  
  private class c
  {
    TextView a;
    
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */