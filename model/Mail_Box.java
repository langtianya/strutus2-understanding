/***********************************************************************
 * Module:  Mail_Box.java
 * Author:  ocq
 * Purpose: Defines the Class Mail_Box
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Mail_Box {
   public int mbId;
   public java.lang.String password;
   public java.lang.String userName;
   public java.lang.String pop3Host;
   public java.lang.String smtpHost;
   public boolean requestSsl;
   public short pop3Port;
   public short smtpPort;
   public boolean valid;
   
   public java.util.Collection<Email> email;
   public java.util.Collection<Site> site;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Email> getEmail() {
      if (email == null)
         email = new java.util.HashSet<Email>();
      return email;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEmail() {
      if (email == null)
         email = new java.util.HashSet<Email>();
      return email.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEmail */
   public void setEmail(java.util.Collection<Email> newEmail) {
      removeAllEmail();
      for (java.util.Iterator iter = newEmail.iterator(); iter.hasNext();)
         addEmail((Email)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEmail */
   public void addEmail(Email newEmail) {
      if (newEmail == null)
         return;
      if (this.email == null)
         this.email = new java.util.HashSet<Email>();
      if (!this.email.contains(newEmail))
         this.email.add(newEmail);
   }
   
   /** @pdGenerated default remove
     * @param oldEmail */
   public void removeEmail(Email oldEmail) {
      if (oldEmail == null)
         return;
      if (this.email != null)
         if (this.email.contains(oldEmail))
            this.email.remove(oldEmail);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllEmail() {
      if (email != null)
         email.clear();
   }
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
         newSite.addMail_Box(this);      
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
            oldSite.removeMail_Box(this);
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
            oldSite.removeMail_Box(this);
         }
      }
   }

}