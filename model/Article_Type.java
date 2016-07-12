/***********************************************************************
 * Module:  Article_Type.java
 * Author:  ocq
 * Purpose: Defines the Class Article_Type
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Article_Type {
   public int atId;
   /** 是html还是txt还是。。。 */
   public java.lang.String type;
   
   /** txt还是html等 */
   public java.util.Collection<Article> article;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Article> getArticle() {
      if (article == null)
         article = new java.util.HashSet<Article>();
      return article;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorArticle() {
      if (article == null)
         article = new java.util.HashSet<Article>();
      return article.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArticle */
   public void setArticle(java.util.Collection<Article> newArticle) {
      removeAllArticle();
      for (java.util.Iterator iter = newArticle.iterator(); iter.hasNext();)
         addArticle((Article)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArticle */
   public void addArticle(Article newArticle) {
      if (newArticle == null)
         return;
      if (this.article == null)
         this.article = new java.util.HashSet<Article>();
      if (!this.article.contains(newArticle))
         this.article.add(newArticle);
   }
   
   /** @pdGenerated default remove
     * @param oldArticle */
   public void removeArticle(Article oldArticle) {
      if (oldArticle == null)
         return;
      if (this.article != null)
         if (this.article.contains(oldArticle))
            this.article.remove(oldArticle);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArticle() {
      if (article != null)
         article.clear();
   }

}