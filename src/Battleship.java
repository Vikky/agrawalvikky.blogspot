import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Vikky.Agrawal
 * 
 */
public class Battleship {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Battleship obj = new Battleship();
		obj.play(4, 3);

	}

	public void play(int N, int S) {

		Player player1 = new Player(N+1, S);
		Player player2 = new Player(N+1, S);

		//player1.putShips(2, 5, 7, 5);
		player1.putShips(1, 1, 1, 3);
		player1.putShips(2, 4, 4, 4);
		player1.putShips(3, 1, 3, 3);
		
		
		
		player2.putShips(1, 1, 1, 3);
		player2.putShips(1, 4, 3, 4);
		player2.putShips(2,1,4,1);
		
		
		Play playGame=new Play();
		
		playGame.guessBlock(2,1,player2);
		playGame.guessBlock(2,2,player2);
		playGame.guessBlock(2,3,player2);
		
		
	}
}

class Player {

	int[][] board;
	ArrayList<Ship> shipArr;

	Player(int N,  int ships) {
		this.board = new int[N][N];
		
		this.shipArr = new ArrayList<Ship>(ships);
	}

	private int getSize() {
		return this.board.length;
	}

	public void putShips(int x1, int y1, int x2, int y2) {

		if (x1 > this.getSize() || x2 > this.getSize() || y1 > this.getSize()
				|| y2 > this.getSize()) {
			System.out.println("Cant place a ship outside of board ");
			return;
		}

		this.shipArr.add(new Ship(x1,y1,x2,y2));
		if (x1 == x2) {
			// horizontal
			for (int i = y1; i <= y2; i++) {
				this.board[x1][i] = 1;
				
			}

		} else if (y1 == y2) {
			// vertical
			for (int i = x1; i <= x2; i++) {
				this.board[i][y1] = 1;
				
			}

		} else {
			System.out.println("Can't place diagonally");
			return;
		}

		this.shipArr.add(new Ship(x1, y1, x2, y2));

	}

	
	
}


class Play{
	
	public boolean guessBlock(int a, int b, Player p) {

		
		int[][] board=p.board;
		
		if (a > p.board.length || b > p.board.length) {
			System.out.println("Cant check beyond boundaries");
			return false;
		}

		if (board[a][b] == 1) {
			// set as a hit;
			board[a][b] = -1;
			System.out.println("It was a hit");
			this.checkShipHit(a, b ,p);
			
			return true;
		} else {
			System.out.println("It was a miss");
			return false;
		}

	}

	private void checkShipHit(int a, int b, Player p) {
		
		ArrayList<Ship> shipArr=p.shipArr;
		
		Iterator<Ship> itr=shipArr.iterator();
		while(itr.hasNext()) {
			// vertical
			Ship ship=itr.next();
			
			if (ship.getX1() == ship.getX2()) {
				int x1 = ship.getX1();
				int y1 = ship.getY1();
				int y2 = ship.getY2();

				if (a == x1) {
					for (int i = y1; i <=y2; i++) {
						if (b == i) {
							ship.ship[x1][i] = -1;
							break;
						}
					}
					break;
				}
			} else {
				// Horizontal
				int x1 = ship.getX1();
				int x2 = ship.getX2();
				int y1 = ship.getY2();

				if (b == y1) {
					for (int i = x1; i <= x2; i++) {
						if (a == i) {
							ship.ship[i][y1] = -1;
							break;
						}
					}
					break;
				}

			}

		}
		
		
		Iterator<Ship> itr1=shipArr.iterator();
		while(itr1.hasNext()) {
			// vertical
			Ship ship=itr1.next();
			if (ship.getX1() == ship.getX2()) {
				int x1 = ship.getX1();
				int y1 = ship.getY1();
				int y2 = ship.getY2();
				int temp=y2-y1+1;
				int count=0;
					for (int i = y1; i <= y2; i++) {
						if(ship.ship[x1][i]==-1){
							count++;
						}else{
							break;
						}
					}
				if(count==temp){
					System.out.println("Ship"+shipArr.indexOf(ship)+" is dead:");
					p.shipArr.remove(ship);
				}
			}else{
				int x1 = ship.getX1();
				int x2= ship.getX2();
				int y1 = ship.getY1();
				
				int temp=x2-x1+1;
				int count=0;
					for (int i = x1; i <= x2; i++) {
						if(ship.ship[i][y1]==-1){
							count++;
						}else{
							break;
						}
					}
				//System.out.println("temp:"+temp+"count : "+count);	
				if(count==temp){
					System.out.println("Ship"+shipArr.indexOf(ship)+" is dead:");
					p.shipArr.remove(ship);
				}
			}
		}
		
		
		
		if(p.shipArr.size()==0){
			System.out.println("Other player won the game");
		}

	}
	
	
	

	
	
}





class Ship {

	int x1;
	int y1;
	int x2;
	int y2;
	int[][] ship;

	Ship(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.ship=new int[11][11];
		
		
		if (x1 == x2) {
			// vertical
			if (y1 < y2) {
				//this.ship = new int[x1][y2];
				this.fillShipHorizontal(x1,y1, y2);
			} else {
				//this.ship = new int[x1][y1];
				this.fillShipHorizontal(x1, y1,y2);
			}

		} else if (y1 == y2) {
			// horizontal
			if (x1 < x2) {
				//this.ship = new int[x2][y1];
				this.fillShipVertical(x1,x2, y1);
			} else {
				//this.ship = new int[x1][y1];
				this.fillShipVertical(x1,x2, y1);
			}

		} else {
			System.out.println("Can't place diagonally");
			return;
		}

	}

	private void fillShipHorizontal(int x1,int y1, int y2) {
		for (int i = y1; i <= y2; i++) {
			this.ship[x1][i] = 1;
		}
	}

	private void fillShipVertical(int x1,int x2, int y1) {
		for (int i = x1; i <= x2; i++) {
			this.ship[i][y1] = 1;
		}
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int[][] getShip() {
		return ship;
	}

	public void setShip(int[][] ship) {
		this.ship = ship;
	}

}
