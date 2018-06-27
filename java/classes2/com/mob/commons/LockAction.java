package com.mob.commons;

import com.mob.tools.utils.FileLocker;

public abstract interface LockAction
{
  public abstract boolean run(FileLocker paramFileLocker);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/LockAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */