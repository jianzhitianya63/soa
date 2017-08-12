package cn.soa.Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import cn.soa.entity.Person;
import cn.soa.entity.zhansan;

/*
 * 以下是Java内置的序列化方式所实现的对象序列化和反序列化的关键代码: 
 * Hessian服务框架框架底层所使用
 * 序列化性能排名  1,json/fiexjson/databind
 * 			2,java-built-in
 * 			3,xml
 * 			7,hessian
 */
public class RpcSerializable {
	@Test
	public void rpcSerializable() throws Exception{
		//定义一个字节数组输出流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//对象输出流
		ObjectOutputStream out = new ObjectOutputStream(os);
		//将对象写入到字节数组输出, 进行序列化
		out.writeObject(new zhansan(18,"北京"));
		byte[] zhangsanByte = os.toByteArray();
		
		//字节数组输入流
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		//执行反序列化,从流中读取对象
		ObjectInputStream in = new ObjectInputStream(is);
		
		Person person = (Person) in.readObject();
		System.out.println(person);
	}
}
