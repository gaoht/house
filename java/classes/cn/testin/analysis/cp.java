package cn.testin.analysis;

import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cp
  extends cr
{
  private final Map<TextView, TextWatcher> a = new HashMap();
  
  public cp(String paramString1, String paramString2, String paramString3, cs paramcs)
  {
    super(paramString1, paramString2, paramString3, paramcs, true);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getKey()).removeTextChangedListener((TextWatcher)localEntry.getValue());
    }
    this.a.clear();
  }
  
  public void a(View paramView)
  {
    TextView localTextView;
    cq localcq;
    if ((paramView instanceof TextView))
    {
      localTextView = (TextView)paramView;
      localcq = new cq(this, localTextView);
      TextWatcher localTextWatcher = (TextWatcher)this.a.get(localTextView);
      if (localTextWatcher == null) {
        break label66;
      }
      localTextView.removeTextChangedListener(localTextWatcher);
    }
    for (;;)
    {
      localTextView.addTextChangedListener(localcq);
      this.a.put(localTextView, localcq);
      return;
      label66:
      c(paramView);
    }
  }
  
  protected String b()
  {
    return c() + " on Text Change";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */