package com.unionpay;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

final class a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    localObject1 = (DownloadManager)paramContext.getSystemService("download");
    long l1 = paramIntent.getLongExtra("extra_download_id", -1L);
    long l2 = UPUtils.c(paramContext, "id");
    if (l2 == l1)
    {
      localIntent = new Intent("android.intent.action.VIEW");
      localObject1 = ((DownloadManager)localObject1).getUriForDownloadedFile(l2);
      paramIntent = "";
      if (localObject1 != null) {
        try
        {
          Object localObject2 = new FileInputStream(new File(((Uri)localObject1).getPath()));
          Object localObject3 = paramContext.getFilesDir().getAbsolutePath();
          if (localObject3 != null)
          {
            paramIntent = (String)localObject3 + File.separator + UPPayAssistEx.a();
            localObject3 = paramContext.openFileOutput(UPPayAssistEx.a(), 1);
            byte[] arrayOfByte = new byte['Ѐ'];
            for (;;)
            {
              int i = ((FileInputStream)localObject2).read(arrayOfByte);
              if (i <= 0) {
                break;
              }
              ((FileOutputStream)localObject3).write(arrayOfByte, 0, i);
            }
          }
          try
          {
            localObject2 = b.b(paramIntent);
            if (UPPayAssistEx.b().equalsIgnoreCase((String)localObject2)) {
              if (!UPPayAssistEx.checkInstalled(UPPayAssistEx.c()))
              {
                localIntent.setDataAndType(Uri.parse("file:" + paramIntent), UPPayAssistEx.d());
                localIntent.addFlags(268435456);
                paramContext.startActivity(localIntent);
              }
            }
            for (;;)
            {
              g.b("uppay", "downloadFileUri" + localObject1);
              paramContext.unregisterReceiver(UPPayAssistEx.e());
              UPPayAssistEx.f();
              return;
              ((FileOutputStream)localObject3).close();
              ((FileInputStream)localObject2).close();
              break;
              b.c(((Uri)localObject1).getPath());
            }
          }
          catch (FileNotFoundException paramIntent)
          {
            for (;;) {}
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          paramIntent = ((Uri)localObject1).getPath();
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */