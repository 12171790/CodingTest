# CodingTest
This is an auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).

수수행 시간을 고려할 때 1초에 약 2천만번 정도의 연산을 수행할 수 있다고 가정하자.

코딩 테스트 문제에서 시간 제한은 통상 1~5초 가량임.

<aside>
💡

문제 해결 과정

1. 지문 읽기 및 컴퓨터적 사고
2. 요구사항(복잡도) 분석
3. 문제 해결을 위한 아이디어 찾기 ⇒ 바로 코딩하지 말고 분석을 해보는 것이 중요
4. 소스코드 설계 및 코딩
</aside>

# 🥊 요구사항 확인

문제에서 가장 먼저 확인할 것은 시간 제한이다. 데이터의 개수 N의 범위가 주어지기 때문에 데이터의 조건을 확인하고, 수행 시간 조건을 확인한 후 알고리즘을 선택하자.

예를 들어 시간 제한이 1초인 문제의 경우

1. N의 범위가 500인 경우 : 시간 복잡도가 O(N^3)인 알고리즘을 설계하면 문제를 풀 수 있다.
2. N의 범위가 2,000인 경우 : 시간 복잡도가 O(N^2)인 알고리즘을 설계하면 문제를 풀 수 있다.
3. N의 범위가 100,000인 경우 : 시간 복잡도가 O(NlogN)인 알고리즘을 설게하면 문제를 풀 수 있다.

## ✨ 수행 시간 측정

```python
import time
start_time = time.time() #측정 시작

#프로그램 소스코드

end_time = time.time() #측정 종료
print("time : ", end_time - start_time) #수행 시간 출력
```

# 💡 자료형

- 모든 프로그래밍은 결국 데이터를 다루는 행위이므로 자료형에 대한 이해가 필요.

1. 정수형

```python
a = 1000
print(a)

a = -7
print(a)

a = 0
print(a)
```

1. 실수형

```python
a = 5.4
print(a)

# 0.7
a = .7
print(a)

# 5.0
a = 5.
print(a)

# -0.92
a = -.92
print(a)
```

💡 지수 표현 방식

- 파이썬에서는 e나 E를 이용한 지수 표현 방식을 이용할 수 있다. e나 E 다음에 오는 수는 10의 지수부를 의미.
- 예를 들어 1e9라고 입력하게 되면 10의 9 제곱을 의미하게 된다. 단, 지수 표현 방식은 실수형 데이터로 처리된다. 보통 임의의 큰 수를 표현하기 위해 사용한다. 예를 들어 최단 경로 알고리즘에서 도달할 수 없는 노드에 대하여 최단 거리를 무한으로 설정하곤 하는데, 이때 가능한 최댓값이 10억 미만이라면 무한의 값으로 1e9를 사용할 수 있다.

```python
a = 1e9
print(a)

# 752.5
a = 75.25e1
print(a)

#3.954
a = 3954e-3
print(a)

# 실수형 데이터를 정수형 데이터로 변환
a = int(1e9)
print(a)
```

💡 실수형 더 알아보기

- 실수형을 저장하기 위해 4바이트, 8바이트 등 고정된 크기의 메모리를 할당하므로, 컴퓨터 시스템은 실수 정보를 표현하는 정확도에 한계를 갖는다.
- 10진수에서는 0.3 + 0.6 = 0.9를 정확하게 표현할 수 있지만, 2진수에서는 0.9를 정확히 표현할 방법이 없다. 이에 따라 미세한 오차가 발생할 수 있다.
- 실수값 비교를 위해 round() 함수를 사용.
- round(123.456, 2) = 123.46이 됨.

```python
a = 0.3 + 0.6
#0.899999999999
print(a)

if a == 0.9:
	print(True)
else:
	print(False)
	
#False

a = 0.3 + 0.6
print(round(a, 3))

if round(a, 3) == 0.9:
	print(True)
else:
	print(False)
	
#True
```

💡 수 자료형 연산

- 나누기 연산자(/)를 사용할 때 파이썬은 나눠진 결과를 실수형으로 반환한다. 파이썬에서는 몫을 얻기 위해 몫 연산자(//)를 사용한다

```python
#3.3333333
a = 10 / 3
print(a)

#3
a = 10 // 3
print(a)

#125 (거듭 제곱)
a = 5 ** 3
print(a)

#제곱근
a = 5 ** 0.5
print(a)
```

# 💡리스트

- 여러 개의 데이터를 연속적으로 담아 처리하기 위해 사용하는 자료형. C나 자바에서의 Array의 기능 및 연결 리스트와 유사한 기능을 지원.
- vector와 기능적으로 유사하다. 리스트 대신에 배열 혹은 테이블이라고도 부름.
- 대괄호 안에 원소를 넣어 초기화하며, 쉼표로 원소를 구분.
- 비어 있는 리스트를 선언하고자 할 때는 list() 혹은 간단히 []을 사용.
- 인덱스 값을 입력하여 리스트의 특정한 원소에 접근하는 것을 인덱싱이라고 함. 인덱스 값은 양의 정수와 음의 정수 둘 다 사용 가능.

```python
a = [1, 2, 3, 4, 5, 6, 7]
print(a)

# 4번째 원소 4 출력
print(a[3])

# 0이 10개 출력됨.
n = 10
a = [0] * n
print(a)

a = [1, 2, 3, 4, 5, 6, 7]

# 뒤에서 첫번째 원소 출력 7
print(a[-1)

# 뒤에서 세번째 원소 출력 5
print(a[-3])
```

- 리스트에서 연속적인 위치를 갖는 원소들을 가져와야 할 때는 슬라이싱을 이용
    - 대괄호 안에 콜론을 넣어서 시작 인덱스와 끝 인덱스를 설정. 끝 인덱스는 실제 인덱스보다 1 더 크게 설정해야 함.

```python
a = [1, 2, 3, 4, 5, 6, 7]

# 2, 3, 4
print(a[1:4])

# 3, 4, 5, 6
print(a[2:-1])
```

- 리스트 컴프리헨션 : 리스트를 초기화하는 방법 중 하나
    - 대괄호 안에 조건문과 반복문을 적용하여 리스트를 초기화.
    - 2차원 리스트를 초기화할 때 효과적으로 사용됨.
    - 특히 NxM 크기의 2차원 리스트를 한 번에 초기화 해야 할 때 매우 유용하다

```python
array = [i for i in range(10)]

# 0부터 9까지의 수를 포함하는 리스트
print(array)

array = [i for i in range(20) if i % 2 == 1]

# 0~19까지의 수 중에서 홀수만 포함하는 리스트
print(array)

array = [i * i for i in range(1, 10)]

# 1~9까지의 수들의 제곱 값을 포함하는 리스트
print(array)

n = 5
m = 7
# 2차원 리스트 초기화
# 반복을 수행하되 반복을 위한 변수의 값을 무시하고자 할 때 언더바를 사용
array = [[0] * m for _ in range(n)]
print(array)

# 잘못된 예시. 파이썬에서는 리스트를 생성할 때 객체로 생성. 근데 이것에 대해 n을 곱하면, n번
# 만큼 참조값을 복사하는 것과 동일. [0] * m 이라는 객체를 n번 나열하는 것. 원소 1개만 바꿔도
# n개의 원소가 모두 바뀌게 된다.
array = [[0] * m] * n
print(array)
```

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/31b3a542-8874-4476-bec1-3253a9474a08/cb4e7397-a406-4e2d-86ad-a94f34b07e28/image.png)

```python
a = [1, 4, 3]
print(a)

a.append(2)
print("삽입", a)

a.sort()
print("오름차순 정렬", a)

a.sort(reverse = True)
print("내림차순 정렬", a)

a = [4, 3, 2, 1]

a.reverse()
print("원소 뒤집기", a)
# 1, 2, 3, 4

a.insert(2, 55)
print("원소 삽입", a)
# 1, 2, 55, 3, 4

print("값이 3인 데이터 개수", a.count(3))

a.remove(2)
print("2인 데이터 삭제", a)

a = [1, 2, 3, 4, 5, 5, 5]
remove_set = {3, 5} # 집합 자료형

# remove_list에 포함되지 않은 값만을 저장
result = [i for i in a if i not in remove_set]
print(result) # 1, 2, 4
```
# 💡 문자열

- 문자열 변수를 초기화할 때는 큰 따옴표나 작은 따옴표를 이용
- 문자열 안에 큰 따옴표나 작은 따옴표가 포함되어야 하는 경우
    - 전체 문자열을 큰 따옴표로 구성하면 내부적으로 작은 따옴표를 포함할 수 있다.
    - 전체 문자열을 작은 따옴표로 구성하면 내부적으로 큰 따옴표를 포함할 수 있다.
    - 혹은 백 슬래시(\)를 사용하면, 큰 따옴표나 작은 따옴표를 원하는 만큼 포함 시킬 수 있다.

```python
data = 'Hello World'
print(data)

data = "Don't you know \'Python\'?"
print(data)
```

- 문자열 변수에 덧셈을 이용하면 문자열이 더해져서 연결됨.
- 문자열 변수를 특정한 양의 정수와 곱하는 경우, 문자열이 그 값만큼 여러 번 더해짐
- 문자열에 대해서도 마찬가지로 인덱싱과 슬라이싱을 이용할 수 있다.
    - 다만 문자열은 특정 인덱스의 값을 변경할 수 없음!!

```python
a = "Hello"
b = "World"
print(a + " " + b)
print(a + b)

a = "String"
print(a * 3)

a = "ABCDEF"
print(a[2:4])
```

# 💡 튜플

- 리스트와 유사하지만 문법적 차이가 있다.
    - 튜플은 **한 번 선언된 값을 변경할 수 없다.**
    - 리스트는 대괄호를 이용. 튜플은 소괄호를 이용
- 튜플은 리스트에 비해 상대적으로 공간 효율적임.

```python
a = (1, 2, 3, 4, 5, 6, 7, 8)

# 4
print(a[3])

# 2, 3, 4
print(a[1:4])
```

## 😎 튜플을 사용하면 좋은 경우

- 서로 다른 성질의 데이터를 묶어서 관리해야 할 때
    - 최단 경로 알고리즘에서는 (비용, 노드 번호)의 형태로 튜플 자료형을 자주 사용함.
- 데이터의 나열을 해싱의 키 값으로 사용해야 할 때
    - 튜플은 변경이 불가능하므로 리스트와 다르게 키 값으로 사용될 수 있다.
- 리스트보다 메모리를 효율적으로 사용해야 할 때

# 💡 사전 자료형

- 사전 자료형은 키(key)와 값(value)의 쌍을 데이터로 가지는 자료형.
    - 앞서 다루었던 리스트나 튜플이 값을 순차적으로 저장하는 것과는 대비됨
- 사전 자료형은 키와 값의 싸을 데이터로 가지며, 원하는 **“변경 불가능한 자료형”**을 키로 사용할 수 있다.
- 파이썬의 사전 자료형은 해시 테이블을 이용하므로 데이터의 조회 및 수정에 있어서 O(1)의 시간에 처리 가능

```python
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

print(data)

# 데이터를 조회하는데 상수 시간이 걸림.
if '사과' in data:
	print('사과 데이터가 존재합니다.')
```

- 사전 자료형에서는 키와 값을 별도로 뽑아내기 위한 메서드를 지원
    - 키 데이터만 뽑아서 리스트로 이용할 때는 keys() 함수를 이용.
    - 값 데이터만 뽑아서 리스트로 이용할 때는 values() 함수를 이용.

```python
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

# 키 데이터만 담은 리스트.
# 실제 반환되는 데이터는 객체 형태라서 리스트로 형 변환이 필요하다
key_list = list(data.keys())
# 값 데이터만 담은 리스트
value_list = data.values()

print(key_list)
print(value_list)

for key in key_list:
	print(data[key])
```

# 💡 집합 자료형

- 집합은 다음과 같은 특징이 있다.
    - 중복을 허용하지 않음.
    - 순서가 없음.
- 집합은 리스트 혹은 문자열을 이용해서 초기화할 수 있다.
    - 이때 set() 함수를 이용.
- 혹은 중괄호 안에 각 원소를 콤마(,)를 기준으로 구분하여 삽입함으로써 초기화.
- 데이터의 조회 및 수정에 있어서 O(1)의 시간에 처리 가능.

```python
# 초기화
data = set([1, 1, 2, 2, 3, 4, 5])
print(data)

# 초기화
data = {1, 1, 2, 2, 3, 4, 5}
print(data)

# 중복된 값이 제거되어 {1, 2, 3, 4, 5}가 출력됨.
```

## 😎 집합 자료형의 연산

- 기본적인 집합 연산으로 합집합, 교집합, 차집합 연산 등이 있다.
    - 합집합 : 집합 A에 속하거나 B에 속하는 원소로 이루어진 집합
    - 교집합 : 집합 A에도 속하고, B에도 속하는 원소로 이루어진 집합
    - 차집합 : 집합 A의 원소 중에서 B에 속하지 않는 원소들로 이루어진 집합

```python
a = set([1, 2, 3, 4, 5])
b = set([3, 4, 5, 6, 7])

#합집합
# 1, 2, 3, 4, 5, 6, 7
print(a | b)

#교집합
# 3, 4, 5
print(a & b)

#차집합
# 1, 2
print(a - b)

# 새로운 원소 추가
a.add(9)
print(a)

# 새로운 원소 여러 개 추가
a.update([6, 7])
print(a)

# 특정한 값을 갖는 원소 삭제
a.remove(2)
print(a)
```

## 🐱‍🏍 사전 자료형과 집합 자료형의 특징

- 리스트나 튜플은 순서가 있기 때문에 인덱싱을 통해 자료형의 값을 얻을 수 있음.
- 사전 자료형과 집합 자료형은 순서가 없기 때문에 인덱싱으로 값을 얻을 수 없음.
    - 사전의 키 혹은 집합의 원소를 이용해 O(1)의 시간 복잡도로 조회함.
    - 키나 원소의 값으로는 문자열이나 튜플 같이 변경 불가능한 자료형을 사용해야 함.

# 💡 기본 입출력

- 모든 프로그램은 약속된 입출력 양식을 가지고 있다.
- 프로그램 동작의 첫 단계는 데이터를 입력 받거나 생성하는 것.

## 🥊 자주 사용되는 표준 입력 방법

- input() 함수는 한 줄의 문자열을 입력 받는 함수.
- map() 함수는 리스트의 모든 원소에 각각 특정한 함수를 적용할 때 사용.
- 예) 공백을 기준으로 구분된 데이터를 입력 받을 때
    - list(map(int, input().split()))
    - input으로 입력을 받고, split으로 공백을 기준으로 나눈 후, int형으로 변환하여 리스트로 바꿈.
- 예) 공백을 기준으로 구분된 데이터의 개수가 많지 않을 경우
    - a, b, c = map(int, input().split))
    - a, b, c에 차례대로 값이 들어감

```python
# 데이터의 개수 입력
n = int(input())

# 입력한 값이 하나의 문자열로 저장됨
# 78 27 35
data = input()

# 입력한 값 공백을 기준으로 문자로 저장됨
# ['78', '27', '35']
data = input().split()

# 각 데이터를 공백을 기준으로 구분하여 입력
# [78, 27, 35]
data = list(map(int, input().split()))

data.sort(reverse=True)
print(data)
```

