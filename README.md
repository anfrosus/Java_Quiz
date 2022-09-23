# Java_Quiz

<h2>Q1.다음 코드를 실행하면 출력 결과로 5를 기대했는데 4가 출력되었습니다. 
어디에서 잘못 작성된 것일까요?</h1>
<div>
int var1=5;
int var2=2;
double var3=var1/var2;
int var4=(int)(var3*var2);
System.out.println(var4);

1. 우선 포인트는 데이터 타입인 것 같다.

2. 확인을 위해 각 변수의 어떤 수가 저장되어 있는지 출력해보자

        /*다음 코드를 실행하면 출력 결과로 5를 기대했는데 4가 출력되었습니다. 어디에서 잘못 작성된 것일까요?*/
        int var1=5;
        int var2=2;
        
        double var3=var1/var2;          
        
        int var4=(int)(var3*var2);              //(2.5 x 2) = 5
        
        System.out.println("var1 = " + var1);   //var1 = 5
        System.out.println("var2 = " + var2);   //var2 = 2
        System.out.println("var3 = " + var3);   //var3 = 2.0
        System.out.println("var4 = " + var4);   //var4 = 4

3. va1 과 var2는 문제가 없지만 var3이 우리가 기대했던 값과는 다르게 나왔다

4. var1과 var2가 정수형(int) 이기에 va1/var2 의 데이터는 2.5가 아닌 정수부분인 2만을 담고 있을 것이다.

5. 그래서 var3은 double 타입 임에도 2.0을 담게 된 것이다.
    (4, 5번을 통해서 데이터를 담을 때 '=' 을 기준으로
     오른쪽에 있는 표현식이 먼저 계산 된 후 왼쪽에 있는 변수에 할당된 다는 것을 알 수 있었다.)

6. 따라서 = 오른쪽에 있는 var1과 var2를 double타입으로 변환 후 계산해보자

7. 문제가 해결된 것 같다.

        /*다음 코드를 실행하면 출력 결과로 5를 기대했는데 4가 출력되었습니다. 어디에서 잘못 작성된 것일까요?*/
        int var1=5;
        int var2=2;

        double var3=(double)var1/(double)var2;

        int var4=(int)(var3*var2);              //(2.5 x 2) = 5

//        System.out.println("var1 = " + var1);   //var1 = 5
//        System.out.println("var2 = " + var2);   //var2 = 2
        System.out.println("var3 = " + var3);   //var3 = 2.5
        System.out.println("var4 = " + var4);   //var4 = 5


! 느낀점 !
 처음에는 var1/var2 자체를 묶어서 (double)(var1/var2)를 시도 했으나
 이는 자동으로 변환 된 상태였던 기존의 결과와 같았다.
 이번에는 각각 int -> (double)로 캐스팅 해주니 위와 같은 결과를 얻게 되었다.
 그 후에 double 과 int 를 나눈다면? 이라는 생각이들어 각각 하나씩만 캐스팅을 해주었는데
 같은 결과가 나왔고 이를 통해 표현식에서 하나 이상만 캐스팅 해주면 된다는 결론을 얻었다.
 
 <h2>Q2.다음 코드를 실행했을 때 출력 결과는 무엇입니까? (증감연산자에 대해 알아보세요!)</h2>

        /*다음 코드를 실행했을 때 출력 결과는 무엇입니까? (증감연산자에 대해 알아보세요!)*/
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);
        System.out.println(z);	//x -> 11
        System.out.println(x);	//y -> 19
        System.out.println(y);	//z -> 31

1. 우선 증감연산자가 있는 세번째 줄의 코드가 실행되고 나서 각각 어떤 값을 담고 있는지 확인해 보았다.

2. x는 1이 증가된 11, y는 1이 감소된 19 가 들어가 있었다.

3. 그런데 그 둘을 더한 값(z)은 30이 아닌 31이였다.

4. 문제의 세번째 코드를 보면 증감 연산자가 ++는 앞에 붙어있고 --는 뒤에 붙어있다.

5. 이 차이가 무엇인지 확인해보자

        int a = 1;
        System.out.println(a);      //a -> 1
        System.out.println(a++);    //a -> 1
        System.out.println(++a);    //a -> 3
        System.out.println(a);      //a -> 3

6. ++연산자는 1씩 증가해야하는데 a++는 똑같이 1을 출력하고 ++a는 2가 아닌 3을 출력한다.

7. 증감 연산자가 앞에 붙으면(++a) 1증가 한 a가 값이 되고
    뒤에 붙으면(a++) a를 기존의 값으로 사용 한 후 1 증가시킨다
    
8. 즉 '++a 는 1증가한 a', 'a++ 는 a 일단 쓰고나서 증가시킬게' 의 의미를 갖는다는 걸 알 수 있었다.


! 느낀점 !

  증감연산자가 쓰이는 for문을 생각해봤다.

   i for문은 ' i++' 일 때 0~4 까지 출력을 하니까
   '++j' 라면 1, 2, 3 과 같은 형태로 가지 않을까? 하고 생각했지만 결과는 둘다 0, 1, 2, 3, 4 를 출력했다.
  이유는 for문의 구조 때문인 것 같은데  / i를 넣고 사용하고 / ++j(사용), i++(사용)  / i를 넣고 사용하고 /
  의 구조를 가지고 있어 둘다 이미 증가된 상태로 다음 내용을 실행하는 것 같다(추측).

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        for (int j = 0; j < 5; ++j) {
            System.out.println(j);
        }


<h2>Q3.while문과 Math.random() 메소드를 이용해서 2개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고, 
눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성해보세요. 
눈의 합이 5가 되는 조합은 (1,4), (4,1), (2,3), (3,2)입니다.</h2>

1. Math.random() 메소드는 0.0 이상 1.0 미만의 난수를 반환한다고 한다.

2. 우리는 주사위를 던질 테니까 1~6을 사용 할 것이다.

3.(0~0.9999) 에 6을 곱하면 (0~5.999) 가 나온다. 여기에 1을 더해주면 (1~6.9999)의 난수가 나올것이다.
   그러나 우리는 정수 1~6 이 필요 하기 때문에 int로 형변환을 해주면 1~6 정수를 얻을 수 있다.
   이를 정리해 보면 다음과 같다.
   (int) Math.random() * (최댓값-최소값+1) + 최소값 으로 범위를 정할 수 있다.

4. 위의 값을 리턴해주는 dice()함수를 만들자.

5. 2개의 주사위 이므로 각각 의 난수를 주고 (1, 2) 와같은 형태로 출력하는 함수를 만들자.

6. 두 값을 더해 5인지 아닌지 를 조건으로 한 while문 사용하면 되겠다. -> 기약 없는 반복이기에 for문은 부적합한듯
    일단 한번 던지고 확인 해도 되므로 do-while문 사용해보자
        /*while문과 Math.random() 메소드를 이용해서 2개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고,
     * 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
     * 눈의 합이 5가 되는 조합은 (1,4), (4,1), (2,3), (3,2)입니다.*/

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

    //public static void main(String[] args) {
        doDice();
    //}
    
    7. 우선 주사위를 던지고 while문을 통해 (x+y가 5가 아닐 동안) 즉 5일 때 까지 위 위의 동작을 반복시켰다.
    
    
    ! 느낀점 !
  1) while 문 조건이 은근 직관적이지 않다. while( 조건 ){} '조건 = true일 동안 실행한다' 인데
     나에겐 좀 더 직관적인 if문과 반대되는 느낌이다.
     ex) while(true) {if (x+y == 5){break;}}      vs      while(x+y != 5){} 이런느낌?
  2) 최대한 함수를 만들며 구현해보려고 했는데 이게 구조 파악에 조금 도움이 됐다.
      작성 하고 나면 훨씬 직관적이고 깔끔한 것 같다.
  3) 처음에 Math.random()함수의 리턴 범위를 알고자 ctrl 클릭으로 random함수를 찾아들어가봤다.

    public static double random() {
    return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
}
아마 RandomNumberGeneratorHolder 클래스의 randomNumberGenerator 객체의 nextDouble() 메소드를 
가리키는 것 같은데 nextDouble()메소드를 또 찾아 들어가봤다.

public double nextDouble() {
    return (((long)(next(26)) << 27) + next(27)) * DOUBLE_UNIT;
}

//-> DOUBLE_UNIT
private static final double DOUBLE_UNIT = 0x1.0p-53; // 1.0 / (1L << 53)
이런 구조로 이루어저 있는데 이해 할 수가 없어서 검색을 통해 해결했다.
하여튼 0~9.99999999... 사이의 난수를 리턴해준단다!
