package islandcount;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

class IslandCount {

    public static void main(String[] args) {

        int[] foo = {1,2,3,4,5};
        System.out.println("foo size: " + foo.length);

        List<String> bar = new LinkedList<>();
        bar.add("foo");
        bar.add("bar");
        bar.add("muk");
        System.out.println("bar: " + bar);
        bar.remove(1);
        System.out.println("bar: " + bar);

        System.out.println("bar size: " + bar.size());

        System.out.println("Hello, world!");

//        java.util.Scanner scanner = new java.util.Scanner(System.in);
//        System.out.println("Enter: ");
        int num = -1;
//        while (num != 0) {
//            num = scanner.nextInt();
//            System.out.println("Echo: " + num);
//        }

/*        boolean isIntPalindrone = false;
        int value = 0;

        value = 1234;
        isIntPalindrone = isPalindrone(value);
        System.out.println("isIntPalindrone(" + value + ") = " + isIntPalindrone);

        value = 12321;
        isIntPalindrone = isPalindrone(value);
        System.out.println("isIntPalindrone(" + value + ") = " + isIntPalindrone);

        value = 12344321;
        isIntPalindrone = isPalindrone(value);
        System.out.println("isIntPalindrone(" + value + ") = " + isIntPalindrone);

        value = 32156123;
        isIntPalindrone = isPalindrone(value);
        System.out.println("isIntPalindrone(" + value + ") = " + isIntPalindrone);
*/
        for (int i = 0; i <= 2000; i++) {
            if (isArmstrong(i)) {
                System.out.println("isArmstrong(" + i + ")");
            }
        }

        for (int i = 0; i <= 10; i++){
            int f1 = fact(i);
            int f2 = fact2(i);
            Assert.assertEquals(f1, f2);
            System.out.println("fact(" + i + ")): " + fact(i));
        }

        String reverse = null;

        reverse = "abc";
        System.out.println("Reverse(" + reverse + ") = " + reverseRC(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse1(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse2(reverse));
        reverse = "mississippi";
        System.out.println("Reverse(" + reverse + ") = " + reverseRC(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse1(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse2(reverse));
        reverse = "abcdef";
        System.out.println("Reverse(" + reverse + ") = " + reverseRC(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse1(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse2(reverse));
        reverse = "abcdefg";
        System.out.println("Reverse(" + reverse + ") = " + reverseRC(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse1(reverse));
        System.out.println("Reverse(" + reverse + ") = " + reverse2(reverse));

        final Integer[] execptedA =  {1,2,3,4,5,7,null,null,null};
        Integer[]a = {1,2,3,2,4,5,3,2,7};
        removeDups(a);
        Assert.assertArrayEquals(execptedA, a);

        final Integer[]expectedB = {1,2,3,4,5,6,7,null,null,null,null,null};
        Integer[]b = {1,1,2,1,2,3,4,5,2,6,7,5};
        removeDups(b);

        final Integer[]expectedC = {5,6,3,8,9,7,1,2,null,null,null,null,null,null,null};
        Integer[]c = {5,6,3,5,3,8,5,9,9,9,6,7,3,1,2};
        removeDups(c);



        int[][] map = {{1,1,0,0},
                       {1,1,0,1},
                       {0,0,0,0},
                       {0,1,1,0},
                       {0,0,1,1}};

        int islandCount = findIslandCount(map);

        System.out.println("Island Count: " + islandCount);

        int[][] map2 = {
                {0,0,0,0,1,0,0,0,1,0},
                {0,1,0,1,0,0,0,1,0,0},
                {0,1,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,1,0},
                {0,0,0,0,0,1,0,1,0,1},
                {0,0,0,0,1,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {1,0,1,1,0,0,0,0,0,0}};

        islandCount = findIslandCount2(map2);

        System.out.println("Island Count2: " + islandCount);

        System.out.println("Done.");
    }

    private static int getPowerOfTen(int p) {
        int result = 1;
        for (int i = 0; i < p; i++) {
            result *= 10;
        }

        return result;
    }

    private static int getNumberDigits(int value) {
        int result = 0;
        int d = 1;
        while (value/d != 0) {
            d *= 10;
            result++;
        }

        return result;
    }

    private static int getDigit(int value, int index) {
        int p = getPowerOfTen(index);
        int result = (value/p)%10;
        return result;
    }


    private static boolean isPalindrone(int value) {

        int d = getNumberDigits(value);
        System.out.println("NumDigits: " + d);

        for (int i = 0; i < d/2; i++) {
            System.out.println("Test[" + getDigit(value,i) + "," + getDigit(value, d-i-1) + "]");
            if (getDigit(value,i) != getDigit(value, d-i-1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isArmstrong(int value) {
        int sum = 0;
        for (int i = 0; i < getNumberDigits(value); i++) {
            int d = getDigit(value, i);
            sum +=  d*d*d;
            if (sum > value) {
                return false;
            }
        }
        return sum == value;
    }

    private static int fact(int value) {
        if (value == 1 || value == 0) {
            return 1;
        }

        return value * fact(value-1);
    }

    private static int fact2(int value) {
        int f = 1;
        for (int i = 2; i <= value; i++) {
            f *= i;
        }
        return f;
    }

    private static String reverse1(String str) {
        char[] cStr = str.toCharArray();
        for (int i=0; i < str.length()/2; i++) {
            char c = cStr[i];
            cStr[i] = cStr[str.length()-(i+1)];
            cStr[str.length()-(i+1)] = c;
        }
        return new String(cStr);
    }

    private static String reverse2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i>= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static String reverseRC(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String result = str.charAt(str.length()-1) + reverseRC(str.substring(1, str.length() - 1)) + str.charAt(0);

        return result;
    }

    private static String arrayToString(Integer[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < a.length; i++ ) {
            sb.append( a[i] == null ? "null" : a[i]);
            if (i < (a.length - 1)) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    private static void makeDupsNull(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                for (int j = i+1; j < a.length; j++) {
                    if (a[i].equals(a[j])) {
                        a[j] = null;
                    }
                }
            }
        }
    }

    private static void removeNulls(Integer[] a) {
        int current = 0;
        int next = 0;
        int length = a.length;

        while (current < length) {
            while (current < length && a[current] == null) {
                current++;
            }
            while (current < length && a[current] != null) {
                a[next++] = a[current++];
            }
        }
        while (next < length) {
            a[next++] = null;
        }
    }

    private static void removeDups(Integer[] a) {
        System.out.println("Input: " + arrayToString(a));
        makeDupsNull(a);
        System.out.println("Nulls: " + arrayToString(a));
        removeNulls(a);
        System.out.println("Result: " + arrayToString(a));
    }

    private static void printMap(int[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                System.out.print(map[row][column] == 0 ? "O" : "X");
            }
            System.out.println();
        }
    }

    private static void printVisited(boolean[][] visited) {
        for (int row = 0; row < visited.length; row++) {
            for (int column = 0; column < visited[row].length; column++) {
                System.out.print(visited[row][column] ? "T" : "F");
            }
            System.out.println();
        }
    }

    private static void initVisited(boolean[][] visited) {
        for (int row = 0; row < visited.length; row++) {
            for (int column = 0; column < visited[row].length; column++) {
                visited[row][column] = false;
            }
        }
    }

    private static void initIslandMap(int[][] islandMap) {
        for (int row = 0; row < islandMap.length; row++) {
            for (int column = 0; column < islandMap[row].length; column++) {
                islandMap[row][column] = 0;
            }
        }
    }

    private static class Cell {
        private int r;
        private int c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }
    }

    private static boolean hasBeenVisited(boolean[][] visited, int row, int col) {
        return visited[row][col];
    }

    private static boolean isIslandCell(int[][] map, int row, int col) {
        return (map[row][col] != 0);
    }

    private static List<Cell> getAdjacentCells(int[][] map, int row, int col, boolean[][] visited) {
        List<Cell> result = new ArrayList<>();

        for (int r = Math.max(row-1,0); r <= Math.min(row+1, map.length-1); r++) {
            for (int c = Math.max(col-1, 0); c <= Math.min(col+1, map[0].length-1); c++) {
                if (!(r == row && c == col) && isIslandCell(map, r, c) && !hasBeenVisited(visited, r, c)) {
                    result.add(new Cell(r, c));
                }
            }
        }

        return result;
    }

    private static String toString(List<Cell> cells) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < cells.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(cells.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private static int findIslandCount(int[][] map) {
        printMap(map);

        int islandCount = 0;

        boolean[][] visited = new boolean[map.length][map[0].length];
        initVisited(visited);

        int[][] islandMap = new int[map.length][map[0].length];
        initIslandMap(islandMap);

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                int oldIslandCount = islandCount;
                islandCount = getIslandCount(map, r, c, visited, islandCount, islandMap);
                if (islandCount != oldIslandCount) {
                    System.out.println("Island started at " + r + "," + c);
                    printMap(islandMap);
                    initIslandMap(islandMap);
                }
            }
        }

        return islandCount;
    }

    private static int getIslandCount(int[][] map, int r, int c, boolean[][] visited, int islandCount, int[][] islandMap) {
        if (isIslandCell(map, r, c) && !hasBeenVisited(visited, r, c)) {
            visited[r][c] = true;
            islandMap[r][c] = 1;
            List<Cell> adjacentCells = getAdjacentCells(map, r, c, visited);
            if (adjacentCells.isEmpty()) {
                return ++islandCount;
            }
            for (Cell cell : adjacentCells) {
                return getIslandCount(map, cell.getR(), cell.getC(), visited, islandCount, islandMap);
            }

//            System.out.println("(" + r + "," + c + "): " + toString(adjacentCells));
        }

        return islandCount;
    }

    private static int findIslandCount2(int[][] map) {
        printMap(map);

        int islandCount = 0;

        boolean[][] visited = new boolean[map.length][map[0].length];
        initVisited(visited);

        int[][] islandMap = new int[map.length][map[0].length];
        initIslandMap(islandMap);

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (isIslandCell(map, r, c) && !hasBeenVisited(visited, r, c)) {
                    initIslandMap(islandMap);
                    getIsland(map, r, c, visited, islandMap);
                    islandCount++;
                    System.out.println("\nIsland #" + islandCount);
                    System.out.println("===========");
                    printMap(islandMap);

                }
            }
        }

        return islandCount;
    }

    private static void getIsland(int[][] map, int r, int c, boolean[][] visited, int[][] islandMap) {
        if (isIslandCell(map, r, c) && !hasBeenVisited(visited, r, c)) {
            visited[r][c] = true;
            islandMap[r][c] = 1;
            List<Cell> adjacentCells = getAdjacentCells(map, r, c, visited);
            if (adjacentCells.isEmpty()) {
                return;
            }
            for (Cell cell : adjacentCells) {
                getIsland(map, cell.getR(), cell.getC(), visited, islandMap);
            }

//            System.out.println("(" + r + "," + c + "): " + toString(adjacentCells));
        }
    }
}