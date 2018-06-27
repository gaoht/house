package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.al.c;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class w
  extends RecyclerView.a<a>
{
  List<al.c> a;
  private Context b;
  
  public w(Context paramContext, List<al.c> paramList)
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
    parama.e.setPadding(0, 0, n.dip2px(this.b, 6.0F), 0);
    float f1 = j.getDisplayWidth(this.b) * 342.0F / 375.0F;
    float f2 = 228.0F * f1 / 342.0F;
    Object localObject = parama.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
    ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
    parama.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = parama.i.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
    ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
    parama.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)parama.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)f2 * 135 / 228);
    parama.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = x.makeUrl(((al.c)this.a.get(paramInt)).getUrl());
    parama.a.setController(c.frescoController((String)localObject));
    parama.b.setController(c.frescoController(((al.c)this.a.get(paramInt)).getDesignerAvatar()));
    parama.c.setText(((al.c)this.a.get(paramInt)).getName());
    parama.d.setText(((al.c)this.a.get(paramInt)).getIntroduce());
    parama.e.setTag(Integer.valueOf(paramInt));
    parama.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = ((al.c)w.this.a.get(paramInt)).getJumpTitle();
        String str1 = ((al.c)w.this.a.get(paramInt)).getJumpUrl();
        String str2 = ((al.c)w.this.a.get(paramInt)).getIntroduce();
        String str3 = ((al.c)w.this.a.get(paramInt)).getUrl();
        JsBridgeWebActivity.start(w.a(w.this), paramAnonymousView, str1, true, str2, str3, false);
      }
    });
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904583, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    View e;
    LinearLayout f;
    LinearLayout g;
    RelativeLayout h;
    View i;
    
    public a(View paramView)
    {
      super();
      this.i = paramView.findViewById(2131695606);
      this.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      this.f = ((LinearLayout)paramView.findViewById(2131695820));
      this.g = ((LinearLayout)paramView.findViewById(2131695822));
      this.e = paramView.findViewById(2131690425);
      this.b = ((SimpleDraweeView)paramView.findViewById(2131695821));
      this.c = ((TextView)paramView.findViewById(2131692687));
      this.d = ((TextView)paramView.findViewById(2131692688));
      this.h = ((RelativeLayout)paramView.findViewById(2131690714));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */