package com.ziroom.ziroomcustomer.minsu.home.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseListActivity;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.home.b.b.a.b.a;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.widget.ZiroomFlowLayout;
import java.util.List;

public class MinsuHomeRecyclerViewTop
  extends RelativeLayout
{
  List<b.a.b.a> a;
  private Context b;
  private TextView c;
  private TextView d;
  private TextView e;
  private RelativeLayout f;
  private RecyclerView g;
  private View h;
  private View i;
  private a j;
  private HomeCListCtrlView.b k;
  
  public MinsuHomeRecyclerViewTop(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerViewTop(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerViewTop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(final Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2130903941, this);
    this.c = ((TextView)((View)localObject).findViewById(2131689533));
    this.d = ((TextView)((View)localObject).findViewById(2131691564));
    this.e = ((TextView)((View)localObject).findViewById(2131691258));
    this.h = ((View)localObject).findViewById(2131689578);
    this.i = ((View)localObject).findViewById(2131694175);
    this.f = ((RelativeLayout)((View)localObject).findViewById(2131695049));
    this.g = ((RecyclerView)((View)localObject).findViewById(2131694160));
    localObject = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.g.setLayoutManager((RecyclerView.h)localObject);
    this.b = paramContext;
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(paramContext, MinsuTopHouseListActivity.class);
        paramContext.startActivity(paramAnonymousView);
      }
    });
  }
  
  private void a(ZiroomFlowLayout paramZiroomFlowLayout, List<String> paramList)
  {
    paramZiroomFlowLayout.setMaxLine(1);
    paramZiroomFlowLayout.removeLastView();
    if (paramZiroomFlowLayout.getChildCount() > 0) {
      paramZiroomFlowLayout.removeAllViews();
    }
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramList)) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < paramList.size())
      {
        Object localObject = (String)paramList.get(m);
        TextView localTextView = new TextView(this.b);
        localTextView.setText((CharSequence)localObject);
        localTextView.setTextColor(this.b.getResources().getColor(2131624042));
        localTextView.setTextSize(12.0F);
        localObject = new View(this.b);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ab.dp2px(this.b, 1.0F), ab.dp2px(this.b, 11.0F));
        ((View)localObject).setBackgroundColor(this.b.getResources().getColor(2131624046));
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setTag("line");
        localLayoutParams.setMargins(ab.dp2px(this.b, 8.0F), ab.dp2px(this.b, 3.0F), ab.dp2px(this.b, 8.0F), 0);
        paramZiroomFlowLayout.addView(localTextView);
        paramZiroomFlowLayout.addView((View)localObject);
        m += 1;
      }
    }
  }
  
  public View getHead_line()
  {
    return this.i;
  }
  
  public void setData(List<b.a.b.a> paramList)
  {
    this.a = paramList;
    if (this.j == null)
    {
      this.j = new a();
      this.g.setAdapter(this.j);
      return;
    }
    this.j.notifyDataSetChanged();
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
    this.h.setVisibility(8);
    this.d.setVisibility(8);
    this.c.setText(paramString);
  }
  
  public class a
    extends RecyclerView.a<a>
  {
    private int b = ac.getScreenWidth(MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this));
    private LayoutInflater c = LayoutInflater.from(MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this));
    
    public a() {}
    
    public int getItemCount()
    {
      return MinsuHomeRecyclerViewTop.this.a.size();
    }
    
    public void onBindViewHolder(a parama, int paramInt)
    {
      if ((MinsuHomeRecyclerViewTop.this.a == null) || (MinsuHomeRecyclerViewTop.this.a.size() == 0)) {
        return;
      }
      final b.a.b.a locala = (b.a.b.a)MinsuHomeRecyclerViewTop.this.a.get(paramInt);
      if (locala != null)
      {
        String str = x.makeUrl(locala.getPicUrl());
        parama.b.setController(com.freelxl.baselibrary.f.c.frescoController(str));
        parama.c.setText(locala.getHouseName());
        MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this, parama.d, locala.getIndivLabelTipsList());
      }
      parama.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = locala.getFid();
          String str = locala.getRentWay() + "";
          k.toHouseDetail(MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this), paramAnonymousView, str, true);
        }
      });
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = this.c.inflate(2130904359, paramViewGroup, false);
      paramViewGroup = new a((View)localObject);
      paramInt = ac.getScreenWidth(MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this)) - ab.dp2px(MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this), 100.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt * 2 / 3);
      paramViewGroup.b = ((SimpleDraweeView)((View)localObject).findViewById(2131695249));
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      com.freelxl.baselibrary.f.c.frescoHierarchyController(paramViewGroup.b, 2130838349);
      paramViewGroup.c = ((TextView)((View)localObject).findViewById(2131690049));
      paramViewGroup.c.getLayoutParams().width = paramInt;
      paramViewGroup.d = ((ZiroomFlowLayout)((View)localObject).findViewById(2131691369));
      paramViewGroup.a = ((LinearLayout)((View)localObject).findViewById(2131690968));
      localObject = new LinearLayout.LayoutParams(paramInt, -2);
      ((LinearLayout.LayoutParams)localObject).rightMargin = n.dip2px(MinsuHomeRecyclerViewTop.a(MinsuHomeRecyclerViewTop.this), 11.0F);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return paramViewGroup;
    }
    
    public class a
      extends RecyclerView.u
    {
      LinearLayout a;
      SimpleDraweeView b;
      TextView c;
      ZiroomFlowLayout d;
      
      public a(View paramView)
      {
        super();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/view/MinsuHomeRecyclerViewTop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */