package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.ac;
import com.ziroom.ziroomcustomer.bestgoods.model.ad;
import com.ziroom.ziroomcustomer.bestgoods.model.j;
import com.ziroom.ziroomcustomer.bestgoods.model.p;
import com.ziroom.ziroomcustomer.newServiceList.view.FlowLayoutLimitLine;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
  extends BaseAdapter
{
  private j a;
  private Map<Integer, Integer> b = new HashMap();
  private boolean c;
  private boolean d;
  private List<p> e;
  private ad f;
  private List<ac> g;
  private Context h;
  private int i = -1;
  private int j = -1;
  private a k;
  
  public f(Context paramContext, j paramj, Map<Integer, Integer> paramMap)
  {
    this(paramContext, paramj, paramMap, null);
  }
  
  public f(Context paramContext, j paramj, Map<Integer, Integer> paramMap, a parama)
  {
    this.k = parama;
    this.a = paramj;
    this.h = paramContext;
    if (paramMap == null)
    {
      this.c = false;
      m = 0;
      while (m < 2)
      {
        this.b.put(Integer.valueOf(m), Integer.valueOf(-1));
        m += 1;
      }
    }
    int m = 0;
    while (m < 2)
    {
      this.b.put(Integer.valueOf(m), paramMap.get(Integer.valueOf(m)));
      m += 1;
    }
    this.c = true;
    this.e = paramj.getPropertyList();
    m = 0;
    for (;;)
    {
      if (m < this.e.size())
      {
        paramContext = (p)this.e.get(m);
        if (paramContext.getChecked() != 1) {
          break label311;
        }
        this.f = paramContext.getProperty();
        this.g = this.f.getPropertyList();
        if (!this.d)
        {
          this.i = m;
          m = n;
        }
      }
      for (;;)
      {
        if (m < this.g.size())
        {
          if (((ac)this.g.get(m)).getChecked() != 1) {
            break label302;
          }
          this.j = m;
          m = ((ac)this.g.get(m)).getAmount();
          if (this.k != null) {
            this.k.initData(m);
          }
        }
        return;
        label302:
        m += 1;
      }
      label311:
      m += 1;
    }
  }
  
  private void a()
  {
    Object localObject1 = new ArrayList();
    String str = "已选";
    Object localObject2 = this.b.entrySet().iterator();
    int m = 1;
    Object localObject3;
    Integer localInteger;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localInteger = (Integer)((Map.Entry)localObject3).getKey();
      localObject3 = (Integer)((Map.Entry)localObject3).getValue();
      if (localInteger.intValue() == 0) {
        if (((Integer)localObject3).intValue() == -1)
        {
          ((List)localObject1).add(this.a.getPropertyName());
          m = 0;
        }
      }
    }
    for (;;)
    {
      break;
      str = str + ((p)this.e.get(((Integer)localObject3).intValue())).getPropertyValueName() + " ";
      continue;
      if (localInteger.intValue() == 1) {
        if (((Integer)localObject3).intValue() == -1)
        {
          ((List)localObject1).add(this.f.getPropertyName());
          m = 0;
        }
        else
        {
          str = str + ((ac)this.g.get(((Integer)localObject3).intValue())).getPropertyValueName() + " ";
          continue;
          if (m == 0)
          {
            localObject1 = ((List)localObject1).iterator();
            for (str = "请选择"; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + " ") {
              localObject2 = (String)((Iterator)localObject1).next();
            }
            if (this.k != null) {
              this.k.checkProperty(str, null);
            }
          }
          while (this.k == null) {
            return;
          }
          if (this.d)
          {
            this.k.checkProperty(str, this.b);
            return;
          }
          this.k.checkProperty(str, null);
          return;
        }
      }
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    int n = 0;
    int m = 0;
    Object localObject;
    if (paramInt == 0)
    {
      if ((this.e != null) && (this.e.size() > 0)) {
        paramb.b.setVisibility(0);
      }
      while (m < this.e.size())
      {
        localObject = (p)this.e.get(m);
        a(paramb, ((p)localObject).getPropertyValueName(), paramInt, m, ((p)localObject).getChecked());
        m += 1;
        continue;
        paramb.b.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        if ((this.g == null) || (this.g.size() <= 0)) {
          break;
        }
        paramb.b.setVisibility(0);
        m = n;
        while (m < this.g.size())
        {
          localObject = (ac)this.g.get(m);
          a(paramb, ((ac)localObject).getPropertyValueName(), paramInt, m, ((ac)localObject).getChecked());
          m += 1;
        }
      }
    }
    paramb.b.setVisibility(8);
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    paramb = (TextView)paramb.b.getChildAt(paramInt2);
    if ((paramInt1 == 0) || ((paramInt1 == 1) && (((ac)this.g.get(paramInt2)).getAmount() > 0)))
    {
      paramb.setBackgroundResource(2130839356);
      paramb.setTextColor(this.h.getResources().getColor(2131624097));
      paramb.setTag(Integer.valueOf(-1));
      paramb.setClickable(true);
    }
    for (;;)
    {
      if (paramInt1 == 1) {
        ((ac)this.g.get(paramInt2)).setChecked(0);
      }
      return;
      if ((paramInt1 == 1) && (paramInt1 == 1) && (((ac)this.g.get(paramInt2)).getAmount() <= 0))
      {
        paramb.setBackgroundResource(2130839352);
        paramb.setTextColor(this.h.getResources().getColor(2131624583));
        paramb.setTag(Integer.valueOf(-1));
        paramb.setClickable(false);
      }
    }
  }
  
  private void a(final b paramb, String paramString, final int paramInt1, final int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.h);
    localTextView.setText(paramString);
    localTextView.setIncludeFontPadding(false);
    localTextView.setGravity(17);
    localTextView.setPadding(n.dip2px(this.h, 6.0F), n.dip2px(this.h, 6.0F), n.dip2px(this.h, 6.0F), n.dip2px(this.h, 6.0F));
    localTextView.setTextSize(14.0F);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, 0, n.dip2px(this.h, 12.0F), n.dip2px(this.h, 12.0F));
    localTextView.setLayoutParams(paramString);
    int m;
    boolean bool2;
    if (this.i == ((Integer)this.b.get(Integer.valueOf(0))).intValue())
    {
      m = 1;
      if (paramInt1 != 0) {
        break label277;
      }
      bool2 = true;
      label165:
      if (paramInt3 != 1) {
        break label362;
      }
      this.b.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      localTextView.setTag(Integer.valueOf(0));
      localTextView.setBackgroundResource(2130839372);
      localTextView.setTextColor(this.h.getResources().getColor(2131624516));
      paramb.b.setTag(Integer.valueOf(paramInt2));
    }
    for (;;)
    {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (TextView)paramAnonymousView;
          paramAnonymousView.getText().toString();
          int i;
          if (((Integer)paramAnonymousView.getTag()).intValue() == -1)
          {
            if (paramInt1 == 0) {
              f.a(f.this, ((p)f.a(f.this).get(paramInt2)).getProperty().getPropertyList());
            }
            f.b(f.this).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
            if (f.c(f.this) != ((Integer)f.b(f.this).get(Integer.valueOf(0))).intValue()) {}
            for (i = 1;; i = 0)
            {
              Object localObject = paramb.b.getTag();
              if ((localObject != null) && (((Integer)localObject).intValue() >= 0) && (i == 0)) {
                f.a(f.this, paramb, paramInt1, ((Integer)localObject).intValue());
              }
              paramAnonymousView.setBackgroundResource(2130839372);
              paramAnonymousView.setTextColor(f.d(f.this).getResources().getColor(2131624516));
              paramAnonymousView.setTag(Integer.valueOf(0));
              paramb.b.setTag(Integer.valueOf(paramInt2));
              if (paramInt1 != 0) {
                break label394;
              }
              i = 0;
              if (i >= f.a(f.this).size()) {
                break label370;
              }
              paramAnonymousView = (p)f.a(f.this).get(i);
              if (paramInt2 != i) {
                break label362;
              }
              paramAnonymousView.setChecked(1);
              paramAnonymousView = f.e(f.this).iterator();
              while (paramAnonymousView.hasNext()) {
                ((ac)paramAnonymousView.next()).setChecked(0);
              }
            }
            f.b(f.this).put(Integer.valueOf(1), Integer.valueOf(-1));
            for (;;)
            {
              i += 1;
              break;
              label362:
              paramAnonymousView.setChecked(0);
            }
            label370:
            f.a(f.this, false);
            f.this.notifyDataSetChanged();
          }
          for (;;)
          {
            f.i(f.this);
            return;
            label394:
            if ((paramInt1 == 1) && (((ac)f.e(f.this).get(paramInt2)).getChecked() != 1)) {
              if ((!f.f(f.this)) && (i == 0) && (f.g(f.this) == ((Integer)f.b(f.this).get(Integer.valueOf(1))).intValue()))
              {
                if (f.h(f.this) != null) {
                  f.h(f.this).revertUI();
                }
                f.a(f.this, false);
              }
              else
              {
                ((ac)f.e(f.this).get(paramInt2)).setChecked(1);
                f.a(f.this, true);
                f.a(f.this, paramInt2);
                f.b(f.this, ((Integer)f.b(f.this).get(Integer.valueOf(0))).intValue());
              }
            }
          }
        }
      });
      localTextView.setClickable(bool2);
      paramb.b.addView(localTextView);
      return;
      m = 0;
      break;
      label277:
      if (paramInt1 == 1)
      {
        boolean bool1;
        if (((ac)this.g.get(paramInt2)).getAmount() > 0)
        {
          bool1 = true;
          label305:
          bool2 = bool1;
          if (this.k == null) {
            break label165;
          }
          paramString = this.k;
          if (m != 0) {
            break label350;
          }
        }
        label350:
        for (bool2 = true;; bool2 = false)
        {
          paramString.propertyOneChange(bool2);
          bool2 = bool1;
          break;
          bool1 = false;
          break label305;
        }
      }
      bool2 = false;
      break label165;
      label362:
      if ((paramInt1 == 1) && (!bool2))
      {
        localTextView.setTag(Integer.valueOf(-1));
        localTextView.setBackgroundResource(2130839352);
        localTextView.setTextColor(this.h.getResources().getColor(2131624583));
      }
      else
      {
        localTextView.setTag(Integer.valueOf(-1));
        localTextView.setBackgroundResource(2130839356);
        localTextView.setTextColor(this.h.getResources().getColor(2131624097));
      }
    }
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.h).inflate(2130904135, null);
      paramView = new b(null);
      paramView.a = ((TextView)localView.findViewById(2131694865));
      paramView.b = ((FlowLayoutLimitLine)localView.findViewById(2131694866));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      Log.e("TAG", "getView" + paramInt);
      if (paramInt != 0) {
        break label142;
      }
      paramViewGroup.a.setText(this.a.getPropertyName());
    }
    for (;;)
    {
      paramViewGroup.b.removeAllViews();
      a(paramViewGroup, paramInt);
      return localView;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break;
      label142:
      if (paramInt == 1) {
        paramViewGroup.a.setText(this.f.getPropertyName());
      }
    }
  }
  
  public void setData(j paramj, Map<Integer, Integer> paramMap)
  {
    int m = 0;
    this.a = paramj;
    if (paramMap == null)
    {
      this.c = false;
      while (m < 2)
      {
        this.b.put(Integer.valueOf(m), Integer.valueOf(-1));
        m += 1;
      }
    }
    this.b = paramMap;
    this.c = true;
    this.e = paramj.getPropertyList();
    paramj = this.e.iterator();
    while (paramj.hasNext())
    {
      paramMap = (p)paramj.next();
      if (paramMap.getChecked() == 1) {
        this.g = paramMap.getProperty().getPropertyList();
      }
    }
    notifyDataSetChanged();
  }
  
  public void setOnCheckProperty(a parama)
  {
    this.k = parama;
  }
  
  public static abstract interface a
  {
    public abstract void checkProperty(String paramString, Map<Integer, Integer> paramMap);
    
    public abstract void initData(int paramInt);
    
    public abstract void propertyOneChange(boolean paramBoolean);
    
    public abstract void revertUI();
  }
  
  private static class b
  {
    public TextView a;
    public FlowLayoutLimitLine b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */