package com.ziroom.ziroomcustomer.minsu.home.view;

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
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.collection.GrowingIO;
import com.ziroom.ziroomcustomer.minsu.home.b.a.b;
import com.ziroom.ziroomcustomer.util.x;
import java.util.ArrayList;
import java.util.List;

public class SojournHomeItemView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private View d;
  private View e;
  private RelativeLayout f;
  private RecyclerView g;
  private RecyclerView.a h;
  
  public SojournHomeItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SojournHomeItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SojournHomeItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View localView = View.inflate(paramContext, 2130903941, this);
    this.a = ((TextView)localView.findViewById(2131689533));
    this.b = ((TextView)localView.findViewById(2131691564));
    this.c = ((TextView)localView.findViewById(2131691258));
    this.d = localView.findViewById(2131689578);
    this.e = localView.findViewById(2131694175);
    this.f = ((RelativeLayout)localView.findViewById(2131694176));
    this.g = ((RecyclerView)localView.findViewById(2131694160));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.g.setLayoutManager(paramContext);
  }
  
  public View getHead_line()
  {
    return this.e;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.h != null) {
      this.h.notifyDataSetChanged();
    }
  }
  
  public void setData(String paramString1, String paramString2, View.OnClickListener paramOnClickListener, RecyclerView.a parama)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString1))
    {
      this.a.setVisibility(8);
      this.d.setVisibility(8);
      this.b.setVisibility(8);
      this.f.setVisibility(8);
      if (!TextUtils.isEmpty(paramString2)) {
        break label180;
      }
      this.d.setVisibility(8);
      this.b.setVisibility(8);
      label71:
      if (paramOnClickListener != null) {
        break label199;
      }
      this.c.setVisibility(8);
    }
    for (;;)
    {
      label84:
      if (parama != null)
      {
        this.h = parama;
        this.g.setAdapter(this.h);
        paramString2 = new ArrayList();
        for (;;)
        {
          if (i < this.h.getItemCount())
          {
            paramString2.add(paramString1 + i);
            i += 1;
            continue;
            this.a.setVisibility(0);
            this.a.setText(paramString1);
            break;
            label180:
            this.b.setVisibility(0);
            this.b.setText(paramString2);
            break label71;
            label199:
            this.c.setVisibility(0);
            this.c.setOnClickListener(paramOnClickListener);
            break label84;
          }
        }
        GrowingIO.trackBanner(this.g, paramString2);
      }
    }
  }
  
  public void setView(RecyclerView.h paramh)
  {
    if (paramh != null) {
      this.g.setLayoutManager(paramh);
    }
  }
  
  public static class a
    extends RecyclerView.a
  {
    private Context a;
    private List<a.b> b;
    private int c;
    private LayoutInflater d;
    private float e = 1.0F;
    
    public a(Context paramContext, List<a.b> paramList, int paramInt)
    {
      this(paramContext, paramList, paramInt, 1.0F);
    }
    
    public a(Context paramContext, List<a.b> paramList, int paramInt, float paramFloat)
    {
      this.a = paramContext;
      this.b = paramList;
      this.c = paramInt;
      this.d = LayoutInflater.from(this.a);
      this.e = paramFloat;
    }
    
    protected void a(a.b paramb, a parama) {}
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
    {
      paramu = (a)paramu;
      a.b localb = (a.b)this.b.get(paramInt);
      String str = x.makeUrl(localb.getImg(), this.e);
      paramu.e.setController(c.frescoController(str));
      a(localb, paramu);
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
      public TextView d;
      public SimpleDraweeView e;
      
      public a(View paramView)
      {
        super();
        this.a = paramView;
        this.b = ((TextView)paramView.findViewById(2131689541));
        this.c = ((TextView)paramView.findViewById(2131690071));
        this.e = ((SimpleDraweeView)paramView.findViewById(2131691098));
        this.d = ((TextView)paramView.findViewById(2131693150));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/view/SojournHomeItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */