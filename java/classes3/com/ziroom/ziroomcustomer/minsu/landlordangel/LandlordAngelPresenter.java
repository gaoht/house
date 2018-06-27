package com.ziroom.ziroomcustomer.minsu.landlordangel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.c;
import com.ziroom.ziroomcustomer.model.sojourn.AngelLandlordHome;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity.a;
import java.util.Iterator;
import java.util.List;

public class LandlordAngelPresenter
  extends c
  implements b.a
{
  b.b a = (b.b)getView();
  private int b;
  private int c;
  
  public LandlordAngelPresenter(b.b paramb)
  {
    super(paramb);
    if (this.a != null)
    {
      this.a.setPresenter(this);
      this.b = n.dip2px(this.a.getViewContext(), 18.0F);
      this.c = n.dip2px(this.a.getViewContext(), 21.0F);
    }
  }
  
  private void a(Context paramContext, List<String> paramList, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    if (s.isEmpty(paramList)) {
      paramLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      return;
      paramLinearLayout.setVisibility(0);
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, this.b, this.c);
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        paramTextView = new TextView(paramContext);
        paramTextView.setText((CharSequence)localObject);
        paramTextView.setTag(Boolean.valueOf(false));
        paramTextView.setTextColor(paramContext.getResources().getColor(2131624081));
        paramTextView.setTextSize(12.0F);
        paramTextView.setIncludeFontPadding(false);
        paramTextView.setGravity(16);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(this.b, 0, this.b, this.b);
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramLinearLayout.addView(paramTextView);
      }
    }
  }
  
  public void start()
  {
    com.ziroom.ziroomcustomer.minsu.e.b.requestLandlordAngel(this.a.getViewContext(), new com.ziroom.ziroomcustomer.minsu.landlord.d.a(this.a.getViewContext(), new com.ziroom.ziroomcustomer.minsu.landlord.d.b(AngelLandlordHome.class))
    {
      public void onSuccess(int paramAnonymousInt, final AngelLandlordHome paramAnonymousAngelLandlordHome)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousAngelLandlordHome);
        final b.b localb;
        TextView localTextView1;
        TextView localTextView2;
        TextView localTextView3;
        Object localObject1;
        LinearLayout localLinearLayout;
        RecyclerView localRecyclerView;
        RelativeLayout localRelativeLayout;
        if (paramAnonymousAngelLandlordHome != null)
        {
          localb = (b.b)LandlordAngelPresenter.this.getView();
          if ((localb != null) && (localb.isActive()))
          {
            localTextView1 = localb.gettTvLandlordArrowright();
            localTextView2 = localb.getTvLandlordTime();
            localTextView3 = localb.getTvLandlordDescribe();
            localObject1 = localb.getTvLandlordTitle();
            localLinearLayout = localb.getLlLandlordPre();
            localRecyclerView = localb.getRecyclerview();
            localRelativeLayout = localb.getRlLandlordPre();
            ((TextView)localObject1).setText(paramAnonymousAngelLandlordHome.getMainTitle());
            if (paramAnonymousAngelLandlordHome.getSubtitle() != null) {
              break label227;
            }
            localObject1 = "";
            if (paramAnonymousAngelLandlordHome.getGuideTitle() != null) {
              break label235;
            }
          }
        }
        label227:
        label235:
        for (Object localObject2 = "";; localObject2 = paramAnonymousAngelLandlordHome.getGuideTitle())
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label244;
          }
          localTextView3.setText((String)localObject1 + (String)localObject2);
          localTextView2.setText(paramAnonymousAngelLandlordHome.getFooterTitle());
          localObject1 = paramAnonymousAngelLandlordHome.getTargetList();
          ((a)localRecyclerView.getAdapter()).setData((List)localObject1);
          localObject1 = paramAnonymousAngelLandlordHome.getPrivilegeMsgList();
          LandlordAngelPresenter.a(LandlordAngelPresenter.this, localb.getViewContext(), (List)localObject1, localLinearLayout, localTextView1);
          localRelativeLayout.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              new JsBridgeWebActivity.a(localb.getViewContext(), paramAnonymousAngelLandlordHome.getPrivilegeUrl()).title("天使房东特权").backMain(false).mainType(2).starJsBridgeActivity();
            }
          });
          return;
          localObject1 = paramAnonymousAngelLandlordHome.getSubtitle();
          break;
        }
        label244:
        if (paramAnonymousAngelLandlordHome.getGuideUrl() == null) {}
        for (String str = "";; str = paramAnonymousAngelLandlordHome.getGuideUrl())
        {
          localObject2 = new SpannableString((String)localObject1 + (String)localObject2);
          ((SpannableString)localObject2).setSpan(new LandlordAngelPresenter.MyURLSpan(LandlordAngelPresenter.this, str), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#FF961E")), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
          localTextView3.setMovementMethod(LinkMovementMethod.getInstance());
          localTextView3.setText((CharSequence)localObject2);
          break;
        }
      }
    });
  }
  
  private class MyURLSpan
    extends URLSpan
  {
    private String b;
    
    public MyURLSpan(String paramString)
    {
      super();
      this.b = paramString;
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      JsBridgeWebActivity.start(paramView.getContext(), "", this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordangel/LandlordAngelPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */