package problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return
 * the minimum number of conference rooms required.
 */
public class MinimumMeetingRooms {

  public static void main(String[] args) {

    MinimumMeetingRooms obj = new MinimumMeetingRooms();
    int[][] intervals = new int[][] {{0, 30}, {5, 10}, {15, 20}};
    System.out.println(obj.minMeetingRooms(intervals));
  }

  // Algo :
  // Sort the intervals based on start time.
  // Allocate room and set end time.
  // If next start interval >= this.endtime reset end time
  // else check next room
  // if no rooms available allocate a new room.
  public int minMeetingRooms(int[][] intervals) {

    if (intervals == null) return 0;

    Map<Integer, List<Room>> map = new TreeMap();
    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      Room room = new Room(start, end);
      if (map.containsKey(start)) map.get(start).add(room);
      else {
        List<Room> list = new ArrayList();
        list.add(room);
        map.put(start, list);
      }
    }

    List<Room> rooms = new ArrayList();
    List<Room> incoming = new ArrayList();
    for (Map.Entry<Integer, List<Room>> entry : map.entrySet()) {
      incoming.addAll(entry.getValue());
    }

    for (int i = 0; i < incoming.size(); i++) {
      Room request = incoming.get(i);
      if (rooms.size() == 0) {
        rooms.add(request);
        continue;
      }
      boolean flag = false;
      for (int j = 0; j < rooms.size(); j++) {
        Room existing = rooms.get(j);
        if (existing.endTime <= request.startTime) {
          existing.endTime = request.endTime;
          flag = true;
          break;
        }
      }
      if (!flag) rooms.add(request);
    }
    return rooms.size();
  }

  static class Room {
    int startTime;
    int endTime;

    Room(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }
}
