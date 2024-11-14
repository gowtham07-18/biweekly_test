package fourteenNov;
import java.util.Scanner;

public class QuestionOne {
    
    
    public static int findMinimumPath(int row, int col,boolean[][] visited, int goldX, int goldY, int count, int min) {
        
        if (row == goldX && col == goldY) {
            return Math.min(min, count);
        }

        int currentMin = min;
        if (row - 1 >= 0 && !visited[row - 1][col]) { 
            visited[row - 1][col] = true;
            currentMin = findMinimumPath(row - 1, col, visited, goldX, goldY, count + 1, currentMin);
            visited[row - 1][col] = false;
        }
        if (col - 1 >= 0 && !visited[row][col - 1]) { 
            visited[row][col - 1] = true;
            currentMin = findMinimumPath(row, col - 1, visited, goldX, goldY, count + 1, currentMin);
            visited[row][col - 1] = false;
        }
        if (row + 1 < visited.length && !visited[row + 1][col]) { 
            visited[row + 1][col] = true;
            currentMin = findMinimumPath(row + 1, col, visited, goldX, goldY, count + 1, currentMin);
            visited[row + 1][col] = false;
        }
        if (col + 1 < visited[0].length && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            currentMin = findMinimumPath(row, col + 1, visited, goldX, goldY, count + 1, currentMin);
            visited[row][col + 1] = false;
        }
        return currentMin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int adventurePositionX = sc.nextInt()-1;
        int adventurePositionY = sc.nextInt()-1;
        int goldPositionX = sc.nextInt()-1;
        int goldPositionY = sc.nextInt()-1;

        boolean[][] visited = new boolean[row][col];

        int result = findMinimumPath(adventurePositionX, adventurePositionY,visited, goldPositionX, goldPositionY, 0, Integer.MAX_VALUE);
        
        System.out.println("Minimum path length: " + result);
    }
}


