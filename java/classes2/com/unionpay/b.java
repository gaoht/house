package com.unionpay;

import android.os.Handler.Callback;
import android.os.Message;
import android.util.Base64;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.f;
import org.json.JSONArray;
import org.json.JSONObject;

final class b
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      try
      {
        if (paramMessage.obj != null)
        {
          localObject = new JSONObject((String)paramMessage.obj);
          str1 = f.a((JSONObject)localObject, "sign");
          i = 0;
        }
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          Object localObject;
          String str1;
          int i;
          int j;
          label73:
          String str2;
          paramMessage.printStackTrace();
        }
      }
      try
      {
        j = Integer.parseInt(UPPayAssistEx.g());
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label73;
      }
      localObject = new String(Base64.decode(((JSONObject)localObject).getString("configs"), 2));
      str2 = com.unionpay.utils.b.a(UPUtils.a((String)localObject + UPPayAssistEx.h()));
      if (UPUtils.forConfig(i, str1).equals(str2))
      {
        UPUtils.a(UPPayAssistEx.c(), (String)paramMessage.obj, "configs");
        UPUtils.a(UPPayAssistEx.c(), UPPayAssistEx.g(), "mode");
        UPUtils.a(UPPayAssistEx.c(), UPPayAssistEx.h(), "or");
        if (!UPPayAssistEx.i()) {
          UPPayAssistEx.a(UPPayAssistEx.a(new JSONArray((String)localObject), "sort"));
        }
      }
      if (!UPPayAssistEx.i())
      {
        UPPayAssistEx.a(UPPayAssistEx.c(), UPPayAssistEx.j(), UPPayAssistEx.k());
        continue;
        UPPayAssistEx.l();
        UPPayAssistEx.a(UPPayAssistEx.c(), UPPayAssistEx.j(), UPPayAssistEx.k());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */