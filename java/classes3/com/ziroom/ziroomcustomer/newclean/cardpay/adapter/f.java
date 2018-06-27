package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanGiftCardActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.GiftCardLink;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.GiftCardList;
import com.ziroom.ziroomcustomer.util.ac;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

@com.maa.android.agent.instrumentation.Instrumented
public class f
  extends RecyclerView.a
{
  private Context a;
  private LinkedList<GiftCardList> b;
  private IWXAPI c;
  private GiftCardList d;
  private b e;
  private IntentFilter f;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
    this.c = WXAPIFactory.createWXAPI(this.a, "wxc2bae7e8ecb7d70b", false);
    this.c.registerApp("wxc2bae7e8ecb7d70b");
    this.e = new b();
    this.f = new IntentFilter();
    this.f.addAction("wx_share_result");
  }
  
  private void a(GiftCardLink paramGiftCardLink)
  {
    if (!this.c.isWXAppInstalled())
    {
      ((BaseActivity)this.a).showToast("请先安装微信客户端后再分享");
      return;
    }
    Object localObject = paramGiftCardLink.getUrl() + "?logicCode=" + paramGiftCardLink.getLogicCode() + "&sign=" + paramGiftCardLink.getSign() + "&timestamp=" + paramGiftCardLink.getTimestamp();
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    localWXWebpageObject.webpageUrl = ((String)localObject);
    localObject = new WXMediaMessage(localWXWebpageObject);
    ((WXMediaMessage)localObject).title = paramGiftCardLink.getShareTitle();
    ((WXMediaMessage)localObject).description = paramGiftCardLink.getShareContent();
    ((WXMediaMessage)localObject).setThumbImage(getBitmap(paramGiftCardLink.getShareUrl()));
    paramGiftCardLink = new SendMessageToWX.Req();
    paramGiftCardLink.transaction = (System.currentTimeMillis() + "");
    paramGiftCardLink.message = ((WXMediaMessage)localObject);
    this.c.sendReq(paramGiftCardLink);
  }
  
  private void a(String paramString)
  {
    n.getCleanGiftCardShapingLinks(this.a, paramString, new d(this.a, new com.ziroom.ziroomcustomer.e.c.f(GiftCardLink.class))
    {
      public void onSuccess(int paramAnonymousInt, GiftCardLink paramAnonymousGiftCardLink)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousGiftCardLink);
        f.b(f.this).registerReceiver(f.a(f.this), f.d(f.this));
        CleanGiftCardActivity localCleanGiftCardActivity = (CleanGiftCardActivity)f.b(f.this);
        if (localCleanGiftCardActivity != null) {
          localCleanGiftCardActivity.upDateView();
        }
        f.a(f.this, paramAnonymousGiftCardLink);
      }
    });
  }
  
  private void a(final String paramString1, String paramString2, final boolean paramBoolean)
  {
    n.ChangeCleanGiftCardStatus(this.a, paramString1, paramString2, new d(this.a, new com.ziroom.ziroomcustomer.e.c.f(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        if (paramBoolean)
        {
          paramAnonymousObject = (CleanGiftCardActivity)f.b(f.this);
          if (paramAnonymousObject != null) {
            ((CleanGiftCardActivity)paramAnonymousObject).upDateView();
          }
          return;
        }
        f.a(f.this, paramString1);
      }
    });
  }
  
  public Bitmap getBitmap(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        if (!(paramString instanceof URL))
        {
          paramString = paramString.openConnection();
          int i = ((HttpURLConnection)paramString).getContentLength();
          paramString.connect();
          localInputStream = paramString.getInputStream();
          localBufferedInputStream = new BufferedInputStream(localInputStream, i);
          paramString = BitmapFactory.decodeStream(localBufferedInputStream);
        }
      }
      catch (Exception localException1)
      {
        InputStream localInputStream;
        BufferedInputStream localBufferedInputStream;
        paramString = null;
      }
      try
      {
        localBufferedInputStream.close();
        localInputStream.close();
        return paramString;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      paramString = HttpInstrumentation.openConnection((URL)paramString);
    }
    localException1.printStackTrace();
    return paramString;
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    final GiftCardList localGiftCardList = (GiftCardList)this.b.get(paramInt);
    paramu = (a)paramu;
    if (localGiftCardList.getGiveState() == 1)
    {
      paramu.j.setVisibility(0);
      paramu.e.setTextColor(40960);
      paramu.b.setText("未赠送");
      paramu.f.setVisibility(8);
      paramu.a.setAlpha(1.0F);
      paramu.k.setBackgroundResource(2130837736);
      if (localGiftCardList.getCardState() > 2)
      {
        paramu.a.setAlpha(0.0F);
        paramu.b.setText("已失效");
        paramu.j.setVisibility(8);
        paramu.f.setVisibility(8);
        paramu.h.setVisibility(8);
        paramu.k.setBackgroundColor(12303291);
      }
      paramu.d.setText(localGiftCardList.getCardStyleNote());
      paramu.c.setText("¥" + (localGiftCardList.getTotalAmount() + localGiftCardList.getGiftCount()) / 100);
      paramu.h.setText(localGiftCardList.getReceiveNickName());
      paramu.b.setVisibility(0);
      if (!TextUtils.isEmpty(localGiftCardList.getReceiveHeadUrl())) {
        break label398;
      }
      paramu.f.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130840243));
    }
    for (;;)
    {
      paramu.a.setController(com.freelxl.baselibrary.f.c.frescoController(localGiftCardList.getCardStyleUrl()));
      paramu.e.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f.a(f.this, localGiftCardList);
          if (f.c(f.this).getGiveState() == 5)
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(f.b(f.this)).setTitle("提示").setBtnConfirmText("再次赠送").setContent("该礼品卡已被赠送给好友（好友还未领取），确认要再次赠送吗 ").setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean) {
                  f.a(f.this, f.1.this.a.getCardNumber());
                }
              }
            }).build().show();
            return;
          }
          f.a(f.this, f.c(f.this).getCardNumber(), "5", false);
        }
      });
      return;
      if (localGiftCardList.getGiveState() == 5)
      {
        paramu.j.setVisibility(0);
        paramu.e.setTextColor(-12303292);
        paramu.b.setText("已赠送／未领取");
        paramu.f.setVisibility(8);
        paramu.k.setBackgroundResource(2130837736);
        paramu.a.setAlpha(1.0F);
        break;
      }
      if (localGiftCardList.getGiveState() != 10) {
        break;
      }
      paramu.h.setVisibility(0);
      paramu.f.setVisibility(0);
      paramu.j.setVisibility(8);
      paramu.a.setAlpha(0.4F);
      paramu.b.setText("已领取");
      paramu.k.setBackgroundColor(-1061438533);
      break;
      label398:
      paramu.f.setController(com.freelxl.baselibrary.f.c.frescoController(localGiftCardList.getReceiveHeadUrl()));
    }
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.a).inflate(2130904163, paramViewGroup, false));
  }
  
  public void setData(LinkedList<GiftCardList> paramLinkedList)
  {
    this.b = paramLinkedList;
    notifyDataSetChanged();
  }
  
  private class a
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    SimpleDraweeView f;
    LinearLayout g;
    TextView h;
    CardView i;
    CardView j;
    TextView k;
    
    public a(View paramView)
    {
      super();
      this.a = ((SimpleDraweeView)paramView.findViewById(2131694925));
      this.b = ((TextView)paramView.findViewById(2131694927));
      this.c = ((TextView)paramView.findViewById(2131689846));
      this.h = ((TextView)paramView.findViewById(2131694929));
      this.d = ((TextView)paramView.findViewById(2131690084));
      this.e = ((TextView)paramView.findViewById(2131691257));
      this.f = ((SimpleDraweeView)paramView.findViewById(2131692685));
      this.g = ((LinearLayout)paramView.findViewById(2131694928));
      this.i = ((CardView)paramView.findViewById(2131693377));
      this.j = ((CardView)paramView.findViewById(2131694930));
      this.k = ((TextView)paramView.findViewById(2131694926));
      int m = (int)((ac.getScreenWidth(f.b(f.this)) - ab.dp2px(f.b(f.this), 40.0F)) * 1.0F / 335.0F * 210.0F);
      this.a.getLayoutParams().height = m;
      this.k.getLayoutParams().height = m;
      this.i.setRadius(ab.dp2px(f.b(f.this), 8.0F));
      this.j.setRadius(ab.dp2px(f.b(f.this), 19.0F));
      this.j.setCardElevation(ab.dp2px(f.b(f.this), 2.0F));
      this.i.setCardElevation(ab.dp2px(f.b(f.this), 6.0F));
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      f.b(f.this).unregisterReceiver(f.a(f.this));
      int i = paramIntent.getIntExtra("code", -1);
      int j = paramIntent.getIntExtra("type", -1);
      paramContext = "";
      paramIntent = paramContext;
      if (j == 2) {
        switch (i)
        {
        case -1: 
        default: 
          if (f.c(f.this).getGiveCount() == 0) {
            f.a(f.this, f.c(f.this).getCardNumber(), "1", true);
          }
          paramContext = "未知原因";
        }
      }
      for (;;)
      {
        f.a(f.this, null);
        paramIntent = paramContext;
        g.textToast(f.b(f.this), paramIntent);
        return;
        paramIntent = "取消分享";
        paramContext = paramIntent;
        if (f.c(f.this).getGiveCount() == 0)
        {
          f.a(f.this, f.c(f.this).getCardNumber(), "1", true);
          paramContext = paramIntent;
          continue;
          paramIntent = "分享失败";
          paramContext = paramIntent;
          if (f.c(f.this).getGiveCount() == 0)
          {
            f.a(f.this, f.c(f.this).getCardNumber(), "1", true);
            paramContext = paramIntent;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */