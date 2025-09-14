public static void main(String[] args) {
// 학생들의 점수를 저장한 배열 (-1은 오류, 0은 결석)
int [] scores = {90, 44, 112, -1 , 0 ,55};

// 점수 총합을 저장할 변수
int sum = 0;
// 유효한 점수(정상적인 점수)의 개수를 저장할 변수
int count = 0;

// 배열에 있는 점수를 하나씩 꺼내서 처리
for (int score : scores) {
    try {
        // 점수가 -1이면 오류로 간주하고 예외 발생시킴
        if (score == -1) {
            throw new IllegalArgumentException("오류 점수");
        }

        // 점수가 0이면 결석으로 간주하고 메시지만 출력한 후 다음 점수로 넘어감
        if (score == 0) {
            System.out.println("결석 처리 점수");
            continue; // 다음 반복으로 넘어감
        }

        // 점수가 100점을 초과하면 잘못된 점수로 간주하고 예외 발생시킴
        if (score > 100) {
            throw new IllegalArgumentException("100점초과");
        }

        // 위 조건에 해당하지 않으면 정상 점수로 간주하고 합계에 더하고 개수 증가
        sum += score;
        count++;
    } catch (IllegalArgumentException e) {
        // 예외가 발생했을 때 메시지를 출력
        System.out.println("예외 " + e.getMessage());
    } finally {
        // 예외가 있든 없든 무조건 실행되는 부분
        System.out.println("점수 " + score + " 처리 완료 \n");
    }
}

// 모든 점수 처리가 끝난 후 평균 계산
if (count > 0) {
    // 유효한 점수가 하나 이상 있을 경우 평균 계산
    double average = (double) sum / count;
    System.out.println("유효 점수 평균 " + average);
} else {
    // 유효한 점수가 하나도 없을 경우
    System.out.println("유효한 점수가 없다.");
}
