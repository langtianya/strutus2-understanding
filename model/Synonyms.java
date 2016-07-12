/***********************************************************************
 * Module:  Synonyms.java
 * Author:  ocq
 * Purpose: Defines the Class Synonyms
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

public class Synonyms {
   public int syId;
   public java.lang.String syWord;
   public java.lang.String language;
   
   public java.util.Collection<Synonyms> synonymsB;
   public java.util.Collection<Synonyms> synonymsA;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Synonyms> getSynonymsB() {
      if (synonymsB == null)
         synonymsB = new java.util.HashSet<Synonyms>();
      return synonymsB;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSynonymsB() {
      if (synonymsB == null)
         synonymsB = new java.util.HashSet<Synonyms>();
      return synonymsB.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSynonymsB */
   public void setSynonymsB(java.util.Collection<Synonyms> newSynonymsB) {
      removeAllSynonymsB();
      for (java.util.Iterator iter = newSynonymsB.iterator(); iter.hasNext();)
         addSynonymsB((Synonyms)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSynonyms */
   public void addSynonymsB(Synonyms newSynonyms) {
      if (newSynonyms == null)
         return;
      if (this.synonymsB == null)
         this.synonymsB = new java.util.HashSet<Synonyms>();
      if (!this.synonymsB.contains(newSynonyms))
      {
         this.synonymsB.add(newSynonyms);
         newSynonyms.addSynonymsA(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSynonyms */
   public void removeSynonymsB(Synonyms oldSynonyms) {
      if (oldSynonyms == null)
         return;
      if (this.synonymsB != null)
         if (this.synonymsB.contains(oldSynonyms))
         {
            this.synonymsB.remove(oldSynonyms);
            oldSynonyms.removeSynonymsA(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSynonymsB() {
      if (synonymsB != null)
      {
         Synonyms oldSynonyms;
         for (java.util.Iterator iter = getIteratorSynonymsB(); iter.hasNext();)
         {
            oldSynonyms = (Synonyms)iter.next();
            iter.remove();
            oldSynonyms.removeSynonymsA(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Synonyms> getSynonymsA() {
      if (synonymsA == null)
         synonymsA = new java.util.HashSet<Synonyms>();
      return synonymsA;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSynonymsA() {
      if (synonymsA == null)
         synonymsA = new java.util.HashSet<Synonyms>();
      return synonymsA.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSynonymsA */
   public void setSynonymsA(java.util.Collection<Synonyms> newSynonymsA) {
      removeAllSynonymsA();
      for (java.util.Iterator iter = newSynonymsA.iterator(); iter.hasNext();)
         addSynonymsA((Synonyms)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSynonyms */
   public void addSynonymsA(Synonyms newSynonyms) {
      if (newSynonyms == null)
         return;
      if (this.synonymsA == null)
         this.synonymsA = new java.util.HashSet<Synonyms>();
      if (!this.synonymsA.contains(newSynonyms))
      {
         this.synonymsA.add(newSynonyms);
         newSynonyms.addSynonymsB(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSynonyms */
   public void removeSynonymsA(Synonyms oldSynonyms) {
      if (oldSynonyms == null)
         return;
      if (this.synonymsA != null)
         if (this.synonymsA.contains(oldSynonyms))
         {
            this.synonymsA.remove(oldSynonyms);
            oldSynonyms.removeSynonymsB(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSynonymsA() {
      if (synonymsA != null)
      {
         Synonyms oldSynonyms;
         for (java.util.Iterator iter = getIteratorSynonymsA(); iter.hasNext();)
         {
            oldSynonyms = (Synonyms)iter.next();
            iter.remove();
            oldSynonyms.removeSynonymsB(this);
         }
      }
   }

}