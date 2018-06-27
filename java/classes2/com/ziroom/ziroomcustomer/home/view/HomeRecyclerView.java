package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.x;
import java.util.List;

public class HomeRecyclerView
  extends RelativeLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private RelativeLayout f;
  private RecyclerView g;
  private int h = 0;
  private float i;
  private a j;
  private HomeCListCtrlView.b k;
  
  public HomeRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HomeRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HomeRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2130904216, this);
    this.b = ((TextView)((View)localObject).findViewById(2131689533));
    this.c = ((TextView)((View)localObject).findViewById(2131695051));
    this.d = ((TextView)((View)localObject).findViewById(2131691564));
    this.e = ((TextView)((View)localObject).findViewById(2131691258));
    this.f = ((RelativeLayout)((View)localObject).findViewById(2131695049));
    this.g = ((RecyclerView)((View)localObject).findViewById(2131694160));
    localObject = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.g.setLayoutManager((RecyclerView.h)localObject);
    this.a = paramContext;
  }
  
  public void setData(Context paramContext, List<ContentBean> paramList, int paramInt)
  {
    this.h = paramInt;
    this.j = new a(paramContext, paramList);
    this.g.setAdapter(this.j);
    if (paramInt == 1)
    {
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    if ((paramInt == 2) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6))
    {
      this.e.setVisibility(8);
      return;
    }
    if (paramInt == 8)
    {
      this.e.setVisibility(0);
      this.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (HomeRecyclerView.a(HomeRecyclerView.this) != null) {
            HomeRecyclerView.a(HomeRecyclerView.this).onClick();
          }
        }
      });
      return;
    }
    if (paramInt == 7)
    {
      this.e.setVisibility(8);
      this.b.setVisibility(8);
      this.c.setVisibility(0);
      return;
    }
    if (paramInt == 3) {
      this.e.setText("意见建议");
    }
    this.e.setVisibility(0);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (HomeRecyclerView.a(HomeRecyclerView.this) != null) {
          HomeRecyclerView.a(HomeRecyclerView.this).onClick();
        }
      }
    });
  }
  
  public void setOnClickListener(HomeCListCtrlView.b paramb)
  {
    this.k = paramb;
  }
  
  public void setSubTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.d.setText(paramString);
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
    this.c.setText(paramString);
  }
  
  public class a
    extends RecyclerView.a<a>
  {
    List<ContentBean> a;
    private int c;
    private LayoutInflater d;
    
    public a(List<ContentBean> paramList)
    {
      this.d = LayoutInflater.from(paramList);
      List localList;
      this.a = localList;
      this.c = ac.getScreenWidth(paramList);
      HomeRecyclerView.a(HomeRecyclerView.this, paramList.getResources().getDisplayMetrics().density);
    }
    
    public int getItemCount()
    {
      return this.a.size();
    }
    
    public void onBindViewHolder(a parama, final int paramInt)
    {
      ContentBean localContentBean = (ContentBean)this.a.get(paramInt);
      String str = localContentBean.getPic();
      if ((HomeRecyclerView.b(HomeRecyclerView.this) == 0) || (HomeRecyclerView.b(HomeRecyclerView.this) == 2))
      {
        parama.h.setVisibility(8);
        parama.g.setVisibility(8);
        parama.c.setVisibility(0);
        parama.d.setVisibility(0);
        parama.c.setText(localContentBean.getTitle());
        parama.d.setText(localContentBean.getSubtitle());
      }
      for (;;)
      {
        parama.b.setController(c.frescoController(str));
        parama.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (HomeRecyclerView.a(HomeRecyclerView.this) != null) {
              HomeRecyclerView.a(HomeRecyclerView.this).onItemClick(paramInt);
            }
          }
        });
        return;
        if ((HomeRecyclerView.b(HomeRecyclerView.this) == 1) || (HomeRecyclerView.b(HomeRecyclerView.this) == 4) || (HomeRecyclerView.b(HomeRecyclerView.this) == 3))
        {
          parama.h.setVisibility(0);
          parama.g.setVisibility(0);
          parama.c.setVisibility(8);
          parama.d.setVisibility(8);
          if (TextUtils.isEmpty(localContentBean.getSubtitle())) {
            parama.f.setVisibility(8);
          }
          for (;;)
          {
            parama.e.setText(localContentBean.getTitle());
            break;
            parama.f.setText(localContentBean.getSubtitle());
          }
        }
        if (HomeRecyclerView.b(HomeRecyclerView.this) == 5)
        {
          parama.h.setVisibility(8);
          parama.g.setVisibility(8);
          parama.c.setVisibility(8);
          parama.d.setVisibility(8);
          parama.f.setVisibility(8);
          parama.e.setVisibility(8);
        }
        else
        {
          if ((HomeRecyclerView.b(HomeRecyclerView.this) == 6) || (HomeRecyclerView.b(HomeRecyclerView.this) == 8))
          {
            parama.h.setVisibility(8);
            parama.g.setVisibility(8);
            if (ae.isNull(localContentBean.getTitle())) {
              parama.c.setVisibility(8);
            }
            for (;;)
            {
              parama.d.setVisibility(8);
              parama.f.setVisibility(8);
              parama.e.setVisibility(8);
              str = x.makeUrl(localContentBean.getPic(), 1.0F);
              break;
              parama.c.setVisibility(0);
              parama.c.setTextSize(15.0F);
              parama.c.setSingleLine(false);
              parama.c.getPaint().setFakeBoldText(true);
              parama.c.setText(localContentBean.getTitle());
            }
          }
          if (HomeRecyclerView.b(HomeRecyclerView.this) == 7)
          {
            parama.h.setVisibility(8);
            parama.g.setVisibility(8);
            if (ae.isNull(localContentBean.getTitle())) {
              parama.c.setVisibility(8);
            }
            for (;;)
            {
              parama.d.setVisibility(8);
              parama.f.setVisibility(8);
              parama.e.setVisibility(8);
              str = x.makeUrl(localContentBean.getPic(), 1.0F);
              break;
              parama.c.setVisibility(0);
              parama.c.setTextSize(16.0F);
              parama.c.setSingleLine(false);
              parama.c.setTextColor(-12303292);
              parama.c.setText(localContentBean.getTitle());
            }
          }
        }
      }
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = this.d.inflate(2130904030, paramViewGroup, false);
      a locala;
      if (HomeRecyclerView.b(HomeRecyclerView.this) == 0)
      {
        paramInt = (int)(this.c * 0.6F);
        locala = new a(localView);
        locala.a = ((RelativeLayout)localView.findViewById(2131690968));
        if ((6 != HomeRecyclerView.b(HomeRecyclerView.this)) && (8 != HomeRecyclerView.b(HomeRecyclerView.this))) {
          break label445;
        }
        paramViewGroup = new RelativeLayout.LayoutParams(paramInt, (int)(paramInt * 2.0F / 3.0F));
      }
      for (;;)
      {
        locala.b = ((SimpleDraweeView)localView.findViewById(2131690969));
        locala.b.setLayoutParams(paramViewGroup);
        c.frescoHierarchyController(locala.b, 2130838349);
        locala.g = ((LinearLayout)localView.findViewById(2131694465));
        locala.c = ((TextView)localView.findViewById(2131694508));
        locala.d = ((TextView)localView.findViewById(2131694509));
        locala.h = ((ImageView)localView.findViewById(2131694464));
        locala.h.setLayoutParams(paramViewGroup);
        paramViewGroup = new LinearLayout.LayoutParams(paramInt, -2);
        paramViewGroup.setMargins(0, (int)(8.0F * HomeRecyclerView.c(HomeRecyclerView.this)), 0, 0);
        locala.c.setLayoutParams(paramViewGroup);
        paramViewGroup = new LinearLayout.LayoutParams(paramInt, -2);
        paramViewGroup.setMargins(0, (int)(4.0F * HomeRecyclerView.c(HomeRecyclerView.this)), 0, 0);
        locala.d.setLayoutParams(paramViewGroup);
        locala.e = ((TextView)localView.findViewById(2131694466));
        locala.f = ((TextView)localView.findViewById(2131694467));
        paramViewGroup = new LinearLayout.LayoutParams(paramInt - (int)(52.0F * HomeRecyclerView.c(HomeRecyclerView.this)), -2);
        locala.e.setLayoutParams(paramViewGroup);
        locala.f.setLayoutParams(paramViewGroup);
        return locala;
        if ((HomeRecyclerView.b(HomeRecyclerView.this) == 6) || (HomeRecyclerView.b(HomeRecyclerView.this) == 8))
        {
          paramInt = (int)(this.c - HomeRecyclerView.c(HomeRecyclerView.this) * 36.0F);
          break;
        }
        if (HomeRecyclerView.b(HomeRecyclerView.this) == 7)
        {
          paramInt = (int)(this.c - HomeRecyclerView.c(HomeRecyclerView.this) * 36.0F);
          break;
        }
        paramInt = (int)(this.c / 2 - 22.0F * HomeRecyclerView.c(HomeRecyclerView.this));
        break;
        label445:
        if (5 == HomeRecyclerView.b(HomeRecyclerView.this)) {
          paramViewGroup = new RelativeLayout.LayoutParams(paramInt, (int)(paramInt * 100.0F / 165.0F));
        } else {
          paramViewGroup = new RelativeLayout.LayoutParams(paramInt, (int)(paramInt * 2.0F / 3.0F));
        }
      }
    }
    
    public class a
      extends RecyclerView.u
    {
      RelativeLayout a;
      SimpleDraweeView b;
      TextView c;
      TextView d;
      TextView e;
      TextView f;
      LinearLayout g;
      ImageView h;
      
      public a(View paramView)
      {
        super();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/HomeRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */