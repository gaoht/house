package com.ziroom.ziroomcustomer.newchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.hyphenate.chat.EMMessage.Type;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class ContextMenu
  extends BaseActivity
{
  private int a;
  
  public void copy(View paramView)
  {
    setResult(1, new Intent().putExtra("position", this.a));
    finish();
  }
  
  public void delete(View paramView)
  {
    setResult(2, new Intent().putExtra("position", this.a));
    finish();
  }
  
  public void download(View paramView)
  {
    setResult(5, new Intent().putExtra("position", this.a));
    finish();
  }
  
  public void forward(View paramView)
  {
    setResult(3, new Intent().putExtra("position", this.a));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EMMessage.Type.TXT.ordinal();
    int i = getIntent().getIntExtra("type", -1);
    if (i == EMMessage.Type.TXT.ordinal()) {
      setContentView(2130903697);
    }
    for (;;)
    {
      this.a = getIntent().getIntExtra("position", -1);
      return;
      if (i == EMMessage.Type.IMAGE.ordinal()) {
        setContentView(2130903696);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    finish();
    return true;
  }
  
  public void open(View paramView)
  {
    setResult(4, new Intent().putExtra("position", this.a));
    finish();
  }
  
  public void toCloud(View paramView)
  {
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/ContextMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */