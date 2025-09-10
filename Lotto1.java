package lotto1;

// 로또 공 하나를 나타내는 클래스
public class Ball implements Comparable<Ball> {
    private int no; // 공의 번호
    // 생성자: 공 번호를 받아서 초기화
    public Ball(int no) {this.no = no;}
    // 공 번호를 반환하는 메서드
    public int getNo() {return this.no;}
    // 공 비교: 번호 기준으로 정렬하기 위해 사용
    @Override
    public int compareTo(Ball o) {
        if (this.no > o.no) {return 1;
        } 
        else if (this.no < o.no) {return -1;}
            return 0;}
    // 공을 문자열로 출력할 때 번호만 보여줌
    @Override
    public String toString() {return String.valueOf(this.no);}
    // equals와 hashCode는 기본 Object 방식 사용 (중복 체크에 사용됨)
    public boolean equals(Object obj) {return super.equals(obj);}
    @Override
    public int hashCode() {return super.hashCode();}
}

=============================================


package lotto1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 사용자가 직접 로또 번호 6개를 입력하는 클래스
public class LottPa {
    private Set<Ball> lottoSet; // 사용자가 입력한 번호를 저장할 Set
    // 생성자: TreeSet으로 초기화 (중복 제거 + 자동 정렬)
    public LottPa() {lottoSet = new TreeSet<Ball>();}
    // 사용자에게 번호를 입력받는 메서드
    public void write() {Scanner scanner = new Scanner(System.in);
        System.out.println("=======================");
        // 6개의 번호를 입력받을 때까지 반복
        while (true) {
            System.out.printf("%d번째 번호? ", (lottoSet.size() + 1));
            int no = Integer.parseInt(scanner.nextLine());
            lottoSet.add(new Ball(no)); // 중복은 자동 제거됨
            if (6 == lottoSet.size()) {
                break;
            }
        }
        scanner.close(); // 입력 종료
        System.out.println(); // 줄 바꿈
    }
    // 사용자가 입력한 번호들을 반환
    public Set<Ball> getLottoset() {return lottoSet;}
}
=====================================

package lotto1;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

// 컴퓨터가 로또 번호를 생성하고, 사용자 번호와 비교하는 클래스
public class LottoMac {
    private Set<Ball> lottoSet; // 컴퓨터가 생성한 번호 저장
    // 생성자: TreeSet으로 초기화
    public LottoMac() {lottoSet = new TreeSet<Ball>();}
    // 랜덤으로 1~45 사이의 번호 6개 생성
    public void initLotto() {
        Random rand = new Random();
        while (true) {
            int no = rand.nextInt(45) + 1; // 1~45 사이 번호
            lottoSet.add(new Ball(no)); // 중복은 자동 제거됨
            if (6 == lottoSet.size()) {
                break;
            }
        }
        System.out.println(); // 줄 바꿈
    }
    // 사용자 번호와 컴퓨터 번호를 비교해서 당첨 개수 출력
    public void atari(LottPa lp) {
        int atariCount = 0;
        Set<Ball> userSet = lp.getLottoset(); // 사용자 번호 가져오기
        // 사용자 번호 하나씩 꺼내서 컴퓨터 번호에 포함되어 있는지 확인
        Iterator<Ball> itr = userSet.iterator();
        while (itr.hasNext()) {
            Ball userBall = itr.next();
            if (lottoSet.contains(userBall)) {
                atariCount++; // 맞은 번호 개수 증가
            }
        }

        // 당첨 결과 출력
        System.out.printf(" %d개 당첨 !!\n", atariCount);
        System.out.println();

        // 공 번호를 출력하는 함수형 인터페이스 정의
        Consumer<Ball> ballPrinter = ball -> System.out.print(ball + " ");

        // 컴퓨터가 뽑은 번호 출력
        System.out.print("당첨 번호: ");
        lottoSet.forEach(ballPrinter);
        System.out.println();

        // 사용자가 입력한 번호 출력
        System.out.print("입력 번호: ");
        userSet.forEach(ballPrinter);
        System.out.println();
    }

    // 컴퓨터 번호를 외부에서 가져올 수 있도록 getter 제공
    public Set<Ball> getLottoSet() {return lottoSet;}
}
==============================================
package lotto1;

// 프로그램을 실행하는 메인 클래스
public class Test {
    public static void main(String[] args) {
        LottoMac lm = new LottoMac(); // 컴퓨터 로또 객체 생성
        lm.initLotto(); // 컴퓨터가 번호 6개 생성

        LottPa lp = new LottPa(); // 사용자 입력 객체 생성
        lp.write(); // 사용자에게 번호 입력 받기

        lm.atari(lp); // 당첨 결과 비교 및 출력
    }
}






