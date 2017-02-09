package gson;

import static gson.JsonConstants.JSON_STR_PHOTOS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.mt.ALog;
public class GsonParseTest extends ALog{
	
    public static void main( String args[] ){
        new GsonParseTest();
    }
    
    public GsonParseTest(){
//    	jsonReaderTest2(JSON_STR_PHOTOS);
    	jsonReaderTest2(getJsonInfoFromFile());

    }
    
    /**
     * jsonReaderTest2������JSON_INFO�б����Json��Ϣ
     * @param JSON_INFO������Json��Ϣ���ִ�
     */
    public void jsonReaderTest2(String JSON_INFO)
    {  
    	try {
	        Gson gson = new Gson();  
	        JsonParser parser = new JsonParser();  
	        JsonObject jsonObject = parser.parse(JSON_INFO).getAsJsonObject();  
	        //��data�ڵ��µ�����תΪJsonArray  
	        JsonArray jsonArray = jsonObject.getAsJsonObject("photos").getAsJsonArray("photo"); //getAsJsonObject���ڹ���photo���ϼ��ڵ�
	        for (int i = 0; i < jsonArray.size(); i++) {  
	            //��ȡ��i������Ԫ��  
	            JsonElement el = jsonArray.get(i);  
	            //ӳ��Ϊ��ʵ��  
	            PhotoInfo data = gson.fromJson(el, PhotoInfo.class);
	            data.visitData();
	        }
        } catch (Exception e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
    }  
    
    private class PhotoInfo{
    	public String id;
    	public String owner;
    	public String secret;
    	public String server;
    	public String farm;
    	public String title;
    	public int ispublic;
    	public int isfriend;
    	public int isfamily;
    	private void visitData(){
    		Log("/*********************visitData**********************/");
    		Log("id: "+id);
    		Log("owner: "+owner);
    		Log("secret: "+secret);
    		Log("server: "+server);
    		Log("farm: "+farm);
    		Log("title: "+title);    
    		Log("ispublic: "+ispublic);
    		Log("isfriend: "+isfriend);
    		Log("isfamily"+isfamily);    	    		
    	}
    }
    
    /**
     * getJsonInfoFromFile����Json�ļ��л�ȡJson����
     * @return
     */
    public String getJsonInfoFromFile() {
        BufferedReader br;
        String json = "";
        try {

            br = new BufferedReader(new FileReader("files/Json/photosJsonInfo.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }
            json = sb.toString();

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    
    private void jsonReaderTest() {
        // �����Json�ŵ�string�У����Լ�����ת��
        String jsonData = "[{\"username\":\"name01\",\"userId\":001},{\"username\":\"name02\",\"userId\":002}]";

        JsonReader reader = new JsonReader(new StringReader(jsonData));
        reader.setLenient(true); // �ڿ���ģʽ�½���
        try {
            reader.beginArray(); // ��ʼ�������飨����һ������Json����
            while (reader.hasNext()) { // �������һ�����ݾͼ�������
                reader.beginObject(); // ��ʼ����һ���µĶ���
                while (reader.hasNext()) {
                    String tagName = reader.nextName(); // �õ���һ��������
                    if (tagName.equals("username")) {
                        Log(reader.nextString());
                    } else if (tagName.equals("userId")) {
                    	Log(reader.nextString());
                    }
                }
                reader.endObject(); // ��������Ľ���
            }
            reader.endArray(); // ����������ǰ����
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
    }
    
    public class User {
        //ʡ������
        public String name;
        public int age;
        public String emailAddress;
        public User(String name,int age){
        	this(name,age,"N/A");
        }
        public User(String name,int age,String emailAddress){
        	this.name = name;
        	this.age = age;
        	this.emailAddress = emailAddress;
        }
    }
    
    private void test2(){
    	Gson gson = new Gson();
    	User user = new User("�ֵ�kidou",24,"wwmengtao@163.com");
    	String jsonObject = gson.toJson(user); // {"name":"�ֵ�kidou","age":24,"emailAddress":"wwmengtao@163.com"}
    	ALog.Log("toJson:");
    	ALog.Log(jsonObject);
    	//
    	//String jsonObject2 = "{\"name\":\"�ֵ�kidou\",\"age\":24,\"emailAddress\":\"wwmengtao@163.com\"}";
    	String jsonObject2 = "{\"id\":\"136365\",\"name\":\"�ֵ�kidou\",\"id\":\"136365\",\"age\":24,\"emailAddress\":\"wwmengtao@163.com\"}";
    	User user2 = gson.fromJson(jsonObject2, User.class);
    	ALog.Log("fromJson:");
    	ALog.Log("name: "+user2.name);
    	ALog.Log("age: "+user2.age);
    	ALog.Log("emailAddress: "+user2.emailAddress);

    }
    
    private void test1(){
    	Gson gson = new Gson();
    	//�����л�
    	int i = gson.fromJson("100", int.class);              //100
    	double d = gson.fromJson("\"99.99\"", double.class);  //99.99
    	boolean b = gson.fromJson("true", boolean.class);     // true
    	String str = gson.fromJson("String", String.class);   // String
    	//���л�
    	String jsonNumber = gson.toJson(100);       // 100
    	String jsonBoolean = gson.toJson(false);    // false
    	String jsonString = gson.toJson("String"); //"String"
    }
}
