package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairFaultDescActivity;
import com.ziroom.ziroomcustomer.newrepair.b.g;
import com.ziroom.ziroomcustomer.newrepair.b.g.a;
import com.ziroom.ziroomcustomer.newrepair.b.g.a.a;
import com.ziroom.ziroomcustomer.util.n;
import java.util.Iterator;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private int b = 0;
  private g c;
  private String d;
  private boolean e = false;
  private a f;
  
  public i(Context paramContext, g paramg, String paramString, boolean paramBoolean)
  {
    this.a = paramContext;
    this.c = paramg;
    this.d = paramString;
    this.e = paramBoolean;
  }
  
  private void a(String paramString, final FlowLayout paramFlowLayout, final g.a parama)
  {
    Button localButton = new Button(this.a);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(-6710887);
    localButton.setTextSize(12.0F);
    localButton.setPadding(n.dip2px(this.a, 12.0F), n.dip2px(this.a, 4.0F), n.dip2px(this.a, 12.0F), n.dip2px(this.a, 4.0F));
    localButton.setBackgroundResource(2130837861);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, n.dip2px(this.a, 6.0F), n.dip2px(this.a, 12.0F), 0);
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = ((Button)paramAnonymousView).getText().toString();
        int i = 0;
        while (i < paramFlowLayout.getChildCount())
        {
          if (paramAnonymousView.equals(((Button)paramFlowLayout.getChildAt(i)).getText().toString()))
          {
            Intent localIntent = new Intent(i.a(i.this), InternalRepairFaultDescActivity.class);
            localIntent.putExtra("internal_repair_fault_name", parama.getGoodsName());
            localIntent.putExtra("internal_repair_fault_code", parama.getGoodsCode());
            localIntent.putExtra("internal_repair_fault_tag", paramAnonymousView);
            localIntent.putExtra("internal_repair_fault_keyword", i.b(i.this));
            localIntent.putExtra("isMyFragment", i.c(i.this));
            i.a(i.this).startActivity(localIntent);
            if (i.d(i.this) != null) {
              i.d(i.this).isFinish();
            }
          }
          i += 1;
        }
      }
    });
    paramFlowLayout.addView(localButton);
  }
  
  public int getCount()
  {
    if ((this.c.getRepairGoodsList() != null) && (this.c.getRepairGoodsList().size() > 0)) {
      return this.c.getRepairGoodsList().size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.a, 2130904257, null);
      b.a(paramViewGroup, (TextView)paramView.findViewById(2131695117));
      b.a(paramViewGroup, (FlowLayout)paramView.findViewById(2131690332));
      b.a(paramViewGroup, (SimpleDraweeView)paramView.findViewById(2131694449));
      paramView.setTag(paramViewGroup);
    }
    final g.a locala;
    for (;;)
    {
      locala = (g.a)this.c.getRepairGoodsList().get(paramInt);
      b.a(paramViewGroup).setController(c.frescoController(locala.getGoodsPic()));
      j.setIndexColor(locala.getGoodsName(), this.d, 40960, b.b(paramViewGroup));
      b.c(paramViewGroup).removeAllViews();
      Iterator localIterator = locala.getFaultFlagList().iterator();
      while (localIterator.hasNext()) {
        a(((g.a.a)localIterator.next()).getMaintainTag(), b.c(paramViewGroup), locala);
      }
      paramViewGroup = (b)paramView.getTag();
    }
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(i.a(i.this), InternalRepairFaultDescActivity.class);
        paramAnonymousView.putExtra("internal_repair_fault_name", locala.getGoodsName());
        paramAnonymousView.putExtra("internal_repair_fault_keyword", i.b(i.this));
        paramAnonymousView.putExtra("internal_repair_fault_code", locala.getGoodsCode());
        paramAnonymousView.putExtra("isMyFragment", i.c(i.this));
        i.a(i.this).startActivity(paramAnonymousView);
        if (i.d(i.this) != null) {
          i.d(i.this).isFinish();
        }
      }
    });
    return paramView;
  }
  
  public void setOnFinishListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void isFinish();
  }
  
  public class b
  {
    private TextView b;
    private SimpleDraweeView c;
    private FlowLayout d;
    
    public b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */