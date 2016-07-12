/***********************************************************************
 * Module:  Site_Type.java
 * Author:  ocq
 * Purpose: Defines the Class Site_Type
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

/** 识别该网站属于哪种类型网站，比如是dz的，新浪博客的，百度空间的。。。 */
public class SiteType {
   public short stId;
   public java.lang.String stName;
   
   public java.util.Collection<Site> site;
   public java.util.Collection<SnsUserHome> sns_User_Home;
   
   
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
   public java.util.Collection<SnsUserHome> getSns_User_Home() {
      if (sns_User_Home == null)
         sns_User_Home = new java.util.HashSet<SnsUserHome>();
      return sns_User_Home;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSns_User_Home() {
      if (sns_User_Home == null)
         sns_User_Home = new java.util.HashSet<SnsUserHome>();
      return sns_User_Home.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSns_User_Home */
   public void setSns_User_Home(java.util.Collection<SnsUserHome> newSns_User_Home) {
      removeAllSns_User_Home();
      for (java.util.Iterator iter = newSns_User_Home.iterator(); iter.hasNext();)
         addSns_User_Home((SnsUserHome)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSns_User_Home */
   public void addSns_User_Home(SnsUserHome newSns_User_Home) {
      if (newSns_User_Home == null)
         return;
      if (this.sns_User_Home == null)
         this.sns_User_Home = new java.util.HashSet<SnsUserHome>();
      if (!this.sns_User_Home.contains(newSns_User_Home))
         this.sns_User_Home.add(newSns_User_Home);
   }
   
   /** @pdGenerated default remove
     * @param oldSns_User_Home */
   public void removeSns_User_Home(SnsUserHome oldSns_User_Home) {
      if (oldSns_User_Home == null)
         return;
      if (this.sns_User_Home != null)
         if (this.sns_User_Home.contains(oldSns_User_Home))
            this.sns_User_Home.remove(oldSns_User_Home);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSns_User_Home() {
      if (sns_User_Home != null)
         sns_User_Home.clear();
   }

}