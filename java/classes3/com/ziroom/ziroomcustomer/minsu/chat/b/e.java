package com.ziroom.ziroomcustomer.minsu.chat.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMFileMessageBody.EMDownloadStatus;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.util.ImageUtils;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a;
import com.ziroom.ziroomcustomer.minsu.chat.d.d;
import com.ziroom.ziroomcustomer.minsu.chat.d.h;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.MinsuChatPhotoView;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.b.d;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.b.e;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.n;
import java.io.File;
import java.util.List;

public class e
  extends PagerAdapter
{
  int a = 2130838349;
  private Activity b;
  private List<EMMessage> c;
  private SparseBooleanArray d;
  
  public e(Activity paramActivity, List<EMMessage> paramList)
  {
    this.b = paramActivity;
    this.c = paramList;
    this.d = new SparseBooleanArray(paramList.size());
  }
  
  private void a(final int paramInt, String paramString1, final String paramString2, final MinsuChatPhotoView paramMinsuChatPhotoView, final TextView paramTextView, View paramView, final boolean paramBoolean)
  {
    this.d.put(paramInt, d.isNetworkConnAndAvailable(this.b));
    paramTextView.setVisibility(0);
    paramTextView.setEnabled(false);
    paramView = new File(paramString2);
    paramString2 = new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        paramAnonymousString = new File(this.a);
        if ((paramAnonymousString.exists()) && (paramAnonymousString.isFile())) {
          paramAnonymousString.delete();
        }
        e.a(e.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (e.7.this.e) {
              e.b(e.this, "保存失败");
            }
            if ((e.a(e.this).isFinishing()) || (e.a(e.this).isDestroyed())) {
              return;
            }
            e.7.this.d.setVisibility(0);
            e.7.this.d.setText("查看原图");
            e.7.this.d.setEnabled(true);
          }
        });
      }
      
      public void onProgress(final int paramAnonymousInt, String paramAnonymousString)
      {
        e.a(e.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((e.a(e.this).isFinishing()) || (e.a(e.this).isDestroyed())) {}
            do
            {
              return;
              if (paramAnonymousInt > 0) {
                e.7.this.d.setText(paramAnonymousInt + "%");
              }
            } while (paramAnonymousInt < 100);
            e.7.this.d.setVisibility(8);
          }
        });
      }
      
      public void onSuccess()
      {
        e.a(e.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            int j = 1;
            int i = 0;
            final boolean bool = d.isNetworkConnAndAvailable(e.a(e.this));
            for (;;)
            {
              try
              {
                new File(e.7.this.a).renameTo(new File(e.7.this.b));
                Object localObject = new DisplayMetrics();
                e.a(e.this).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
                int k = ((DisplayMetrics)localObject).widthPixels;
                int m = ((DisplayMetrics)localObject).heightPixels;
                localObject = ImageUtils.decodeScaleImage(e.7.this.b, k, m);
                if (localObject == null)
                {
                  e.7.this.c.setImageResource(e.this.a);
                  j = 0;
                  if (!e.7.this.e)
                  {
                    if (i != 0) {
                      e.7.this.d.setVisibility(8);
                    }
                  }
                  else
                  {
                    if (e.7.this.e)
                    {
                      if (j == 0) {
                        break label368;
                      }
                      e.7.this.d.setVisibility(8);
                      e.a(e.this, "保存成功");
                    }
                    if (e.a(e.this).isFinishing()) {
                      break;
                    }
                    if (!e.a(e.this).isDestroyed()) {
                      break label383;
                    }
                  }
                }
                else
                {
                  e.7.this.c.setImageBitmap((Bitmap)localObject);
                  com.ziroom.ziroomcustomer.minsu.chat.d.e.getInstance().put(e.7.this.b, (Bitmap)localObject);
                  e.7.this.d.setText("已完成");
                  if ((!e.7.this.e) || (!n.saveImage((Bitmap)localObject))) {
                    break label448;
                  }
                  i = 1;
                  continue;
                }
                e.7.this.d.setVisibility(0);
                e.7.this.d.setEnabled(true);
                continue;
                e.b(e.this, "保存失败");
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                new Handler(e.a(e.this).getMainLooper()).postDelayed(new Runnable()
                {
                  public void run()
                  {
                    if ((!bool) && (e.b(e.this).get(e.7.this.f)))
                    {
                      e.7.this.d.setText("重新加载");
                      e.7.this.d.setVisibility(0);
                      e.7.this.d.setEnabled(true);
                    }
                    for (;;)
                    {
                      e.b(e.this).put(e.7.this.f, bool);
                      return;
                      e.7.this.d.setVisibility(8);
                    }
                  }
                }, 300L);
                return;
              }
              label368:
              continue;
              label383:
              if ((!bool) && (e.b(e.this).get(e.7.this.f)))
              {
                e.7.this.d.setText("重新加载");
                e.7.this.d.setVisibility(0);
                e.7.this.d.setEnabled(true);
                continue;
                label448:
                j = 0;
                i = 1;
              }
            }
          }
        });
      }
    };
    paramString1 = EMClient.getInstance().chatManager().getMessage(paramString1);
    paramString1.setMessageStatusCallback(paramString2);
    EMClient.getInstance().chatManager().downloadAttachment(paramString1);
  }
  
  private void a(final View paramView, final int paramInt)
  {
    final TextView localTextView = (TextView)paramView.findViewById(2131691713);
    final View localView = paramView.findViewById(2131695354);
    paramView = (MinsuChatPhotoView)paramView.findViewById(2131689700);
    EMMessage localEMMessage = (EMMessage)this.c.get(paramInt);
    final EMImageMessageBody localEMImageMessageBody = (EMImageMessageBody)localEMMessage.getBody();
    Uri localUri = Uri.fromFile(new File(localEMImageMessageBody.getLocalUrl()));
    final String str1 = localEMImageMessageBody.getLocalUrl();
    final String str2 = localEMMessage.getMsgId();
    paramView.setTag(2131689523, localUri.getPath());
    if ((localUri != null) && (new File(localUri.getPath()).exists()))
    {
      a(paramView, localTextView, localUri);
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!d.isNetworkConnAndAvailable(e.a(e.this)))
          {
            com.freelxl.baselibrary.f.g.textToast(e.a(e.this), "网络连接失败，请检查网络设置");
            return;
          }
          e.a(e.this, paramInt, str2, str1, paramView, localTextView, localView, false);
        }
      });
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!d.isNetworkConnAndAvailable(e.a(e.this)))
          {
            com.freelxl.baselibrary.f.g.textToast(e.a(e.this), "网络连接失败，请检查网络设置");
            return;
          }
          boolean bool = false;
          if (new File(localEMImageMessageBody.getLocalUrl()).exists())
          {
            paramAnonymousView = new DisplayMetrics();
            e.a(e.this).getWindowManager().getDefaultDisplay().getMetrics(paramAnonymousView);
            int i = paramAnonymousView.widthPixels;
            int j = paramAnonymousView.heightPixels;
            paramAnonymousView = ImageUtils.decodeScaleImage(str1, i, j);
            if (paramAnonymousView != null) {
              bool = n.saveImage(paramAnonymousView);
            }
            if (bool)
            {
              e.a(e.this, "保存成功");
              return;
            }
            e.b(e.this, "保存失败");
            return;
          }
          e.a(e.this, paramInt, str2, str1, paramView, localTextView, localView, true);
        }
      });
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          e.a(e.this).finish();
        }
      });
      paramView.setOnPhotoTapListener(new b.d()
      {
        public void onPhotoTap(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          a.i("wz_info", "onPhotoTap  x = " + paramAnonymousFloat1 + "  y = " + paramAnonymousFloat2);
          if (!e.a(e.this).isFinishing()) {
            e.a(e.this).finish();
          }
        }
      });
      paramView.setOnViewTapListener(new b.e()
      {
        public void onViewTap(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          a.i("wz_info", "onViewTap  x = " + paramAnonymousFloat1 + "  y = " + paramAnonymousFloat2);
          if (!e.a(e.this).isFinishing()) {
            e.a(e.this).finish();
          }
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          return true;
        }
      });
      return;
      if (str2 != null)
      {
        a(localEMMessage, paramView, localTextView);
        localTextView.setVisibility(0);
      }
      else
      {
        paramView.setImageResource(this.a);
      }
    }
  }
  
  private void a(EMMessage paramEMMessage, MinsuChatPhotoView paramMinsuChatPhotoView, TextView paramTextView)
  {
    if (paramEMMessage != null)
    {
      paramEMMessage = (EMImageMessageBody)paramEMMessage.getBody();
      if ((paramEMMessage != null) && (paramEMMessage.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.SUCCESSED))
      {
        paramEMMessage = paramEMMessage.thumbnailLocalPath();
        Object localObject = new DisplayMetrics();
        this.b.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        int i = ((DisplayMetrics)localObject).widthPixels;
        int j = ((DisplayMetrics)localObject).heightPixels;
        localObject = com.ziroom.ziroomcustomer.minsu.chat.d.e.getInstance().get(paramEMMessage);
        if (localObject == null)
        {
          paramMinsuChatPhotoView.setTag(2131689523, paramEMMessage);
          paramEMMessage = new h(this.b, paramEMMessage, paramMinsuChatPhotoView, paramTextView, i, j);
          if (Build.VERSION.SDK_INT > 10)
          {
            paramEMMessage.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
          }
          paramEMMessage.execute(new Void[0]);
          return;
        }
        paramMinsuChatPhotoView.setImageBitmap((Bitmap)localObject);
        return;
      }
      paramMinsuChatPhotoView.setImageResource(this.a);
      return;
    }
    paramMinsuChatPhotoView.setImageResource(this.a);
  }
  
  private void a(MinsuChatPhotoView paramMinsuChatPhotoView, TextView paramTextView, Uri paramUri)
  {
    Object localObject = new DisplayMetrics();
    this.b.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    localObject = com.ziroom.ziroomcustomer.minsu.chat.d.e.getInstance().get(paramUri.getPath());
    if (localObject == null)
    {
      paramMinsuChatPhotoView.setTag(2131689523, paramUri.getPath());
      paramMinsuChatPhotoView = new com.ziroom.ziroomcustomer.minsu.chat.d.g(this.b, paramUri.getPath(), paramMinsuChatPhotoView, paramTextView, 640, 960);
      if (Build.VERSION.SDK_INT > 10)
      {
        paramMinsuChatPhotoView.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      paramMinsuChatPhotoView.execute(new Void[0]);
      return;
    }
    paramMinsuChatPhotoView.setImageBitmap((Bitmap)localObject);
  }
  
  private void a(String paramString)
  {
    a(true, paramString);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Toast localToast = new Toast(this.b);
    LinearLayout localLinearLayout = new LinearLayout(this.b);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(ab.dp2px(this.b, 124.0F), ab.dp2px(this.b, 124.0F)));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundResource(2130837811);
    View localView = new View(this.b);
    if (paramBoolean) {}
    for (int i = 2130840447;; i = 2130840448)
    {
      localView.setBackgroundResource(i);
      Object localObject = new LinearLayout.LayoutParams(ab.dp2px(this.b, 44.0F), ab.dp2px(this.b, 44.0F));
      ((LinearLayout.LayoutParams)localObject).setMargins(0, ab.dp2px(this.b, 26.0F), 0, ab.dp2px(this.b, 18.0F));
      ((LinearLayout.LayoutParams)localObject).gravity = 1;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.b);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((TextView)localObject).setGravity(1);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextSize(16.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView(localView);
      localLinearLayout.addView((View)localObject);
      localToast.setView(localLinearLayout);
      localToast.setDuration(1);
      localToast.setGravity(17, 0, 0);
      if ((localToast instanceof Toast)) {
        break;
      }
      localToast.show();
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
  
  private void b(String paramString)
  {
    a(false, paramString);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(this.b).inflate(2130904361, null);
    a(localView, paramInt);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */