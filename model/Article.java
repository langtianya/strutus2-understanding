/***********************************************************************
 * Module:  Article.java
 * Author:  ocq
 * Purpose: Defines the Class Article
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Article {
   public int aId;
   public java.lang.String aTitle;
   public java.lang.String body;
   public boolean posted;
   public boolean useable;
   public Properties properties;
   /** 是编辑状态呢还是被预览状态呢，还是。。。 */
   public byte status;
   
   /** 当关系双方一个修改了之后另外两方的关系重新计算 */
   public java.util.Collection<Bad_Word> bad_Word;
   public java.util.Collection<PostRecord> post_Record;
   public java.util.Collection<Keyword> keyword;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Bad_Word> getBad_Word() {
      if (bad_Word == null)
         bad_Word = new java.util.HashSet<Bad_Word>();
      return bad_Word;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorBad_Word() {
      if (bad_Word == null)
         bad_Word = new java.util.HashSet<Bad_Word>();
      return bad_Word.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newBad_Word */
   public void setBad_Word(java.util.Collection<Bad_Word> newBad_Word) {
      removeAllBad_Word();
      for (java.util.Iterator iter = newBad_Word.iterator(); iter.hasNext();)
         addBad_Word((Bad_Word)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBad_Word */
   public void addBad_Word(Bad_Word newBad_Word) {
      if (newBad_Word == null)
         return;
      if (this.bad_Word == null)
         this.bad_Word = new java.util.HashSet<Bad_Word>();
      if (!this.bad_Word.contains(newBad_Word))
         this.bad_Word.add(newBad_Word);
   }
   
   /** @pdGenerated default remove
     * @param oldBad_Word */
   public void removeBad_Word(Bad_Word oldBad_Word) {
      if (oldBad_Word == null)
         return;
      if (this.bad_Word != null)
         if (this.bad_Word.contains(oldBad_Word))
            this.bad_Word.remove(oldBad_Word);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllBad_Word() {
      if (bad_Word != null)
         bad_Word.clear();
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
         this.post_Record.add(newPost_Record);
   }
   
   /** @pdGenerated default remove
     * @param oldPost_Record */
   public void removePost_Record(PostRecord oldPost_Record) {
      if (oldPost_Record == null)
         return;
      if (this.post_Record != null)
         if (this.post_Record.contains(oldPost_Record))
            this.post_Record.remove(oldPost_Record);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPost_Record() {
      if (post_Record != null)
         post_Record.clear();
   }
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
         newKeyword.addArticle(this);      
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
            oldKeyword.removeArticle(this);
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
            oldKeyword.removeArticle(this);
         }
      }
   }

}