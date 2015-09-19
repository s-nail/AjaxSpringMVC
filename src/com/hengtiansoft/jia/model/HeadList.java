package com.hengtiansoft.jia.model;

import java.util.ArrayList;
import java.util.List;

public class HeadList<T> extends Head {

	List<T> data =new ArrayList<T>();
	public HeadList(){
		
	}
	public HeadList(List<T> data){
		this.data=data;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
