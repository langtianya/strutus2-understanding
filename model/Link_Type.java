/***********************************************************************
 * Module:  Link_Type.java
 * Author:  ocq
 * Purpose: Defines the Class Link_Type
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

/** 发布出去的文章的链接类型，用来查询所带连接为xx的发布出历史记录收录情况等 */
public class Link_Type {
   public byte litId;
   /** 类型为：keySuper、urlSuper、key_urlText、urlText、none */
   public java.lang.String lktname;
   
   public java.util.Collection<PostRecord> post_Record;
   
   
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

}