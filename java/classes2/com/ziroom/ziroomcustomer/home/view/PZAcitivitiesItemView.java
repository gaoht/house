package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.collection.GrowingIO;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.List;

public class PZAcitivitiesItemView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private View c;
  private TextView d;
  private RecyclerView e;
  private RecyclerView.a f;
  
  public PZAcitivitiesItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PZAcitivitiesItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PZAcitivitiesItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void initView(Context paramContext, int paramInt)
  {
    removeAllViews();
    View localView = View.inflate(paramContext, paramInt, this);
    this.a = ((TextView)localView.findViewById(2131689541));
    this.b = ((TextView)localView.findViewById(2131690071));
    this.c = localView.findViewById(2131696300);
    this.d = ((TextView)localView.findViewById(2131690326));
    this.e = ((RecyclerView)localView.findViewById(2131690100));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.e.setLayoutManager(paramContext);
  }
  
  public void notifyDataSetChanged()
  {
    if (this.f != null) {
      this.f.notifyDataSetChanged();
    }
  }
  
  public void setData(String paramString1, String paramString2, RecyclerView.a parama)
  {
    setData(paramString1, paramString2, null, null, parama);
  }
  
  public void setData(String paramString1, String paramString2, View.OnClickListener paramOnClickListener, RecyclerView.a parama)
  {
    setData(paramString1, paramString2, null, paramOnClickListener, parama);
  }
  
  public void setData(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener, RecyclerView.a parama)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      this.a.setVisibility(8);
      if (!TextUtils.isEmpty(paramString2)) {
        break label140;
      }
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      label41:
      if (parama != null)
      {
        this.f = parama;
        this.e.setAdapter(this.f);
        paramString2 = new ArrayList();
        int i = 0;
        for (;;)
        {
          if (i < this.f.getItemCount())
          {
            paramString2.add(paramString1 + i);
            i += 1;
            continue;
            this.a.setText(paramString1);
            this.a.setVisibility(0);
            break;
            label140:
            this.b.setText(paramString2);
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            break label41;
          }
        }
        GrowingIO.trackBanner(this.e, paramString2);
      }
    }
    if (ae.isNull(paramString3)) {
      this.d.setVisibility(8);
    }
    do
    {
      return;
      this.d.setText(paramString3);
      this.d.setVisibility(0);
    } while (paramOnClickListener == null);
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void setView(RecyclerView.h paramh)
  {
    if (paramh != null) {
      this.e.setLayoutManager(paramh);
    }
  }
  
  public static class a
    extends RecyclerView.a
  {
    private Context a;
    private int b;
    private int c;
    private LayoutInflater d;
    
    public a(Context paramContext, int paramInt1, int paramInt2)
    {
      this.a = paramContext;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = LayoutInflater.from(this.a);
    }
    
    protected void a(RecyclerView.u paramu, int paramInt) {}
    
    public int getItemCount()
    {
      return this.b;
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
    {
      a(paramu, paramInt);
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(this.d.inflate(this.c, paramViewGroup, false));
    }
    
    public static class a
      extends RecyclerView.u
    {
      public View a;
      public TextView b;
      public TextView c;
      public SimpleDraweeView d;
      
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/PZAcitivitiesItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */