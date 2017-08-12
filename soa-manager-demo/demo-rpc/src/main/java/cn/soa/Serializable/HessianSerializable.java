package cn.soa.Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import cn.soa.entity.Person;
import cn.soa.entity.zhansan;
/*
 * Hession的序列化的反序列化实现
 */
public class HessianSerializable {
	public static void main(String[] args) throws Exception {
		//定义一个字节数组输出流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//对象输出流
		HessianOutput out = new HessianOutput(os);
		//将对象写入到字节数组输出, 进行序列化
		out.writeObject(new zhansan(18,"北京"));
		byte[] zhangsanByte = os.toByteArray();
		
		//字节数组输入流
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		//执行反序列化,从流中读取对象
		HessianInput in = new HessianInput(is);
		
		Person person = (Person) in.readObject();
		System.out.println(person);
	}
}
