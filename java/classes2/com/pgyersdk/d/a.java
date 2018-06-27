package com.pgyersdk.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.pgyersdk.i.m;
import com.pgyersdk.views.q;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class a
{
  public static boolean b = false;
  private static a f = null;
  private static c r;
  public b a = null;
  public String c;
  public String d;
  public String e = "";
  private com.pgyersdk.views.g g;
  private int h;
  private Handler i;
  private Dialog j;
  private Context k;
  private String l = "";
  private File m;
  private Boolean n = Boolean.valueOf(false);
  private DialogInterface o;
  private boolean p = false;
  private Map q = new HashMap();
  
  private void a(Context paramContext, String paramString)
  {
    View localView = ((Activity)paramContext).getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = localView.getDrawingCache();
    com.pgyersdk.i.g.a("takeScreenshot filepath", paramString);
    com.pgyersdk.i.b.a(new h(this, localBitmap, paramString, paramContext, localView));
  }
  
  private boolean a(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
  }
  
  /* Error */
  private static void b(DialogInterface paramDialogInterface, Boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 148	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 153	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   7: ldc -101
    //   9: invokevirtual 159	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   12: astore_2
    //   13: aload_2
    //   14: iconst_1
    //   15: invokevirtual 164	java/lang/reflect/Field:setAccessible	(Z)V
    //   18: aload_2
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 168	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   24: return
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   30: return
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 172	java/lang/NoSuchFieldException:printStackTrace	()V
    //   36: return
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   42: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramDialogInterface	DialogInterface
    //   0	43	1	paramBoolean	Boolean
    //   12	7	2	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   18	24	25	java/lang/IllegalAccessException
    //   0	18	31	java/lang/NoSuchFieldException
    //   18	24	31	java/lang/NoSuchFieldException
    //   26	30	31	java/lang/NoSuchFieldException
    //   38	42	31	java/lang/NoSuchFieldException
    //   18	24	37	java/lang/IllegalArgumentException
  }
  
  private void c()
  {
    this.i = new i(this);
  }
  
  public static a getInstance()
  {
    if (f == null)
    {
      f = new a();
      f.c();
    }
    return f;
  }
  
  public static void setIScreenShotListener(c paramc)
  {
    r = paramc;
  }
  
  public void destroy()
  {
    com.pgyersdk.i.d.a().a(com.pgyersdk.i.d.a().b(this.k));
    com.pgyersdk.i.d.a().b();
    com.pgyersdk.i.a.getInstance().destroy();
    if (this.a != null) {
      this.a.b();
    }
    this.g = null;
    f = null;
    this.p = false;
  }
  
  public void sendFeedback(Context paramContext, String paramString1, String paramString2, File paramFile, String paramString3, Boolean paramBoolean)
  {
    if (this.k == null) {
      this.k = paramContext;
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
    {
      paramContext = Toast.makeText(this.k, com.pgyersdk.b.b.a(1057), 0);
      if (!(paramContext instanceof Toast))
      {
        paramContext.show();
        return;
      }
      VdsAgent.showToast((Toast)paramContext);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!com.pgyersdk.i.k.a(paramString3))
    {
      if (paramBoolean.booleanValue()) {
        break label153;
      }
      if ((this.g.d() != null) && (this.g.d().isChecked()) && (a(paramContext))) {
        localArrayList.add(paramString3);
      }
    }
    while (com.pgyersdk.i.k.a(paramString1))
    {
      paramContext = Toast.makeText(paramContext, com.pgyersdk.b.b.a(1063), 0);
      if (!(paramContext instanceof Toast))
      {
        paramContext.show();
        return;
        label153:
        localArrayList.add(paramString3);
      }
      else
      {
        VdsAgent.showToast((Toast)paramContext);
        return;
      }
    }
    if (!m.a(paramString1))
    {
      paramContext = Toast.makeText(paramContext, com.pgyersdk.b.b.a(1046), 0);
      if (!(paramContext instanceof Toast))
      {
        paramContext.show();
        return;
      }
      VdsAgent.showToast((Toast)paramContext);
      return;
    }
    if (!paramBoolean.booleanValue()) {
      com.pgyersdk.i.i.a(paramContext, "selfmail", VdsAgent.trackEditTextSilent(this.g.b()).toString());
    }
    if (this.o != null) {
      b(this.o, Boolean.valueOf(true));
    }
    if ((this.j != null) && (this.j.isShowing())) {
      this.j.dismiss();
    }
    paramContext = new com.pgyersdk.g.k(paramContext, paramString1, "http://www.pgyer.com/apiv1/feedback/add", paramString2, localArrayList, paramFile, "", this.i, this.e);
    paramContext.a(true);
    com.pgyersdk.i.b.a(paramContext);
  }
  
  public a setCallback(b paramb)
  {
    this.a = paramb;
    return f;
  }
  
  public a setGLSurface(boolean paramBoolean)
  {
    b = paramBoolean;
    return f;
  }
  
  public void setMoreParam(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.q.put(paramString1, paramString2);
    this.e = new JSONObject(this.q).toString();
  }
  
  public a setTheme(int paramInt)
  {
    this.h = paramInt;
    return f;
  }
  
  public void showActivity(Context paramContext)
  {
    if (this.p) {}
    do
    {
      return;
      this.p = true;
      if (this.a != null) {
        this.a.a();
      }
      this.k = paramContext;
      this.n = Boolean.valueOf(false);
      com.pgyersdk.e.c.a(paramContext);
    } while (!(paramContext instanceof Activity));
    if (!b)
    {
      this.l = com.pgyersdk.i.d.a().a(paramContext);
      a(paramContext, this.l);
      return;
    }
    com.pgyersdk.i.a.getInstance().setContext(paramContext);
    com.pgyersdk.i.a.getInstance().setScreenShot(true);
  }
  
  public com.pgyersdk.views.g showDialog(Context paramContext)
  {
    return showDialog(paramContext, false);
  }
  
  public com.pgyersdk.views.g showDialog(Context paramContext, boolean paramBoolean)
  {
    this.k = paramContext;
    this.n = Boolean.valueOf(true);
    com.pgyersdk.e.c.a(paramContext);
    com.pgyersdk.a.a.c(paramContext);
    if (this.g != null) {
      return this.g;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.h == 0) {
        this.h = 3;
      }
      if (paramBoolean)
      {
        this.g = new q(paramContext, this.h);
        this.g.setCancelable(true);
        if (!paramBoolean) {
          break label272;
        }
        this.g.setOnCancelListener(new f(this, paramBoolean));
        if (Build.VERSION.SDK_INT >= 17) {
          this.g.setOnDismissListener(new g(this, paramBoolean));
        }
        this.j = this.g.create();
        paramContext = this.j;
        if ((paramContext instanceof Dialog)) {
          break label370;
        }
        paramContext.show();
      }
    }
    for (;;)
    {
      return this.g;
      if (this.a != null) {
        this.a.a();
      }
      this.g = new com.pgyersdk.views.g(paramContext, this.h);
      this.g.setCancelable(false);
      break;
      if (paramBoolean)
      {
        this.g = new q(paramContext);
        this.g.setCancelable(true);
        break;
      }
      if (this.a != null) {
        this.a.a();
      }
      this.g = new com.pgyersdk.views.g(paramContext);
      this.g.setCancelable(false);
      break;
      label272:
      if ((paramContext instanceof Activity))
      {
        if (b) {
          break label353;
        }
        this.l = com.pgyersdk.i.d.a().a(paramContext);
        a(paramContext, this.l);
      }
      for (;;)
      {
        this.g.setPositiveButton(com.pgyersdk.b.b.a(1048), new d(this));
        this.g.setNegativeButton(com.pgyersdk.b.b.a(1049), new e(this, paramContext));
        break;
        label353:
        com.pgyersdk.i.a.getInstance().setContext(paramContext);
        com.pgyersdk.i.a.getInstance().setScreenShot(true);
      }
      label370:
      VdsAgent.showDialog((Dialog)paramContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */