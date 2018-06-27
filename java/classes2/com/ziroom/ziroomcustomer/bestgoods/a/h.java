package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
  extends RecyclerView.a<a>
{
  private List<SKUMo> a;
  private Context b;
  private b c;
  
  public h(Context paramContext, List<SKUMo> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      a.c(parama).setClickable(false);
      a.c(parama).setTextColor(this.b.getResources().getColor(2131624042));
    }
    while ((paramInt2 < 9) && (paramInt2 < paramInt1))
    {
      a.d(parama).setClickable(true);
      a.d(parama).setTextColor(this.b.getResources().getColor(2131624516));
      return;
      a.c(parama).setClickable(true);
      a.c(parama).setTextColor(this.b.getResources().getColor(2131624516));
    }
    a.d(parama).setClickable(false);
    a.d(parama).setTextColor(this.b.getResources().getColor(2131624042));
  }
  
  public void getAllSelectedGoods(Integer paramInteger, String paramString)
  {
    double d1 = 0.0D;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    double d2 = 0.0D;
    while (localIterator.hasNext())
    {
      SKUMo localSKUMo = (SKUMo)localIterator.next();
      if (localSKUMo.isChecked())
      {
        localArrayList.add(localSKUMo);
        d2 += localSKUMo.getPrice().doubleValue() * localSKUMo.getCount();
        d1 += localSKUMo.getFreight() * localSKUMo.getCount();
      }
    }
    if (this.c != null) {
      this.c.getSelectedGoods(localArrayList, d2, d1);
    }
    if (paramInteger == null)
    {
      notifyDataSetChanged();
      return;
    }
    notifyItemChanged(paramInteger.intValue(), paramString);
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
    final SKUMo localSKUMo = (SKUMo)this.a.get(paramInt);
    final int i = localSKUMo.getCount();
    String str = localSKUMo.getSkuImg();
    a.e(parama).setText(localSKUMo.getSkuName());
    a.a(parama).setText(i + "");
    a.f(parama).setText("¥" + String.format("%.2f", new Object[] { localSKUMo.getPrice() }));
    final boolean bool;
    if (!TextUtils.isEmpty(str))
    {
      a.g(parama).setController(c.frescoController(str));
      bool = localSKUMo.isChecked();
      if (!bool) {
        break label249;
      }
      a.b(parama).setImageResource(2130838895);
    }
    for (;;)
    {
      a.h(parama).setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          if (h.a(h.this) != null)
          {
            h.a(h.this).removeGoods(paramInt);
            return true;
          }
          return false;
        }
      });
      a.b(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = localSKUMo;
          if (!bool) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            h.this.getAllSelectedGoods(Integer.valueOf(paramInt), "select");
            return;
          }
        }
      });
      a.c(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (i >= 1)
          {
            localSKUMo.setCount(i - 1);
            if (localSKUMo.isChecked()) {
              h.this.getAllSelectedGoods(Integer.valueOf(paramInt), "sub");
            }
          }
          else
          {
            return;
          }
          h.this.notifyItemChanged(paramInt, "sub");
        }
      });
      a.d(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localSKUMo.setCount(i + 1);
          if (localSKUMo.isChecked())
          {
            h.this.getAllSelectedGoods(Integer.valueOf(paramInt), "add");
            return;
          }
          h.this.notifyItemChanged(paramInt, "add");
        }
      });
      a(parama, localSKUMo.getAmount(), i);
      return;
      a.g(parama).setController(c.frescoController(null));
      break;
      label249:
      a.b(parama).setImageResource(2130838169);
    }
  }
  
  public void onBindViewHolder(a parama, final int paramInt, List<Object> paramList)
  {
    if (paramList.isEmpty())
    {
      onBindViewHolder(parama, paramInt);
      return;
    }
    paramList = (String)paramList.get(0);
    if (TextUtils.isEmpty(paramList))
    {
      onBindViewHolder(parama, paramInt);
      return;
    }
    final SKUMo localSKUMo = (SKUMo)this.a.get(paramInt);
    final boolean bool = ((SKUMo)this.a.get(paramInt)).isChecked();
    final int j = localSKUMo.getCount();
    int i;
    switch (paramList.hashCode())
    {
    default: 
      i = -1;
      label123:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      a.c(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (j >= 1)
          {
            localSKUMo.setCount(j - 1);
            if (bool) {
              h.this.getAllSelectedGoods(Integer.valueOf(paramInt), "sub");
            }
          }
          else
          {
            return;
          }
          h.this.notifyItemChanged(paramInt, "sub");
        }
      });
      a.d(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localSKUMo.setCount(j + 1);
          if (bool)
          {
            h.this.getAllSelectedGoods(Integer.valueOf(paramInt), "add");
            return;
          }
          h.this.notifyItemChanged(paramInt, "add");
        }
      });
      a.b(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = localSKUMo;
          if (!bool) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            h.this.getAllSelectedGoods(Integer.valueOf(paramInt), "select");
            return;
          }
        }
      });
      a(parama, localSKUMo.getAmount(), j);
      return;
      if (!paramList.equals("sub")) {
        break;
      }
      i = 0;
      break label123;
      if (!paramList.equals("add")) {
        break;
      }
      i = 1;
      break label123;
      if (!paramList.equals("select")) {
        break;
      }
      i = 2;
      break label123;
      a.a(parama).setText("" + j);
      continue;
      if (bool) {
        a.b(parama).setImageResource(2130838895);
      } else {
        a.b(parama).setImageResource(2130838169);
      }
    }
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904525, paramViewGroup, false));
  }
  
  public void setData(List<SKUMo> paramList)
  {
    this.a = paramList;
  }
  
  public void setOnSelectGoodsListener(b paramb)
  {
    this.c = paramb;
  }
  
  public static class a
    extends RecyclerView.u
  {
    private ImageView a;
    private RelativeLayout b;
    private SimpleDraweeView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    
    public a(View paramView)
    {
      super();
      this.b = ((RelativeLayout)paramView.findViewById(2131692167));
      this.a = ((ImageView)paramView.findViewById(2131695668));
      this.c = ((SimpleDraweeView)paramView.findViewById(2131694859));
      this.e = ((TextView)paramView.findViewById(2131693681));
      this.f = ((TextView)paramView.findViewById(2131690041));
      this.d = ((TextView)paramView.findViewById(2131690049));
      this.g = ((TextView)paramView.findViewById(2131689912));
      this.h = ((TextView)paramView.findViewById(2131689995));
    }
  }
  
  public static abstract interface b
  {
    public abstract void getSelectedGoods(ArrayList<SKUMo> paramArrayList, double paramDouble1, double paramDouble2);
    
    public abstract void removeGoods(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */