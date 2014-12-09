import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class concatenation {
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(S == null || L == null){
            return result;
        }
        HashMap<String, Integer> needtofind = new HashMap<String, Integer>();
        for(String l : L){
            if(needtofind.containsKey(l)){
                needtofind.put(l, needtofind.get(l) + 1);
            }
            else{
                needtofind.put(l, 1);
            }
        }
        int step = L[0].length(), count = 0;
        int total_chars = step * L.length;
        for(int i = 0; i < step; ++i){
            HashMap<String, Integer> hasfound = new HashMap<String, Integer>();
            int start = i;
            count = 0;
            for(int j = i; j <= S.length() - step; j += step){
                String cur = S.substring(j, j + step);
                if(needtofind.containsKey(cur)){
                    if(hasfound.containsKey(cur)){
                        if(hasfound.get(cur) >= needtofind.get(cur)){
                            for(int k = start; k + step <= j; k += start){
                                String str = S.substring(k, k + step);
                                if(str.equals(cur)){
                                    start = k + step;
                                    break;
                                }
                                count--;
                                hasfound.put(str, hasfound.get(str) - 1);
                            }
                        }
                        else{
                            hasfound.put(cur, hasfound.get(cur) + 1);
                            count++;
                        }
                    }
                    else{
                        hasfound.put(cur, 1);
                        count++;
                    }
                    if(count == L.length){
                        result.add(start);
                        hasfound.put(S.substring(start, start+step), hasfound.get(S.substring(start, start+step))-1);
                        count--;
                        start += step;
                    }
                }
                else{
                    hasfound.clear();
                    start = j + step;
                    count = 0;
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args){
		concatenation con = new concatenation();
		String[] dict = {"ba","ab","ab"};
		String s = "abaababbaba";
		System.out.println(con.findSubstring(s, dict));
	}
}
