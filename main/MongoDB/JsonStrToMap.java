
import java.util.HashMap;
import java.util.Map;

import com.mongodb.util.JSON;

/**
 *	json字符串转换为map对象
 */
public class JsonStrToMap {
	public static Map<String, Integer> jsonStrToMap(String jsonString) {
        Object parseObj = JSON.parse(jsonString); // 反序列化 把json 转化为对象
        Map<String, Integer> map = (HashMap<String, Integer>) parseObj; // 把对象转化为map
        return map;
    }
}
