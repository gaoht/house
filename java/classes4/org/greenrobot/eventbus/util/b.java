package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.os.Bundle;

public abstract class b<T>
{
  protected final a a;
  
  protected abstract T a(d paramd, Bundle paramBundle);
  
  protected T a(d paramd, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramd.isSuppressErrorUi()) {
      return null;
    }
    if (paramBundle != null) {}
    for (paramBundle = (Bundle)paramBundle.clone();; paramBundle = new Bundle())
    {
      if (!paramBundle.containsKey("de.greenrobot.eventbus.errordialog.title")) {
        paramBundle.putString("de.greenrobot.eventbus.errordialog.title", b(paramd, paramBundle));
      }
      if (!paramBundle.containsKey("de.greenrobot.eventbus.errordialog.message")) {
        paramBundle.putString("de.greenrobot.eventbus.errordialog.message", c(paramd, paramBundle));
      }
      if (!paramBundle.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
        paramBundle.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", paramBoolean);
      }
      if ((!paramBundle.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close")) && (this.a.i != null)) {
        paramBundle.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.a.i);
      }
      if ((!paramBundle.containsKey("de.greenrobot.eventbus.errordialog.icon_id")) && (this.a.h != 0)) {
        paramBundle.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.a.h);
      }
      return (T)a(paramd, paramBundle);
    }
  }
  
  protected String b(d paramd, Bundle paramBundle)
  {
    return this.a.a.getString(this.a.b);
  }
  
  protected String c(d paramd, Bundle paramBundle)
  {
    int i = this.a.getMessageIdForThrowable(paramd.a);
    return this.a.a.getString(i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */