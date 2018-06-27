package com.growingio.android.sdk.collection;

import android.view.View;
import com.growingio.android.sdk.models.i;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VdsJsBridgeManager
{
  private static VdsJsBridgeManager a;
  private List<SnapshotCallback> b = new ArrayList();
  
  public static VdsJsBridgeManager getInstance()
  {
    if (a == null) {
      a = new VdsJsBridgeManager();
    }
    return a;
  }
  
  public static void hookWebViewIfNeeded(View paramView)
  {
    Object localObject = GConfig.s();
    if ((localObject == null) || (!((GConfig)localObject).q()) || (Util.b(paramView))) {}
    while (paramView.getTag(84159240) != null) {
      return;
    }
    localObject = ViewHelper.a(paramView, null);
    VdsJsHelper localVdsJsHelper = new VdsJsHelper(paramView);
    if (localObject != null) {
      ((VdsJsHelper)localVdsJsHelper).update((i)localObject, false);
    }
    paramView.setTag(84159240, localVdsJsHelper);
    LogUtil.d("VdsManager", new Object[] { "hookWebViewIfNeeded: hooked ", paramView, " with node ", localObject });
  }
  
  public static boolean isWebViewHooked(View paramView)
  {
    paramView = paramView.getTag(84159240);
    return (paramView != null) && ((paramView instanceof VdsJsHelper));
  }
  
  public static void updateViewNodeIfNeeded(View paramView, i parami, boolean paramBoolean)
  {
    paramView = paramView.getTag(84159240);
    if ((paramView != null) && ((paramView instanceof VdsJsHelper))) {
      ((VdsJsHelper)paramView).update(parami, paramBoolean);
    }
  }
  
  public String getCirclePluginSrc()
  {
    return String.format("javascript:(function(){try{var p=document.createElement('script');p.src='%s';document.head.appendChild(p);}catch(e){}})()", new Object[] { String.format("https://assets.growingio.com/sdk/hybrid/1.0/vds_hybrid_circle_plugin.min.js?sdkVer=%s&platform=Android", new Object[] { "1.1.2_dcb91e54" }) });
  }
  
  public void onSnapshotFinished(VdsJsHelper paramVdsJsHelper, List<i> paramList)
  {
    paramVdsJsHelper = this.b.iterator();
    while (paramVdsJsHelper.hasNext()) {
      ((SnapshotCallback)paramVdsJsHelper.next()).a(paramList);
    }
  }
  
  public void registerSnapshotCallback(SnapshotCallback paramSnapshotCallback)
  {
    if (this.b.indexOf(paramSnapshotCallback) == -1) {
      this.b.add(paramSnapshotCallback);
    }
  }
  
  public boolean unregisterSnapshotCallback(SnapshotCallback paramSnapshotCallback)
  {
    return this.b.remove(paramSnapshotCallback);
  }
  
  public static abstract interface SnapshotCallback
  {
    public abstract void a(List<i> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/VdsJsBridgeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */