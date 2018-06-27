package com.ziroom.ziroomcustomer.rent.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.a.a;
import com.ziroom.ziroomcustomer.findhouse.model.HouseItem;
import com.ziroom.ziroomcustomer.findhouse.model.HouseItem.TagsBean;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListOptions;
import com.ziroom.ziroomcustomer.findhouse.view.AutoNextViewGroup;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.Arrays;
import java.util.List;

public class b
  extends RecyclerView.a<RecyclerView.u>
{
  private final int a = 0;
  private final int b = 1;
  private int[] c;
  private int[] d;
  private int e;
  private int f;
  private Context g;
  private LayoutInflater h;
  private boolean i;
  private List<HouseItem> j;
  private HouseListOptions k;
  private List<String> l = Arrays.asList(new String[] { "您想住哪儿", "您跟谁一起住", "您的预算是多少" });
  
  public b(Context paramContext, List<HouseItem> paramList, HouseListOptions paramHouseListOptions)
  {
    this.g = paramContext;
    this.j = paramList;
    this.k = paramHouseListOptions;
    a();
  }
  
  private void a()
  {
    this.h = LayoutInflater.from(this.g);
    this.c = this.g.getResources().getIntArray(2131361818);
    this.d = this.g.getResources().getIntArray(2131361819);
    this.e = this.g.getResources().getColor(2131624587);
    this.f = this.g.getResources().getColor(2131624417);
  }
  
  private void a(final int paramInt, final HouseItem paramHouseItem, final a parama)
  {
    Object localObject2;
    Object localObject1;
    label241:
    label249:
    int m;
    if ((f.notNull(paramHouseItem.getWill_unrent_date())) && (1 != paramHouseItem.getTurn()))
    {
      parama.e.setVisibility(0);
      localObject2 = paramHouseItem.getType_text() + "·" + paramHouseItem.getName();
      localObject1 = "¥" + paramHouseItem.getPrice() + paramHouseItem.getPrice_unit();
      parama.g.setText("");
      parama.g.setVisibility(4);
      if (paramHouseItem.getType() != 8) {
        break label493;
      }
      localObject2 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject2).setSpan(new com.ziroom.ziroomcustomer.findhouse.widget.b(this.g, paramHouseItem.getType_text(), this.c), 0, paramHouseItem.getType_text().length(), 17);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), 0, paramHouseItem.getType_text().length(), 17);
      parama.d.setText((CharSequence)localObject2);
      localObject2 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject2).setSpan(new com.ziroom.ziroomcustomer.findhouse.widget.b(this.g, (String)localObject1, this.d), 0, ((String)localObject1).length(), 17);
      parama.f.setText((CharSequence)localObject2);
      if (1 != paramHouseItem.getTurn()) {
        break label514;
      }
      parama.k.setText(paramHouseItem.getSubway_station_info());
      parama.l.setText(paramHouseItem.getType_text());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramHouseItem.getArea()).append("㎡ | ").append(paramHouseItem.getFloor()).append("/").append(paramHouseItem.getFloor_total()).append("层");
      parama.c.setText(((StringBuilder)localObject1).toString());
      localObject1 = paramHouseItem.getTags();
      localObject2 = new TextView[3];
      localObject2[0] = parama.h;
      localObject2[1] = parama.i;
      localObject2[2] = parama.j;
      if (localObject1 == null) {
        break label587;
      }
      m = 0;
      label375:
      if (m >= 3) {
        break label587;
      }
      if (m >= ((List)localObject1).size()) {
        break label552;
      }
      localObject2[m].setVisibility(0);
      localObject2[m].setText(((HouseItem.TagsBean)((List)localObject1).get(m)).getTitle());
      localObject2[m].setPadding(12, 6, 12, 6);
      if (paramHouseItem.getType() != 8) {
        break label526;
      }
      localObject2[m].setBackgroundResource(2130839635);
      localObject2[m].setTextColor(this.e);
    }
    for (;;)
    {
      m += 1;
      break label375;
      parama.e.setVisibility(8);
      break;
      label493:
      parama.d.setText((CharSequence)localObject2);
      parama.f.setText((CharSequence)localObject1);
      break label241;
      label514:
      parama.m.setVisibility(8);
      break label249;
      label526:
      localObject2[m].setBackgroundResource(2130839627);
      localObject2[m].setTextColor(this.f);
      continue;
      label552:
      localObject2[m].setVisibility(8);
      localObject2[m].setText("");
      localObject2[m].setPadding(0, 0, 0, 0);
    }
    label587:
    parama.b.setController(c.frescoController(paramHouseItem.getPhoto_min()));
    parama.a.setOnClickListener(new View.OnClickListener()
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
        w.onEvent(b.a(b.this), "roomlist_roomdetail");
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("id", paramHouseItem.getId());
        paramAnonymousView.putExtra("house_id", paramHouseItem.getHouse_id());
        paramAnonymousView.putExtra("bannerUrl", paramHouseItem.getPhoto_min());
        if (paramHouseItem.getType() == 8) {
          paramAnonymousView.putExtra("placeholder_type", 2);
        }
        paramAnonymousView.setClass(b.a(b.this), RentHouseDetailActivity.class);
        if (Build.VERSION.SDK_INT >= 21)
        {
          ActivityOptionsCompat localActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)b.a(b.this), parama.b, "sdv_banner");
          ActivityCompat.startActivity(b.a(b.this), paramAnonymousView, localActivityOptionsCompat.toBundle());
        }
        for (;;)
        {
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              b.1.this.a = false;
            }
          }, 600L);
          return;
          b.a(b.this).startActivity(paramAnonymousView);
        }
      }
    });
  }
  
  private void b() {}
  
  public void addHouseItems(List<HouseItem> paramList)
  {
    if (paramList != null)
    {
      if (this.j == null) {
        break label27;
      }
      this.j.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label27:
      this.j = paramList;
    }
  }
  
  public int getItemCount()
  {
    if (this.j != null) {}
    for (int m = this.j.size() + 0;; m = 0)
    {
      if ((this.k != null) && (this.j != null) && (this.j.size() > 8)) {
        m += 1;
      }
      for (this.i = true;; this.i = false)
      {
        u.d("RentHouseListAdapter", "====getItemCount：" + m);
        return m;
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.k != null) && (paramInt == 9)) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    u.d("RentHouseListAdapter", "====onBindViewHolder：" + paramInt);
    if ((paramu instanceof a)) {
      if (this.i) {
        if (paramInt > 9)
        {
          m = paramInt - 1;
          a(paramInt, (HouseItem)this.j.get(m), (a)paramu);
        }
      }
    }
    while (!(paramu instanceof b)) {
      for (;;)
      {
        return;
        int m = paramInt;
        continue;
        m = paramInt;
      }
    }
    b();
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new a(this.h.inflate(2130904466, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new b(this.h.inflate(2130904468, paramViewGroup, false));
    }
    return null;
  }
  
  public void setData(List<HouseItem> paramList, HouseListOptions paramHouseListOptions)
  {
    this.j = paramList;
    this.k = paramHouseListOptions;
    notifyDataSetChanged();
  }
  
  public void setHouseOption(HouseListOptions paramHouseListOptions)
  {
    this.k = paramHouseListOptions;
    notifyDataSetChanged();
  }
  
  private class a
    extends RecyclerView.u
  {
    public View a;
    public SimpleDraweeView b;
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
    public TextView m;
    public View n;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((SimpleDraweeView)paramView.findViewById(2131695075));
      this.d = ((TextView)paramView.findViewById(2131690970));
      this.e = ((TextView)paramView.findViewById(2131695076));
      this.c = ((TextView)paramView.findViewById(2131695077));
      this.f = ((TextView)paramView.findViewById(2131690972));
      this.g = ((TextView)paramView.findViewById(2131695078));
      this.h = ((TextView)paramView.findViewById(2131695079));
      this.i = ((TextView)paramView.findViewById(2131695080));
      this.j = ((TextView)paramView.findViewById(2131695081));
      this.k = ((TextView)paramView.findViewById(2131690971));
      this.l = ((TextView)paramView.findViewById(2131695083));
      this.n = paramView.findViewById(2131689774);
      this.m = ((TextView)paramView.findViewById(2131695084));
      c.frescoHierarchyController(this.b, 2130838349);
    }
  }
  
  private class b
    extends RecyclerView.u
  {
    public TextView a;
    public AutoNextViewGroup b;
    
    public b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131689541));
      this.b = ((AutoNextViewGroup)paramView.findViewById(2131695577));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/rent/list/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */