package com.gl.java.deepcopy;

public class Address{
 
    private String address;
 
    public Address(String address){
        this.address = address;
    }
 
    public String getAddress(){
        return address;
    }
 
    public void setAddress(String address){
        this.address = address;
    }
 
    @Override
    public Object clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}