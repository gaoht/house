package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Status;
import com.ziroom.ziroomcustomer.newchat.ShowBigImage;
import com.ziroom.ziroomcustomer.newchat.d;
import com.ziroom.ziroomcustomer.newchat.g;
import com.ziroom.ziroomcustomer.newchat.h;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;

public class a
  extends AsyncTask<Object, Void, Bitmap>
{
  String a = null;
  String b = null;
  String c = null;
  EMMessage d = null;
  EMMessage.ChatType e;
  Activity f;
  ImageView g = null;
  private ImageView h = null;
  
  protected Bitmap a(Object... paramVarArgs)
  {
    this.b = ((String)paramVarArgs[0]);
    this.a = ((String)paramVarArgs[1]);
    this.c = ((String)paramVarArgs[2]);
    this.e = ((EMMessage.ChatType)paramVarArgs[3]);
    this.h = ((ImageView)paramVarArgs[4]);
    this.f = ((Activity)paramVarArgs[5]);
    this.d = ((EMMessage)paramVarArgs[6]);
    this.g = ((ImageView)paramVarArgs[7]);
    if (new File(this.b).exists()) {
      return h.decodeScaleImage(this.b, 160, 160);
    }
    if (this.d.direct() == EMMessage.Direct.SEND) {
      return h.decodeScaleImage(this.a, 160, 160);
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.h.setImageBitmap(d.convertBitmap(paramBitmap, d.convertDip2Px(this.f, 90), d.convertDip2Px(this.f, 90)));
      g.getInstance().put(this.b, paramBitmap);
      if (this.g != null) {
        this.g.setVisibility(8);
      }
      this.h.setClickable(true);
      this.h.setTag(this.b);
      this.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          File localFile;
          if (a.this.b != null)
          {
            paramAnonymousView = new Intent(a.this.f, ShowBigImage.class);
            paramAnonymousView.putExtra("messageId", a.this.d.getMsgId());
            if (a.this.d.direct() != EMMessage.Direct.SEND) {
              break label282;
            }
            localFile = new File(a.this.a);
            if (!localFile.exists()) {
              break label265;
            }
            paramAnonymousView.putExtra("uri", Uri.fromFile(localFile));
          }
          for (;;)
          {
            if ((a.this.d.getChatType() == EMMessage.ChatType.Chat) || ((a.this.d != null) && (a.this.d.direct() == EMMessage.Direct.RECEIVE) && (!a.this.d.isAcked()))) {
              a.this.d.setAcked(true);
            }
            try
            {
              EMClient.getInstance().chatManager().ackMessageRead(a.this.d.getFrom(), a.this.d.getMsgId());
              paramAnonymousView.putExtra("remotepath", a.this.c);
              u.d("dskjglkdf", "=======  下载 111");
              a.this.f.startActivity(paramAnonymousView, ActivityOptions.makeScaleUpAnimation(a.a(a.this), a.a(a.this).getWidth() / 2, a.a(a.this).getHeight() / 2, 0, 0).toBundle());
              return;
              label265:
              paramAnonymousView.putExtra("remotepath", a.this.c);
              continue;
              label282:
              if (a.this.d.direct() != EMMessage.Direct.RECEIVE) {
                continue;
              }
              localFile = new File(a.this.b);
              if (localFile.exists())
              {
                paramAnonymousView.putExtra("uri", Uri.fromFile(localFile));
                continue;
              }
              paramAnonymousView.putExtra("remotepath", ((EMImageMessageBody)a.this.d.getBody()).getLocalUrl());
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
      });
    }
    while ((this.d.status() != EMMessage.Status.FAIL) || (!d.isNetWorkConnected(this.f))) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run() {}
    }).start();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */