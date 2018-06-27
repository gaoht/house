package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class an
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  private final SearchManager a = (SearchManager)this.mContext.getSystemService("search");
  private final SearchView b;
  private final SearchableInfo c;
  private final Context d;
  private final WeakHashMap<String, Drawable.ConstantState> e;
  private final int f;
  private boolean g = false;
  private int h = 1;
  private ColorStateList i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  
  public an(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.b = paramSearchView;
    this.c = paramSearchableInfo;
    this.f = paramSearchView.getSuggestionCommitIconResId();
    this.d = paramContext;
    this.e = paramWeakHashMap;
  }
  
  private Drawable a(ComponentName paramComponentName)
  {
    Object localObject = null;
    String str = paramComponentName.flattenToShortString();
    if (this.e.containsKey(str))
    {
      paramComponentName = (Drawable.ConstantState)this.e.get(str);
      if (paramComponentName == null) {
        return null;
      }
      return paramComponentName.newDrawable(this.d.getResources());
    }
    Drawable localDrawable = b(paramComponentName);
    if (localDrawable == null) {}
    for (paramComponentName = (ComponentName)localObject;; paramComponentName = localDrawable.getConstantState())
    {
      this.e.put(str, paramComponentName);
      return localDrawable;
    }
  }
  
  private Drawable a(String paramString)
  {
    Object localObject1;
    if ((paramString == null) || (paramString.isEmpty()) || ("0".equals(paramString))) {
      localObject1 = null;
    }
    for (;;)
    {
      return (Drawable)localObject1;
      try
      {
        int i1 = Integer.parseInt(paramString);
        String str = "android.resource://" + this.d.getPackageName() + "/" + i1;
        localDrawable = b(str);
        localObject1 = localDrawable;
        if (localDrawable == null)
        {
          localObject1 = ContextCompat.getDrawable(this.d, i1);
          a(str, (Drawable)localObject1);
          return (Drawable)localObject1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Drawable localDrawable = b(paramString);
        Object localObject2 = localDrawable;
        if (localDrawable == null)
        {
          localObject2 = b(Uri.parse(paramString));
          a(paramString, (Drawable)localObject2);
          return (Drawable)localObject2;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Log.w("SuggestionsAdapter", "Icon resource not found: " + paramString);
      }
    }
    return null;
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    if (this.i == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, (TypedValue)localObject, true);
      this.i = this.mContext.getResources().getColorStateList(((TypedValue)localObject).resourceId);
    }
    Object localObject = new SpannableString(paramCharSequence);
    ((SpannableString)localObject).setSpan(new TextAppearanceSpan(null, 0, 0, this.i, null), 0, paramCharSequence.length(), 33);
    return (CharSequence)localObject;
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  private void a(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras();; paramCursor = null)
    {
      if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
      return;
    }
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.e.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private Drawable b(ComponentName paramComponentName)
  {
    Object localObject = this.mContext.getPackageManager();
    ActivityInfo localActivityInfo;
    int i1;
    try
    {
      localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      i1 = localActivityInfo.getIconResource();
      if (i1 == 0) {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.w("SuggestionsAdapter", paramComponentName.toString());
      return null;
    }
    localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i1, localActivityInfo.applicationInfo);
    if (localObject == null)
    {
      Log.w("SuggestionsAdapter", "Invalid icon resource " + i1 + " for " + paramComponentName.flattenToShortString());
      return null;
    }
    return (Drawable)localObject;
  }
  
  private Drawable b(Cursor paramCursor)
  {
    Object localObject;
    if (this.m == -1) {
      localObject = null;
    }
    Drawable localDrawable;
    do
    {
      return (Drawable)localObject;
      localDrawable = a(paramCursor.getString(this.m));
      localObject = localDrawable;
    } while (localDrawable != null);
    return d(paramCursor);
  }
  
  private Drawable b(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool) {
        try
        {
          Drawable localDrawable1 = a(paramUri);
          return localDrawable1;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          throw new FileNotFoundException("Resource does not exist: " + paramUri);
        }
      }
      localInputStream = this.d.getContentResolver().openInputStream(paramUri);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.w("SuggestionsAdapter", "Icon not found: " + paramUri + ", " + localFileNotFoundException.getMessage());
      return null;
    }
    InputStream localInputStream;
    if (localInputStream == null) {
      throw new FileNotFoundException("Failed to open " + paramUri);
    }
    try
    {
      Drawable localDrawable2 = Drawable.createFromStream(localInputStream, null);
      try
      {
        localInputStream.close();
        return localDrawable2;
      }
      catch (IOException localIOException1)
      {
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + paramUri, localIOException1);
        return localDrawable2;
      }
      try
      {
        localIOException1.close();
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("SuggestionsAdapter", "Error closing icon stream for " + paramUri, localIOException2);
        }
      }
    }
    finally {}
  }
  
  private Drawable b(String paramString)
  {
    paramString = (Drawable.ConstantState)this.e.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private Drawable c(Cursor paramCursor)
  {
    if (this.n == -1) {
      return null;
    }
    return a(paramCursor.getString(this.n));
  }
  
  private Drawable d(Cursor paramCursor)
  {
    paramCursor = a(this.c.getSearchActivity());
    if (paramCursor != null) {
      return paramCursor;
    }
    return this.mContext.getPackageManager().getDefaultActivityIcon();
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString)
  {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  Cursor a(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    if (paramSearchableInfo == null) {}
    do
    {
      return null;
      localObject = paramSearchableInfo.getSuggestAuthority();
    } while (localObject == null);
    Object localObject = new Uri.Builder().scheme("content").authority((String)localObject).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    if (str != null)
    {
      paramSearchableInfo = new String[1];
      paramSearchableInfo[0] = paramString;
    }
    for (;;)
    {
      if (paramInt > 0) {
        ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
      }
      paramString = ((Uri.Builder)localObject).build();
      return this.mContext.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
      ((Uri.Builder)localObject).appendPath(paramString);
      paramSearchableInfo = null;
    }
  }
  
  Drawable a(Uri paramUri)
    throws FileNotFoundException
  {
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str)) {
      throw new FileNotFoundException("No authority: " + paramUri);
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null) {
        throw new FileNotFoundException("No path: " + paramUri);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("No package found for authority: " + paramUri);
    }
    int i1 = localList.size();
    if (i1 == 1) {}
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt((String)localList.get(0));
        if (i1 != 0) {
          break;
        }
        throw new FileNotFoundException("No resource found for: " + paramUri);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Single path segment is not a resource ID: " + paramUri);
      }
      if (i1 == 2) {
        i1 = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), localNumberFormatException);
      } else {
        throw new FileNotFoundException("More than two path segments: " + paramUri);
      }
    }
    return localResources.getDrawable(i1);
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    paramContext = (a)paramView.getTag();
    if (this.o != -1) {}
    for (int i1 = paramCursor.getInt(this.o);; i1 = 0)
    {
      if (paramContext.a != null)
      {
        paramView = a(paramCursor, this.j);
        a(paramContext.a, paramView);
      }
      if (paramContext.b != null)
      {
        paramView = a(paramCursor, this.l);
        if (paramView == null) {
          break label215;
        }
        paramView = a(paramView);
        if (!TextUtils.isEmpty(paramView)) {
          break label227;
        }
        if (paramContext.a != null)
        {
          paramContext.a.setSingleLine(false);
          paramContext.a.setMaxLines(2);
        }
      }
      for (;;)
      {
        a(paramContext.b, paramView);
        if (paramContext.c != null) {
          a(paramContext.c, b(paramCursor), 4);
        }
        if (paramContext.d != null) {
          a(paramContext.d, c(paramCursor), 8);
        }
        if ((this.h != 2) && ((this.h != 1) || ((i1 & 0x1) == 0))) {
          break label253;
        }
        paramContext.e.setVisibility(0);
        paramContext.e.setTag(paramContext.a.getText());
        paramContext.e.setOnClickListener(this);
        return;
        label215:
        paramView = a(paramCursor, this.k);
        break;
        label227:
        if (paramContext.a != null)
        {
          paramContext.a.setSingleLine(true);
          paramContext.a.setMaxLines(1);
        }
      }
      label253:
      paramContext.e.setVisibility(8);
      return;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (this.g)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    for (;;)
    {
      return;
      try
      {
        super.changeCursor(paramCursor);
        if (paramCursor != null)
        {
          this.j = paramCursor.getColumnIndex("suggest_text_1");
          this.k = paramCursor.getColumnIndex("suggest_text_2");
          this.l = paramCursor.getColumnIndex("suggest_text_2_url");
          this.m = paramCursor.getColumnIndex("suggest_icon_1");
          this.n = paramCursor.getColumnIndex("suggest_icon_2");
          this.o = paramCursor.getColumnIndex("suggest_flags");
          return;
        }
      }
      catch (Exception paramCursor)
      {
        Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
      }
    }
  }
  
  public void close()
  {
    changeCursor(null);
    this.g = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      do
      {
        return null;
        String str = getColumnString(paramCursor, "suggest_intent_query");
        if (str != null) {
          return str;
        }
        if (this.c.shouldRewriteQueryFromData())
        {
          str = getColumnString(paramCursor, "suggest_intent_data");
          if (str != null) {
            return str;
          }
        }
      } while (!this.c.shouldRewriteQueryFromText());
      paramCursor = getColumnString(paramCursor, "suggest_text_1");
    } while (paramCursor == null);
    return paramCursor;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = newDropDownView(this.mContext, this.mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).a.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public int getQueryRefinement()
  {
    return this.h;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = newView(this.mContext, this.mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).a.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new a(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(this.f);
    return paramContext;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    a(getCursor());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    a(getCursor());
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.b.a((CharSequence)paramView);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; (this.b.getVisibility() != 0) || (this.b.getWindowVisibility() != 0); paramCharSequence = paramCharSequence.toString()) {
      return null;
    }
    try
    {
      paramCharSequence = a(this.c, paramCharSequence, 50);
      if (paramCharSequence != null)
      {
        paramCharSequence.getCount();
        return paramCharSequence;
      }
    }
    catch (RuntimeException paramCharSequence)
    {
      Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
    }
    return null;
  }
  
  public void setQueryRefinement(int paramInt)
  {
    this.h = paramInt;
  }
  
  private static final class a
  {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    
    public a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(16908308));
      this.b = ((TextView)paramView.findViewById(16908309));
      this.c = ((ImageView)paramView.findViewById(16908295));
      this.d = ((ImageView)paramView.findViewById(16908296));
      this.e = ((ImageView)paramView.findViewById(R.id.edit_query));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */