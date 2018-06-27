package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.minsu.f.k;
import org.json.JSONArray;
import org.json.JSONObject;

public class MinsuChatRowHouseShare
  extends MinsuChatRow
{
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private SimpleDraweeView y;
  private Activity z;
  
  public MinsuChatRowHouseShare(Activity paramActivity, EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramActivity, paramEMMessage, paramInt, paramBaseAdapter);
    this.z = paramActivity;
  }
  
  private String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramInt == 0) {
        return "整套出租";
      }
      return "独立房间";
    }
    return paramString;
  }
  
  private void b(EMMessage paramEMMessage)
  {
    try
    {
      Object localObject = paramEMMessage.getJSONArrayAttribute("shareHouseMsg").getJSONObject(0);
      paramEMMessage = ((JSONObject)localObject).optString("fid");
      int i = ((JSONObject)localObject).optInt("rentWay");
      localObject = ((JSONObject)localObject).optString("isTop50Online");
      k.toHouseDetail(this.z, paramEMMessage, String.valueOf(i), "1".equals(localObject), "MinsuChatDetail");
      return;
    }
    catch (Exception paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
  }
  
  protected void a(EMMessage paramEMMessage)
  {
    b(paramEMMessage);
  }
  
  protected void g()
  {
    LayoutInflater localLayoutInflater = this.b;
    if (this.e.direct() == EMMessage.Direct.RECEIVE) {}
    for (int i = 2130904918;; i = 2130904924)
    {
      localLayoutInflater.inflate(i, this);
      return;
    }
  }
  
  protected void h()
  {
    this.t = ((TextView)findViewById(2131694581));
    this.u = ((TextView)findViewById(2131694587));
    this.v = ((TextView)findViewById(2131694582));
    this.w = ((TextView)findViewById(2131694582));
    this.x = ((TextView)findViewById(2131694587));
    this.y = ((SimpleDraweeView)findViewById(2131696911));
  }
  
  protected void i()
  {
    if ((this.d instanceof g))
    {
      ((g)this.d).refresh();
      return;
    }
    this.d.notifyDataSetChanged();
  }
  
  protected void j()
  {
    if (this.e.direct() == EMMessage.Direct.SEND)
    {
      d();
      switch (1.a[this.e.status().ordinal()])
      {
      }
    }
    while ((this.e.isAcked()) || (this.e.getChatType() != EMMessage.ChatType.Chat) || (this.e.getBooleanAttribute("em_readFire", false)))
    {
      return;
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      return;
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      return;
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      return;
      this.l.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    try
    {
      EMClient.getInstance().chatManager().ackMessageRead(this.e.getFrom(), this.e.getMsgId());
      this.e.setAcked(true);
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  public void onSetUpView()
  {
    try
    {
      Object localObject2 = this.e.getJSONArrayAttribute("shareHouseMsg").getJSONObject(0);
      String str1 = ((JSONObject)localObject2).optString("price");
      Object localObject1 = ((JSONObject)localObject2).optString("name");
      int i = Integer.parseInt(((JSONObject)localObject2).optString("rentWay"));
      String str2 = ((JSONObject)localObject2).optString("rentWayName");
      String str3 = ((JSONObject)localObject2).optString("city");
      localObject2 = ((JSONObject)localObject2).optString("picUrl");
      String str4 = this.z.getString(2131297451);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str3);
      localStringBuffer.append(str4);
      localStringBuffer.append("|");
      localStringBuffer.append(str4);
      localStringBuffer.append(a(i, str2));
      this.t.setText((CharSequence)localObject1);
      this.y.setController(c.frescoController((String)localObject2));
      localObject1 = this.y.getTag(2131689523);
      if ((localObject1 == null) || (String.valueOf(localObject1).equals(localObject2)))
      {
        c.loadHolderImage(this.y, (String)localObject2);
        this.y.setTag(2131689523, localObject2);
      }
      this.w.setText("¥" + str1 + "/晚");
      this.x.setText(localStringBuffer.toString());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    j();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatRowHouseShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */