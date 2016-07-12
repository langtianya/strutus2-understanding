/***********************************************************************
 * Module:  Group.java
 * Author:  ocq
 * Purpose: Defines the Class Group
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

/** 可能是网站分组也可能是关键词分组............ */
public class Group {
   public short gId;
   public java.lang.String gName;
   
   public java.util.Collection<Site> site;
   /** 多对多可能造成一个分组的关键词修改了而其他组的同一关键词肯能必须修改，有些用户可能不想要这种效果，于是改成多 多一，虽然存在数据重复，但毕竟关键词一搬不多；如果需要一个分组的关键词修改了另外一个分组的跟着修改，根据次主键来判定其他分组是否有相同关键词有的话提醒是否同时修改 */
   public java.util.Collection<Keyword> keyword;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Site> getSite() {
      if (site == null)
         site = new java.util.HashSet<Site>();
      return site;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSite() {
      if (site == null)
         site = new java.util.HashSet<Site>();
      return site.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSite */
   public void setSite(java.util.Collection<Site> newSite) {
      removeAllSite();
      for (java.util.Iterator iter = newSite.iterator(); iter.hasNext();)
         addSite((Site)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSite */
   public void addSite(Site newSite) {
      if (newSite == null)
         return;
      if (this.site == null)
         this.site = new java.util.HashSet<Site>();
      if (!this.site.contains(newSite))
         this.site.add(newSite);
   }
   
   /** @pdGenerated default remove
     * @param oldSite */
   public void removeSite(Site oldSite) {
      if (oldSite == null)
         return;
      if (this.site != null)
         if (this.site.contains(oldSite))
            this.site.remove(oldSite);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSite() {
      if (site != null)
         site.clear();
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
         this.keyword.add(newKeyword);
   }
   
   /** @pdGenerated default remove
     * @param oldKeyword */
   public void removeKeyword(Keyword oldKeyword) {
      if (oldKeyword == null)
         return;
      if (this.keyword != null)
         if (this.keyword.contains(oldKeyword))
            this.keyword.remove(oldKeyword);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKeyword() {
      if (keyword != null)
         keyword.clear();
   }

}