package cn.soa.tcp.rpc.impl;

public class SayHelloServiceImpl implements SayHelloService{
	public String sayHello(String helloArg) {
		if(helloArg.equals("hello")){
			return "hello";
		}else{
			return "bye bye";
		}
	}
}
