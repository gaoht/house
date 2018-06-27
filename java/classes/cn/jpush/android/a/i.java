package cn.jpush.android.a;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class i
{
  private static Queue<Integer> a = new ConcurrentLinkedQueue();
  
  public static int a()
  {
    if (a.size() > 0) {
      return ((Integer)a.poll()).intValue();
    }
    return 0;
  }
  
  public static boolean a(int paramInt)
  {
    return a.offer(Integer.valueOf(paramInt));
  }
  
  public static int b()
  {
    return a.size();
  }
  
  public static boolean b(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */