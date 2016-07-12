/***********************************************************************
 * Module:  Task.java
 * Author:  ocq
 * Purpose: Defines the Class Task
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Task {
   public short taId;
   public java.lang.String taName;
   public java.util.Date startTime;
   public java.util.Date endTime;
   public boolean goOnAfterReboot;
   public int pos;
   /** 成功总数=网站成功数量*该网站执行该任务的次数 */
   public int sumSuccessCount;
   public int siteSuccessCoun;
   
   public java.util.Collection<Site> site;
   
   
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
      {
         this.site.add(newSite);
         newSite.addTask(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSite */
   public void removeSite(Site oldSite) {
      if (oldSite == null)
         return;
      if (this.site != null)
         if (this.site.contains(oldSite))
         {
            this.site.remove(oldSite);
            oldSite.removeTask(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSite() {
      if (site != null)
      {
         Site oldSite;
         for (java.util.Iterator iter = getIteratorSite(); iter.hasNext();)
         {
            oldSite = (Site)iter.next();
            iter.remove();
            oldSite.removeTask(this);
         }
      }
   }

}