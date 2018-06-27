package com.ziroom.ziroomcustomer.social.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.social.model.e;
import com.ziroom.ziroomcustomer.social.model.e.a;
import com.ziroom.ziroomcustomer.social.model.l;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class a
  extends RecyclerView.a<b>
{
  private int a = Color.parseColor("#444444");
  private int b = Color.parseColor("#666666");
  private int c = Color.parseColor("#999999");
  private int d = Color.parseColor("#FB303E");
  private int e = Color.parseColor("#FFA000");
  private Context f;
  private List<e> g;
  private a h;
  
  public a(Context paramContext, List<e> paramList)
  {
    this.f = paramContext;
    this.g = paramList;
  }
  
  private void a(final String paramString)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.f).setTitle("提示").setContent("请假超过2次会影响活动信用，不利于报名其他活动；且请假后不能再次报名参加活动\n是否确认请假这次活动").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          j.acEnrollAskForLeave(a.a(a.this), paramString, new com.ziroom.ziroomcustomer.e.a.f(a.a(a.this), new com.ziroom.ziroomcustomer.e.c.f(String.class))
          {
            public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
            {
              super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
              g.textToast(a.a(a.this), "请假成功！");
              if (a.b(a.this) != null) {
                a.b(a.this).refresh();
              }
            }
          });
        }
      }
    }).build().show();
  }
  
  private void b(final String paramString)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.f).setTitle("提示").setContent("取消报名后不能再次报名，是否确认取消").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          j.acEnrollCancel(a.a(a.this), paramString, new com.ziroom.ziroomcustomer.e.a.f(a.a(a.this), new com.ziroom.ziroomcustomer.e.c.f(String.class))
          {
            public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
            {
              super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
              g.textToast(a.a(a.this), "取消报名成功！");
              if (a.b(a.this) != null) {
                a.b(a.this).refresh();
              }
            }
          });
        }
      }
    }).build().show();
  }
  
  private void c(String paramString)
  {
    com.ziroom.ziroomcustomer.social.view.a.newBuilder(this.f).setTitle("活动微信群二维码").setCodeUrl(paramString).build().show();
  }
  
  private void d(String paramString)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    JsBridgeWebActivity.start(this.f, "", paramString);
  }
  
  public int getItemCount()
  {
    if (this.g == null) {
      return 0;
    }
    return this.g.size();
  }
  
  public void onBindViewHolder(b paramb, int paramInt)
  {
    final e locale = (e)this.g.get(paramInt);
    if (locale == null) {
      return;
    }
    final e.a locala = locale.getApp_show();
    paramb.a.setText(locale.getTitle());
    paramb.b.setText(locale.getShow_time());
    String str1;
    String str2;
    if (locala != null)
    {
      str1 = locala.getType();
      if ((!"2".equals(str1)) || (ae.isNull(locala.getButton_2()))) {
        break label355;
      }
      paramb.f.setVisibility(0);
      paramb.f.setText(locala.getButton_2());
      paramb.f.setTextColor(this.b);
      paramb.f.setBackgroundResource(2130837956);
      paramb.f.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          a.a(a.this, locale.getActivity_code());
        }
      });
      if (!TextUtils.isEmpty(locala.getStatus()))
      {
        str2 = locala.getStatus();
        if (!"报名通过".equals(str2)) {
          break label450;
        }
        paramb.c.setTextColor(this.e);
      }
      label175:
      paramb.c.setText(locala.getStatus());
      if (TextUtils.isEmpty(locala.getButton())) {
        break label640;
      }
      paramb.e.setVisibility(0);
      paramb.e.setText(locala.getButton());
      if (!"取消报名".equals(locala.getButton())) {
        break label514;
      }
      paramb.e.setTextColor(this.b);
      paramb.e.setBackgroundResource(2130837956);
      label252:
      if (!TextUtils.isEmpty(str1))
      {
        if (!"1".equals(str1)) {
          break label538;
        }
        paramb.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            a.c(a.this, locale.getActivity_code());
          }
        });
      }
    }
    label287:
    if (!TextUtils.isEmpty(locale.getRefusal_reason()))
    {
      paramb.d.setVisibility(0);
      paramb.d.setText(locale.getRefusal_reason());
    }
    for (;;)
    {
      paramb.g.setController(com.freelxl.baselibrary.f.c.frescoController(x.makeUrl(locale.getCover_pic(), 0.5F)));
      if (!TextUtils.isEmpty(locale.getDetail_url())) {
        break label664;
      }
      paramb.itemView.setOnClickListener(null);
      return;
      label355:
      if (("3".equals(str1)) && (!ae.isNull(locala.getButton())))
      {
        paramb.f.setVisibility(0);
        paramb.f.setText(locala.getButton());
        paramb.f.setTextColor(this.e);
        paramb.f.setBackgroundResource(2130837965);
        paramb.f.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            a.b(a.this, locala.getUrl());
          }
        });
        break;
      }
      paramb.f.setVisibility(8);
      break;
      label450:
      if ("报名失败".equals(str2))
      {
        paramb.c.setTextColor(this.d);
        break label175;
      }
      if ("已关闭".equals(str2))
      {
        paramb.c.setTextColor(this.a);
        break label175;
      }
      paramb.c.setTextColor(this.c);
      break label175;
      label514:
      paramb.e.setTextColor(this.e);
      paramb.e.setBackgroundResource(2130837965);
      break label252;
      label538:
      if ("2".equals(str1))
      {
        paramb.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            a.d(a.this, locale.getErcode());
          }
        });
        break label287;
      }
      if ("3".equals(str1))
      {
        paramb.e.setTextColor(this.b);
        paramb.e.setBackgroundResource(2130837956);
        paramb.e.setText(locala.getButton_2());
        paramb.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            a.b(a.this, locale.getApp_show().getUrl_2());
          }
        });
        break label287;
      }
      paramb.e.setOnClickListener(null);
      break label287;
      label640:
      paramb.e.setVisibility(8);
      break label287;
      paramb.d.setVisibility(8);
    }
    label664:
    paramb.itemView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (locale.getShare_info() != null)
        {
          JsBridgeWebActivity.start(a.a(a.this), "", locale.getDetail_url(), true, locale.getShare_info().getContent(), locale.getShare_info().getImage(), false, false);
          return;
        }
        JsBridgeWebActivity.start(a.a(a.this), "", locale.getDetail_url(), false, "", "", false, true);
      }
    });
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.f).inflate(2130904115, null, false));
  }
  
  public void setRefreshListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void refresh();
  }
  
  public class b
    extends RecyclerView.u
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    Button e;
    Button f;
    SimpleDraweeView g;
    
    public b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131690049));
      this.b = ((TextView)paramView.findViewById(2131689852));
      this.c = ((TextView)paramView.findViewById(2131689822));
      this.d = ((TextView)paramView.findViewById(2131693107));
      this.e = ((Button)paramView.findViewById(2131690043));
      this.f = ((Button)paramView.findViewById(2131694811));
      this.g = ((SimpleDraweeView)paramView.findViewById(2131691098));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */