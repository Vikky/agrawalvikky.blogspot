package problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumFunctions {

  /**
   * On a single-threaded CPU, we execute a program containing n functions. Each function has a
   * unique ID between 0 and n-1.
   *
   * <p>Function calls are stored in a call stack: when a function call starts, its ID is pushed
   * onto the stack, and when a function call ends, its ID is popped off the stack. The function
   * whose ID is at the top of the stack is the current function being executed. Each time a
   * function starts or ends, we write a log with the ID, whether it started or ended, and the
   * timestamp.
   *
   * <p>You are given a list logs, where logs[i] represents the ith log message formatted as a
   * string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function
   * call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function
   * call with function ID 1 ended at the end of timestamp 2. Note that a function can be called
   * multiple times, possibly recursively.
   *
   * <p>A function's exclusive time is the sum of execution times for all function calls in the
   * program. For example, if a function is called twice, one call executing for 2 time units and
   * another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
   *
   * <p>Return the exclusive time of each function in an array, where the value at the ith index
   * represents the exclusive time for the function with ID i.
   *
   * @param args
   */
  public static void main(String[] args) {
    MinimumFunctions minimumFunctions = new MinimumFunctions();
    List<String> list = new ArrayList<>();
    list.add("0:start:0");
    list.add("0:start:2");
    list.add("0:end:5");
    list.add("0:start:6");
    list.add("0:end:7");

    int[] time = minimumFunctions.exclusiveTime(1, list);
    for (int i : time) System.out.println(i);
  }

  // Algo
  // Maintain last execution time.
  // If next job is start job then update current job's execution time
  // else pop and subtract time+1 is the total execution time.
  // if next is end time then end-lastexecution will be the time. pop
  public int[] exclusiveTime(int n, List<String> logs) {

    if (logs == null || logs.isEmpty()) return null;

    Stack<Logs> stack = new Stack();
    int[] times = new int[n];

    int lastexecution = 0;
    for (int i = 0; i < logs.size(); i++) {
      String str = logs.get(i);
      String[] input = str.split(":");

      int id = Integer.valueOf(input[0]);
      int soe = Integer.valueOf(input[2]);
      Logs log = new Logs(id);
      if ("start".equalsIgnoreCase(input[1])) {

        log.start = soe;
        if (!stack.isEmpty()) {
          if (!stack.peek().execution) {
            Logs popped = stack.pop();
            int time = soe - popped.start;
            times[popped.id] += time;
            lastexecution = time;
            popped.execution = true;
            stack.push(popped);
          }
        }
        stack.push(log);
      } else {
        log.end = soe;
        if (!stack.isEmpty()) {
          if (!stack.peek().execution) {
            int time = soe - stack.pop().start + 1;
            times[id] += time;
            lastexecution = soe;
          } else {
            int time = soe - lastexecution;
            times[id] += time;
            lastexecution = soe;
            stack.pop();
          }
        }
      }
    }
    return times;
  }

  static class Logs {
    int id;
    int start;
    boolean execution;
    int end;

    Logs(int id) {
      this.id = id;
    }
  }
}
