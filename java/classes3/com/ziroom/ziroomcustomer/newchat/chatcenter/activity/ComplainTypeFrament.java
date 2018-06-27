package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.u;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.b;
import com.ziroom.ziroomcustomer.newchat.chatcenter.d;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.MyListView;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.MyViewPaper;
import java.util.Iterator;
import java.util.List;

public class ComplainTypeFrament
  extends BaseFragment
{
  Context a;
  d b;
  b c;
  List<b> d;
  c e;
  MyViewPaper f;
  int g = 0;
  private MyListView h;
  
  public ComplainTypeFrament(d paramd, MyViewPaper paramMyViewPaper, int paramInt)
  {
    this.b = paramd;
    this.f = paramMyViewPaper;
    this.g = paramInt;
  }
  
  private void a(View paramView)
  {
    this.h = ((MyListView)paramView.findViewById(2131691217));
    b(this.b.getId());
    this.c = new b();
    this.h.setAdapter(this.c);
    this.f.setObjectForPosition(this.h, this.g);
  }
  
  private void b(String paramString)
  {
    n.getSugChildTypeList(this.a, paramString, new h(this.a, new u(b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<b> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        ComplainTypeFrament.this.d = paramAnonymousList;
        ComplainTypeFrament.this.c.notifyDataSetChanged();
      }
    });
  }
  
  private SpannableStringBuilder c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    paramString = new SpannableStringBuilder(localStringBuilder);
    paramString.setSpan(new ForegroundColorSpan(-16777216), 0, 5, 34);
    paramString.setSpan(new AbsoluteSizeSpan(sp2px(12.0F)), 0, 5, 34);
    return paramString;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getContext();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(getActivity(), 2130904656, null);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    this.f.resetHeight();
    if (this.b != null) {
      b(this.b.getId());
    }
  }
  
  public void setmOnChecked(c paramc)
  {
    this.e = paramc;
  }
  
  public int sp2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public class a
  {
    public RadioButton a;
    public TextView b;
    
    public a() {}
  }
  
  class b
    extends BaseAdapter
  {
    b() {}
    
    public int getCount()
    {
      if (ComplainTypeFrament.this.d == null) {
        return 0;
      }
      return ComplainTypeFrament.this.d.size();
    }
    
    public Object getItem(int paramInt)
    {
      return ComplainTypeFrament.this.d.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(ComplainTypeFrament.this.a, 2130904144, null);
        paramViewGroup = new ComplainTypeFrament.a(ComplainTypeFrament.this);
        paramViewGroup.a = ((RadioButton)paramView.findViewById(2131694882));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690084));
        Object localObject = ComplainTypeFrament.this.getResources().getDrawable(2130839285);
        ((Drawable)localObject).setBounds(0, 0, ComplainTypeFrament.this.sp2px(20.0F), ComplainTypeFrament.this.sp2px(20.0F));
        paramViewGroup.a.setCompoundDrawables((Drawable)localObject, null, null, null);
        paramViewGroup.a.setCompoundDrawablePadding(ComplainTypeFrament.this.sp2px(6.0F));
        paramViewGroup.a.setTag(paramViewGroup.b);
        paramView.setTag(paramViewGroup);
        localObject = (b)ComplainTypeFrament.this.d.get(paramInt);
        paramViewGroup.a.setText(((b)localObject).getValue());
        if (!((b)localObject).getChecked().booleanValue()) {
          break label285;
        }
        paramViewGroup.a.setChecked(true);
        if (TextUtils.isEmpty(((b)localObject).getScheme())) {
          break label273;
        }
        paramViewGroup.b.setText(ComplainTypeFrament.a(ComplainTypeFrament.this, "解决方案：" + ((b)localObject).getScheme()));
        paramViewGroup.b.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = ComplainTypeFrament.this.d.iterator();
            while (paramAnonymousView.hasNext()) {
              ((b)paramAnonymousView.next()).setChecked(Boolean.valueOf(false));
            }
            ((b)ComplainTypeFrament.this.d.get(paramInt)).setChecked(Boolean.valueOf(true));
            if (ComplainTypeFrament.this.e != null) {
              ComplainTypeFrament.this.e.onChecked(ComplainTypeFrament.this.b.getKey(), ((b)ComplainTypeFrament.this.d.get(paramInt)).getKey());
            }
            ComplainTypeFrament.b.this.notifyDataSetChanged();
          }
        });
        return paramView;
        paramViewGroup = (ComplainTypeFrament.a)paramView.getTag();
        break;
        label273:
        paramViewGroup.b.setVisibility(8);
        continue;
        label285:
        paramViewGroup.a.setChecked(false);
        paramViewGroup.b.setVisibility(8);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onChecked(String paramString1, String paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ComplainTypeFrament.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */