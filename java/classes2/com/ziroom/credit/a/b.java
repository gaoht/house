package com.ziroom.credit.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.s;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.R.style;
import com.ziroom.datacenter.remote.b.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.p.a;
import java.util.List;

public class b
  extends BaseAdapter
{
  public a a;
  private Context b;
  private List<p.a> c;
  
  public b(Context paramContext, List<p.a> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
  }
  
  private void a(String paramString)
  {
    com.ziroom.datacenter.remote.e.c.getAppeal((Activity)this.b, paramString, new a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        s.showToast("申诉成功");
        b.this.a.appealeSuccess();
      }
    });
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public SpannableStringBuilder getMyString(String paramString1, String paramString2, String paramString3)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString1);
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new TextAppearanceSpan(this.b, R.style.credit_item_credit_negative_record), 0, i, 33);
    localSpannableStringBuilder.append(" " + paramString2 + " ");
    if (paramString3 != null) {
      localSpannableStringBuilder.append(paramString3);
    }
    return localSpannableStringBuilder;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = LayoutInflater.from(this.b).inflate(R.layout.credit_item_negative_record, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(R.id.credit_tv_record_info));
      paramViewGroup.b = ((TextView)paramView.findViewById(R.id.credit_tv_record_time));
      paramViewGroup.c = ((TextView)paramView.findViewById(R.id.credit_tv_toappeal));
      paramView.setTag(paramViewGroup);
      paramViewGroup.c.setOnClickListener(null);
      i = ((p.a)this.c.get(paramInt)).getCanLitigation();
      if (i != 1) {
        break label233;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText("去申诉");
      paramViewGroup.c.setTextColor(Color.parseColor("#ffa000"));
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(final View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = ((p.a)b.a(b.this).get(paramInt)).getWorkOrder();
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(b.b(b.this)).setTitle("提示").setBtnConfirmText("去申诉").setContent("去申诉负面记录").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {
                b.a(b.this, paramAnonymousView);
              }
            }
          }).build().show();
        }
      });
    }
    for (;;)
    {
      paramViewGroup.a.setText(getMyString(((p.a)this.c.get(paramInt)).getResult(), "·", ((p.a)this.c.get(paramInt)).getDesc()));
      paramViewGroup.b.setText(((p.a)this.c.get(paramInt)).getDate());
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label233:
      if (i == 2)
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText("申诉中");
        paramViewGroup.c.setTextColor(Color.parseColor("#999999"));
      }
      else if (i == 3)
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText("申诉成功");
        paramViewGroup.c.setTextColor(Color.parseColor("#63D18B"));
      }
      else if (i == 4)
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText("申诉失败");
        paramViewGroup.c.setTextColor(Color.parseColor("#999999"));
      }
      else if (i == 5)
      {
        paramViewGroup.c.setVisibility(8);
      }
    }
  }
  
  public void setOnAppealStatusLiatener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void appealeFaliure();
    
    public abstract void appealeSuccess();
  }
  
  public class b
  {
    TextView a;
    TextView b;
    TextView c;
    
    public b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */