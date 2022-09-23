/*
 * Q1.다음 코드를 실행하면 출력 결과로 5를 기대했는데 4가 출력되었습니다. 어디에서 잘못 작성된 것일까요?
 * int var1=5;
 * int var2=2;
 * double var3=var1/var2;
 * int var4=(int)(var3*var2);
 * System.out.println(var4);
 */
public class Quiz1 {
    public static void main(String[] args) {
        int var1=5;
        int var2=2;

        double var3=(double)var1/(double)var2;

        int var4=(int)(var3*var2);              //(2.5 x 2) = 5

        System.out.println("var1 = " + var1);   //var1 = 5
        System.out.println("var2 = " + var2);   //var2 = 2
        System.out.println("var3 = " + var3);   //var3 = 2.5
        System.out.println("var4 = " + var4);   //var4 = 5
    }
}

/**
 *1. 우선 포인트는 데이터 타입인 것 같다.
 *2. 확인을 위해 각 변수의 어떤 수가 저장되어 있는지 출력해보자
 *3. va1 과 var2는 문제가 없지만 var3이 우리가 기대했던 값과는 다르게 나왔다
 *4. var1과 var2가 정수형(int) 이기에 va1/var2 의 데이터는 2.5가 아닌 정수부분인 2만을 담고 있을 것이다.
 *5. 그래서 var3은 double 타입 임에도 2.0을 담게 된 것이다.
 *   (4, 5번을 통해서 데이터를 담을 때 '=' 을 기준으로
 *   오른쪽에 있는 표현식이 먼저 계산 된 후 왼쪽에 있는 변수에 할당된 다는 것을 알 수 있었다.)
 * 6. 따라서 = 오른쪽에 있는 var1과 var2를 double타입으로 변환 후 계산해보자
 * 7. 문제가 해결된 것 같다.
 *
 *  ! 느낀점 !
 *  처음에는 var1/var2 자체를 묶어서 (double)(var1/var2)를 시도 했으나
 *  이는 자동으로 변환 된 상태였던 기존의 결과와 같았다.
 *  이번에는 각각 int -> (double)로 캐스팅 해주니 위와 같은 결과를 얻게 되었다.
 *  그 후에 double 과 int 를 나눈다면? 이라는 생각이들어 각각 하나씩만 캐스팅을 해주었는데
 *  같은 결과가 나왔고 이를 통해 표현식에서 하나 이상만 캐스팅 해주면 된다는 결론을 얻었다.
 */
