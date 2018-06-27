package com.ziroom.ziroomcustomer.newchat;

import android.app.Activity;
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
import java.io.File;

public class i
  extends AsyncTask<Object, Void, Bitmap>
{
  String a = null;
  String b = null;
  String c = null;
  EMMessage d = null;
  EMMessage.ChatType e;
  Activity f;
  private ImageView g = null;
  
  protected Bitmap a(Object... paramVarArgs)
  {
    this.b = ((String)paramVarArgs[0]);
    this.a = ((String)paramVarArgs[1]);
    this.c = ((String)paramVarArgs[2]);
    this.e = ((EMMessage.ChatType)paramVarArgs[3]);
    this.g = ((ImageView)paramVarArgs[4]);
    this.f = ((Activity)paramVarArgs[5]);
    this.d = ((EMMessage)paramVarArgs[6]);
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
      this.g.setImageBitmap(d.convertBitmap(paramBitmap, d.convertDip2Px(this.f, 90), d.convertDip2Px(this.f, 90)));
      g.getInstance().put(this.b, paramBitmap);
      this.g.setClickable(true);
      this.g.setTag(this.b);
      this.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          File localFile;
          if (i.this.b != null)
          {
            paramAnonymousView = new Intent(i.this.f, ShowBigImage.class);
            paramAnonymousView.putExtra("messageId", i.this.d.getMsgId());
            if (i.this.d.direct() != EMMessage.Direct.SEND) {
              break label231;
            }
            localFile = new File(i.this.a);
            if (!localFile.exists()) {
              break label205;
            }
            paramAnonymousView.putExtra("uri", Uri.fromFile(localFile));
          }
          for (;;)
          {
            if ((i.this.d.getChatType() == EMMessage.ChatType.Chat) || ((i.this.d != null) && (i.this.d.direct() == EMMessage.Direct.RECEIVE) && (!i.this.d.isAcked()))) {
              i.this.d.setAcked(true);
            }
            try
            {
              EMClient.getInstance().chatManager().ackMessageRead(i.this.d.getFrom(), i.this.d.getMsgId());
              i.this.f.startActivity(paramAnonymousView);
              return;
              label205:
              paramAnonymousView.putExtra("remotepath", ((EMImageMessageBody)i.this.d.getBody()).getLocalUrl());
              continue;
              label231:
              if (i.this.d.direct() != EMMessage.Direct.RECEIVE) {
                continue;
              }
              localFile = new File(i.this.b);
              if (localFile.exists())
              {
                paramAnonymousView.putExtra("uri", Uri.fromFile(localFile));
                continue;
              }
              paramAnonymousView.putExtra("remotepath", i.this.c);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */