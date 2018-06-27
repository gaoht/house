package com.ziroom.ziroomcustomer.minsu.chat;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.freelxl.baselibrary.f.g;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMSearchDirection;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Type;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.chat.b.e;
import com.ziroom.ziroomcustomer.minsu.chat.d.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MinsuChatShowBigImageListActivity
  extends BaseActivity
{
  e a;
  private String b;
  private ViewPager c;
  private String d;
  private EMConversation e;
  private List<EMMessage> f;
  private List<EMMessage> g;
  private final int r = 5;
  private final int s = 50;
  private boolean t = true;
  private NetworkConnectChangedReceiver u;
  
  private void a()
  {
    this.u = new NetworkConnectChangedReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.u, localIntentFilter);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    g.textToast(this, "网络连接失败，请检查网络设置");
    this.a.notifyDataSetChanged();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968587, 2130968589);
  }
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903343);
    this.c = ((ViewPager)findViewById(2131691037));
    this.b = getIntent().getExtras().getString("messageId");
    paramBundle = EMClient.getInstance().chatManager().getMessage(this.b);
    if (paramBundle.getChatType() == EMMessage.ChatType.Chat) {
      if (paramBundle.direct() == EMMessage.Direct.RECEIVE) {
        this.d = paramBundle.getFrom();
      }
    }
    for (;;)
    {
      this.e = EMClient.getInstance().chatManager().getConversation(this.d);
      if (this.e == null)
      {
        g.textToast(this, "会话不存在！");
        finish();
      }
      this.g = new ArrayList();
      this.f = new ArrayList();
      Object localObject1 = this.e.searchMsgFromDB(paramBundle.getMsgTime(), 50, EMConversation.EMSearchDirection.DOWN);
      Object localObject2 = this.e.searchMsgFromDB(paramBundle.getMsgTime(), 50, EMConversation.EMSearchDirection.UP);
      this.f.addAll((Collection)localObject2);
      this.f.add(paramBundle);
      this.f.addAll((Collection)localObject1);
      localObject1 = this.f.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EMMessage)((Iterator)localObject1).next();
        if (EMMessage.Type.IMAGE == ((EMMessage)localObject2).getType()) {
          this.g.add(localObject2);
        }
      }
      this.d = paramBundle.getTo();
      continue;
      this.d = paramBundle.getTo();
    }
    this.a = new e(this, this.g);
    this.c.setOffscreenPageLimit(2);
    this.c.setAdapter(this.a);
    this.c.setCurrentItem(this.g.indexOf(paramBundle));
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.u);
  }
  
  public class NetworkConnectChangedReceiver
    extends BroadcastReceiver
  {
    public NetworkConnectChangedReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = d.isNetworkConnAndAvailable(MinsuChatShowBigImageListActivity.this);
      if (bool != MinsuChatShowBigImageListActivity.a(MinsuChatShowBigImageListActivity.this))
      {
        MinsuChatShowBigImageListActivity.a(MinsuChatShowBigImageListActivity.this, bool);
        if (bool) {
          MinsuChatShowBigImageListActivity.b(MinsuChatShowBigImageListActivity.this, true);
        }
      }
      else
      {
        return;
      }
      MinsuChatShowBigImageListActivity.b(MinsuChatShowBigImageListActivity.this, false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatShowBigImageListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */