/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.apache.shindig.social.opensocial.jpa;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

import org.apache.shindig.social.opensocial.jpa.api.DbObject;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;


/**
 * An application data map is the map of data for a single key within an application.
 */
@Entity
@Table(name="mdl_widgetspace_appdatas")
public class AppdataDb implements DbObject {
  /**
   * The object needs to be seializable (map).
   */
  private static final long serialVersionUID = 8017568825925047318L;

  public static final String FINDBY_ALL_GROUP = null;

  public static final String FINDBY_FRIENDS_GROUP = "select ad from AppdataDb ad where ad.personId in (select f.friend.id from PersonDb p, FriendDb f where p.objectId = f.person.objectId and ";

  public static final String FINDBY_GROUP_GROUP = null;

  public static final String FINDBY_SELF_GROUP = "select ad from AppdataDb ad where ";

  /**
   * The internal object ID used for references to this object. Should be generated by the
   * underlying storage mechanism
   */
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id")
  protected long id;

  @Basic
  @Column(name = "application_id")
  protected long applicationId;

  /**
   * A Application Data Map belongs to a set of maps associated with an application.
   * The link from Application to DataMap is not navigable since it may contain 1000's of entries.
   */
  // @ManyToOne(targetEntity=ApplicationDb.class)
  // @JoinColumn(name="application_id", referencedColumnName="oid")
  @Transient
  protected ApplicationDb application;

  @Basic
  @Column(name="context_id")
  protected long contextId;

  @Basic
  @Column(name="context_type")
  protected String contextType;
  
  @Basic
  @Column(name="name", length=255)
  protected String name;
  
  
  @Basic
  @Column(name="value", length=4096)
  protected String value;
  

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }
  
  /**
   * @return the id
   */
  public long getObjectId() {
    return id;
  }
  
  /**
   * @return the applicationId
   */
  public long getApplicationId() {
    return applicationId;
  }

  /**
   * @param applicationId to set
   */
  public void setApplicationId(long applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * @return the contextId
   */
  public long getContextId() {
    return contextId;
  }

  /**
   * @param contextId the contextId to set
   */
  public void setContextId(long contextId) {
    this.contextId = contextId;
  }
  
  /**
   * @return the contextType
   */
  public String getContextType() {
    return contextType;
  }

  /**
   * @param contextType the contextType to set
   */
  public void setContextType(String contextType) {
    this.contextType = contextType;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }
  

}
