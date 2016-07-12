/***********************************************************************
 * Module:  Schedu.java
 * Author:  ocq
 * Purpose: Defines the Class Schedu
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Schedu {
   public java.util.Collection<ImplFactory> implFactory;
   public java.util.Collection<TaskFactory> taskFactory;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ImplFactory> getImplFactory() {
      if (implFactory == null)
         implFactory = new java.util.HashSet<ImplFactory>();
      return implFactory;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorImplFactory() {
      if (implFactory == null)
         implFactory = new java.util.HashSet<ImplFactory>();
      return implFactory.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newImplFactory */
   public void setImplFactory(java.util.Collection<ImplFactory> newImplFactory) {
      removeAllImplFactory();
      for (java.util.Iterator iter = newImplFactory.iterator(); iter.hasNext();)
         addImplFactory((ImplFactory)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newImplFactory */
   public void addImplFactory(ImplFactory newImplFactory) {
      if (newImplFactory == null)
         return;
      if (this.implFactory == null)
         this.implFactory = new java.util.HashSet<ImplFactory>();
      if (!this.implFactory.contains(newImplFactory))
         this.implFactory.add(newImplFactory);
   }
   
   /** @pdGenerated default remove
     * @param oldImplFactory */
   public void removeImplFactory(ImplFactory oldImplFactory) {
      if (oldImplFactory == null)
         return;
      if (this.implFactory != null)
         if (this.implFactory.contains(oldImplFactory))
            this.implFactory.remove(oldImplFactory);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllImplFactory() {
      if (implFactory != null)
         implFactory.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TaskFactory> getTaskFactory() {
      if (taskFactory == null)
         taskFactory = new java.util.HashSet<TaskFactory>();
      return taskFactory;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTaskFactory() {
      if (taskFactory == null)
         taskFactory = new java.util.HashSet<TaskFactory>();
      return taskFactory.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTaskFactory */
   public void setTaskFactory(java.util.Collection<TaskFactory> newTaskFactory) {
      removeAllTaskFactory();
      for (java.util.Iterator iter = newTaskFactory.iterator(); iter.hasNext();)
         addTaskFactory((TaskFactory)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTaskFactory */
   public void addTaskFactory(TaskFactory newTaskFactory) {
      if (newTaskFactory == null)
         return;
      if (this.taskFactory == null)
         this.taskFactory = new java.util.HashSet<TaskFactory>();
      if (!this.taskFactory.contains(newTaskFactory))
         this.taskFactory.add(newTaskFactory);
   }
   
   /** @pdGenerated default remove
     * @param oldTaskFactory */
   public void removeTaskFactory(TaskFactory oldTaskFactory) {
      if (oldTaskFactory == null)
         return;
      if (this.taskFactory != null)
         if (this.taskFactory.contains(oldTaskFactory))
            this.taskFactory.remove(oldTaskFactory);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTaskFactory() {
      if (taskFactory != null)
         taskFactory.clear();
   }

}