/***********************************************************************
 * Module:  ImplFactory.java
 * Author:  ocq
 * Purpose: Defines the Class ImplFactory
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class ImplFactory {
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

}