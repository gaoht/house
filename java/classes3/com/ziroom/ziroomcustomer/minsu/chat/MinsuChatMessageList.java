package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.ziroom.ziroomcustomer.R.styleable;

public class MinsuChatMessageList
  extends RelativeLayout
{
  protected ListView a;
  protected SwipeRefreshLayout b;
  protected Context c;
  protected EMConversation d;
  protected int e;
  protected String f;
  protected g g;
  protected boolean h;
  protected boolean i;
  protected Drawable j;
  protected Drawable k;
  
  public MinsuChatMessageList(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinsuChatMessageList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MinsuChatMessageList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    LayoutInflater.from(paramContext).inflate(2130904887, this);
    this.b = ((SwipeRefreshLayout)findViewById(2131696854));
    this.a = ((ListView)findViewById(2131691217));
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MinsuChatMessageList);
    this.i = paramContext.getBoolean(2, true);
    this.j = paramContext.getDrawable(0);
    this.k = paramContext.getDrawable(0);
    this.h = paramContext.getBoolean(3, false);
    paramContext.recycle();
  }
  
  public EMMessage getItem(int paramInt)
  {
    return this.g.getItem(paramInt);
  }
  
  public ListView getListView()
  {
    return this.a;
  }
  
  public SwipeRefreshLayout getSwipeRefreshLayout()
  {
    return this.b;
  }
  
  public void init(String paramString, int paramInt, f paramf)
  {
    this.e = paramInt;
    this.f = paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.g = new g((Activity)this.c, paramString, paramInt, this.a);
      this.g.setShowAvatar(this.i);
      this.g.setShowUserNick(this.h);
      this.g.setMyBubbleBg(this.j);
      this.g.setOtherBuddleBg(this.k);
      this.g.setCustomChatRowProvider(paramf);
      this.a.setAdapter(this.g);
      refreshSelectLast();
      return;
      this.d = EMClient.getInstance().chatManager().getConversation(paramString, EMConversation.EMConversationType.Chat, true);
      continue;
      this.d = EMClient.getInstance().chatManager().getConversation(paramString, EMConversation.EMConversationType.GroupChat, true);
    }
  }
  
  public boolean isShowUserNick()
  {
    return this.h;
  }
  
  public void refresh()
  {
    this.g.refresh();
  }
  
  public void refreshSeekTo(int paramInt)
  {
    this.g.refreshSeekTo(paramInt);
  }
  
  public void refreshSelectLast()
  {
    if (this.g != null) {
      this.g.refreshSelectLast();
    }
  }
  
  public void scrollToListViewBottom()
  {
    this.a.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        if ((MinsuChatMessageList.this.g != null) && (MinsuChatMessageList.this.g.getCount() > 0))
        {
          MinsuChatMessageList.this.a.setSelection(MinsuChatMessageList.this.g.getCount() - 1);
          MinsuChatMessageList.this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        return true;
      }
    });
  }
  
  public void setCustomChatRowProvider(f paramf)
  {
    this.g.setCustomChatRowProvider(paramf);
  }
  
  public void setItemClickListener(d paramd)
  {
    this.g.setItemClickListener(paramd);
  }
  
  public void setOnMessageStatusAdapter(i parami)
  {
    this.g.setOnMessageStatusListener(parami);
  }
  
  public void setShowUserNick(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatMessageList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */