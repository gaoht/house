package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.collection.GrowingIO;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.util.x;
import java.util.ArrayList;
import java.util.List;

public class HomeRentItemView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private RecyclerView d;
  private RecyclerView.a e;
  
  public HomeRentItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HomeRentItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HomeRentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View localView = View.inflate(paramContext, 2130904689, this);
    this.a = ((TextView)localView.findViewById(2131689541));
    this.b = ((TextView)localView.findViewById(2131690071));
    this.c = ((TextView)localView.findViewById(2131690326));
    this.d = ((RecyclerView)localView.findViewById(2131690100));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.d.setLayoutManager(paramContext);
  }
  
  public void notifyDataSetChanged()
  {
    if (this.e != null) {
      this.e.notifyDataSetChanged();
    }
  }
  
  public void setData(String paramString1, String paramString2, RecyclerView.a parama)
  {
    setData(paramString1, paramString2, null, parama);
  }
  
  public void setData(String paramString1, String paramString2, View.OnClickListener paramOnClickListener, RecyclerView.a parama)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString1))
    {
      this.a.setVisibility(8);
      if (!TextUtils.isEmpty(paramString2)) {
        break label144;
      }
      this.b.setVisibility(8);
      label35:
      if (paramOnClickListener != null) {
        break label163;
      }
      this.c.setVisibility(8);
    }
    for (;;)
    {
      label48:
      if (parama != null)
      {
        this.e = parama;
        this.d.setAdapter(this.e);
        paramString2 = new ArrayList();
        for (;;)
        {
          if (i < this.e.getItemCount())
          {
            paramString2.add(paramString1 + i);
            i += 1;
            continue;
            this.a.setVisibility(0);
            this.a.setText(paramString1);
            break;
            label144:
            this.b.setVisibility(0);
            this.b.setText(paramString2);
            break label35;
            label163:
            this.c.setVisibility(0);
            this.c.setOnClickListener(paramOnClickListener);
            break label48;
          }
        }
        GrowingIO.trackBanner(this.d, paramString2);
      }
    }
  }
  
  public void setTitleBold(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.getPaint().setFakeBoldText(paramBoolean);
      this.a.postInvalidate();
    }
  }
  
  public void setView(RecyclerView.h paramh)
  {
    if (paramh != null) {
      this.d.setLayoutManager(paramh);
    }
  }
  
  public static class a
    extends RecyclerView.a
  {
    private Context a;
    private List<ContentBean> b;
    private int c;
    private LayoutInflater d;
    private float e = 1.0F;
    
    public a(Context paramContext, List<ContentBean> paramList, int paramInt)
    {
      this(paramContext, paramList, paramInt, 1.0F);
    }
    
    public a(Context paramContext, List<ContentBean> paramList, int paramInt, float paramFloat)
    {
      this.a = paramContext;
      this.b = paramList;
      this.c = paramInt;
      this.d = LayoutInflater.from(this.a);
      this.e = paramFloat;
    }
    
    protected View a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      return this.d.inflate(this.c, paramViewGroup, paramBoolean);
    }
    
    protected ContentBean a(int paramInt)
    {
      if ((this.b != null) && (this.b.size() > paramInt)) {
        return (ContentBean)this.b.get(paramInt);
      }
      return null;
    }
    
    protected void a(ContentBean paramContentBean, RecyclerView.u paramu) {}
    
    protected void a(ContentBean paramContentBean, View paramView, SimpleDraweeView paramSimpleDraweeView, TextView paramTextView1, TextView paramTextView2) {}
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public float getProportion()
    {
      return this.e;
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
    {
      paramu = (a)paramu;
      ContentBean localContentBean = (ContentBean)this.b.get(paramInt);
      String str = x.makeUrl(localContentBean.getPic(), this.e);
      paramu.d.setController(c.frescoController(str));
      if (TextUtils.isEmpty(localContentBean.getTitle()))
      {
        paramu.b.setVisibility(8);
        paramu.c.setVisibility(8);
      }
      for (;;)
      {
        a(localContentBean, paramu.a, paramu.d, paramu.b, paramu.c);
        a(localContentBean, paramu);
        return;
        paramu.b.setVisibility(0);
        paramu.b.setText(localContentBean.getTitle());
        if (TextUtils.isEmpty(localContentBean.getSubtitle()))
        {
          paramu.c.setVisibility(8);
        }
        else
        {
          paramu.c.setText(localContentBean.getSubtitle());
          paramu.c.setVisibility(0);
        }
      }
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(this.d.inflate(this.c, paramViewGroup, false));
    }
    
    public static class a
      extends RecyclerView.u
    {
      protected View a;
      protected TextView b;
      protected TextView c;
      protected SimpleDraweeView d;
      
      public a(View paramView)
      {
        super();
        this.a = paramView;
        this.b = ((TextView)paramView.findViewById(2131689541));
        this.c = ((TextView)paramView.findViewById(2131690071));
        this.d = ((SimpleDraweeView)paramView.findViewById(2131691098));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/HomeRentItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */