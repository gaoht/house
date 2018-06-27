package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;

public class SearchBar
  extends LinearLayout
{
  private Context a;
  private final int b = Color.parseColor("#ffa000");
  private final int c = Color.parseColor("#000000");
  private final int d = Color.parseColor("#d8d8d8");
  private int e;
  private int f;
  private int g;
  private int h;
  private List<LinearLayout> i = new ArrayList();
  
  public SearchBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SearchBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public SearchBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private View.OnClickListener a(final TextView paramTextView, final a parama)
  {
    new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        VdsAgent.onClick(this, paramAnonymousView);
        boolean bool3 = paramTextView.isSelected();
        if (parama != null)
        {
          SearchBar.a locala = parama;
          if (!bool3)
          {
            bool1 = true;
            locala.onSearchItemClick(paramAnonymousView, bool1);
          }
        }
        else
        {
          paramAnonymousView = paramTextView;
          if (bool3) {
            break label68;
          }
        }
        label68:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          paramAnonymousView.setSelected(bool1);
          return;
          bool1 = false;
          break;
        }
      }
    };
  }
  
  private LinearLayout a(String paramString, a parama, Boolean paramBoolean)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    Object localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    localObject = new TextView(this.a);
    ((TextView)localObject).setId(2131689508);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, this.g, 0);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setSingleLine(true);
    ((TextView)localObject).setLines(1);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setTextSize(12.0F);
    if (paramBoolean.booleanValue()) {
      ((TextView)localObject).setTextColor(this.b);
    }
    for (;;)
    {
      ((TextView)localObject).setCompoundDrawablePadding(this.g);
      paramString = getResources().getDrawable(2130837621);
      paramString.setBounds(0, 0, this.g, this.f);
      ((TextView)localObject).setCompoundDrawables(null, null, paramString, null);
      localLinearLayout.addView((View)localObject);
      localLinearLayout.setOnClickListener(a((TextView)localObject, parama));
      return localLinearLayout;
      ((TextView)localObject).setTextColor(this.c);
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setOrientation(0);
    paramContext = this.a.getResources().getDisplayMetrics();
    this.e = ((int)(paramContext.density * 1.0F));
    this.f = ((int)(paramContext.density * 5.0F));
    this.g = ((int)(paramContext.density * 8.0F));
    this.h = ((int)(paramContext.density * 12.0F));
  }
  
  public void addItem(int paramInt, String paramString, a parama, Boolean paramBoolean)
  {
    paramString = a(paramString, parama, paramBoolean);
    this.i.add(paramInt, paramString);
    addView(paramString, paramInt);
    if (paramInt < this.i.size() - 1)
    {
      paramString = new View(this.a);
      parama = new LinearLayout.LayoutParams(this.e, -1);
      parama.setMargins(0, this.h, 0, this.h);
      paramString.setLayoutParams(parama);
      addView(paramString);
    }
  }
  
  public void setData(List<String> paramList, List<a> paramList1, List<Boolean> paramList2)
  {
    removeAllViews();
    int j;
    String str;
    if ((paramList != null) && (paramList.size() > 0))
    {
      j = 0;
      if (j < paramList.size())
      {
        str = (String)paramList.get(j);
        if ((paramList1 == null) || (paramList1.size() <= j)) {
          break label226;
        }
      }
    }
    label226:
    for (Object localObject1 = (a)paramList1.get(j);; localObject1 = null)
    {
      if ((paramList2 != null) && (paramList2.size() > j)) {}
      for (Object localObject2 = (Boolean)paramList2.get(j);; localObject2 = Boolean.valueOf(false))
      {
        localObject1 = a(str, (a)localObject1, (Boolean)localObject2);
        this.i.add(localObject1);
        addView((View)localObject1);
        if (j < paramList.size() - 1)
        {
          localObject1 = new View(this.a);
          localObject2 = new LinearLayout.LayoutParams(this.e, -1);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, this.h, 0, this.h);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setBackgroundColor(this.d);
          addView((View)localObject1);
        }
        j += 1;
        break;
        return;
      }
    }
  }
  
  public void setItem(int paramInt, String paramString, a parama, Boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    TextView localTextView;
    if (paramInt < this.i.size())
    {
      localLinearLayout = (LinearLayout)this.i.get(paramInt);
      localTextView = (TextView)localLinearLayout.findViewById(2131689508);
      localTextView.setText(paramString);
      if (!paramBoolean.booleanValue()) {
        break label89;
      }
      localTextView.setTextColor(this.b);
    }
    for (;;)
    {
      localLinearLayout.setTag(Boolean.valueOf(false));
      localLinearLayout.setOnClickListener(a(localTextView, parama));
      invalidate();
      return;
      label89:
      localTextView.setTextColor(this.c);
    }
  }
  
  public void setItemSelectStatus(int paramInt, boolean paramBoolean)
  {
    if (paramInt < this.i.size())
    {
      TextView localTextView = (TextView)((LinearLayout)this.i.get(paramInt)).findViewById(2131689508);
      if (localTextView != null) {
        localTextView.setSelected(paramBoolean);
      }
    }
  }
  
  public void updateItem(int paramInt, Boolean paramBoolean)
  {
    TextView localTextView;
    if (paramInt < this.i.size())
    {
      localTextView = (TextView)((LinearLayout)this.i.get(paramInt)).findViewById(2131689508);
      if (!paramBoolean.booleanValue()) {
        break label55;
      }
      localTextView.setTextColor(this.b);
    }
    for (;;)
    {
      invalidate();
      return;
      label55:
      localTextView.setTextColor(this.c);
    }
  }
  
  public void updateItem(int paramInt, String paramString, Boolean paramBoolean)
  {
    TextView localTextView;
    if (paramInt < this.i.size())
    {
      localTextView = (TextView)((LinearLayout)this.i.get(paramInt)).findViewById(2131689508);
      localTextView.setText(paramString);
      if (!paramBoolean.booleanValue()) {
        break label63;
      }
      localTextView.setTextColor(this.b);
    }
    for (;;)
    {
      invalidate();
      return;
      label63:
      localTextView.setTextColor(this.c);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onSearchItemClick(View paramView, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SearchBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */