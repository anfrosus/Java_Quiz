/*
 * Q2.다음 코드를 실행했을 때 출력 결과는 무엇입니까? (증감연산자에 대해 알아보세요!)
 */
public class Quiz2 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);
        System.out.println(z);    //x -> 11
        System.out.println(x);    //y -> 19
        System.out.println(y);    //z -> 31
    }
}
/**
 * 1. 우선 증감연산자가 있는 세번째 줄의 코드가 실행되고 나서 각각 어떤 값을 담고 있는지 확인해 보았다.
 * 2. x는 1이 증가된 11, y는 1이 감소된 19 가 들어가 있었다.
 * 3. 그런데 그 둘을 더한 값(z)은 30이 아닌 31이였다.
 * 4. 문제의 세번째 코드를 보면 증감 연산자가 ++는 앞에 붙어있고 --는 뒤에 붙어있다.
 * 5. 이 차이가 무엇인지 확인해보자
 *         int a = 1;
 *         System.out.println(a);      //a -> 1
 *         System.out.println(a++);    //a -> 1
 *         System.out.println(++a);    //a -> 3
 *         System.out.println(a);      //a -> 3
 * 6. ++연산자는 1씩 증가해야하는데 a++는 똑같이 1을 출력하고 ++a는 2가 아닌 3을 출력한다.
 * 7. 증감 연산자가 앞에 붙으면(++a) 1증가 한 a가 값이 되고
 *    뒤에 붙으면(a++) a를 기존의 값으로 사용 한 후 1 증가시킨다
 * 8. 즉 '++a 는 1증가한 a', 'a++ 는 a 일단 쓰고나서 증가시킬게' 의 의미를 갖는다는 걸 알 수 있었다.
 *
 *  ! 느낀점 !
 *  증감연산자가 쓰이는 for문을 생각해봤다.
 *  i for문은 ' i++' 일 때 0~4 까지 출력을 하니까
 *  '++j' 라면 1, 2, 3 과 같은 형태로 가지 않을까? 하고 생각했지만 결과는 둘다 0, 1, 2, 3, 4 를 출력했다.
 *  이유는 for문의 구조 때문인 것 같은데  / i를 넣고 사용하고 / ++j(사용), i++(사용)  / i를 넣고 사용하고 /
 *  의 구조를 가지고 있어 둘다 이미 증가된 상태로 다음 내용을 실행하는 것 같다(추측).
 *  public class Hello {
 *     public static void main(String[] args) {
 *         for (int i = 0; i < 5; i++) {
 *             System.out.println(i);
 *         }
 *         for (int j = 0; j < 5; ++j) {
 *             System.out.println(j);
 *         }
 *     }
 * }
 */