import java.util.LinkedList;

public class newMaze {
	static int[][] maze = {
			{2, 0, 1, 1},
			{1, 1, 0, 1},
			{0, 1, 1, 1}
	};
	
	static LinkedList<Position> path = new LinkedList<Position>();
	public static void main(String[] args) {
		
		Position p = new Position(0, 3);
		path.push(p);
		
		while(true) {
			int y = path.peek().y;
			int x = path.peek().x;
			
			maze[y][x] = 0;
		//down
		if(maze[y+1][x] == 2) {
			System.out.println("Moved down. you won!");
			return;
					
		}else if(maze[y+1][x] == 1) {
				path.push(new Position(y+1, x));
				System.out.println("Moved down");
				continue;
				}
				//left
				if(maze[y][x-1] == 2) {
					System.out.println("Moved left. you won!");
					return;
							
				}else if(maze[y][x-1] == 1) {
						path.push(new Position(y, x-1));
						System.out.println("Moved left");
						continue;
						}
				//up
				if(maze[y-1][x] == 2) {
					System.out.println("Moved up. you won!");
					return;
							
				}else if(maze[y-1][x] == 1) {
						path.push(new Position(y-1, x));
						System.out.println("Moved up");
						continue;
						}
				//down
				if(maze[y+1][x] == 2) {
					System.out.println("Moved down. you won!");
					return;
							
				}else if(maze[y][x-1] == 1) {
						path.push(new Position(y+1, x));
						System.out.println("Moved down");
						continue;
						}
				//right
				if(maze[y+1][x] == 2) {
					System.out.println("Moved right. you won!");
					return;
							
				}else if(maze[y+1][x] == 1) {
						path.push(new Position(y+1, x));
						System.out.println("Moved down");
						continue;
						}
				path.pop();
				if(path.size() <= 0) {
					System.out.println("no path");
				}
			
			}
		}
		
		
	}


