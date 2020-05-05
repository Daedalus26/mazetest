import java.util.ArrayList;
import java.util.LinkedList;

public class newMaze {
	
	static ArrayList<Maze> Mazes = new ArrayList<Maze>();

	public static void main(String[] args) {
		
		Maze m = new Maze();

		int[][] maze = {
				{2, 1, 1, 1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0, 1, 0, 1},
				{1, 0, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 1, 1, 0, 0, 1},
				{0, 1, 0, 0, 1, 1, 0, 0},
				{0, 1, 1, 1, 1, 1, 1, 1}

		};
		
		m.maze = maze;
		m.start = new Position(0, 3);
		m.path = new LinkedList<Position>();
		
		Maze n = new Maze();
		
		int[][] secondmaze = {
				{2, 0, 0, 1, 0, 1, 1, 1},
				{1, 1, 0, 1, 0, 1, 0, 1},
				{0, 0, 1, 1, 0, 1, 0, 1},
				{1, 0, 0, 0, 1, 0, 0, 1},
				{0, 1, 0, 0, 1, 1, 0, 0},
				{0, 1, 1, 1, 1, 1, 1, 1}

		};
		
		n.maze = secondmaze;
		n.start = new Position(0, 3);
		n.path = new LinkedList<Position>();
		
		Mazes.add(m);
		Mazes.add(n);
		
		int i = 0;
		while(i < Mazes.size()) {
		if(solveMaze(Mazes.get(i))) {
		System.out.println("You left the maze");
		
		} else {
			System.out.println("No Path");
		}
		i++;
	}
		
}
		private static boolean solveMaze(Maze m) {
					Position p = m.start;
					m.path.push(p);

				
					
				while(true) {
				int y = m.path.peek().y;
				int x = m.path.peek().x;
				
				m.maze[y][x] = 0;
			//down
				if(isValid(y+1, x, m)) {
			if(m.maze[y+1][x] == 2) {
				System.out.println("Moved down");
				return true;
						
			}else if(m.maze[y+1][x] == 1) {
					m.path.push(new Position(y+1, x));
					System.out.println("Moved down");
					continue;
					}
				}
			
					//left
					if(isValid(y, x-1, m)) {
					if(m.maze[y][x-1] == 2) {
						System.out.println("Moved left");
						return true;
								
					}else if(m.maze[y][x-1] == 1) {
							m.path.push(new Position(y, x-1));
							System.out.println("Moved left");
							continue;
							}
					}
					
					//up
					if(isValid(y-1, x, m)) {
					if(m.maze[y-1][x] == 2) {
						System.out.println("Moved up");
						return true;
								
					}else if(m.maze[y-1][x] == 1) {
							m.path.push(new Position(y-1, x));
							System.out.println("Moved up");
							continue;
							}
					}
					
					//down
					if(isValid(y+1, x, m)) {
					if(m.maze[y+1][x] == 2) {
						System.out.println("Moved down");
						return true;
								
					}else if(m.maze[y][x-1] == 1) {
							m.path.push(new Position(y+1, x));
							System.out.println("Moved down");
							continue;
							}
					}
					
					//right
					if(isValid(y+1, x, m)) {
					if(m.maze[y+1][x] == 2) {
						System.out.println("Moved right");
						return true;
								
					}else if(m.maze[y+1][x] == 1) {
							m.path.push(new Position(y+1, x));
							System.out.println("Moved down");
							continue;
							}
						}
					m.path.pop();
					System.out.println("Moved back");
					
					if(m.path.size() <= 0) {
						return false;
					}
		
				}
				
			}
		
	

		public static boolean isValid(int y, int x, Maze m) { 
			if(y < 0 ||
				y >= m.maze.length ||
				x < 0 ||
				x >= m.maze[y].length
					) {
			
			return false;
			}
		
			return true;
		}
	}


