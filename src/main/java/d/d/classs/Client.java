package d.d.classs;


import lombok.val;

public class Client {
	public static void main(String[] args) throws Exception {
		Demo d = new Demo();
		d.setAge(1);
		Class c = d.getClass();
		Demo d1 = (Demo) c.newInstance();
		System.out.println(d1.getClass().getName());
		System.out.println(void.class.getName());
		System.out.println(d1.equals(d));

		System.out.println(Class.forName("d.d.classs.Demo").newInstance().equals(d));
	}
}
