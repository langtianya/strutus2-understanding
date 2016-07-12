/***********************************************************************
 * Module:  Search_Keword.java
 * Author:  ocq
 * Purpose: Defines the Class Search_Keword
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Search_Keword {
   public int skId;
   public java.lang.String skName;
   
   public java.util.Collection<SnsArticle> sns_Article;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<SnsArticle> getSns_Article() {
      if (sns_Article == null)
         sns_Article = new java.util.HashSet<SnsArticle>();
      return sns_Article;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSns_Article() {
      if (sns_Article == null)
         sns_Article = new java.util.HashSet<SnsArticle>();
      return sns_Article.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSns_Article */
   public void setSns_Article(java.util.Collection<SnsArticle> newSns_Article) {
      removeAllSns_Article();
      for (java.util.Iterator iter = newSns_Article.iterator(); iter.hasNext();)
         addSns_Article((SnsArticle)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSns_Article */
   public void addSns_Article(SnsArticle newSns_Article) {
      if (newSns_Article == null)
         return;
      if (this.sns_Article == null)
         this.sns_Article = new java.util.HashSet<SnsArticle>();
      if (!this.sns_Article.contains(newSns_Article))
      {
         this.sns_Article.add(newSns_Article);
         newSns_Article.addSearch_Keword(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSns_Article */
   public void removeSns_Article(SnsArticle oldSns_Article) {
      if (oldSns_Article == null)
         return;
      if (this.sns_Article != null)
         if (this.sns_Article.contains(oldSns_Article))
         {
            this.sns_Article.remove(oldSns_Article);
            oldSns_Article.removeSearch_Keword(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSns_Article() {
      if (sns_Article != null)
      {
         SnsArticle oldSns_Article;
         for (java.util.Iterator iter = getIteratorSns_Article(); iter.hasNext();)
         {
            oldSns_Article = (SnsArticle)iter.next();
            iter.remove();
            oldSns_Article.removeSearch_Keword(this);
         }
      }
   }

}