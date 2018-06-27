package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

public abstract interface JSONLexer
{
  public static final int ARRAY = 2;
  public static final int END = 4;
  public static final char EOI = '\032';
  public static final int NOT_MATCH = -1;
  public static final int NOT_MATCH_NAME = -2;
  public static final int OBJECT = 1;
  public static final int UNKNOWN = 0;
  public static final int VALUE = 3;
  public static final int VALUE_NULL = 5;
  
  public abstract byte[] bytesValue();
  
  public abstract void close();
  
  public abstract void config(Feature paramFeature, boolean paramBoolean);
  
  public abstract Number decimalValue(boolean paramBoolean);
  
  public abstract BigDecimal decimalValue();
  
  public abstract float floatValue();
  
  public abstract char getCurrent();
  
  public abstract Locale getLocale();
  
  public abstract TimeZone getTimeZone();
  
  public abstract String info();
  
  public abstract int intValue();
  
  public abstract Number integerValue();
  
  public abstract boolean isBlankInput();
  
  public abstract boolean isEnabled(int paramInt);
  
  public abstract boolean isEnabled(Feature paramFeature);
  
  public abstract boolean isRef();
  
  public abstract long longValue();
  
  public abstract char next();
  
  public abstract void nextToken();
  
  public abstract void nextToken(int paramInt);
  
  public abstract void nextTokenWithColon();
  
  public abstract void nextTokenWithColon(int paramInt);
  
  public abstract String numberString();
  
  public abstract int pos();
  
  public abstract void resetStringPosition();
  
  public abstract boolean scanBoolean(char paramChar);
  
  public abstract double scanDouble(char paramChar);
  
  public abstract Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar);
  
  public abstract float scanFloat(char paramChar);
  
  public abstract int scanInt(char paramChar);
  
  public abstract long scanLong(char paramChar);
  
  public abstract void scanNumber();
  
  public abstract String scanString(char paramChar);
  
  public abstract void scanString();
  
  public abstract void scanStringArray(Collection<String> paramCollection, char paramChar);
  
  public abstract String scanSymbol(SymbolTable paramSymbolTable);
  
  public abstract String scanSymbol(SymbolTable paramSymbolTable, char paramChar);
  
  public abstract String scanSymbolUnQuoted(SymbolTable paramSymbolTable);
  
  public abstract String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar);
  
  public abstract void setLocale(Locale paramLocale);
  
  public abstract void setTimeZone(TimeZone paramTimeZone);
  
  public abstract void skipWhitespace();
  
  public abstract String stringVal();
  
  public abstract int token();
  
  public abstract String tokenName();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/JSONLexer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */