/***********************************************************************
 * Module:  Keyword.java
 * Author:  ocq
 * Purpose: Defines the Class Keyword
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Keyword {
   public int kId;
   public int id;
   public int 关键词;
   public java.lang.String kUrl;
   public boolean inUse;
   public byte baiduRanking;
   public byte googleRanking;
   public byte s360Ranking;
   public byte yahooRanking;
   public float density;
   public int baiduIndex;
   public int googleIndex;
   public short optimizeDifficultyLevel;
   public boolean userDo;
   public int 关键词对应url;
   public int 是否使用过;
   public int 所属关键词分组;
   
   public java.util.Collection<Article> article;
   /** 当关系双方一个修改了之后另外两方的关系重新计算 */
   public java.util.Collection<Long_Tail> long_Tail;
   /** 双方的修改互不影响 */
   public java.util.Collection<PostRecord> post_Record;
   
   
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
      {
         this.article.add(newArticle);
         newArticle.addKeyword(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldArticle */
   public void removeArticle(Article oldArticle) {
      if (oldArticle == null)
         return;
      if (this.article != null)
         if (this.article.contains(oldArticle))
         {
            this.article.remove(oldArticle);
            oldArticle.removeKeyword(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArticle() {
      if (article != null)
      {
         Article oldArticle;
         for (java.util.Iterator iter = getIteratorArticle(); iter.hasNext();)
         {
            oldArticle = (Article)iter.next();
            iter.remove();
            oldArticle.removeKeyword(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Long_Tail> getLong_Tail() {
      if (long_Tail == null)
         long_Tail = new java.util.HashSet<Long_Tail>();
      return long_Tail;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLong_Tail() {
      if (long_Tail == null)
         long_Tail = new java.util.HashSet<Long_Tail>();
      return long_Tail.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLong_Tail */
   public void setLong_Tail(java.util.Collection<Long_Tail> newLong_Tail) {
      removeAllLong_Tail();
      for (java.util.Iterator iter = newLong_Tail.iterator(); iter.hasNext();)
         addLong_Tail((Long_Tail)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLong_Tail */
   public void addLong_Tail(Long_Tail newLong_Tail) {
      if (newLong_Tail == null)
         return;
      if (this.long_Tail == null)
         this.long_Tail = new java.util.HashSet<Long_Tail>();
      if (!this.long_Tail.contains(newLong_Tail))
      {
         this.long_Tail.add(newLong_Tail);
         newLong_Tail.addKeyword(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldLong_Tail */
   public void removeLong_Tail(Long_Tail oldLong_Tail) {
      if (oldLong_Tail == null)
         return;
      if (this.long_Tail != null)
         if (this.long_Tail.contains(oldLong_Tail))
         {
            this.long_Tail.remove(oldLong_Tail);
            oldLong_Tail.removeKeyword(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLong_Tail() {
      if (long_Tail != null)
      {
         Long_Tail oldLong_Tail;
         for (java.util.Iterator iter = getIteratorLong_Tail(); iter.hasNext();)
         {
            oldLong_Tail = (Long_Tail)iter.next();
            iter.remove();
            oldLong_Tail.removeKeyword(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<PostRecord> getPost_Record() {
      if (post_Record == null)
         post_Record = new java.util.HashSet<PostRecord>();
      return post_Record;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPost_Record() {
      if (post_Record == null)
         post_Record = new java.util.HashSet<PostRecord>();
      return post_Record.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPost_Record */
   public void setPost_Record(java.util.Collection<PostRecord> newPost_Record) {
      removeAllPost_Record();
      for (java.util.Iterator iter = newPost_Record.iterator(); iter.hasNext();)
         addPost_Record((PostRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPost_Record */
   public void addPost_Record(PostRecord newPost_Record) {
      if (newPost_Record == null)
         return;
      if (this.post_Record == null)
         this.post_Record = new java.util.HashSet<PostRecord>();
      if (!this.post_Record.contains(newPost_Record))
      {
         this.post_Record.add(newPost_Record);
         newPost_Record.addKeyword(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPost_Record */
   public void removePost_Record(PostRecord oldPost_Record) {
      if (oldPost_Record == null)
         return;
      if (this.post_Record != null)
         if (this.post_Record.contains(oldPost_Record))
         {
            this.post_Record.remove(oldPost_Record);
            oldPost_Record.removeKeyword(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPost_Record() {
      if (post_Record != null)
      {
         PostRecord oldPost_Record;
         for (java.util.Iterator iter = getIteratorPost_Record(); iter.hasNext();)
         {
            oldPost_Record = (PostRecord)iter.next();
            iter.remove();
            oldPost_Record.removeKeyword(this);
         }
      }
   }

}