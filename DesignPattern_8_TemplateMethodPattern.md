# 템플릿 메소드 패턴

디자인 패턴이라고 하기도 뭐할정도로 객체지향 언어로 개발을 하다보면 무의식적으로 사용하는 패턴

- 특정 작업을 처리하는 일부분을 **서브 클래스로 캡슐화**하여 	-- 변화/확장이 필요한 부분
  전체적인 구조는 바꾸지 않으면서			  								 -- 추상 클래스에 구현된 것들은 공통적인 부분
  특정 단계에서 수행하는 내용을 바꾸는 패턴 							-- 서브 클래스에서 구현
- abstract 클래스에서 abstract 메소드를 이용해서 전체 흐름을 정의하고 
  구체적인 각 메소드의 구현은 하위 클래스에 위임하는 것



##### 이점

추상 클래스를 통해 메소드에 알고리즘의 골격을 정의해서 사용하는 "템플릿 메소드 패턴"은 여러 가지 이점 제공

소스코드 중복을 줄이기 위해 하위 클래스에서 빈번하고 공통적으로 나타나는 부분에 대해 별도의 추상 클래스를 정의(캡슐화)해서 사용하는 것이 핵심!!!

- 코드 중복 ↓
- 자식 클래스의 역할을 줄여 핵심 로직 관리가 용이
- 확장 용이하게 만들어줌
  - 변화/확장 등 필요한 부분(달라지는 부분)만 서브 클래스에서 구현할 수 있도록 함
  - 전체적으로 동일한/변하지 않는 알고리즘은 상위 클래스에서 구현

##### 단점

- 추상 메소드가 많아지면서 클래스 관리가 복잡해질 수 있음
  - 알고리즘 단계를 적절히 나누고,
    필요하지 않은 부분은 Hook로 구현하면 부담이 줄어든다고 함
- 클래스 간 관계와 코드가 꼬일 염려



##### 코드

커피

```java
public class Coffee {
    void prepareRecipe() {
    	boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }
    
    public void boidWater() { System.out.println("물 끓이는 중"); }					//
    public void brewCoffeeGrinds() { System.out.println("커피 우려내는 중"); }
    public void pourInCup() { System.out.println("컵에 따르는 중"); }				   //
    public void addSugarAndMilk() { System.out.println("설탕과 우유를 추가하는 중"); }
}
```

차

```java
public class Tea {
    void prepareRecipe() {
    	boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    
    public void boidWater() { System.out.println("물 끓이는 중"); }					//
    public void steepTeaBag() { System.out.println("차를 우려내는 중"); }
    public void pourInCup() { System.out.println("컵에 따르는 중"); }				   //
    public void addLemon() { System.out.println("레몬을 추가하는 중"); }
}
```

공통/중복 부분이 있네? 추상화해보자!

```java
public abstract class CaffeineBeverage {
    //음료 만드는 과정을 변경할 수 없게 final로 선언
    final void prepareRecipe() {
    	boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    
    //커피와 차가 다른 방식으로 처리하기 때문에 추상 메소드로 선언 (서브클래스에서 정의)
    abstract void brew();
    abstract void addCondiments();
    
    //커피와 차 둘 다 동일한 부분이기 때문에 여기서 정의
    void boidWater() { System.out.println("물 끓이는 중"); }
    void pourInCup() { System.out.println("컵에 따르는 중"); }
}
```

- 서브 클래스에서 알고리즘의 특정 단계를 제공해야 할 때? 즉, 변화하는 부분에 **추상메서드**!

- 알고리즘의 특정 부분에서 선택적으로 적용되는 경우가 있다면? → **후크** 사용(아래)

- 커피

  ```java
  public class Coffe extends CaffeineBeverage {
      @Override
      void brew() { System.out.println("커피 우려내는 중"); }
      @Override
      void addCondiments() { System.out.println("설탕과 우유를 추가하는 중"); }
  }
  ```

- 차

  ```java
  public class Tea extends CaffeineBeverage {
      @Override
      void brew() { System.out.println("차 우려내는 중"); }
      @Override
      void addCondiments() { System.out.println("레몬을 추가하는 중"); }
  }
  ```

- `prepareRecipe()`가 템플릿 메소드 (어떤 알고리즘에 대한 틀 역할!!)



##### 후크(Hook)

- 추상클래스에서 선언되는 메소드지만 기본적인 내용만 구현 or 아무 코드도 들어있지 않은 메소드
- 서브클래스 입장에선 다양한 위치에서 알고리즘에 끼어들 수 있음
  - 알고리즘에서는 필수적이지 않은 부분
  - 진행되는 작업에 대한 결정을 내리는 기능 (서브 클래스에서도 결정 가능!)

```java
// 위의 CaffeineBeverage에서 해당 부분이 추가되었고 다른 것들은 다 똑같다!
public abstract class CaffeineBeverageWithHook {
    final void prepareRecipe() {
        ...
        if(customerWantsCondiments()){
        	addCondiments();
        }
    }
    
    ...
        
    boolean customerWantsCondiments(){
    	return true;
    } 
}
```

- 여기에서 `customerWantsCondiments()` 메소드가 바로 Hook!

  - 이 메소드는 서브 클래스에서 필요에 따라 오버라이드할 수 있다!

  - ex.

    ```java
    public class CoffeWithHook extends CaffeineBeverageWithHook {
        @Override
        void brew() { System.out.println("커피 우려내는 중"); }
        @Override
        void addCondiments() { System.out.println("설탕과 우유를 추가하는 중"); }
        @Override
        boolean customerWantsCondiments() {
            /* 
            	어떤 조건에 따라 true or false로 return할 수 있는
            	로직을 추가하여 오버라이딩 가능!
            */
        }
    }
    ```

    

##### 헐리우드 원칙

> "(저수준아,) 먼저 연락하지 마세요. 저희(고수준)가 연락 드리겠습니다."

- 의존성 부패(dependency rot)를 방지할 수 있음
  - 의존성 부패?
    어떤 고수준 구성요소가 저수준 구성요소에 의존하고, 
    그 저수준 구성요소는 다시 고수준 구성요소에 의존하고, 
    그 고수준 구성요소는 다시 또 다른 구성요소에 의존하고... 복잡하게 꼬여 있음
- 헐리우드 원칙을 사용하면, 
  저수준 구성요소에서 시스템에 접속을 할수는 있지만, 
  언제 어떤 식으로 그 구성요소들을 사용할지는 **고수준 구성요소에서 결정**하게 된다.
- 적용
  - `CaffeineBeverage`는 고수준 구성요소
    - 음료를 만드는 방법에 대당하는 알고리즘을 장악하고 있음
    - 메소드 구현이 필요한 상태에서만 서브클래스를 불러냄
  - `Coffee`와 `Tea`(서브클래스)는 저수준 구성요소
    - 각각의 자질구레한 메소드 구현을 제공하기 위한 용도로만 사용됨
    - 고수준 구성요소인 `CaffeineBeverage` 클래스로부터 호출 당하기 전까지는 
      절대로 `CaffeineBeverage` 추상 클래스를 직접 호출하지 않음
  - `CaffeineBeverage` 클래스의 클라이언트에서는
    Tea, Coffe 같은 구상 클래스가 아닌 `CaffeineBeverage`에 추상화되어 있는 부분에 의존!
- **의존성 역전**과는 하나의 목표를 공유함 : **분리**
  - 구상 클래스 사용 ↓, 대신 추상화시켜 그것을 사용
  - 차이점 & 헐리웃 원칙 이해 쉽게 할 수 있는 예시 필요 + 코드 짜봐야
  - **https://johngrib.github.io/wiki/hollywood-principle/ 읽어보자**
    - 의존성보다는 **제어의 역전** 개념
    - **Interface에서 어디에 있는 boil을 호출할지, 어디에 있는 brew를 호출할지 정하는 것!**
      **하위 클래스에서 결정되는 것이 아니다!!**







참고 블로그

- https://gmlwjd9405.github.io/2018/07/13/template-method-pattern.html : 예시가 좋음
  - 엘리베이터 예시 (모터가 다른 상황)
- https://coding-factory.tistory.com/712
  - 선생님 예시 (하는 일은 똑같고, 과목만 다르다는 가정 하에)
- https://jusungpark.tistory.com/24
  - Hook 쉽게!
- https://bb-dochi.tistory.com/81