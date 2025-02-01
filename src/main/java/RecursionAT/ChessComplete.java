package RecursionAT;

public class ChessComplete {

	private int size;

	private int[][] arr;

	private int count;

	private int step;

	

	public ChessComplete(int size) {

		this.size=size;

		arr = new int[size][size];

		step = 0;

	}

	

	public boolean move(int x, int y) {

		boolean trueFalse = true;

			for (int[] i : arr) {

				for (int j : i) {

					if (j == 0) {

						trueFalse = false;

					}

				}

			}

			if (trueFalse) {

				return trueFalse;

			}

		if (inBounds(x-2, y-1)) {

			step++;

			arr[x-2][y-1]=step;

			move(x-2, y-1);

		}

		else if (inBounds(x-2, y+1)) {

			step++;

			arr[x-2][y+1]=step;

			move(x-2, y+1);

		}

		else if (inBounds(x-1, y-2)) {

			step++;

			arr[x-1][y-2]=step;

			move(x-1, y-2);

		}

		else if (inBounds(x-1, y+2)) {

			step++;

			arr[x-1][y+2]=step;

			move(x-1, y+2);

		}

		else if (inBounds(x+2, y-1)) {

			step++;

			arr[x+2][y-1]=step;

			move(x+2, y-1);

		}

		else if (inBounds(x+2, y+1)) {

			step++;

			arr[x+2][y+1]=step;

			move(x+2, y+1);

		}

		else if (inBounds(x+1, y+2)) {

			step++;

			arr[x+1][y+2]=step;

			move(x+1, y+2);

		}

		else if (inBounds(x+1, y-2)) {

			step++;

			arr[x+1][y-2]=step;

			move(x+1, y-2);

		}

		return false;

	}

	

	public int getSteps() {

		return step;

	}

	

	public boolean inBounds(int x, int y) {

		if (y < arr[0].length && y >= 0 && x < arr.length && x >= 0) {

			if(arr[x][y]==0) {

				return true;

			}

		}

			return false;

	}

	

	public void displayBoard() {

		String board = "";

		for (int[] i : arr) {

			for (int j : i) {

				board += j + " ";

			}

			board+="\n";

		}

		System.out.println(board);

	}
}