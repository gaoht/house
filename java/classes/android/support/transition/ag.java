package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ag
{
  public final Map<String, Object> a = new HashMap();
  public View b;
  final ArrayList<Transition> c = new ArrayList();
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ag)) && (this.b == ((ag)paramObject).b) && (this.a.equals(((ag)paramObject).a));
  }
  
  public int hashCode()
  {
    return this.b.hashCode() * 31 + this.a.hashCode();
  }
  
  public String toString()
  {
    String str1 = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
    str1 = str1 + "    view = " + this.b + "\n";
    str1 = str1 + "    values:";
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      str1 = str1 + "    " + str2 + ": " + this.a.get(str2) + "\n";
    }
    return str1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */