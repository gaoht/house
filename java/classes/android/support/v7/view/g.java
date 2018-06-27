package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.view.menu.j;
import android.support.v7.widget.w;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
  extends MenuInflater
{
  static final Class<?>[] a = { Context.class };
  static final Class<?>[] b = a;
  final Object[] c;
  final Object[] d;
  Context e;
  private Object f;
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    this.c = new Object[] { paramContext };
    this.d = this.c;
  }
  
  private Object a(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {}
    while (!(paramObject instanceof ContextWrapper)) {
      return paramObject;
    }
    return a(((ContextWrapper)paramObject).getBaseContext());
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    label49:
    int k;
    int j;
    if (i == 2)
    {
      paramMenu = paramXmlPullParser.getName();
      if (paramMenu.equals("menu"))
      {
        i = paramXmlPullParser.next();
        paramMenu = null;
        int m = 0;
        k = i;
        j = 0;
        i = m;
        label65:
        if (j != 0) {
          return;
        }
      }
    }
    switch (k)
    {
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label65;
        throw new RuntimeException("Expecting menu, got " + paramMenu);
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label49;
        if (i == 0)
        {
          String str = paramXmlPullParser.getName();
          if (str.equals("group"))
          {
            localb.readGroup(paramAttributeSet);
          }
          else if (str.equals("item"))
          {
            localb.readItem(paramAttributeSet);
          }
          else if (str.equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localb.addSubMenuItem());
          }
          else
          {
            paramMenu = str;
            i = 1;
            continue;
            str = paramXmlPullParser.getName();
            if ((i != 0) && (str.equals(paramMenu)))
            {
              paramMenu = null;
              i = 0;
            }
            else if (str.equals("group"))
            {
              localb.resetGroup();
            }
            else if (str.equals("item"))
            {
              if (!localb.hasAddedItem()) {
                if ((localb.a != null) && (localb.a.hasSubMenu())) {
                  localb.addSubMenuItem();
                } else {
                  localb.addItem();
                }
              }
            }
            else if (str.equals("menu"))
            {
              j = 1;
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  Object a()
  {
    if (this.f == null) {
      this.f = a(this.e);
    }
    return this.f;
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 145
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 147	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 36	android/support/v7/view/g:e	Landroid/content/Context;
    //   26: invokevirtual 151	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 157	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 163	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 117	android/support/v7/view/g:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 168 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 170	android/view/InflateException
    //   78: dup
    //   79: ldc -84
    //   81: aload_2
    //   82: invokespecial 175	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_2
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 168 1 0
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload 5
    //   102: astore_3
    //   103: new 170	android/view/InflateException
    //   106: dup
    //   107: ldc -84
    //   109: aload_2
    //   110: invokespecial 175	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	g
    //   0	114	1	paramInt	int
    //   0	114	2	paramMenu	Menu
    //   15	88	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	84	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	86	finally
    //   46	58	86	finally
    //   75	86	86	finally
    //   103	114	86	finally
    //   22	35	99	java/io/IOException
    //   46	58	99	java/io/IOException
  }
  
  private static class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] a = { MenuItem.class };
    private Object b;
    private Method c;
    
    public a(Object paramObject, String paramString)
    {
      this.b = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.c = localClass.getMethod(paramString, a);
        return;
      }
      catch (Exception paramObject)
      {
        paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    @Instrumented
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      VdsAgent.onMenuItemClick(this, paramMenuItem);
      try
      {
        if (this.c.getReturnType() == Boolean.TYPE)
        {
          boolean bool = ((Boolean)this.c.invoke(this.b, new Object[] { paramMenuItem })).booleanValue();
          VdsAgent.handleClickResult(new Boolean(bool));
          return bool;
        }
        this.c.invoke(this.b, new Object[] { paramMenuItem });
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private class b
  {
    private String A;
    private String B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E = null;
    private PorterDuff.Mode F = null;
    ActionProvider a;
    private Menu c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private CharSequence m;
    private CharSequence n;
    private int o;
    private char p;
    private int q;
    private char r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private String z;
    
    public b(Menu paramMenu)
    {
      this.c = paramMenu;
      resetGroup();
    }
    
    private char a(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = g.this.e.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
      }
      return null;
    }
    
    private void a(MenuItem paramMenuItem)
    {
      int i1 = 1;
      Object localObject = paramMenuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
      if (this.t >= 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.n).setIcon(this.o);
        if (this.x >= 0) {
          paramMenuItem.setShowAsAction(this.x);
        }
        if (this.B == null) {
          break label146;
        }
        if (!g.this.e.isRestricted()) {
          break;
        }
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(g.this.a(), this.B));
      label146:
      if ((paramMenuItem instanceof j)) {
        localObject = (j)paramMenuItem;
      }
      if (this.t >= 2)
      {
        if ((paramMenuItem instanceof j)) {
          ((j)paramMenuItem).setExclusiveCheckable(true);
        }
      }
      else
      {
        if (this.z == null) {
          break label356;
        }
        paramMenuItem.setActionView((View)a(this.z, g.a, g.this.c));
      }
      for (;;)
      {
        if (this.y > 0)
        {
          if (i1 != 0) {
            break label344;
          }
          paramMenuItem.setActionView(this.y);
        }
        for (;;)
        {
          if (this.a != null) {
            MenuItemCompat.setActionProvider(paramMenuItem, this.a);
          }
          MenuItemCompat.setContentDescription(paramMenuItem, this.C);
          MenuItemCompat.setTooltipText(paramMenuItem, this.D);
          MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.p, this.q);
          MenuItemCompat.setNumericShortcut(paramMenuItem, this.r, this.s);
          if (this.F != null) {
            MenuItemCompat.setIconTintMode(paramMenuItem, this.F);
          }
          if (this.E != null) {
            MenuItemCompat.setIconTintList(paramMenuItem, this.E);
          }
          return;
          if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
            break;
          }
          ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
          break;
          label344:
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
        label356:
        i1 = 0;
      }
    }
    
    public void addItem()
    {
      this.j = true;
      a(this.c.add(this.d, this.k, this.l, this.m));
    }
    
    public SubMenu addSubMenuItem()
    {
      this.j = true;
      SubMenu localSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
      a(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean hasAddedItem()
    {
      return this.j;
    }
    
    public void readGroup(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = g.this.e.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
      this.d = paramAttributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.e = paramAttributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.f = paramAttributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.g = paramAttributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.h = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.i = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
    }
    
    public void readItem(AttributeSet paramAttributeSet)
    {
      int i2 = 1;
      paramAttributeSet = g.this.e.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
      this.k = paramAttributeSet.getResourceId(R.styleable.MenuItem_android_id, 0);
      this.l = (paramAttributeSet.getInt(R.styleable.MenuItem_android_menuCategory, this.e) & 0xFFFF0000 | paramAttributeSet.getInt(R.styleable.MenuItem_android_orderInCategory, this.f) & 0xFFFF);
      this.m = paramAttributeSet.getText(R.styleable.MenuItem_android_title);
      this.n = paramAttributeSet.getText(R.styleable.MenuItem_android_titleCondensed);
      this.o = paramAttributeSet.getResourceId(R.styleable.MenuItem_android_icon, 0);
      this.p = a(paramAttributeSet.getString(R.styleable.MenuItem_android_alphabeticShortcut));
      this.q = paramAttributeSet.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
      this.r = a(paramAttributeSet.getString(R.styleable.MenuItem_android_numericShortcut));
      this.s = paramAttributeSet.getInt(R.styleable.MenuItem_numericModifiers, 4096);
      int i1;
      if (paramAttributeSet.hasValue(R.styleable.MenuItem_android_checkable)) {
        if (paramAttributeSet.getBoolean(R.styleable.MenuItem_android_checkable, false))
        {
          i1 = 1;
          this.t = i1;
          label184:
          this.u = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_checked, false);
          this.v = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_visible, this.h);
          this.w = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_enabled, this.i);
          this.x = paramAttributeSet.getInt(R.styleable.MenuItem_showAsAction, -1);
          this.B = paramAttributeSet.getString(R.styleable.MenuItem_android_onClick);
          this.y = paramAttributeSet.getResourceId(R.styleable.MenuItem_actionLayout, 0);
          this.z = paramAttributeSet.getString(R.styleable.MenuItem_actionViewClass);
          this.A = paramAttributeSet.getString(R.styleable.MenuItem_actionProviderClass);
          if (this.A == null) {
            break label433;
          }
          i1 = i2;
          label292:
          if ((i1 == 0) || (this.y != 0) || (this.z != null)) {
            break label438;
          }
          this.a = ((ActionProvider)a(this.A, g.b, g.this.d));
          label335:
          this.C = paramAttributeSet.getText(R.styleable.MenuItem_contentDescription);
          this.D = paramAttributeSet.getText(R.styleable.MenuItem_tooltipText);
          if (!paramAttributeSet.hasValue(R.styleable.MenuItem_iconTintMode)) {
            break label459;
          }
          this.F = w.parseTintMode(paramAttributeSet.getInt(R.styleable.MenuItem_iconTintMode, -1), this.F);
          label386:
          if (!paramAttributeSet.hasValue(R.styleable.MenuItem_iconTint)) {
            break label467;
          }
        }
      }
      label433:
      label438:
      label459:
      label467:
      for (this.E = paramAttributeSet.getColorStateList(R.styleable.MenuItem_iconTint);; this.E = null)
      {
        paramAttributeSet.recycle();
        this.j = false;
        return;
        i1 = 0;
        break;
        this.t = this.g;
        break label184;
        i1 = 0;
        break label292;
        if (i1 != 0) {
          Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        }
        this.a = null;
        break label335;
        this.F = null;
        break label386;
      }
    }
    
    public void resetGroup()
    {
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = true;
      this.i = true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */