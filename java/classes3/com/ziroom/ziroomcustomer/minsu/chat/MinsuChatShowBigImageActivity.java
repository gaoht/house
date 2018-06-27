package com.ziroom.ziroomcustomer.minsu.chat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMFileMessageBody.EMDownloadStatus;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.util.ImageUtils;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a;
import com.ziroom.ziroomcustomer.minsu.chat.d.e;
import com.ziroom.ziroomcustomer.minsu.chat.d.g;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.MinsuChatPhotoView;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.b.d;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.b.e;
import java.io.File;

public class MinsuChatShowBigImageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView a;
  private MinsuChatPhotoView b;
  private int c = 2130838349;
  private String d;
  private Bitmap e;
  private boolean f;
  private String g;
  
  private void a()
  {
    Object localObject = EMClient.getInstance().chatManager().getMessage(this.g);
    if (localObject != null)
    {
      localObject = (EMImageMessageBody)((EMMessage)localObject).getBody();
      if ((localObject != null) && (((EMImageMessageBody)localObject).thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.SUCCESSED))
      {
        localObject = ((EMImageMessageBody)localObject).thumbnailLocalPath();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels;
        int j = localDisplayMetrics.heightPixels;
        this.e = e.getInstance().get((String)localObject);
        if (this.e == null)
        {
          localObject = new g(this, (String)localObject, this.b, this.a, i, j);
          if (Build.VERSION.SDK_INT > 10)
          {
            ((g)localObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
          }
          ((g)localObject).execute(new Void[0]);
          return;
        }
        this.b.setImageBitmap(this.e);
        return;
      }
      this.b.setImageResource(this.c);
      return;
    }
    this.b.setImageResource(this.c);
  }
  
  private void a(TextView paramTextView, Uri paramUri)
  {
    d.d("huanxin ShowBigImage", "showbigimage file exists. directly show it");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.e = e.getInstance().get(paramUri.getPath());
    if (this.e == null)
    {
      paramTextView = new g(this, paramUri.getPath(), this.b, paramTextView, 640, 960);
      if (Build.VERSION.SDK_INT > 10)
      {
        paramTextView.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      paramTextView.execute(new Void[0]);
      return;
    }
    this.b.setImageBitmap(this.e);
  }
  
  @SuppressLint({"NewApi"})
  private void d(String paramString)
  {
    d.e("huanxin ShowBigImage", "download with messageId: " + paramString);
    getResources().getString(2131296762);
    this.a.setVisibility(0);
    this.a.setEnabled(false);
    Object localObject = new File(this.d);
    localObject = new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        d.e("huanxin ShowBigImage", "offline file transfer error:" + paramAnonymousString);
        paramAnonymousString = new File(this.a);
        if ((paramAnonymousString.exists()) && (paramAnonymousString.isFile())) {
          paramAnonymousString.delete();
        }
        MinsuChatShowBigImageActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((MinsuChatShowBigImageActivity.this.isFinishing()) || (MinsuChatShowBigImageActivity.this.isDestroyed())) {
              return;
            }
            MinsuChatShowBigImageActivity.d(MinsuChatShowBigImageActivity.this).setImageResource(MinsuChatShowBigImageActivity.c(MinsuChatShowBigImageActivity.this));
            MinsuChatShowBigImageActivity.e(MinsuChatShowBigImageActivity.this).setText("查看原图");
            MinsuChatShowBigImageActivity.e(MinsuChatShowBigImageActivity.this).setVisibility(0);
            MinsuChatShowBigImageActivity.e(MinsuChatShowBigImageActivity.this).setEnabled(true);
          }
        });
      }
      
      public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
      {
        d.d("huanxin ShowBigImage", "Progress: " + paramAnonymousInt);
        MinsuChatShowBigImageActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((MinsuChatShowBigImageActivity.this.isFinishing()) || (MinsuChatShowBigImageActivity.this.isDestroyed())) {}
            do
            {
              return;
              if (paramAnonymousInt > 0) {
                MinsuChatShowBigImageActivity.e(MinsuChatShowBigImageActivity.this).setText(paramAnonymousInt + "%");
              }
            } while (paramAnonymousInt < 100);
            MinsuChatShowBigImageActivity.e(MinsuChatShowBigImageActivity.this).setVisibility(8);
          }
        });
      }
      
      public void onSuccess()
      {
        d.e("huanxin ShowBigImage", "onSuccess");
        MinsuChatShowBigImageActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            try
            {
              new File(MinsuChatShowBigImageActivity.5.this.a).renameTo(new File(MinsuChatShowBigImageActivity.a(MinsuChatShowBigImageActivity.this)));
              DisplayMetrics localDisplayMetrics = new DisplayMetrics();
              MinsuChatShowBigImageActivity.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
              int i = localDisplayMetrics.widthPixels;
              int j = localDisplayMetrics.heightPixels;
              MinsuChatShowBigImageActivity.a(MinsuChatShowBigImageActivity.this, ImageUtils.decodeScaleImage(MinsuChatShowBigImageActivity.a(MinsuChatShowBigImageActivity.this), i, j));
              if (MinsuChatShowBigImageActivity.b(MinsuChatShowBigImageActivity.this) == null) {
                MinsuChatShowBigImageActivity.d(MinsuChatShowBigImageActivity.this).setImageResource(MinsuChatShowBigImageActivity.c(MinsuChatShowBigImageActivity.this));
              }
              for (;;)
              {
                if (MinsuChatShowBigImageActivity.this.isFinishing()) {
                  return;
                }
                if (!MinsuChatShowBigImageActivity.this.isDestroyed()) {
                  break;
                }
                return;
                MinsuChatShowBigImageActivity.d(MinsuChatShowBigImageActivity.this).setImageBitmap(MinsuChatShowBigImageActivity.b(MinsuChatShowBigImageActivity.this));
                e.getInstance().put(MinsuChatShowBigImageActivity.a(MinsuChatShowBigImageActivity.this), MinsuChatShowBigImageActivity.b(MinsuChatShowBigImageActivity.this));
                MinsuChatShowBigImageActivity.a(MinsuChatShowBigImageActivity.this, true);
              }
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              new Handler(MinsuChatShowBigImageActivity.this.getMainLooper()).postDelayed(new Runnable()
              {
                public void run()
                {
                  MinsuChatShowBigImageActivity.e(MinsuChatShowBigImageActivity.this).setVisibility(8);
                }
              }, 300L);
            }
          }
        });
      }
    };
    paramString = EMClient.getInstance().chatManager().getMessage(paramString);
    paramString.setMessageStatusCallback((EMCallBack)localObject);
    d.e("huanxin ShowBigImage", "downloadAttachement");
    EMClient.getInstance().chatManager().downloadAttachment(paramString);
  }
  
  public void onBackPressed()
  {
    if (this.f) {
      setResult(-1);
    }
    finish();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d(this.g);
  }
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903342);
    this.b = ((MinsuChatPhotoView)findViewById(2131689700));
    this.a = ((TextView)findViewById(2131691713));
    this.a.setOnClickListener(this);
    this.c = getIntent().getIntExtra("default_image", 2130838350);
    paramBundle = (Uri)getIntent().getParcelableExtra("uri");
    this.d = getIntent().getExtras().getString("localUrl");
    this.g = getIntent().getExtras().getString("messageId");
    d.d("huanxin ShowBigImage", "show big msgId:" + this.g);
    if ((paramBundle != null) && (new File(paramBundle.getPath()).exists()))
    {
      a(this.a, paramBundle);
      this.a.setVisibility(8);
    }
    for (;;)
    {
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuChatShowBigImageActivity.this.finish();
        }
      });
      this.b.setOnPhotoTapListener(new b.d()
      {
        public void onPhotoTap(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          a.i("wz_info", "onPhotoTap  x = " + paramAnonymousFloat1 + "  y = " + paramAnonymousFloat2);
          if (!MinsuChatShowBigImageActivity.this.isFinishing()) {
            MinsuChatShowBigImageActivity.this.finish();
          }
        }
      });
      this.b.setOnViewTapListener(new b.e()
      {
        public void onViewTap(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          a.i("wz_info", "onViewTap  x = " + paramAnonymousFloat1 + "  y = " + paramAnonymousFloat2);
          if (!MinsuChatShowBigImageActivity.this.isFinishing()) {
            MinsuChatShowBigImageActivity.this.finish();
          }
        }
      });
      this.b.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          return true;
        }
      });
      return;
      if (this.g != null) {
        a();
      } else {
        this.b.setImageResource(this.c);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatShowBigImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */