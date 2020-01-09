package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikky.agrawal on 2020-01-09
 * <p>
 * Problem statement : You are given n rooms (1..n) find a room which is of max distance from occupied rooms and
 * allocate it to new person. Conditions :  in case 2 rooms having same max distance allocate the room having lower
 * index.
 */
public class MaxDistanceRoom
{

	public static void main(String[] args)
	{
		MaxDistanceRoom maxDistanceRoom = new MaxDistanceRoom();
		maxDistanceRoom.initialize(5);

		maxDistanceRoom.findAndInsertMaxDistancedRoom();
		maxDistanceRoom.findAndInsertMaxDistancedRoom();
		maxDistanceRoom.findAndInsertMaxDistancedRoom();

		maxDistanceRoom.findAndInsertMaxDistancedRoom();
		maxDistanceRoom.findAndInsertMaxDistancedRoom();
		maxDistanceRoom.findAndInsertMaxDistancedRoom();

		maxDistanceRoom.deleteRoom(5);

		maxDistanceRoom.findAndInsertMaxDistancedRoom();

	}

	private int[][] arr;

	private void initialize(int n)
	{
		arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (i > j)
					arr[i][j] = i - j;
				if (i < j)
					arr[i][j] = j - i;
			}
		}
		printMatrix(arr);
	}

	private void findAndInsertMaxDistancedRoom()
	{
		int max = 0, index = 1;

		final List<Integer> empty = getEmptyRooms(arr);
		final List<Integer> occupied = getOccupiedRooms(arr);

		if (empty.size() == 0)
		{
			System.out.println("Can't allocate any room, all are occupied.");
			return;
		}

		for (int i = 0; i < empty.size(); i++)
		{
			int emptyRoom = empty.get(i);

			for (int j = 0; j < occupied.size(); j++)
			{
				int occupiedRoom = occupied.get(j);
				if (arr[emptyRoom][occupiedRoom] > max)
				{
					max = arr[emptyRoom][occupiedRoom];
					index = emptyRoom;
				}
			}
		}
		System.out.println("Found max distance room : " + index);
		insertRoom(index);
		printMatrix(arr);

	}

	private void insertRoom(int room)
	{
		arr[0][room] = 1;
	}

	private void deleteRoom(int room)
	{
		arr[0][room] = 0;
	}

	private List<Integer> getEmptyRooms(int[][] arr)
	{
		final List<Integer> empty = new ArrayList<>();

		for (int i = 1; i < arr.length; i++)
		{
			if (arr[0][i] == 0)
			{
				empty.add(i);
			}
		}
		return empty;
	}

	private List<Integer> getOccupiedRooms(int[][] arr)
	{
		final List<Integer> occupied = new ArrayList<>();

		for (int i = 1; i < arr.length; i++)
		{
			if (arr[0][i] != 0)
			{
				occupied.add(i);
			}
		}
		return occupied;
	}

	public void printMatrix(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}