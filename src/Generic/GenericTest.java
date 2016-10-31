package Generic;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericTest {
    public ArrayList <HashMap<String, Object>> mList = new ArrayList<HashMap<String, Object>>();

    public void setupList(ArrayList<HashMap<String, Object>> list) {
    	mList.clear();
    	for(int i = 0;i<list.size();i++){
    		mList.add(list.get(i));
    	}
    }
}
