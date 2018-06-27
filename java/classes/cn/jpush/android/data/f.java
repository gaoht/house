package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

final class f
  extends SQLiteOpenHelper
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "Q7.f\\WE?fJ^ KSW~\n\bFd|\n\037Nn{\006\nSa}\013K\017W{\001KnFF ,bZ259nES72\007CW<Kf]F*\"iK@ &bFFEGKfM\f\017\007d}\013\f\007f}\021KI}~\tGKfM\006\004RffE\002I|w\002\016U(|\n\037\007fg\t\007\013d|:\031Be}\023\016\007a|\021\016@m`E\005H|2\013\036Kd>\t\005x|k\025\016\007a|\021\016@m`E\005H|2\013\036Kd>\t\005xmj\021\031F(f\000\023S(>\t\005x|`\f\f@m`:\037NewE\007HfuEGKfM\004\017CWf\f\006B(~\n\005@(;^";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 8;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "^\n\bFd\\\n\037Nn{\006\nSa}\013/e";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "衺嶗纤孿圠";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "x\025\036T`M\t\004Di~:\005H|{\003\002Dif\f\004I&v\007";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "V7$w(F$)kM2,-\007MJ,8s[2\0214Kgq\004\007Igf\f\rNks\021\002Hf";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 18;
        break label91;
        i = 101;
        break label91;
        i = 107;
        break label91;
        i = 39;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public f(Context paramContext)
  {
    this(paramContext, z[3], null, 1);
  }
  
  private f(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(z[0]);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      cn.jpush.android.c.f.a(z[1], z[2]);
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL(z[4]);
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */