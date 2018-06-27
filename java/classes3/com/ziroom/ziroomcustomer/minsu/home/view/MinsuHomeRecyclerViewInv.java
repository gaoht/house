package com.ziroom.ziroomcustomer.minsu.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.LabelTips;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.home.b.a.b;
import com.ziroom.ziroomcustomer.minsu.home.b.b.a.a;
import com.ziroom.ziroomcustomer.minsu.home.b.b.a.a.a;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.x;
import java.util.List;

public class MinsuHomeRecyclerViewInv
  extends RelativeLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  private RecyclerView d;
  private View e;
  private View f;
  private a g;
  private SimpleDraweeView h;
  private HomeCListCtrlView.b i;
  private List<MinsuHouseBean.DataBean.ListBean> j;
  
  public MinsuHomeRecyclerViewInv(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerViewInv(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MinsuHomeRecyclerViewInv(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2130903942, this);
    this.b = ((TextView)((View)localObject).findViewById(2131689533));
    this.c = ((TextView)((View)localObject).findViewById(2131691564));
    this.h = ((SimpleDraweeView)((View)localObject).findViewById(2131694177));
    this.e = ((View)localObject).findViewById(2131689578);
    this.f = ((View)localObject).findViewById(2131691258);
    this.d = ((RecyclerView)((View)localObject).findViewById(2131694160));
    localObject = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.d.setLayoutManager((RecyclerView.h)localObject);
    localObject = this.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = (ac.getScreenWidth(paramContext) - ab.dp2px(paramContext, 36.0F));
    ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 9 / 16);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a = paramContext;
  }
  
  public void setData(final b.a.a parama)
  {
    if (!TextUtils.isEmpty(parama.getTitle()))
    {
      this.b.setVisibility(0);
      this.b.setText(parama.getTitle());
      if (TextUtils.isEmpty(parama.getSubtitle())) {
        break label199;
      }
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.c.setText(parama.getSubtitle());
      label66:
      if ((parama == null) || (parama.getCover() == null) || (TextUtils.isEmpty(parama.getCover().getImg()))) {
        break label220;
      }
      c.loadHolderImage(this.h, parama.getCover().getImg());
      this.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new a.b();
          paramAnonymousView.setTarget(parama.getCover().getTarget());
          paramAnonymousView.setDescription(parama.getCover().getTitle());
          paramAnonymousView.setImg(parama.getCover().getImg());
          if ((MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this) instanceof MainActivity)) {
            k.CmsToWebActivity((MainActivity)MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this), paramAnonymousView);
          }
        }
      });
    }
    for (;;)
    {
      this.j = parama.getHouse();
      if (s.isEmpty(this.j)) {
        break label240;
      }
      if (this.g != null) {
        break label232;
      }
      this.g = new a();
      this.d.setAdapter(this.g);
      return;
      this.b.setVisibility(8);
      this.e.setVisibility(8);
      this.c.setVisibility(8);
      break;
      label199:
      this.e.setVisibility(8);
      this.c.setVisibility(8);
      break label66;
      label220:
      this.h.setVisibility(8);
    }
    label232:
    this.g.notifyDataSetChanged();
    return;
    label240:
    this.d.setVisibility(8);
  }
  
  public void setMoreClick(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.f.setVisibility(0);
      this.f.setOnClickListener(paramOnClickListener);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void setOnClickListener(HomeCListCtrlView.b paramb)
  {
    this.i = paramb;
  }
  
  public class a
    extends RecyclerView.a<a>
  {
    private int b = ac.getScreenWidth(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this));
    private LayoutInflater c = LayoutInflater.from(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this));
    
    public a() {}
    
    private void a(List<MinsuHouseBean.DataBean.ListBean.LabelTips> paramList, a parama)
    {
      TextView localTextView;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = (MinsuHouseBean.DataBean.ListBean.LabelTips)paramList.get(0);
        localTextView = (TextView)LayoutInflater.from(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this)).inflate(2130904936, null);
        if (!MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this).getResources().getString(2131297164).equals(paramList.tipsType)) {
          break label145;
        }
        localTextView.setTextColor(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this).getResources().getColor(2131624504));
      }
      for (;;)
      {
        localTextView.getPaint().setFakeBoldText(true);
        localTextView.setTextSize(1, 8.0F);
        localTextView.setText(paramList.name);
        parama.b.addView(localTextView);
        ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).setMargins(ab.dp2px(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this), 9.0F), 0, 0, 0);
        return;
        label145:
        if (MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this).getResources().getString(2131297163).equals(paramList.tipsType))
        {
          localTextView.setTextColor(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this).getResources().getColor(2131624487));
          localTextView.setBackgroundResource(2130838659);
        }
      }
    }
    
    public int getItemCount()
    {
      return MinsuHomeRecyclerViewInv.b(MinsuHomeRecyclerViewInv.this).size();
    }
    
    public void onBindViewHolder(a parama, int paramInt)
    {
      if ((MinsuHomeRecyclerViewInv.b(MinsuHomeRecyclerViewInv.this) == null) || (MinsuHomeRecyclerViewInv.b(MinsuHomeRecyclerViewInv.this).size() == 0)) {
        return;
      }
      final MinsuHouseBean.DataBean.ListBean localListBean = (MinsuHouseBean.DataBean.ListBean)MinsuHomeRecyclerViewInv.b(MinsuHomeRecyclerViewInv.this).get(paramInt);
      if (localListBean != null)
      {
        String str = x.makeUrl(localListBean.picUrl);
        parama.c.setController(c.frescoController(str));
        parama.d.setText("¥ " + localListBean.price + "/晚");
        parama.d.setTextColor(Color.parseColor("#444444"));
        parama.f.setText(localListBean.cityName);
        if (!TextUtils.isEmpty(localListBean.description)) {
          break label179;
        }
        parama.g.setVisibility(8);
        parama.e.setVisibility(8);
      }
      for (;;)
      {
        a(localListBean.labelTipsList, parama);
        parama.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = localListBean.fid;
            String str = localListBean.rentWay + "";
            if (localListBean.isTop50Online == 1)
            {
              k.toHouseDetail(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this), paramAnonymousView, str, true);
              return;
            }
            k.toHouseDetail(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this), paramAnonymousView, str, false);
          }
        });
        return;
        label179:
        parama.g.setVisibility(0);
        parama.e.setVisibility(0);
        parama.g.setText(localListBean.description);
      }
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = this.c.inflate(2130904319, paramViewGroup, false);
      a locala = new a(paramViewGroup);
      paramInt = (ac.getScreenWidth(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this)) - ab.dp2px(MinsuHomeRecyclerViewInv.a(MinsuHomeRecyclerViewInv.this), 40.0F)) / 3;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt * 2 / 3);
      locala.c = ((SimpleDraweeView)paramViewGroup.findViewById(2131695249));
      locala.c.setLayoutParams(localLayoutParams);
      paramViewGroup.getLayoutParams().width = paramInt;
      c.frescoHierarchyController(locala.c, 2130838349);
      locala.d = ((TextView)paramViewGroup.findViewById(2131695276));
      locala.g = ((TextView)paramViewGroup.findViewById(2131695279));
      locala.f = ((TextView)paramViewGroup.findViewById(2131695277));
      locala.e = paramViewGroup.findViewById(2131695278);
      locala.b = ((LinearLayout)paramViewGroup.findViewById(2131693065));
      locala.a = ((RelativeLayout)paramViewGroup.findViewById(2131690968));
      return locala;
    }
    
    public class a
      extends RecyclerView.u
    {
      RelativeLayout a;
      LinearLayout b;
      SimpleDraweeView c;
      TextView d;
      View e;
      TextView f;
      TextView g;
      
      public a(View paramView)
      {
        super();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/view/MinsuHomeRecyclerViewInv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */