/***********************************************************************
 * Module:  Long_Tail.java
 * Author:  ocq
 * Purpose: Defines the Class Long_Tail
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Long_Tail {
   public int aId;
   public java.lang.String ltName;
   
   /** 当关系双方一个修改了之后另外两方的关系重新计算 */
   public java.util.Collection<Keyword> keyword;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Keyword> getKeyword() {
      if (keyword == null)
         keyword = new java.util.HashSet<Keyword>();
      return keyword;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKeyword() {
      if (keyword == null)
         keyword = new java.util.HashSet<Keyword>();
      return keyword.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKeyword */
   public void setKeyword(java.util.Collection<Keyword> newKeyword) {
      removeAllKeyword();
      for (java.util.Iterator iter = newKeyword.iterator(); iter.hasNext();)
         addKeyword((Keyword)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKeyword */
   public void addKeyword(Keyword newKeyword) {
      if (newKeyword == null)
         return;
      if (this.keyword == null)
         this.keyword = new java.util.HashSet<Keyword>();
      if (!this.keyword.contains(newKeyword))
      {
         this.keyword.add(newKeyword);
         newKeyword.addLong_Tail(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldKeyword */
   public void removeKeyword(Keyword oldKeyword) {
      if (oldKeyword == null)
         return;
      if (this.keyword != null)
         if (this.keyword.contains(oldKeyword))
         {
            this.keyword.remove(oldKeyword);
            oldKeyword.removeLong_Tail(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKeyword() {
      if (keyword != null)
      {
         Keyword oldKeyword;
         for (java.util.Iterator iter = getIteratorKeyword(); iter.hasNext();)
         {
            oldKeyword = (Keyword)iter.next();
            iter.remove();
            oldKeyword.removeLong_Tail(this);
         }
      }
   }

}