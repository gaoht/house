package com.mob.commons;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MobProductParser
  implements PublicMemberKeeper
{
  public static HashMap<String, MobProduct> parse()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new ArrayList();
    try
    {
      Object localObject2 = new SHARESDK();
      if ((localObject2 instanceof MobProduct)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      try
      {
        localObject2 = new SMSSDK();
        if ((localObject2 instanceof MobProduct)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        try
        {
          localObject2 = new SHAREREC();
          if ((localObject2 instanceof MobProduct)) {
            ((ArrayList)localObject1).add(localObject2);
          }
          try
          {
            localObject2 = new MOBAPI();
            if ((localObject2 instanceof MobProduct)) {
              ((ArrayList)localObject1).add(localObject2);
            }
            try
            {
              localObject2 = new MOBLINK();
              if ((localObject2 instanceof MobProduct)) {
                ((ArrayList)localObject1).add(localObject2);
              }
              try
              {
                localObject2 = new UMSSDK();
                if ((localObject2 instanceof MobProduct)) {
                  ((ArrayList)localObject1).add(localObject2);
                }
                try
                {
                  localObject2 = new CMSSDK();
                  if ((localObject2 instanceof MobProduct)) {
                    ((ArrayList)localObject1).add(localObject2);
                  }
                  try
                  {
                    localObject2 = new BBSSDK();
                    if ((localObject2 instanceof MobProduct)) {
                      ((ArrayList)localObject1).add(localObject2);
                    }
                    try
                    {
                      localObject2 = new SHOPSDK();
                      if ((localObject2 instanceof MobProduct)) {
                        ((ArrayList)localObject1).add(localObject2);
                      }
                      try
                      {
                        localObject2 = new PAYSDK();
                        if ((localObject2 instanceof MobProduct)) {
                          ((ArrayList)localObject1).add(localObject2);
                        }
                        try
                        {
                          localObject2 = new MOBIM();
                          if ((localObject2 instanceof MobProduct)) {
                            ((ArrayList)localObject1).add(localObject2);
                          }
                          try
                          {
                            localObject2 = new MOBPUSH();
                            if ((localObject2 instanceof MobProduct)) {
                              ((ArrayList)localObject1).add(localObject2);
                            }
                            try
                            {
                              localObject2 = new ANALYSDK();
                              if ((localObject2 instanceof MobProduct)) {
                                ((ArrayList)localObject1).add(localObject2);
                              }
                              localObject1 = ((ArrayList)localObject1).iterator();
                              label409:
                              while (((Iterator)localObject1).hasNext())
                              {
                                localObject2 = (MobProduct)((Iterator)localObject1).next();
                                String[] arrayOfString = MobProductCollector.MOB_PRODUCTS;
                                int j = arrayOfString.length;
                                int i = 0;
                                for (;;)
                                {
                                  if (i >= j) {
                                    break label409;
                                  }
                                  String str = arrayOfString[i];
                                  try
                                  {
                                    if (str.equals(((MobProduct)localObject2).getProductTag())) {
                                      localHashMap.put(str, localObject2);
                                    }
                                  }
                                  catch (Throwable localThrowable14)
                                  {
                                    i += 1;
                                  }
                                }
                              }
                              return localHashMap;
                            }
                            catch (Throwable localThrowable1)
                            {
                              for (;;) {}
                            }
                          }
                          catch (Throwable localThrowable2)
                          {
                            for (;;) {}
                          }
                        }
                        catch (Throwable localThrowable3)
                        {
                          for (;;) {}
                        }
                      }
                      catch (Throwable localThrowable4)
                      {
                        for (;;) {}
                      }
                    }
                    catch (Throwable localThrowable5)
                    {
                      for (;;) {}
                    }
                  }
                  catch (Throwable localThrowable6)
                  {
                    for (;;) {}
                  }
                }
                catch (Throwable localThrowable7)
                {
                  for (;;) {}
                }
              }
              catch (Throwable localThrowable8)
              {
                for (;;) {}
              }
            }
            catch (Throwable localThrowable9)
            {
              for (;;) {}
            }
          }
          catch (Throwable localThrowable10)
          {
            for (;;) {}
          }
        }
        catch (Throwable localThrowable11)
        {
          for (;;) {}
        }
      }
      catch (Throwable localThrowable12)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable13)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/MobProductParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */