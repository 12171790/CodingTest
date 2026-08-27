import java.util.*;

class Solution {    
    public String solution(String number, int k) {
        String answer = "";
    
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(Integer.parseInt(number.charAt(0) + ""));

        for (int i = 1; i < number.length(); i++)
        {
             if (k > 0)
            {
                int first = queue.getLast();
                int num = Integer.parseInt(number.charAt(i) + "");

                if (first >= num)
                {
                    queue.offerLast(num);
                }
                else
                {
                    while(!queue.isEmpty() && k > 0)
                    {
                        first = queue.getLast();
                        if (first >= num)
                        {
                            break;
                        }
                        else
                        {
                            k--;
                            queue.pollLast();
                        }
                    }

                    queue.offerLast(num);
                }
            }
            else
            {
                queue.offerLast(Integer.parseInt(number.charAt(i) + ""));
            }
        }

        while(k > 0)
        {
            queue.pollLast();
            k--;
        }
        
        while (!queue.isEmpty())
        {
            answer += queue.pollFirst();
        }

        return answer;
    }
}