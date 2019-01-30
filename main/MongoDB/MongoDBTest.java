
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mongodb.client.MongoDatabase;


public class MongoDBTest {
	public static void main(String[] args) {
		try {
			MongoDBQueryData mq = new MongoDBQueryData();
			MongoDBConnection mc = new MongoDBConnection();
			MongoDatabase md = mc.getMongoDataBase(mc.getMongoClient());
			Map<String,Integer> res = mq.queryByID(md,"chip", "5b4da08668baed679b763618");
			Set<Entry<String,Integer>> set = res.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()){
				Entry e = (Entry) it.next();
				String key = (String) e.getKey();
				Integer value = (Integer) e.getValue();
				System.out.println("key :"+key+"-----value :"+value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
