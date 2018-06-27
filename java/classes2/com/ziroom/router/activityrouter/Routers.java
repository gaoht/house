package com.ziroom.router.activityrouter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Routers
{
  public static String KEY_ORIGINAL_URL = "com.ziroom.router.OriginalUrl";
  private static List<Mapping> mappings = new ArrayList();
  
  private static boolean doOpen(Context paramContext, Uri paramUri, Bundle paramBundle, int paramInt)
  {
    initIfNeed();
    Object localObject = Path.create(paramUri);
    Iterator localIterator = mappings.iterator();
    while (localIterator.hasNext())
    {
      Mapping localMapping = (Mapping)localIterator.next();
      if (localMapping.match((Path)localObject))
      {
        if (localMapping.getActivity() == null)
        {
          localMapping.getMethod().invoke(paramContext, localMapping.parseExtras(paramUri));
          return true;
        }
        localObject = new Intent(paramContext, localMapping.getActivity());
        ((Intent)localObject).putExtras(localMapping.parseExtras(paramUri));
        ((Intent)localObject).putExtra(KEY_ORIGINAL_URL, paramUri.toString());
        if (paramBundle != null) {
          ((Intent)localObject).putExtras(paramBundle);
        }
        if (!(paramContext instanceof Activity)) {
          ((Intent)localObject).addFlags(268435456);
        }
        if (paramInt >= 0) {
          if ((paramContext instanceof Activity)) {
            ((Activity)paramContext).startActivityForResult((Intent)localObject, paramInt);
          }
        }
        for (;;)
        {
          return true;
          throw new RuntimeException("can not startActivityForResult context " + paramContext);
          paramContext.startActivity((Intent)localObject);
        }
      }
    }
    return false;
  }
  
  private static Class<? extends Activity> getActivityByUri(Uri paramUri)
  {
    paramUri = Path.create(paramUri);
    Iterator localIterator = mappings.iterator();
    while (localIterator.hasNext())
    {
      Mapping localMapping = (Mapping)localIterator.next();
      if (localMapping.match(paramUri)) {
        return localMapping.getActivity();
      }
    }
    return null;
  }
  
  private static RouterCallback getGlobalCallback(Context paramContext)
  {
    if ((paramContext.getApplicationContext() instanceof RouterCallbackProvider)) {
      return ((RouterCallbackProvider)paramContext.getApplicationContext()).provideRouterCallback();
    }
    return null;
  }
  
  private static void initIfNeed()
  {
    if (!mappings.isEmpty()) {
      return;
    }
    RouterInit.init();
    sort();
  }
  
  static void map(String paramString, Class<? extends Activity> paramClass, MethodInvoker paramMethodInvoker, ExtraTypes paramExtraTypes)
  {
    mappings.add(new Mapping(paramString, paramClass, paramMethodInvoker, paramExtraTypes));
  }
  
  public static boolean open(Context paramContext, Uri paramUri)
  {
    return open(paramContext, paramUri, null, getGlobalCallback(paramContext));
  }
  
  public static boolean open(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    return open(paramContext, paramUri, paramBundle, getGlobalCallback(paramContext));
  }
  
  private static boolean open(Context paramContext, Uri paramUri, Bundle paramBundle, int paramInt, RouterCallback paramRouterCallback)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramRouterCallback != null) && (paramRouterCallback.beforeOpen(paramContext, paramUri))) {
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      try
      {
        bool1 = doOpen(paramContext, paramUri, paramBundle, paramInt);
        bool2 = bool1;
        if (paramRouterCallback != null) {
          if (bool1)
          {
            paramRouterCallback.afterOpen(paramContext, paramUri);
            return bool1;
          }
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          bool1 = bool2;
          if (paramRouterCallback != null)
          {
            paramRouterCallback.error(paramContext, paramUri, paramBundle);
            bool1 = bool2;
          }
        }
        paramRouterCallback.notFound(paramContext, paramUri);
      }
    }
    return bool1;
  }
  
  public static boolean open(Context paramContext, Uri paramUri, Bundle paramBundle, RouterCallback paramRouterCallback)
  {
    return open(paramContext, paramUri, paramBundle, -1, paramRouterCallback);
  }
  
  public static boolean open(Context paramContext, Uri paramUri, RouterCallback paramRouterCallback)
  {
    return open(paramContext, paramUri, null, paramRouterCallback);
  }
  
  public static boolean open(Context paramContext, String paramString)
  {
    return open(paramContext, Uri.parse(paramString), null, getGlobalCallback(paramContext));
  }
  
  public static boolean open(Context paramContext, String paramString, Bundle paramBundle)
  {
    return open(paramContext, Uri.parse(paramString), paramBundle, getGlobalCallback(paramContext));
  }
  
  public static boolean open(Context paramContext, String paramString, Bundle paramBundle, RouterCallback paramRouterCallback)
  {
    return open(paramContext, Uri.parse(paramString), paramBundle, paramRouterCallback);
  }
  
  public static boolean open(Context paramContext, String paramString, RouterCallback paramRouterCallback)
  {
    return open(paramContext, Uri.parse(paramString), null, paramRouterCallback);
  }
  
  public static boolean openForResult(Context paramContext, Uri paramUri, int paramInt)
  {
    return openForResult(paramContext, paramUri, null, paramInt, getGlobalCallback(paramContext));
  }
  
  public static boolean openForResult(Context paramContext, Uri paramUri, int paramInt, RouterCallback paramRouterCallback)
  {
    return openForResult(paramContext, paramUri, null, paramInt, paramRouterCallback);
  }
  
  public static boolean openForResult(Context paramContext, Uri paramUri, Bundle paramBundle, int paramInt)
  {
    return openForResult(paramContext, paramUri, paramBundle, paramInt, getGlobalCallback(paramContext));
  }
  
  public static boolean openForResult(Context paramContext, Uri paramUri, Bundle paramBundle, int paramInt, RouterCallback paramRouterCallback)
  {
    return open(paramContext, paramUri, paramBundle, paramInt, paramRouterCallback);
  }
  
  public static boolean openForResult(Context paramContext, String paramString, int paramInt)
  {
    return openForResult(paramContext, Uri.parse(paramString), null, paramInt, getGlobalCallback(paramContext));
  }
  
  public static boolean openForResult(Context paramContext, String paramString, int paramInt, RouterCallback paramRouterCallback)
  {
    return openForResult(paramContext, Uri.parse(paramString), null, paramInt, paramRouterCallback);
  }
  
  public static boolean openForResult(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    return openForResult(paramContext, Uri.parse(paramString), paramBundle, paramInt, getGlobalCallback(paramContext));
  }
  
  public static boolean openForResult(Context paramContext, String paramString, Bundle paramBundle, int paramInt, RouterCallback paramRouterCallback)
  {
    return openForResult(paramContext, Uri.parse(paramString), paramBundle, paramInt, paramRouterCallback);
  }
  
  public static Intent resolve(Context paramContext, Uri paramUri)
  {
    initIfNeed();
    Path localPath = Path.create(paramUri);
    Iterator localIterator = mappings.iterator();
    while (localIterator.hasNext())
    {
      Mapping localMapping = (Mapping)localIterator.next();
      if (localMapping.match(localPath))
      {
        paramContext = new Intent(paramContext, localMapping.getActivity());
        paramContext.putExtras(localMapping.parseExtras(paramUri));
        paramContext.putExtra(KEY_ORIGINAL_URL, paramUri.toString());
        return paramContext;
      }
    }
    return null;
  }
  
  public static Intent resolve(Context paramContext, String paramString)
  {
    return resolve(paramContext, Uri.parse(paramString));
  }
  
  private static void sort()
  {
    Collections.sort(mappings, new Comparator()
    {
      public int compare(Mapping paramAnonymousMapping1, Mapping paramAnonymousMapping2)
      {
        return paramAnonymousMapping1.getFormat().compareTo(paramAnonymousMapping2.getFormat()) * -1;
      }
    });
  }
  
  public static void updateRouterMapping(ArrayList<UpdateRouterInfo> paramArrayList)
  {
    if ((mappings == null) || (paramArrayList == null)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        UpdateRouterInfo localUpdateRouterInfo = (UpdateRouterInfo)paramArrayList.next();
        updateTargetActivity(getActivityByUri(localUpdateRouterInfo.getNewPageUri()), localUpdateRouterInfo);
      }
    }
  }
  
  private static void updateTargetActivity(Class<? extends Activity> paramClass, UpdateRouterInfo paramUpdateRouterInfo)
  {
    if (paramClass != null)
    {
      paramUpdateRouterInfo = Path.create(paramUpdateRouterInfo.getTargetNeedReplayUri());
      Iterator localIterator = mappings.iterator();
      while (localIterator.hasNext())
      {
        Mapping localMapping = (Mapping)localIterator.next();
        if (localMapping.match(paramUpdateRouterInfo)) {
          localMapping.updateActivity(paramClass);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/Routers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */