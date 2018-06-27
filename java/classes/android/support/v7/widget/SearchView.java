package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.c;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final a i = new a();
  private c A;
  private b B;
  private d C;
  private View.OnClickListener D;
  private boolean E;
  private boolean F;
  private boolean G;
  private CharSequence H;
  private boolean I;
  private boolean J;
  private int K;
  private boolean L;
  private CharSequence M;
  private CharSequence N;
  private boolean O;
  private int P;
  private Bundle Q;
  private final Runnable R = new Runnable()
  {
    public void run()
    {
      SearchView.this.a();
    }
  };
  private Runnable S = new Runnable()
  {
    public void run()
    {
      if ((SearchView.this.g != null) && ((SearchView.this.g instanceof an))) {
        SearchView.this.g.changeCursor(null);
      }
    }
  };
  private final WeakHashMap<String, Drawable.ConstantState> T = new WeakHashMap();
  private final View.OnClickListener U = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (paramAnonymousView == SearchView.this.b) {
        SearchView.this.d();
      }
      do
      {
        return;
        if (paramAnonymousView == SearchView.this.d)
        {
          SearchView.this.c();
          return;
        }
        if (paramAnonymousView == SearchView.this.c)
        {
          SearchView.this.b();
          return;
        }
        if (paramAnonymousView == SearchView.this.e)
        {
          SearchView.this.e();
          return;
        }
      } while (paramAnonymousView != SearchView.this.a);
      SearchView.this.h();
    }
  };
  private final TextView.OnEditorActionListener V = new TextView.OnEditorActionListener()
  {
    public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.b();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener W = new AdapterView.OnItemClickListener()
  {
    @Instrumented
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
      SearchView.this.a(paramAnonymousInt, 0, null);
    }
  };
  final SearchAutoComplete a;
  private final AdapterView.OnItemSelectedListener aa = new AdapterView.OnItemSelectedListener()
  {
    @Instrumented
    public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      VdsAgent.onItemSelected(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
      SearchView.this.a(paramAnonymousInt);
    }
    
    public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
  };
  private TextWatcher ab = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.b(paramAnonymousCharSequence);
    }
  };
  final ImageView b;
  final ImageView c;
  final ImageView d;
  final ImageView e;
  View.OnFocusChangeListener f;
  CursorAdapter g;
  SearchableInfo h;
  View.OnKeyListener j = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.h == null) {}
      do
      {
        return false;
        if ((SearchView.this.a.isPopupShowing()) && (SearchView.this.a.getListSelection() != -1)) {
          return SearchView.this.a(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      } while ((SearchView.SearchAutoComplete.a(SearchView.this.a)) || (!paramAnonymousKeyEvent.hasNoModifiers()) || (paramAnonymousKeyEvent.getAction() != 1) || (paramAnonymousInt != 66));
      paramAnonymousView.cancelLongPress();
      SearchView.this.a(0, null, SearchView.this.a.getText().toString());
      return true;
    }
  };
  private final View k;
  private final View l;
  private final View m;
  private final View n;
  private e o;
  private Rect p = new Rect();
  private Rect q = new Rect();
  private int[] r = new int[2];
  private int[] s = new int[2];
  private final ImageView t;
  private final Drawable u;
  private final int v;
  private final int w;
  private final Intent x;
  private final Intent y;
  private final CharSequence z;
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = at.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
    this.a = ((SearchAutoComplete)findViewById(R.id.search_src_text));
    this.a.setSearchView(this);
    this.k = findViewById(R.id.search_edit_frame);
    this.l = findViewById(R.id.search_plate);
    this.m = findViewById(R.id.submit_area);
    this.b = ((ImageView)findViewById(R.id.search_button));
    this.c = ((ImageView)findViewById(R.id.search_go_btn));
    this.d = ((ImageView)findViewById(R.id.search_close_btn));
    this.e = ((ImageView)findViewById(R.id.search_voice_btn));
    this.t = ((ImageView)findViewById(R.id.search_mag_icon));
    ViewCompat.setBackground(this.l, paramAttributeSet.getDrawable(R.styleable.SearchView_queryBackground));
    ViewCompat.setBackground(this.m, paramAttributeSet.getDrawable(R.styleable.SearchView_submitBackground));
    this.b.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_searchIcon));
    this.c.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_goIcon));
    this.d.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_closeIcon));
    this.e.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_voiceIcon));
    this.t.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_searchIcon));
    this.u = paramAttributeSet.getDrawable(R.styleable.SearchView_searchHintIcon);
    av.setTooltipText(this.b, getResources().getString(R.string.abc_searchview_description_search));
    this.v = paramAttributeSet.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
    this.w = paramAttributeSet.getResourceId(R.styleable.SearchView_commitIcon, 0);
    this.b.setOnClickListener(this.U);
    this.d.setOnClickListener(this.U);
    this.c.setOnClickListener(this.U);
    this.e.setOnClickListener(this.U);
    this.a.setOnClickListener(this.U);
    this.a.addTextChangedListener(this.ab);
    this.a.setOnEditorActionListener(this.V);
    this.a.setOnItemClickListener(this.W);
    this.a.setOnItemSelectedListener(this.aa);
    this.a.setOnKeyListener(this.j);
    this.a.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.f != null) {
          SearchView.this.f.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.z = paramAttributeSet.getText(R.styleable.SearchView_defaultQueryHint);
    this.H = paramAttributeSet.getText(R.styleable.SearchView_queryHint);
    paramInt = paramAttributeSet.getInt(R.styleable.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(R.styleable.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(R.styleable.SearchView_android_focusable, true));
    paramAttributeSet.recycle();
    this.x = new Intent("android.speech.action.WEB_SEARCH");
    this.x.addFlags(268435456);
    this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.y.addFlags(268435456);
    this.n = findViewById(this.a.getDropDownAnchor());
    if (this.n != null) {
      this.n.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          SearchView.this.g();
        }
      });
    }
    a(this.E);
    n();
  }
  
  private Intent a(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    paramIntent = paramSearchableInfo.getSearchActivity();
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.flattenToShortString())
    {
      localIntent.putExtra("calling_package", paramIntent);
      return localIntent;
    }
  }
  
  private Intent a(Cursor paramCursor, int paramInt, String paramString)
  {
    try
    {
      localObject2 = an.getColumnString(paramCursor, "suggest_intent_action");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label207;
      }
      localObject1 = this.h.getSuggestIntentAction();
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        try
        {
          String str;
          paramInt = paramCursor.getPosition();
          Log.w("SearchView", "Search suggestions cursor at row " + paramInt + " returned exception.", paramString);
          return null;
        }
        catch (RuntimeException paramCursor)
        {
          paramInt = -1;
          continue;
        }
        label207:
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = "android.intent.action.SEARCH";
          continue;
          label224:
          if (localObject3 == null) {
            localObject1 = null;
          }
        }
      }
    }
    localObject3 = an.getColumnString(paramCursor, "suggest_intent_data");
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.h.getSuggestIntentData();
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      str = an.getColumnString(paramCursor, "suggest_intent_data_id");
      localObject3 = localObject1;
      if (str != null)
      {
        localObject3 = (String)localObject1 + "/" + Uri.encode(str);
        break label224;
        for (;;)
        {
          localObject3 = an.getColumnString(paramCursor, "suggest_intent_query");
          return a((String)localObject2, (Uri)localObject1, an.getColumnString(paramCursor, "suggest_intent_extra_data"), (String)localObject3, paramInt, paramString);
          localObject1 = Uri.parse((String)localObject3);
        }
      }
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.N);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.Q != null) {
      paramString1.putExtra("app_data", this.Q);
    }
    if (paramInt != 0)
    {
      paramString1.putExtra("action_key", paramInt);
      paramString1.putExtra("action_msg", paramString4);
    }
    paramString1.setComponent(this.h.getSearchActivity());
    return paramString1;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("SearchView", "Failed launch activity: " + paramIntent, localRuntimeException);
    }
  }
  
  private void a(View paramView, Rect paramRect)
  {
    paramView.getLocationInWindow(this.r);
    getLocationInWindow(this.s);
    int i1 = this.r[1] - this.s[1];
    int i2 = this.r[0] - this.s[0];
    paramRect.set(i2, i1, paramView.getWidth() + i2, paramView.getHeight() + i1);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    int i2 = 8;
    this.F = paramBoolean;
    int i1;
    boolean bool1;
    if (paramBoolean)
    {
      i1 = 0;
      if (TextUtils.isEmpty(this.a.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.b.setVisibility(i1);
      b(bool1);
      View localView = this.k;
      if (!paramBoolean) {
        break label129;
      }
      i1 = 8;
      label60:
      localView.setVisibility(i1);
      i1 = i2;
      if (this.t.getDrawable() != null)
      {
        if (!this.E) {
          break label134;
        }
        i1 = i2;
      }
      label87:
      this.t.setVisibility(i1);
      l();
      if (bool1) {
        break label139;
      }
    }
    label123:
    label129:
    label134:
    label139:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      c(paramBoolean);
      k();
      return;
      i1 = 8;
      break;
      bool1 = false;
      break label33;
      i1 = 0;
      break label60;
      i1 = 0;
      break label87;
    }
  }
  
  static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private Intent b(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Object localObject3 = null;
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Object localObject1 = new Intent("android.intent.action.SEARCH");
    ((Intent)localObject1).setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent)localObject1, 1073741824);
    Bundle localBundle = new Bundle();
    if (this.Q != null) {
      localBundle.putParcelable("app_data", this.Q);
    }
    Intent localIntent = new Intent(paramIntent);
    paramIntent = "free_form";
    int i1 = 1;
    Object localObject2 = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
      paramIntent = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
    }
    if (paramSearchableInfo.getVoicePromptTextId() != 0) {}
    for (localObject1 = ((Resources)localObject2).getString(paramSearchableInfo.getVoicePromptTextId());; localObject1 = null)
    {
      if (paramSearchableInfo.getVoiceLanguageId() != 0) {}
      for (localObject2 = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageId());; localObject2 = null)
      {
        if (paramSearchableInfo.getVoiceMaxResults() != 0) {
          i1 = paramSearchableInfo.getVoiceMaxResults();
        }
        localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramIntent);
        localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
        localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
        localIntent.putExtra("android.speech.extra.MAX_RESULTS", i1);
        if (localComponentName == null) {}
        for (paramIntent = (Intent)localObject3;; paramIntent = localComponentName.flattenToShortString())
        {
          localIntent.putExtra("calling_package", paramIntent);
          localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
          localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
          return localIntent;
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    Editable localEditable = this.a.getText();
    Object localObject = this.g.getCursor();
    if (localObject == null) {
      return;
    }
    if (((Cursor)localObject).moveToPosition(paramInt))
    {
      localObject = this.g.convertToString((Cursor)localObject);
      if (localObject != null)
      {
        setQuery((CharSequence)localObject);
        return;
      }
      setQuery(localEditable);
      return;
    }
    setQuery(localEditable);
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 8;
    int i1 = i2;
    if (this.G)
    {
      i1 = i2;
      if (j())
      {
        i1 = i2;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i1 = i2;
            if (this.L) {}
          }
          else
          {
            i1 = 0;
          }
        }
      }
    }
    this.c.setVisibility(i1);
  }
  
  private boolean b(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = this.g.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1)))
    {
      a(a(localCursor, paramInt2, paramString));
      return true;
    }
    return false;
  }
  
  private CharSequence c(CharSequence paramCharSequence)
  {
    if ((!this.E) || (this.u == null)) {
      return paramCharSequence;
    }
    int i1 = (int)(this.a.getTextSize() * 1.25D);
    this.u.setBounds(0, 0, i1, i1);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  private void c(boolean paramBoolean)
  {
    int i1;
    if ((this.L) && (!isIconified()) && (paramBoolean))
    {
      i1 = 0;
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.e.setVisibility(i1);
      return;
      i1 = 8;
    }
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  private boolean i()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    if (this.h != null)
    {
      bool1 = bool2;
      if (this.h.getVoiceSearchEnabled())
      {
        localIntent = null;
        if (!this.h.getVoiceSearchLaunchWebSearch()) {
          break label69;
        }
        localIntent = this.x;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (localIntent != null)
      {
        bool1 = bool2;
        if (getContext().getPackageManager().resolveActivity(localIntent, 65536) != null) {
          bool1 = true;
        }
      }
      return bool1;
      label69:
      if (this.h.getVoiceSearchLaunchRecognizer()) {
        localIntent = this.y;
      }
    }
  }
  
  private boolean j()
  {
    return ((this.G) || (this.L)) && (!isIconified());
  }
  
  private void k()
  {
    int i2 = 8;
    int i1 = i2;
    if (j()) {
      if (this.c.getVisibility() != 0)
      {
        i1 = i2;
        if (this.e.getVisibility() != 0) {}
      }
      else
      {
        i1 = 0;
      }
    }
    this.m.setVisibility(i1);
  }
  
  private void l()
  {
    int i4 = 1;
    int i3 = 0;
    int i1;
    int i2;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.a.getText()))
    {
      i1 = 1;
      i2 = i4;
      if (i1 == 0)
      {
        if ((!this.E) || (this.O)) {
          break label99;
        }
        i2 = i4;
      }
      localObject = this.d;
      if (i2 == 0) {
        break label104;
      }
      i2 = i3;
      ((ImageView)localObject).setVisibility(i2);
      localDrawable = this.d.getDrawable();
      if (localDrawable != null) {
        if (i1 == 0) {
          break label110;
        }
      }
    }
    label99:
    label104:
    label110:
    for (Object localObject = ENABLED_STATE_SET;; localObject = EMPTY_STATE_SET)
    {
      localDrawable.setState((int[])localObject);
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label44;
      i2 = 8;
      break label56;
    }
  }
  
  private void m()
  {
    post(this.R);
  }
  
  private void n()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.a;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(c((CharSequence)localObject));
  }
  
  private void o()
  {
    int i2 = 1;
    this.a.setThreshold(this.h.getSuggestThreshold());
    this.a.setImeOptions(this.h.getImeOptions());
    int i3 = this.h.getInputType();
    int i1 = i3;
    if ((i3 & 0xF) == 1)
    {
      i3 &= 0xFFFEFFFF;
      i1 = i3;
      if (this.h.getSuggestAuthority() != null) {
        i1 = i3 | 0x10000 | 0x80000;
      }
    }
    this.a.setInputType(i1);
    if (this.g != null) {
      this.g.changeCursor(null);
    }
    if (this.h.getSuggestAuthority() != null)
    {
      this.g = new an(getContext(), this, this.h, this.T);
      this.a.setAdapter(this.g);
      an localan = (an)this.g;
      i1 = i2;
      if (this.I) {
        i1 = 2;
      }
      localan.setQueryRefinement(i1);
    }
  }
  
  private void p()
  {
    this.a.dismissDropDown();
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.a;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i1 = 0;; i1 = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i1);
      return;
    }
  }
  
  void a()
  {
    if (this.a.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.l.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.m.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = a("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }
  
  void a(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  boolean a(int paramInt)
  {
    if ((this.C == null) || (!this.C.onSuggestionSelect(paramInt)))
    {
      b(paramInt);
      return true;
    }
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = false;
    if ((this.C == null) || (!this.C.onSuggestionClick(paramInt1)))
    {
      b(paramInt1, 0, null);
      SearchAutoComplete.a(this.a, false);
      p();
      bool = true;
    }
    return bool;
  }
  
  boolean a(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.h == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.g == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return a(this.a.getListSelection(), 0, null);
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.a.length())
        {
          this.a.setSelection(paramInt);
          this.a.setListSelection(0);
          this.a.clearListSelection();
          i.a(this.a, true);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.a.getListSelection() != 0));
    return false;
  }
  
  void b()
  {
    Editable localEditable = this.a.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0) && ((this.A == null) || (!this.A.onQueryTextSubmit(localEditable.toString()))))
    {
      if (this.h != null) {
        a(0, null, localEditable.toString());
      }
      SearchAutoComplete.a(this.a, false);
      p();
    }
  }
  
  void b(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.a.getText();
    this.N = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      b(bool1);
      if (bool1) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      c(bool1);
      l();
      k();
      if ((this.A != null) && (!TextUtils.equals(paramCharSequence, this.M))) {
        this.A.onQueryTextChange(paramCharSequence.toString());
      }
      this.M = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  void c()
  {
    if (TextUtils.isEmpty(this.a.getText()))
    {
      if ((this.E) && ((this.B == null) || (!this.B.onClose())))
      {
        clearFocus();
        a(true);
      }
      return;
    }
    this.a.setText("");
    this.a.requestFocus();
    SearchAutoComplete.a(this.a, true);
  }
  
  public void clearFocus()
  {
    this.J = true;
    super.clearFocus();
    this.a.clearFocus();
    SearchAutoComplete.a(this.a, false);
    this.J = false;
  }
  
  void d()
  {
    a(false);
    this.a.requestFocus();
    SearchAutoComplete.a(this.a, true);
    if (this.D != null) {
      this.D.onClick(this);
    }
  }
  
  void e()
  {
    if (this.h == null) {}
    do
    {
      return;
      Object localObject = this.h;
      try
      {
        if (((SearchableInfo)localObject).getVoiceSearchLaunchWebSearch())
        {
          localObject = a(this.x, (SearchableInfo)localObject);
          getContext().startActivity((Intent)localObject);
          return;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.w("SearchView", "Could not find voice search activity");
        return;
      }
    } while (!localActivityNotFoundException.getVoiceSearchLaunchRecognizer());
    Intent localIntent = b(this.y, localActivityNotFoundException);
    getContext().startActivity(localIntent);
  }
  
  void f()
  {
    a(isIconified());
    m();
    if (this.a.hasFocus()) {
      h();
    }
  }
  
  void g()
  {
    int i3;
    Rect localRect;
    int i1;
    if (this.n.getWidth() > 1)
    {
      Resources localResources = getContext().getResources();
      i3 = this.l.getPaddingLeft();
      localRect = new Rect();
      boolean bool = bb.isLayoutRtl(this);
      if (!this.E) {
        break label144;
      }
      i1 = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
      i1 = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + i1;
      this.a.getDropDownBackground().getPadding(localRect);
      if (!bool) {
        break label149;
      }
    }
    label144:
    label149:
    for (int i2 = -localRect.left;; i2 = i3 - (localRect.left + i1))
    {
      this.a.setDropDownHorizontalOffset(i2);
      i2 = this.n.getWidth();
      int i4 = localRect.left;
      int i5 = localRect.right;
      this.a.setDropDownWidth(i1 + (i2 + i4 + i5) - i3);
      return;
      i1 = 0;
      break;
    }
  }
  
  public int getImeOptions()
  {
    return this.a.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.a.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.K;
  }
  
  public CharSequence getQuery()
  {
    return this.a.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.H != null) {
      return this.H;
    }
    if ((this.h != null) && (this.h.getHintId() != 0)) {
      return getContext().getText(this.h.getHintId());
    }
    return this.z;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.w;
  }
  
  int getSuggestionRowLayout()
  {
    return this.v;
  }
  
  public CursorAdapter getSuggestionsAdapter()
  {
    return this.g;
  }
  
  void h()
  {
    i.a(this.a);
    i.b(this.a);
  }
  
  public boolean isIconfiedByDefault()
  {
    return this.E;
  }
  
  public boolean isIconified()
  {
    return this.F;
  }
  
  public boolean isQueryRefinementEnabled()
  {
    return this.I;
  }
  
  public boolean isSubmitButtonEnabled()
  {
    return this.G;
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    clearFocus();
    a(true);
    this.a.setImeOptions(this.P);
    this.O = false;
  }
  
  public void onActionViewExpanded()
  {
    if (this.O) {
      return;
    }
    this.O = true;
    this.P = this.a.getImeOptions();
    this.a.setImeOptions(this.P | 0x2000000);
    this.a.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.R);
    post(this.S);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      a(this.a, this.p);
      this.q.set(this.p.left, 0, this.p.right, paramInt4 - paramInt2);
      if (this.o == null)
      {
        this.o = new e(this.q, this.p, this.a);
        setTouchDelegate(this.o);
      }
    }
    else
    {
      return;
    }
    this.o.setBounds(this.q, this.p);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    switch (i2)
    {
    default: 
      paramInt1 = i1;
      i1 = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      return;
      if (this.K > 0)
      {
        paramInt1 = Math.min(this.K, i1);
        break;
      }
      paramInt1 = Math.min(getPreferredWidth(), i1);
      break;
      paramInt1 = i1;
      if (this.K <= 0) {
        break;
      }
      paramInt1 = Math.min(this.K, i1);
      break;
      if (this.K > 0)
      {
        paramInt1 = this.K;
        break;
      }
      paramInt1 = getPreferredWidth();
      break;
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
      continue;
      paramInt2 = getPreferredHeight();
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    a(paramParcelable.a);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = isIconified();
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    m();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.J) {}
    while (!isFocusable()) {
      return false;
    }
    if (!isIconified())
    {
      boolean bool = this.a.requestFocus(paramInt, paramRect);
      if (bool) {
        a(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.Q = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
      return;
    }
    d();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.E == paramBoolean) {
      return;
    }
    this.E = paramBoolean;
    a(paramBoolean);
    n();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.a.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.a.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.K = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.B = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.f = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.A = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.D = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.C = paramd;
  }
  
  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.a.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      this.a.setSelection(this.a.length());
      this.N = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      b();
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.H = paramCharSequence;
    n();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.I = paramBoolean;
    an localan;
    if ((this.g instanceof an))
    {
      localan = (an)this.g;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i1 = 2;; i1 = 1)
    {
      localan.setQueryRefinement(i1);
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.h = paramSearchableInfo;
    if (this.h != null)
    {
      o();
      n();
    }
    this.L = i();
    if (this.L) {
      this.a.setPrivateImeOptions("nm");
    }
    a(isIconified());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.G = paramBoolean;
    a(isIconified());
  }
  
  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter)
  {
    this.g = paramCursorAdapter;
    this.a.setAdapter(this.g);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public SearchView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new SearchView.SavedState(paramAnonymousParcel, null);
      }
      
      public SearchView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new SearchView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public SearchView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new SearchView.SavedState[paramAnonymousInt];
      }
    };
    boolean a;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.a = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.a + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.a));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    final Runnable a = new Runnable()
    {
      public void run()
      {
        SearchView.SearchAutoComplete.b(SearchView.SearchAutoComplete.this);
      }
    };
    private int b = getThreshold();
    private SearchView c;
    private boolean d;
    
    public SearchAutoComplete(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private boolean a()
    {
      return TextUtils.getTrimmedLength(getText()) == 0;
    }
    
    private void b()
    {
      if (this.d)
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        this.d = false;
      }
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
        return 256;
      }
      if ((i >= 600) || ((i >= 640) && (j >= 480))) {
        return 192;
      }
      return 160;
    }
    
    private void setImeVisibility(boolean paramBoolean)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.d = false;
        removeCallbacks(this.a);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.d = false;
        removeCallbacks(this.a);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.d = true;
    }
    
    public boolean enoughToFilter()
    {
      return (this.b <= 0) || (super.enoughToFilter());
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.d)
      {
        removeCallbacks(this.a);
        post(this.a);
      }
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.c.f();
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            this.c.clearFocus();
            setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.c.hasFocus()) && (getVisibility() == 0))
      {
        this.d = true;
        if (SearchView.a(getContext())) {
          SearchView.i.a(this, true);
        }
      }
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setSearchView(SearchView paramSearchView)
    {
      this.c = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.b = paramInt;
    }
  }
  
  private static class a
  {
    private Method a;
    private Method b;
    private Method c;
    
    a()
    {
      try
      {
        this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.a.setAccessible(true);
        try
        {
          this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.b.setAccessible(true);
          try
          {
            this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.c.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          for (;;) {}
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        for (;;) {}
      }
    }
    
    void a(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.a != null) {}
      try
      {
        this.a.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    void a(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
    {
      if (this.c != null) {}
      try
      {
        this.c.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.b != null) {}
      try
      {
        this.b.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean onClose();
  }
  
  public static abstract interface c
  {
    public abstract boolean onQueryTextChange(String paramString);
    
    public abstract boolean onQueryTextSubmit(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract boolean onSuggestionClick(int paramInt);
    
    public abstract boolean onSuggestionSelect(int paramInt);
  }
  
  private static class e
    extends TouchDelegate
  {
    private final View a;
    private final Rect b;
    private final Rect c;
    private final Rect d;
    private final int e;
    private boolean f;
    
    public e(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.b = new Rect();
      this.d = new Rect();
      this.c = new Rect();
      setBounds(paramRect1, paramRect2);
      this.a = paramView;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int j = 1;
      boolean bool2 = false;
      int k = (int)paramMotionEvent.getX();
      int m = (int)paramMotionEvent.getY();
      boolean bool1;
      int i;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = false;
        i = j;
        label57:
        if (bool1)
        {
          if ((i == 0) || (this.c.contains(k, m))) {
            break label206;
          }
          paramMotionEvent.setLocation(this.a.getWidth() / 2, this.a.getHeight() / 2);
        }
        break;
      }
      for (;;)
      {
        bool2 = this.a.dispatchTouchEvent(paramMotionEvent);
        return bool2;
        if (!this.b.contains(k, m)) {
          break;
        }
        this.f = true;
        bool1 = true;
        i = j;
        break label57;
        boolean bool3 = this.f;
        i = j;
        bool1 = bool3;
        if (!bool3) {
          break label57;
        }
        i = j;
        bool1 = bool3;
        if (this.d.contains(k, m)) {
          break label57;
        }
        i = 0;
        bool1 = bool3;
        break label57;
        bool1 = this.f;
        this.f = false;
        i = j;
        break label57;
        label206:
        paramMotionEvent.setLocation(k - this.c.left, m - this.c.top);
      }
    }
    
    public void setBounds(Rect paramRect1, Rect paramRect2)
    {
      this.b.set(paramRect1);
      this.d.set(paramRect1);
      this.d.inset(-this.e, -this.e);
      this.c.set(paramRect2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */