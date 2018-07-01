package com.atguigu.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class BaseCatalog1 implements Serializable {

	    @Id
	    @Column
	    private String id;
	    @Column
	    private String name;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	    

}
