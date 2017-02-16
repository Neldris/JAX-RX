package com.rx.king;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/")
public class EntryPoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData(){
		String res = "hello data";
		Best b =  new Best();
		b.setAge(90);
		b.setName(res);
		Best1 b1 = Best1.getInstace();
		List<Best> lb = new ArrayList<>();
		lb.add(b);
		b1.setBest(lb);
		return Response.status(Status.OK).entity(b1).build();
	}

	@GET
	@Path("/{king}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showmore(@PathParam("king") String king){
		String res = "hello data "+king;
		Best1 b1 = Best1.getInstace();
		b1.setLooker(res);
		b1.setPoints(30.46d);
		return Response.status(Status.OK).entity(b1).build();
	}
}


@XmlRootElement
class Best{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

@XmlRootElement
class Best1{
   List<Best> best = new ArrayList<>();
   private Double points;
   private String looker;
   private Object obj;
   private static Best1 instance;
   private Best1(){}
   
 public synchronized static Best1  getInstace(){
	 if(instance == null){
		 instance = new Best1();
	 }
	 return instance;
 }
public List<Best> getBest() {
	return best;
}
public void setBest(List<Best> best) {
	this.best = best;
}
public Double getPoints() {
	return points;
}
public void setPoints(Double points) {
	this.points = points;
}
public String getLooker() {
	return looker;
}
public void setLooker(String looker) {
	this.looker = looker;
}
   
}