## 😎 빠르게 입력 받기

- 사용자로부터 입력을 최대한 빠르게 받아야 하는 경우
- 파이썬의 경우 sys 라이브러리에 정의되어 있는 sys.stdin.readline() 메서드를 이용.
    - 단, 입력 후 엔터가 줄 바꿈 기호로 입력되므로 rstrip() 메서드를 함께 사용함.
- 실제로 이진 탐색, 정렬, 그래프 관련 문제에서 입력의 양이 많을 경우 자주 사용됨.

```python
import sys

# 문자열 입력 받기
data = sys.stdin.readline().rstrip()
print(data)
```

## 🥊 자주 사용되는 표준 출력 방법

- 파이썬에서 기본 출력은 print() 함수를 이용.
    - 각 변수를 콤마(,)를 이용하여 띄어쓰기로 구분하여 출력할 수 있다.
- print()는 기본적으로 출력 이후에 줄 바꿈을 수행함.
    - 줄 바꿈을 원치 않을 경우 ‘end’ 속성을 이용.

```python
a = 1
b = 2
print(a, b)
print(7, end=" ")
print(8, end="하하")

answer = 7
print("정답은 " + str(answer) + "입니다.")
print(f"정답은 {answer}입니다.")
```
# 💡 조건문

- 조건문은 프로그램의 흐름을 제어하는 문법
- 조건문을 이용해 조건에 따라서 프로그램의 로직을 설정할 수 있다.

```python
x = 15

if x >= 10:
	print("x >= 10")
	
if x >= 0:
	print("x >= 0")

if x >= 30:
	print("x >= 30")
```

### 🐱‍🏍 들여쓰기

- 파이썬에서는 코드의 블록을 들여쓰기로 지정한다.
- 파이썬 스타일 가이드 라인에서는 4개의 공백 문자를 사용하는 것을 표준으로 설정하고 있다.

### 💪 조건문의 기본 형태

- 조건문의 기본적인 형태는 if ~elif ~else이다.

```python
if 조건문 1:
    조건문 1이 True일 때 실행되는 코드
elif 조건문 2:
    조건문 1에 해당하지 않고, 조건문 2가 True일 때 실행되는 코드
else:
    위의 모든 조건문이 모두 True 값이 아닐 때 실행되는 코드
```

```python
score = 85

if score >= 90:
    print("학점 : A")
elif score >= 80:
    print("학점 : B")
elif score >= 70:
    print("학점 : C")
else:
    print("학점 : D")
```

### 🎃 논리 연산자

| 논리 연산자 | 설명 |
| --- | --- |
| X and Y | X와 Y가 모두 참일 때 참이다. |
| X or Y | X 혹은 Y 중 하나만 참이어도 참이다. |
| not X | X가 거짓일 때 참이다. |

### 🎶 기타 연산자

- 다수의 데이터를 담는 자료형을 위해 in 연산자와 not in 연산자가 제공된다.
    - 리스트, 튜플, 문자열, 딕셔너리 모두에서 사용 가능.

| in 연산자와 not in 연산자 | 설명 |
| --- | --- |
| x in 리스트 | 리스트 안에 x가 들어 있을 때 참이다. |
| x not in 문자열 | 문자열 안에 x가 들어가 있지 않을 때 참이다. |

### 🐱‍💻pass 키워드

- 아무것도 처리하고 싶지 않을 때 pass 키워드를 사용

```python
score = 85

if score >= 85:
    pass # 나중에 작성할 소스코드
else:
    print("성적이 85점 미만입니다.")

print("프로그램을 종료합니다")
```

### ✌ 조건문 간소화

- 실행될 소스코드가 한 줄인 경우, 줄바꿈을 하지 않아도 됨.

```python
score = 85

if score >= 80: result = "success"
else: result = "fail"
```

- 조건부 표현식은 if~else문을 한 줄에 작성할 수 있도록 해준다.

```python
score = 85
result = "success" if score >= 80 else "fail"

print(result)
```

### 🐱‍🚀파이썬 조건문 내에서의 부등식

- 다른 프로그래밍 언어와 다르게 파이썬은 조건문 안에서 수학의 부등식을 그대로 사용할 수 있다.

```python
if x > 0 and x < 20:
    print("x는 0 초과, 20 미만의 수입니다.")

if 0 < x < 20
    print("x는 0 초과, 20 미만의 수입니다.")    
```
# 💡 반복문

- 특정한 소스코드를 반복적으로 실행하고자 할 때 사용하는 문법이다.
- 파이썬에서는 while문과 for문이 있는데, 코테에서의 실제 사용 예시를 보면 for문이 더 간결함.

## ✌ 1부터 9까지 모든 정수의 합 구하기 예제 (while문)

```python
i = 1
result = 0

while i <= 9:
	result += i
	i += 1

print(result)
```

## 🐱‍🏍 for문

- 반복문으로 for문을 이용할 수 있다.
- 특정한 변수를 이용하여 ‘in’ 뒤에 오는 데이터(리스트, 튜플)에 포함되어 있는 원소를 첫 번째 인덱스부터 차례대로 하나씩 방문.

```python
for 변수 in 리스트:
	실행할 소스코드
	
array = [9, 8, 7, 6, 5]

for i in array:
	print(i)
```

- for문에서 연속적인 값을 차례대로 순회할 때는 range()를 사용
    - 이때 range(시작 값, 끝 값 + 1) 형태로 사용
    - 인자를 하나만 넣으면 자동으로 시작 값은 0이 됨.

```python
result = 9

# i는 1부터 9까지 모든 값을 순회
for i in range(1, 10):
	result += i
	
print(result)
```

## 🤞 파이썬의 continue 키워드

- 반복문에서 남은 코드의 실행을 건너뛰고, 다음 반복을 진행하고자 할 때 continue를 사용.
- 1부터 9까지의 홀수의 합을 구할 떄

```python
result = 0

for i in range(1, 10):
	if i % 2 == 0:
		continue
	result += i
	
print(result)
```

## 🤞 파이썬의 break 키워드

- 반복문을 즉시 탈출하고자 할 때 break를 사용
- 1부터 5까지의 정수를 차례대로 출력할 때

```python
i = 1

while True:
	print("현재 i : ", i)
	if i == 5:
		break
	i += 1
```
# 💡 함수

- 함수란 특정한 작업을 하나의 단위로 묶어 놓은 것을 의미
- 함술르 사용하면 불필요한 소스코드의 반복을 줄일 수 있다.

## 🐱‍🏍 함수의 종류

- 내장 함수 : 파이썬이 기본적으로 제공하는 함수
- 사용자 정의 함수 : 개발자가 직접 정의하여 사용할 수 있는 함수

## 🐱‍🚀 함수 정의하기

- 프로그램에는 똑같은 코드가 반복적으로 사용되어야 할 때가 많다,
- 함수를 사용하면 소스코드의 길이를 줄일 수 있다.
    - 매개변수 : 함수 내부에서 사용할 변수
    - 반환 값 : 함수에서 처리된 결과를 반환

```python
def 함수명(매개변수):
	실행할 소스코드
	return 반환 값
	
def add(a, b):
  return a + b

print(add(3, 7))
```

- 파라미터의 변수를 직접 지정할 수 있다.
    - 이 경우 매개변수의 순서가 달라도 상관 없음!

```python
def add(a, b):
	print("함수의 결과 : ", a + b)
	
add(b = 3, a = 7)
```

## 🎶 global 키워드

- global 키워드로 변수를 지정하면 해당 함수에서는 지역 변수를 만들지 않고, 함수 바깥에 선언된 변수를 바로 참조하게 됨.

```python
a = 0

def func():
	global a
	a += 1
	
for i in range(10):
	func()

print(a)
```

## 🐱‍💻 여러 개의 반환 값

- 파이썬에서 함수는 여러 개의 반환 값을 가질 수 있다.

```python
def operator(a, b):
	add_var = a + b
	subtract_var = a - b
	multiply_var = a * b
	divide_var = a / b
	return add_var, subtract_var, multiply_var, divide_var
	
a, b, c, d = operator(7, 3)
print(a, b, c, d)
```

# 💡람다 표현식

- 람다 표현식을 이용하면 함수를 간단하게 작성할 수 있다.
    - 특정한 기능을 수행하는 함수를 한 줄에 작성할 수 있다는 점이 특징.
    - 함수를 입력으로 받는 함수 작성 시에 유용
    - 간단한 함수 작성 시에 유용

```python
def add(a, b):
	return a + b

print(add(3, 7))

#람다 표현식을 사용하면
print((lambda a, b: a + b)(3, 7))

array = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]

def my_key(x):
	return x[1]

# key는 정렬 기준
print(sorted(array, key=my_key))
print(sorted(array, key=lambda x: x[1]))

# 여러 개의 리스트에 적용
list1 = [1, 2, 3, 4, 5]
list2 = [6, 7, 8, 9, 10]

# map은 각각의 원소에 함수를 적용할 때 사용
result = map(lambda a, b: a + b, list1, list2)

print(list(result))
```

# 💡유용한 표준 라이브러리

- 내장 함수 : 기본 입출력 함수부터 정렬 함수까지 기본적인 함수들을 제공
- itertools : 파이썬에서 반복되는 형태의 데이터를 처리하기 위한 유용한 기능들을 제공
    - 순열과 조합 라이브러리는 코딩 테스트에서 자주 사용됨.
- heapq : 힙 자료구조를 제공
    - 일반적으로 우선순위 큐 기능을 구현하기 위해 사용
- bisect : 이진 탐색 기능을 제공
- collections : 덱, 카운터 등의 유용한 자료구조를 포함
- math : 필수적인 수학적 기능을 제공

## 🎶 자주 사용되는 내장 함수

```python
# sum()
result = sum([1, 2, 3, 4, 5])
print(result)

# min(), max()
min_result = min(7, 3, 5, 2)
max_result = max(7, 3, 5, 2)
print(min_result, max_result)

# eval()
# 사람이 보는 식을 계산해서 반환해줌
result = eval("(3+5)*7")
print(result)

# sorted() 
result = sorted([9, 1, 8, 4, 5])
reverse_result = sorted([9, 1, 8, 4, 5], reverse = True)
print(result)
print(reverse_result)

# sorted() with key
array = [('홍길동', 35), ('이순신', 75), ('아무개', 50)]
result = sorted(array, key=lambda x: x[1], reverse=True) 
print(result)
```

## 🐱‍🚀순열과 조합

- 모든 경우의 수를 고려해야 할 때
- 순열 : 서로 다른 n개에서 서로 다른 r개를 선택하여 일렬로 나열하는 것
    - ‘A’, ‘B’, ‘C’에서 세 개를 선택하여 나열하는 경우 : ‘ABC’, ‘ACB’, ‘BAC’, …
- 조합 : 서로 다른 n개에서 순서에 상관없이 서로 다른 r개를 선택하는 것
    - ‘A’, ‘B’, ‘C’에서 순서를 고려하지 않고 두 개를 뽑는 경우 : ‘AB’, ‘AC’, ‘BC’
- **식을 사용하여 전체 경우의 수를 구하여 완전 탐색을 수행해도 괜찮을지 판단.**

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/31b3a542-8874-4476-bec1-3253a9474a08/b5da07dc-3e7d-4634-844d-d2fc9bafc1b5/image.png)

- 순열

```python
from itertools import permutations

data = ['A', 'B', 'C']

result = list(permutations(data, 3))
#모든 순열이 출력됨
print(result)
```

- 조합

```python
from itertools import combinations

data = ['A', 'B', 'C']

result = list(combinations(data, 2))
#모든 조합이 출력됨
print(result)
```

- 중복 순열과 중복 조합

```python
from itertools import product
from itertools import combinations_with_replacement

data = ['A', 'B', 'C']

result = list(product(data, repeat=2)) # 2개를 뽑는 모든 순열 구하기(중복 허용)
print(result)

result = list(combinations_with_replacement(data, 2)) # 2개를 뽑는 모든 조합 구하기(중복 허용)
print(result)
```

## 🐱‍🏍 Counter

- 파이썬 collections 라이브러리의 Counter는 등장 횟수를 세는 기능을 제공
- 리스트와 같은 반복 가능한 객체가 주어졌을 때 내부의 원소가 몇 번씩 등장 했는지를 알려줌

```python
from collections import Counter

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])

print(counter['blue']) # 'blue'가 등장한 횟수 출력
print(dict(counter)) # 사전 자료형으로 변환 key는 원소의 값, value는 원소가 등장한 횟수
# {'red': 2, 'blue': 3, 'green': 1}
```

## 🐱‍🚀 최대 공약수와 최소 공배수

- 최대 공약수를 구해야 할 때 gcd() 함수

```python
import math

# 최소 공배수(LCM)를 구하는 함수
def lcm(a, b):
	return a * b // math.gcd(a, b)
	
a = 21
b = 14

print(math.gcd(21, 14)) # 최대 공약수 gcd 계산
print(lcm(a, b)) # 최소 공배수 lcm 계산
```
# Java 공부
# ✨ 입력

```jsx
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 10, 20, 30 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
	}
}
```

# ✨ 출력

```jsx
// 기본
System.out.println("정답 : " = answer);

// 빠른 출력
StringBuilder sb = new StringBuilder();
sb.append("1\n");
sb.append("2\n");
System.out.println(sb.toString());
```

# ✨ 문자열 처리

```jsx
String str = "hello world";
str.length(); // 문자열 길이
str.charAt(0); // 첫번재 문자
str.substring(0, 5)); // hello
str.split(" ")[1]; // world
str.equals("abc"); // 문자열 비교
str.contains("abc"): // 문자열 포함 여부
str.indexOf("o"); // 문자열 찾기
str.replace("a", "b") // 문자열 치환
str.split(" "); // 문자열 나누기

StringBuilder sb = new StringBuilder();
sb.append(str);

System.out.println(sb.toString());
```

# ✨ 배열 입력 처리

```jsx
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
int[] arr = new int[n];
StringTokenizer st = new StringTokenizer(br.readLine();

for (int i = 0; i < n; i++)
{
	arr[i] = Integer.parseInt(st.nextToken());
}
```

# ✨char 배열 or 문자 입력 처리

```jsx
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = br.readLine();
char[] chars = str.toCharArray();

for (char c : chars)
{
	System.out.println(c);
}
```

## 😎 연습 문제

```jsx
import java.io.*

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		int sum = 0;
		
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		System.out.print(sum);
	}
}
```

```jsx
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int n = 5;
		
		for (int i = 1; i < n + 1; i++)
		{
			sb.append(i).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
}
```

```jsx
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(st.nextToken());
		
		System.out.println("길이: " + sb.length());
		
		for (int i = 0; i < 3; i++) {
			System.out.print(sb.charAt(i));
		}
		
		String[] arr = sb.toString().split(" ");
		
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr[i]);
		}
	}
}
```

```jsx
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			sb.append(st.nextToken()).append("\n");
		}
		
		System.out.print(sb);
	}
}
```
