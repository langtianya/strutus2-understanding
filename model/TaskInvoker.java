/***********************************************************************
 * Module:  TaskInvoker.java
 * Author:  ocq
 * Purpose: Defines the Class TaskInvoker
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class TaskInvoker {
   public java.util.Collection<Task> task;
   
   
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
         this.task.add(newTask);
   }
   
   /** @pdGenerated default remove
     * @param oldTask */
   public void removeTask(Task oldTask) {
      if (oldTask == null)
         return;
      if (this.task != null)
         if (this.task.contains(oldTask))
            this.task.remove(oldTask);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTask() {
      if (task != null)
         task.clear();
   }

}