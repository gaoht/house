package com.ziroom.ziroomcustomer.minsu.chat;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMFileMessageBody.EMDownloadStatus;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.chat.d.e;
import com.ziroom.ziroomcustomer.minsu.chat.d.f;
import com.ziroom.ziroomcustomer.minsu.chat.d.i;
import com.ziroom.ziroomcustomer.minsu.chat.d.k;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.Date;

public class MinsuChatRowImage
  extends MinsuChatRowFile
{
  protected ImageView w;
  ObjectAnimator x;
  private EMImageMessageBody y;
  private k z = k.getInstance();
  
  public MinsuChatRowImage(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.w.getLayoutParams().width = paramBitmap.getWidth();
    this.w.getLayoutParams().height = paramBitmap.getHeight();
    this.w.setImageBitmap(paramBitmap);
  }
  
  private void a(final String paramString1, final String paramString2, final EMMessage paramEMMessage)
  {
    Bitmap localBitmap = e.getInstance().get(paramString1);
    if (localBitmap != null)
    {
      a(f.convertLimitBitmap(localBitmap));
      i();
      return;
    }
    AsyncTaskCompat.executeParallel(new AsyncTask()
    {
      protected Bitmap a(Object... paramAnonymousVarArgs)
      {
        Object localObject = null;
        if (new File(paramString1).exists()) {
          paramAnonymousVarArgs = f.decodeScaleImage(paramString1, com.ziroom.ziroomcustomer.newchat.d.convertDip2Px(MinsuChatRowImage.this.c, 160), com.ziroom.ziroomcustomer.newchat.d.convertDip2Px(MinsuChatRowImage.this.c, 160));
        }
        do
        {
          do
          {
            do
            {
              return paramAnonymousVarArgs;
              if (new File(MinsuChatRowImage.a(MinsuChatRowImage.this).thumbnailLocalPath()).exists()) {
                return f.decodeScaleImage(MinsuChatRowImage.a(MinsuChatRowImage.this).thumbnailLocalPath(), com.ziroom.ziroomcustomer.newchat.d.convertDip2Px(MinsuChatRowImage.this.c, 160), com.ziroom.ziroomcustomer.newchat.d.convertDip2Px(MinsuChatRowImage.this.c, 160));
              }
              paramAnonymousVarArgs = (Object[])localObject;
            } while (paramEMMessage.direct() != EMMessage.Direct.SEND);
            paramAnonymousVarArgs = (Object[])localObject;
          } while (paramString2 == null);
          paramAnonymousVarArgs = (Object[])localObject;
        } while (!new File(paramString2).exists());
        return f.decodeScaleImage(paramString2, com.ziroom.ziroomcustomer.newchat.d.convertDip2Px(MinsuChatRowImage.this.c, 160), com.ziroom.ziroomcustomer.newchat.d.convertDip2Px(MinsuChatRowImage.this.c, 160));
      }
      
      protected void a(Bitmap paramAnonymousBitmap)
      {
        MinsuChatRowImage.b(MinsuChatRowImage.this);
        if (paramAnonymousBitmap != null)
        {
          MinsuChatRowImage.a(MinsuChatRowImage.this, f.convertLimitBitmap(paramAnonymousBitmap));
          e.getInstance().put(paramString1, paramAnonymousBitmap);
        }
        for (;;)
        {
          MinsuChatRowImage.this.i();
          return;
          MinsuChatRowImage.a(MinsuChatRowImage.this, MinsuChatRowImage.this.a(2130840288));
        }
      }
    }, new Object[0]);
  }
  
  private void k()
  {
    if ((ApplicationEx.c.getUser() == null) || (ApplicationEx.c.getUser().getHeadImg() == null)) {}
    String str;
    do
    {
      return;
      str = ApplicationEx.c.getUser().getHeadImg();
    } while ((str.equals(this.h.getTag(2131689523))) || (TextUtils.isEmpty(str)));
    this.h.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(ApplicationEx.c));
    c.loadHolderImage(this.h, str);
    this.h.setTag(2131689523, str);
  }
  
  private void l()
  {
    Object localObject1 = this.e.getFrom();
    Object localObject2 = this.z.getUser((String)localObject1);
    com.ziroom.ziroomcustomer.minsu.chat.a.a locala = j.getUserFromMessage(this.e);
    if (localObject2 == null)
    {
      u.i("wz_huanxin", "chat group  a");
      this.z.putUser((String)localObject1, locala);
    }
    for (;;)
    {
      localObject1 = this.z.getUser((String)localObject1);
      u.i("wz_huanxin", "chat group  user = " + localObject1);
      if (localObject1 == null) {
        break label207;
      }
      localObject2 = ((com.ziroom.ziroomcustomer.minsu.chat.a.a)localObject1).b;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.h.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(ApplicationEx.c));
        c.loadHolderImage(this.h, (String)localObject2);
      }
      localObject1 = ((com.ziroom.ziroomcustomer.minsu.chat.a.a)localObject1).a;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      this.j.setText((CharSequence)localObject1);
      return;
      if ((localObject2 != null) && (locala != null))
      {
        u.i("wz_huanxin", "chat group  b 0");
        if (!((com.ziroom.ziroomcustomer.minsu.chat.a.a)localObject2).equals(locala))
        {
          u.i("wz_huanxin", "chat group  b 1");
          if (locala.c > ((com.ziroom.ziroomcustomer.minsu.chat.a.a)localObject2).c)
          {
            u.i("wz_huanxin", "chat group  b 2");
            this.z.putUser((String)localObject1, locala);
          }
        }
      }
    }
    this.j.setText("房客");
    return;
    label207:
    this.j.setText("房客");
  }
  
  private void m()
  {
    View localView = findViewById(2131696905);
    if (localView == null) {
      return;
    }
    this.w.setVisibility(8);
    localView.setVisibility(0);
    this.x = ObjectAnimator.ofFloat(localView, View.ROTATION, new float[] { 0.0F, 360.0F });
    this.x.setDuration(1500L);
    this.x.setRepeatMode(1);
    this.x.setRepeatCount(-1);
    this.x.start();
  }
  
  private void n()
  {
    View localView = findViewById(2131689700);
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = findViewById(2131696905);
    if (localView == null) {}
    do
    {
      return;
      localView.setVisibility(4);
    } while ((this.x == null) || (!this.x.isRunning()));
    this.x.end();
    this.x = null;
  }
  
  private void o()
  {
    this.l.setVisibility(8);
    this.k.setVisibility(8);
    m();
    EMCallBack local2 = new EMCallBack()
    {
      public void onError(final int paramAnonymousInt, final String paramAnonymousString)
      {
        MinsuChatRowImage.this.c.runOnUiThread(new Runnable()
        {
          public void run()
          {
            MinsuChatRowImage.b(MinsuChatRowImage.this);
            MinsuChatRowImage.a(MinsuChatRowImage.this, MinsuChatRowImage.this.a(2130840288));
            if (MinsuChatRowImage.this.q != null) {
              MinsuChatRowImage.this.q.onError(paramAnonymousInt, paramAnonymousString);
            }
            if (MinsuChatRowImage.this.p != null) {
              MinsuChatRowImage.this.p.onError(paramAnonymousInt, paramAnonymousString);
            }
          }
        });
      }
      
      public void onProgress(final int paramAnonymousInt, final String paramAnonymousString)
      {
        MinsuChatRowImage.this.c.runOnUiThread(new Runnable()
        {
          public void run()
          {
            com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_info", "pro = " + paramAnonymousInt + " sts = " + paramAnonymousString);
            if (MinsuChatRowImage.this.q != null) {
              MinsuChatRowImage.this.q.onProgress(paramAnonymousInt, paramAnonymousString);
            }
            if (MinsuChatRowImage.this.p != null) {
              MinsuChatRowImage.this.p.onProgress(paramAnonymousInt, paramAnonymousString);
            }
          }
        });
      }
      
      public void onSuccess()
      {
        MinsuChatRowImage.this.c.runOnUiThread(new Runnable()
        {
          public void run()
          {
            MinsuChatRowImage.b(MinsuChatRowImage.this);
            MinsuChatRowImage.this.w.setVisibility(0);
            MinsuChatRowImage.this.l.setVisibility(8);
            MinsuChatRowImage.this.k.setVisibility(8);
            String str2 = MinsuChatRowImage.a(MinsuChatRowImage.this).thumbnailLocalPath();
            String str1 = str2;
            if (!new File(str2).exists()) {
              str1 = f.getThumbnailImagePath(MinsuChatRowImage.a(MinsuChatRowImage.this).getLocalUrl());
            }
            MinsuChatRowImage.a(MinsuChatRowImage.this, str1, MinsuChatRowImage.a(MinsuChatRowImage.this).getLocalUrl(), MinsuChatRowImage.this.e);
            if (MinsuChatRowImage.this.e.direct() == EMMessage.Direct.RECEIVE) {
              if (MinsuChatRowImage.this.q != null) {
                MinsuChatRowImage.this.q.onSuccess();
              }
            }
            while (MinsuChatRowImage.this.p == null) {
              return;
            }
            MinsuChatRowImage.this.p.onSuccess();
          }
        });
      }
    };
    this.e.setMessageStatusCallback(local2);
    EMClient.getInstance().chatManager().downloadThumbnail(this.e);
  }
  
  Bitmap a(int paramInt)
  {
    return f.convertLimitBitmap(BitmapFactory.decodeResource(this.c.getResources(), paramInt));
  }
  
  protected void a()
  {
    if ("ZIROOM_ZRY_IM".equals(this.e.getStringAttribute("ziroomFlag", "")))
    {
      c();
      return;
    }
    super.a();
  }
  
  protected void a(EMMessage paramEMMessage)
  {
    if ((this.y.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.DOWNLOADING) || (this.y.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.PENDING)) {
      return;
    }
    if (this.y.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.FAILED)
    {
      o();
      return;
    }
    paramEMMessage = new Intent(this.c, MinsuChatShowBigImageListActivity.class);
    paramEMMessage.putExtra("messageId", this.e.getMsgId());
    File localFile = new File(this.y.getLocalUrl());
    if (localFile.exists()) {
      paramEMMessage.putExtra("uri", Uri.fromFile(localFile));
    }
    for (;;)
    {
      if ((this.e != null) && (this.e.direct() == EMMessage.Direct.RECEIVE) && (!this.e.isAcked()) && (this.e.getChatType() == EMMessage.ChatType.Chat)) {}
      try
      {
        EMClient.getInstance().chatManager().ackMessageRead(this.e.getFrom(), this.e.getMsgId());
        this.c.startActivity(paramEMMessage);
        this.c.overridePendingTransition(0, 0);
        return;
        paramEMMessage.putExtra("localUrl", this.y.getLocalUrl());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void c()
  {
    TextView localTextView = (TextView)findViewById(2131696902);
    if (localTextView != null)
    {
      if (this.f == 0)
      {
        localTextView.setText(i.getTimestampString(new Date(this.e.getMsgTime())));
        localTextView.setVisibility(0);
      }
    }
    else
    {
      if (this.e.direct() != EMMessage.Direct.SEND) {
        break label269;
      }
      k();
      label65:
      if (this.o != null)
      {
        if (!this.e.isDelivered()) {
          break label276;
        }
        this.o.setVisibility(0);
      }
      label90:
      if ((this.d instanceof g))
      {
        if (!((g)this.d).isShowAvatar()) {
          break label287;
        }
        this.h.setVisibility(0);
        label121:
        if (this.j != null)
        {
          if (!((g)this.d).isShowUserNick()) {
            break label299;
          }
          this.j.setVisibility(0);
        }
        label149:
        if (this.e.direct() != EMMessage.Direct.SEND) {
          break label311;
        }
        if (((g)this.d).getMyBubbleBg() != null) {
          this.i.setBackgroundDrawable(((g)this.d).getMyBubbleBg());
        }
      }
    }
    label269:
    label276:
    label287:
    label299:
    label311:
    while ((this.e.direct() != EMMessage.Direct.RECEIVE) || (((g)this.d).getOtherBuddleBg() == null))
    {
      return;
      EMMessage localEMMessage = (EMMessage)this.d.getItem(this.f - 1);
      if ((localEMMessage != null) && (i.isCloseEnough(this.e.getMsgTime(), localEMMessage.getMsgTime())))
      {
        localTextView.setVisibility(8);
        break;
      }
      localTextView.setText(i.getTimestampString(new Date(this.e.getMsgTime())));
      localTextView.setVisibility(0);
      break;
      l();
      break label65;
      this.o.setVisibility(4);
      break label90;
      this.h.setVisibility(8);
      break label121;
      this.j.setVisibility(8);
      break label149;
    }
    this.i.setBackgroundDrawable(((g)this.d).getOtherBuddleBg());
  }
  
  protected void g()
  {
    LayoutInflater localLayoutInflater = this.b;
    if (this.e.direct() == EMMessage.Direct.RECEIVE) {}
    for (int i = 2130904920;; i = 2130904929)
    {
      localLayoutInflater.inflate(i, this);
      return;
    }
  }
  
  protected void h()
  {
    this.k = ((TextView)findViewById(2131696907));
    this.w = ((ImageView)findViewById(2131689700));
  }
  
  protected void i()
  {
    if (this.f == this.d.getCount() - 1) {
      super.i();
    }
    n();
  }
  
  protected void onSetUpView()
  {
    this.y = ((EMImageMessageBody)this.e.getBody());
    a(a(2130840288));
    if (this.e.direct() == EMMessage.Direct.RECEIVE)
    {
      if ((this.y.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.DOWNLOADING) || (this.y.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.PENDING))
      {
        this.w.setVisibility(8);
        m();
        e();
        return;
      }
      this.w.setVisibility(0);
      n();
      this.l.setVisibility(8);
      this.k.setVisibility(8);
      String str2 = this.y.thumbnailLocalPath();
      str1 = str2;
      if (!new File(str2).exists()) {
        str1 = f.getThumbnailImagePath(this.y.getLocalUrl());
      }
      a(str1, this.y.getLocalUrl(), this.e);
      return;
    }
    this.w.setVisibility(0);
    String str1 = this.y.getLocalUrl();
    a(f.getThumbnailImagePath(this.y.getLocalUrl()), str1, this.e);
    j();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */