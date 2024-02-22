import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Friend> friendMap = new HashMap<>();
        for(String friend : friends){
            friendMap.put(friend ,new Friend(friend));
        }

        for(String gift : gifts){
            String[] giveAndTake = gift.split(" ");
            String giver = giveAndTake[0];
            String taker = giveAndTake[1];
            friendMap.get(giver).giveGift(taker);
            friendMap.get(taker).takeGift(giver);
        }
        
        int highest = 0;
        for(Friend f : friendMap.values()){
            f.calculateNextMonthGift(friendMap);
            System.out.println(f.toString());
            if (highest < f.nextMonthGift){
                highest = f.nextMonthGift;
            }
        }

        int answer = highest;
        return answer;
    }

    public class Friend{
        public String name;
        private final Map<String, Integer> giftGivenMap;
        private Map<String, Integer> giftTakenMap;
        public int giftIndex;
        public int nextMonthGift;

        public Friend(String name){
            this.name = name;
            this.giftGivenMap = new HashMap<String, Integer>();
            this.giftTakenMap = new HashMap<String, Integer>();
            this.giftIndex = 0;
            this.nextMonthGift = 0;
        }

        public void giveGift(String toFriend){
            if(giftGivenMap.get(toFriend) == null){
                giftGivenMap.put(toFriend, 1);
            }else{
                int i = giftGivenMap.get(toFriend);
                giftGivenMap.put(toFriend, ++i);
            }
            giftIndex++;
        }

        public void takeGift(String fromFriend){
            if(giftTakenMap.get(fromFriend) == null){
                giftTakenMap.put(fromFriend, 1);
            }else{
                int i = giftTakenMap.get(fromFriend);
                giftTakenMap.put(fromFriend, ++i);
            }
            giftIndex--;
        }

        public int calculateNextMonthGift(Map<String, Friend> friendMap){
            for(Friend f : friendMap.values()){
                if(f.name.equals(this.name)){
                    continue;
                }
                int givenCnt = giftGivenMap.get(f.name)== null ? 0 : giftGivenMap.get(f.name);
                int takenCnt = giftTakenMap.get(f.name) == null ? 0 : giftTakenMap.get(f.name);
                if(givenCnt > takenCnt){
                    nextMonthGift++;
                    continue;
                }
                if(givenCnt == takenCnt){
                    if(this.giftIndex > f.giftIndex){
                        nextMonthGift++;
                        continue;
                    }
                }
            }
            return this.nextMonthGift;
        }
        
        public String toString(){
            return this.name + " = " + this.nextMonthGift; 
        }

    }
}