package com.openu.menuapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 8944787938499211012L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Basic
	protected String uuid;
	
	@Basic
    @Temporal(TemporalType.TIMESTAMP)
	protected Date creationTime;
	
	@Basic
    @Temporal(TemporalType.TIMESTAMP)
	protected Date modificationTime;
	
	@Basic
	protected String createdBy;
	
	public BaseEntity()
	{
		this("");
	}

	public BaseEntity(String createdBy)
	{
		setCreationTime(new Date());
		setCreatedBy(createdBy);
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	private void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
		setModificationTime(creationTime);
	}

	/**
	 * @return the modificationTime
	 */
	public Date getModificationTime() {
		return modificationTime;
	}

	/**
	 * @param modificationTime the modificationTime to set
	 */
	protected void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	private void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity baseEntity = (BaseEntity) o;

        return uuid.equals(baseEntity.uuid);
    }

    @Override
    public int hashCode() {
        return 13 * uuid.hashCode();
    } 
}
