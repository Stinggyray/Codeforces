package AdventOfCode;

import Utils.LoggingUtil;

import java.util.*;

//Advent of Code Day 6
public class UniversalOrbitMap {
    static class Planet {
        private Planet head;
        private String name;

        public Planet(Planet head, String name) {
            this.head = head;
            this.name = name;
        }

        public Planet(String name){
            this.head = null;
            this.name = name;
        }

        public Planet getHead() {
            return head;
        }

        public void setHead(Planet head) {
            this.head = head;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args){
        //runPart1();
        runPart2();
    }

    public static void runPart1(){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Planet> planets = new HashMap<>();
        while(true){
            String cur;
            try {
                cur = sc.nextLine();
            } catch (NoSuchElementException e){
                break;
            }

            if(!cur.contains(")")){
                break;
            }

            String planet1 = cur.substring(0, cur.indexOf(")"));
            String planet2 = cur.substring(cur.indexOf(")") + 1);

            if(planets.containsKey(planet1)){
                if(planets.containsKey(planet2)) {
                    planets.get(planet2).setHead(planets.get(planet1));
                }
                else {
                    Planet bruh = planets.get(planet1);
                    planets.put(planet2, new Planet(bruh, planet2));
                }
            }
            else {
                Planet bruh = new Planet(planet1);
                planets.put(planet1, bruh);

                if(planets.containsKey(planet2)){
                    planets.get(planet2).setHead(bruh);
                }
                else {
                    planets.put(planet2, new Planet(bruh, planet2));
                }
            }
        }

        int counter = 0;
        for(Map.Entry<String, Planet> cur : planets.entrySet()){
            //System.out.print(cur.getKey() + ",");
            counter += getOrbitLength(cur.getValue()) - 1;
        }

        System.out.println("Total orbit length: " + counter);
    }

    public static void runPart2(){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Planet> planets = new HashMap<>();
        while(true){
            String cur;
            try {
                cur = sc.nextLine();
            } catch (NoSuchElementException e){
                break;
            }

            if(!cur.contains(")")){
                break;
            }

            String planet1 = cur.substring(0, cur.indexOf(")"));
            String planet2 = cur.substring(cur.indexOf(")") + 1);

            if(planets.containsKey(planet1)){
                if(planets.containsKey(planet2)) {
                    planets.get(planet2).setHead(planets.get(planet1));
                }
                else {
                    Planet bruh = planets.get(planet1);
                    planets.put(planet2, new Planet(bruh, planet2));
                }
            }
            else {
                Planet bruh = new Planet(planet1);
                planets.put(planet1, bruh);

                if(planets.containsKey(planet2)){
                    planets.get(planet2).setHead(bruh);
                }
                else {
                    planets.put(planet2, new Planet(bruh, planet2));
                }
            }
        }

        Planet YOU = planets.get("YOU");
        Planet SAN = planets.get("SAN");

        ArrayList<String> visited = new ArrayList<>();

        Planet cur = YOU;
        while(cur != null){
            visited.add(cur.getName());
            cur = cur.getHead();
        }

        System.out.println(LoggingUtil.logArrayList(visited));

        Planet santa = SAN;
        int counter = 0;

        System.out.print("[");
        while(santa != null){
            System.out.print(santa.getName() + ",");
            if(visited.contains(santa.getName())){
                break;
            }
            counter++;
            santa = santa.getHead();
        }
        System.out.print("]\n");

        System.out.println(counter + visited.indexOf(santa.getName()) - 2);
    }

    public static int getOrbitLength(Planet planet){
        if(planet == null){
            System.out.println();
            return 0;
        }
        else {
            System.out.print(planet.getName() + "->");
            return 1 + getOrbitLength(planet.getHead());
        }
    }
}
