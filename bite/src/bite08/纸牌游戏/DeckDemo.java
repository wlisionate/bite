package bite08.纸牌游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 18:05
 * @Description:
 */
class Card{
    public int rank;
    public String suit;

    @Override
    public String toString() {
        String valueStr = null;
        if(rank == 1){
            valueStr = "A";
        }else if(rank > 10){
            if(rank == 11)
                valueStr = "J";
            if(rank == 12)
                valueStr = "Q";
            if(rank == 13)
                valueStr = "K";
        }else {
            valueStr = String.valueOf(rank);
        }
        return String.format("(%s,%s)",valueStr,suit);
    }
}
public class DeckDemo {
    static final String [] s = {"♥","♣","♦","♠"};
    static List<Card> deck = new ArrayList<>();
    public static void creatCard(){
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                Card card = new Card();
                card.rank = j+1;
                card.suit = s[i];
                deck.add(card);
            }
        }
    }
    public static void swap(List<Card> deck,int i,int j){
        Card card = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,card);
    }
    public static void shuffle(List<Card> deck){
        Random random = new Random();
        for(int i=deck.size()-1;i>0;i--){
            int j = random.nextInt(i);
            swap(deck,i,j);
        }
    }
    public static void main(String[] args) {
        creatCard();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
    }
}
