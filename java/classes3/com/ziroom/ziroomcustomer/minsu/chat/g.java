package com.ziroom.ziroomcustomer.minsu.chat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Type;
import java.util.List;

public class g
  extends BaseAdapter
{
  EMMessage[] a = null;
  Handler b = new Handler()
  {
    private void a()
    {
      int m = 20;
      int k = 0;
      if (g.a(g.this) == null) {
        return;
      }
      List localList = g.a(g.this).getAllMessages();
      int j;
      label73:
      g localg;
      Object localObject;
      if (localList == null)
      {
        i = 0;
        j = m;
        if (g.this.a != null)
        {
          j = m;
          if (g.this.a.length > 20)
          {
            if (20 >= i) {
              break label192;
            }
            j = i;
          }
        }
        localg = null;
        localObject = localg;
        if (localList != null)
        {
          localObject = localg;
          if (localList.size() != 0) {
            localObject = ((EMMessage)localList.get(0)).getMsgId();
          }
        }
        g.a(g.this).loadMoreMsgFromDB((String)localObject, j);
        localObject = g.a(g.this).getAllMessages();
        localg = g.this;
        if (localObject != null) {
          break label204;
        }
      }
      label192:
      label204:
      for (int i = k;; i = ((List)localObject).size())
      {
        localg.a = ((EMMessage[])((List)localObject).toArray(new EMMessage[i]));
        g.this.notifyDataSetChanged();
        return;
        i = localList.size();
        break;
        j = g.this.a.length;
        break label73;
      }
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          return;
          a();
          return;
        } while (g.this.a.length <= 0);
        g.b(g.this).setSelection(g.this.a.length - 1);
        return;
      }
      int i = paramAnonymousMessage.arg1;
      g.b(g.this).setSelection(i);
    }
  };
  private Activity c;
  private EMConversation d;
  private String e;
  private d f;
  private i g;
  private f h;
  private boolean i;
  private boolean j;
  private Drawable k;
  private Drawable l;
  private ListView m;
  
  public g(Activity paramActivity, String paramString, int paramInt, ListView paramListView)
  {
    this.c = paramActivity;
    this.m = paramListView;
    this.e = paramString;
    this.d = EMClient.getInstance().chatManager().getConversation(paramString);
  }
  
  protected MinsuChatRow a(Activity paramActivity, EMMessage paramEMMessage, int paramInt)
  {
    if ((this.h != null) && (this.h.getCustomChatRow(paramEMMessage, paramInt, this) != null)) {
      return this.h.getCustomChatRow(paramEMMessage, paramInt, this);
    }
    try
    {
      switch (2.a[paramEMMessage.getType().ordinal()])
      {
      case 1: 
        for (paramActivity = new MinsuChatRowText(paramActivity, paramEMMessage, paramInt, this);; paramActivity = new MinsuChatRowRevoke(paramActivity, paramEMMessage, paramInt, this))
        {
          com.freelxl.baselibrary.f.d.d("lanzhihong", "message===" + paramEMMessage.getType() + "m===" + paramEMMessage.toString());
          return paramActivity;
          if (!paramEMMessage.getBooleanAttribute("em_revoke", false)) {
            break;
          }
        }
      }
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
        paramActivity = null;
        continue;
        if ("1".equals(paramEMMessage.getStringAttribute("msgType", "")))
        {
          paramActivity = new MinsuChatRowHouse(paramActivity, paramEMMessage, paramInt, this);
        }
        else if ("2".equals(paramEMMessage.getStringAttribute("msgType", "")))
        {
          paramActivity = new MinsuChatRowHouseShare(paramActivity, paramEMMessage, paramInt, this);
        }
        else if ("3".equals(paramEMMessage.getStringAttribute("msgType", "")))
        {
          paramActivity = new MinsuChatRowSystem(paramActivity, paramEMMessage, paramInt, this);
        }
        else if ("4".equals(paramEMMessage.getStringAttribute("msgType", "")))
        {
          paramActivity = new MinsuChatRowBigExpression(paramActivity, paramEMMessage, paramInt, this);
        }
        else if ("1".equals(paramEMMessage.getStringAttribute("houseCard", "")))
        {
          paramActivity = new MinsuChatRowHouse(paramActivity, paramEMMessage, paramInt, this);
        }
        else if ("2".equals(paramEMMessage.getStringAttribute("msgType", "")))
        {
          paramActivity = new MinsuChatRowHouseShare(paramActivity, paramEMMessage, paramInt, this);
        }
        else
        {
          paramActivity = new MinsuChatRowText(paramActivity, paramEMMessage, paramInt, this);
          continue;
          paramActivity = new MinsuChatRowImage(paramActivity, paramEMMessage, paramInt, this);
        }
      }
    }
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public EMMessage getItem(int paramInt)
  {
    if ((this.a != null) && (paramInt < this.a.length)) {
      return this.a[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int n = 16;
    EMMessage localEMMessage = getItem(paramInt);
    if (localEMMessage == null) {
      paramInt = -1;
    }
    for (;;)
    {
      return paramInt;
      if ((this.h != null) && (this.h.getCustomChatRowType(localEMMessage) > 0)) {
        return this.h.getCustomChatRowType(localEMMessage) + 23;
      }
      try
      {
        if (localEMMessage.getType() == EMMessage.Type.TXT)
        {
          if (localEMMessage.getBooleanAttribute("em_revoke", false)) {
            return 14;
          }
          if (localEMMessage.getBooleanAttribute("em_is_big_expression", false))
          {
            if (localEMMessage.direct() != EMMessage.Direct.RECEIVE) {
              break;
            }
            return 13;
          }
          if ("1".equals(localEMMessage.getStringAttribute("msgType", "")))
          {
            paramInt = n;
            if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
              continue;
            }
            return 15;
          }
          if ("2".equals(localEMMessage.getStringAttribute("msgType", "")))
          {
            if (localEMMessage.direct() != EMMessage.Direct.RECEIVE) {
              break label445;
            }
            return 18;
          }
          if ("3".equals(localEMMessage.getStringAttribute("msgType", "")))
          {
            if (localEMMessage.direct() != EMMessage.Direct.RECEIVE) {
              break label448;
            }
            return 20;
          }
          if ("4".equals(localEMMessage.getStringAttribute("msgType", "")))
          {
            if (localEMMessage.direct() != EMMessage.Direct.RECEIVE) {
              break label451;
            }
            return 21;
          }
          if ("1".equals(localEMMessage.getStringAttribute("houseCard", "")))
          {
            paramInt = n;
            if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
              continue;
            }
            return 15;
          }
          EMMessage.Direct localDirect1 = localEMMessage.direct();
          EMMessage.Direct localDirect2 = EMMessage.Direct.RECEIVE;
          if (localDirect1 == localDirect2) {
            return 0;
          }
          return 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (localEMMessage.getType() == EMMessage.Type.IMAGE)
        {
          if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
            return 5;
          }
          return 2;
        }
        if (localEMMessage.getType() == EMMessage.Type.LOCATION)
        {
          if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
            return 4;
          }
          return 3;
        }
        if (localEMMessage.getType() == EMMessage.Type.VOICE)
        {
          if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
            return 7;
          }
          return 6;
        }
        if (localEMMessage.getType() == EMMessage.Type.VIDEO)
        {
          if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
            return 9;
          }
          return 8;
        }
        if (localEMMessage.getType() == EMMessage.Type.FILE)
        {
          if (localEMMessage.direct() == EMMessage.Direct.RECEIVE) {
            return 11;
          }
          return 10;
        }
        com.freelxl.baselibrary.f.d.d("lanzhihong", "message===" + localEMMessage.getType() + "m===" + localEMMessage.toString());
        return -1;
      }
    }
    return 12;
    label445:
    return 17;
    label448:
    return 19;
    label451:
    return 22;
  }
  
  public Drawable getMyBubbleBg()
  {
    return this.k;
  }
  
  public i getOnMessageStatusListener()
  {
    return this.g;
  }
  
  public Drawable getOtherBuddleBg()
  {
    return this.l;
  }
  
  public String getToChatUsername()
  {
    return this.e;
  }
  
  @SuppressLint({"NewApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getItem(paramInt);
    if (paramView == null) {
      paramView = a(this.c, paramViewGroup, paramInt);
    }
    for (;;)
    {
      if (paramViewGroup.getBooleanAttribute("em_revoke", false)) {
        ((MinsuChatRowRevoke)paramView).setUpView(paramViewGroup, paramInt, this.f);
      }
      for (;;)
      {
        ((MinsuChatRow)paramView).setOnMessageStatusListener(this.g);
        return paramView;
        ((MinsuChatRow)paramView).setUpView(paramViewGroup, paramInt, this.f);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    if ((this.h != null) && (this.h.getCustomChatRowTypeCount() > 0)) {
      return this.h.getCustomChatRowTypeCount() + 23;
    }
    return 23;
  }
  
  public boolean isShowAvatar()
  {
    return this.j;
  }
  
  public boolean isShowUserNick()
  {
    return this.i;
  }
  
  public void refresh()
  {
    if (this.b.hasMessages(0)) {
      return;
    }
    Message localMessage = this.b.obtainMessage(0);
    this.b.sendMessage(localMessage);
  }
  
  public void refreshSeekTo(int paramInt)
  {
    this.b.sendMessage(this.b.obtainMessage(0));
    Message localMessage = this.b.obtainMessage(2);
    localMessage.arg1 = paramInt;
    this.b.sendMessage(localMessage);
  }
  
  public void refreshSelectLast()
  {
    this.b.sendMessage(this.b.obtainMessage(0));
    this.b.sendMessage(this.b.obtainMessage(1));
  }
  
  public void setCustomChatRowProvider(f paramf)
  {
    this.h = paramf;
  }
  
  public void setItemClickListener(d paramd)
  {
    this.f = paramd;
  }
  
  public void setMyBubbleBg(Drawable paramDrawable)
  {
    this.k = paramDrawable;
  }
  
  public void setOnMessageStatusListener(i parami)
  {
    this.g = parami;
  }
  
  public void setOtherBuddleBg(Drawable paramDrawable)
  {
    this.l = paramDrawable;
  }
  
  public void setShowAvatar(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setShowUserNick(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */