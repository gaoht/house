package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ImageView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.ziroom.commonlibrary.f.a;
import com.ziroom.threelib.ziroomshare.c;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.morepage.MoreItemView;
import com.ziroom.ziroomcustomer.morepage.MoreItemView.b;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.d;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ZiRuWebViewActivity
  extends BaseActivity
  implements PlatformActionListener
{
  private MoreItemView a;
  private Context b;
  private ImageView c;
  private String d;
  private String e;
  private String f;
  
  private void a()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ZiRuWebViewActivity.a(ZiRuWebViewActivity.this) != null)
        {
          a.getInstance().shareFromCenter((FragmentActivity)ZiRuWebViewActivity.b(ZiRuWebViewActivity.this), ZiRuWebViewActivity.a(ZiRuWebViewActivity.this), "自如这个活动不错 ", ZiRuWebViewActivity.c(ZiRuWebViewActivity.this), ZiRuWebViewActivity.d(ZiRuWebViewActivity.this));
          return;
        }
        g.textToast(ZiRuWebViewActivity.b(ZiRuWebViewActivity.this), "房源尚未加载完成", 0);
      }
    });
  }
  
  public void initView()
  {
    Intent localIntent = getIntent();
    String str = getIntent().getStringExtra("ziru");
    u.e("url", this.d);
    if (str.equals("ziruApartment"))
    {
      this.d = "http://m.ziroomapartment.com/";
      this.e = "自如寓";
      this.f = localIntent.getStringExtra("pic");
      this.c = ((ImageView)findViewById(2131691042));
      this.a = ((MoreItemView)findViewById(2131692134));
      this.a.setTitle("自如寓");
      u.e("url", this.d);
      this.a.setWeb(this.d);
      this.a.setBack(new MoreItemView.b()
      {
        public void backtoActivity()
        {
          ZiRuWebViewActivity.this.finish();
        }
      });
    }
    do
    {
      return;
      if (str.equals("ziruviewpager"))
      {
        this.d = "http://www.ziroom.com/zhuanti/pdhhuigu/";
        this.d = localIntent.getStringExtra("url");
        this.e = localIntent.getStringExtra("title");
        this.f = localIntent.getStringExtra("pic");
        this.c = ((ImageView)findViewById(2131691042));
        u.e("url", this.d);
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle(this.e);
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziruviewpager"))
      {
        this.d = "http://www.ziroom.com/zhuanti/pdhhuigu/";
        this.d = localIntent.getStringExtra("url");
        this.e = localIntent.getStringExtra("title");
        this.f = localIntent.getStringExtra("pic");
        this.c = ((ImageView)findViewById(2131691042));
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle(this.e);
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziruke"))
      {
        this.d = "http://www.ziroom.com/zhuanti/zrzk/index.html";
        this.e = "自如客";
        this.f = localIntent.getStringExtra("pic");
        this.c = ((ImageView)findViewById(2131691042));
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle("自如客");
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziruClub"))
      {
        this.d = "http://www.ziroom.com/zhuanti/pdhhuigu/";
        this.e = "自如俱乐部";
        this.f = localIntent.getStringExtra("pic");
        this.c = ((ImageView)findViewById(2131691042));
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle("自如俱乐部");
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziruviewpager"))
      {
        this.d = "http://www.ziroom.com/zhuanti/pdhhuigu/";
        this.d = localIntent.getStringExtra("url");
        this.e = localIntent.getStringExtra("title");
        this.f = localIntent.getStringExtra("pic");
        this.c = ((ImageView)findViewById(2131691042));
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle(this.e);
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziruNew"))
      {
        this.a = ((MoreItemView)findViewById(2131692134));
        this.d = "http://www.ziroom.com/ziroomer/news/";
        this.a.setTitle("自如NEWS");
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("zirujoin"))
      {
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle("自如活动");
        if ((!"".equals(this.e)) && (this.e != null)) {
          this.e = localIntent.getStringExtra("title");
        }
        this.d = localIntent.getStringExtra("url");
        this.f = localIntent.getStringExtra("pic");
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("howtocharge"))
      {
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle("智能锁使用说明");
        this.d = localIntent.getStringExtra("url");
        this.c = ((ImageView)findViewById(2131691042));
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziruyuLifePage"))
      {
        this.d = "http://m.ziroomapartment.com/zra_mst/BJ/community/toActiveList.action";
        this.c = ((ImageView)findViewById(2131691042));
        this.c.setVisibility(8);
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle("社区活动");
        u.e("url", this.d);
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("upin"))
      {
        this.a = ((MoreItemView)findViewById(2131692134));
        this.c = ((ImageView)findViewById(2131691042));
        this.d = localIntent.getStringExtra("url");
        this.f = localIntent.getStringExtra("pic");
        this.a.setWeb(this.d);
        this.a.setTitle("自如优品");
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("ziroomupin"))
      {
        if ((!"".equals(this.e)) && (this.e != null)) {
          this.e = localIntent.getStringExtra("title");
        }
        this.d = localIntent.getStringExtra("url");
        this.f = localIntent.getStringExtra("pic");
        this.c = ((ImageView)findViewById(2131691042));
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setTitle("自如优品");
        this.a.setWeb(this.d);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("mystory"))
      {
        this.e = localIntent.getStringExtra("title");
        this.d = localIntent.getStringExtra("url");
        this.c = ((ImageView)findViewById(2131691042));
        this.c.setVisibility(8);
        this.a = ((MoreItemView)findViewById(2131692134));
        if (TextUtils.isEmpty(this.e)) {
          this.a.setTitle("我的自如生活手记");
        }
        for (;;)
        {
          this.a.setWeb(this.d);
          this.a.setBack(new MoreItemView.b()
          {
            public void backtoActivity()
            {
              ZiRuWebViewActivity.this.finish();
            }
          });
          return;
          this.a.setTitle(this.e);
        }
      }
      if (str.equals("houseinfo_correct"))
      {
        this.e = "房源纠错";
        this.d = "http://form.mikecrm.com/vDly14";
        this.c = ((ImageView)findViewById(2131691042));
        this.c.setVisibility(8);
        this.a = ((MoreItemView)findViewById(2131692134));
        this.a.setWeb(this.d);
        this.a.setTitle(this.e);
        this.a.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuWebViewActivity.this.finish();
          }
        });
        return;
      }
    } while (!str.equals("houseinfo_nc"));
    this.e = localIntent.getStringExtra("title");
    if (TextUtils.isEmpty(this.e)) {
      this.e = "自如";
    }
    this.d = getIntent().getStringExtra("url");
    this.c = ((ImageView)findViewById(2131691042));
    this.c.setVisibility(8);
    this.a = ((MoreItemView)findViewById(2131692134));
    this.a.setWeb(this.d);
    this.a.setTitle(this.e);
    this.a.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        ZiRuWebViewActivity.this.finish();
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d locald;
    Uri localUri;
    if (paramInt1 == 1)
    {
      locald = this.a.getOpenFileWebChromeClient();
      if (locald.a != null)
      {
        if ((paramIntent != null) && (paramInt2 == -1)) {
          break label139;
        }
        localUri = null;
        if (localUri == null) {
          break label148;
        }
        localUri = Uri.fromFile(new File(ah.getImageAbsolutePath(this, localUri)));
        locald.a.onReceiveValue(localUri);
      }
      label69:
      if (locald.b != null)
      {
        if ((paramIntent != null) && (paramInt2 == -1)) {
          break label162;
        }
        paramIntent = null;
        label88:
        if (paramIntent == null) {
          break label170;
        }
        paramIntent = Uri.fromFile(new File(ah.getImageAbsolutePath(this, paramIntent)));
        locald.b.onReceiveValue(new Uri[] { paramIntent });
      }
    }
    for (;;)
    {
      locald.a = null;
      locald.b = null;
      return;
      label139:
      localUri = paramIntent.getData();
      break;
      label148:
      locald.a.onReceiveValue(null);
      break label69;
      label162:
      paramIntent = paramIntent.getData();
      break label88;
      label170:
      locald.b.onReceiveValue(null);
    }
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    new Message();
    showToast("分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905246);
    this.b = this;
    MobSDK.init(this.b);
    initView();
    a();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    showToast("分享失败");
    if ("SinaWeibo".equals(paramPlatform.getName()))
    {
      ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
      ShareSDK.removeCookieOnAuthorize(true);
    }
  }
  
  protected void onPause()
  {
    if ((this.a != null) && (this.a.getWebView() != null)) {
      this.a.getWebView().reload();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if ((this.a != null) && (this.a.getWebView() != null)) {
        this.a.getWebView().getClass().getMethod("onResume", new Class[0]).invoke(this.a.getWebView(), (Object[])null);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/ZiRuWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */