package org.xy_poi.data;

import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table;

/**
 * Classe que representa um Point of Interest
 * @author carlos
 *
 */

@Entity
@Table(name="POI")
public class POI implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4181260500770137209L;

	@Id
	@Column(name="poi_id")
	private int m_id;
	
	@Column(name="x_value")
	private int m_x_value;
	
	@Column(name="y_value")
	private int m_y_value;
	
	@Column(name="name")
	private String m_name;
	
	public int getId() {
		return m_id;
	}

	public void setId(int m_id) {
		this.m_id = m_id;
	}

	public int getX() {
		return m_x_value;
	}
	
	public void setX(int m_x_value) {
		this.m_x_value = m_x_value;
	}
	
	public int getY() {
		return m_y_value;
	}
	
	public void setY(int m_y_value) {
		this.m_y_value = m_y_value;
	}
	
	public String getName() {
		return m_name;
	}
	
	public void setName(String m_name) {
		this.m_name = m_name;
	}
}
