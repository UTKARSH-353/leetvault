class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq = new LinkedList<>();
        for(int i = deck.length-1; i >= 0; i--){
            if(!dq.isEmpty()){
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(deck[i]);
        }
        int[] result = new int[deck.length];
        int i = 0;
        for(int x : dq){
            result[i++] = x;
        }
        return result;
    }
}