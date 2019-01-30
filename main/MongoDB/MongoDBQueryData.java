
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class MongoDBQueryData implements MongoDAO {

	//查询一条具体的记录
	public Map<String, Integer> queryByID(MongoDatabase db, String table, Object Id) throws Exception {
		MongoCollection<Document> collection = db.getCollection(table);
		//DBObject接口和BasicDBObject对象：表示一个具体的记录，
		//BasicDBObject实现了DBObject，是key-value的数据结构，用起来和HashMap是基本一致的。
		BasicDBObject query = new BasicDBObject("_id",Id);
		FindIterable<Document> iterable = collection.find(query);
		
		Map<String,Integer> jsonStrToMap = null;
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext()){
			Document user = cursor.next();
			String jsonString = user.toJson();
			jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
		}
		System.out.println("检索ID完毕");
		return jsonStrToMap;
	}
	
	//根据文档来查询
	public List<Map<String,Integer>> queryByDoc(MongoDatabase db,String table,BasicDBObject doc){
		MongoCollection<Document> collection =  db.getCollection(table);
		FindIterable<Document> iterable = collection.find(doc);
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext()){
			Document document = cursor.next();
			String jsonString = document.toJson();
			Map<String,Integer> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
			list.add(jsonStrToMap);
		}
		System.out.println("检索doc完毕");
        return list;
	}
	
	//查询全部文档
	public List<Map<String,Integer>> queryAll(MongoDatabase db,String table){
		MongoCollection<Document> collection = db.getCollection(table);
		FindIterable<Document> iterable = collection.find();
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext()){
			Document docs = cursor.next();
			String jsonString = docs.toJson();
			Map<String,Integer> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
			list.add(jsonStrToMap);
		}
		System.out.println("检索全部完毕");
        return list;
	}

	public boolean insert(MongoDatabase db, String table, Document doc) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(MongoDatabase db, String table, BasicDBObject doc) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(MongoDatabase db, String table, BasicDBObject oldDoc, BasicDBObject newDoc) {
		// TODO Auto-generated method stub
		return false;
	}

}
