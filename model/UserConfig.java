/***********************************************************************
 * Module:  UserConfig.java
 * Author:  ocq
 * Purpose: Defines the Class UserConfig
 ***********************************************************************/

package com.wangzhe.model;

import java.util.*;

/** 可以是任何配置，比如注册配置，发布配置，模版配置，采集配置.. */
public class UserConfig {
   public short ucId;
   public java.lang.String ucName;
   /** 注册配置、发布配置、换ip配置、还是邮件配置。。。 */
   public java.lang.String type;
   public java.lang.String data;

}