/***********************************************************************
 * Module:  Post_Record.java
 * Author:  ocq
 * Purpose: Defines the Class Post_Record
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

/** 发布记录 */
public class PostRecord {
   public int prId;
   public java.lang.String pUrl;
   public java.lang.String pTitle;
   public boolean baiduIncluded;
   public boolean googleIncluded;
   public boolean s360Included;
   public boolean yahooIncluded;
   public boolean rssSubmit;
   public java.util.Date postTime;
   
   /** 双方的修改互不影响 */
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
         newKeyword.addPost_Record(this);      
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
            oldKeyword.removePost_Record(this);
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
            oldKeyword.removePost_Record(this);
         }
      }
   }

}