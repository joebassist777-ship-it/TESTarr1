package arr3;

public class A {
	int[] a; // 원본 배열
	int[] a1; // 정렬된 결과를 저장할 배열

	// 생성자: 외부에서 배열을 받아서 초기화
	A(int[] a) {
		this.a = a; 
		}

	void a() {
		a1= new int[a.length];
		for (int i = 0; i < a.length;i++) {
			a1[i]=a[i];
		}
		for (int i = 0; i < a1.length;) {
			if (9 == i + 1) {
				break;
			}
			if (a1[i] > a1[i + 1]) {
				int b = a1[i];
				a1[i] = a1[i + 1];
				a1[i + 1] = b;
				i = 0;
			} else {
				i++;
			}
		}
	}

	int[] getA1() {
		return this.a1;
	}
}
//        for (int i = 0; i < a.length; i++) {
//            for (int k = i + 1; k < a.length; k++) {
//                // 현재 값이 다음 값보다 크면 자리 바꾸기
//                if (a[i] > a[k]) {
//                    int J = a[i];   // 임시로 a[i] 저장
//                    a[i] = a[k];    // 작은 값을 앞으로 이동
//                    a[k] = J;       // 큰 값을 뒤로 이동
//                }
//            }
//        }
//a1 = a;

--------






package arr3;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 7, 3, 8, 9, 2, 5, 4, 1, 6 };
		A a = new A(arr);
		a.a();
		System.out.println(Arrays.toString(a.getA1()));
	}
}
//오름차순 앞자리 3
//배열정렬 오름내림차순




================================== 0901
	//오버로딩
B(){}
	B(int a){}
	B(String s){}
	// int b() {} 리턴타입은 안됀다. 
	void b() {}
	void b (int a) {}
	void b (String a) {}



 
//arr 세가지 종류

//static int [] c =new int [5];  //스테틱도 사용가능
	int [] c =new int [5]; //사이즈
	int [] c2 = new int[] {1,2,3,4,5};
	int [] c3={1,2,3,4,5};
//arr 세가지 종류
public static void main(String[] args) {
	System.out.println(c[5]);
					// (new Arr1().c[5]);
 
//여기서 C는 스테틱이 없으면 애러가 난다
}
}





package Cart;
public class Cart1 {
	private Item [] iteamArr;
	private int idx = 0;
	
	Cart1(int size){
		iteamArr=new Item[size];
	}
	public void put(Item item) {
		iteamArr[idx]= item;
	}
}




=======


package Cart;

public class Item {
	private String  name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

		
		
	
