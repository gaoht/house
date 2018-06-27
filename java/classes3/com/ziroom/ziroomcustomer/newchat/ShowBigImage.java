package com.ziroom.ziroomcustomer.newchat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.util.ImageUtils;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class ShowBigImage
  extends Activity
{
  private ProgressDialog a;
  private ImageView b;
  private int c = 2130838350;
  private String d;
  private Bitmap e;
  private boolean f;
  private ProgressBar g;
  private String h;
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    this.a = new ProgressDialog(this);
    this.a.setProgressStyle(0);
    this.a.setCanceledOnTouchOutside(false);
    this.a.setMessage(getResources().getString(2131296762));
    paramMap = this.a;
    if (!(paramMap instanceof ProgressDialog)) {
      paramMap.show();
    }
    for (;;)
    {
      this.d = paramString;
      paramString = new File(this.d);
      paramString = new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          Log.e("###", "offline file transfer error:" + paramAnonymousString);
          paramAnonymousString = new File(ShowBigImage.a(ShowBigImage.this));
          if ((paramAnonymousString.exists()) && (paramAnonymousString.isFile())) {
            paramAnonymousString.delete();
          }
          ShowBigImage.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              ShowBigImage.d(ShowBigImage.this).dismiss();
            }
          });
        }
        
        public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
        {
          ShowBigImage.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              ShowBigImage.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  ShowBigImage.d(ShowBigImage.this).setMessage(ShowBigImage.this.getResources().getString(2131296763) + ShowBigImage.2.3.this.a + "%");
                }
              });
            }
          });
        }
        
        public void onSuccess()
        {
          ShowBigImage.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              new File(ShowBigImage.2.this.a).renameTo(new File(ShowBigImage.a(ShowBigImage.this)));
              DisplayMetrics localDisplayMetrics = new DisplayMetrics();
              ShowBigImage.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
              int i = localDisplayMetrics.widthPixels;
              int j = localDisplayMetrics.heightPixels;
              ShowBigImage.a(ShowBigImage.this, ImageUtils.decodeScaleImage(ShowBigImage.a(ShowBigImage.this), i, j));
              if (ShowBigImage.b(ShowBigImage.this) == null) {}
              for (;;)
              {
                if (ShowBigImage.d(ShowBigImage.this) != null) {
                  ShowBigImage.d(ShowBigImage.this).dismiss();
                }
                return;
                ShowBigImage.c(ShowBigImage.this).setImageBitmap(ShowBigImage.b(ShowBigImage.this));
                g.getInstance().put(ShowBigImage.a(ShowBigImage.this), ShowBigImage.b(ShowBigImage.this));
                ShowBigImage.a(ShowBigImage.this, true);
              }
            }
          });
        }
      };
      paramMap = EMClient.getInstance().chatManager().getMessage(this.h);
      paramMap.setMessageStatusCallback(paramString);
      d.e("hhjkh", "downloadAttachement");
      EMClient.getInstance().chatManager().downloadAttachment(paramMap);
      return;
      VdsAgent.showDialog((ProgressDialog)paramMap);
    }
  }
  
  public String getLocalFilePath(String paramString)
  {
    if (paramString.contains("/")) {
      return PathUtil.getInstance().getImagePath().getAbsolutePath() + "/" + paramString.substring(paramString.lastIndexOf("/") + 1);
    }
    return PathUtil.getInstance().getImagePath().getAbsolutePath() + "/" + paramString;
  }
  
  public void onBackPressed()
  {
    if (this.f) {
      setResult(-1);
    }
    finish();
  }
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(12);
    setContentView(2130903496);
    this.b = ((ImageView)findViewById(2131689700));
    this.g = ((ProgressBar)findViewById(2131692408));
    paramBundle = (Uri)getIntent().getParcelableExtra("uri");
    Object localObject = getIntent().getExtras().getString("remotepath");
    String str = getIntent().getExtras().getString("secret");
    System.err.println("show big image uri:" + paramBundle + " remotepath:" + (String)localObject);
    this.h = getIntent().getStringExtra("messageId");
    if (localObject != null)
    {
      u.d("dskjglkdf", "=======  big下载 从远程 222");
      System.err.println("download remote image");
      paramBundle = new HashMap();
      if (!TextUtils.isEmpty(str)) {
        paramBundle.put("share-secret", str);
      }
      a((String)localObject, paramBundle);
    }
    for (;;)
    {
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ShowBigImage.this.finish();
        }
      });
      return;
      if ((paramBundle != null) && (new File(paramBundle.getPath()).exists()))
      {
        u.d("dskjglkdf", "=======  big下载 加载本地 222");
        System.err.println("showbigimage file exists. directly show it");
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        this.e = g.getInstance().get(paramBundle.getPath());
        if (this.e == null)
        {
          paramBundle = new j(this, paramBundle.getPath(), this.b, this.g, 640, 960);
          if (Build.VERSION.SDK_INT > 10) {
            paramBundle.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
          } else {
            paramBundle.execute(new Void[0]);
          }
        }
        else
        {
          this.b.setImageBitmap(this.e);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/ShowBigImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */