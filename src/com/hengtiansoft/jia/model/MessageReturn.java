package com.hengtiansoft.jia.model;

public class MessageReturn<T> {
	T result = null;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	public MessageReturn(){
		
	}
	public MessageReturn(T result){
		this.result=result;
	}
}
