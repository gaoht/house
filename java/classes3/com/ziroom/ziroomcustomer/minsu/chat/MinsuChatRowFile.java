package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMNormalFileMessageBody;
import com.hyphenate.util.TextFormater;
import java.io.File;

public class MinsuChatRowFile
  extends MinsuChatRow
{
  protected TextView t;
  protected TextView u;
  protected TextView v;
  private EMNormalFileMessageBody w;
  
  public MinsuChatRowFile(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
  }
  
  protected void a(EMMessage paramEMMessage) {}
  
  protected void g()
  {
    LayoutInflater localLayoutInflater = this.b;
    if (this.e.direct() == EMMessage.Direct.RECEIVE) {}
    for (int i = 2130904916;; i = 2130904927)
    {
      localLayoutInflater.inflate(i, this);
      return;
    }
  }
  
  protected void h()
  {
    this.t = ((TextView)findViewById(2131696908));
    this.u = ((TextView)findViewById(2131696909));
    this.v = ((TextView)findViewById(2131696910));
    this.k = ((TextView)findViewById(2131696907));
  }
  
  protected void i()
  {
    this.d.notifyDataSetChanged();
  }
  
  protected void j()
  {
    d();
    switch (1.a[this.e.status().ordinal()])
    {
    default: 
      this.l.setVisibility(4);
      if (this.k != null) {
        this.k.setVisibility(4);
      }
      this.m.setVisibility(0);
      return;
    case 1: 
      this.l.setVisibility(4);
      if (this.k != null) {
        this.k.setVisibility(4);
      }
      this.m.setVisibility(4);
      return;
    case 2: 
      this.l.setVisibility(4);
      if (this.k != null) {
        this.k.setVisibility(4);
      }
      this.m.setVisibility(0);
      return;
    }
    this.l.setVisibility(0);
    if (this.k != null)
    {
      this.k.setVisibility(0);
      this.k.setText(this.e.progress() + "%");
    }
    this.m.setVisibility(4);
  }
  
  protected void onSetUpView()
  {
    this.w = ((EMNormalFileMessageBody)this.e.getBody());
    Object localObject = this.w.getLocalUrl();
    this.t.setText(this.w.getFileName());
    this.u.setText(TextFormater.getDataSize(this.w.getFileSize()));
    if (this.e.direct() == EMMessage.Direct.RECEIVE)
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        this.v.setText("已经下载");
        return;
      }
      this.v.setText("没有下载");
      return;
    }
    j();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */