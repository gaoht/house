package com.ziroom.ziroomcustomer.minsu.adapter;

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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCmsBean.DataBean;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.ArrayList;
import java.util.List;

public class MinsuHomeRecyclerView
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
  
  public MinsuHomeRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private List<List<MinsuCmsBean.DataBean>> a(List<MinsuCmsBean.DataBean> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int n = paramList.size() / 2;
    int m = n;
    if (paramList.size() % 2 != 0) {
      m = n + 1;
    }
    n = 0;
    while (n < m)
    {
      ArrayList localArrayList2 = new ArrayList();
      if (paramList.size() > n * 2)
      {
        int i1 = 0;
        while (i1 < 2)
        {
          if (n * 2 + i1 < paramList.size()) {
            localArrayList2.add(paramList.get(n * 2 + i1));
          }
          i1 += 1;
        }
      }
      localArrayList1.add(localArrayList2);
      n += 1;
    }
    return localArrayList1;
  }
  
  private void a(Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2130904900, this);
    this.b = ((TextView)((View)localObject).findViewById(2131689533));
    this.c = ((TextView)((View)localObject).findViewById(2131691564));
    this.e = ((TextView)((View)localObject).findViewById(2131696867));
    this.d = ((TextView)((View)localObject).findViewById(2131691258));
    this.f = ((RelativeLayout)((View)localObject).findViewById(2131695049));
    this.g = ((RecyclerView)((View)localObject).findViewById(2131694160));
    localObject = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.g.setLayoutManager((RecyclerView.h)localObject);
    this.a = paramContext;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = paramString.split("&");
      if (paramString.length >= 3)
      {
        this.e.setVisibility(0);
        this.b.setText(paramString[0]);
        this.c.setText(paramString[1]);
        this.e.setText(paramString[2]);
        return;
      }
    } while (paramString.length < 2);
    this.b.setText(paramString[0]);
    this.c.setText(paramString[1]);
  }
  
  public void setData(Context paramContext, List<MinsuCmsBean.DataBean> paramList, int paramInt)
  {
    this.h = paramInt;
    this.j = new a(paramContext, a(paramList));
    this.g.setAdapter(this.j);
    this.d.setVisibility(8);
    setTitle(((MinsuCmsBean.DataBean)paramList.get(0)).title);
  }
  
  public void setOnClickListener(HomeCListCtrlView.b paramb)
  {
    this.k = paramb;
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
    a(paramString);
  }
  
  public class a
    extends RecyclerView.a<a>
  {
    private int b;
    private LayoutInflater c;
    private List<List<MinsuCmsBean.DataBean>> d;
    
    public a(List<List<MinsuCmsBean.DataBean>> paramList)
    {
      this.c = LayoutInflater.from(paramList);
      List localList;
      this.d = localList;
      this.b = ac.getScreenWidth(paramList);
      MinsuHomeRecyclerView.a(MinsuHomeRecyclerView.this, paramList.getResources().getDisplayMetrics().density);
    }
    
    public int getItemCount()
    {
      return this.d.size();
    }
    
    public void onBindViewHolder(a parama, int paramInt)
    {
      final List localList = (List)this.d.get(paramInt);
      parama.b.setController(c.frescoController(((MinsuCmsBean.DataBean)localList.get(0)).pic));
      parama.c.setController(c.frescoController(((MinsuCmsBean.DataBean)localList.get(1)).pic));
      parama.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(MinsuHomeRecyclerView.c(MinsuHomeRecyclerView.this), MinsuWebActivity.class);
          paramAnonymousView.putExtra("url", ((MinsuCmsBean.DataBean)localList.get(0)).url);
          paramAnonymousView.putExtra("picUrl", ((MinsuCmsBean.DataBean)localList.get(0)).pic);
          paramAnonymousView.putExtra("title", ((MinsuCmsBean.DataBean)localList.get(0)).subtitle);
          if (!TextUtils.isEmpty(((MinsuCmsBean.DataBean)localList.get(0)).rgb)) {
            paramAnonymousView.putExtra("shareTitle", ((MinsuCmsBean.DataBean)localList.get(0)).rgb.split("&")[0]);
          }
          paramAnonymousView.putExtra("isShowShare", true);
          MinsuHomeRecyclerView.c(MinsuHomeRecyclerView.this).startActivity(paramAnonymousView);
        }
      });
      parama.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(MinsuHomeRecyclerView.c(MinsuHomeRecyclerView.this), MinsuWebActivity.class);
          paramAnonymousView.putExtra("url", ((MinsuCmsBean.DataBean)localList.get(1)).url);
          paramAnonymousView.putExtra("picUrl", ((MinsuCmsBean.DataBean)localList.get(1)).pic);
          paramAnonymousView.putExtra("title", ((MinsuCmsBean.DataBean)localList.get(1)).subtitle);
          if (!TextUtils.isEmpty(((MinsuCmsBean.DataBean)localList.get(1)).rgb)) {
            paramAnonymousView.putExtra("shareTitle", ((MinsuCmsBean.DataBean)localList.get(1)).rgb.split("&")[0]);
          }
          paramAnonymousView.putExtra("isShowShare", true);
          MinsuHomeRecyclerView.c(MinsuHomeRecyclerView.this).startActivity(paramAnonymousView);
        }
      });
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = this.c.inflate(2130904898, paramViewGroup, false);
      if (MinsuHomeRecyclerView.a(MinsuHomeRecyclerView.this) == 0) {}
      for (paramInt = (int)(this.b * 0.6F);; paramInt = (int)(this.b / 2 - 22.0F * MinsuHomeRecyclerView.b(MinsuHomeRecyclerView.this)))
      {
        a locala = new a(paramViewGroup);
        locala.a = ((LinearLayout)paramViewGroup.findViewById(2131690968));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt * 2 / 3);
        locala.b = ((SimpleDraweeView)paramViewGroup.findViewById(2131696865));
        locala.b.setLayoutParams(localLayoutParams);
        c.frescoHierarchyController(locala.b, 2130838349);
        locala.c = ((SimpleDraweeView)paramViewGroup.findViewById(2131696866));
        locala.c.setLayoutParams(localLayoutParams);
        c.frescoHierarchyController(locala.c, 2130838349);
        return locala;
      }
    }
    
    public class a
      extends RecyclerView.u
    {
      LinearLayout a;
      SimpleDraweeView b;
      SimpleDraweeView c;
      
      public a(View paramView)
      {
        super();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/MinsuHomeRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */