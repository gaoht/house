package com.growingio.android.sdk.agent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Rect;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.collection.VdsJsBridgeManager;
import com.growingio.android.sdk.models.a;
import com.growingio.android.sdk.models.i;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.ViewHelper;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import java.lang.reflect.Field;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

@Instrumented
public class VdsAgent
{
  private static a a = new a(null);
  
  private static List<android.app.Fragment> a(android.app.Fragment paramFragment)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramFragment = paramFragment.getChildFragmentManager();
      try
      {
        Field localField = paramFragment.getClass().getDeclaredField("mActive");
        localField.setAccessible(true);
        paramFragment = (List)localField.get(paramFragment);
        return paramFragment;
      }
      catch (Exception paramFragment)
      {
        Log.w("GIO.VdsAgent", "getChildFragments failed. " + paramFragment.getMessage());
      }
    }
    return null;
  }
  
  private static void a()
  {
    MessageProcessor localMessageProcessor = MessageProcessor.e();
    if ((localMessageProcessor != null) && (localMessageProcessor.a())) {
      localMessageProcessor.g();
    }
  }
  
  private static void a(Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject;
    try
    {
      if (!ClassExistHelper.instanceOfSupportFragment(paramObject)) {
        break label207;
      }
      if (((android.support.v4.app.Fragment)paramObject).isResumed())
      {
        localObject = (android.support.v4.app.Fragment)paramObject;
        if (paramBoolean2) {
          break label411;
        }
        paramBoolean2 = bool1;
        if (a((android.support.v4.app.Fragment)localObject, paramBoolean2))
        {
          LogUtil.d("GIO.VdsAgent", new Object[] { "setFragmentUserVisibleHint: ", Boolean.valueOf(paramBoolean1), " @ ", paramObject });
          if (paramBoolean1)
          {
            localObject = AppState.l();
            if (localObject != null) {
              ((AppState)localObject).a((android.support.v4.app.Fragment)paramObject);
            }
          }
          for (;;)
          {
            try
            {
              paramObject = ((android.support.v4.app.Fragment)paramObject).getChildFragmentManager().getFragments();
              if (paramObject == null) {
                break;
              }
              paramObject = ((List)paramObject).iterator();
              if (!((Iterator)paramObject).hasNext()) {
                break;
              }
              a((android.support.v4.app.Fragment)((Iterator)paramObject).next(), paramBoolean1, false);
              continue;
              localObject = AppState.l();
            }
            catch (Exception paramObject)
            {
              LogUtil.d("GIO.VdsAgent", new Object[] { "getFragments() Fail" });
              return;
            }
            if (localObject != null) {
              ((AppState)localObject).b((android.support.v4.app.Fragment)paramObject);
            }
          }
        }
      }
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
      return;
    }
    tmp194_191[0] = "skip invisible Fragment: ";
    Object[] tmp199_194 = tmp194_191;
    tmp199_194[1] = paramObject;
    LogUtil.d("GIO.VdsAgent", tmp199_194);
    return;
    label207:
    if (((paramObject instanceof android.app.Fragment)) && (Build.VERSION.SDK_INT >= 15)) {
      if (((android.app.Fragment)paramObject).isResumed())
      {
        localObject = (android.app.Fragment)paramObject;
        if (paramBoolean2) {
          break label416;
        }
      }
    }
    label411:
    label416:
    for (paramBoolean2 = bool2;; paramBoolean2 = false)
    {
      if (a((android.app.Fragment)localObject, paramBoolean2))
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "setFragmentUserVisibleHint: ", Boolean.valueOf(paramBoolean1), " @ ", paramObject });
        if (paramBoolean1)
        {
          localObject = AppState.l();
          if (localObject != null) {
            ((AppState)localObject).a((android.app.Fragment)paramObject);
          }
        }
        for (;;)
        {
          paramObject = a((android.app.Fragment)paramObject);
          if (paramObject == null) {
            break;
          }
          paramObject = ((List)paramObject).iterator();
          while (((Iterator)paramObject).hasNext()) {
            a((android.app.Fragment)((Iterator)paramObject).next(), paramBoolean1, false);
          }
          LogUtil.d("GIO.VdsAgent", new Object[] { "setFragmentUserVisibleHint: ", paramObject });
          localObject = AppState.l();
          if (localObject != null) {
            ((AppState)localObject).b((android.app.Fragment)paramObject);
          }
        }
      }
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible Fragment: ", paramObject });
      return;
      paramBoolean2 = false;
      break;
    }
  }
  
  @TargetApi(15)
  private static boolean a(android.app.Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment.getId() != 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip non-id fragment ", paramFragment });
      return false;
    }
    if (paramFragment.isHidden())
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip hidden fragment ", paramFragment });
      return false;
    }
    if (!paramFragment.getUserVisibleHint())
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip !userVisibleHint fragment ", paramFragment });
      return false;
    }
    android.app.Fragment localFragment;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localFragment = paramFragment.getParentFragment();
      if (localFragment == null) {}
    }
    for (boolean bool = a(localFragment, paramBoolean);; bool = true)
    {
      if (!bool)
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip !visible parent fragment ", paramFragment });
        return false;
      }
      if (!paramBoolean) {
        return true;
      }
      if (!a(paramFragment.getView()))
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible view fragment ", paramFragment });
        return false;
      }
      return true;
    }
  }
  
  private static boolean a(android.support.v4.app.Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment.getId() != 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip non-id fragment ", paramFragment });
      return false;
    }
    if (paramFragment.isHidden())
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip hidden fragment ", paramFragment });
      return false;
    }
    if (!paramFragment.getUserVisibleHint())
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "skip !userVisibleHint fragment ", paramFragment });
      return false;
    }
    android.support.v4.app.Fragment localFragment = paramFragment.getParentFragment();
    if (localFragment != null) {}
    for (boolean bool = a(localFragment, paramBoolean);; bool = true)
    {
      if (!bool)
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip !visible parent fragment ", paramFragment });
        return false;
      }
      if (!paramBoolean) {
        return true;
      }
      if (!a(paramFragment.getView()))
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible view fragment ", paramFragment });
        return false;
      }
      return true;
    }
  }
  
  private static boolean a(View paramView)
  {
    Object localObject = paramView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = ((View)localObject).getParent();
      boolean bool1;
      if (localObject == null)
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "Hit detached view: ", paramView });
        bool1 = false;
      }
      boolean bool2;
      do
      {
        return bool1;
        if ((localObject instanceof View))
        {
          localObject = (View)localObject;
          break;
        }
        bool2 = paramView.getLocalVisibleRect(new Rect());
        bool1 = bool2;
      } while (bool2);
      LogUtil.d("GIO.VdsAgent", new Object[] { "Hit invisible rect view: ", paramView });
      return bool2;
    }
    return false;
  }
  
  private static void b(Object paramObject, boolean paramBoolean)
  {
    a(paramObject, paramBoolean, true);
  }
  
  private static void c(Object paramObject)
  {
    AppState localAppState;
    try
    {
      if (ClassExistHelper.instanceOfSupportFragment(paramObject))
      {
        if (a((android.support.v4.app.Fragment)paramObject, false))
        {
          LogUtil.d("GIO.VdsAgent", new Object[] { "onFragmentResume: ", paramObject });
          localAppState = AppState.l();
          if (localAppState == null) {
            return;
          }
          localAppState.a((android.support.v4.app.Fragment)paramObject);
          return;
        }
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible Fragment: ", paramObject });
        return;
      }
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
      return;
    }
    if (((paramObject instanceof android.app.Fragment)) && (Build.VERSION.SDK_INT >= 15)) {
      if (a((android.app.Fragment)paramObject, false))
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "onFragmentResume: ", paramObject });
        localAppState = AppState.l();
        if (localAppState != null) {
          localAppState.a((android.app.Fragment)paramObject);
        }
      }
      else
      {
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible Fragment: ", paramObject });
      }
    }
  }
  
  public static void clickOn(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((paramDialogInterface instanceof AlertDialog)) {
        clickOn(((AlertDialog)paramDialogInterface).getButton(paramInt));
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      LogUtil.d(paramDialogInterface);
    }
  }
  
  public static void clickOn(View paramView)
  {
    try
    {
      if (a.a()) {
        return;
      }
      paramView = ViewHelper.a(paramView);
      if (paramView != null)
      {
        a.a(paramView);
        handleClickResult(Boolean.valueOf(true));
        return;
      }
    }
    catch (Throwable paramView)
    {
      LogUtil.d(paramView);
    }
  }
  
  public static void clickOn(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramAdapterView instanceof Spinner))
    {
      clickOn(paramAdapterView);
      return;
    }
    clickOn(paramView);
  }
  
  private static void d(Object paramObject)
  {
    AppState localAppState;
    try
    {
      if (ClassExistHelper.instanceOfSupportFragment(paramObject))
      {
        if (a((android.support.v4.app.Fragment)paramObject, false))
        {
          LogUtil.d("GIO.VdsAgent", new Object[] { "onFragmentPause: ", paramObject });
          localAppState = AppState.l();
          if (localAppState == null) {
            return;
          }
          localAppState.b((android.support.v4.app.Fragment)paramObject);
          return;
        }
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible Fragment: ", paramObject });
        return;
      }
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
      return;
    }
    if ((paramObject instanceof android.app.Fragment)) {
      if (Build.VERSION.SDK_INT >= 15)
      {
        if (a((android.app.Fragment)paramObject, false))
        {
          LogUtil.d("GIO.VdsAgent", new Object[] { "onFragmentPause: ", paramObject });
          localAppState = AppState.l();
          if (localAppState != null) {
            localAppState.b((android.app.Fragment)paramObject);
          }
        }
      }
      else {
        LogUtil.d("GIO.VdsAgent", new Object[] { "skip invisible Fragment: ", paramObject });
      }
    }
  }
  
  private static boolean e(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Boolean)) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    return bool;
  }
  
  public static void handleClickResult(Object paramObject)
  {
    if ((e(paramObject)) && (a.a()))
    {
      ThreadUtils.c(a);
      ThreadUtils.b(a);
      return;
    }
    a.a(null);
  }
  
  public static void loadUrl(android.webkit.WebView paramWebView, String paramString)
  {
    if (!(paramWebView instanceof android.webkit.WebView)) {
      paramWebView.loadUrl(paramString);
    }
    for (;;)
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "loadUrl: ", paramString });
      return;
      WebviewInstrumentation.loadUrl((android.webkit.WebView)paramWebView, paramString);
    }
  }
  
  public static void onCheckedChanged(Object paramObject, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    try
    {
      if ((paramObject instanceof CompoundButton.OnCheckedChangeListener)) {
        clickOn(paramCompoundButton);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onCheckedChanged(Object paramObject, RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      if ((paramObject instanceof RadioGroup.OnCheckedChangeListener)) {
        clickOn(paramRadioGroup);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static boolean onChildClick(Object paramObject, ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if ((a.a()) && (!GConfig.sCanHook)) {
      return false;
    }
    paramExpandableListView = null;
    if ((paramObject instanceof ExpandableListView.OnChildClickListener)) {
      paramExpandableListView = ViewHelper.a(paramView);
    }
    a.a(paramExpandableListView);
    return false;
  }
  
  public static void onClick(Object paramObject, DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((paramObject instanceof DialogInterface.OnClickListener)) {
        clickOn(paramDialogInterface, paramInt);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onClick(Object paramObject, View paramView)
  {
    try
    {
      if ((paramObject instanceof View.OnClickListener)) {
        clickOn(paramView);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onFragmentHiddenChanged(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setFragmentUserVisibleHint(paramObject, paramBoolean);
      return;
    }
  }
  
  public static void onFragmentPause(Object paramObject)
  {
    ThreadUtils.b(new Runnable()
    {
      public void run()
      {
        VdsAgent.b(this.a);
      }
    });
  }
  
  public static void onFragmentResume(Object paramObject)
  {
    ThreadUtils.b(new Runnable()
    {
      public void run()
      {
        VdsAgent.a(this.a);
      }
    });
  }
  
  public static boolean onGroupClick(Object paramObject, ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    if ((a.a()) && (!GConfig.sCanHook)) {
      return false;
    }
    paramExpandableListView = null;
    if ((paramObject instanceof ExpandableListView.OnGroupClickListener)) {
      paramExpandableListView = ViewHelper.a(paramView);
    }
    a.a(paramExpandableListView);
    return false;
  }
  
  public static void onItemClick(Object paramObject, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    try
    {
      if (((paramObject instanceof AdapterView.OnItemClickListener)) || ((paramObject instanceof AdapterView.OnItemSelectedListener))) {
        clickOn(paramAdapterView, paramView, paramInt, paramLong);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onItemSelected(Object paramObject, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramAdapterView != null) && ((paramAdapterView instanceof Spinner))) {
      onItemClick(paramObject, paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public static void onLocationChanged(Object paramObject, Location paramLocation)
  {
    try
    {
      if (((paramObject instanceof LocationListener)) && (GConfig.sCanHook)) {
        GrowingIO.getInstance().setGeoLocation(paramLocation.getLatitude(), paramLocation.getLongitude());
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onLocationChanged(Object paramObject, AMapLocation paramAMapLocation)
  {
    try
    {
      if (((paramObject instanceof AMapLocationListener)) && (paramAMapLocation.getErrorCode() == 0) && (GConfig.sCanHook)) {
        GrowingIO.getInstance().setGeoLocation(paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude());
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onLocationChanged(Object paramObject, TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    try
    {
      if (((paramObject instanceof TencentLocationListener)) && (paramInt == 0) && (GConfig.sCanHook)) {
        GrowingIO.getInstance().setGeoLocation(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static boolean onMenuItemClick(Object paramObject, MenuItem paramMenuItem)
  {
    if ((a.a()) && (!GConfig.sCanHook)) {
      return false;
    }
    i locali = null;
    if ((paramObject instanceof PopupMenu.OnMenuItemClickListener)) {
      locali = ViewHelper.a(paramMenuItem);
    }
    a.a(locali);
    return false;
  }
  
  public static void onNewIntent(Object paramObject, Intent paramIntent)
  {
    if (((paramObject instanceof Activity)) && (GConfig.sCanHook))
    {
      c localc = c.e();
      if (localc != null) {
        localc.a(paramIntent, (Activity)paramObject);
      }
    }
  }
  
  public static boolean onOptionsItemSelected(Object paramObject, MenuItem paramMenuItem)
  {
    if ((a.a()) && (!GConfig.sCanHook)) {
      return false;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Activity))
    {
      localObject1 = localObject2;
      if (!ClassExistHelper.instanceOfFragmentActivity(paramObject)) {
        localObject1 = ViewHelper.a(paramMenuItem);
      }
    }
    a.a((i)localObject1);
    return false;
  }
  
  public static void onRatingChanged(Object paramObject, RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      clickOn(paramRatingBar);
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onReceiveLocation(Object paramObject, BDLocation paramBDLocation)
  {
    try
    {
      if (((paramObject instanceof BDLocationListener)) && (GConfig.sCanHook))
      {
        int i = paramBDLocation.getLocType();
        if ((i == 61) || (i == 161) || (i == 66)) {
          GrowingIO.getInstance().setGeoLocation(paramBDLocation.getLatitude(), paramBDLocation.getLongitude());
        }
      }
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static void onStopTrackingTouch(Object paramObject, SeekBar paramSeekBar)
  {
    try
    {
      clickOn(paramSeekBar);
      return;
    }
    catch (Throwable paramObject)
    {
      LogUtil.d((Throwable)paramObject);
    }
  }
  
  public static URLConnection openConnection(URLConnection paramURLConnection)
  {
    LogUtil.d("GIO.VdsAgent", new Object[] { "openConnection: ", paramURLConnection });
    return paramURLConnection;
  }
  
  public static void setFragmentUserVisibleHint(Object paramObject, final boolean paramBoolean)
  {
    ThreadUtils.b(new Runnable()
    {
      public void run()
      {
        VdsAgent.a(this.a, paramBoolean);
      }
    });
  }
  
  public static void setWebChromeClient(android.webkit.WebView paramWebView, android.webkit.WebChromeClient paramWebChromeClient)
  {
    paramWebView.setWebChromeClient(paramWebChromeClient);
    if (!GConfig.sCanHook) {}
    do
    {
      return;
      paramWebView.setTag(84159239, paramWebChromeClient);
      if (GConfig.DEBUG) {
        LogUtil.d("GIO.VdsAgent", new Object[] { "trackWebView: ", paramWebView, " with client ", paramWebChromeClient });
      }
    } while (paramWebChromeClient == null);
    VdsJsBridgeManager.hookWebViewIfNeeded(paramWebView);
  }
  
  public static void setWebChromeClient(com.tencent.smtt.sdk.WebView paramWebView, com.tencent.smtt.sdk.WebChromeClient paramWebChromeClient)
  {
    paramWebView.setWebChromeClient(paramWebChromeClient);
    if (!GConfig.sCanHook) {}
    do
    {
      return;
      paramWebView.setTag(84159239, paramWebChromeClient);
      if (GConfig.DEBUG) {
        LogUtil.d("GIO.VdsAgent", new Object[] { "trackWebView: ", paramWebView, " with client ", paramWebChromeClient });
      }
    } while (paramWebChromeClient == null);
    VdsJsBridgeManager.hookWebViewIfNeeded(paramWebView);
  }
  
  public static AlertDialog showAlertDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = paramBuilder.show();
    a();
    return paramBuilder;
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView)
  {
    paramPopupWindow.showAsDropDown(paramView);
    if (GConfig.sCanHook) {
      a();
    }
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2)
  {
    paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
    if (GConfig.sCanHook) {
      a();
    }
  }
  
  @TargetApi(19)
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    if (GConfig.sCanHook) {
      a();
    }
  }
  
  public static void showAtLocation(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramPopupWindow.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    if (GConfig.sCanHook) {
      a();
    }
  }
  
  public static void showDialog(AlertDialog paramAlertDialog)
  {
    showDialog(paramAlertDialog);
  }
  
  public static void showDialog(DatePickerDialog paramDatePickerDialog)
  {
    showDialog(paramDatePickerDialog);
  }
  
  public static void showDialog(Dialog paramDialog)
  {
    paramDialog.show();
    a();
  }
  
  public static void showDialog(ProgressDialog paramProgressDialog)
  {
    showDialog(paramProgressDialog);
  }
  
  public static void showDialog(TimePickerDialog paramTimePickerDialog)
  {
    showDialog(paramTimePickerDialog);
  }
  
  public static int showDialogFragment(android.app.DialogFragment paramDialogFragment, android.app.FragmentTransaction paramFragmentTransaction, String paramString)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11)
    {
      LogUtil.d("GIO.VdsAgent", new Object[] { "showDialogFragment: ", paramDialogFragment });
      i = paramDialogFragment.show(paramFragmentTransaction, paramString);
      a();
    }
    return i;
  }
  
  public static int showDialogFragment(android.support.v4.app.DialogFragment paramDialogFragment, android.support.v4.app.FragmentTransaction paramFragmentTransaction, String paramString)
  {
    LogUtil.d("GIO.VdsAgent", new Object[] { "showDialogFragment: ", paramDialogFragment });
    int i = paramDialogFragment.show(paramFragmentTransaction, paramString);
    a();
    return i;
  }
  
  public static void showDialogFragment(android.app.DialogFragment paramDialogFragment, android.app.FragmentManager paramFragmentManager, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramDialogFragment.show(paramFragmentManager, paramString);
      a();
    }
  }
  
  public static void showDialogFragment(android.support.v4.app.DialogFragment paramDialogFragment, android.support.v4.app.FragmentManager paramFragmentManager, String paramString)
  {
    LogUtil.d("GIO.VdsAgent", new Object[] { "showDialogFragment: ", paramDialogFragment });
    paramDialogFragment.show(paramFragmentManager, paramString);
    a();
  }
  
  @TargetApi(11)
  public static void showPopupMenu(PopupMenu paramPopupMenu)
  {
    paramPopupMenu.show();
    if (GConfig.sCanHook) {
      a();
    }
  }
  
  public static void showToast(Toast paramToast)
  {
    paramToast.show();
    if (GConfig.sCanHook) {
      a();
    }
  }
  
  public static Editable trackEditTextSilent(EditText paramEditText)
  {
    if (paramEditText == null) {
      return null;
    }
    GrowingIO.getInstance().trackEditTextSilent(paramEditText);
    return paramEditText.getText();
  }
  
  private static class a
    implements Runnable
  {
    private i a;
    private a b;
    
    public void a(i parami)
    {
      this.a = parami;
      if (parami != null) {
        this.b = ViewHelper.a(parami);
      }
    }
    
    public boolean a()
    {
      return this.a != null;
    }
    
    public void run()
    {
      try
      {
        ViewHelper.a(this.b, this.a);
        this.a = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          LogUtil.d(localThrowable);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/agent/VdsAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */