package com.ziroom.ziroomcustomer.newclean.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.newclean.d.bm.b;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.List;

public class ServiceRecyclerView
  extends RelativeLayout
{
  private Context a;
  private RecyclerView b;
  private float c;
  private a d;
  private HomeCListCtrlView.b e;
  
  public ServiceRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ServiceRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ServiceRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = ((RecyclerView)View.inflate(paramContext, 2130904516, this).findViewById(2131694160));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext);
    localLinearLayoutManager.setOrientation(0);
    this.b.setLayoutManager(localLinearLayoutManager);
    this.a = paramContext;
  }
  
  public void setData(Context paramContext, List<bm.b> paramList)
  {
    this.d = new a(paramContext, paramList);
    this.b.setAdapter(this.d);
  }
  
  public void setOnClickListener(HomeCListCtrlView.b paramb)
  {
    this.e = paramb;
  }
  
  public class a
    extends RecyclerView.a<a>
  {
    List<bm.b> a;
    private int c;
    private LayoutInflater d;
    
    public a(List<bm.b> paramList)
    {
      this.d = LayoutInflater.from(paramList);
      List localList;
      this.a = localList;
      this.c = ac.getScreenWidth(paramList);
      ServiceRecyclerView.a(ServiceRecyclerView.this, paramList.getResources().getDisplayMetrics().density);
    }
    
    public int getItemCount()
    {
      if (this.a != null) {
        return this.a.size();
      }
      return 0;
    }
    
    public void onBindViewHolder(a parama, final int paramInt)
    {
      bm.b localb = (bm.b)this.a.get(paramInt);
      parama.f.setVisibility(0);
      parama.e.setVisibility(0);
      if (TextUtils.isEmpty(localb.getSubtitle())) {
        parama.d.setVisibility(8);
      }
      for (;;)
      {
        parama.c.setText(localb.getTitle());
        parama.b.setController(c.frescoController(localb.getPic()));
        parama.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (ServiceRecyclerView.b(ServiceRecyclerView.this) != null) {
              ServiceRecyclerView.b(ServiceRecyclerView.this).onItemClick(paramInt);
            }
          }
        });
        return;
        parama.d.setText(localb.getSubtitle());
      }
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = this.d.inflate(2130905122, paramViewGroup, false);
      paramInt = (int)(this.c / 2 - 22.0F * ServiceRecyclerView.a(ServiceRecyclerView.this));
      paramViewGroup = new a((View)localObject);
      paramViewGroup.a = ((RelativeLayout)((View)localObject).findViewById(2131690968));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt * 2 / 3);
      paramViewGroup.b = ((SimpleDraweeView)((View)localObject).findViewById(2131690969));
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      c.frescoHierarchyController(paramViewGroup.b, 2130838349);
      paramViewGroup.e = ((LinearLayout)((View)localObject).findViewById(2131694465));
      paramViewGroup.f = ((ImageView)((View)localObject).findViewById(2131694464));
      paramViewGroup.f.setLayoutParams(localLayoutParams);
      paramViewGroup.c = ((TextView)((View)localObject).findViewById(2131694466));
      paramViewGroup.d = ((TextView)((View)localObject).findViewById(2131694467));
      localObject = new LinearLayout.LayoutParams(paramInt - (int)(52.0F * ServiceRecyclerView.a(ServiceRecyclerView.this)), -2);
      paramViewGroup.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return paramViewGroup;
    }
    
    public class a
      extends RecyclerView.u
    {
      RelativeLayout a;
      SimpleDraweeView b;
      TextView c;
      TextView d;
      LinearLayout e;
      ImageView f;
      
      public a(View paramView)
      {
        super();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/ServiceRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */