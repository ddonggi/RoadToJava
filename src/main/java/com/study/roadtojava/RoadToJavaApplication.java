package com.study.roadtojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration
public class RoadToJavaApplication {
    enum Direction {
        EAST(1), SOUTH(5), WEST(-1), NORTH(10);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST"); //상수 이름으로 상수에 대한 참조를 얻을수있다.
        Direction d3 = Enum.valueOf(Direction.class, "EAST"); //지정된 열거형에서 상수명과 일치하는 상수 반환

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1==d2 : " + (d1 == d2)); //열거형 상수간의 비교는 ==연산 가능. 결과 false
        System.out.println("d1==d3 : " + (d1 == d3)); //열거형 상수간의 비교는 ==연산 가능. 결과 true
        System.out.println("d1.equals(d3) : " + (d1.equals(d3))); //equals로 비교 가능. ==보다 느린 성능
//        System.out.println("d1 > d3) : "+(d1>d3)); // > < 비교연산 사용 불가
        System.out.println("d1.compareTo(d3) : " + d1.compareTo(d3)); // a.compareTo(b) a,b 비교 하여 왼이 크면 양수,같으면 0, 오른이 크면 음수
        System.out.println("d1.compareTo(d2) : " + d1.compareTo(d2)); // a.compareTo(b) a,b 비교 하여 왼이 크면 양수,같으면 0, 오른이 크면 음수

        /* switch 연산 */
        switch (d1) {
            case EAST: //Direction.EAST 라고 쓸 수 없다.
                System.out.println("Direction is EAST");
                break;
            case WEST:
                System.out.println("Direction is WEST");
                break;
            case SOUTH:
                System.out.println("Direction is SOUTH");
                break;
            case NORTH:
                System.out.println("Direction is NORTH");
                break;
        }

        Direction[] dArr = Direction.values(); //열거형의 모든 상수를 배열에 담아 반환

        for (Direction d : dArr)
            System.out.printf("%s = %d \n", d.name(), d.ordinal()); //이름과 순서
    }

    //Direction d = new Direction(1); // 에러. 열거형의 생성자는 외부에서 호출 불가
}
