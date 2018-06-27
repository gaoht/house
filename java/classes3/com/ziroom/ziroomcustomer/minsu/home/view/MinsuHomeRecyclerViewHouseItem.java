package com.ziroom.ziroomcustomer.minsu.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LabelTips;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.c.a.a;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.TodaySecialView;
import com.ziroom.ziroomcustomer.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinsuHomeRecyclerViewHouseItem
  extends RelativeLayout
{
  RecyclerView.l a = new RecyclerView.l()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
    }
    
    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
      paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
      paramAnonymousInt2 = paramAnonymousRecyclerView.getChildCount();
      int i = paramAnonymousRecyclerView.getItemCount();
      int j = paramAnonymousRecyclerView.findFirstVisibleItemPosition();
      paramAnonymousRecyclerView = new ArrayList();
      paramAnonymousInt1 = 0;
      while (paramAnonymousInt1 < paramAnonymousInt2)
      {
        if (j + paramAnonymousInt1 < i) {
          paramAnonymousRecyclerView.add(String.valueOf(j + paramAnonymousInt1));
        }
        paramAnonymousInt1 += 1;
      }
      MinsuHomeRecyclerViewHouseItem.e(MinsuHomeRecyclerViewHouseItem.this).setCurrrents(paramAnonymousRecyclerView);
    }
  };
  private Context b;
  private TextView c;
  private TextView d;
  private TextView e;
  private View f;
  private RelativeLayout g;
  private RecyclerView h;
  private int i = 1;
  private a j;
  private HomeCListCtrlView.b k;
  private com.ziroom.ziroomcustomer.minsu.c.c l;
  private List<MinsuHouseBean.DataBean.ListBean> m;
  
  public MinsuHomeRecyclerViewHouseItem(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerViewHouseItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerViewHouseItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private long a(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    return this.l.getTsDeadlineRemainTime(paramListBean);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2130903941, this);
    this.c = ((TextView)((View)localObject).findViewById(2131689533));
    this.f = ((View)localObject).findViewById(2131689578);
    ((View)localObject).findViewById(2131694175).setVisibility(8);
    this.d = ((TextView)((View)localObject).findViewById(2131691564));
    this.e = ((TextView)((View)localObject).findViewById(2131691258));
    this.g = ((RelativeLayout)((View)localObject).findViewById(2131695049));
    this.h = ((RecyclerView)((View)localObject).findViewById(2131694160));
    localObject = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.h.setLayoutManager((RecyclerView.h)localObject);
    this.b = paramContext;
  }
  
  private long b(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    return this.l.getTsRemainTime(paramListBean);
  }
  
  public void setData(List<MinsuHouseBean.DataBean.ListBean> paramList, int paramInt)
  {
    this.i = paramInt;
    this.m = paramList;
    if (this.j == null)
    {
      this.j = new a();
      this.h.setAdapter(this.j);
    }
    for (;;)
    {
      this.h.addOnScrollListener(this.a);
      this.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuHomeRecyclerViewHouseItem.a(MinsuHomeRecyclerViewHouseItem.this) != null) {
            MinsuHomeRecyclerViewHouseItem.a(MinsuHomeRecyclerViewHouseItem.this).onClick();
          }
        }
      });
      return;
      this.j.notifyDataSetChanged();
    }
  }
  
  public void setOnClickListener(HomeCListCtrlView.b paramb)
  {
    this.k = paramb;
  }
  
  public void setTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString.length >= 2)
    {
      this.d.setVisibility(0);
      this.c.setText(arrayOfString[0]);
      this.d.setText(arrayOfString[1]);
      return;
    }
    this.f.setVisibility(8);
    this.d.setVisibility(8);
    this.c.setText(paramString);
  }
  
  public class a
    extends RecyclerView.a<a>
  {
    private LayoutInflater b = LayoutInflater.from(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this));
    private ViewGroup.LayoutParams c;
    
    public a()
    {
      MinsuHomeRecyclerViewHouseItem.a(MinsuHomeRecyclerViewHouseItem.this, com.ziroom.ziroomcustomer.minsu.c.c.getInstance());
    }
    
    public int getItemCount()
    {
      return MinsuHomeRecyclerViewHouseItem.c(MinsuHomeRecyclerViewHouseItem.this).size();
    }
    
    public void onBindViewHolder(final a parama, final int paramInt)
    {
      if ((MinsuHomeRecyclerViewHouseItem.c(MinsuHomeRecyclerViewHouseItem.this) == null) || (MinsuHomeRecyclerViewHouseItem.c(MinsuHomeRecyclerViewHouseItem.this).size() == 0)) {}
      final Object localObject1;
      do
      {
        return;
        localObject1 = (MinsuHouseBean.DataBean.ListBean)MinsuHomeRecyclerViewHouseItem.c(MinsuHomeRecyclerViewHouseItem.this).get(paramInt);
      } while (localObject1 == null);
      Object localObject2;
      Object localObject3;
      if (MinsuHomeRecyclerViewHouseItem.d(MinsuHomeRecyclerViewHouseItem.this) == 1)
      {
        parama.i.setVisibility(0);
        parama.i.setItem((MinsuHouseBean.DataBean.ListBean)localObject1).setTsCountHelper(paramInt + "", MinsuHomeRecyclerViewHouseItem.e(MinsuHomeRecyclerViewHouseItem.this)).setCallb(new a.a()
        {
          public void onCountDown(long paramAnonymousLong)
          {
            if ((MinsuHomeRecyclerViewHouseItem.a(MinsuHomeRecyclerViewHouseItem.this, localObject1) > 100L) || (MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this, localObject1) <= 0L)) {
              parama.h.setText("¥ " + ad.getPriceInt(localObject1.price) + "/晚");
            }
            while (localObject1.originalPrice <= 0) {
              return;
            }
            parama.h.setText("¥" + ad.getPriceInt(localObject1.originalPrice) + "/晚");
          }
        }).update();
        parama.h.setPaintFlags(17);
        parama.h.setVisibility(0);
        if (((MinsuHouseBean.DataBean.ListBean)localObject1).tonightDiscountInfoVo != null) {
          parama.f.setText("¥ " + ad.getPriceInt(((MinsuHouseBean.DataBean.ListBean)localObject1).tonightDiscountInfoVo.tonightPrice) + "/晚");
        }
        localObject2 = x.makeUrl(((MinsuHouseBean.DataBean.ListBean)localObject1).picUrl);
        localObject3 = x.makeUrl(((MinsuHouseBean.DataBean.ListBean)localObject1).landlordUrl);
        com.freelxl.baselibrary.f.c.loadHolderImage(parama.b, (String)localObject2);
        com.freelxl.baselibrary.f.c.loadHolderImage(parama.c, (String)localObject3);
        parama.d.setText(((MinsuHouseBean.DataBean.ListBean)localObject1).houseName);
        parama.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            k.toLandlordDetailActivty(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this), localObject1.landlordUid);
          }
        });
        localObject2 = new ArrayList();
        ((List)localObject2).add(((MinsuHouseBean.DataBean.ListBean)localObject1).cityName);
        ((List)localObject2).add(((MinsuHouseBean.DataBean.ListBean)localObject1).rentWayName);
        if (((MinsuHouseBean.DataBean.ListBean)localObject1).personCount <= 0) {
          break label535;
        }
        ((List)localObject2).add("可住" + ((MinsuHouseBean.DataBean.ListBean)localObject1).personCount + "人");
      }
      int j;
      int i;
      for (;;)
      {
        localObject3 = new StringBuilder();
        j = ((List)localObject2).size();
        i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject3).append((String)((List)localObject2).get(i));
          if (i < j - 1)
          {
            ((StringBuilder)localObject3).append(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this).getString(2131297451));
            ((StringBuilder)localObject3).append(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this).getString(2131297451));
            ((StringBuilder)localObject3).append("|");
            ((StringBuilder)localObject3).append(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this).getString(2131297451));
            ((StringBuilder)localObject3).append(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this).getString(2131297451));
          }
          i += 1;
        }
        parama.i.setVisibility(8);
        parama.f.setText("¥ " + ad.getPriceInt(((MinsuHouseBean.DataBean.ListBean)localObject1).price) + "/晚");
        parama.f.setTextColor(Color.parseColor("#444444"));
        break;
        label535:
        if (((MinsuHouseBean.DataBean.ListBean)localObject1).personCount == 0) {
          ((List)localObject2).add("不限人数");
        }
      }
      com.ziroom.ziroomcustomer.minsu.f.ac.colorMulti(parama.e, ((StringBuilder)localObject3).toString(), "|", MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this).getResources().getColor(2131624046));
      if ((((MinsuHouseBean.DataBean.ListBean)localObject1).labelTipsList != null) && (((MinsuHouseBean.DataBean.ListBean)localObject1).labelTipsList.size() > 0))
      {
        localObject1 = ((MinsuHouseBean.DataBean.ListBean)localObject1).labelTipsList.iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label710;
        }
        localObject2 = (MinsuHouseBean.DataBean.ListBean.LabelTips)((Iterator)localObject1).next();
        if ((!MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this).getResources().getString(2131297164).equals(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject2).tipsType)) || (i >= 1)) {
          break label763;
        }
        if (MinsuHomeRecyclerViewHouseItem.d(MinsuHomeRecyclerViewHouseItem.this) != 1) {
          parama.g.setText(((MinsuHouseBean.DataBean.ListBean.LabelTips)localObject2).name);
        }
        i += 1;
      }
      label710:
      label752:
      label763:
      for (;;)
      {
        break;
        j = 0;
        if (MinsuHomeRecyclerViewHouseItem.d(MinsuHomeRecyclerViewHouseItem.this) != 1)
        {
          if (j != 0) {
            break label752;
          }
          parama.g.setVisibility(8);
        }
        for (;;)
        {
          parama.a.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if (MinsuHomeRecyclerViewHouseItem.a(MinsuHomeRecyclerViewHouseItem.this) != null) {
                MinsuHomeRecyclerViewHouseItem.a(MinsuHomeRecyclerViewHouseItem.this).onItemClick(paramInt);
              }
            }
          });
          return;
          parama.g.setVisibility(0);
        }
      }
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = this.b.inflate(2130904311, paramViewGroup, false);
      paramViewGroup = new a((View)localObject);
      paramInt = com.ziroom.ziroomcustomer.util.ac.getScreenWidth(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this)) - ab.dp2px(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this), 100.0F);
      this.c = new RelativeLayout.LayoutParams(paramInt, paramInt * 2 / 3);
      paramViewGroup.b = ((SimpleDraweeView)((View)localObject).findViewById(2131695249));
      paramViewGroup.b.setLayoutParams(this.c);
      com.freelxl.baselibrary.f.c.frescoHierarchyController(paramViewGroup.b, 2130838349);
      paramViewGroup.c = ((SimpleDraweeView)((View)localObject).findViewById(2131695264));
      paramViewGroup.c.setHierarchy(d.getRoundingHierarchy(MinsuHomeRecyclerViewHouseItem.b(MinsuHomeRecyclerViewHouseItem.this)));
      paramViewGroup.d = ((TextView)((View)localObject).findViewById(2131695250));
      paramViewGroup.f = ((TextView)((View)localObject).findViewById(2131689912));
      paramViewGroup.h = ((TextView)((View)localObject).findViewById(2131691316));
      paramViewGroup.g = ((TextView)((View)localObject).findViewById(2131695261));
      paramViewGroup.e = ((TextView)((View)localObject).findViewById(2131695251));
      paramViewGroup.i = ((TodaySecialView)((View)localObject).findViewById(2131695270));
      paramViewGroup.a = ((RelativeLayout)((View)localObject).findViewById(2131695269));
      localObject = paramViewGroup.d.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt;
      paramViewGroup.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return paramViewGroup;
    }
    
    public class a
      extends RecyclerView.u
    {
      RelativeLayout a;
      SimpleDraweeView b;
      SimpleDraweeView c;
      TextView d;
      TextView e;
      TextView f;
      TextView g;
      TextView h;
      TodaySecialView i;
      
      public a(View paramView)
      {
        super();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/view/MinsuHomeRecyclerViewHouseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */