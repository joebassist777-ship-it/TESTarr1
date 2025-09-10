package lotto1;

// 로또 공 하나를 나타내는 클래스
public class Ball implements Comparable<Ball> {
    private int no; // 공 번호

    // 공 번호를 받아서 저장하는 생성자
    public Ball(int no) {
        this.no = no;
    }
    // 공 번호를 꺼내는 기능
    public int getNo() {
        return this.no;
    }
    // 공 번호를 비교해서 순서를 정하는 기능 (TreeSet에서 정렬할 때 사용)
    @Override
    public int compareTo(Ball o) {
        if (this.no > o.no) {
            return 1;  // 내가 더 크면 양수
        } else if (this.no < o.no) {
            return -1; // 내가 더 작으면 음수
        }
        return 0;      // 같으면 0
    }

    // 공을 출력할 때 번호만 보여주기
    @Override
    public String toString() {
        return String.valueOf(this.no);
    }

    // 같은 공인지 확인하는 기능 (기본 방식 그대로 사용)
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // 공의 고유값(해시값) (기본 방식 그대로 사용)
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
=============================================


package lotto1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 사용자가 직접 로또 번호 6개를 입력하는 클래스
public class LottPa {
    private Set<Ball> lottoSet; // 사용자가 입력한 번호 저장

    // TreeSet 사용 → 번호 자동 정렬 + 중복 제거
    public LottPa() {
        lottoSet = new TreeSet<Ball>();
    }

    // 사용자에게 번호를 입력받는 기능
    public void write() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================");

        // 번호가 6개 될 때까지 반복
        while (true) {
            System.out.printf("%d번째 번호? ", (lottoSet.size() + 1));
            int no = Integer.parseInt(scanner.nextLine());
            lottoSet.add(new Ball(no)); // 입력한 번호를 공 객체로 만들어 저장

            if (6 == lottoSet.size()) { // 6개 다 입력하면 종료
                break;
            }
        }

        scanner.close(); // 입력 도구 닫기
        System.out.println();
    }

    // 사용자가 입력한 번호 목록을 돌려주는 기능
    public Set<Ball> getLottoset() {
        return lottoSet;
    }
}
=====================================

package lotto1;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

// 컴퓨터가 로또 번호를 뽑고, 사용자 번호와 비교하는 클래스
public class LottoMac {
    private Set<Ball> lottoSet; // 컴퓨터가 뽑은 번호 저장

    // TreeSet 사용 → 번호 자동 정렬 + 중복 제거
    public LottoMac() {
        lottoSet = new TreeSet<Ball>();
    }

    // 1~45 사이에서 랜덤으로 6개 번호 뽑기
    public void initLotto() {
        Random rand = new Random();
        while (true) {
            int no = rand.nextInt(45) + 1; // 1~45 중 하나
            lottoSet.add(new Ball(no));    // 공 객체로 만들어 저장

            if (6 == lottoSet.size()) {    // 6개 다 뽑으면 종료
                break;
            }
        }
        System.out.println();
    }

    // 사용자 번호와 비교해서 맞춘 개수 세기
    public void atari(LottPa lp) {
        int atariCount = 0; // 맞춘 개수
        Set<Ball> userSet = lp.getLottoset(); // 사용자 번호 가져오기

        // 사용자 번호 하나씩 꺼내서 컴퓨터 번호에 있는지 확인
        Iterator<Ball> itr = userSet.iterator();
        while (itr.hasNext()) {
            Ball userBall = itr.next();
            if (lottoSet.contains(userBall)) {
                atariCount++; // 맞으면 개수 증가
            }
        }

        // 맞춘 개수 출력
        System.out.printf(" %d개 당첨 !!\n", atariCount);
        System.out.println();

        // 번호를 예쁘게 출력하는 방법 정의
        Consumer<Ball> ballPrinter = ball -> System.out.print(ball + " ");

        // 컴퓨터 번호 출력
        System.out.print("당첨 번호: ");
        lottoSet.forEach(ballPrinter);
        System.out.println();

        // 사용자 번호 출력
        System.out.print("입력 번호: ");
        userSet.forEach(ballPrinter);
        System.out.println();
    }

    // 컴퓨터 번호를 가져오는 기능
    public Set<Ball> getLottoSet() {
        return lottoSet;
    }
}
==============================================
package lotto1;

// 프로그램을 실행하는 클래스
public class Test {
    public static void main(String[] args) {
        LottoMac lm = new LottoMac(); // 컴퓨터 로또 기계 만들기
        lm.initLotto();               // 컴퓨터가 번호 6개 뽑기

        LottPa lp = new LottPa();     // 사용자 입력 도구 만들기
        lp.write();                   // 사용자 번호 입력받기

        lm.atari(lp);                 // 맞춘 개수와 번호 출력
    }
}





