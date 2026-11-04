package com.ronak;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Labmda and stream
/*
- Lambda :- is a way to create anonymous instances of your functional interfaces.
- Stream :-
 */
public class Main {
    public static void main(String[] args) {

        /* older way
        Walkable obj = new WalkFast();
        obj.walk(4);
         */

//        Walkable obj = new Walkable() {
//            @Override
//            public int walk(int steps) {
//                return 0;
//            }
//        }

        Walkable obj = (int steps) -> {
            System.out.println("Walking fast " + steps + " steps.");
            return 2 * steps;
        };
        obj.walk(4);


        List<String> fruits = List.of("Banana", "Apple", "Kiwi", "Mango");

        Set<Integer> fruitsList = fruits
                .stream()
                .map(fruit -> fruit.length())
                .collect(Collectors.toSet());

        System.out.println(fruitsList);

//        Stream<String> stream = fruits.stream();
//        stream.forEach((f) -> {
//            System.out.println(f);
//        });

//        stream
//                .filter(fruit -> fruit.length() < 5)
//                .sorted()
////                .map(fruit -> fruit.length())
////                .map(fruitLength -> 2 * fruitLength)
//                .forEach(fruit -> System.out.println(fruit));
    }
}

@FunctionalInterface
interface Walkable {
    int walk(int steps);
}

//class WalkFast implements Walkable {
//
//    @Override
//    public int walk(int steps) {
//        System.out.println("Walking fast " + steps + " steps.");
//        return 2 * steps;
//    }
//}