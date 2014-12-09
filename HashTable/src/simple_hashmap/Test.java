package simple_hashmap;

public class Test {
	public static void main(String[] args) {
		HashMap map = new HashMap(10);
		System.out.println(map.get(1));
		map.put(1, 11);
		System.out.println(map.get(1));
		map.put(1, 111);
		System.out.println(map.get(1));
		map.put(11, 1111);
		System.out.println(map.get(11));
		System.out.println(map.remove(11));
		
		System.out.println(map.get(1));
		
		System.out.println();
		
		HashMap1 map1 = new HashMap1(10);
		System.out.println(map1.get(1));
		map1.put(1, 11);
		System.out.println(map1.get(1));
		map1.put(1, 111);
		System.out.println(map1.get(1));
		map1.put(11, 1111);
		System.out.println(map1.get(11));
		System.out.println(map1.remove(11));
		
		System.out.println(map1.get(1));
	}
}
