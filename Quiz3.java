/*
 * Q3.while문과 Math.random() 메소드를 이용해서 2개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고,
 * 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
 * 눈의 합이 5가 되는 조합은 (1,4), (4,1), (2,3), (3,2)입니다.
 */
public class Quiz3 {
    //주사위 굴리는 함수
    static int dice() {
        return (int)(Math.random() * 6) + 1;
    }

    //합이 5가 될 때 까지 주사위 2개 던지는 함수
    static void doDice() {
        int x, y;

        do {
            x = dice();
            y = dice();
            System.out.println(x + "," + y);
        } while (x + y != 5);
    }
    public static void main(String[] args) {
        doDice();
    }
}
/**
 * 1. Math.random() 메소드는 0.0 이상 1.0 미만의 난수를 반환한다고 한다.
 * 2. 우리는 주사위를 던질 테니까 1~6을 사용 할 것이다.
 * 3. (0~0.9999) 에 6을 곱하면 (0~5.999) 가 나온다. 여기에 1을 더해주면 (1~6.9999)의 난수가 나올것이다.
 *    그러나 우리는 정수 1~6 이 필요 하기 때문에 int로 형변환을 해주면 1~6 정수를 얻을 수 있다.
 *    이를 정리해 보면 다음과 같다.
 *    (int) Math.random() * (최댓값-최소값+1) + 최소값 으로 범위를 정할 수 있다.
 * 4. 위의 값을 리턴해주는 dice()함수를 만들자.
 * 5. 2개의 주사위 이므로 각각 의 난수를 주고 (1, 2) 와같은 형태로 출력하는 함수를 만들자.
 * 6. 두 값을 더해 5인지 아닌지 를 조건으로 한 while문 사용하면 되겠다. -> 기약 없는 반복이기에 for문은 부적합한듯
 *    일단 한번 던지고 확인 해도 되므로 do-while문 사용해보자
 * 7. 우선 주사위를 던지고 while문을 통해 (x+y가 5가 아닐 동안) 즉 5일 때 까지 위 위의 동작을 반복시켰다.
 *
 *   ! 느낀점 !
 *   1) while 문 조건이 은근 직관적이지 않다. while( 조건 ){} '조건 = true일 동안 실행한다' 인데
 *      나에겐 좀 더 직관적인 if문과 반대되는 느낌이다.
 *      ex) while(true) {if (x+y == 5){break;}}      vs      while(x+y != 5){} 이런느낌?
 *   2) 최대한 함수를 만들며 구현해보려고 했는데 이게 구조 파악에 조금 도움이 됐다.
 *      작성 하고 나면 훨씬 직관적이고 깔끔한 것 같다.
 *   3) 처음에 Math.random()함수의 리턴 범위를 알고자 ctrl 클릭으로 random함수를 찾아들어가봤다.
 *          public static double random() {
 *              return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
 *          }
 *   4) 아마 RandomNumberGeneratorHolder 클래스의 randomNumberGenerator 객체의 nextDouble() 메소드를
 *      가리키는 것 같은데 nextDouble()메소드를 또 찾아 들어가봤다.
 *          public double nextDouble() {
 *              return (((long)(next(26)) << 27) + next(27)) * DOUBLE_UNIT;
 *          }
 *  //-> DOUBLE_UNIT
 *      private static final double DOUBLE_UNIT = 0x1.0p-53; // 1.0 / (1L << 53)
 *   5) 이런 구조로 이루어저 있는데 이해 할 수가 없어서 검색을 통해 해결했다.
 *      하여튼 0~9.99999999... 사이의 난수를 리턴해준단다!
 * */