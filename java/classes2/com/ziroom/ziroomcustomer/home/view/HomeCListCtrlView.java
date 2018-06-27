package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.a;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.widget.CustomGallery;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;
import java.util.List;

public class HomeCListCtrlView
  extends RelativeLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private RelativeLayout e;
  private CustomGallery f;
  private int g = 0;
  private a h;
  private float i;
  private float j;
  private float k;
  private b l;
  
  public HomeCListCtrlView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HomeCListCtrlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HomeCListCtrlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    int m = ac.getScreenWidth(paramContext);
    this.i = ((float)(m * 0.9D));
    this.j = ((float)(m * 0.9D * 2.0D / 3.0D));
    this.k = paramContext.getResources().getDisplayMetrics().density;
    View localView = View.inflate(paramContext, 2130904214, this);
    this.b = ((TextView)localView.findViewById(2131689533));
    this.c = ((TextView)localView.findViewById(2131691564));
    this.d = ((TextView)localView.findViewById(2131691258));
    this.e = ((RelativeLayout)localView.findViewById(2131695049));
    this.f = ((CustomGallery)localView.findViewById(2131695050));
    this.a = paramContext;
  }
  
  public void setData(Context paramContext, List<ContentBean> paramList, ScrollControlerViewPager paramScrollControlerViewPager, int paramInt)
  {
    this.f.setmPager(paramScrollControlerViewPager);
    this.g = paramInt;
    this.h = new a(paramContext, paramList);
    this.f.setAdapter(this.h);
    if ((paramInt == 1) || (paramInt == 3))
    {
      this.d.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if (HomeCListCtrlView.a(HomeCListCtrlView.this) != null) {
            HomeCListCtrlView.a(HomeCListCtrlView.this).onItemClick(paramAnonymousInt);
          }
        }
      });
      return;
      this.d.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (HomeCListCtrlView.a(HomeCListCtrlView.this) != null) {
            HomeCListCtrlView.a(HomeCListCtrlView.this).onClick();
          }
        }
      });
    }
  }
  
  public void setOnClickListener(b paramb)
  {
    this.l = paramb;
  }
  
  public void setSubTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  private class a
    extends a<ContentBean>
  {
    public a(List<ContentBean> paramList)
    {
      super(localList, 2130904020);
    }
    
    public void convert(b paramb, ContentBean paramContentBean) {}
    
    public void convert(b paramb, ContentBean paramContentBean, int paramInt)
    {
      super.convert(paramb, paramContentBean, paramInt);
      if (HomeCListCtrlView.b(HomeCListCtrlView.this) == 0)
      {
        paramb.setVisibility(2131694464, 8);
        paramb.setVisibility(2131694465, 8);
        paramb.setVisibility(2131694463, 0);
        paramb.setVisibility(2131691564, 0);
        paramb.setText(2131694463, paramContentBean.getTitle());
        paramb.setText(2131691564, paramContentBean.getSubtitle());
      }
      for (;;)
      {
        Object localObject = (RelativeLayout)paramb.getView(2131694434);
        paramb = (SimpleDraweeView)paramb.getView(2131694462);
        paramb.setLayoutParams(new RelativeLayout.LayoutParams((int)HomeCListCtrlView.c(HomeCListCtrlView.this), (int)HomeCListCtrlView.d(HomeCListCtrlView.this)));
        ((RelativeLayout)localObject).setLayoutParams(new Gallery.LayoutParams((int)HomeCListCtrlView.c(HomeCListCtrlView.this), -2));
        paramb.setController(c.frescoController(paramContentBean.getPic()));
        return;
        if ((HomeCListCtrlView.b(HomeCListCtrlView.this) == 1) || (HomeCListCtrlView.b(HomeCListCtrlView.this) == 3))
        {
          paramb.setVisibility(2131694465, 8);
          paramb.setVisibility(2131694463, 0);
          paramb.setVisibility(2131691564, 8);
          paramb.setVisibility(2131694464, 8);
          paramb.setText(2131694463, paramContentBean.getTitle());
          if (HomeCListCtrlView.b(HomeCListCtrlView.this) == 3)
          {
            localObject = (TextView)paramb.getView(2131694463);
            ((TextView)localObject).setTextSize(16.0F);
            ((TextView)localObject).getPaint().setFakeBoldText(true);
          }
        }
        else if (HomeCListCtrlView.b(HomeCListCtrlView.this) == 2)
        {
          paramb.setVisibility(2131694465, 0);
          paramb.setVisibility(2131694464, 0);
          paramb.setVisibility(2131694463, 8);
          paramb.setVisibility(2131691564, 8);
          paramb.setText(2131694466, paramContentBean.getTitle());
          paramb.setText(2131694467, paramContentBean.getSubtitle());
          ((ImageView)paramb.getView(2131694464)).setLayoutParams(new RelativeLayout.LayoutParams((int)HomeCListCtrlView.c(HomeCListCtrlView.this), (int)HomeCListCtrlView.d(HomeCListCtrlView.this)));
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
    
    public abstract void onItemClick(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/HomeCListCtrlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */