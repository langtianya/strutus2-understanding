/***********************************************************************
 * Module:  Sns_Article.java
 * Author:  ocq
 * Purpose: Defines the Class Sns_Article
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class SnsArticle extends Article {
   public int snaId;
   
   public java.util.Collection<Search_Keword> search_Keword;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Search_Keword> getSearch_Keword() {
      if (search_Keword == null)
         search_Keword = new java.util.HashSet<Search_Keword>();
      return search_Keword;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSearch_Keword() {
      if (search_Keword == null)
         search_Keword = new java.util.HashSet<Search_Keword>();
      return search_Keword.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSearch_Keword */
   public void setSearch_Keword(java.util.Collection<Search_Keword> newSearch_Keword) {
      removeAllSearch_Keword();
      for (java.util.Iterator iter = newSearch_Keword.iterator(); iter.hasNext();)
         addSearch_Keword((Search_Keword)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSearch_Keword */
   public void addSearch_Keword(Search_Keword newSearch_Keword) {
      if (newSearch_Keword == null)
         return;
      if (this.search_Keword == null)
         this.search_Keword = new java.util.HashSet<Search_Keword>();
      if (!this.search_Keword.contains(newSearch_Keword))
      {
         this.search_Keword.add(newSearch_Keword);
         newSearch_Keword.addSns_Article(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSearch_Keword */
   public void removeSearch_Keword(Search_Keword oldSearch_Keword) {
      if (oldSearch_Keword == null)
         return;
      if (this.search_Keword != null)
         if (this.search_Keword.contains(oldSearch_Keword))
         {
            this.search_Keword.remove(oldSearch_Keword);
            oldSearch_Keword.removeSns_Article(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSearch_Keword() {
      if (search_Keword != null)
      {
         Search_Keword oldSearch_Keword;
         for (java.util.Iterator iter = getIteratorSearch_Keword(); iter.hasNext();)
         {
            oldSearch_Keword = (Search_Keword)iter.next();
            iter.remove();
            oldSearch_Keword.removeSns_Article(this);
         }
      }
   }

}