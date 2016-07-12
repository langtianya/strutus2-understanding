/***********************************************************************
 * Module:  Site.java
 * Author:  ocq
 * Purpose: Defines the Class Site
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public abstract class Site {
   public long sId;
   public java.lang.String sTitle;
   public java.lang.String sUrl;
   public byte pr;
   public java.lang.String regUrl;
   public java.lang.String loginUrl;
   public java.lang.String postUrl;
   public java.lang.String commentUrl;
   public java.lang.String codeUrl;
   public java.lang.String signUrl;
   public Hashtable data;
   public boolean verified;
   public boolean reUseEmail;
   public boolean postable;
   public boolean commentable;
   public boolean signable;
   
   private boolean haveAccount;
   
   public java.util.Collection<Task> task;
   /** 为了避免生成一个中间表，虽然一个帐号可以属于多个网站，比如qq、新浪微博帐号可以在一些其他网站上登录，但是毕竟这种情况可能不多，构成一点数据重复是可以接受的，因此还是设计成一比多关系，以后看情况再说 */
   public java.util.Collection<SiteAccount> siteAccount;
   public java.util.Collection<Mail_Box> mail_Box;
   /** 本来是多对多关系，但是由于并不会查询执行某文章的所有网站，但需要查询某网站执行发布的所有文章，所以设计成多多一.        
    *    一旦发布任务完成，他们的关系就断开 */
   public java.util.Collection<Article> article;
   public java.util.Collection<PostRecord> post_Record;
   public Site_Impl site_Impl;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Task> getTask() {
      if (task == null)
         task = new java.util.HashSet<Task>();
      return task;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTask() {
      if (task == null)
         task = new java.util.HashSet<Task>();
      return task.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTask */
   public void setTask(java.util.Collection<Task> newTask) {
      removeAllTask();
      for (java.util.Iterator iter = newTask.iterator(); iter.hasNext();)
         addTask((Task)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTask */
   public void addTask(Task newTask) {
      if (newTask == null)
         return;
      if (this.task == null)
         this.task = new java.util.HashSet<Task>();
      if (!this.task.contains(newTask))
      {
         this.task.add(newTask);
         newTask.addSite(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTask */
   public void removeTask(Task oldTask) {
      if (oldTask == null)
         return;
      if (this.task != null)
         if (this.task.contains(oldTask))
         {
            this.task.remove(oldTask);
            oldTask.removeSite(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTask() {
      if (task != null)
      {
         Task oldTask;
         for (java.util.Iterator iter = getIteratorTask(); iter.hasNext();)
         {
            oldTask = (Task)iter.next();
            iter.remove();
            oldTask.removeSite(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<SiteAccount> getSiteAccount() {
      if (siteAccount == null)
         siteAccount = new java.util.HashSet<SiteAccount>();
      return siteAccount;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSiteAccount() {
      if (siteAccount == null)
         siteAccount = new java.util.HashSet<SiteAccount>();
      return siteAccount.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSiteAccount */
   public void setSiteAccount(java.util.Collection<SiteAccount> newSiteAccount) {
      removeAllSiteAccount();
      for (java.util.Iterator iter = newSiteAccount.iterator(); iter.hasNext();)
         addSiteAccount((SiteAccount)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSiteAccount */
   public void addSiteAccount(SiteAccount newSiteAccount) {
      if (newSiteAccount == null)
         return;
      if (this.siteAccount == null)
         this.siteAccount = new java.util.HashSet<SiteAccount>();
      if (!this.siteAccount.contains(newSiteAccount))
         this.siteAccount.add(newSiteAccount);
   }
   
   /** @pdGenerated default remove
     * @param oldSiteAccount */
   public void removeSiteAccount(SiteAccount oldSiteAccount) {
      if (oldSiteAccount == null)
         return;
      if (this.siteAccount != null)
         if (this.siteAccount.contains(oldSiteAccount))
            this.siteAccount.remove(oldSiteAccount);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSiteAccount() {
      if (siteAccount != null)
         siteAccount.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Mail_Box> getMail_Box() {
      if (mail_Box == null)
         mail_Box = new java.util.HashSet<Mail_Box>();
      return mail_Box;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMail_Box() {
      if (mail_Box == null)
         mail_Box = new java.util.HashSet<Mail_Box>();
      return mail_Box.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMail_Box */
   public void setMail_Box(java.util.Collection<Mail_Box> newMail_Box) {
      removeAllMail_Box();
      for (java.util.Iterator iter = newMail_Box.iterator(); iter.hasNext();)
         addMail_Box((Mail_Box)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMail_Box */
   public void addMail_Box(Mail_Box newMail_Box) {
      if (newMail_Box == null)
         return;
      if (this.mail_Box == null)
         this.mail_Box = new java.util.HashSet<Mail_Box>();
      if (!this.mail_Box.contains(newMail_Box))
      {
         this.mail_Box.add(newMail_Box);
         newMail_Box.addSite(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldMail_Box */
   public void removeMail_Box(Mail_Box oldMail_Box) {
      if (oldMail_Box == null)
         return;
      if (this.mail_Box != null)
         if (this.mail_Box.contains(oldMail_Box))
         {
            this.mail_Box.remove(oldMail_Box);
            oldMail_Box.removeSite(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMail_Box() {
      if (mail_Box != null)
      {
         Mail_Box oldMail_Box;
         for (java.util.Iterator iter = getIteratorMail_Box(); iter.hasNext();)
         {
            oldMail_Box = (Mail_Box)iter.next();
            iter.remove();
            oldMail_Box.removeSite(this);
         }
      }
   }
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

public boolean isHaveAccount() {
	return haveAccount;
}

public void setHaveAccount(boolean haveAccount) {
	this.haveAccount = haveAccount;
}

}