package com.ziroom.ziroomcustomer.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BedRoomUnlockHistoryActivity
  extends BaseActivity
{
  Handler a = new Handler()
  {
    public void dispatchMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      } while (!paramAnonymousMessage.getSuccess().booleanValue());
      paramAnonymousMessage = (Map)paramAnonymousMessage.getObject();
      BedRoomUnlockHistoryActivity.a(BedRoomUnlockHistoryActivity.this);
      BedRoomUnlockHistoryActivity.this.b();
    }
  };
  private ListView b;
  private List<Map<String, String>> c;
  private SimpleAdapter d;
  
  private void e() {}
  
  protected void a()
  {
    this.c = new ArrayList();
    int i = 0;
    while (i < 30)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("person", "person" + i);
      localHashMap.put("phoneNum", String.valueOf(1353456789));
      localHashMap.put("time", m.GetNowDateTime());
      this.c.add(localHashMap);
      i += 1;
    }
  }
  
  protected void b()
  {
    this.b.setAdapter(this.d);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903105);
    this.b = ((ListView)findViewById(2131689979));
    a();
    e();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/BedRoomUnlockHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */