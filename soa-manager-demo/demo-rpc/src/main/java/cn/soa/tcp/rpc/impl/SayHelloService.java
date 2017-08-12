package cn.soa.tcp.rpc.impl;
/*
 * 基于Java的socketAPI进行一个简单的RPC调用,包括客户端和服务器的接口调用,服务的消费者与远端的提供方,基于TCP系诶实现
 */
public interface SayHelloService {
	public String sayHello(String helloArg);
}
