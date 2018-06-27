package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinCombinationInfoActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.al.f;
import com.ziroom.ziroomcustomer.bestgoods.model.al.f.a;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class t
  extends RecyclerView.a<a>
{
  List<al.f> a;
  private Context b;
  
  public t(Context paramContext, List<al.f> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(a parama, final int paramInt)
  {
    parama.b.setPadding(0, 0, n.dip2px(this.b, 6.0F), 0);
    ViewGroup.LayoutParams localLayoutParams = parama.a.getLayoutParams();
    float f1 = j.getDisplayWidth(this.b) * 342.0F / 375.0F;
    float f2 = 228.0F * f1 / 342.0F;
    localLayoutParams.width = ((int)f1);
    localLayoutParams.height = ((int)f2);
    parama.a.setLayoutParams(localLayoutParams);
    parama.a.setController(c.frescoController(((al.f)this.a.get(paramInt)).getGroupImgUrl()));
    parama.d.setText(((al.f)this.a.get(paramInt)).getGroupName());
    parama.c.setText(((al.f)this.a.get(paramInt)).getGroupPrice());
    if ((((al.f)this.a.get(paramInt)).getGroupDetail() != null) && (((al.f)this.a.get(paramInt)).getGroupDetail().size() > 0))
    {
      if (((al.f)this.a.get(paramInt)).getGroupDetail().size() != 1) {
        break label295;
      }
      parama.e.setController(c.frescoController(""));
      parama.f.setController(c.frescoController(""));
      parama.g.setController(c.frescoController(((al.f.a)((al.f)this.a.get(paramInt)).getGroupDetail().get(0)).getSkuImg()));
    }
    for (;;)
    {
      parama.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(t.a(t.this), YouPinCombinationInfoActivity.class);
          paramAnonymousView.putExtra("groupCode", ((al.f)t.this.a.get(paramInt)).getGroupCode());
          t.a(t.this).startActivity(paramAnonymousView);
        }
      });
      return;
      label295:
      if (((al.f)this.a.get(paramInt)).getGroupDetail().size() == 2)
      {
        parama.e.setController(c.frescoController(""));
        parama.f.setController(c.frescoController(((al.f.a)((al.f)this.a.get(paramInt)).getGroupDetail().get(0)).getSkuImg()));
        parama.g.setController(c.frescoController(((al.f.a)((al.f)this.a.get(paramInt)).getGroupDetail().get(1)).getSkuImg()));
      }
      else if (((al.f)this.a.get(paramInt)).getGroupDetail().size() == 3)
      {
        parama.e.setController(c.frescoController(((al.f.a)((al.f)this.a.get(paramInt)).getGroupDetail().get(0)).getSkuImg()));
        parama.f.setController(c.frescoController(((al.f.a)((al.f)this.a.get(paramInt)).getGroupDetail().get(1)).getSkuImg()));
        parama.g.setController(c.frescoController(((al.f.a)((al.f)this.a.get(paramInt)).getGroupDetail().get(2)).getSkuImg()));
      }
    }
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904577, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    View b;
    TextView c;
    TextView d;
    SimpleDraweeView e;
    SimpleDraweeView f;
    SimpleDraweeView g;
    
    public a(View paramView)
    {
      super();
      this.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      this.b = paramView.findViewById(2131690425);
      this.c = ((TextView)paramView.findViewById(2131693913));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131695805));
      this.f = ((SimpleDraweeView)paramView.findViewById(2131695806));
      this.g = ((SimpleDraweeView)paramView.findViewById(2131695807));
      this.d = ((TextView)paramView.findViewById(2131690741));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */