package Chapter11;

import java.util.HashMap;
import java.util.Map;

/*
Write a method called rarest that accepts a map whose keys are strings and whose values are integers as a parameter
and returns the integer value that occurs the fewest times in the map. If there is a tie, return the smaller integer value. If
the map is empty, throw an exception.
 */
public class Exercise19 {
    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<>();

        map.put("Simon", 19);
        map.put("Mikkel", 19);
        map.put("Bent", 12);
        map.put("Jacob", 20);
        map.put("Kasper", 20);
        map.put("Sofie", 19);
        map.put("Sarah", 20);
        map.put("Marlene", 10);

        Exercise19 exercise19 = new Exercise19();
        System.out.println("the rares number in the list is: " + exercise19.rarest(map));
    }

    private int rarest(Map<String, Integer> map)
    {
        if (map.size() == 0) return 0;
        else
        {
            Map<Integer, Integer> newMap = new HashMap<>();

            for(Map.Entry<String, Integer> entry : map.entrySet()){

                if (newMap.containsKey(entry.getValue()))
                {
                    newMap.put(entry.getValue(), newMap.get(entry.getValue()) + 1);
                }
                else
                {
                    newMap.put(entry.getValue(), 1);
                }
            }

            Map.Entry<Integer, Integer> min = null;

            for (Map.Entry<Integer, Integer> entry : newMap.entrySet())
            {
                if(min == null || min.getValue() > entry.getValue())
                    min = entry;
            }
            return min.getKey();
        }
    }
}
